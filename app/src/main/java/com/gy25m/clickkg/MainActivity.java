package com.gy25m.clickkg;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {
    int num=0;
    TextView tv;
    LinearLayout lay,lay1,lay2,lay3,lay4;
    Button btn;
    ImageView[] ims=new ImageView[12];
    Random rnd=new Random();
    int a=R.drawable.newyork;
    Integer p=0;
    Integer j=0;
    ArrayList<Integer> nums=new ArrayList<>();
    ArrayList<Integer> imgs=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.start_btn);
        btn.setOnClickListener(listener);
        lay=(LinearLayout) findViewById(R.id.lay);
        lay1=(LinearLayout)findViewById(R.id.lay1);
        lay2=(LinearLayout)findViewById(R.id.lay2);
        lay3=(LinearLayout)findViewById(R.id.lay3);
        lay4=(LinearLayout)findViewById(R.id.lay4);
        int[] imgs=new int[]{R.drawable.num01,R.drawable.num02,R.drawable.num03,
                R.drawable.num04,R.drawable.num05,R.drawable.num06,R.drawable.num07,
                R.drawable.num08,R.drawable.num09,R.drawable.num10,R.drawable.num11,
                R.drawable.num12};

        for(int n=0;n<=11;n++) nums.add(n);
        Collections.shuffle(nums);

        for(int i=0;i<ims.length;i++){
            ims[i]=findViewById(R.id.im01+i);
            ims[i].setOnClickListener(listener2);
            ims[i].setVisibility(View.INVISIBLE);

        }
        for(int i=0;i<ims.length;i++){
            ims[nums.get(i)].setImageResource(imgs[i]);
            ims[nums.get(i)].setTag(i);
        }




    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tv.setText("1 to 12!");
            for(int i=0;i<ims.length;i++){
                ims[i].setVisibility(View.VISIBLE);
            }
        }
    };
    View.OnClickListener listener2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (p== view.getTag()) {view.setVisibility(View.INVISIBLE);
            p++; j++;
           }
            if(p==12){
                p=0;
                if(j==24) {lay.setBackground(getResources().getDrawable(R.drawable.newyork));
                tv.setVisibility(View.INVISIBLE);
                btn.setVisibility(View.INVISIBLE);
                lay1.setVisibility(View.INVISIBLE);
                lay2.setVisibility(View.INVISIBLE);
                lay3.setVisibility(View.INVISIBLE);
                lay4.setVisibility(View.INVISIBLE);
                }
                tv.setText("A to L!");
                ims[nums.get(0)].setImageResource(R.drawable.a);
                ims[nums.get(1)].setImageResource(R.drawable.b);
                ims[nums.get(2)].setImageResource(R.drawable.c);
                ims[nums.get(3)].setImageResource(R.drawable.d);
                ims[nums.get(4)].setImageResource(R.drawable.e);
                ims[nums.get(5)].setImageResource(R.drawable.f);
                ims[nums.get(6)].setImageResource(R.drawable.g);
                ims[nums.get(7)].setImageResource(R.drawable.h);
                ims[nums.get(8)].setImageResource(R.drawable.i);
                ims[nums.get(9)].setImageResource(R.drawable.j);
                ims[nums.get(10)].setImageResource(R.drawable.k);
                ims[nums.get(11)].setImageResource(R.drawable.l);
                for(int i=0;i<ims.length;i++){
                    ims[i].setVisibility(View.VISIBLE);
                }
                
            }
        }
    };
}