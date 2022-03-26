package com.prerana.uiux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    RecyclerView recyclerCateogries,recyclerFoodItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerCateogries = findViewById(R.id.recycler_categories);
        recyclerFoodItem = findViewById(R.id.recycler_Food);

        setCategories();
        setFoodItem(0);
    }

    private void setCategories(){

        List<FoodCategory>data=new ArrayList<>();

        FoodCategory foodCategory = new FoodCategory("Chicken",R.drawable.ic_chicken);
        FoodCategory foodCategory2 = new FoodCategory("Burger",R.drawable.ic_burger);
        FoodCategory foodCategory3 = new FoodCategory("Pizza",R.drawable.ic_pizza);
        FoodCategory foodCategory4 = new FoodCategory("Chicken",R.drawable.ic_chicken);
        FoodCategory foodCategory5 = new FoodCategory("Chicken",R.drawable.ic_chicken);

        data.add(foodCategory);
        data.add(foodCategory2);
        data.add(foodCategory3);
        data.add(foodCategory4);
        data.add(foodCategory5);

        FoodCategoryAdapter foodCategoryAdapter = new FoodCategoryAdapter(data, Home.this, new FoodCategoryAdapter.OnCategoryClickedListner() {
            @Override
            public void onCategoryClick(int positionClicked) {
                setFoodItem(positionClicked);
            }
        });

        recyclerCateogries.setLayoutManager(new LinearLayoutManager(Home.this,RecyclerView.HORIZONTAL,false));
        recyclerCateogries.setAdapter(foodCategoryAdapter);

        foodCategoryAdapter.notifyDataSetChanged();


    }
    private void setFoodItem(int categoryPos){
        List<Fooditem>data=new ArrayList<>();
        switch (categoryPos){
            case 0:
                Fooditem fooditem11 = new Fooditem("Chicken",4.5f,15,R.drawable.grill_chicken_1);
                Fooditem fooditem21 = new Fooditem("Chicken +",.5f,14,R.drawable.grill_chicken_2);
                Fooditem fooditem31= new Fooditem("Grilled Chicken",3.5f,12,R.drawable.grill_chicken_3);

                data.add(fooditem11);
                data.add(fooditem21);
                data.add(fooditem31);
                break;
            case 1:
                Fooditem fooditem111 = new Fooditem("Burger big",4.5f,16,R.drawable.pizza_2);
                Fooditem fooditem211 = new Fooditem("Burger",3.5f,14,R.drawable.pizza_3);

                data.add(fooditem111);
                data.add(fooditem211);

                break;
            case 2:

                Fooditem fooditem = new Fooditem("Pizza",3.5f,14,R.drawable.pizza_1);
                Fooditem fooditem2 = new Fooditem("Some Pizza",3.5f,14,R.drawable.pizza_2);
                Fooditem fooditem3 = new Fooditem("Crazy Pizza",3.5f,14,R.drawable.pizza_3);
                Fooditem fooditem4 = new Fooditem("Pizza 2",3.5f,14,R.drawable.pizza_4);

                data.add(fooditem);
                data.add(fooditem2);
                data.add(fooditem3);
                data.add(fooditem4);
                break;


        }





        FooditemAdapter fooditemAdapter = new FooditemAdapter(data);
        recyclerFoodItem.setLayoutManager(new LinearLayoutManager(Home.this,RecyclerView.HORIZONTAL,false));
        recyclerFoodItem.setAdapter(fooditemAdapter);

        fooditemAdapter.notifyDataSetChanged();

    }
}