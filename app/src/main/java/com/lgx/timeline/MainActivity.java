package com.lgx.timeline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * author : LGX
 * github :
 * time   : 2019/8/27
 * desc   : 主页
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.act_recycler_view);

        List<TimeLineData> dataList = new ArrayList<>();
        TimeLineData data = new TimeLineData("0", 1, "08-25", "11:26", "您的订单开始处理");
        TimeLineData data1 = new TimeLineData("1", 2, "08-25", "11:46", "包裹正等待揽收");
        TimeLineData data2 = new TimeLineData("2", 3, "08-25", "15:39", "【陕西西安公司】的收件员已收件");
        TimeLineData data3 = new TimeLineData("3", 4, "08-25", "20:17", "快件已到达【陕西西安转运中心】扫描装车");
        TimeLineData data4 = new TimeLineData("3", 5, "08-25", "20:37", "【陕西西安转运中心】正在进行【装车】");
        TimeLineData data5 = new TimeLineData("3", 6, "08-25", "20:45", "由【陕西西安转运中心】发往【河北石家庄转运中心】");
        TimeLineData data6 = new TimeLineData("3", 7, "08-26", "18:36", "快件到达【河北石家庄转运中心】");
        TimeLineData data7 = new TimeLineData("3", 8, "08-26", "18:36", "由【河北石家庄转运中心】发往【河北石家庄名门营业部】");
        TimeLineData data8 = new TimeLineData("3", 8, "08-26", "20:16", "由【河北石家庄转运中心】发往【河北石家庄名门营业部】");

        dataList.add(data8);
        dataList.add(data7);
        dataList.add(data6);
        dataList.add(data5);
        dataList.add(data4);
        dataList.add(data3);
        dataList.add(data2);
        dataList.add(data1);
        dataList.add(data);

        dataList.get(0).setGray(true);
        dataList.get(1).setGrayTwo(true);

        //数据加载
        TimeLineViewAdapter adapter = new TimeLineViewAdapter(R.layout.item_time_line, dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
