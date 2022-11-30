package org.techtown.roulette;

import static java.lang.Thread.sleep;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class ResultActivity extends AppCompatActivity {
public static int ID = 0;                                          // 랜덤 돌릴 변수 생성

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();                                                     // 받아오는 인텐트 생성
        String [] data = intent.getStringArrayExtra("selectedMenu");               // CheckMenuActivity에서 고른 메뉴 받아서 data 문자배열에 저장

        ListView listView = findViewById(R.id.candidateList);                            // 리스트뷰 변수화
        // data 문자열을 굳이 리스트에 옮겨야하나...?
        /*
        List<String> list = new ArrayList<>();                                           // 리스트 변수 생성
        for(int i = 0; i < data.length; i++) {                                           // 리스트에 data 문자 배열 저장
            list.add(data[i]);
        }
        */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data){         // data를 리스트뷰에 추가
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView)view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.WHITE);
                return view;
            }
        };
        listView.setAdapter(adapter);

        int[] images = new int[] {
                R.drawable.burgerking,
                R.drawable.gunaesikdang,
                R.drawable.haewall,
                R.drawable.china,
                R.drawable.myungga,
                R.drawable.sundae,
                R.drawable.donkachu,
                R.drawable.naemyun
        };
        String[] images_name = new String[]{
                "버거킹",
                "법구",
                "해월",
                "금석궁",
                "명가",
                "순대국",
                "목동카츠",
                "육쌈냉면"
        };

        //Button button_okay = findViewById(R.id.button_result_okay);
        //Button button_cancle = findViewById(R.id.button_result_cancle);
        Button button_roulette = findViewById(R.id.button_result_roulette);
/*
        button_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Result_to_end = new Intent(getApplicationContext(),endactivity.class);
                Result_to_end.putExtra("Result_imageId",data[ID]);

                startActivity(Result_to_end);
                finish();
            }
        });

        button_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Result_to_main = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(Result_to_main);
                finish();
            }
        });*/
        button_roulette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                try
                {
                    ImageView imageView_food = (ImageView) findViewById(R.id.imageView_result_image);
                    ID = (int) (Math.random() * images.length);
                    imageView_food.setBackgroundResource(images[ID]);
                    TextView textView = findViewById(R.id.textView_result_result);
                    textView.setText(images_name[ID]);
                    sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                */

                try {
                    ImageView imageView_food = (ImageView) findViewById(R.id.imageView_result_image);
                    ID = (int) (Math.random() * data.length);
                    for(int i = 0; i < 8; i++) {
                        if(data[ID].equals(images_name[i])) {
                            imageView_food.setBackgroundResource(images[i]);
                            TextView textView = findViewById(R.id.textView_result_result);
                            textView.setText("★ " + images_name[i] + " ★");
                        }
                    }
                    sleep(500);
                } catch (InterruptedException e)
                {
                    Toast.makeText(ResultActivity.this, "예외처리", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });

    }
}