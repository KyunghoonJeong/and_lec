package com.jkh.ex0914;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
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


        btn_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //요청버튼 누르면 리스폰스를 받아온 것을 텍스트 뷰 추가
                String name = et_input.getText().toString(); //보낼값 가지고 잇음
                //보낼 주소 만들기
                String url = "http://project-student.ddns.net/Android/exam";
                //현재 우리가 보낼 방식은 ? QueryString 즉 get방식이다.
                //get방식이기때문에 url 뒤에 ?name= /name 으로 추가 해줌 !
                url += "?name=";
                url+= name;
                //4.Request객체 생성 ! (우리는 StringRequest를 사용 !)
                //리퀘스트 큐는 4가지 정보를 담아야 한다!  1. 전송방식 (get, post) 2. 어디로 보내야되냐, 요청주소 !  3. 응답 성공 시에 실행되는 로직 4. 응답 실패시
                StringRequest request = new StringRequest(
                        Request.Method.GET,  //post방식은 get 대신 post쓰면 된다.
                        url,
                        new Response.Listener<String>() {  //응답 성공시
                            @Override
                            public void onResponse(String response) {
                            tv_result.setText(response);
                            }
                        },
                        new Response.ErrorListener() {   //응답 실패시
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                tv_result.setText("Fail");
                            }
                        }
                );
                //StringRequest 끝나는 파트

                requestQueue.add(request);


            }
        });
        //5.RequestQueue객체에 Request객체 추가 !








    }
}