package com.company;

public class Vaksina {
    public static final String ANSI_CYAN = "\u001B[36m";
    private String nomi;
    private int mavjud_soni;
    private int qabul_qilish_soni;
    private String malumotlari;
    private int oraliq_kuni;

    public Vaksina(String nomi, int mavjud_soni, int qabul_qilish_soni, String malumotlari, int oraliq_kuni) {
        this.nomi = nomi;
        this.mavjud_soni = mavjud_soni;
        this.qabul_qilish_soni = qabul_qilish_soni;
        this.malumotlari = malumotlari;
        this.oraliq_kuni = oraliq_kuni;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    public int getMavjud_soni() {
        return mavjud_soni;
    }

    public void setMavjud_soni(int mavjud_soni) {
        this.mavjud_soni = mavjud_soni;
    }

    public int getQabul_qilish_soni() {
        return qabul_qilish_soni;
    }

    public void setQabul_qilish_soni(int qabul_qilish_soni) {
        this.qabul_qilish_soni = qabul_qilish_soni;
    }

    public String getMalumotlari() {
        return malumotlari;
    }

    public void setMalumotlari(String malumotlari) {
        this.malumotlari = malumotlari;
    }

    public int getOraliq_kuni() {
        return oraliq_kuni;
    }

    public void setOraliq_kuni(int oraliq_kuni) {
        this.oraliq_kuni = oraliq_kuni;
    }
    public void show(){
            System.out.println(ANSI_CYAN + "\n---> Vaksina nomi: " + this.getNomi() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> Mavjud soni: " + this.getMavjud_soni() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> Qabul qilish soni: " + this.getQabul_qilish_soni() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> Vaksina ma'lumotlari: " + this.getMalumotlari() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> Oraliq kuni: " + this.getOraliq_kuni() + ANSI_CYAN);
    }
}