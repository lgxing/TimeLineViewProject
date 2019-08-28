package com.lgx.timeline;


/**
 * author : LGX
 * github :
 * time   : 2019/8/27
 * desc   : 时间轴view数据模型
 */

public class TimeLineData {

    private String status; //流程节点
    private int nodeNumber;//流程序号
    private String month_day; //日期
    private String time; //上下午
    private String node_info;//节点信息
    private boolean isGray = false;// 当流程没走完时，控制上竖线变灰色；
    private boolean isGrayTwo = false;// 当流程没走完时，控制下竖线变灰色；

    public TimeLineData(String status, int nodeNumber, String month_day, String time, String node_info) {
        this.status = status;
        this.nodeNumber = nodeNumber;
        this.month_day = month_day;
        this.time = time;
        this.node_info = node_info;

    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public void setMonth_day(String month_day) {
        this.month_day = month_day;
    }

    public String getMonth_day() {
        return month_day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setNode_info(String node_info) {
        this.node_info = node_info;
    }

    public String getNode_info() {
        return node_info;
    }


    public boolean isGray() {
        return isGray;
    }

    public void setGray(boolean gray) {
        isGray = gray;
    }

    public boolean isGrayTwo() {
        return isGrayTwo;
    }

    public void setGrayTwo(boolean grayTwo) {
        isGrayTwo = grayTwo;
    }

}
