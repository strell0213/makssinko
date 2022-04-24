package com.example.childrensquizinc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.childrensquizinc.R;

import org.w3c.dom.Text;

public class GemeLvl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gemelvll);

        SharedPreferences save = getSharedPreferences("Seve",MODE_PRIVATE);
        final int level = save.getInt("level",1);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button) findViewById (R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(GemeLvl.this,MainActivity.class );
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });
         TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             try {
                                                 if(level>=1) {
                                                     Intent intent = new Intent(GemeLvl.this, lvl1.class);
                                                     startActivity(intent);
                                                     finish();
                                                 }else {

                                                 }
                                             } catch (Exception e) {

                                             }
                                         }
                                     });
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=2) {
                        Intent intent = new Intent(GemeLvl.this, lvl2.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                } catch (Exception e) {

                }
            }
        });
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=3) {
                        Intent intent = new Intent(GemeLvl.this, lvl3.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                } catch (Exception e) {

                }
            }
        });
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=4) {
                        Intent intent = new Intent(GemeLvl.this, lvl4.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                } catch (Exception e) {

                }
            }
        });
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(level>=5) {
                        Intent intent = new Intent(GemeLvl.this, lvl5.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                } catch (Exception e) {

                }
            }
        });

      final int[] x ={
              R.id.textView1,R.id.textView2,R.id.textView3,
              R.id.textView4,R.id.textView5,
      };
    for(int i=1; i<level; i++){
        TextView tv = findViewById(x[i]);
        tv.setText(""+(i+1));

    }
    }
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(GemeLvl.this,MainActivity.class );
            startActivity(intent);
            finish();
        }catch (Exception e){

        }

    }

}