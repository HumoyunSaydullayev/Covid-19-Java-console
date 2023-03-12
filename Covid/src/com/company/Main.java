package com.company;

import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
   public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) throws IOException, ClassNotFoundException, DocumentException {
        Database db = new Database();
        db.getInformationOperator();
        ArrayList<InformationUser> informationUsers;
        ArrayList<Vaksina> Informationvaccines;
        ArrayList<Vaksina_jarayoni> Information;
        ArrayList<Statistika> statistic;
        ArrayList<InformationOperator> InformationOperators = db.getInformationOperators();

        int  back, option;
        String Login;
        String Parol;
        Scanner input = new Scanner(System.in);
        Scanner inputseria=new Scanner(System.in);
        System.out.println(ANSI_BLUE+"\nCovid-19 vaccination statistics platform dasturiga xush kelibsiz !!!"+ANSI_BLUE);
            while (true) {
            Menu mainMenu = new Menu("Asosiy menyu");
            mainMenu.addItem("Fuqaro sifatida kirish.");
            mainMenu.addItem("Operator sifatida kirish.");
            mainMenu.setBlocked(true);
            mainMenu.show();
            System.out.print(ANSI_PURPLE+"---> Bo'limni tanlang : "+ANSI_PURPLE);
            option = input.nextInt();
                switch (option) {
                    case 1 -> {
                        main:
                        {
                            db.getInformationUser();
                            informationUsers = db.getInformationUsers();
                            int count = 0;
                            System.out.println(ANSI_BLUE+"\n-------> Dastruga kirish <-------"+ANSI_BLUE);
                            System.out.print(ANSI_PURPLE+"Pasport Seriyasini kiriting: "+ANSI_PURPLE);
                            String seria = inputseria.nextLine();
                            for (InformationUser user : informationUsers) {
                                if (user.getSeria().equals(seria)) {
                                    outer:
                                    {
                                        while (true) {
                                            Menu OperatorMenu = new Menu("Fuqaro moduli !!!");
                                            OperatorMenu.addItem("Vaksinatsiya ma'lumotlari");
                                            OperatorMenu.addItem("Oilaviy poliklinika ma'lumotlari");
                                            OperatorMenu.setMenuType("Usermenu");
                                            OperatorMenu.setBlocked(true);
                                            OperatorMenu.show();
                                            System.out.print(ANSI_PURPLE+"---> Bo'limni tanlang : "+ANSI_PURPLE);
                                            option = input.nextInt();
                                            switch (option) {
                                                case 1:
                                                    if(informationUsers==null){
                                                        for (InformationUser item : informationUsers) {
                                                            if (Objects.equals(item.getSeria(), user.getSeria())) {
                                                                item.show();
                                                            }
                                                        }
                                                        informationUsers.clear();
                                                    }else {
                                                        for (InformationUser item : informationUsers) {
                                                            if (Objects.equals(item.getSeria(), user.getSeria())) {
                                                                item.show();
                                                            }
                                                        }
                                                    }
                                                    while(true){
                                                        System.out.println(ANSI_RED+"\n--> Fuqaro moduliga qaytish uchun 0 ni bosing"+ANSI_RED);
                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                        back = input.nextInt();
                                                        if (back == 0) break;
                                                        else if (back == -1) break main;
                                                    }
                                                    break;
                                                case 2:
                                                inter:
                                                    {
                                                        while (true) {
                                                            Menu OPMenu = new Menu(" Oilaviy poliklinika moduli ");
                                                            OPMenu.addItem("Vaksinalar haqida ma'lumotlar");
                                                            OPMenu.addItem("Xodimlar haqida ma'lumotlar");
                                                            OPMenu.setMenuType("OPmenu");
                                                            OPMenu.setBlocked(true);
                                                            OPMenu.show();
                                                            System.out.print(ANSI_PURPLE+"---> Bo'limni tanlang : "+ANSI_PURPLE);
                                                            option = input.nextInt();
                                                            switch (option) {
                                                                case 1:
                                                                    System.out.println(ANSI_BLUE+"\n\t-------> Vaksina haqida ma'lumotlar <-------"+ANSI_BLUE);
                                                                    db.getInformationvaksina();
                                                                    Informationvaccines = db.getInformationvaccines();
                                                                    for (Vaksina vaksina : Informationvaccines) {
                                                                        vaksina.show();
                                                                    }
                                                                    Informationvaccines.clear();
                                                                    while (true){
                                                                        System.out.println(ANSI_YELLOW+"\n--------------------------------------------------------------------------"+ANSI_YELLOW);
                                                                        System.out.println(ANSI_RED+"\n--> Oilaviy poliklinika moduliga qaytish uchun 0 ni bosing"+ANSI_RED);
                                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                                        back = input.nextInt();
                                                                        if (back == 0) break;
                                                                        else if (back == -1) break main;
                                                                    }
                                                                    break;
                                                                case 2:
                                                                    System.out.println(ANSI_BLUE+"\n\t-------> Xodimlar haqida  ma'lumotlar <-------"+ANSI_BLUE);
                                                                    for (InformationOperator operator : InformationOperators) {
                                                                        operator.show();
                                                                    }
                                                                    while(true) {
                                                                        System.out.println(ANSI_YELLOW+"\n--------------------------------------------------------------------------"+ANSI_YELLOW);
                                                                        System.out.println(ANSI_RED+"\n--> Oilaviy poliklinika moduliga qaytish uchun 0 ni bosing"+ANSI_RED);
                                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                                        back = input.nextInt();
                                                                        if (back == 0) break;
                                                                        else if (back == -1) break main;
                                                                    }
                                                                    break;
                                                                case 0:
                                                                    break inter;
                                                                default:
                                                                    System.out.println(ANSI_YELLOW+"\nIltimos[1 yoki 2]ni tanlang !!!"+ANSI_YELLOW);
                                                                    break;
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 0:
                                                    break outer;
                                                default:
                                                    System.out.println(ANSI_YELLOW+"\nIltimos[1 yoki 2]ni tanlang !!!"+ANSI_YELLOW);
                                                    break;
                                            }
                                        }
                                    }
                                } else {
                                    count++;
                                    if (count >= informationUsers.size())
                                        System.out.println(ANSI_YELLOW+"\nPasport seriyasini nato'g'ri kiritdingiz !!!"+ANSI_YELLOW);
                                }
                            }
                            informationUsers.clear();
                        }
                    }
                    case 2 -> {
                        int sanash = 0;
                        System.out.println(ANSI_BLUE+"\n-------> Dastruga kirish <-------"+ANSI_BLUE);
                        System.out.print(ANSI_PURPLE+"---> Loginingizni kiriting: "+ANSI_PURPLE);
                        Login = inputseria.nextLine();
                        for (InformationOperator operator : InformationOperators) {
                            if (operator.getLogin().equals(Login)) {
                                System.out.print(ANSI_PURPLE+"---> Parolingizni kiriting: "+ANSI_PURPLE);
                                Parol = inputseria.nextLine();
                                if (operator.getParol().equals(Parol)) {
                                    inter:
                                    {
                                        while (true) {
                                            Menu OperatorMenu = new Menu("Operator moduli !!!");
                                            OperatorMenu.addItem("Vaksina  ma'lumotlarini boshqarish.");
                                            OperatorMenu.addItem("Emlanish jarayonini boshqarish.");
                                            OperatorMenu.addItem("Statistika ma'lumotlarini ko'rish");
                                            OperatorMenu.setMenuType("OPmenu");
                                            OperatorMenu.setBlocked(true);
                                            OperatorMenu.show();
                                            System.out.print(ANSI_PURPLE+"---> Bo'limni tanlang : "+ANSI_PURPLE);
                                            option = input.nextInt();
                                            switch (option) {
                                                case 1:
                                                    outer:
                                                    {
                                                        while (true) {
                                                            Menu vaksinamenu = new Menu("Vaksina  ma'lumotlarini boshqarish moduli");
                                                            vaksinamenu.addItem("Yangi vaksina qo'shish.");
                                                            vaksinamenu.addItem("Vaksinani o'chirish.");
                                                            vaksinamenu.addItem("Vaksina  ma'lumotlarini yangilash.");
                                                            vaksinamenu.addItem("Vaksina  ma'lumotlarini ko'rish.");
                                                            vaksinamenu.setMenuType("OPmenu");
                                                            vaksinamenu.setBlocked(true);
                                                            vaksinamenu.show();
                                                            System.out.print(ANSI_PURPLE+"---> Bo'limni tanlang : "+ANSI_PURPLE);
                                                            option = input.nextInt();
                                                            switch (option) {
                                                                case 1:
                                                                    System.out.println(ANSI_BLUE+"\n\t-------> Yangi vaksina qo'shish moduli <-------"+ANSI_BLUE);
                                                                    db.vaksinaadd();
                                                                    while (true){
                                                                        System.out.println(ANSI_YELLOW+"\n--------------------------------------------------------------------------"+ANSI_YELLOW);
                                                                        System.out.println(ANSI_RED+"\n--> Vaksina  ma'lumotlarini boshqarish moduli qaytish uchun 0 ni bosing.");
                                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                                        back = input.nextInt();
                                                                        if (back == 0) break;
                                                                        else if (back == -1) break inter;
                                                                    }
                                                                    break;
                                                                case 2:
                                                                    System.out.println(ANSI_BLUE+"\n\t-------> Vaksinani o'chirish moduli <-------"+ANSI_BLUE);
                                                                    db.vaksinadelete();
                                                                    while(true) {
                                                                        System.out.println(ANSI_YELLOW+"\n--------------------------------------------------------------------------"+ANSI_YELLOW);
                                                                        System.out.println(ANSI_RED+"\n--> Vaksina  ma'lumotlarini boshqarish moduliga qaytish uchun 0 ni bosing."+ANSI_RED);
                                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                                        back = input.nextInt();
                                                                        if (back == 0) break;
                                                                        else if (back == -1) break inter;
                                                                    }
                                                                    break;
                                                                case 3:
                                                                    System.out.println(ANSI_BLUE+"\n\t-------> Vaksina ma'lumotlarini yangilash moduli <-------"+ANSI_BLUE);
                                                                    db.vaksinaupdate();
                                                                    while (true){
                                                                        System.out.println(ANSI_YELLOW+"\n--------------------------------------------------------------------------"+ANSI_YELLOW);
                                                                        System.out.println(ANSI_RED+"\n--> Vaksina  ma'lumotlarini boshqarish moduliga qaytish uchun 0 ni bosing."+ANSI_RED);
                                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                                        back = input.nextInt();
                                                                        if (back == 0) break;
                                                                        else if (back == -1) break inter;
                                                                    }
                                                                    break;
                                                                case 4:
                                                                    System.out.println(ANSI_BLUE+"\n\t-------> Vaksina ma'lumotlarini ko'rish moduli <-------"+ANSI_BLUE);
                                                                    db.getInformationvaksina();
                                                                    Informationvaccines = db.getInformationvaccines();
                                                                    for (Vaksina vaksina : Informationvaccines) {
                                                                        vaksina.show();
                                                                    }
                                                                    Informationvaccines.clear();
                                                                    while (true){
                                                                        System.out.println(ANSI_YELLOW+"\n--------------------------------------------------------------------------"+ANSI_YELLOW);
                                                                        System.out.println(ANSI_RED+"\n--> Vaksina  ma'lumotlarini boshqarish moduliga qaytish uchun 0 ni bosing."+ANSI_RED);
                                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                                        back = input.nextInt();
                                                                        if (back == 0) break;
                                                                        else if (back == -1) break inter;
                                                                    }
                                                                    break;
                                                                case 0:
                                                                    break outer;
                                                                default:
                                                                    System.out.println(ANSI_YELLOW+"\nIltimos[1-4]ni tanlang !!!"+ANSI_YELLOW);
                                                                    break;
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    outer:
                                                    {
                                                        while (true) {
                                                            Menu usermenu = new Menu("Emlanish jarayonini boshqarish moduli");
                                                            usermenu.addItem("Yangi jarayonni qo'shish.");
                                                            usermenu.addItem("Mavjud jarayonni qo'shish.");
                                                            usermenu.addItem("Jarayon ma'lumotlarini ko'rish.");
                                                            usermenu.setMenuType("usermenu");
                                                            usermenu.setBlocked(true);
                                                            usermenu.show();
                                                            System.out.print(ANSI_PURPLE+"---> Bo'limni tanlang : "+ANSI_PURPLE);
                                                            option = input.nextInt();
                                                            switch (option) {
                                                                case 1:
                                                                    System.out.println(ANSI_BLUE+"\n\t-------> Yangi jarayonni qo'shish moduli <-------"+ANSI_BLUE);
                                                                    db.useradd(Parol);
                                                                    while (true){
                                                                        System.out.println(ANSI_YELLOW+"\n--------------------------------------------------------------------------"+ANSI_YELLOW);
                                                                        System.out.println(ANSI_RED+"\n--> Emlanish jarayonini boshqarish moduliga qaytish uchun 0 ni bosing."+ANSI_RED);
                                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                                        back = input.nextInt();
                                                                        if (back == 0) break;
                                                                        else if (back == -1) break inter;
                                                                    }
                                                                    break;
                                                                case 2:
                                                                    System.out.println(ANSI_BLUE+"\n\t-------> Mavjud jarayonni qo'shish moduli <-------"+ANSI_BLUE);
                                                                    db.yesuseradd(Parol);
                                                                    while (true){
                                                                        System.out.println(ANSI_YELLOW+"\n--------------------------------------------------------------------------"+ANSI_YELLOW);
                                                                        System.out.println(ANSI_RED+"\n--> Emlanish jarayonini boshqarish moduliga qaytish uchun 0 ni bosing."+ANSI_RED);
                                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                                        back = input.nextInt();
                                                                        if (back == 0) break;
                                                                        else if (back == -1) break inter;
                                                                    }
                                                                    break;
                                                                case 3:
                                                                    System.out.println(ANSI_BLUE+"\n\t-------> Jarayon ma'lumotlarini ko'rish <-------"+ANSI_BLUE);
                                                                    db.getInformation();
                                                                    Information = db.getInformations();
                                                                    for (Vaksina_jarayoni about : Information) {
                                                                        about.Show();
                                                                    }
                                                                    Information.clear();
                                                                    while(true) {
                                                                        System.out.println(ANSI_RED+"\n--> Emlanish jarayonini boshqarish moduliga qaytish uchun 0 ni bosing."+ANSI_RED);
                                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                                        back = input.nextInt();
                                                                        if (back == 0) break;
                                                                        else if (back == -1) break inter;
                                                                    }
                                                                    break;
                                                                case 0:
                                                                    break outer;
                                                                default:
                                                                    System.out.println(ANSI_YELLOW+"\nIltimos[1-4]ni tanlang !!!"+ANSI_YELLOW);
                                                                    break;
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    outer:
                                                    {
                                                        while (true){
                                                            db.getStatistic();
                                                            statistic =db.getStatistics();
                                                            for(Statistika item: statistic){
                                                                item.Show();
                                                            }
                                                            statistic.clear();
                                                            Menu statisticmenu = new Menu("Statistika moduli !!!");
                                                            statisticmenu.addItem("Emlanmagan fuqarolar ro'yxati");
                                                            statisticmenu.addItem("Emlanayotgan fuqarolar ro'yxati");
                                                            statisticmenu.addItem("Emlangan fuqarolar ro'yxati");
                                                            statisticmenu.setMenuType("statisticmenu");
                                                            statisticmenu.setBlocked(true);
                                                            statisticmenu.show();
                                                            System.out.print(ANSI_PURPLE+"---> Bo'limni tanlang : "+ANSI_PURPLE);
                                                            option = input.nextInt();
                                                            switch (option) {
                                                                case 1:
                                                                    System.out.println(ANSI_BLUE+"\n\t-------> Emlanmagan fuqarolar ro'yxati <-------"+ANSI_BLUE);
                                                                    db.getInformationUser();
                                                                    informationUsers = db.getInformationUsers();
                                                                    for (InformationUser item : informationUsers) {
                                                                            item.ShowEmlanmagan();
                                                                        }
                                                                    informationUsers.clear();
                                                                    while (true){
                                                                        System.out.println(ANSI_RED+"\n--> Statistika moduliga qaytish uchun 0 ni bosing."+ANSI_RED);
                                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                                        back = input.nextInt();
                                                                        if (back == 0) break;
                                                                        else if (back == -1) break inter;
                                                                    }
                                                                    break;
                                                                case 2:
                                                                    System.out.println(ANSI_BLUE+"\n\t-------> Emlanayotganlar fuqarolar ro'yxati <-------"+ANSI_BLUE);
                                                                    db.getInformationUser();
                                                                    informationUsers = db.getInformationUsers();
                                                                    for (InformationUser item : informationUsers) {
                                                                        item.ShowEmlanayotganlar();
                                                                    }
                                                                    informationUsers.clear();
                                                                    while (true){
                                                                        System.out.println(ANSI_RED+"\n--> Statistika moduliga qaytish uchun 0 ni bosing."+ANSI_RED);
                                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                                        back = input.nextInt();
                                                                        if (back == 0) break;
                                                                        else if (back == -1) break inter;
                                                                    }
                                                                    break;
                                                                case 3:
                                                                    System.out.println(ANSI_BLUE+"\n\t-------> Emlangan fuqarolar ro'yxati <-------"+ANSI_BLUE);
                                                                    db.getInformationUser();
                                                                    informationUsers = db.getInformationUsers();
                                                                    for (InformationUser item : informationUsers) {
                                                                        item.ShowEmlangan();
                                                                    }
                                                                    informationUsers.clear();
                                                                    while (true){
                                                                        System.out.println(ANSI_RED+"\n--> Statistika moduliga qaytish uchun 0 ni bosing."+ANSI_RED);
                                                                        System.out.println(ANSI_RED+"--> Asosiy menyuga qaytish uchun -1 ni bosing."+ANSI_RED);
                                                                        System.out.print(ANSI_PURPLE+"---> Qayerga qaytmoqchisiz: "+ANSI_PURPLE);
                                                                        back = input.nextInt();
                                                                        if (back == 0) break;
                                                                        else if (back == -1) break inter;
                                                                    }
                                                                    break;
                                                                case 0:
                                                                    break outer;
                                                                default:
                                                                    System.out.println(ANSI_YELLOW+"\nIltimos[1-2]ni tanlang !!!"+ANSI_YELLOW);
                                                                    break;
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 0:
                                                    break inter;
                                                default:
                                                    System.out.println(ANSI_YELLOW+"\nIltimos[1 yoki 2]ni tanlang !!!"+ANSI_YELLOW);
                                                    break;
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println(ANSI_YELLOW+"\nParolni nato'g'ri kiritdingiz !!!"+ANSI_YELLOW);
                                }
                            } else {
                                sanash++;
                                if (sanash >= InformationOperators.size()) {
                                    System.out.println(ANSI_YELLOW+"\nLoginni nato'g'ri kiritdingiz !!!"+ANSI_YELLOW);
                                }
                            }
                        }
                    }
                    case 0 -> {
                        System.out.println(ANSI_RED+"\n-------> Dasturdan foydalanganiz uchun rahmat !!! <-------"+ANSI_RED);
                        System.out.println(ANSI_RED+"------->          Dastur tugatildi !!!            <-------"+ANSI_RED);
                        System.exit(0);
                    }
                    default -> System.out.println(ANSI_YELLOW+"\n Iltimos[1 yoki 2]ni tanlang !!!"+ANSI_YELLOW);
                }
        }
    }
}