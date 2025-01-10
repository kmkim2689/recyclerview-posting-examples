package com.kmkim.rvposting.adapter.recyclerview.listadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kmkim.rvposting.BenefitListItem
import com.kmkim.rvposting.BenefitListViewItem
import com.kmkim.rvposting.R
import com.kmkim.rvposting.adapter.recyclerview.BenefitScreenRecyclerViewHolder
import com.kmkim.rvposting.adapter.recyclerview.diffutil.BenefitDiffUtilCallback

class BenefitListAdapter
    : ListAdapter<BenefitListItem, BenefitScreenRecyclerViewHolder>(BenefitDiffUtilCallback()) {
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
                holder.bind(currentList[position].viewItem as BenefitListViewItem.Benefit)
            }

            is BenefitScreenRecyclerViewHolder.AdvertisementViewHolder -> {
                holder.bind(currentList[position].viewItem as BenefitListViewItem.Advertisement)
            }
        }
    }

    override fun getItemCount(): Int = currentList.count()

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position].viewItem) {
            is BenefitListViewItem.Benefit -> BenefitListViewItem.VIEW_TYPE_BENEFIT
            is BenefitListViewItem.Advertisement -> BenefitListViewItem.VIEW_TYPE_ADVERTISEMENT
        }
    }

    fun submitBenefitData(benefits: List<BenefitListItem>) {
        submitList(benefits)
    }
}
