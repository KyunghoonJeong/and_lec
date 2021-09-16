package com.jkh.myapplication;

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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MovieActivity extends AppCompatActivity {
    //1. volley라이브러리 추가
    //2. 권한 허용 http는 허용이 필요함
    //3. requestqueue객체 생성
    //4.리퀘스트 객체 생성
    //5.리퀘스트큐 작업영역에 리퀘스트 추가 !

    Button btn_movie;
    RequestQueue requestQueue;
    List<MovieVO> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        btn_movie = findViewById(R.id.btn_movie);
        data = new ArrayList<MovieVO>();
        String date; //Main activity에서 넘어온 날짜를 저장할 변수


        if(requestQueue ==null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        date = getIntent().getStringExtra("date");  //date는 키값


        btn_movie.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {


                                             String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=";
                                             url +=date;


                                             StringRequest request = new StringRequest(
                                                     Request.Method.GET,
                                                     url,
                                                     new Response.Listener<String>() {
                                                         @Override
                                                         public void onResponse(String response) {


                                                             try {
                                                                 JSONObject jsonObject = new JSONObject(response);
                                                                 JSONObject jsonObject2 = jsonObject.getJSONObject("boxOfficeResult"); //박스오피스리절트의 키값으로 가져옴 그걸 제이슨 오브젝트2로 받겠다
                                                                 JSONArray movies = jsonObject2.getJSONArray("dailyBoxOfficeList");
                                                                 for(int i = 0 ; i < movies.length(); i++) {
                                                                     JSONObject movie = (JSONObject) movies.get(i);  // =>첫번째 제이슨 배열값
                                                                     String rank = movie.getString("rank");
                                                                     String rankOldAndNew = movie.getString("rankOldAndNew");
                                                                     String movieNm = movie.getString("movieNm");
                                                                     String audiAcc = movie.getString("audiAcc");
                                                                     String openDt = movie.getString("openDt");

                                                                     MovieVO vo = new MovieVO(rank, rankOldAndNew, movieNm, audiAcc, openDt);


                                                                     data.add(vo);

                                                                     Log.d("영화 제목 : ",data.get(i).getMovieNm());

                                                                 }

                                                                   //jsonobject를 스트링형태로
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
                                     }
        );

    }
}