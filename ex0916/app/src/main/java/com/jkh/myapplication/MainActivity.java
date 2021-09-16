package com.jkh.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CalendarView cv;
    Button btn_rank;
    String date; // movie액티비티로 전달할 날짜 정보 !

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
        cv = findViewById(R.id.cv);
        btn_rank =findViewById(R.id.btn_rank);
        date ="0";

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                date ="";
                date += year;
                month++;
                if(month <10){
                    date+="0";
                }
                date += month;


                if(day<10){
                    date+="0";
                }
                date+=day;

                Log.d("날짜",date);
            }
        });

        btn_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //intent를 활용해 mainactivity -> movieactivity
                //date라는 날짜 정보를 넘길 것 ! 
                //2012 01 01 ~ 2021 09 15 까지만 검색이 가능하다 !
                //date가 위의 날짜 사이 일때만 넘김! 
                //위의 날짜 사이가 아닐 때는  toast메세지로 "날짜를 다시 선택해주세요" 라고 문구를 띄우겠다

                Intent intent = new Intent(MainActivity.this, MovieActivity.class);

                int check = Integer.parseInt(date);
                if(check >= 20120101 && check <=20210915){
                    intent.putExtra("date",date);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "날짜를 다시 선택해주세요.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}