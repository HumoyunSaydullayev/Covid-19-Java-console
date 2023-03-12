package com.company;

import java.io.*;
import java.util.Date;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class InformationUser {
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private String seria;
    private String ism;
    private String familya;
    private String sharifi;
    private String jinsi;
    private Date tugulgan_yili;
    private String yashash_manzili;
    private int emlanish_jarayoni;
    private String vaksina;

    public InformationUser(String seria, String ism, String familya, String sharifi, String jinsi, Date tugulgan_yili, String yashash_manzili,int emlanish_jarayoni,String vaksina) {
        this.seria = seria;
        this.ism = ism;
        this.familya = familya;
        this.sharifi = sharifi;
        this.jinsi = jinsi;
        this.tugulgan_yili = tugulgan_yili;
        this.yashash_manzili = yashash_manzili;
        this.emlanish_jarayoni=emlanish_jarayoni;
        this.vaksina=vaksina;
    }

    public String getVaksina() {
        return vaksina;
    }

    public void setVaksina(String vaksina) {
        this.vaksina = vaksina;
    }

    public int getEmlanish_jarayoni() {
        return emlanish_jarayoni;
    }

    public void setEmlanish_jarayoni(int emlanish_jarayoni) {
        this.emlanish_jarayoni = emlanish_jarayoni;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
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

    public String getSharifi() {
        return sharifi;
    }

    public void setSharifi(String sharifi) {
        this.sharifi = sharifi;
    }

    public String getJinsi() {
        return jinsi;
    }

    public void setJinsi(String jinsi) {
        this.jinsi = jinsi;
    }

    public Date getTugulgan_yili() {
        return tugulgan_yili;
    }

    public void setTugulgan_yili(Date tugulgan_yili) {
        this.tugulgan_yili = tugulgan_yili;
    }

    public String getYashash_manzili() {
        return yashash_manzili;
    }

    public void setYashash_manzili(String yashash_manzili) {
        this.yashash_manzili = yashash_manzili;
    }

    public  void show() throws IOException, DocumentException {
            System.out.println(ANSI_BLUE+"\n\t-------> Vaksinatsiya Ma'lumotlari <-------\n" +ANSI_BLUE);
            System.out.println( ANSI_CYAN+"---> Passport seriyasi: " + this.getSeria()+ANSI_CYAN);
            System.out.println( ANSI_CYAN+"---> Ism: " + this.getIsm()+ANSI_CYAN);
            System.out.println(ANSI_CYAN+"---> Familya: " + this.getFamilya()+ANSI_CYAN);
            System.out.println(ANSI_CYAN+"---> Sharifi: " + this.getSharifi()+ANSI_CYAN);
            System.out.println(ANSI_CYAN+"---> jinsi: " + this.getJinsi()+ANSI_CYAN);
            System.out.println(ANSI_CYAN+"---> Tugulgan yili: " + this.getTugulgan_yili()+ANSI_CYAN);
            System.out.println(ANSI_CYAN+"---> Yashash manzili: " + this.getYashash_manzili()+ANSI_CYAN);
            if (this.getEmlanish_jarayoni()>=3) {
                System.out.println(ANSI_CYAN + "---> Qabul qilgan vaksinangiz nomi: " + this.getVaksina() + ANSI_CYAN);
                System.out.println(ANSI_CYAN + "---> Qabul qilgan vaksina dozasi soni: Siz to'liq emlangansiz !!!" + ANSI_CYAN);
                try {
                String file_nomi = "D:\\Hujjatlar\\2-kurs\\2-kurs 1-smester PBL\\PBL FINAL\\Covid\\src\\Hujjatlar\\" + this.getSeria() + ".pdf";
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(file_nomi));
                document.open();
                Paragraph para = new Paragraph("                                          O'zbekiston Respublikasi sog'liqni saqlash " + "\n                                           vazirligi koronavirus(COVID-19)ga qarshi " + "\n                                                   Emlanganlik to'g'risidagi sertifikat " +
                        "\n\n   Passport seriyasi: " + this.getSeria() + "\n   To'liq ismi: " + this.getIsm() + " " + this.getFamilya() + " " + this.getSharifi() + "\n   Tug'ulgan sanasi: " + this.getTugulgan_yili() + "\n   Jinsi: " + this.getJinsi() + "\n   Qabul qilgan vaksina nomi: " + this.getVaksina() +
                        "\n\n                                          To'liq emlanganligingiz uchun minnatdorchilik bildiramiz !!!");
                document.add(para);
                document.add(new Paragraph(" "));
                document.close();
            }
                catch (Exception e){
                    System.out.println();
                }
            }else if(this.getEmlanish_jarayoni()==0){
                System.out.println(ANSI_CYAN + "---> Siz vaksina qabul qilmagansiz !!!" + ANSI_CYAN);
                File file = new File("D:\\Hujjatlar\\2-kurs\\2-kurs 1-smester PBL\\PBL FINAL\\Covid\\src\\Hujjatlar\\Ogohlantirish.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                while ((st = br.readLine()) != null)
                    System.out.println(ANSI_GREEN+st+ANSI_GREEN);
            }
            else {
                System.out.println(ANSI_CYAN+"---> Qabul qilgan vaksinangiz nomi: "+this.getVaksina()+ANSI_CYAN);
                System.out.println(ANSI_CYAN + "---> Qabul qilgan vaksina dozasi soni: " + this.getEmlanish_jarayoni() + ANSI_CYAN);
                File file = new File("D:\\Hujjatlar\\2-kurs\\2-kurs 1-smester PBL\\PBL FINAL\\Covid\\src\\Hujjatlar\\Maslahat.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                while ((st = br.readLine()) != null)
                    System.out.println(ANSI_GREEN+st+ANSI_GREEN);
            }
    }
    public  void ShowEmlanmagan() {
        if (this.getEmlanish_jarayoni()==0){
            System.out.println(ANSI_CYAN + "---> Passport seriyasi: " + this.getSeria() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> To'liq ism sharifi: " + this.getIsm()+" "+this.getFamilya()+" "+this.getSharifi()+ ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> jinsi: " + this.getJinsi() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> Tugulgan yili: " + this.getTugulgan_yili() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> Yashash manzili: " + this.getYashash_manzili() + ANSI_CYAN);
            System.out.println(ANSI_YELLOW+"\n-----------------------------------------------------------------------------"+ANSI_YELLOW);
        }
    }
    public  void ShowEmlangan() {
        if (this.getEmlanish_jarayoni()==3){
            System.out.println(ANSI_CYAN + "---> Passport seriyasi: " + this.getSeria() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> To'liq ism sharifi: " + this.getIsm()+" "+this.getFamilya()+" "+this.getSharifi()+ ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> jinsi: " + this.getJinsi() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> Tugulgan yili: " + this.getTugulgan_yili() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> Yashash manzili: " + this.getYashash_manzili() + ANSI_CYAN);
            System.out.println(ANSI_YELLOW+"\n-----------------------------------------------------------------------------"+ANSI_YELLOW);
        }
    }
    public  void ShowEmlanayotganlar() {
        if (this.getEmlanish_jarayoni()==1 || this.getEmlanish_jarayoni()==2){
            System.out.println(ANSI_CYAN + "---> Passport seriyasi: " + this.getSeria() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> To'liq ism sharifi: " + this.getIsm()+" "+this.getFamilya()+" "+this.getSharifi()+ ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> jinsi: " + this.getJinsi() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> Tugulgan yili: " + this.getTugulgan_yili() + ANSI_CYAN);
            System.out.println(ANSI_CYAN + "---> Yashash manzili: " + this.getYashash_manzili() + ANSI_CYAN);
            System.out.println(ANSI_YELLOW+"\n-----------------------------------------------------------------------------"+ANSI_YELLOW);
        }
    }
}