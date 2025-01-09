package com.kmkim.rvposting.adapter.listview

import android.view.View
import android.widget.TextView
import com.kmkim.rvposting.BenefitListViewItem
import com.kmkim.rvposting.R

sealed class BenefitScreenViewHolder(val view: View) {
    class BenefitViewHolder(view: View) : BenefitScreenViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.tv_benefit_button_title)
        private val description: TextView = view.findViewById(R.id.tv_benefit_button_description)

        fun bind(benefit: BenefitListViewItem.Benefit) {
            title.text = benefit.title
            description.text = benefit.description
        }
    }

    class AdvertisementViewHolder(view: View) : BenefitScreenViewHolder(view) {
        private val content: TextView = view.findViewById(R.id.tv_advertisement)

        fun bind(advertisement: BenefitListViewItem.Advertisement) {
            content.text = advertisement.content
        }
    }
}
