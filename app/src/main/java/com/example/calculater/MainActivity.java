package com.example.calculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private  Spinner s;
    private ArrayList<String> sign=new ArrayList<String>();
    private EditText et1,et2;
    private TextView TV1;
    private Button btncalculate;
    double a,b,result;
    ADDITION ADD=new ADDITION();
    SUB SUB=new SUB();
    DIVISION DIV=new DIVISION();
    MULTIPLICATION MUL=new MULTIPLICATION();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncalculate=findViewById(R.id.btncalculate);
        s=(Spinner)findViewById(R.id.spnsign);
        et1=findViewById(R.id.etfirst);
        et2=findViewById(R.id.etsecound);
        TV1=findViewById(R.id.txtanswer);
        sign.add("Select option");
        sign.add("Addition");
        sign.add("Subtraction");
        sign.add("Multiplication");
        sign.add("Division");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,sign);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(dataAdapter);
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=Double.parseDouble(et1.getText().toString());
                b=Double.parseDouble(et2.getText().toString());
                String selected=s.getSelectedItem().toString();
                if(selected.equals("Addition"))
                {
                     result=ADD.sum(a,b);
                    String res=String.valueOf(result);
                    TV1.setText("Result ="+res);
                }
                else if(selected.equals("Subtraction"))
                {
                     result=SUB.sub(a,b);
                    String res=String.valueOf(result);
                    TV1.setText("Result ="+res);
                }
                else if(selected.equals("Multiplication"))
                {
                     result=MUL.Mul(a,b);
                    String res=String.valueOf(result);
                    TV1.setText("Result ="+res);
                }
                else if(selected.equals("Division")){
                    result=DIV.DIV(a,b);
                    String res=String.valueOf(result);
                    if(b==0)
                    {
                        Toast.makeText(MainActivity.this,"Dividen can not be zero",Toast.LENGTH_SHORT).show();
                    }
                    TV1.setText("Result ="+res);
                }
                else if(selected.equals("")){
                    Toast.makeText(MainActivity.this,"Select correct option",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),sign.get(position) , Toast.LENGTH_LONG).show();

    }


    public void onNothingSelected(AdapterView<?> parent) {
       TV1.setText("Please select option");
    }


}