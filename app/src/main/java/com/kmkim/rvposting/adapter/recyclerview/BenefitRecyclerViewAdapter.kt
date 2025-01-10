package com.kmkim.rvposting.adapter.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmkim.rvposting.BenefitListItem
import com.kmkim.rvposting.BenefitListViewItem
import com.kmkim.rvposting.R

class BenefitRecyclerViewAdapter(
    private var benefits: List<BenefitListItem>,
) : RecyclerView.Adapter<BenefitScreenRecyclerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BenefitScreenRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = when (viewType) {
            BenefitListViewItem.VIEW_TYPE_BENEFIT -> {
                val view = inflater.inflate(R.layout.item_benefit, parent, false)
                BenefitScreenRecyclerViewHolder.BenefitViewHolder(view)
            }

            BenefitListViewItem.VIEW_TYPE_ADVERTISEMENT -> {
                val view = inflater.inflate(R.layout.item_advertisement, parent, false)
                BenefitScreenRecyclerViewHolder.AdvertisementViewHolder(view)
            }

            else -> throw RuntimeException("Unknown view type")
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: BenefitScreenRecyclerViewHolder, position: Int) {
        when (holder) {
            is BenefitScreenRecyclerViewHolder.BenefitViewHolder -> {
                holder.bind(benefits[position].viewItem as BenefitListViewItem.Benefit)
            }

            is BenefitScreenRecyclerViewHolder.AdvertisementViewHolder -> {
                holder.bind(benefits[position].viewItem as BenefitListViewItem.Advertisement)
            }
        }
    }

    override fun getItemCount(): Int = benefits.count()

    override fun getItemViewType(position: Int): Int {
        return when (benefits[position].viewItem) {
            is BenefitListViewItem.Benefit -> BenefitListViewItem.VIEW_TYPE_BENEFIT
            is BenefitListViewItem.Advertisement -> BenefitListViewItem.VIEW_TYPE_ADVERTISEMENT
        }
    }

    fun refreshBenefitData(newBenefits: List<BenefitListItem>) {
        benefits = newBenefits
        notifyDataSetChanged()
    }

    fun refreshBenefitItem(position: Int, newBenefits: List<BenefitListItem>) {
        benefits = newBenefits
        notifyItemChanged(position)
    }

    fun changeBenefitItemPosition(
        prevPosition: Int,
        newPosition: Int,
        newBenefits: List<BenefitListItem>,
    ) {
        benefits = newBenefits
        notifyItemMoved(prevPosition, newPosition)
    }
}
