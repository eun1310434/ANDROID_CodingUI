/*=====================================================================
□ Infomation
  ○ Data : 23.03.2018
  ○ Mail : eun1310434@naver.com
  ○ Blog : https://blog.naver.com/eun1310434
  ○ Reference
     - Do it android app Programming
     - Hello JAVA Programming
     - http://itmining.tistory.com/5

□ Function
  ○ 소스코드에서 XML 적용하기
     - LinearLayout 추가
     - ScrollView 추가
     - Button 추가
     - ProgressBar 추가
     - TextView 추가

  ○ 소스코드로 ListView 만들기
     - ArrayList로 각각의 View를 관리

□ Study
  ○ Layout을 설정하기 위해선 각각의 타입에 맞는 LayoutParams을 가지고 와서 설정한다.
     - RelativeLayout.LayoutParams
     - LinearLayout.LayoutParams
     - ScrollView.LayoutParams
=====================================================================*/
package com.eun1310434.android_codingui;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Item {

    private Button btn;
    private ProgressBar proBar;
    private TextView title;
    private Handler handler;

    public Item(String titleName, int value, LinearLayout _layout, Context _context) {
        //int value= (int) (Math.random()*100 + 1);

        handler = new Handler();

        /**Wrap LayoutA*/
        RelativeLayout wrapLayoutA = new RelativeLayout(_context);
        wrapLayoutA.setBackgroundColor(Color.LTGRAY);

        //Wrap Layout - Layout Setting
        //해당 부분을 덥고 있는 것이 LinearLayout이기에 LinearLayout을 활용
        LinearLayout.LayoutParams wrapParamsA = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                200);


        /**Wrap LayoutB*/
        LinearLayout wrapLayoutB = new LinearLayout(_context);
        wrapLayoutB.setOrientation(LinearLayout.HORIZONTAL);
        wrapLayoutB.setBackgroundColor(Color.BLACK);

        //Wrap Layout - Layout Setting
        //해당 부분을 덥고 있는 것이 RelativeLayout이기에 RelativeLayout을 활용
        RelativeLayout.LayoutParams wrapParamsB = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        wrapParamsB.setMargins(0,0,0,1);

        /**TextView*/
        title = new TextView(_context);
        title.setText(titleName);
        title.setTextSize(15);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);

        // TextView - Layout Setting
        //해당 부분을 덥고 있는 것이 LinearLayout이기에 LinearLayout을 활용
        LinearLayout.LayoutParams textViewParam = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.MATCH_PARENT);
        textViewParam.weight = 1;
        textViewParam.gravity = Gravity.CENTER;
        textViewParam.setMargins(5, 0, 0, 0);

        // ADD - TextView
        wrapLayoutB.addView(title, textViewParam);//프로그래스바를 params의 레이아웃에 맞춰서 itemLayout에 입력




        /**ProgressBar*/
        proBar = new ProgressBar(_context, null, android.R.attr.progressBarStyleHorizontal);
        //proBar.setIndeterminate(false); //게이지가 올라가는 것이 작업이 완료될때까지 멈추지 않음
        proBar.setMax(100);

        new Thread(new Runnable() {

            @Override
            public void run() {

                while(true){
                    if(proBar.getProgress() == proBar.getMax()){break;}

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            proBar.incrementProgressBy(1);
                        }
                    });
                }
            }
        }).start();


        // ProgressBar - Layout Setting
        //해당 부분을 덥고 있는 것이 LinearLayout이기에 LinearLayout을 활용
        LinearLayout.LayoutParams proBarParams = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.MATCH_PARENT);
        proBarParams.setMargins(5,0,5,0);
        proBarParams.weight = 5;
        proBarParams.gravity = Gravity.LEFT;

        // ADD - ProgressBar
        wrapLayoutB.addView(proBar, proBarParams);


        // ADD - Wrap LayoutB
        wrapLayoutA.addView(wrapLayoutB,wrapParamsB);


        /**Button*/
        btn = new Button(_context);
        btn.setBackgroundColor(Color.TRANSPARENT);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proBar.setProgress(0);
            }
        });

        // Button - Layout Setting
        //해당 부분을 덥고 있는 것이 RelativeLayout이기에 RelativeLayout을 활용
        RelativeLayout.LayoutParams btnParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        //btnParams.gravity = Gravity.LEFT;

        // ADD - ProgressBar
        wrapLayoutA.addView(btn, btnParams);



        /**MainLayout*/
        _layout.addView(wrapLayoutA,wrapParamsA);
    }
}
