package id.chacha.desain.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import id.chacha.desain.R;

import id.chacha.desain.activity.halaman.*;

public class MultipleActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);

        btn1 = (Button) findViewById(R.id.btnHal1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), Halaman1.class);
                startActivity(i);
            }
        });

        btn2 = (Button) findViewById(R.id.btnHal2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), Halaman2.class);
                startActivity(i);
            }
        });

        btn3 = (Button) findViewById(R.id.btnHal3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), Halaman3.class);
                startActivity(i);
            }
        });

        btn4 = (Button) findViewById(R.id.btnHal4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), Halaman4.class);
                startActivity(i);
            }
        });

        btn5 = (Button) findViewById(R.id.btnHal5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), Halaman5.class);
                startActivity(i);
            }
        });

        btn6 = (Button) findViewById(R.id.btnHal6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), Halaman6.class);
                startActivity(i);
            }
        });

        btn7 = (Button) findViewById(R.id.btnHal7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), Halaman7.class);
                startActivity(i);
            }
        });

        btn8 = (Button) findViewById(R.id.btnHal8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), Halaman8.class);
                startActivity(i);
            }
        });
    }
}