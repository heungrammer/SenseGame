package com.heunglab.sensegame;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ComActivity extends AppCompatActivity {

    int MILLISINFUTURE = 16*1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;
    int count = 15, user_time;
    int number = 0, number_random;
    Button number_btn;
    TextView countTxt, board;
    CountDownTimer countDownTimer, com_random;
    Person person[] = new Person[5];
    String result;
    int chance = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com);




        //게임
        number_btn = (Button)findViewById(R.id.number);
        board = (TextView)findViewById(R.id.board);
        number_btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                ++number;   ++chance;
                board.setText(String.valueOf(number));
                user_time = count;

                if(number == 6) {
                    board.setText("당신이 졌습니다.");
                }
                if(chance >= 2) {
                    board.setText("당신이 졌습니다.");
                }
            }
        });

        //타이머
        countTxt = (TextView)findViewById(R.id.countTxt);
        countDownTimer();


        for(int i=0; i<5; i++) {
            number_random = (int) (Math.random() * 9 + 1) * 1000;
            person[i] = new Person(i);
            person[i].countGame();
            com_random.start();
        }
        countDownTimer.start();

//        while(true) {
//            for (int i = 0; i < 5; i++) {
//                if (abs(user_time - person[i].time) >= 0 || abs(user_time - person[i].time) <= 1) {
////                    result = "당신,"
////                    board.setText("당신과"+"사람["+String.valueOf(i)+"]가 졌습니다.");
////                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
////                    try{Thread.sleep(3000);} catch(Exception e) {}
////                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
////                    finish();
//                }
//
//            }
//        }


    }


    public void countDownTimer() {
        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                countTxt.setText(String.valueOf(count));
                count--;
            }
            @Override
            public void onFinish() {
                countTxt.setText(String.valueOf("끝"));
                board.setText(result);
                try { Thread.sleep(3000);} catch(Exception e) {}
                finish();
            }
        };
    }
    class Person {
        private int ii=0;
        int time;
        public Person(int i) {
            this.ii = i;
        }
        public void countGame() {
            com_random = new CountDownTimer(number_random, COUNT_DOWN_INTERVAL) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    board.setText("사람["+String.valueOf(ii+1)+"]이 눌렀습니다.  " + String.valueOf(++number));
                    if(number==6) {
                        board.setText("사람["+String.valueOf(ii+1)+"]이 졌습니다.  ");
                    }
                    time = count;
                }
            };
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        try{
            countDownTimer.cancel();
        } catch(Exception e) {}
        countDownTimer=null;
    }
}
