package com.example.semana7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    Button button2;
    Button button3;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    private void UnSegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                for (int i=1; i<=10; i++){
                    UnSegundo();
                }
                Toast.makeText(getBaseContext(), "Tarea Larga Finalizada", Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                Hilos();
                break;
            case R.id.button3:
                EjemploAsyncTask ejemploAsyncTask = new EjemploAsyncTask();
                ejemploAsyncTask.execute();
                break;
            default:
                break;
        }
    }
    void Hilos(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; 1<=10; i++){
                    UnSegundo();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(),"Tarea Larga Finalizada", Toast.LENGTH_LONG).show();
                    }
                });
            }
        }).start();
    }
}