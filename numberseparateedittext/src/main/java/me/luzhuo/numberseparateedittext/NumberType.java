/* Copyright 2017 Luzhuo. All rights reserved.
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

import me.luzhuo.numberseparateedittext.callback.ExpandParameter;

import static android.R.attr.x;

/**
 * =================================================
 * <p>
 * Author: Luzhuo
 * <p>
 * Version: 1.0
 * <p>
 * Creation Date: 2017/2/6 19:56
 * <p>
 * Description: 数字类型枚举
 * <p>
 * Revision History:
 * <p>
 * Copyright: Copyright 2017 Luzhuo. All rights reserved.
 * <p>
 * =================================================
 **/
public enum NumberType implements ExpandParameter {

    Expand("0", Integer.MAX_VALUE) {
        @Override
        public boolean matching(int index) {
            return false;
        }
    }, Phone("1", 11) {
        @Override
        public boolean matching(int index) {
            if(index == 3 || index == 7) return true;
            else return false;
        }
    }, BankCard("2", 19) {
        @Override
        public boolean matching(int index) {
            if(index == 4 || index == 8 || index == 12 || index == 16) return true;
            else return false;
        }
    }, IdCard("3", 18) {
        @Override
        public boolean matching(int index) {
            if(index == 6 || index == 14) return true;
            else return false;
        }
    };

    private String numberTypeAttr;
    private int maxLength;

    private NumberType(String numberType, int maxLength){
        this.numberTypeAttr = numberType;
        this.maxLength = maxLength;
    }

    public void setMaxLength(int maxLength){
        this.maxLength = maxLength;
    }

    public int getMaxLength(){
        return maxLength;
    }

    public String getNumberTypeAttr(){
        return numberTypeAttr;
    }

}
