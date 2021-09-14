package com.jkh.ex0914;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity3 extends AppCompatActivity {

    EditText et_num1 , et_num2;
    TextView tv_cal;
    Button btn_cal;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        et_num1 = findViewById(R.id.et_num1);
        et_num2 = findViewById(R.id.et_num2);
        tv_cal = findViewById(R.id.tv_cal);
        btn_cal = findViewById(R.id.btn_cal);

        //네트워크 통신을 하기 위한 5단계
        //1. Volley 라이브러리 추가
        //2. 권한 허용 ! / 프로토콜 허용(http)
        //3. RequestQueue 객체 생성
        //한번만 안만들어져있을때!
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());

        }



        //4.Request 객체 생성 (계산버튼 눌렀을때)
        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                

            }
        });
        //5. RequestQueue작업영역에 Request 추가 !

    }
}