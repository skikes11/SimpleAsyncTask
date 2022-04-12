package com.example.simpleasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    TextView textViewTitle;
    ProgressBar pbLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CongViec().execute();
            }
        });



    }

    private class CongViec extends AsyncTask<Void, String, String> {

        @Override
        protected void onPreExecute() {
            textViewTitle.setText("Napping...");
        }

        @Override
        protected String doInBackground(Void... voids) {
            int cur = 1;

            while(pbLoad.getProgress() < pbLoad.getMax()){
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pbLoad.setProgress(cur);
                cur ++;
            }

            return "Complete...";
        }

        @Override
        protected void onPostExecute(String s) {
            textViewTitle.setText("Complete");
            super.onPostExecute(s);
        }
    }

    private void Mapping(){
        btnStart = (Button) findViewById(R.id.btnStart);
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        pbLoad = (ProgressBar) findViewById(R.id.progressBar);
    }
}