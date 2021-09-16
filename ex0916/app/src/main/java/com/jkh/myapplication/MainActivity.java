package com.jkh.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. listview 위치
        //2. item 디자인
        //3. 아이템 클래스 정의
        //4. 커스텀어댑터 구현(베이스 어댑터 상속)
        //5. 어댑터 부착-> 리스트뷰랑
        //6. 클릭 이벤트(로직)
    }
}