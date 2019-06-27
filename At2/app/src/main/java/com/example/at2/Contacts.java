package com.example.at2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Contacts extends AppCompatActivity {

    ArrayList<EditText> phoneList = new ArrayList<EditText>();
    LinearLayout phones;
    int phoneId = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        phones = (LinearLayout) findViewById(R.id.phones);
    }

    public void addPhone(View view) {

        EditText newPhone = new EditText(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.topMargin = 8;
        params.bottomMargin = 8;
        newPhone.setLayoutParams(params);
        phoneList.add(newPhone);
        newPhone.setHint("Telefone");

        phones.addView(newPhone);
        phoneId++;

    }
    public void saveContact(View view) {

        LinearLayout contactList = (LinearLayout) findViewById(R.id.contacts);
        EditText name = (EditText) findViewById(R.id.name);

        TextView nameContact = new TextView(this);
        LinearLayout.LayoutParams nameParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        nameParams.width = 300;
        nameContact.setLayoutParams(nameParams);
        nameContact.setText(name.getText());

        LinearLayout contact = new LinearLayout(this);
        LinearLayout.LayoutParams contactParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        contactParams.topMargin = 8;
        contactParams.bottomMargin = 8;
        contact.setLayoutParams(contactParams);
        contact.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout contactPhones = new LinearLayout(this);
        LinearLayout.LayoutParams contactPhonesParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        contactPhonesParams.width = 300;
        contactPhones.setLayoutParams(contactPhonesParams);
        contactPhones.setOrientation(LinearLayout.VERTICAL);

        contactList.addView(contact);
        contact.addView(nameContact);
        contact.addView(contactPhones);

        EditText phone = (EditText) findViewById(R.id.phone1);

        TextView phoneTV = new TextView(this);
        LinearLayout.LayoutParams phoneParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        phoneTV.setLayoutParams(phoneParams);

        if(phone.getText().toString().isEmpty()){
            phoneTV.setText("");
        }else{
            phoneTV.setText(phone.getText().toString());
        }
        contactPhones.addView(phoneTV);

        phone.setText("");

        for (int i = 0; i < phoneList.size(); i++){
            phone = phoneList.get(i);

            phoneTV = new TextView(this);
            phoneTV.setLayoutParams(phoneParams);
            if(phone.getText().toString().isEmpty()){
                phoneTV.setText("");
            }else{
                phoneTV.setText(phone.getText().toString());
            }
            contactPhones.addView(phoneTV);

            phones.removeView(phone);
        }

        /*for( int i = 0; i < phones.getChildCount(); i++ ) {
            if (phones.getChildAt(i) instanceof EditText){
                EditText phone = (EditText) findViewById(phones.getChildAt(i).getId());

                TextView phoneTV = new TextView(this);
                LinearLayout.LayoutParams phoneParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                phoneTV.setLayoutParams(phoneParams);

                if(phone.getText().toString().isEmpty()){
                    phoneTV.setText("");
                }else{
                    phoneTV.setText(phone.getText().toString());
                }
                contactPhones.addView(phoneTV);

                phone.setHint("Telefone");
            }
        }*/

        name.setText("");
    }
}
