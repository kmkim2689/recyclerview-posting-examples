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
        val viewType = getItemViewType(position)
        val view = convertView ?: generateItemView(viewType, parent)

        when (val viewItem = getItem(position)) {
            is BenefitListViewItem.Benefit -> {
                view.findViewById<TextView>(R.id.tv_benefit_button_title).text = viewItem.title
                view.findViewById<TextView>(R.id.tv_benefit_button_description).text =
                    viewItem.description
            }

            is BenefitListViewItem.Advertisement -> {
                view.findViewById<TextView>(R.id.tv_advertisement).text = viewItem.content
            }
        }

        return view
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
