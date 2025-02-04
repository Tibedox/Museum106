package com.example.museum106;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

        // Загружаем текст из файла
        String fileName = "text" + imageName.substring(5) + ".txt"; // Формируем имя файла
        String longText = readFileFromAssets(fileName);
        detailText.setText(longText);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Закрываем активность
            }
        });
    }

    private String readFileFromAssets(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream is = getAssets().open(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
