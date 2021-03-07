package com.example.bank_app;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class page_bank extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ProgressDialog progressDoalog;
    private Object AdapterView;
    public List<Compte_bank> list_compte = new List<Compte_bank>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<Compte_bank> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] a) {
            return null;
        }

        @Override
        public boolean add(Compte_bank compte_bank) {
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends Compte_bank> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, @NonNull Collection<? extends Compte_bank> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Compte_bank get(int index) {
            return null;
        }

        @Override
        public Compte_bank set(int index, Compte_bank element) {
            return null;
        }

        @Override
        public void add(int index, Compte_bank element) {

        }

        @Override
        public Compte_bank remove(int index) {
            return null;
        }

        @Override
        public int indexOf(@Nullable Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(@Nullable Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<Compte_bank> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<Compte_bank> listIterator(int index) {
            return null;
        }

        @NonNull
        @Override
        public List<Compte_bank> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_bank);

        /*Button buttonval = (Button) findViewById(R.id.button_ok);

        buttonval.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button validé cliqué");
                spinner.setOnItemSelectedListener(this);
            }
        });*/
    }
    @Override
    public void onStart(){
        super.onStart();
        Spinner spinner = (Spinner) findViewById(R.id.spinner_compte);
        List list_spinner = new ArrayList();

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
                        System.out.println("Compte bancaire n°" + b.getId()+"   Iban :"+b.getIban()+"   Nom  : "+b.getAccountName()+"     Argent :"+b.getAmount());
                    }
                    ArrayAdapter<String> adapter;
                    adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, list_spinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<Compte_bank>> call, Throwable t) {
            }
        });
        Spinner spin = (Spinner) findViewById(R.id.spinner_compte);
        spin.setOnItemSelectedListener(this);

    }
    public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
        final int[] i = {0};
        System.out.println("La postion est :" + position);

        GetDataServiceMoney service = RetrofitClientInstance.getRetrofitInstance().create(GetDataServiceMoney.class);
        Call<List<Compte_bank>> call_2 = service.getAllMoney();
        call_2.enqueue(new Callback<List<Compte_bank>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Compte_bank>> call_2, Response<List<Compte_bank>> response) {
                if (response.isSuccessful()) {
                    for (Compte_bank b : response.body()) {
                        if (position != 0) {
                            if (i[0] == position) {
                                System.out.println("Compte bancaire n°" + b.getId() + "   Iban :" + b.getIban() + "   Nom  : " + b.getAccountName() + "     Argent :" + b.getAmount());
                                TextView id_p = (TextView) findViewById(R.id.id_print);
                                TextView iban_p = (TextView) findViewById(R.id.iban_print);
                                TextView amount_p = (TextView) findViewById(R.id.amount_print);
                                TextView currency_p = (TextView) findViewById(R.id.currency_print);
                                id_p.setText(b.getId());
                                iban_p.setText(b.getIban());
                                amount_p.setText(b.getAmount());
                                currency_p.setText(b.getCurrency());
                            }
                            i[0] = i[0] + 1;
                            System.out.println("contage pour arriver a destination :" + i[0]);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Compte_bank>> call, Throwable t) {
            }
        });
    }
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
        System.out.println("Vous n'avez rien selectionné");

    }
}

