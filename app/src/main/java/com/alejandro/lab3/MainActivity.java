package com.alejandro.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText subj1, subj2, subj3, subj4, subj5, subj6, subj7, subj8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subj1 = findViewById(R.id.editText);
        subj2 = findViewById(R.id.editText2);
        subj3 = findViewById(R.id.editText3);
        subj4 = findViewById(R.id.editText4);
        subj5 = findViewById(R.id.editText5);
        subj6 = findViewById(R.id.editText6);
        subj7 = findViewById(R.id.editText7);
        subj8 = findViewById(R.id.editText8);
    }

    public void writeData(View v)
    {
        String data1 = subj1.getText().toString();
        String data2 = subj2.getText().toString();
        String data3 = subj3.getText().toString();
        String data4 = subj4.getText().toString();
        String data5 = subj5.getText().toString();
        String data6 = subj6.getText().toString();
        String data7 = subj7.getText().toString();
        String data8 = subj8.getText().toString();
        String fulldata = data1 + "," + data2 + "," + data3 + "," + data4 + "," + data5 + "," + data6 + "," + data7 + "," + data8;
        FileOutputStream writer = null;
        try
        {
            writer = openFileOutput("subjects.txt", MODE_PRIVATE);
            writer.write(fulldata.getBytes());
        }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
            Log.d("error", "No file found.");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            Log.d("error", "IO error...");
        }
        finally
        {
            try
            {
                writer.close();
            } catch (IOException e)
            {
                e.printStackTrace();
                Log.d("error", "IO error");
            }
        }
        Toast.makeText(this, "data saved...", Toast.LENGTH_LONG).show();
    }

    public void nextValidate(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ValidateSubjects.class);
        startActivity(intent);
    }
}
