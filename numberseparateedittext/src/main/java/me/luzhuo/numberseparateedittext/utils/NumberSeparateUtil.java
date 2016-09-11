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

    public static INumberSeparate.NumberType switchNumberType(AttributeSet attrs) {
        if(INumberSeparate.numberTypeAttrs[0].equals(attrs.getAttributeValue(INumberSeparate.AUTO, "NumberType"))) return INumberSeparate.NumberType.Expand;
        else if(INumberSeparate.numberTypeAttrs[1].equals(attrs.getAttributeValue(INumberSeparate.AUTO, "NumberType"))) return INumberSeparate.NumberType.Phone;
        else if(INumberSeparate.numberTypeAttrs[2].equals(attrs.getAttributeValue(INumberSeparate.AUTO, "NumberType"))) return INumberSeparate.NumberType.BankCard;
        else if(INumberSeparate.numberTypeAttrs[3].equals(attrs.getAttributeValue(INumberSeparate.AUTO, "NumberType"))) return INumberSeparate.NumberType.IdCard;
        else return INumberSeparate.NumberType.Expand;
    }

    /**
     * separate number.
     * @param originalData user input text number.
     * @param numberType number type {@link INumberSeparate.NumberType}
     * @param expandParameter expand parameter callback.
     * @param expandMaxLength expand textcontent max length.
     * @return data separate.
     */
    public static  String separateNumberText(String originalData, INumberSeparate.NumberType numberType, ExpandParameter expandParameter, int expandMaxLength) {
        String data;
        // avoid pasting data.
        if(numberType == INumberSeparate.NumberType.Phone) {
            data = originalData.substring(0, originalData.length() <= INumberSeparate.PHONEMAXLENGTH ? originalData.length() : INumberSeparate.PHONEMAXLENGTH);
        }else if(numberType == INumberSeparate.NumberType.BankCard){
            data = originalData.substring(0, originalData.length() <= INumberSeparate.BANKCARDMAXLENGTH ? originalData.length() : INumberSeparate.BANKCARDMAXLENGTH);
        }else if(numberType == INumberSeparate.NumberType.IdCard){
            data = originalData.substring(0, originalData.length() <= INumberSeparate.IDCARDMAXLENGTH ? originalData.length() : INumberSeparate.IDCARDMAXLENGTH);
        }else if(numberType == INumberSeparate.NumberType.Expand){
            data = originalData.substring(0, originalData.length() <= expandMaxLength ? originalData.length() : expandMaxLength);
        } else {
            data = originalData;
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
                    case Phone:
                        if (x == 3 || x == 7) sbAppend(true, sb, bytes, x);
                        else sbAppend(false, sb, bytes, x);
                        break;
                    case BankCard:
                        if (x == 4 || x == 8 || x == 12 || x == 16) sbAppend(true, sb, bytes, x);
                        else sbAppend(false, sb, bytes, x);
                        break;
                    case IdCard:
                        if (x == 6 || x == 14) sbAppend(true, sb, bytes, x);
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
    public static String getNumberText(String data, INumberSeparate.NumberType numberType){
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
