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
                    //프래그먼트 갈아끼우는 코드
                                                                                                                        //프래그먼트가 들어갈 공간 , 지정하고 싶은 프래그먼트 객체.commit() => 반영될 수있도록 commit() 붙여주기
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment1()).commit();
                            //프래그먼트매니저가 트랜잭션(갈아끼우는)을 하게끔 준비시키는 중 //()에는어디에다 프래그먼트 끼우고싶니 , +  프래그먼트 객체가 들어감

                }
                else if(item.getItemId() == R.id.menu2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment2()).commit();

                }
                else if(item.getItemId() == R.id.menu3){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment3()).commit();

                }
                else if(item.getItemId() == R.id.menu4){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment4()).commit();

                }


                return true;  //리스너의 리턴이 펄스면 아직 끝나지 않았다는 의미가 되어서 다른 ui 작동을 안함
            }
        });



    }
}