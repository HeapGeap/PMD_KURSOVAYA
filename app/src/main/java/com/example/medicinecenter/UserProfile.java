package com.example.medicinecenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.medicinecenter.Adapters.MenuCategoryAdapter;
import com.example.medicinecenter.Database.DatabaseManager;
import com.example.medicinecenter.Models.Category;

import java.util.ArrayList;
import java.util.List;

public class UserProfile extends AppCompatActivity {


    RecyclerView categoryRecycler;
    MenuCategoryAdapter menuCategoryAdapter;

    private static TextView DbOut;

    public static DatabaseManager myDbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Личный кабинет"));
        categoryList.add(new Category(2,"Запись / Прием"));
        categoryList.add(new Category(3,"Мед.карта"));
        categoryList.add(new Category(4,"Часы работы"));

        myDbManager = new DatabaseManager(this);

        DbOut = findViewById(R.id.UsersVision);


        setCategoryRecycler(categoryList);

    }

    @Override
    protected void onResume() {
        super.onResume();
        myDbManager.openDb();
    }



    public static void Delete(){
        DbOut.setText(" ");
    }



    public void database_work_window(View v){
        Intent intent = new Intent(UserProfile.this, DatabaseSave.class);
        startActivity(intent);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        categoryRecycler = findViewById(R.id.category_recycler);
        categoryRecycler.setLayoutManager(layoutManager);

        menuCategoryAdapter = new MenuCategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(menuCategoryAdapter);
    }

    public static void showById(int id){
        if(id == 4){
            Delete();
            for(String name : myDbManager.getDataFromDb()){
                DbOut.append(name);
                DbOut.append("\t\t");
            }
        }else if(id == 2){
            Delete();
            for(String name : myDbManager.getDataFromDb2()){
                DbOut.append(name);
                DbOut.append("\t\t");
        }

        }else Delete();

    }

    public void AlertDia(View v){
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setMessage("+7-XXX-XXX-XXXX - Регистратура" + "\n" + "+7-XXX-XXX-XXXX - Кардио отделение"
                + "\n" + "+7-XXX-XXX-XXXX - Контакт-центр")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog alert = alt_bld.create();
        alert.setTitle("Контактная информация");
        alert.show();
    }

    public void AlertDia2(View v){
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setMessage("Центр предоставляет полный спектр медицинских услуг, выполняемых мастерами своего дела." +
                        "Горячая линия доступна круглосуточно, за подробной информацией обращайтесь в регистратуру. ")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog alert = alt_bld.create();
        alert.setTitle("Медицинский центр 'Sanctum'");
        alert.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDbManager.closeDatabase();
    }
}