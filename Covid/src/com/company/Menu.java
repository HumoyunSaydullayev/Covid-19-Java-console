package com.company;
import java.util.ArrayList;
import java.util.Objects;

public class Menu {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private String name;
    private boolean blocked;
    private ArrayList<String> items;
    private String menuType;

    public Menu(String name){
        this.name=name;
        this.blocked=false;
        this.items=new ArrayList<>();
        menuType="main";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean status) {
        this.blocked = status;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void addItem(String item){
        if(!blocked)
            this.items.add(item);
    }
    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public void show(){
        System.out.println(ANSI_BLUE+"\n-------> "+this.name+" <-------"+ANSI_BLUE);
        if (this.items.size() == 0){
            System.out.println("Menu bo'sh");
        }
        else{
            for (int i = 0; i < this.items.size(); i++) {
                System.out.println(ANSI_CYAN+(i+1) +" ---> "+ this.items.get(i)+ANSI_CYAN);
            }
        }
        if (Objects.equals(this.menuType, "main")){
            System.out.println(ANSI_RED+"0 ---> Dasturdan chiqish"+ANSI_RED);
        } else{
            System.out.println(ANSI_RED+"0 ---> Orqaga qaytish"+ANSI_RED);
        }
    }
}