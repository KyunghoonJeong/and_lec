package com.jkh.ex0917;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    TextView tv_number;
    Button btn_start, btn_stop;
    TextView tv_number2;
    MyThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //초기화하고
        //btn_start눌렀을때
        //tv_number의 값이 0부터 10까지 변하게 해주세요

        tv_number = findViewById(R.id.tv_number);
        btn_start =findViewById(R.id.btn_start);
        tv_number2=findViewById(R.id.tv_number2);
        btn_stop =findViewById(R.id.btn_stop);
        //액티비티실행하자마자 tv num2가 0부터 10까지 변화 !
        MyThread thread2 = new MyThread(tv_number2);
        thread2.start();
        
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 thread = new MyThread(tv_number);
                thread.start(); //jvm에게 thread의 run을 호출해달라고 요청 !
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread.interrupt(); //스탑누르면 예외처리의 예외일때로 감
                //한번중지하면 다시 시작할 수 없다 !
            }
        });



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

        TextView tv;
        private MyThread(TextView tv){
            this.tv = tv;
        }
        //스레드 1과 스레드 2가 동시동작하게끔
        //스레드1은 1~10까지 증가
        //스레드2는 10~20까지 증가

        //run()이라는 메소드 오버라이딩 !
        //Alt Insert -> override  -> run() 오버라이드 메소드

        //Main thread에 작업 전달해줄 핸들ㄹ러 만들자!

        Handler myHandler = new Handler(){
            //오버라이딩하나!
            // 우클릭 제네레이트 ! 오버라이드해서 핸들메시지!

            @Override
            public void handleMessage(@NonNull Message msg) {
                //핸들러가 메인쓰레드 작업큐에 작업을 계속 요청한다 !
                int num = msg.arg1;
                TextView tv = (TextView) msg.obj;

                tv.setText(String.valueOf(num));



            }
        };

        @Override
        public void run() {
           //만들고자 하는것 1초에 1씩증가
            //코드를 1초 지연시켜야한다

            try {
                for(int i = 0 ; i<= 10 ; i++){
                    Log.d("스탑워치",String.valueOf(i));
//                    tv_number.setText(String.valueOf(i));    //핸들러사용해야함

                    //message객체에 i를 담아서


                    Message message = new Message();
                    message.arg1 = i;  //정수를 담고싶다 arg1
                    message.obj = tv; // 문자는 obj에 담김

                    //핸들러 쪽으로 전송 !
                    myHandler.sendMessage(message);




                    //1초가 지남
                    Thread.sleep(1000);  //1초지연시키려면 1000  m 10의 마이너스3승  //예외처리를 해야함(스레드 동작하기 때문에)


                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}