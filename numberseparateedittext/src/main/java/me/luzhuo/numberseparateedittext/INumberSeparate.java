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

import me.luzhuo.numberseparateedittext.callback.ExpandParameter;

/**
 * =================================================
 * <p>
 * Author: Luzhuo
 * <p>
 * Version: 1.0
 * <p>
 * Creation Date: 2016/8/21 17:41
 * <p>
 * Description:
 * <p>
 * Revision History:
 * <p>
 * Copyright: Copyright 2016 Luzhuo. All rights reserved.
 * <p>
 * =================================================
 **/
public interface INumberSeparate {
    String AUTO = "http://schemas.android.com/apk/res-auto";

    /**
     * set number type.
     * @param numtype NumberType {@link me.luzhuo.numberseparateedittext.NumberType}
     */
    void setNumberType(NumberType numtype);

    /**
     * get number string.
     * @return number.
     */
    String getNumber();

    /**
     * set number
     * @param number int type number content.
     */
    void setNumber(int number);

    /**
     * set number
     * @param number String type number content.
     */
    void setNumber(String number);

    /**
     * set expand
     * @param numbermax Limit the length.
     * @param expandParameter If it is null, don't break up, or implement ExpandParameter interface
     */
    void setExpand(int numbermax, ExpandParameter expandParameter);

}
