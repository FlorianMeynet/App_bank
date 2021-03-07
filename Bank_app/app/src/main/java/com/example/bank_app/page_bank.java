package com.example.bank_app;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class page_bank extends AppCompatActivity {
    ProgressDialog progressDoalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_bank);
    }
    @Override
    public void onStart(){
        super.onStart();
        Spinner spinner = (Spinner) findViewById(R.id.spinner_compte);
        List list_spinner = new ArrayList();
        List<Compte_bank> list_compte = null;
        //On va chercher les infos sur les comptes bancaires de la personnes
        GetDataServiceMoney service = RetrofitClientInstance.getRetrofitInstance().create(GetDataServiceMoney.class);
        Call<List<Compte_bank>> call_2 = service.getAllMoney();
        call_2.enqueue(new Callback<List<Compte_bank>>() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Compte_bank>> call_2, Response<List<Compte_bank>> response) {
                if (response.isSuccessful()) {

                    int i = 0;
                    Compte_bank compte_personne = new Compte_bank();


                    for (Compte_bank b : response.body()) {
                        list_spinner.add(b.getAccountName());
                        list_compte.add(b);
                        System.out.println("Compte bancaire n°" + b.getId()+"   Iban :"+b.getIban()+"   Nom  : "+b.getAccountName()+"     Argent :"+b.getAmount());
                    }
                    ArrayAdapter<String> adapter;
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, list_spinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);

                }
            }
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

                Compte_bank compte_select= list_compte.get(position);
                TextView id_p = (TextView) findViewById(R.id.id_print);
                TextView iban_p = (TextView) findViewById(R.id.iban_text);
                TextView amount_p = (TextView) findViewById(R.id.amount_print);
                id_p.setText(compte_select.getId());
                iban_p.setText(compte_select.getIban());
                amount_p.setText((int) compte_select.getAmount());
            }
            @Override
            public void onFailure(Call<List<Compte_bank>> call, Throwable t) {

            }


        });
    }


}