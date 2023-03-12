package com.company;

import java.util.Date;

public class InformationOperator {
    private String Login;
    private String Parol;
    private String ism;
    private String familya;
    private Date tugulgan_yili;
    private String lavozimi;
    private String malakasi;
    public static final String ANSI_CYAN = "\u001B[36m";

    public InformationOperator( String login, String parol,String ism, String familya, Date tugulgan_yili, String lavozimi, String malakasi) {
        this.Login = login;
        this.Parol = parol;
        this.ism = ism;
        this.familya = familya;
        this.tugulgan_yili = tugulgan_yili;
        this.lavozimi = lavozimi;
        this.malakasi = malakasi;
    }

    public void setLogin(String Login) {
        this.Login=Login;
    }

    public void setParol(String Parol) {
        this.Parol=Parol;
    }

    public String getLogin() {
        return Login;
    }

    public String getParol() {
        return Parol;
    }
    public String getIsm() {
        return ism;
    }

    public void setIsm(String ism) {
        this.ism = ism;
    }

    public String getFamilya() {
        return familya;
    }

    public void setFamilya(String familya) {
        this.familya = familya;
    }

    public Date getTugulgan_yili() {
        return tugulgan_yili;
    }

    public void setTugulgan_yili(Date tugulgan_yili) {
        this.tugulgan_yili = tugulgan_yili;
    }

    public String getLavozimi() {
        return lavozimi;
    }

    public void setLavozimi(String lavozimi) {
        this.lavozimi = lavozimi;
    }

    public String getMalakasi() {
        return malakasi;
    }

    public void setMalakasi(String malakasi) {
        this.malakasi = malakasi;
    }


    public void show(){
        System.out.println(ANSI_CYAN+"\n---> Ismi: "+this.getIsm()+ANSI_CYAN);
        System.out.println(ANSI_CYAN+"---> Familyasi: "+ this.getFamilya()+ANSI_CYAN);
        System.out.println(ANSI_CYAN+"---> Tug'ulgan yili: "+this.getTugulgan_yili()+ANSI_CYAN);
        System.out.println(ANSI_CYAN+"---> Lavozimi: "+this.getLavozimi()+ANSI_CYAN);
        System.out.println(ANSI_CYAN+"---> Malakasi: "+this.getMalakasi()+ANSI_CYAN);
    }
}