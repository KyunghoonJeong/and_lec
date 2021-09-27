package com.jkh.ex0923;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DoActivity extends AppCompatActivity {

    TextView tv_count;
    TextView tv_timer;
    ImageView[] imgs;
    int cnt ; //잡은 개수 저장할 변수
    boolean isPlaying;
    final int CATCH = 9999 ; // catch (stop )

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do);

        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.mouse);
        mediaPlayer.start();

        tv_timer =findViewById(R.id.tv_timer);
        tv_count = findViewById(R.id.tv_count);
        cnt = 0;
        isPlaying =true;
    
        TimerThread thread2 = new TimerThread(tv_timer);
        thread2.start();
        
        imgs = new ImageView[9];
//        int num1 = 1000137;
//        imgs[0] = findViewById(1000137);
        for (int i = 0; i < imgs.length; i++) {
            int resID = getResources().getIdentifier("img" + (i + 1), "id", getPackageName());
            imgs[i] = findViewById(resID);

            imgs[i].setTag("off"); //처음에는 다 앉아있다는 정보 저장


            //for문을 통해 이미지 뷰 9 개 초기화하였음.

//            imgs[i].setVisibility(View.INVISIBLE);

            //i : 두더지 인덱스 !

            DoThread thread = new DoThread(i);
            thread.start();
            final int pos = i ;

            //두더지 클릭했을 때 이미지 이벤트 !
            imgs[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    //현재 두더지가 일어나있는지 앉아있는지 판단해야함

                    String do_status =(String) imgs[pos].getTag();

                    if(cnt ==10){
                        isPlaying = false;
                        imgs[pos].setClickable(isPlaying);

                    }

                    //클릭했을 때 두더지가 일어나 있는 상태라면
                    if(do_status.equals("on")){
                        cnt++;

                    }
                    else{
                        if(cnt >0 ){
                            cnt--;
                        }
                    }
                    tv_count.setText(String.valueOf("잡은 개수 : " +cnt));
                    //앉아 있을 때 클릭하면 -1점
                    //점수는 0점 밑으로 내려가지 않는다.

                    //잡은 개수가 30개가 되면 두더지가 더 이상 일어나지 않게 해주세요
                    //테스트는 10개로 해주세요



                }
            });
        }


    }

    Handler doHandler = new Handler() {
        //handlemassage()오버라이딩 하기

        @Override
        public void handleMessage(@NonNull Message msg) {
            int i = msg.arg1;
            int img = msg.arg2; //일어나있는 두더지의 이미지
            String do_status = (String) msg.obj ;
            imgs[i].setImageResource(img) ;
            imgs[i].setTag(do_status);

        }
    };


    //oncreate 밖
    // Thread 만들자 !
    // 현재 전부 앉아 있는 두더지를 랜덤하게 서게 만들자 !
    //랜덤하게 서게 만들자 !
    private class DoThread extends Thread {

        int i;  //imageView의 인덱스 정보를 담고 있는 변수

        //Handler에게 넘길 값
        private DoThread(int i) {
            this.i = i;
        }

        //alt insert -> 오버라이드 메소드
        // 우클릭 제너레이트
        //런 함수 오버라이드 해라

        @Override
        public void run() {

            while (isPlaying) {


                //랜덤하게 시간을 만들자

                try {
                    //0~5초 랜덤하게 지연되는 코드
                    int offTime = new Random().nextInt(5000);

                    Thread.sleep(offTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //핸들러에 전달할 객체
                Message message = new Message();

                message.arg1 = i; //이미지뷰의 인덱스
                //일어나있는 두더지의 이미지 주소를 전달!

                message.arg2 = R.drawable.on;
                message.obj = "on";  //현재 일어난 상태라는 정보를 obj에 저장

                doHandler.sendMessage(message);

                //앉는 기능 만들자
                // 서 있는 시간을 0~3초로 설정하자.
                int onTime = new Random().nextInt(3000);

                try {
                    Thread.sleep(onTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                message = new Message();
                message.arg1 = i;
                message.arg2 = R.drawable.off;
                message.obj = "off"; //서있을때는 on, 앉아있을 때는 off

                doHandler.sendMessage(message); //0~3초가 지난 후 off이미지 보내준다.


            }
        }
    }
    //여기까지가 DoThread()
    
    //Thread구현 시에 할 일
    //1.run() 메소드 오버라이딩
    //2.전역 변수 설정 후 생성자 만들기
    Handler timerHandler = new Handler(){
       //Handler 생성 시 할 일
        //1. 핸들 메세지 오버라이딩

        @Override
        public void handleMessage(@NonNull Message msg) {
            int time =msg.arg1 ;
            TextView tv = (TextView) msg.obj;
            tv.setText("남은 시간 : "+time+"초");
        }
    };

    private class TimerThread extends Thread{

       TextView tv;

        private  TimerThread(TextView tv){
            this.tv = tv;



        }

        @Override
        public void run() {
            try {
                for(int i = 9 ; i >= 0 ; i--){
                    Thread.sleep(1000);

                    Message message = new Message();
                    message.arg1 = i ; //남은 시간
                    message.obj = tv;  //변경할 텍스트
                    timerHandler.sendMessage(message);

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }



}