package me.luzhuo.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import me.luzhuo.numberseparateedittext.callback.ExpandParameter;
import me.luzhuo.numberseparateedittext.NumberSeparateEditText;
import me.luzhuo.numberseparateedittext.callback.NumberTextWatcher;

public class MainActivity extends AppCompatActivity {
    private NumberSeparateEditText number;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (NumberSeparateEditText) findViewById(R.id.number);
        text = (TextView) findViewById(R.id.text);

        // 设置自定义分隔,不需要不设置
//        number.setExpand(10, new ExpandParameter(){
//            @Override
//            public boolean matching(int index) {
//                if(index == 3 || index == 6) return true;
//                else return false;
//            }
//        });

        number.addTextChangedListener(watcher);
        // 设置数字文本, 具有自动过滤非数字字符的功能
        number.setNumber("asfdhasfksajr15or8orjslkjfww6ihasf88h8wfayiq7hriaqh8rof8tqitu8534232kaj");
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

    public void startActivity(View v){
        startActivity(new Intent(this, TextViewDemo.class));
    }
}
