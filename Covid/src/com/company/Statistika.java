package com.company;

public class Statistika {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private float umumiy_fuqarolar;
    private float emlanganlar;

    public Statistika(float umumiy_fuqarolar, float emlanganlar) {
        this.umumiy_fuqarolar = umumiy_fuqarolar;
        this.emlanganlar = emlanganlar;
    }

    public float getUmumiy_fuqarolar() {
        return umumiy_fuqarolar;
    }

    public void setUmumiy_fuqarolar(int umumiy_fuqarolar) {
        this.umumiy_fuqarolar = umumiy_fuqarolar;
    }

    public float getEmlanganlar() {
        return emlanganlar;
    }

    public void setEmlanganlar(int emlanganlar) {
        this.emlanganlar = emlanganlar;
    }

    public void Show() {
        char simvol='%';
        System.out.println(ANSI_BLUE+"\n-------> Oilaviy poliklinika statistika moduli !!! <-------"+ANSI_BLUE);
        System.out.println(ANSI_CYAN+"---> Ro'yxatdagi umumiy fuqarolar soni: "+(int)this.getUmumiy_fuqarolar()+ANSI_CYAN);
        float peresent=((getUmumiy_fuqarolar()-this.getEmlanganlar())*100/this.getUmumiy_fuqarolar());
        System.out.printf(ANSI_CYAN+"---> Emlanmaganlar soni-foizi: %d-( %.3f %s)\n",(int)(this.getUmumiy_fuqarolar()-this.getEmlanganlar()),peresent,simvol);
        float peresent1=(this.getEmlanganlar()*100/this.getUmumiy_fuqarolar());
        System.out.printf(ANSI_CYAN+"---> Emlanganlar soni-foizi: %d-( %.3f %s)\n",(int)this.getEmlanganlar(),peresent1,simvol);
    }
}