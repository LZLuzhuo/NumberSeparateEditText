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
package me.luzhuo.numberseparateedittext.utils;

import android.text.TextUtils;
import android.util.AttributeSet;

import me.luzhuo.numberseparateedittext.INumberSeparate;
import me.luzhuo.numberseparateedittext.NumberType;
import me.luzhuo.numberseparateedittext.callback.ExpandParameter;

/**
 * =================================================
 * <p>
 * Author: Luzhuo
 * <p>
 * Version: 1.0
 * <p>
 * Creation Date: 2016/8/21 15:54
 * <p>
 * Description:
 * <p>
 * Revision History:
 * <p>
 * Copyright: Copyright 2016 Luzhuo. All rights reserved.
 * <p>
 * =================================================
 **/
public class NumberSeparateUtil {

    public static NumberType switchNumberType(AttributeSet attrs) {
        if(NumberType.Expand.getNumberTypeAttr().equals(attrs.getAttributeValue(INumberSeparate.AUTO, "NumberType"))) return NumberType.Expand;
        else if(NumberType.Phone.getNumberTypeAttr().equals(attrs.getAttributeValue(INumberSeparate.AUTO, "NumberType"))) return NumberType.Phone;
        else if(NumberType.BankCard.getNumberTypeAttr().equals(attrs.getAttributeValue(INumberSeparate.AUTO, "NumberType"))) return NumberType.BankCard;
        else if(NumberType.IdCard.getNumberTypeAttr().equals(attrs.getAttributeValue(INumberSeparate.AUTO, "NumberType"))) return NumberType.IdCard;
        else return NumberType.Expand;
    }

    /**
     * separate number.
     * @param originalData user input text number.
     * @param numberType number type {@link NumberType}
     * @param expandParameter expand parameter callback.
     * @param expandMaxLength expand textcontent max length.
     * @return data separate.
     */
    public static  String separateNumberText(String originalData, NumberType numberType, ExpandParameter expandParameter, int expandMaxLength) {
        String data;
        // avoid pasting data.
        if(numberType == NumberType.Expand){
            data = originalData.substring(0, originalData.length() <= expandMaxLength ? originalData.length() : expandMaxLength);
        } else {
            data = originalData.substring(0, originalData.length() <= numberType.getMaxLength() ? originalData.length() : numberType.getMaxLength());
        }

        char[] bytes = data.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int x = 0; x < bytes.length; x++){
            if(numberType != null) {
                switch (numberType){
                    case Expand:
                        if(expandParameter != null){
                            if(expandParameter.matching(x)) sbAppend(true, sb, bytes, x);
                            else sbAppend(false, sb, bytes, x);
                        }else sbAppend(false, sb, bytes, x);
                        break;
                    default:
                        if (numberType.matching(x)) sbAppend(true, sb, bytes, x);
                        else sbAppend(false, sb, bytes, x);
                        break;
                }
            }else{
                sbAppend(false, sb, bytes, x);
            }
        }
        return sb.toString();
    }

    private static void sbAppend(boolean addSpace,StringBuffer sb, char[] bytes, int x){
        if(addSpace) sb.append(" ");
        sb.append(bytes[x]);
    }

    /**
     * trim data.
     * @param data need to trim data
     * @param numberType number type
     * @return finishing complete data.
     */
    public static String getNumberText(String data, NumberType numberType){
        String text = data.trim();
        char[] bytes = text.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int x = 0; x < bytes.length; x++){
            if(TextUtils.isEmpty(String.valueOf(bytes[x]).trim())) continue;
            else{
                switch (numberType){
                    case IdCard: // 1234567890 valid, any other characters are X.
                        if(bytes[x] >= 48 && bytes[x] <= 57) sb.append(bytes[x]);
                        else sb.append('X'); break;
                    default:
                        if(bytes[x] >= 48 && bytes[x] <= 57) sb.append(bytes[x]);
                        break;
                }
            }
        }
        return sb.toString();
    }
}
