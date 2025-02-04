package com.example.museum106;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        // Найти все ImageViews
        ImageView image1 = findViewById(R.id.image_1);
        ImageView image2 = findViewById(R.id.image_2);
        // ... повторить для всех 12 изображений

        // Установить обработчики кликов
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity("image1");
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity("image2");
            }
        });

        // ... повторить для остальных изображений
    }

    private void openDetailActivity(String imageName) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("IMAGE_NAME", imageName); // Передаем имя изображения
        startActivity(intent);
    }
}