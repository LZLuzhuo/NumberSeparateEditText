package me.luzhuo.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import me.luzhuo.numberseparateedittext.NumberSeparateEditText;
import me.luzhuo.numberseparateedittext.NumberTextWatcher;

public class MainActivity extends AppCompatActivity {
    private NumberSeparateEditText number;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (NumberSeparateEditText) findViewById(R.id.number);
        text = (TextView) findViewById(R.id.text);

        number.addTextChangedListener(watcher);
    }

    NumberTextWatcher watcher = new NumberTextWatcher(){
        @Override
        public void onTextChanged(String s) {
            System.out.println("NumberText=====:"+ s);
        }
    };

    public void button(View v){
        text.setText(number.getNumber());
    }
}
