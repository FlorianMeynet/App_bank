package com.example.bank_app;

public class Client {


    private int id;
    private String name;
    private String  lastname;

    public void CLient(int id_compte, String nom, String prenom){
        this.id=id_compte;
        this.name=nom;
        this.lastname=prenom;
    }


    public int getId() {
        return id;
    }
    public void setId(int i) {
        this.id=i;
    }

    public String getName() {
        return name;
    }
    public void setName(String n) {
        this.name=n;
    }


    public String getLastname() {
        return lastname;
    }
    public void setLastname(String i) {
        this.lastname=i;
    }
}
