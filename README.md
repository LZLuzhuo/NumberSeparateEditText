# NumberSeparateEditText
---
英文 | [中文](https://github.com/LZLuzhuo/NumberSeparateEditText/blob/master/CREADME.md)  

Separated some common digital information input by the user, such as a telephone number, bank card number, etc. 

 - NumberSeparateEditText:
	 - **Phone**:  
		![](/screenshot/NumberSeparateEditText01.gif)  
	 - **BankCard**:  
		![](/screenshot/NumberSeparateEditText02.gif)  
	 - **IdCard**:  
		![](/screenshot/NumberSeparateEditText03.gif)  

 - NumberSeparateTextView:
	 - **Phone**  
	 	![](/screenshot/NumberSeparateEditText06.png)  
	 - etc.

## Gradle

	dependencies {
	    ...
	    compile 'me.luzhuo.numberseparateedittext:numberseparateedittext:1.1.0'
	}


## Usage

	xmlns:app="http://schemas.android.com/apk/res-auto"

	// NumberSeparateEditText
	<me.luzhuo.numberseparateedittext.NumberSeparateEditText
	        android:id="@+id/number"
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content"
	        app:NumberType="Phone"/>

	// NumberSeparateTextView
    <me.luzhuo.numberseparateedittext.NumberSeparateTextView
	        android:id="@+id/number"
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content"
	        app:NumberType="Phone" />


##### Set input number type:
	xml: app:NumberType="Phone"
	code: setNumberType(NumberType numtype);

	parameters: Phone / BankCard / IdCard .

##### get number:
	code: String getNumber();

##### set number:
	code: setNumber(int number);
		  setNumber(String number);

##### set NumberSeparateEditText input change listener:
	// NumberSeparateEditText unique method
	code: addTextChangedListener(NumberTextWatcher textWatcher);

#### set NumberSeparateEditText input expand:
	code: setExpand(int numbermax, ExpandParameter expandParameter);

	demo:  
		number.setExpand(10, new ExpandParameter(){
		    @Override
		    public boolean matching(int index) {
		        if(index == 3 || index == 6) return true;
		        else return false;
		    }
		});

![](/screenshot/NumberSeparateEditText05.png)

## Special note:
- IdCard: input digital display, input other characters will be replaced with X.

## About author

Luzhuo  
Email: `LZ.Luzhuo@gmail.com`  
Blog: `http://blog.csdn.net/Rozol/article/details/51811330`  


## License

	Copyright 2016 Luzhuo. All rights reserved.
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	    http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.