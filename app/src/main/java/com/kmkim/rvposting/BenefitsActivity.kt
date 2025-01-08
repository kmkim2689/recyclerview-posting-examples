package com.kmkim.rvposting

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BenefitsActivity : AppCompatActivity() {
    private val benefitRepository = BenefitRepository()
    private val adapter = BenefitRecyclerViewAdapter(benefitRepository.benefits)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_benefits)
        initializeAdapter()
        initializeButtons()
    }

    private fun initializeAdapter() {
        val benefitsList = findViewById<RecyclerView>(R.id.rv_benefits)
        benefitsList.adapter = adapter
        benefitsList.layoutManager = LinearLayoutManager(this)
    }

    private fun initializeButtons() {
        val buttonAlterTitle = findViewById<Button>(R.id.btn_alter_title)
        val buttonAlterPosition = findViewById<Button>(R.id.btn_alter_position)

        buttonAlterTitle.setOnClickListener {
            alterBenefitTitle()
            adapter.refreshBenefitData(benefitRepository.benefits)
        }

        buttonAlterPosition.setOnClickListener {
            alterBenefitData()
            adapter.refreshBenefitData(benefitRepository.benefits)
        }
    }

    private fun alterBenefitTitle() {
        benefitRepository.updateBenefitTitle(
            id = 3,
            newTitle = "변경 완!",
        )
    }

    private fun alterBenefitData() {
        benefitRepository.updateBenefitPosition(
            id = 3,
            newPosition = 0,
        )
    }
}
