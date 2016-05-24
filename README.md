# NumberSeparateEditText
---

Separated some common digital information input by the user, such as a telephone number, bank card number, etc.  
![](/screenshot/NumberSeparateEditText01.gif)  
![](/screenshot/NumberSeparateEditText02.gif)  

## Gradle

	dependencies {
	    ...
	    compile 'me.luzhuo.numberseparateedittext:numberseparateedittext:1.0.4'
	}


## Usage

	xmlns:app="http://schemas.android.com/apk/res-auto"


	<me.luzhuo.numberseparateedittext.NumberSeparateEditText
	        android:id="@+id/number"
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content"
	        app:NumberType="Phone"/>


##### Set input number type:
	xml: app:NumberType="Phone"
	code: setNumberType(NumberType numtype);

	parameters: Phone / BankCard .

##### get number:
	code: String getNumber();

##### set NumberSeparateEditText input change listener:
	code: addTextChangedListener(NumberTextWatcher textWatcher)


## About author

Luzhuo  
Email:LZ.Luzhuo@gmail.com  
Blog:


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