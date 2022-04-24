package com.example.childrensquizinc;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class lvl2 extends AppCompatActivity {
    Dialog dialog;
    Dialog dialogEnd;
    public int numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl1);

        TextView text_lvl = findViewById(R.id.text_lvl);
        text_lvl.setText(R.string.level2);
        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        img_right.setClipToOutline(true);

        final TextView text_left = findViewById(R.id.textleft);


        final TextView text_right = findViewById(R.id.textright);



        Button button_back = (Button) findViewById (R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(lvl2.this,GemeLvl.class );
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }



        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.priviedialog2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        TextView btnclose = (TextView) dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             try
             {
                 Intent intent = new Intent(lvl2.this,GemeLvl.class );
                 startActivity(intent);
                 finish();

             }
             catch (Exception e)
             {
             }


            }
        });
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {

                                               dialog.dismiss();
                                           }
                                       });
        dialog.show();



        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend2);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.setCancelable(false);
        TextView btnclose2 = (TextView) dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Intent intent = new Intent(lvl2.this,GemeLvl.class );
                    startActivity(intent);
                    finish();

                }
                catch (Exception e)
                {
                }


            }
        });
        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(lvl2.this,lvl3.class);
                    startActivity(intent);
                    finish();

                 }catch (Exception e){

                }


                dialogEnd.dismiss();

            }
        });


     final int [] progress = {
             R.id.point1,R.id.point2,
             R.id.point3,R.id.point4,
             R.id.point5,R.id.point6,
             R.id.point7,R.id.point8,
             R.id.point9,R.id.point10,
             R.id.point11,R.id.point12,
             R.id.point13,R.id.point14,
             R.id.point15,R.id.point16,
             R.id.point17,R.id.point18,
             R.id.point19,R.id.point20,

     };
  final Animation a = AnimationUtils.loadAnimation(lvl2.this,R.anim.alpha);

    numLeft = random.nextInt(20);
   img_left.setImageResource(array.imeges2[numLeft]);
   text_left.setText(array.texts2[numLeft]);
   numRight = random.nextInt(20);
   while (array.strong2[numLeft]==array.strong2[numRight]){
       numRight = random.nextInt(20);
   }
   img_right.setImageResource(array.imeges2[numRight]);
   text_right.setText(array.texts2[numRight]);

   img_left.setOnTouchListener(new View.OnTouchListener() {
       @Override
       public boolean onTouch(View v, MotionEvent motionEvent ) {

           if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
             img_right.setEnabled(false);
             if(array.strong2[numLeft]>array.strong2[numRight]){
                 img_left.setImageResource(R.drawable.img_true);
             }else {
                 img_left.setImageResource(R.drawable.img_false);
             }
           }else if(motionEvent.getAction()==MotionEvent.ACTION_UP) {
             if(array.strong2[numLeft]>array.strong2[numRight]){
                if(count<20){
                     count=count+1;
                 }
                 for (int i=0; i<20; i++){
                     TextView tv = findViewById(progress[i]);
                     tv.setBackgroundResource(R.drawable.st_point);
                 }

                 for (int i=0; i<count; i++){
                     TextView tv = findViewById(progress[i]);
                     tv.setBackgroundResource(R.drawable.st_point_green);
                 }



             }else {
               if (count>0){
                   if (count==1){
                       count=0;
                   }else {
                       count=count-2;
                   }
               }
             } for (int i=0; i<19; i++){
                   TextView tv = findViewById(progress[i]);
                   tv.setBackgroundResource(R.drawable.st_point);
               }

               for (int i=0; i<count; i++){
                   TextView tv = findViewById(progress[i]);
                   tv.setBackgroundResource(R.drawable.st_point_green);
               }

             if(count==20){
                 SharedPreferences save = getSharedPreferences("Seve",MODE_PRIVATE);
                 final int level = save.getInt("level",1);
                 if(level>2){

                 }else{
                     SharedPreferences.Editor editor = save.edit();
                     editor.putInt("level",3);
                     editor.commit();
                 }
                 dialogEnd.show();
             }else{
                 numLeft = random.nextInt(20);
                 img_left.setImageResource(array.imeges2[numLeft]);
                 text_left.setText(array.texts2[numLeft]);
                 numRight = random.nextInt(20);
                 while (array.strong2[numLeft]==array.strong2[numRight]){
                     numRight = random.nextInt(20);
                 }
                 img_right.setImageResource(array.imeges2[numRight]);
                 text_right.setText(array.texts2[numRight]);
                 img_right.startAnimation(a);
                 img_right.setEnabled(true);

             }

           }
           return true;
       }
   });
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent ) {

                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    img_left.setEnabled(false);
                    if(array.strong2[numRight]>array.strong2[numLeft]){
                        img_right.setImageResource(R.drawable.img_true);
                    }else {
                        img_right.setImageResource(R.drawable.img_false);
                    }
                }else if(motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    if(array.strong2[numRight]>array.strong2[numLeft]){
                        if(count<20){
                            count=count+1;
                        }
                        for (int i=0; i<20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.st_point);
                        }

                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.st_point_green);
                        }



                    }else {
                        if (count>0){
                            if (count==1){
                                count=0;
                            }else {
                                count=count-2;
                            }
                        }
                    } for (int i=0; i<19; i++){
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.st_point);
                    }

                    for (int i=0; i<count; i++){
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.st_point_green);
                    }

                    if(count==20){
                        SharedPreferences save = getSharedPreferences("Seve",MODE_PRIVATE);
                        final int level = save.getInt("level",1);
                        if(level>2){

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("level",3);
                            editor.commit();
                        }
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(20);
                        img_left.setImageResource(array.imeges2[numLeft]);
                        text_left.setText(array.texts2[numLeft]);
                        numRight = random.nextInt(20);
                        while (array.strong2[numLeft]==array.strong2[numRight]){
                            numRight = random.nextInt(20);
                        }
                        img_right.setImageResource(array.imeges2[numRight]);
                        text_right.setText(array.texts2[numRight]);
                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[numLeft]);

                        img_left.setEnabled(true);

                    }

                }
                return true;
            }
        });
    }
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(lvl2.this,GemeLvl.class );
            startActivity(intent);
            finish();
        }catch (Exception e){

        }

    }

}