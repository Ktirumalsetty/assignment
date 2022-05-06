package com.assignment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.assignment.RecyclerItemDecoration.SectionCallback
import com.assignment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private val mainAdapter:MainAdapter = MainAdapter()
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val recyclerItemDecoration = RecyclerItemDecoration(this, resources.getDimensionPixelSize(R.dimen.header_height), true, getSectionCallback(dataList))
        mainAdapter.setData(viewModel.getMainMockData())
        binding.rvMultiType.apply {
            this.adapter = mainAdapter
//            this.addItemDecoration(recyclerItemDecoration)
        }

    }

    private fun getSectionCallback(list: ArrayList<HashMap<String, String>>): SectionCallback? {
        return object : SectionCallback {
            override fun isSection(pos: Int): Boolean {
                return pos == 0 || list[pos]["Title"] !== list[pos - 1]["Title"]
            }

            override fun getSectionHeaderName(pos: Int): String {
                val dataMap = list[pos]
                return dataMap["Title"]!!
            }
        }
    }

}