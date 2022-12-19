package com.kh.myapplication;

public class BucketListVo {
    private String goal;
    private int progress_rate;
    private String detail_goal;

    public BucketListVo() {
        super();
    }

    public BucketListVo(String goal, int progress_rate, String detail_goal) {
        this.goal = goal;
        this.progress_rate = progress_rate;
        this.detail_goal = detail_goal;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getProgress_rate() {
        return progress_rate;
    }

    public void setProgress_rate(int progress_rate) {
        this.progress_rate = progress_rate;
    }

    public String getDetail_goal() {
        return detail_goal;
    }

    public void setDetail_goal(String detail_goal) {
        this.detail_goal = detail_goal;
    }

    @Override
    public String toString() {
        return "BucketListVo{" +
                "goal='" + goal + '\'' +
                ", progress_rate=" + progress_rate +
                ", detail_goal='" + detail_goal + '\'' +
                '}';
    }
}
