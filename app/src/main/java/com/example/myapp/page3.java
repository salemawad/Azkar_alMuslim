package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class page3 extends AppCompatActivity {
private ListView listView;
private Button shar,logout;
AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        shar=findViewById(R.id.share_b);
        logout=findViewById(R.id.button);
        builder=new AlertDialog.Builder(this);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("رسالة تاكيد").setTitle("تسجيل خروج");
                builder.setMessage("هل انت متأكد من الخروج").setCancelable(false).setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Toast.makeText(page3.this, "اخترت نعم", Toast.LENGTH_SHORT).show();

                    }
                }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(page3.this, "اخترت لا", Toast.LENGTH_SHORT).show();

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.setTitle("تسجيل خروج");
                dialog.show();

            }
        });

        listView=findViewById(R.id.list1);
        ArrayList<String> list=new ArrayList<>();
        list.add("اذكار الصباح");
        list.add("اذكار المساء");
        list.add("اذكار النوم");
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        listView.getSelectedItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(page3.this,page4.class);
                intent.putExtra("page",position);
                startActivity(intent);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opchin,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.item_share){
            Intent share=new Intent(Intent.ACTION_SEND);
            share.setType("text/plan");
            share.putExtra(Intent.EXTRA_SUBJECT,"ONLINESHOPING");
            startActivity(Intent.createChooser(share,"اختر التطبيق للمشاركة"));

        }else {
            builder.setMessage("رسالة تاكيد").setTitle("تسجيل خروج");
            builder.setMessage("هل انت متأكد من الخروج").setCancelable(false).setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    Toast.makeText(page3.this, "اخترت نعم", Toast.LENGTH_SHORT).show();

                }
            }).setNegativeButton("لا", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(page3.this, "اخترت لا", Toast.LENGTH_SHORT).show();

                }
            });
            AlertDialog dialog=builder.create();
            dialog.setTitle("تسجيل خروج");
            dialog.show();



        }
        return super.onOptionsItemSelected(item);
    }
}