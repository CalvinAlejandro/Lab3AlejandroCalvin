package com.alejandro.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ValidateSubjects extends AppCompatActivity {

    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate_subjects);
        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);

        FileInputStream reader = null;
        String data = "";
        try {
            reader = openFileInput("subjects.txt");
            int token;

            while((token = reader.read()) != -1)
            {
                data = data + (char)token;
            }
        }
        catch (FileNotFoundException fe)
        {
            fe.printStackTrace();
            Log.d("error", "File not found!");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("error", "IO error...");
        }
        String arrData[] = data.split(",");
        checkBox1.setText(arrData[0]);
        checkBox2.setText(arrData[1]);
        checkBox3.setText(arrData[2]);
        checkBox4.setText(arrData[3]);
        checkBox5.setText(arrData[4]);
        checkBox6.setText(arrData[5]);
        checkBox7.setText(arrData[6]);
        checkBox8.setText(arrData[7]);
    }

    public void showData(View v)
    {
        String chkData = "Enrolled in: ";
        if(checkBox1.isChecked())
        {
            chkData = chkData + ", " +  checkBox1.getText().toString();
        }
        if(checkBox2.isChecked())
        {
            chkData = chkData + ", " + checkBox2.getText().toString();
        }
        if(checkBox3.isChecked())
        {
            chkData = chkData + ", " + checkBox3.getText().toString();
        }
        if(checkBox4.isChecked())
        {
            chkData = chkData + ", " + checkBox4.getText().toString();
        }
        if(checkBox5.isChecked())
        {
            chkData = chkData + ", "+ checkBox5.getText().toString();
        }
        if(checkBox6.isChecked())
        {
            chkData = chkData + ", " + checkBox6.getText().toString();
        }
        if(checkBox7.isChecked())
        {
            chkData = chkData + ", " + checkBox7.getText().toString();
        }
        if(checkBox8.isChecked())
        {
            chkData = chkData + ", " + checkBox8.getText().toString();
        }
        Toast.makeText(this, chkData, Toast.LENGTH_LONG).show();
    }
}
