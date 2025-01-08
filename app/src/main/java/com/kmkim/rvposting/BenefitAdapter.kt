package com.kmkim.rvposting

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BenefitAdapter(
    private var benefits: List<BenefitListItem>,
) : BaseAdapter() {
    override fun getCount(): Int = benefits.count()

    override fun getItem(position: Int): BenefitListViewItem = benefits[position].viewItem

    override fun getItemId(position: Int): Long = benefits[position].id

    override fun getItemViewType(position: Int): Int = benefits[position].viewItem.viewType

    override fun getViewTypeCount(): Int = NUMBER_OF_VIEW_TYPES

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder = generateViewHolder(position, convertView, parent)
        bindViewHolder(viewHolder, position)

        return viewHolder.view
    }

    private fun generateViewHolder(
        position: Int,
        convertView: View?,
        parent: ViewGroup,
    ): BenefitScreenViewHolder {
        val viewType = getItemViewType(position)
        val viewHolder =
            convertView?.tag as BenefitScreenViewHolder? ?: createViewHolder(viewType, parent)

        return viewHolder
    }

    private fun createViewHolder(
        viewType: Int,
        parent: ViewGroup
    ): BenefitScreenViewHolder {
        val view = generateItemView(viewType, parent)
        val holder: BenefitScreenViewHolder =
            when (viewType) {
                BenefitListViewItem.VIEW_TYPE_BENEFIT -> {
                    BenefitScreenViewHolder.BenefitViewHolder(view)
                }

                BenefitListViewItem.VIEW_TYPE_ADVERTISEMENT -> {
                    BenefitScreenViewHolder.AdvertisementViewHolder(view)
                }

                else -> throw IllegalArgumentException("Unknown view type")
            }

        view.tag = holder
        return holder
    }

    private fun bindViewHolder(viewHolder: BenefitScreenViewHolder, position: Int) {
        val item = getItem(position)
        when (viewHolder) {
            is BenefitScreenViewHolder.BenefitViewHolder -> {
                viewHolder.bind(item as BenefitListViewItem.Benefit)
            }

            is BenefitScreenViewHolder.AdvertisementViewHolder -> {
                viewHolder.bind(item as BenefitListViewItem.Advertisement)
            }
        }
    }

    fun refreshBenefitData(newBenefits: List<BenefitListItem>) {
        benefits = newBenefits
        notifyDataSetChanged()
    }

    private fun generateItemView(viewType: Int, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            BenefitListViewItem.VIEW_TYPE_BENEFIT -> {
                Log.i("BenefitAdapter", "generateItemView: benefit")
                inflater.inflate(
                    R.layout.item_benefit,
                    parent,
                    false
                )
            }

            BenefitListViewItem.VIEW_TYPE_ADVERTISEMENT -> {
                Log.i("BenefitAdapter", "generateItemView: advertisement")
                inflater.inflate(
                    R.layout.item_advertisement,
                    parent,
                    false
                )
            }

            else -> throw RuntimeException("Unknown view type")
        }
    }

    companion object {
        private const val NUMBER_OF_VIEW_TYPES = 2
    }
}

