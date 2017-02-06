# NumberSeparateEditText
---
[英文](https://github.com/LZLuzhuo/NumberSeparateEditText/blob/master/README.md) | 中文 

分隔一些常见的用户输入的数字信息,如电话号码,银行卡号等。 

 - 输入分隔:
	 - **Phone**:  
		![](/screenshot/NumberSeparateEditText01.gif)  
	 - **BankCard**:  
		![](/screenshot/NumberSeparateEditText02.gif)  
	 - **IdCard**:  
		![](/screenshot/NumberSeparateEditText03.gif)  

 - 文本分隔:
	 - **Phone**  
	 	![](/screenshot/NumberSeparateEditText06.png)  
	 - 其他省略...

## Gradle

	dependencies {
	    ...
	    compile 'me.luzhuo.numberseparateedittext:numberseparateedittext:1.1.0'
	}


## 使用

	xmlns:app="http://schemas.android.com/apk/res-auto"

	// 输入分隔
	<me.luzhuo.numberseparateedittext.NumberSeparateEditText
	        android:id="@+id/number"
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content"
	        app:NumberType="Phone"/>

	// 文本
    <me.luzhuo.numberseparateedittext.NumberSeparateTextView
	        android:id="@+id/number"
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content"
	        app:NumberType="Phone" />


##### 设置输入类型:
	xml: app:NumberType="Phone"
	code: setNumberType(NumberType numtype);

	parameters: Phone / BankCard / IdCard .

##### 获取数字文本:
	code: String getNumber();

##### 设置数字文本:
	code: setNumber(int number);
		  setNumber(String number);

##### 设置输入监听:
	// NumberSeparateEditText 特有的方法
	code: addTextChangedListener(NumberTextWatcher textWatcher);

#### 设置输入扩展:
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

## 注意:
- IdCard: 输入数字显示数字,输入其他字符将被替换为X.

## 关于作者

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