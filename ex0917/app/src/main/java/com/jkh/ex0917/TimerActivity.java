package com.jkh.ex0917;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {
    TextView tv_timer ;
    Button btn_timer, btn_restart, btn_pause;
    TimerThread thread;
    int number ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        tv_timer = findViewById(R.id.tv_timer);
        btn_timer =findViewById(R.id.btn_timer);
        btn_pause =findViewById(R.id.btn_pause);
        btn_restart=findViewById(R.id.btn_restart);
        number = 30;


        btn_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               thread = new TimerThread(tv_timer);
                thread.start();
            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread.interrupt();



            }
        });
        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //재시작
                //일시정지 한 순간 정수를 가져와서
                //그 숫자부터 1씩 감소하는 쓰레드 구현
                thread = new TimerThread(tv_timer);
                thread.start();

            }
        });


    }

    private class TimerThread extends Thread{


        TextView tv;

        Handler timerHandler = new Handler(){
            //alt insert  => override 메소드를 통해 핸들메세지 메소드 오버라이딩

            @Override
            public void handleMessage(@NonNull Message msg) {
                int num = msg.arg1;
                TextView tv = (TextView) msg.obj;
                tv.setText(String.valueOf(num));
            }
        };

        public TimerThread(TextView tv) {
            this.tv = tv;
        }
        //오버라이드메소드
        //run메소드 오버라이딩

        @Override
        public void run() {
            //30부터 0까지 감소하는 코드 작성
            //hint) 1초 지연 시키는 코드 -> thread.sleep(1000);

            try { //1. for문을 통해 1초마다 1씩 감소하는 코드 작성
                for(int i =number ; i >=0 ; i--){
                    //i라는 정보
                    number = i ;
                    //2. message객체 생성 후
                    //정수 i와 tv를 담아 handler로 전송 !
                    Message message = new Message();
                    message.arg1 = i;
                    message.obj =tv;


                    timerHandler.sendMessage(message);


                    Thread.sleep(1000);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
                return ;
            }


            //3. handler쪽에서 메시지를 열어 i와 tv를 꺼낸 후
            //4. main 스레드의 작업 큐에 작업을 추가한다.


        }
    }
}