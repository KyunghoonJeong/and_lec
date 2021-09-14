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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity4 extends AppCompatActivity {

    Button btn_last ;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btn_last = findViewById(R.id.btn_last);

        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        btn_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "http://project-student.ddns.net/Android/exam4";

                StringRequest request = new StringRequest(

                        Request.Method.GET,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("연습", response);
                                try {


                                    //현재 responses는 => jsonarray 타입이다 !
                                    //리스폰스를 제이슨어레이로 !
                                    JSONArray contacts = new JSONArray(response);
                                    //response를 제이슨어레이로 바꾸고자 !

                                    //현재 contact 는 제이슨 어레이타입 !

                                    for(int i = 0 ; i < contacts.length();i++){
                                        JSONObject contact = (JSONObject) contacts.get(i);

                                        String name = contact.getString("name");
                                        Log.d("연습2", name);
                                    }







                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("실패", "onErrorResponse: ");
                            }
                        }
                );//5.
                requestQueue.add(request);
            }
        });





    }
}