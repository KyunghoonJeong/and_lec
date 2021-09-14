package com.jkh.ex0914;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue ; //스레드들을 관리하는 객체 !
    EditText et_input ;
    TextView tv_result;
    Button btn_req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_input =findViewById(R.id.et_input);
        tv_result = findViewById(R.id.tv_result);
        btn_req = findViewById(R.id.btn_req);

       //volley를 이용한 서버 통신 하기 위한 단계
        //1. 볼리 라이브러리를 추가해야한다.
        //1-1. file -> project structure -> dependecy
        // -> +버튼 누른 후 라이브러리 디펜던시
        //-> 볼리 검색하고 구글 관련 라이브러리 선택해서 ok -> ok

        //2. permission(권한)을 허용 !
        // -> internet 관련 권한 : 인터넷을 통해 data를 주고 받을 수 있도록 ..!
        //매니페스트 폴더 !에서 권한 허용 ! user permission ~
        //2-1.  프로토콜 허용 !( http프로토콜 사용을 위한)
        // http , https 둘다 허용
        // android:usesCleartextTraffic="true"  매니페스트에서
        //3. RequestQueue 객체 생성 !!
        if(requestQueue==null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext()); //현재 페이지 정보인 getapplicationContext()
            //
        }
        //리퀘스트큐가 없다면 만들어준다

        //4.Request객체 생성 !
        //5.RequestQueue객체에 Request객체 추가 !








    }
}