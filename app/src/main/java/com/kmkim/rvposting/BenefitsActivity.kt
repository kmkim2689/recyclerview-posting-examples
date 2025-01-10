package com.kmkim.rvposting

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.kmkim.rvposting.adapter.recyclerview.listadapter.BenefitListAdapter
import com.kmkim.rvposting.adapter.recyclerview.rvadapter.BenefitRecyclerViewAdapter

class BenefitsActivity : AppCompatActivity() {
    private val benefitRepository = BenefitRepository()
    private val adapter = BenefitListAdapter().apply {
        submitBenefitData(benefitRepository.benefits)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_benefits)
        initializeAdapter()
        initializeButtons()
    }

    private fun initializeAdapter() {
        val benefitsList = findViewById<RecyclerView>(R.id.rv_benefits)
        benefitsList.adapter = adapter
    }

    private fun initializeButtons() {
        val buttonAlterTitle = findViewById<Button>(R.id.btn_alter_title)
        val buttonAlterPosition = findViewById<Button>(R.id.btn_alter_position)

        buttonAlterTitle.setOnClickListener {
            alterBenefitTitle(3, "변경 완!!!")
            adapter.submitBenefitData(benefitRepository.benefits)
        }

        buttonAlterPosition.setOnClickListener {
            alterBenefitData(3, 0)
            adapter.submitBenefitData(benefitRepository.benefits)
        }
    }

    private fun alterBenefitTitle(id: Long, newTitle: String) {
        benefitRepository.updateBenefitTitle(
            id = id,
            newTitle = newTitle,
        )
    }

    private fun alterBenefitData(id: Long, newPosition: Int) {
        benefitRepository.updateBenefitPosition(
            id = id,
            newPosition = newPosition,
        )
    }
}
