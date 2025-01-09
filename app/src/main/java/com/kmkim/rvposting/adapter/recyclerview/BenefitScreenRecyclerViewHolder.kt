package com.kmkim.rvposting.adapter.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kmkim.rvposting.BenefitListViewItem
import com.kmkim.rvposting.R

sealed class BenefitScreenRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    class BenefitViewHolder(view: View) : BenefitScreenRecyclerViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.tv_benefit_button_title)
        private val description: TextView = view.findViewById(R.id.tv_benefit_button_description)

        fun bind(benefit: BenefitListViewItem.Benefit) {
            title.text = benefit.title
            description.text = benefit.description
        }
    }

    class AdvertisementViewHolder(view: View) : BenefitScreenRecyclerViewHolder(view) {
        private val content: TextView = view.findViewById(R.id.tv_advertisement)

        fun bind(advertisement: BenefitListViewItem.Advertisement) {
            content.text = advertisement.content
        }
    }
}
