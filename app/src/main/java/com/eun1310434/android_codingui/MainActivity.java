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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> items = new ArrayList<>();


    private LinearLayout Mainlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mainlayout = (LinearLayout) findViewById(R.id.layout);

        final ScrollView scrollView = setScrollView(Mainlayout);
        final LinearLayout subLayout = setSV_LinearLayout(scrollView);

        Button addBtn = setButton(Mainlayout);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show Last Items
                scrollView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //상위 레이아웃인 subLayout의 높이를 갖고와서 해당 뷰의 마지막으로 설정
                        //post를 활용하여 UI update를 한다...
                        scrollView.scrollTo(0, subLayout.getHeight());
                    }
                }, 30);

                //scrollView.pageScroll(scrollView.FOCUS_DOWN);
                Log.d("subLayout", String.valueOf(subLayout.getHeight()));
                Log.d("getBottom", String.valueOf(scrollView.getBottom()));
                Log.d("getHeight", String.valueOf(scrollView.getHeight()));
                Log.d("getMeasuredHeight", String.valueOf(scrollView.getMeasuredHeight()));
                Log.d("getScrollY", String.valueOf(scrollView.getScrollY()));
                Log.d("getMaxScrollAmount", String.valueOf(scrollView.getMaxScrollAmount()));

                // 아이템 추가
                addItem(subLayout);
            }
        });
    }

    public Button setButton(LinearLayout _layout) {
        //Button
        Button button = new Button(this);
        button.setText("ADD");
        button.setGravity(Gravity.CENTER);

        //Button - Layout Setting
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,//width
                0 //LinearLayout.LayoutParams.MATCH_PARENT //high
        );
        buttonParams.weight = 1;
        buttonParams.setMargins(10, 10, 10, 10);

        //Button - ADD Layout
        _layout.addView(button, buttonParams);
        return button;

    }

    public ScrollView setScrollView(LinearLayout _layout) {

        //ScrollView
        ScrollView scrollView = new ScrollView(this);

        //ScrollView - Layout Setting
        LinearLayout.LayoutParams scrollviewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,//width
                0 //LinearLayout.LayoutParams.MATCH_PARENT //high
        );
        scrollviewParams.weight = 9;

        //ScrollView - ADD Layout
        _layout.addView(scrollView, scrollviewParams);


        return scrollView;

    }

    public LinearLayout setSV_LinearLayout(ScrollView _scrolView) {
        /**Wrap Layout*/
        LinearLayout setSV_LinearLayout = new LinearLayout(this);
        setSV_LinearLayout.setOrientation(LinearLayout.VERTICAL);
        //setSV_LinearLayout.setBackgroundColor(Color.WHITE);

        //Wrap Layout - Layout Setting
        ScrollView.LayoutParams SV_Params = new ScrollView.LayoutParams(
                ScrollView.LayoutParams.MATCH_PARENT,
                ScrollView.LayoutParams.MATCH_PARENT);

        _scrolView.addView(setSV_LinearLayout, SV_Params);

        return setSV_LinearLayout;
    }


    public void addItem(LinearLayout _subLayout) {
        items.add(new Item("Item-" + items.size(), items.size(), _subLayout, this));
    }
}

