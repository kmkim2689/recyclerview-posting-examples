package com.kmkim.rvposting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BenefitRecyclerViewAdapter(
    private var benefits: List<BenefitListItem>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = when (viewType) {
            BenefitListViewItem.VIEW_TYPE_BENEFIT -> {
                val view = inflater.inflate(R.layout.item_benefit, parent, false)
                BenefitViewHolder(view)
            }

            BenefitListViewItem.VIEW_TYPE_ADVERTISEMENT -> {
                val view = inflater.inflate(R.layout.item_advertisement, parent, false)
                AdvertisementViewHolder(view)
            }

            else -> throw RuntimeException("Unknown view type")
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BenefitViewHolder -> {
                holder.bind(benefits[position].viewItem as BenefitListViewItem.Benefit)
            }

            is AdvertisementViewHolder -> {
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

    class BenefitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.tv_benefit_button_title)
        private val description: TextView = view.findViewById(R.id.tv_benefit_button_description)

        fun bind(benefit: BenefitListViewItem.Benefit) {
            title.text = benefit.title
            description.text = benefit.description
        }
    }

    class AdvertisementViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val content: TextView = view.findViewById(R.id.tv_advertisement)

        fun bind(advertisement: BenefitListViewItem.Advertisement) {
            content.text = advertisement.content
        }
    }
}

