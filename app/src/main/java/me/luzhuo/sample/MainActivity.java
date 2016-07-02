package me.luzhuo.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import me.luzhuo.numberseparateedittext.ExpandParameter;
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

        number.setExpand(10, new ExpandParameter(){
            @Override
            public boolean matching(int index) {
                if(index == 3 || index == 6) return true;
                else return false;
            }
        });

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
