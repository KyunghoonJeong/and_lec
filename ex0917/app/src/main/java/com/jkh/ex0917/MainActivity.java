package com.jkh.ex0917;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyThread thread = new MyThread();
        thread.start(); //jvm에게 thread의 run을 호출해달라고 요청 !


    }

    //inner class 사용이유
    //1. outer class와 밀접한 관련이 있는 경우
    // -> 외부클래스의 멤버에 손쉽게 접근 가능
    //2. 코드이 캡슐화 증가
    //->서로 관련 있는 클래스들을 논리적으로 묶음

    //inner class종류
    //1)instance class
    //2)static class
    //3)local class
    //4)anonymous class : 이벤트리스너 !
    // btn.setonClickEventListener ( new View.On)

    //inner class 사용 시 반드시 final을 통한 상수를 사용해야한다.


    class MyThread extends Thread{
        //스레드 1과 스레드 2가 동시동작하게끔
        //스레드1은 1~10까지 증가
        //스레드2는 10~20까지 증가

        //run()이라는 메소드 오버라이딩 !
        //Alt Insert -> override  -> run() 오버라이드 메소드


        @Override
        public void run() {
           //만들고자 하는것 1초에 1씩증가
            //코드를 1초 지연시켜야한다

            try {
                for(int i = 0 ; i< 10 ; i++){
                    Log.d("스탑워치",String.valueOf(i));
                    //1초가 지남
                    Thread.sleep(1000);  //1초지연시키려면 1000  m 10의 마이너스3승  //예외처리를 해야함(스레드 동작하기 때문에)
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}