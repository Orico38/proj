package com.example.user.files;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
TextView Upd;
EditText Get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Upd=(TextView)findViewById(R.id.Textv);
        Get=(EditText)findViewById(R.id.edit1);

    }

    public void Send(View view) {
       String s=Get.getText().toString();
       FileOutputStream fos=null;
        try {
            fos = openFileOutput("Input.txt", Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw;
        osw=new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        try {
            bw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void Read(View view) {
        InputStream is=null;
        try {
            is = openFileInput("Input.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader tmp=new InputStreamReader(is);
        BufferedReader reader= new BufferedReader(tmp);
        String str;
        StringBuffer buffer = new StringBuffer();
        try {
            while ((str=reader.readLine()) != null) buffer.append(str + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Upd.setText(buffer);
    }
    }

