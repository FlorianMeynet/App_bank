package com.example.bank_app;

public class Compte_bank {

    private int id;
    private String accountName;
    private String iban;
    private float amount;
    private String currency;

    public void Compte_bank(int id_compte,String nom,String iban_compte,float argent,String money){
        this.id=id_compte;
        this.accountName=nom;
        this.iban=iban_compte;
        this.amount=argent;
        this.currency=money;
    }
    public int getId() {
        return id;
    }
    public void setId(int i) {
        this.id=i;
    }


    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String n) {
        this.accountName=n;
    }


    public String getIban() {
        return iban;
    }
    public void setIban(String i) {
        this.iban=i;
    }


    public float getAmount() {
        return amount;
    }
    public void setAmount(float i) {
        this.amount=i;
    }


    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String i) {
        this.currency=i;
    }



}
