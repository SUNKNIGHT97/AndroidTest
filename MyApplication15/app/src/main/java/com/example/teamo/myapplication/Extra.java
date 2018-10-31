package com.example.teamo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.teamo.myapplication.Calculator_pack.CalcTool;

public class Extra extends AppCompatActivity {
    String StrResult = "";
    private StringBuffer str_ex = new StringBuffer();
    Double value_exa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        final TextView txtRes = (TextView) findViewById(R.id.textRes);
        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CalcTool.isDigitEnd(StrResult)) {
                    str_ex = new StringBuffer();
                    str_ex.append("1");
                    StrResult = "";
                } else {
                    str_ex.append("1");
                }
                txtRes.setText(str_ex);
                txtRes.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        });
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CalcTool.isDigitEnd(StrResult)) {
                    str_ex = new StringBuffer();
                    str_ex.append("2");
                    StrResult = "";
                } else {
                    str_ex.append("2");
                }
                txtRes.setText(str_ex);
                txtRes.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        });
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CalcTool.isDigitEnd(StrResult)) {
                    str_ex = new StringBuffer();
                    str_ex.append("3");
                    StrResult = "";
                } else {
                    str_ex.append("3");
                }
                txtRes.setText(str_ex);
                txtRes.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        });
        Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CalcTool.isDigitEnd(StrResult)) {
                    str_ex = new StringBuffer();
                    str_ex.append("4");
                    StrResult = "";
                } else {
                    str_ex.append("4");
                }
                txtRes.setText(str_ex);
                txtRes.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        });
        Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CalcTool.isDigitEnd(StrResult)) {
                    str_ex = new StringBuffer();
                    str_ex.append("5");
                    StrResult = "";
                } else {
                    str_ex.append("5");
                }
                txtRes.setText(str_ex);
                txtRes.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        });
        Button btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CalcTool.isDigitEnd(StrResult)) {
                    str_ex = new StringBuffer();
                    str_ex.append("6");
                    StrResult = "";
                } else {
                    str_ex.append("6");
                }
                txtRes.setText(str_ex);
                txtRes.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        });
        Button btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CalcTool.isDigitEnd(StrResult)) {
                    str_ex = new StringBuffer();
                    str_ex.append("7");
                    StrResult = "";
                } else {
                    str_ex.append("7");
                }
                txtRes.setText(str_ex);
                txtRes.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        });
        Button btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CalcTool.isDigitEnd(StrResult)) {
                    str_ex = new StringBuffer();
                    str_ex.append("8");
                    StrResult = "";
                } else {
                    str_ex.append("8");
                }
                txtRes.setText(str_ex);
                txtRes.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        });
        Button btn9 = (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CalcTool.isDigitEnd(StrResult)) {
                    str_ex = new StringBuffer();
                    str_ex.append("9");
                    StrResult = "";
                } else {
                    str_ex.append("9");
                }
                txtRes.setText(str_ex);
                txtRes.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        });
        Button btn0 = (Button) findViewById(R.id.button0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CalcTool.isDigitEnd(StrResult)) {
                    str_ex = new StringBuffer();
                    str_ex.append("0");
                    StrResult = "";
                } else {
                    str_ex.append("0");
                }
                txtRes.setText(str_ex);
                txtRes.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
        });
        Button btnDel=(Button)findViewById(R.id.buttonDel);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (str_ex.length() != 0) {
                    if (CalcTool.isDigitEnd(StrResult)) {
                        str_ex.deleteCharAt(0);
                        StrResult = str_ex.toString();
                    }
                    str_ex = str_ex.deleteCharAt(str_ex.length() - 1);
                    txtRes.setText(str_ex);
                }
            }
        });
        Button btnDot=(Button)findViewById(R.id.buttonDot);
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str_ex.length() == 0) {
                    str_ex.append("0.");
                    txtRes.setText(str_ex.toString());
                } else {
                    if (str_ex.toString().endsWith("+") || str_ex.toString().endsWith("-") || str_ex.toString().endsWith("*") || str_ex.toString().endsWith("/")) {
                        str_ex.append("0.");
                        txtRes.setText(str_ex.toString());
                    } else if (str_ex.toString().contains(".") && !str_ex.toString().contains("+") && !str_ex.toString().contains("-") && !str_ex.toString().contains("*") && !str_ex.toString().contains("/")) {
                        txtRes.setText(str_ex.toString());
                    } else {
                        str_ex.append(".");
                        txtRes.setText(str_ex.toString());
                    }
                    if (!CalcTool.isTrue(str_ex.toString())) {
                        str_ex.deleteCharAt(str_ex.length() - 1);
                    }
                }
            }
        });
        Button btnClr=(Button)findViewById(R.id.buttonClr);
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_ex = str_ex.delete(0, str_ex.length());
                txtRes.setText(str_ex);
            }
        });
        Button btnSin=(Button)findViewById(R.id.buttonSin);
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_ex = str_ex.toString();
                double a = Double.parseDouble(s_ex);
                value_exa = CalcTool.Sin(a);
                str_ex.append("=");
                str_ex.append(value_exa);
                StrResult = str_ex.toString();
                txtRes.setText(str_ex.toString());
            }
        });
        Button btnCos=(Button)findViewById(R.id.buttonCos);
        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_ex = str_ex.toString();
                double a = Double.parseDouble(s_ex);
                value_exa = CalcTool.Cos(a);
                str_ex.append("=");
                str_ex.append(value_exa);
                StrResult = str_ex.toString();
                txtRes.setText(str_ex.toString());
            }
        });
        Button btnTan=(Button)findViewById(R.id.buttonTan);
        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_ex = str_ex.toString();
                double a = Double.parseDouble(s_ex);
                value_exa = CalcTool.Tan(a);
                str_ex.append("=");
                str_ex.append(value_exa);
                StrResult = str_ex.toString();
                txtRes.setText(str_ex.toString());
            }
        });
        Button btnTwice=(Button)findViewById(R.id.buttonTwoice);
        btnTwice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String s_ex = str_ex.toString();
                //double a = Double.parseDouble(s_ex);
                value_exa = Double.parseDouble(CalcTool.Twice(str_ex));
                str_ex.append("=");
                str_ex.append(value_exa);
                StrResult = str_ex.toString();
                txtRes.setText(str_ex.toString());
            }
        });
        Button btnSqrt=(Button)findViewById(R.id.buttonSqrt);
        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_ex = str_ex.toString();
                double a = Double.parseDouble(s_ex);
                value_exa = CalcTool.Sqrt(a);
                str_ex.append("=");
                str_ex.append(value_exa);
                StrResult = str_ex.toString();
                txtRes.setText(str_ex.toString());
            }
        });
        Button btnSquare=(Button)findViewById(R.id.buttonSquare);
        btnSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_ex = str_ex.toString();
                double a = Double.parseDouble(s_ex);
                value_exa = CalcTool.Squ(a);
                str_ex.append("=");
                str_ex.append(value_exa);
                StrResult = str_ex.toString();
                txtRes.setText(str_ex.toString());
            }
        });
        Button btnCube=(Button)findViewById(R.id.buttonCube);
        btnCube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_ex = str_ex.toString();
                double a = Double.parseDouble(s_ex);
                value_exa = CalcTool.Cube(a);
                str_ex.append("=");
                str_ex.append(value_exa);
                StrResult = str_ex.toString();
                txtRes.setText(str_ex.toString());
            }
        });
    }
}
