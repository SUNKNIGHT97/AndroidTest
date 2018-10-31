package com.example.teamo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamo.myapplication.Calculator_pack.CalcTool;

public class Calculator extends AppCompatActivity {
    String str_Result = "";
    // 存放运算符
    String str_Oper = "";
    // 单个字符
    char str_char;
    // 存放结果
    double valueResult;
    String context;
    private StringBuffer str=new StringBuffer();
    private void refresh(TextView textView){
        int offset=textView.getLineHeight()*textView.getLineCount();
        if(offset>(textView.getHeight())){
            textView.scrollTo(0,offset-textView.getHeight());
        }
        else {
            textView.scrollTo(0, 0);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        final TextView txtResult=(TextView)findViewById(R.id.textResult);
        Button btnOne=(Button)findViewById(R.id.buttonOne);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    if (CalcTool.isDigitEnd(str_Result)) {
                        str = new StringBuffer();
                        str.append("1");
                        str_Result = "";
                    }
                    else {
                        str.append("1");
                    }
                }
                else {
                    str.append("1");
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnTwo=(Button)findViewById(R.id.buttonTwo);
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    if (CalcTool.isDigitEnd(str_Result)) {
                        str = new StringBuffer();
                        str.append("2");
                        str_Result = "";
                    }
                    else {
                        str.append("2");
                    }
                }
                else {
                    str.append("2");
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                       refresh(txtResult);
                    }
                });
            }
        });
        Button btnThree=(Button)findViewById(R.id.buttonThree);
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    if (CalcTool.isDigitEnd(str_Result)) {
                        str = new StringBuffer();
                        str.append("3");
                        str_Result = "";
                    }
                    else {
                        str.append("3");
                    }
                }
                else {
                    str.append("3");
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnFour=(Button)findViewById(R.id.buttonFour);
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    if (CalcTool.isDigitEnd(str_Result)) {
                        str = new StringBuffer();
                        str.append("4");
                        str_Result = "";
                    }
                    else {
                        str.append("4");
                    }
                }
                else {
                    str.append("4");
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnFive=(Button)findViewById(R.id.buttonFive);
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    if (CalcTool.isDigitEnd(str_Result)) {
                        str = new StringBuffer();
                        str.append("5");
                        str_Result = "";
                    }
                    else {
                        str.append("5");
                    }
                }
                else {
                    str.append("5");
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnSix=(Button)findViewById(R.id.buttonSix);
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    if (CalcTool.isDigitEnd(str_Result)) {
                        str = new StringBuffer();
                        str.append("6");
                        str_Result = "";
                    }
                    else {
                        str.append("6");
                    }
                }
                else {
                    str.append("6");
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnSeven=(Button)findViewById(R.id.buttonSeven);
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    if (CalcTool.isDigitEnd(str_Result)) {
                        str = new StringBuffer();
                        str.append("7");
                        str_Result = "";
                    }
                    else {
                        str.append("7");
                    }
                }
                else {
                    str.append("7");
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnEight=(Button)findViewById(R.id.buttonEight);
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    if (CalcTool.isDigitEnd(str_Result)) {
                        str = new StringBuffer();
                        str.append("8");
                        str_Result = "";
                    }
                    else {
                        str.append("8");
                    }
                }
                else {
                    str.append("8");
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnNine=(Button)findViewById(R.id.buttonNine);
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    if (CalcTool.isDigitEnd(str_Result)) {
                        str = new StringBuffer();
                        str.append("9");
                        str_Result = "";
                    }
                    else {
                        str.append("9");
                    }
                }
                else {
                    str.append("9");
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnZero=(Button)findViewById(R.id.buttonZero);
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    if (CalcTool.isDigitEnd(str_Result)) {
                        str = new StringBuffer();
                        str.append("0");
                        str_Result = "";
                    }
                    else {
                        str.append("0");
                    }
                }
                else {
                    str.append("0");
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnClear=(Button)findViewById(R.id.buttonClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = str.delete(0, str.length());
                txtResult.setText(str);
                refresh(txtResult);
            }
        });
        Button btnDivision=(Button)findViewById(R.id.buttonDivide);
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    str_char = str.charAt(str
                            .length() - 1);
                    if (Character.isDigit(str_char)) {
                        str_Oper = "/";
                        str.append("/");
                        txtResult.setText(str.toString());
                    }
                }
                else{
                    str.append("");
                    txtResult.setText(str.toString());
                }
                if(CalcTool.isDigitEnd(str_Result)){
                    str.deleteCharAt(0);
                    str_Result = str.toString();
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnMultiplication=(Button)findViewById(R.id.buttonMultiply);
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    str_char = str.charAt(str
                            .length() - 1);
                    if (Character.isDigit(str_char)) {
                        str_Oper = "*";
                        str.append("*");
                        txtResult.setText(str.toString());
                    }
                }
                else{
                    str.append("");
                    txtResult.setText(str.toString());
                }
                if(CalcTool.isDigitEnd(str_Result)){
                    str.deleteCharAt(0);
                    str_Result = str.toString();
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnMinus=(Button)findViewById(R.id.buttonMinus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_Oper = "-";
                if (str.length() != 0) {
                    str_char = str.charAt(str.length() - 1);
                    if (Character.isDigit(str_char)) {
                        str.append(str_Oper);
                        txtResult.setText(str.toString());
                    }
                }
                if (str.length() == 0) {
                    str.append("-");
                    txtResult.setText(str.toString());
                }
                if(CalcTool.isDigitEnd(str_Result)){
                    str.deleteCharAt(0);
                    str_Result = str.toString();
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnPlus=(Button)findViewById(R.id.buttonPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() != 0) {
                    str_char = str.charAt(str.length() - 1);
                    if (Character.isDigit(str_char)) {
                        str_Oper = "+";
                        str.append("+");
                        txtResult.setText(str.toString());
                    }
                }
                else{
                    str.append("");
                    txtResult.setText(str.toString());
                }
                if(CalcTool.isDigitEnd(str_Result)){
                    str.deleteCharAt(0);
                    str_Result = str.toString();
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnPoint=(Button)findViewById(R.id.buttonPoint);
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.length() == 0) {
                    str.append("0.");
                    txtResult.setText(str.toString());
                } else {
                    if (str.toString().endsWith("+") || str.toString().endsWith("-") || str.toString().endsWith("*") || str.toString().endsWith("/")) {
                        str.append("0.");
                        txtResult.setText(str.toString());
                    } else if (str.toString().contains(".") && !str.toString().contains("+") && !str.toString().contains("-") && !str.toString().contains("*") && !str.toString().contains("/")) {
                        txtResult.setText(str.toString());
                    } else {
                        str.append(".");
                        txtResult.setText(str.toString());
                    }
                    if (!CalcTool.isTrue(str.toString())) {
                        str.deleteCharAt(str.length() - 1);
                    }
                }
                txtResult.setText(str.toString());
                txtResult.setMovementMethod(ScrollingMovementMethod.getInstance());
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnDelete=(Button)findViewById(R.id.buttonDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(str.length()!= 0 ) {
                    if(CalcTool.isDigitEnd(str_Result)){
                        str.deleteCharAt(0);
                        str_Result = str.toString();
                    }
                    str = str.deleteCharAt(str.length()-1);
                    txtResult.setText(str);
                }
                txtResult.post(new Runnable() {
                    @Override
                    public void run() {
                        refresh(txtResult);
                    }
                });
            }
        });
        Button btnEqual=(Button)findViewById(R.id.buttonEqual);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (str.length() != 0) {
                    if (str.toString().indexOf("+") != -1 || str.toString().indexOf("-") != -1 || str.toString().indexOf("*") != -1 || str.toString().indexOf("/") != -1) {
                        if (str.toString().charAt(
                                str.length() - 1) != '+'
                                && str.toString().charAt(
                                str.length() - 1) != '-'
                                && str.toString().charAt(
                                str.length() - 1) != '*'
                                && str.toString().charAt(
                                str.length() - 1) != '/'
                                && str.toString().charAt(
                                str.length() - 1) != '.') {
                            try {
                                valueResult = Double.parseDouble(CalcTool.getCacluteMain(str.toString()));
                                str = new StringBuffer();
                                if (valueResult >= Float.MAX_VALUE) {
                                    str.append("+∞");
                                } else if (valueResult <= -Float.MAX_VALUE) {
                                    str.append("-∞");
                                } else {
                                    str.append("=");
                                    str.append(valueResult);
                                    if (str.toString().endsWith(
                                            ".0")) {
                                        str.delete(str.toString().length() - 2, str.toString().length());
                                    }
                                }
                            } catch (NumberFormatException e) {
                                str = new StringBuffer();
                                str.append("数据错误");
                            }
                            str_Result = str.toString();
                            txtResult.setText(str.toString());
                        }
                    }
                }
            }
        });
        Button btnExtra=(Button)findViewById(R.id.buttonExtra);
        btnExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Calculator.this,Extra.class);
                startActivity(intent);
            }
        });
    }
}