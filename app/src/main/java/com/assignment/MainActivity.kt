package com.assignment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.assignment.RecyclerItemDecoration.SectionCallback
import com.assignment.databinding.ActivityMainBinding
import com.assignment.model.MainModel


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private val mainAdapter:MainAdapter = MainAdapter()
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList = viewModel.getMainMockData()
        val recyclerItemDecoration = RecyclerItemDecoration(this,
            resources.getDimensionPixelSize(R.dimen.header_height), true, getSectionCallback(dataList))
        mainAdapter.setData(viewModel.getMainMockData())

        binding.rvMultiType.apply {
            this.adapter = mainAdapter
//            this.addItemDecoration(recyclerItemDecoration)
        }

    }

    private fun getSectionCallback(list: List<MainModel>): SectionCallback? {
        return object : SectionCallback {
            override fun isSection(pos: Int): Boolean {
                val mainModel = list[pos]
                val mainModelPrev = list[pos-1]

                var title =""
                var titlePrev =""

                if (mainModel is MainModel.Header){
                    title = (mainModel as MainModel.Header).title
                }
                if (mainModelPrev is MainModel.Header){
                    titlePrev = (mainModelPrev as MainModel.Header).title
                }


//                when(val  mainModel = list[pos]){
//                    is MainModel.Header ->{
//                        return (mainModel as MainModel.Header).title
//                    }
//                }
                return pos == 0 || title !== titlePrev
            }

            override fun getSectionHeaderName(pos: Int): String {
                when(val  mainModel = list[pos]){
                    is MainModel.Header ->{
                        return (mainModel as MainModel.Header).title
                    }
                }
                return ""
//                return dataMap["Title"]!!
            }
        }
    }

}