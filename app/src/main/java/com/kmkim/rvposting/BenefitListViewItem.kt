package com.kmkim.rvposting

sealed class BenefitListViewItem(
    val viewType: Int
) {
    data class Benefit(
        val id: Long,
        val title: String,
        val description: String,
    ) : BenefitListViewItem(VIEW_TYPE_BENEFIT)

    data class Advertisement(
        val id: Long,
        val content: String,
    ) : BenefitListViewItem(VIEW_TYPE_ADVERTISEMENT)

    companion object {
        const val VIEW_TYPE_BENEFIT = 0
        const val VIEW_TYPE_ADVERTISEMENT = 1
    }
}
