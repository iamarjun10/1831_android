package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView Screen,Ans_Screen;
    private Button AC,Back,Power,Div,Mul,Add,Sub,Equal,Btn9,Btn8,Btn7,Btn6,Btn5,Btn4,Btn3,Btn2,Btn1,Btn0,Percent,Point;
    private String input,Answer = "0",temp;
    private boolean flag = false,sign_flag=false,dot_flag=false,pow_flag=true,Nzero_flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen = (TextView) findViewById(R.id.screen);
        Ans_Screen = (TextView) findViewById(R.id.ans_screen);
        AC = (Button) findViewById(R.id.ac);
        Back = (Button) findViewById(R.id.del);
        Power = (Button) findViewById(R.id.power);
        Div = (Button) findViewById(R.id.div);
        Mul = (Button) findViewById(R.id.mul);
        Add = (Button) findViewById(R.id.add);
        Sub = (Button) findViewById(R.id.sub);
        Equal = (Button) findViewById(R.id.equal);
        Btn9 = (Button) findViewById(R.id.btn9);
        Btn8 = (Button) findViewById(R.id.btn8);
        Btn7 = (Button) findViewById(R.id.btn7);
        Btn6 = (Button) findViewById(R.id.btn6);
        Btn5 = (Button) findViewById(R.id.btn5);
        Btn4 = (Button) findViewById(R.id.btn4);
        Btn3 = (Button) findViewById(R.id.btn3);
        Btn2 = (Button) findViewById(R.id.btn2);
        Btn1 = (Button) findViewById(R.id.btn1);
        Btn0 = (Button) findViewById(R.id.btn0);
        Percent = (Button) findViewById(R.id.percent);
        Point = (Button) findViewById(R.id.point);

        AC.setOnClickListener(this);
        Back.setOnClickListener(this);
        Power.setOnClickListener(this);
        Div.setOnClickListener(this);
        Mul.setOnClickListener(this);
        Add.setOnClickListener(this);
        Sub.setOnClickListener(this);
        Equal.setOnClickListener(this);
        Btn9.setOnClickListener(this);
        Btn8.setOnClickListener(this);
        Btn7.setOnClickListener(this);
        Btn6.setOnClickListener(this);
        Btn5.setOnClickListener(this);
        Btn4.setOnClickListener(this);
        Btn3.setOnClickListener(this);
        Btn2.setOnClickListener(this);
        Btn1.setOnClickListener(this);
        Btn0.setOnClickListener(this);
        Percent.setOnClickListener(this);
        Point.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "AC" :
                input = "";
                Answer = "";
                flag = false;
                sign_flag=false;
                dot_flag=false;
                pow_flag=true;
                Nzero_flag = false;
                temp = "";
                break;
            case "%" :
                if(input.length()==0) {
                    input = "";
                }else{
                    try {
                        double div = Double.parseDouble(input)/100;
                        input =div + "";
                        Answer = div + "";
                    }
                    catch (Exception e){

                    }
                }
                break;
            case "=" :
                flag = true;
                temp = input;
                Solve();
//                Answer = input;
                break;
            case "del" :
                if(input.length()==0) {
                    input = "";
                }else {
                    if (flag == false) {
                        if (input.endsWith("-") || input.endsWith("+") || input.endsWith("/") || input.endsWith("*")) {
                            sign_flag = false;
                        } else if (input.endsWith(".")) {
                            dot_flag = false;
                        } else if (input.endsWith("^")) {
                            pow_flag = true;
                        } else if (input.endsWith("1") || input.endsWith("2") || input.endsWith("3") || input.endsWith("4") || input.endsWith("5") || input.endsWith("6") || input.endsWith("7") || input.endsWith("8") || input.endsWith("9")) {
                            Nzero_flag = false;
                        }
                        String newText = input.substring(0, input.length() - 1);
                        if (newText.length() == 0)
                            input = "";
                        else
                            input = newText;
                    }
                }
                break;
            default:
                if (input == null){
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/") || data.equals("*")){
                    //Solve();
                    if(data.equals("+") && input.isEmpty() || data.equals("*") && input.isEmpty() || data.equals("/") && input.isEmpty() || data.equals("^") && input.isEmpty()){

                    }else if(flag == true) {
                        if(Answer.equals("can't divide by zero")) {
                            Answer = "0";
                        }
                        input = Answer;
                        input += data;
                        flag = false;
                    }
                    else{
                        if(sign_flag == false) {
                            input += data;   //check no.10 needed
                            sign_flag = true;
                            dot_flag = false;
                        }
                    }
                    Nzero_flag = false;
                }else {
                    if (flag==true) {
                        if(data.equals("^")){
                            input = Answer;
                            input +=data;
                            pow_flag = true;
                        }else {
                            Answer = "";
                            if (data.equals(".")) {
                                if (dot_flag == false) {
                                    input = data;
                                    dot_flag = true;
                                }
                            } else {
                                input = data;
                            }
                        }
                        flag = false;
                    }
                    else{
                        if(data.equals(".")) {
                            if(dot_flag == false) {
                                input += data;
                                dot_flag = true;
                            }
                        }else{
                            if(data.equals("^")){
                                if(pow_flag == false){
                                    input += data;
                                    pow_flag = true;
                                }
                            }
                            else {
                                if(data.equals("0") && input.endsWith("0") && dot_flag==false){
                                    //
                                }else{
                                    if (data.equals("1") || data.equals("2") || data.equals("3") || data.equals("4") || data.equals("5") || data.equals("6") || data.equals("7") || data.equals("8") || data.equals("9") ){
                                        Nzero_flag = true;
                                    }
                                    input += data;
                                    pow_flag = false;
                                }
                            }
                        }
                    }
                    sign_flag = false;

                }
        }
        Screen.setText(input);
        Ans_Screen.setText(Answer);

    }

    private void Solve(){
        if (temp.split("\\*").length==2){
            String number[]=temp.split("\\*");
            try {
                double mul = Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                temp = mul + "";
            }
            catch (Exception e){
                //
            }
        }
        else if (temp.split("/").length==2){
            String number[]=temp.split("/");
            try {
                if ( Double.parseDouble(number[1]) == 0.0) {
                    Answer = "can't divide by zero";
                }
                else{
                    double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                    temp = div + "";
                }
            }
            catch (Exception e){

            }
        }
        else if (temp.split("\\^").length==2){
            String number[]=temp.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                temp = pow + "";
            }
            catch (Exception e){

            }
        }
        else if (temp.split("-").length>1){
            String number[]=temp.split("-");
            if (number[0] == "" && number.length==2){    //if the 1st no. is zero
                number[0] = 0 + "";
            }
            try {
                double sub = 0;
                if (number.length == 2) {
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if (number.length == 3){
                    sub = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                temp = sub + "";
            }
            catch (Exception e){

            }
        }
        else if (temp.split("\\^").length==2){
            String number[]=temp.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                temp = pow + "";
            }
            catch (Exception e){

            }
        }
        else if (temp.split("\\+").length==2){
            String number[]=temp.split("\\+");
            try {
                double sum = Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                temp = sum + "";
            }
            catch (Exception e){
                //
            }
        }
        //to display 10.0 as 10
        String n[] = temp.split("\\.");
        if (n.length>1){
            if (n[1].equals("0")){
                temp = n[0];
            }
        }

        Screen.setText(temp);
        if (Answer.equals("can't divide by zero")){
            Ans_Screen.setText(Answer);
        }else{
            Answer = temp;
            Ans_Screen.setText(Answer);
        }
        pow_flag = false;
    }

}