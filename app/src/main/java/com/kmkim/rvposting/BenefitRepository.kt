package com.kmkim.rvposting

class BenefitRepository {
    var benefits =
        listOf(
            BenefitListItem(1, BenefitListViewItem.Benefit(1, "버튼 누르기", "10원 받기")),
            BenefitListItem(2, BenefitListViewItem.Benefit(2, "라이브 쇼핑", "포인트 받기")),
            BenefitListItem(3, BenefitListViewItem.Benefit(3, "만보기", "포인트 받기")),
            BenefitListItem(4, BenefitListViewItem.Advertisement(1, "광고 보고 가시죠 1")),
            BenefitListItem(5, BenefitListViewItem.Benefit(4, "친구와 함께 토스 켜고", "포인트 받기")),
            BenefitListItem(6, BenefitListViewItem.Benefit(5, "행운 퀴즈1", "추가 혜택 보기")),
            BenefitListItem(7, BenefitListViewItem.Benefit(6, "행운 퀴즈2", "추가 혜택 보기")),
            BenefitListItem(8, BenefitListViewItem.Advertisement(2, "광고 보고 가시죠 2")),
            BenefitListItem(9, BenefitListViewItem.Benefit(7, "행운 퀴즈3", "추가 혜택 보기")),
            BenefitListItem(10, BenefitListViewItem.Benefit(8, "행운 퀴즈4", "추가 혜택 보기")),
            BenefitListItem(11, BenefitListViewItem.Benefit(9, "행운 퀴즈5", "추가 혜택 보기")),
            BenefitListItem(12, BenefitListViewItem.Advertisement(3, "광고 보고 가시죠 3")),
            BenefitListItem(13, BenefitListViewItem.Benefit(10, "행운 퀴즈6", "추가 혜택 보기")),
            BenefitListItem(14, BenefitListViewItem.Benefit(11, "행운 퀴즈7", "추가 혜택 보기")),
            BenefitListItem(15, BenefitListViewItem.Benefit(12, "행운 퀴즈8", "추가 혜택 보기")),
            BenefitListItem(16, BenefitListViewItem.Advertisement(4, "광고 보고 가시죠 4")),
            BenefitListItem(17, BenefitListViewItem.Benefit(13, "행운 퀴즈9", "추가 혜택 보기")),
            BenefitListItem(18, BenefitListViewItem.Benefit(14, "행운 퀴즈10", "추가 혜택 보기")),
            BenefitListItem(19, BenefitListViewItem.Benefit(15, "행운 퀴즈11", "추가 혜택 보기")),
            BenefitListItem(20, BenefitListViewItem.Advertisement(5, "광고 보고 가시죠 5")),
            BenefitListItem(21, BenefitListViewItem.Benefit(16, "행운 퀴즈12", "추가 혜택 보기")),
            BenefitListItem(22, BenefitListViewItem.Benefit(17, "행운 퀴즈13", "추가 혜택 보기")),
            BenefitListItem(23, BenefitListViewItem.Benefit(18, "행운 퀴즈14", "추가 혜택 보기")),
            BenefitListItem(24, BenefitListViewItem.Advertisement(6, "광고 보고 가시죠 6")),
            BenefitListItem(25, BenefitListViewItem.Benefit(19, "행운 퀴즈15", "추가 혜택 보기")),
            BenefitListItem(26, BenefitListViewItem.Benefit(20, "행운 퀴즈16", "추가 혜택 보기")),
            BenefitListItem(27, BenefitListViewItem.Benefit(21, "행운 퀴즈17", "추가 혜택 보기")),
        ) + (28..2000).map {
            BenefitListItem(
                it.toLong(),
                BenefitListViewItem.Benefit(it.toLong(), "행운 퀴즈$it", "추가 혜택 보기")
            )
        }
        private set

    fun updateBenefitTitle(id: Long, newTitle: String) {
        benefits = benefits.map { benefit ->
            if (benefit.viewItem is BenefitListViewItem.Benefit && benefit.viewItem.id == id) {
                benefit.copy(viewItem = benefit.viewItem.copy(title = newTitle))
            } else {
                benefit
            }
        }
    }

    fun updateBenefitPosition(id: Long, newPosition: Int) {
        val position = newPosition.coerceIn(benefits.indices)
        val targetBenefit = benefits.find { it.id == id } ?: return

        benefits = benefits.filterNot { it.id == id }.let { filteredList ->
            filteredList.take(position) + targetBenefit + filteredList.drop(position)
        }
    }
}
