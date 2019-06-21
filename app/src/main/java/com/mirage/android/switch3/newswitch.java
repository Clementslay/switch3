package com.mirage.android.switch3;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class newswitch extends Activity {
    RadioGroup profiles;
    RadioButton sound_profile;
    String profile_name,profile_sound;
    Button locn_btn;
    Button newtohome;
    EditText name;
    ArrayList<String> addArray = new ArrayList<String> ();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newswitch);
        addListenerOnButton();
        name = (EditText) findViewById(R.id.name_switch);


    }
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    public void addListenerOnButton() {

        final Context context = this;

        locn_btn = (Button) findViewById(R.id.button4);
        profiles = (RadioGroup) findViewById(R.id.profiles);


        locn_btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String newEntry = name.getText().toString();
                if (name.length() != 0) {
                    addArray.add(name.getText().toString());


                    Intent intent = new Intent(context, locn.class);
                    intent.putExtra("list",addArray);
                    startActivity(intent);

                } else {
                    toastMessage("Please enter a name for your SWiTcH");
                }



            }

        });

        newtohome = (Button) findViewById(R.id.button2);

        newtohome.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, homepage.class);
                startActivity(intent);

            }

        });

    }

}
