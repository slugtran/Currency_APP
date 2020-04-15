package vn.edu.hust.edu.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.graphics.Typeface;

public class MainActivity<Sin> extends AppCompatActivity implements View.OnClickListener {
    Spinner spinS;
    Spinner spinD;
    TextView textD;
    TextView textNote;
    TextView textS;
    float rate = 1.f;
    String[] items={"Singapore - Dollar","Europe - Euro", "VietNam - Dong","United States - Dollar", "ThaiLand - Baht"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);

        findViewById(R.id.btnBS).setOnClickListener(this);
        findViewById(R.id.btnCE).setOnClickListener(this);
        findViewById(R.id.btnDot).setOnClickListener(this);

        spinD= findViewById(R.id.spinD);
        spinS= findViewById(R.id.spinS);
        textNote= findViewById(R.id.btnC);
        textD= findViewById(R.id.tv2);
        textS= findViewById(R.id.tv1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinS.setAdapter(adapter);
        spinD.setAdapter(adapter);

        spinD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        switch (id){
            case R.id.btn0: {
                AddDigits("0");
                ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
                break;
            }
            case R.id.btn1:{
                AddDigits("1");
                ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
                break;
            }
            case R.id.btn2:{
                AddDigits("2");
                ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
                break;
            }
            case R.id.btn3:{
                AddDigits("3");
                ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
                break;
            }
            case R.id.btn4:{
                AddDigits("4");
                ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
                break;
            }
            case R.id.btn5:{
                AddDigits("5");
                ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
                break;
            }
            case R.id.btn6:{
                AddDigits("6");
                ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
                break;
            }
            case R.id.btn7:{
                AddDigits("7");
                ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
                break;
            }
            case R.id.btn8:{
                AddDigits("8");
                ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
                break;
            }
            case R.id.btn9:{
                AddDigits("9");
                ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
                break;
            }
            case R.id.btnDot:{
                try {
                    AddDigits(".");
                    ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
                    break;
                }catch(Exception e){
                }
            }
            case R.id.btnBS:{
                CharSequence name= textS.getText().toString();
                if(name.length()==1){
                    textS.setText("0");
                    textD.setText("0");
                }
                else{
                    textS.setText(name.subSequence(0, name.length()-1));
                    ChangeCurrency(spinS.getSelectedItem().toString(), spinD.getSelectedItem().toString(), Float.parseFloat(textS.getText().toString()));
                }
                break;
            }
            case R.id.btnCE:{
                textS.setText("0");
                textD.setText("0");
                break;
            }
        }
    }

    private void AddDigits(String digit){
        if(Float.parseFloat(textS.getText().toString())==0)
            textS.setText("");
        textS.append(digit);
    }

    @SuppressLint("SetTextI18n")
    private void ChangeCurrency(String S, String D, float Sce){
        if(S.equals("Singapore - Dollar") && D.equals("Singapore - Dollar")){
            rate=1.f;
            textNote.setText("1 SGD= "+ rate + " SGD");
            textD.setText(String.valueOf(rate*Sce));
        }

        if(S.equals("Singapore - Dollar")&& D.equals("Europe - Euro")){
            rate= 0.6477f;
            textNote.setText("1 SGD= "+ rate + " EUR");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("Singapore - Dollar")&& D.equals("VietNam - Dong")){
            rate= 16559.7173f;
            textNote.setText("1 SGD= "+ rate + " VNĐ");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("Singapore - Dollar")&& D.equals("United States - Dollar")){
            rate= 0.7067f;
            textNote.setText("1 SGD= "+ rate + " USD");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("Singapore - Dollar")&& D.equals("ThaiLan - Baht")){
            rate= 23.1025f;
            textNote.setText("1 SGD= "+ rate + " THB");
            textD.setText(String.valueOf(rate*Sce));
        }

        if(S.equals("Europe - Euro")&& D.equals("Singapore - Dollar")){
            rate= 1.5439f;
            textNote.setText("1 EUR= "+ rate + " SGD");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("Europe - Euro")&& D.equals("Europe - Euro")){
            rate= 1.f;
            textNote.setText("1 EUR= "+ rate + " EUR");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("Europe - Euro")&& D.equals("VietNam - Dong")){
            rate= 25566.8303f;
            textNote.setText("1 EUR= "+ rate + " VNĐ");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("Europe - Euror")&& D.equals("United States - Dollar")){
            rate= 1.0911f;
            textNote.setText("1 EUR= "+ rate + " USD");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("Europe - Euro")&& D.equals("ThaiLan - Baht")){
            rate= 35.6683f;
            textNote.setText("1 EUR= "+ rate + " THB");
            textD.setText(String.valueOf(rate*Sce));
        }

        if(S.equals("VietNam - Dong")&& D.equals("Singapore - Dollar")){
            rate= 0.00006039f;
            textNote.setText("1 VNĐ= "+ rate + " SGD");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("VietNam - Dong")&& D.equals("Europe - Euro")){
            rate= 0.00003911f;
            textNote.setText("1 VNĐ= "+ rate + " EUR");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("VietNam - Dong")&& D.equals("VietNam - Dong")){
            rate= 1.f;
            textNote.setText("1 VNĐ= "+ rate + " VNĐ");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("VietNam - Dong")&& D.equals("United States - Dollar")){
            rate= 0.00004268f;
            textNote.setText("1 VNĐ= "+ rate + " USD");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("VietNam - Dong")&& D.equals("ThaiLan - Baht")){
            rate= 0.001395f;
            textNote.setText("1 VNĐ= "+ rate + " THB");
            textD.setText(String.valueOf(rate*Sce));
        }

        if(S.equals("United States - Dollar")&& D.equals("Singapore - Dollar")){
            rate= 1.415f;
            textNote.setText("1 USD= "+ rate + " SGD");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("United States - Dollar")&& D.equals("Europe - Euro")){
            rate= 0.9165f;
            textNote.setText("1 USD= "+ rate + " EUR");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("United States - Dollar")&& D.equals("VietNam - Dong")){
            rate= 23432;
            textNote.setText("1 USD= "+ rate + " VND");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("United States - Dollar")&& D.equals("United States - Dollar")){
            rate= 1.f;
            textNote.setText("1 USD= "+ rate + " USD");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("United States - Dollar")&& D.equals("ThaiLan - Baht")){
            rate= 32.69f;
            textNote.setText("1 USD= "+ rate + " THB");
            textD.setText(String.valueOf(rate*Sce));
        }

        if(S.equals("ThaiLan - Baht")&& D.equals("Singapore - Dollar")){
            rate= 0.04329f;
            textNote.setText("1 THB= "+ rate + " SGD");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("ThaiLan - Baht")&& D.equals("Europe - Euro")){
            rate= 0.02804f;
            textNote.setText("1 THB= "+ rate + " EUR");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("ThaiLan - Baht")&& D.equals("VietNam - Dong")){
            rate= 716.7941f;
            textNote.setText("1 THB= "+ rate + " VNĐ");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("ThaiLan - Baht")&& D.equals("United States - Dollar")){
            rate= 0.03059f;
            textNote.setText("1 THB= "+ rate + " USD");
            textD.setText(String.valueOf(rate*Sce));
        }
        if(S.equals("ThaiLan - Baht")&& D.equals("ThaiLan - Baht")){
            rate= 1.f;
            textNote.setText("1 THB= "+ rate + " THB");
            textD.setText(String.valueOf(rate*Sce));
        }
    }
}
