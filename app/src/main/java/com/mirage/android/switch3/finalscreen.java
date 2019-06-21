package com.mirage.android.switch3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class finalscreen extends Activity {
    Button hometomain1;
    Button new_btn1;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalscreen);
        addListenerOnButton();
    }
    public void addListenerOnButton() {

        final Context context = this;

        hometomain1 = (Button) findViewById(R.id.button21);
        new_btn1 = (Button) findViewById(R.id.newswitch1);

        hometomain1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });
        new_btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, newswitch.class);
                startActivity(intent);

            }

        });
    }
}