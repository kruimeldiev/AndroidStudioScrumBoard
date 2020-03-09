package com.casperdaris.digitalscrum.Objecten;

public class BacklogItem {

    private int prid, prio;
    private String itnm, itbes, stat, dev;

    public BacklogItem(int prid, int prio, String itnm, String itbes, String stat, String dev) {
        this.prid = prid;
        this.prio = prio;
        this.itnm = itnm;
        this.itbes = itbes;
        this.stat = stat;
        this.dev = dev;
    }

    public int getPrid() {
        return prid;
    }

    public void setPrid(int prid) {
        this.prid = prid;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }

    public String getItnm() {
        return itnm;
    }

    public void setItnm(String itnm) {
        this.itnm = itnm;
    }

    public String getItbes() {
        return itbes;
    }

    public void setItbes(String itbes) {
        this.itbes = itbes;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }
}
