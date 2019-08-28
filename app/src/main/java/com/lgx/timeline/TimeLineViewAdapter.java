package com.lgx.timeline;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * author : LGX
 * github :
 * time   : 2019/8/27
 * desc   : 时间轴view数据适配器
 */

public class TimeLineViewAdapter extends BaseQuickAdapter<TimeLineData, BaseViewHolder> {

    public TimeLineViewAdapter(int layoutResId, @Nullable List<TimeLineData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, TimeLineData item) {
        //控制status为零时隐藏下部的竖线
        if ("0".equals(item.getStatus())) {
            helper.setVisible(R.id.item_line_two, false);
        } else {
            helper.setVisible(R.id.item_line_two, true);
        }

        //隐藏头部的竖线
        if (helper.getLayoutPosition() == 0) {
            helper.setVisible(R.id.item_line_one, false);
        } else {
            helper.setVisible(R.id.item_line_one, true);
        }

        helper.setText(R.id.item_tv_date, item.getMonth_day())
                .setText(R.id.item_tv_time, item.getTime());
        //控制文本、图标的示样式
        switch (item.getStatus()) {//可以根据不同节点设置相对应的图标。demo中统一设置了相同样式
            case "0"://订单开始处理
            case "1"://包裹等待揽收
            case "2"://xxx公司已收件
            case "4"://xxx营业部已收入
            case "5"://xxx正在派件
            case "6"://已由xxx代收
            case "7"://已签收
                helper.setGone(R.id.item_img_status, true);
                helper.setGone(R.id.item_img_status_node, false);
                helper.setGone(R.id.item_tv_status_node, false);
                helper.setGone(R.id.item_tv_status, true);

                helper.setText(R.id.item_tv_status, item.getNode_info());
                if (helper.getLayoutPosition() == 0) {
                    helper.setTextColor(R.id.item_tv_status, mContext.getResources().getColor(R.color.c_333333));
                    helper.setImageResource(R.id.item_img_status, R.drawable.shape_circle_blue);
                } else {
                    helper.setTextColor(R.id.item_tv_status, mContext.getResources().getColor(R.color.c_8b8b8b));
                    helper.setImageResource(R.id.item_img_status, R.drawable.shape_circle_gray);
                }
                showGrayLine(helper, item.isGray(), item.isGrayTwo());
                break;
            case "3"://中间小节点状态
                helper.setGone(R.id.item_img_status, false);
                helper.setGone(R.id.item_img_status_node, true);
                helper.setGone(R.id.item_tv_status_node, true);
                helper.setGone(R.id.item_tv_status, false);

                helper.setText(R.id.item_tv_status_node, item.getNode_info());
                if (helper.getLayoutPosition() == 0) {
                    helper.setTextColor(R.id.item_tv_status_node, mContext.getResources().getColor(R.color.c_333333));
                    helper.setImageResource(R.id.item_img_status_node, R.drawable.shape_circle_blue);
                } else {
                    helper.setTextColor(R.id.item_tv_status_node, mContext.getResources().getColor(R.color.c_8b8b8b));
                    helper.setImageResource(R.id.item_img_status_node, R.drawable.shape_circle_gray);
                }
                showGrayLine(helper, item.isGray(), item.isGrayTwo());
                break;
        }
    }


    //显示竖线的颜色
    private void showGrayLine(BaseViewHolder helper, boolean gray, boolean grayTwo) {
        if (gray) {
            helper.setImageResource(R.id.item_line_two, R.color.c_0f90fc);
        } else {
            helper.setImageResource(R.id.item_line_two, R.color.c_8b8b8b);
        }

        if (grayTwo) {
            helper.setImageResource(R.id.item_line_one, R.color.c_0f90fc);
        } else {
            helper.setImageResource(R.id.item_line_one, R.color.c_8b8b8b);
        }


    }

}
