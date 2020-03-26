package com.casperdaris.digitalscrum.Objecten;

public class Project {

    private int prid;
    private String prnaam, prbes, prown, scrma;

    public Project(int prid, String prnaam, String prbes, String prown, String scrma){
        this.prid = prid;
        this.prnaam = prnaam;
        this.prbes = prbes;
        this.prown = prown;
        this.scrma = scrma;
    }

    public int getPrid() {
        return prid;
    }

    public void setPrid(int prid) {
        this.prid = prid;
    }

    public String getPrnaam() {
        return prnaam;
    }

    public void setPrnaam(String prnaam) {
        this.prnaam = prnaam;
    }

    public String getPrbes() {
        return prbes;
    }

    public void setPrbes(String prbes) {
        this.prbes = prbes;
    }

    public String getPrown() {
        return prown;
    }

    public void setPrown(String prown) {
        this.prown = prown;
    }

    public String getScrma() {
        return scrma;
    }

    public void setScrma(String scrma) {
        this.scrma = scrma;
    }
}
