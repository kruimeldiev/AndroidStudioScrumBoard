package com.casperdaris.digitalscrum.Objecten;

public class Gebruiker {

    private String email, vnaam, anaam, wawo;

    public Gebruiker(String email, String vnaam, String anaam, String wawo){
        this.email = email;
        this.vnaam = vnaam;
        this.anaam = anaam;
        this.wawo = wawo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVnaam() {
        return vnaam;
    }

    public void setVnaam(String vnaam) {
        this.vnaam = vnaam;
    }

    public String getAnaam() {
        return anaam;
    }

    public void setAnaam(String anaam) {
        this.anaam = anaam;
    }

    public String getWawo() {
        return wawo;
    }

    public void setWawo(String wawo) {
        this.wawo = wawo;
    }

}
