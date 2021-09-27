package com.jkh.ex0927;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    //바텀네비게이션 뷰의 선택감지
    //view에 리스너 설정되어 있어야함
    //=> view 를 find해야 리스너 설정할 수 있음

    BottomNavigationView nav_view;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nav_view = findViewById(R.id.nav_view);

        nav_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                //매개변수 아이템으로 구분하겠다 => 내가 선택한 메뉴의 정보가 전달.
                //어떤 메뉴를 선택했는지 감지하려면 item의 id값으로 구분해주면 된다.

                if(item.getItemId() == R.id.menu1){
                    //지금 선택한 메뉴의 아이디가 menu1이라면

                }
                else if(item.getItemId() == R.id.menu2){


                }
                else if(item.getItemId() == R.id.menu3){


                }
                else if(item.getItemId() == R.id.menu4){


                }


                return false;
            }
        });



    }
}