package org.techtown.roulette;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CheckMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_menu);

        Vector<String> selectedMenu = new Vector<String>();                                  // 고른 메뉴를 ResultActivity로 보낼때 그릇이 될 벡터

        // 체크박스 변수화
        CheckBox burgerkingCheck = (CheckBox) findViewById(R.id.checkBox_check_burgerking);
        CheckBox gunaeCheck = (CheckBox) findViewById(R.id.checkBox_check_gunaesikdang);
        CheckBox haewallCheck = (CheckBox) findViewById(R.id.checkBox_check_haewall);
        CheckBox chinaCheck = (CheckBox) findViewById(R.id.checkBox_check_china);
        CheckBox myunggaCheck = (CheckBox) findViewById(R.id.checkBox_check_myungga);
        CheckBox sundaeCheck = (CheckBox) findViewById(R.id.checkBox_check_sundae);
        CheckBox donkachuCheck = (CheckBox) findViewById(R.id.checkBox_check_donkachu);
        CheckBox naemyunCheck = (CheckBox) findViewById(R.id.checkBox_check_naemyun);
        Button confirmButton = (Button) findViewById(R.id.button_check_confirm);

        // 확인 버튼 눌렀을 때
        confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent check_to_Result = new Intent(getApplicationContext(),ResultActivity.class);          // ResultActivity로 넘어갈 인텐트 생성

                selectedMenu.clear();                                                                       // 기존에 선택된 메뉴가 누적되지 않도록 한번 리셋

                // 고른메뉴 벡터에 추가
                if(burgerkingCheck.isChecked()) { selectedMenu.add(burgerkingCheck.getText().toString()); }
                if(gunaeCheck.isChecked()) { selectedMenu.add(gunaeCheck.getText().toString()); }
                if(haewallCheck.isChecked()) { selectedMenu.add(haewallCheck.getText().toString()); }
                if(chinaCheck.isChecked()) { selectedMenu.add(chinaCheck.getText().toString()); }
                if(myunggaCheck.isChecked()) { selectedMenu.add(myunggaCheck.getText().toString()); }
                if(sundaeCheck.isChecked()) { selectedMenu.add(sundaeCheck.getText().toString()); }
                if(donkachuCheck.isChecked()) { selectedMenu.add(donkachuCheck.getText().toString()); }
                if(naemyunCheck.isChecked()) { selectedMenu.add(naemyunCheck.getText().toString()); }

                String[] selectedMenuArr = selectedMenu.toArray(new String[selectedMenu.size()]);            // 고른 메뉴가 담긴 벡터 문자배열화

                check_to_Result.putExtra("selectedMenu", selectedMenuArr);                             // ResultActivity로 넘어가면서 문자배열 보내기

                if(selectedMenuArr.length > 0) {               // 1개 이상의 메뉴르 골랐을 경우
                    startActivity(check_to_Result);            // check_to_Result 인테트를 싱행시키면서 ResultActivity로 넘어감
                } else {
                    Toast.makeText(CheckMenuActivity.this, "아무것도 안골랐잖아;;", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}