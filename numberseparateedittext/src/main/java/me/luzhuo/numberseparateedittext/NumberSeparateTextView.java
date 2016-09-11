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
import android.util.AttributeSet;
import android.widget.TextView;

import me.luzhuo.numberseparateedittext.callback.ExpandParameter;
import me.luzhuo.numberseparateedittext.utils.NumberSeparateUtil;

/**
 * =================================================
 * <p>
 * Author: Luzhuo
 * <p>
 * Version: 1.0
 * <p>
 * Creation Date: 2016/8/6 10:05
 * <p>
 * Description:
 * <p>
 * Revision History:
 * <p>
 * Copyright: Copyright 2016 Luzhuo. All rights reserved.
 * <p>
 * =================================================
 **/
public class NumberSeparateTextView extends TextView implements INumberSeparate{
    private static final String TAG = NumberSeparateTextView.class.getSimpleName();
    private NumberType numberType;
    private int ExpandMaxLength = Integer.MAX_VALUE; private ExpandParameter expandParameter;

    public NumberSeparateTextView(Context context) {
        super(context);
    }

    public NumberSeparateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setNumberType(NumberSeparateUtil.switchNumberType(attrs));
    }

    public NumberSeparateTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setNumberType(NumberType numtype){
        this.numberType = numtype;
    }

    @Override
    public void setNumber(String numbertext){
        String separateText = NumberSeparateUtil.separateNumberText(NumberSeparateUtil.getNumberText(numbertext, numberType), numberType, expandParameter, ExpandMaxLength);
        this.setText(separateText);
    }

    @Override
    public void setNumber(int numbertext){
        setNumber(String.valueOf(numbertext));
    }

    @Override
    public String getNumber() {
        return NumberSeparateUtil.getNumberText(this.getText().toString(), numberType);
    }

    @Override
    public void setExpand(int numbermax, ExpandParameter expandParameter){
        this.ExpandMaxLength = numbermax;
        this.expandParameter = expandParameter;
        setNumberType(NumberType.Expand);
    }
}
