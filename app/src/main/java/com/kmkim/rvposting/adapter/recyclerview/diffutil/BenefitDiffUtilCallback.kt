package com.kmkim.rvposting.adapter.recyclerview.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.kmkim.rvposting.BenefitListItem

class BenefitDiffUtilCallback : DiffUtil.ItemCallback<BenefitListItem>() {
    override fun areItemsTheSame(oldItem: BenefitListItem, newItem: BenefitListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BenefitListItem, newItem: BenefitListItem): Boolean {
        return oldItem == newItem
    }
}
