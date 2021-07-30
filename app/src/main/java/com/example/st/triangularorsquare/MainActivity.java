package com.example.st.triangularorsquare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void checkTheNum(View view){
        Log.i("Info", "Button Pressed!");
        EditText text = (EditText) findViewById(R.id.number);
        String result;
        if(text.getText().toString().isEmpty()){
            result="Please Enter a number";
        }
        else {
            int num = Integer.parseInt(text.getText().toString());
            CheckNum number = new CheckNum(num);

            if (number.isSquare()) {
                if (number.isTriangular()) {
                    result = "the number " + num + " is both tringular and square";
                } else {
                    result = "the number " + num + " is square";
                }
            } else if (number.isTriangular()) {
                result = "the number " + num + " is tringular";
            } else
                result = "the number " + num + " is neither tringular nor square";
        }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
class CheckNum{
    int num;
    CheckNum(int num){
        this.num = num;
    }
    public boolean isSquare(){
        double afterSqurt =Math.sqrt(num);
        if(afterSqurt == (int)afterSqurt){
            return true;
        }
        else return false;
    }

    public boolean isTriangular(){
        int count =1;
        int stop=0;
        while(true){
            stop = count*(count+1)/2;
            if(num == stop)
                return true;

            count++;
            if(stop>num)
                return false;
        }
    }
}
