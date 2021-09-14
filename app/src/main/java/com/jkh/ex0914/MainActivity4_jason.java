package com.jkh.ex0914;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity4_jason extends AppCompatActivity {

    Button btn_json;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_jason);

        btn_json = findViewById(R.id.btn_json);

        //3.
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }


        //버튼 눌렀을때
        btn_json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://project-student.ddns.net/Android/exam3"; //서버

                //4. request 객체생성
                StringRequest request = new StringRequest(
                        Request.Method.GET,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                            Log.d("연습",response);

                            //"나예호"라는 값을 꺼내오고 싶다.
                                //key값은 "name"이라고 알고 있음.
                                //응답받은 리스폰스를 json형태로 변환 할 것임.
                                //json 오브젝트 만들자
                                try {
                                    //json사용 이유 : 타 기종간의 data전송 시에 데이터를 효율적으로 전송하기 위해서 !
                                    JSONObject jsonObject = new JSONObject(response); //안에 반환하고자하는 문자열 ! 예외처리까지 해줘야한다. => 오류가 발생할 수 있는 상황에서 미리
                                    String name = jsonObject.getString("name");  //json의 키값은(name)왠만하면 로그에서 복붙해라
                                    int age = jsonObject.getInt("age");
                                    String tel = jsonObject.getString("tel");


                                    Log.d("연습", "이름 : "+name);
                                    Log.d("연습", "나이 : "+age);
                                    Log.d("연습", "번호 : "+tel);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                );
                requestQueue.add(request);
            }
        });

    }
}