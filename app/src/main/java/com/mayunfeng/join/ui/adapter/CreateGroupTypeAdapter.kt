package com.mayunfeng.join.ui.adapter

import android.annotation.SuppressLint
import com.mayunfeng.join.R
import com.mayunfeng.join.databinding.ItemCreateGroupTypeBinding
import com.mayunfeng.join.databinding.ItemTestBinding
import com.pikachu.utils.adapter.QuickAdapter

/**
 *
 * @ProjectName:    考勤记录管理系统
 * @Package:        com.mayunfeng.join.ui.adapter
 * @Author:         pkpk.run
 * @Description:    null
 */
class CreateGroupTypeAdapter(
    `data`: MutableList<String> = MutableList(20) { "20" },
    private val click: (typeStr: String) -> Unit ) :
    QuickAdapter<ItemCreateGroupTypeBinding, String>(`data`) {

    private var cok = `data`[0]
    private var cokPos = 0

    fun getType(): String = cok

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onQuickBindView(
        binding: ItemCreateGroupTypeBinding,
        itemData: String,
        position: Int,
        `data`: MutableList<String>
    ) {

        if (itemData == cok){
            binding.title.setBackgroundResource(R.drawable.dr_create_group_type_true_bg)
            binding.title.setTextColor(context.resources.getColor(R.color.color_bg))
        } else {
            binding.title.setBackgroundResource(R.drawable.dr_create_group_type_false_bg)
            binding.title.setTextColor(context.resources.getColor(R.color.color_grey1))
        }
        binding.title.text = itemData
        binding.root.setOnClickListener {
            click(itemData)
            cok = itemData
            notifyItemChanged(position)
            notifyItemChanged(cokPos)
            cokPos = position
        }
    }
}