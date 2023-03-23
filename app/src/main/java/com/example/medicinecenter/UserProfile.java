package com.example.medicinecenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.medicinecenter.Adapters.MenuCategoryAdapter;
import com.example.medicinecenter.Models.Category;

import java.util.ArrayList;
import java.util.List;

public class UserProfile extends AppCompatActivity {


    RecyclerView categoryRecycler;
    MenuCategoryAdapter menuCategoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Личный кабинет"));
        categoryList.add(new Category(2,"Запись / Прием"));
        categoryList.add(new Category(3,"Мед.карта"));
        categoryList.add(new Category(4,"Часы работы"));



        setCategoryRecycler(categoryList);

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
}