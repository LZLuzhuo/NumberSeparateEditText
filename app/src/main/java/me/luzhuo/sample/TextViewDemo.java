package me.luzhuo.sample;

import android.app.Activity;
import android.os.Bundle;

import me.luzhuo.numberseparateedittext.NumberSeparateTextView;
import me.luzhuo.numberseparateedittext.callback.ExpandParameter;

public class TextViewDemo extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);

        NumberSeparateTextView textview = (NumberSeparateTextView) findViewById(R.id.textview);

        // 设置自定义分隔,不需要不设置
//        textview.setExpand(10, new ExpandParameter(){
//            @Override
//            public boolean matching(int index) {
//                if(index == 3 || index == 6) return true;
//                else return false;
//            }
//        });

        // 设置数字文本, 具有自动过滤非数字字符的功能
        textview.setNumber("asfdhasfksajr15or8orjslkjfww6ihasf88h8wfayiq7hriaqh8rof8tqitu8534232kaj");
    }
}
