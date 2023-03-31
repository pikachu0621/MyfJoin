package com.mayunfeng.join.ui.adapter

import android.view.View
import com.mayunfeng.join.R
import com.mayunfeng.join.bean.GroupBean
import com.mayunfeng.join.bean.StartSignBean
import com.mayunfeng.join.databinding.ItemMyStartSignBinding
import com.pikachu.utils.adapter.QuickAdapter
import com.pikachu.utils.utils.GlideUtils
import com.pikachu.utils.utils.TimeUtils

class MyStartSignInfoAdapter(
    private val clickItem: (itemData: StartSignBean) -> Unit,
    `data`: MutableList<StartSignBean>? = null
) : QuickAdapter<ItemMyStartSignBinding, StartSignBean>(`data`) {


    override fun onQuickBindView(
        binding: ItemMyStartSignBinding,
        itemData: StartSignBean,
        position: Int,
        data: MutableList<StartSignBean>
    ) {
        binding.root.setOnClickListener { clickItem(itemData) }
        binding.time.text =
            TimeUtils.strToStr(itemData.createTime, "yyyy-MM-dd HH:mm:ss", "MM-dd HH:mm")
        binding.title.text = itemData.signTitle
        binding.type.text = if (itemData.signExpire) {
            binding.type.setBackgroundResource(R.drawable.dr_my_start_sign_item_failure)
            context.getString(R.string.start_sign_type_defunct)
        } else {
            binding.type.setBackgroundResource(R.drawable.dr_login_goto_true)
            context.getString(R.string.start_sign_type_progress)
        }
        binding.done.text = "已签到：${itemData.signHaveCompletedPeople}人"
        binding.onDone.text = " / 总人数：${itemData.signAllPeople}人"
        binding.progress.setMax(itemData.signAllPeople.toFloat())
        binding.progress.setProgress(itemData.signHaveCompletedPeople.toFloat())

        binding.groupNul.visibility = View.VISIBLE
        binding.imgGroup.visibility = View.GONE
        binding.img1.visibility = View.GONE
        binding.img2.visibility = View.GONE
        binding.img3.visibility = View.GONE
        binding.img4.visibility = View.GONE
        if (itemData.signGroupInfo != null) {
            binding.groupNul.visibility = View.GONE
            binding.imgGroup.visibility = View.VISIBLE
            GlideUtils.with(context).loadHeaderToken(itemData.signGroupInfo.groupImg)
                .into(binding.imgGroup)
            binding.img1.visibility = View.VISIBLE
            GlideUtils.with(context)
                .loadHeaderToken(itemData.signGroupInfo.groupTopFourPeople[0].userImg)
                .into(binding.img1)
            if (itemData.signGroupInfo.groupTopFourPeople.size >= 2) {
                binding.img2.visibility = View.VISIBLE
                GlideUtils.with(context)
                    .loadHeaderToken(itemData.signGroupInfo.groupTopFourPeople[1].userImg)
                    .into(binding.img2)
            }
            if (itemData.signGroupInfo.groupTopFourPeople.size >= 3) {
                binding.img3.visibility = View.VISIBLE
                GlideUtils.with(context)
                    .loadHeaderToken(itemData.signGroupInfo.groupTopFourPeople[2].userImg)
                    .into(binding.img3)
            }
            if (itemData.signGroupInfo.groupTopFourPeople.size >= 4) {
                binding.img4.visibility = View.VISIBLE
                GlideUtils.with(context)
                    .loadHeaderToken(itemData.signGroupInfo.groupTopFourPeople[3].userImg)
                    .into(binding.img4)
            }
        }
    }
}