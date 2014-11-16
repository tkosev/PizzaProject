package com.example.vtpizzas;
 

import android.app.Activity;
import android.os.Bundle;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import android.telephony.SmsManager;
import android.text.Editable;
 
public class MainActivity extends Activity implements OnCheckedChangeListener{
  
  private RadioGroup radioGroup;
  private RadioGroup Shape;
  private EditText name;
  private EditText phone;
  private EditText a;
  private CheckBox peperoni;
  private CheckBox mushrooms;
  private CheckBox veggies;
  private CheckBox anchovies;
  private String vl;
  private String radio1;
  private String radio2;
  private String check;
  OnClickListener checkBoxListener;
 // Context context = getApplicationContext();
  String textt = "Please fill your name and Number and check atleast one topping";
  //int duration = Toast.LENGTH_SHORT;
  private Button btnSendSM;
 
  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	
	radioGroup = (RadioGroup) findViewById(R.id.radioSex);
	radioGroup.setOnCheckedChangeListener(this);
	Shape = (RadioGroup) findViewById(R.id.PizzaShape);
	Shape.setOnCheckedChangeListener(this);
	btnSendSM = (Button) findViewById(R.id.btnSendSM);
	name = (EditText) findViewById(R.id.name);
	phone = (EditText) findViewById(R.id.phone);
	peperoni = (CheckBox) findViewById(R.id.checkBox1);
    mushrooms = (CheckBox) findViewById(R.id.checkBox2);
    veggies = (CheckBox) findViewById(R.id.checkBox3);
    anchovies = (CheckBox) findViewById(R.id.checkBox4); 
    peperoni.setOnClickListener(checkBoxListener);
    mushrooms.setOnClickListener(checkBoxListener);
    veggies.setOnClickListener(checkBoxListener);
    anchovies.setOnClickListener(checkBoxListener);
    
    
    btnSendSM.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v)
		{   Boolean ischecked = false;
			if(peperoni.isChecked()){
				check = " Topping-peperoni";
				ischecked = true;
			}
			if(mushrooms.isChecked()){
				check = " Topping-mushrooms";
				ischecked = true;
			}
			if(veggies.isChecked()){
				check = " Topping-veggies";
				ischecked = true;
			}
			if(anchovies.isChecked()){
				check = " Topping-anchovies";
				ischecked = true;
			}
		Editable phonetext = phone.getText();
		Editable nametext = name.getText();
		  
			vl = nametext +"-" +phonetext+"-";
			String text =vl+radio2+radio1+check;
			
			if(vl != null && vl.length() != 0){
				if(ischecked==true){
				
				sendSMS("5554", text);
				 Toast.makeText(getApplicationContext(), 
                         "Your order has been sent ", Toast.LENGTH_LONG).show();
				}
				else{	
				    Toast.makeText(getApplicationContext(), 
                            "Please choose at least one toping", Toast.LENGTH_LONG).show();
				}
			}
			else{
			    Toast.makeText(getApplicationContext(), 
                        "Please fill your name and PhoneNumber", Toast.LENGTH_LONG).show();
			}
			
		
		}

	
	}); {
		
	}
  }
 
  
  @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//---sends an SMS message to another device---
	private void sendSMS(String phoneNumber, String message)
	{
	SmsManager sms = SmsManager.getDefault();
	sms.sendTextMessage(phoneNumber, null, message, null, null);
	}

	

@Override
public void onCheckedChanged(RadioGroup arg0, int arg1) {
	// TODO Auto-generated method stub
	switch(arg1){
	case R.id.Cheese:
		 radio1 = " with cheese-";
		break;
	case R.id.xCheese:
		radio1 =" with double cheese-";
		break;
	case R.id.None:
		radio1 =" with no cheese-";
		break;
	case R.id.Round:
		radio2 ="Round pizza";
		break;
	case R.id.Square:
		radio2 ="Square pizza";
		break;
	}
	
}
}