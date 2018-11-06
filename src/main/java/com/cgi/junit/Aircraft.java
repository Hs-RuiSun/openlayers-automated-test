package com.cgi.junit;

public class Aircraft {
    private int id;
    private String ori;
    private String dst;
    private boolean tracked;
    
    public Aircraft() {}
    
    public Aircraft(int id, String ori, String dst, boolean tracked) {
        this.id = id;
        this.ori = ori;
        this.dst = dst;
        this.tracked = tracked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOri() {
        return ori;
    }

    public void setOri(String ori) {
        this.ori = ori;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public boolean isTracked() {
        return tracked;
    }

    public void setTracked(boolean tracked) {
        this.tracked = tracked;
    }
    
}
