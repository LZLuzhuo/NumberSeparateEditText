/* Copyright 2016 Luzhuo. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.luzhuo.numberseparateedittext;

import android.content.Context;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import me.luzhuo.numberseparateedittext.callback.ExpandParameter;
import me.luzhuo.numberseparateedittext.callback.NumberTextWatcher;
import me.luzhuo.numberseparateedittext.callback.impl.TextWatcherImpl;
import me.luzhuo.numberseparateedittext.utils.NumberSeparateUtil;

/**
 * =================================================
 * <p>
 * Author: Luzhuo
 * <p>
 * Version: 1.0
 * <p>
 * Creation Date: 2016/5/17 14:07
 * <p>
 * Description:<pre>
 * Number input separate widget:
 *     NumberType.Expand : expand
 *     NumberType.Phone : eleven phone number 3-4-4
 *     NumberType.BankCard : sixteen or nineteen card number 4-4-4-4-3
 *     NumberType.IdCard : Eighteen idcard number 6-8-4 </pre>
 * <p>
 * Revision History:
 * <p>
 * Copyright: Copyright 2016 Luzhuo. All rights reserved.
 * <p>
 * =================================================
 **/
public class NumberSeparateEditText extends EditText implements INumberSeparate{
    private static final String TAG = NumberSeparateEditText.class.getSimpleName();
    private NumberType numberType;
    private int ExpandMaxLength = Integer.MAX_VALUE; private ExpandParameter expandParameter;

    public NumberSeparateEditText(Context context) {
        super(context);
        initData();
    }

    public NumberSeparateEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        setNumberType(NumberSeparateUtil.switchNumberType(attrs));
        initData();
    }

    public NumberSeparateEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initData();
    }

    private void initData() {
        this.addTextChangedListener(watcher);
    }

    @Override
    public void setNumberType(NumberType numtype){
        this.numberType = numtype;

        switch (numtype){
            case IdCard: this.setInputType(InputType.TYPE_CLASS_PHONE); break;
            default: this.setInputType(InputType.TYPE_CLASS_NUMBER); break;
        }
    }

    private boolean isRun = false;
    TextWatcher watcher = new TextWatcherImpl() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Perform only user input data, callback setText () method to filter.
            if(isRun){
                isRun = false;
                return;
            }
            isRun = true;

            // Log.e(TAG, "CharSequence" + s.toString());

            setNumber(s.toString());
            if(textWatcher != null) textWatcher.onTextChanged(getNumber());
        }
    };

    @Override
    public String getNumber() {
        return NumberSeparateUtil.getNumberText(this.getText().toString(), numberType);
    }

    @Override
    public void setNumber(int number){
        setNumber(String.valueOf(number));
    }

    @Override
    public void setNumber(String number){
        // data processing
        String separateText = NumberSeparateUtil.separateNumberText(NumberSeparateUtil.getNumberText(number, numberType), numberType, expandParameter, ExpandMaxLength);
        NumberSeparateEditText.this.setText(separateText);
        NumberSeparateEditText.this.setSelection(separateText.length());
    }

    private NumberTextWatcher textWatcher;
    /**
     * set edittext change listener.
     * @param textWatcher NumberTextWatcher interface.
     */
    public void addTextChangedListener(NumberTextWatcher textWatcher){
        this.textWatcher = textWatcher;
    }

    @Override
    public void setExpand(int numbermax, ExpandParameter expandParameter){
        this.ExpandMaxLength = numbermax;
        this.expandParameter = expandParameter;
        setNumberType(NumberType.Expand);
    }
}
