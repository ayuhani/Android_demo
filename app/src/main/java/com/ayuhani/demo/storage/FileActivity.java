package com.ayuhani.demo.storage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.ayuhani.demo.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileActivity extends AppCompatActivity {

    private EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        etInput = findViewById(R.id.et_input);

        String text = load();
        if (!TextUtils.isEmpty(text)) {
            etInput.setText(text);
            etInput.setSelection(text.length());
            Toast.makeText(this, "Restoring succeed", Toast.LENGTH_SHORT).show();
        }

    }

    private String load() {
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            fileInputStream = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String text = etInput.getText().toString();
        save(text);
    }

    private void save(String text) {
        FileOutputStream fileOutputStream = null;
        BufferedWriter writer = null;
        try {
            fileOutputStream = openFileOutput("data", MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            writer.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
