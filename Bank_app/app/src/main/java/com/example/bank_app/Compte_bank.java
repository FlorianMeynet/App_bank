package com.example.bank_app;

public class Compte_bank {

    private String id;
    private String accountName;
    private String iban;
    private String amount;
    private String currency;

    public void Compte_bank(String id_compte,String nom,String iban_compte,String argent,String money){
        this.id=id_compte;
        this.accountName=nom;
        this.iban=iban_compte;
        this.amount=argent;
        this.currency=money;
    }
    public String getId() {
        return id;
    }
    public void setId(String i) {
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


    public String getAmount() {
        return amount;
    }
    public void setAmount(String i) {
        this.amount=i;
    }


    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String i) {
        this.currency=i;
    }



}
