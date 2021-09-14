package com.jkh.ex0914;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //volley를 이용한 서버 통신 하기 위한 단계
        //1. 볼리 라이브러리를 추가해야한다.
        //1-1. file -> project structure -> dependecy
        // -> +버튼 누른 후 라이브러리 디펜던시
        //-> 볼리 검색하고 구글 관련 라이브러리 선택해서 ok -> ok

        //2. permission(권한)을 허용 !
        // -> internet 관련 권한 : 인터넷을 통해 data를 주고 받을 수 있도록 ..!
        //매니페스트 폴더 !에서 권한 허용 ! user permission ~
        //2-1.  프로토콜 허용 !
        // http , https 둘다 허요
        // android:usesCleartextTraffic="true"  매니페스트에서
        //3. RequestQueue 객체 생성 !!
        //4.Request객체 생성 !








    }
}