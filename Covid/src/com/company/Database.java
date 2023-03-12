package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Database {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    ArrayList<InformationUser> informationUsers = new ArrayList<>();

    public void getInformationUser() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Covid_19_pbl", "root", "15042002");
            pst = conn.prepareStatement("select * from fuqaro_malumotlari");
            rs = pst.executeQuery();
            while (rs.next()) {
                String seria = rs.getString("passport_seriya");
                String ism = rs.getString("ism");
                String familya = rs.getString("familya");
                String sharifi = rs.getString("sharifi");
                String jinsi = rs.getString("jinsi");
                Date tugulgan_yili = rs.getDate("tugulgan_yili");
                String yashash_manzili = rs.getString("yashash_manzili");

                PreparedStatement pst1=conn.prepareStatement("SELECT COUNT(fuqaro_seriya) AS Soni, vaksina_nomi FROM vaksina_jarayoni WHERE fuqaro_seriya=?");
                pst1.setString(1, seria);
                ResultSet rs2=pst1.executeQuery();
                while (rs2.next()){
                    int test=rs2.getInt("Soni");
                    String vaksina = rs2.getString("vaksina_nomi");
                    informationUsers.add(new InformationUser(seria, ism, familya, sharifi, jinsi, tugulgan_yili, yashash_manzili,test,vaksina));
                }

            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println();
        }
    }

    public ArrayList<InformationUser> getInformationUsers() {
        return informationUsers;
    }

    ArrayList<InformationOperator> informationOperators = new ArrayList<>();

    public void getInformationOperator() throws  ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Covid_19_pbl", "root", "15042002");
            pst = conn.prepareStatement("select * from Xodimlar");
            rs = pst.executeQuery();
            while (rs.next()) {
                String login = rs.getString("login");
                String parol = rs.getString("parol");
                String ism = rs.getString("ism");
                String familya = rs.getString("familya");
                Date tugulgan_yili = rs.getDate("tugulgan_yili");
                String lavozimi = rs.getString("lavozimi");
                String malakasi = rs.getString("malakasi");
                informationOperators.add(new InformationOperator(login, parol, ism, familya, tugulgan_yili, lavozimi, malakasi));
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println();
        }
    }

    public ArrayList<InformationOperator> getInformationOperators() {
        return informationOperators;
    }

    ArrayList<Vaksina> informationvaccines = new ArrayList<>();

    public void vaksinaadd() throws IOException, ClassNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String nomi;
            int soni;
            int qabul_qilish_soni;
            String malumotlari;
            int oraliq_kuni;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Covid_19_pbl", "root", "15042002");

            System.out.print(ANSI_PURPLE+"Vaksina nomini kiriting: "+ANSI_PURPLE);
            nomi = br.readLine();

            System.out.print(ANSI_PURPLE+"Vaksina sonini kiriting: "+ANSI_PURPLE);
            soni = Integer.parseInt(br.readLine());

            System.out.print(ANSI_PURPLE+"Qabul qilish sonini kiriting: "+ANSI_PURPLE);
            qabul_qilish_soni = Integer.parseInt(br.readLine());

            System.out.print(ANSI_PURPLE+"Vaksina malumotlarini kiriting: "+ANSI_PURPLE);
            malumotlari = br.readLine();

            System.out.print(ANSI_PURPLE+"Qabul qilish oralig'ini kiriting: "+ANSI_PURPLE);
            oraliq_kuni = Integer.parseInt(br.readLine());

            pst = conn.prepareStatement("insert into vaksina (nomi,mavjud_soni,qabul_qilish_soni,malumotlari,oraliq_kuni) values(?,?,?,?,?)");
            pst.setString(1, nomi);
            pst.setInt(2, soni);
            pst.setInt(3, qabul_qilish_soni);
            pst.setString(4, malumotlari);
            pst.setInt(5, oraliq_kuni);
            if (pst.executeUpdate()==1) {
                System.out.println(ANSI_BLUE + "Ma'lumotlar qo'shildi" + ANSI_BLUE);
            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println();
        }
    }

    public void vaksinadelete() throws IOException, ClassNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String nomi;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Covid_19_pbl", "root", "15042002");
            System.out.print(ANSI_PURPLE+"O'chirmoqchi bo'lgan vaksinaning nomini kiriting: "+ANSI_PURPLE);
            nomi = br.readLine();
                pst = conn.prepareStatement("delete from vaksina where nomi=?");
                pst.setString(1, nomi);
                if(pst.executeUpdate()==1) {
                    System.out.println(ANSI_BLUE+"Vaksina ma'lumotlari o'chirildi !!!"+ANSI_BLUE);
                }else {
                    System.out.println(ANSI_RED+"Bunday nomli vaksina yo'q"+ANSI_RED);
                }
                conn.close();
        } catch (SQLException e) {
            System.out.println();
        }
    }

    public void vaksinaupdate() throws IOException, ClassNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String nomi;
            int soni;
            int qabul_qilish_soni;
            String malumotlari;
            int oraliq_kuni;
            ResultSet rs1;
            boolean check=false;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Covid_19_pbl", "root", "15042002");
            PreparedStatement pst1 = conn.prepareStatement("select nomi from vaksina");

            System.out.print("O'zgartirmoqchi bo'lgan vaksinaning nomini kiriting: ");
            nomi = br.readLine();

            rs1 = pst1.executeQuery();
            while (rs1.next()) {
                String name=rs1.getString("nomi");
                if (name.equals(nomi)){
                    check = true;
                }
            }
            if (check){
                System.out.print("Vaksina sonini kiriting: ");
                soni = Integer.parseInt(br.readLine());

                System.out.print("Qabul qilish sonini kiriting: ");
                qabul_qilish_soni = Integer.parseInt(br.readLine());

                System.out.print("Vaksina malumotlarini kiriting: ");
                malumotlari = br.readLine();

                System.out.print("Qabul qilish oralig'ini kiriting: ");
                oraliq_kuni = Integer.parseInt(br.readLine());

                pst = conn.prepareStatement("update vaksina  set mavjud_soni=?,qabul_qilish_soni=?,malumotlari=?,oraliq_kuni=? where nomi=?");

                pst.setInt(1, soni);
                pst.setInt(2, qabul_qilish_soni);
                pst.setString(3, malumotlari);
                pst.setInt(4, oraliq_kuni);
                pst.setString(5,nomi);
                if (pst.executeUpdate()==1){
                    System.out.println("Ma'lumotlar yangilandi");
                }

                conn.close();
            }
           else {
                System.out.println(ANSI_RED+"Bunday vaksina mavjud emas !!!");
            }
        } catch (SQLException e) {
            System.out.println();
        }
    }

    public void getInformationvaksina() throws  ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Covid_19_pbl", "root", "15042002");
            pst = conn.prepareStatement("select * from vaksina");
            rs = pst.executeQuery();
            while (rs.next()) {
                String nomi = rs.getString("nomi");
                int mavjud_soni = rs.getInt("mavjud_soni");
                int qabul_qilish_soni = rs.getInt("qabul_qilish_soni");
                String malumotlari = rs.getString("malumotlari");
                int oraliq_kuni = rs.getInt("oraliq_kuni");
                informationvaccines.add(new Vaksina(nomi, mavjud_soni, qabul_qilish_soni, malumotlari, oraliq_kuni));
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println();
        }
    }

    public ArrayList<Vaksina> getInformationvaccines() {
        return informationvaccines;
    }

    ArrayList<Vaksina_jarayoni> Information= new ArrayList<>();

    public void useradd(String parol) throws IOException, ClassNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String passport_seriya;
            String vaksina_nomi;
            LocalDate now = LocalDate.now();
            LocalDate date=now.plusDays(28);

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Covid_19_pbl", "root", "15042002");

            System.out.print(ANSI_PURPLE + "Fuqaro passport seriyasini kiriting: " + ANSI_PURPLE);
            passport_seriya = br.readLine();
            boolean yesseria = false;
            PreparedStatement pst7=conn.prepareStatement("SELECT  passport_seriya FROM fuqaro_malumotlari");
            ResultSet rs7 = pst7.executeQuery();
            while (rs7.next()){
                String mavjudligi=rs7.getString("passport_seriya");
                if (mavjudligi.equals(passport_seriya)){
                    yesseria=true;
                }
            }
            if (yesseria) {
                PreparedStatement pst3 = conn.prepareStatement("SELECT COUNT(fuqaro_seriya) AS Soni FROM vaksina_jarayoni WHERE fuqaro_seriya=?");

                pst3.setString(1, passport_seriya);

                ResultSet rs2 = pst3.executeQuery();

                boolean bool = true;
                int test = 0;
                while (rs2.next()) {
                    test = rs2.getInt("Soni");
                    if (test >= 3) {
                        bool = false;
                        break;
                    }
                }
                if (test != 1 && test != 2) {
                    if (bool) {
                        System.out.print(ANSI_PURPLE + "Vaksina nomini kiriting: " + ANSI_PURPLE);
                        vaksina_nomi = br.readLine();

                        PreparedStatement pst1 = conn.prepareStatement("select nomi,mavjud_soni from vaksina");
                        rs = pst1.executeQuery();
                        int sanash = 0;
                        while (rs.next()) {
                            String check = rs.getString("nomi");
                            int mavjud_soni = rs.getInt("mavjud_soni");
                            if (check.equals(vaksina_nomi)) {
                                pst = conn.prepareStatement("insert into vaksina_jarayoni (fuqaro_seriya,vaksina_nomi,xodim,belgilangan_sana_vaqt,hozirgi_sana_vaqt) values(?,?,?,?,?)");
                                pst.setString(1, passport_seriya);
                                pst.setString(2, vaksina_nomi);
                                pst.setString(3, parol);
                                pst.setDate(4, java.sql.Date.valueOf(date));
                                pst.setDate(5, java.sql.Date.valueOf(now));
                                if (pst.executeUpdate() == 1) {
                                    mavjud_soni = mavjud_soni - 1;
                                    PreparedStatement pst4 = conn.prepareStatement("Update vaksina set mavjud_soni=? WHERE nomi=?");
                                    pst4.setInt(1, mavjud_soni);
                                    pst4.setString(2, vaksina_nomi);
                                    if (pst4.executeUpdate() == 1) {
                                        System.out.println(ANSI_BLUE + "Ma'lumotlar qo'shildi" + ANSI_BLUE);
                                    }
                                } else {
                                    System.out.println(ANSI_RED + "Ma'lumotlar to'g'ri kiritilmadi" + ANSI_RED);
                                }
                            } else {
                                sanash++;
                                PreparedStatement pst2 = conn.prepareStatement("select count(nomi) as soni from vaksina");
                                ResultSet rs1 = pst2.executeQuery();
                                int soni;
                                while (rs1.next()) {
                                    soni = rs1.getInt("soni");
                                    if (sanash >= soni) {
                                        System.out.println(ANSI_RED + "Vaksina nomini to'g'ri kiriting !!!" + ANSI_RED);
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println(ANSI_YELLOW + "Bu passport seriya egasi to'liq emlanib bo'lgan !!!" + ANSI_YELLOW);
                    }
                } else {
                    System.out.println(ANSI_YELLOW + "Bu fuqaro 1-dozani qabul qilgan !!!" + ANSI_YELLOW);
                }
            }else {
                System.out.println(ANSI_YELLOW+"Bu passport seriyasi ma'lumotlar bazasida mavjud emas !!!");
            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println();
        }
    }

    public void yesuseradd(String parol) throws IOException, ClassNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String passport_seriya;
            LocalDate now = LocalDate.now();
            LocalDate date = now.plusDays(28);

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Covid_19_pbl", "root", "15042002");

            System.out.print(ANSI_PURPLE + "Fuqaro passport seriyasini kiriting: " + ANSI_PURPLE);
            passport_seriya = br.readLine();
            boolean yesseria = false;
            PreparedStatement pst8 = conn.prepareStatement("SELECT  passport_seriya FROM fuqaro_malumotlari");
            ResultSet rs8 = pst8.executeQuery();
            while (rs8.next()) {
                String mavjudligi = rs8.getString("passport_seriya");
                if (mavjudligi.equals(passport_seriya)) {
                    yesseria = true;
                }
            }
            if (yesseria) {
                PreparedStatement pst3 = conn.prepareStatement("SELECT COUNT(fuqaro_seriya) AS Soni,vaksina_nomi,belgilangan_sana_vaqt FROM vaksina_jarayoni WHERE fuqaro_seriya=?");

                pst3.setString(1, passport_seriya);

                ResultSet rs2 = pst3.executeQuery();

                boolean bool = true;
                int test = 0;
                String vaksina = null;
                while (rs2.next()) {
                    test = rs2.getInt("Soni");
                    vaksina = rs2.getString("vaksina_nomi");
                    if (test >= 3) {
                        bool = false;
                        break;
                    }
                }
                Date belgilangan_sana_vaqt = null;
                PreparedStatement pst7 = conn.prepareStatement("SELECT belgilangan_sana_vaqt FROM vaksina_jarayoni WHERE fuqaro_seriya=? AND  (SELECT Count(fuqaro_seriya) FROM vaksina_jarayoni WHERE fuqaro_seriya=?)=?");

                pst7.setString(1, passport_seriya);
                pst7.setString(2, passport_seriya);
                pst7.setInt(3, test);
                ResultSet rs7 = pst7.executeQuery();
                while (rs7.next()) {
                    belgilangan_sana_vaqt = rs7.getDate("belgilangan_sana_vaqt");
                }

                if (belgilangan_sana_vaqt != null) {
                    if (bool) {
                        ZoneId defaultZoneId = ZoneId.systemDefault();
                        Date convert = Date.from(now.atStartOfDay(defaultZoneId).toInstant());
                        if (convert.after(belgilangan_sana_vaqt)) {
                            PreparedStatement pst1 = conn.prepareStatement("select mavjud_soni from vaksina");
                            rs = pst1.executeQuery();
                            while (rs.next()) {
                                int mavjud_soni = rs.getInt("mavjud_soni");
                                pst = conn.prepareStatement("insert into vaksina_jarayoni (fuqaro_seriya,vaksina_nomi,xodim,belgilangan_sana_vaqt,hozirgi_sana_vaqt) values(?,?,?,?,?)");
                                pst.setString(1, passport_seriya);
                                pst.setString(2, vaksina);
                                pst.setString(3, parol);
                                pst.setDate(4, java.sql.Date.valueOf(date));
                                pst.setDate(5, java.sql.Date.valueOf(now));
                                if (pst.executeUpdate() == 1) {
                                    mavjud_soni = mavjud_soni - 1;
                                    PreparedStatement pst4 = conn.prepareStatement("update vaksina set mavjud_soni=? WHERE nomi=?");
                                    pst4.setInt(1, mavjud_soni);
                                    pst4.setString(2,vaksina);
                                    if (pst4.executeUpdate() == 1) {
                                        System.out.println(ANSI_BLUE + "Ma'lumotlar qo'shildi" + ANSI_BLUE);
                                        break;
                                    }
                                    break;
                                } else {
                                    System.out.println(ANSI_RED + "Ma'lumotlar to'g'ri kiritilmadi" + ANSI_RED);
                                }
                            }
                        } else {
                            if (test == 2) {
                                System.out.println(ANSI_RED + "3-dozani qabul qilish uchun belgilangan sanagacha ushbu fuqaro vaksina qabul qila olmaydi !!!" + ANSI_RED);
                                System.out.println(ANSI_BLUE + "3-dozani qabul qilish uchun belgilangan sana: " + belgilangan_sana_vaqt + ANSI_BLUE);
                            } else if (test == 1) {
                                System.out.println(ANSI_RED + "2-dozani qabul qilish uchun belgilangan sanagacha ushbu fuqaro vaksina qabul qila olmaydi !!!" + ANSI_RED);
                                System.out.println(ANSI_BLUE + "2-dozani qabul qilish uchun belgilangan sana: " + belgilangan_sana_vaqt + ANSI_BLUE);
                            }
                        }
                    } else {
                        System.out.println(ANSI_BLUE + "Bu passport seriya egasi to'liq emlanib bo'lgan !!!" + ANSI_BLUE);
                    }
                } else {
                    System.out.println(ANSI_RED + "Bu passport egasi 1-dozani qabul qilmagan !!!" + ANSI_RED);
                }
            } else {
                System.out.println(ANSI_YELLOW + "Bu passport seriyasi ma'lumotlar bazasida mavjud emas !!!");
            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println();
        }
    }
    public void getInformation() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Covid_19_pbl", "root", "15042002");
            pst = conn.prepareStatement("select fuqaro_malumotlari.passport_seriya,fuqaro_malumotlari.ism,fuqaro_malumotlari.familya, vaksina_jarayoni.vaksina_nomi,Xodimlar.ism,Xodimlar.familya,vaksina_jarayoni.belgilangan_sana_vaqt,vaksina_jarayoni.hozirgi_sana_vaqt from vaksina_jarayoni inner join fuqaro_malumotlari on vaksina_jarayoni.fuqaro_seriya=fuqaro_malumotlari.passport_seriya inner join Xodimlar on vaksina_jarayoni.xodim=Xodimlar.parol;");
            rs = pst.executeQuery();
            while (rs.next()) {
                String Fuqaro_seria=rs.getString("fuqaro_malumotlari.passport_seriya");
                String Fuqaro_ismi=rs.getString("fuqaro_malumotlari.ism");
                String Fuqaro_familyasi=rs.getString("fuqaro_malumotlari.familya");
                String vaksina_nomi=rs.getString("vaksina_jarayoni.vaksina_nomi");
                String xodim_ismi=rs.getString("Xodimlar.ism");
                String Xodim_familyasi=rs.getString("Xodimlar.familya");
                Date keyingi_doza_sanasi=rs.getDate("belgilangan_sana_vaqt");
                Date qabul_qilgan_sanasi=rs.getDate("vaksina_jarayoni.hozirgi_sana_vaqt");
                Information.add(new Vaksina_jarayoni(Fuqaro_seria,Fuqaro_ismi,Fuqaro_familyasi,vaksina_nomi,xodim_ismi,Xodim_familyasi,keyingi_doza_sanasi,qabul_qilgan_sanasi));
            }
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println();
        }
    }

    public ArrayList<Vaksina_jarayoni> getInformations() {
        return Information;
    }

    ArrayList<Statistika> Statistics=new ArrayList<>();

    public void getStatistic() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Covid_19_pbl", "root", "15042002");
            pst = conn.prepareStatement("SELECT COUNT(passport_seriya) AS SONI FROM fuqaro_malumotlari");
            rs = pst.executeQuery();
            while (rs.next()) {
                int soni = rs.getInt("SONI");
                PreparedStatement pst1 = conn.prepareStatement("SELECT  COUNT(DISTINCT fuqaro_seriya) AS emlanganlar FROM vaksina_jarayoni");
                ResultSet rs1 = pst1.executeQuery();
                while (rs1.next()) {
                    int emlanganlar = rs1.getInt("emlanganlar");
                    Statistics.add(new Statistika(soni, emlanganlar));
                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println();
        }
    }
    public ArrayList<Statistika> getStatistics(){
        return Statistics;
    }
}

