package com.example.museum106;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String imageName = getIntent().getStringExtra("IMAGE_NAME"); // Получаем имя изображения

        ImageView detailImage = findViewById(R.id.detail_image);
        TextView detailText = findViewById(R.id.detail_text);
        Button closeButton = findViewById(R.id.close_button);

        int resourceId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        Drawable drawable = getResources().getDrawable(resourceId);
        detailImage.setImageDrawable(drawable);

        // Устанавливаем длинный текст
        detailText.setText(getLongText());

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Закрываем активность
            }
        });
    }

    private String getLongText() {
        return "Здесь может быть ваш текст длиной более 3000 символов...";
    }
}
