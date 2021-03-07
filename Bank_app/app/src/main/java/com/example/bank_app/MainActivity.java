package com.example.bank_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDoalog;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button button = (Button) findViewById(R.id.button_main);
        button.setOnClickListener(new View.OnClickListener() {
            EditText id_recup = (EditText) findViewById(R.id.id_submit);

            public void onClick(View v) {

                progressDoalog = new ProgressDialog(MainActivity.this);
                progressDoalog.setMessage("Loading....");
                progressDoalog.show();
                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

                Call<List<Client>> call = service.getAllCompte();
                call.enqueue(new Callback<List<Client>>() {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {

                        progressDoalog.dismiss();
                        System.out.println("reponse est :\n" + response.toString());


                        if (response.isSuccessful()) {

                            int i = 0;
                            Client client_connect=new Client();
                            for (Client c : response.body()) {
                                System.out.println("Nom: " + c.getName());
                                i = i + 1;
                                int final_id = Integer.parseInt(id_recup.getText().toString());
                                if (c.getId() == final_id) {
                                    client_connect = c;

                                    Toast.makeText(getApplicationContext(),"Welcome "+client_connect.getName() , Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(MainActivity.this, page_bank.class);
                                    startActivity(intent);
                                }
                            }

                            //System.out.println("Il y a : " + i + " clients");
                            System.out.println("Vous etes autotentifier en tant que :" + client_connect.getName());

                        }
                        else {
                            System.out.println("il y a une erreur :     " + response.errorBody());
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Client>> call, Throwable t) {
                        progressDoalog.dismiss();
                        Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }






                });


            }

        });
    }
}

