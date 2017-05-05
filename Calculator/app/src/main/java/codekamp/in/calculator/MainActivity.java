package codekamp.in.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
            buttonAdd, buttonMul, buttonDiv, buttonEqual, buttonMin, buttonDelete, buttonDecimal;
    private TextView edit1, edit2;
    public  double v1, v2;
    public boolean add, mul, min, div;
    private String text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String resultText = null;
        if (savedInstanceState != null) {
            resultText = savedInstanceState.getString("result");
        }

        if (resultText != null) {
            edit1.setText(resultText);
            edit2.setText(resultText);
        }

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonDiv = (Button) findViewById(R.id.buttonDIV);
        buttonMul = (Button) findViewById(R.id.buttonMUL);
        buttonEqual = (Button) findViewById(R.id.buttonEQL);
        buttonDecimal = (Button) findViewById(R.id.buttonDeci);
        buttonDelete = (Button) findViewById(R.id.buttonDEL);
        buttonAdd = (Button) findViewById(R.id.buttonADD);
        buttonMin = (Button) findViewById(R.id.buttonMIN);
        edit1 = (TextView) findViewById(R.id.textview1);
        edit2 = (TextView) findViewById(R.id.textview2);





        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + "9");
            }
        });
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(edit1.getText() + ".");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit1.getText().toString();
                text1 = text.substring(0,text.length());
                edit1.setText(edit1.getText() + "+");
                add = true;
            }
        });
        buttonMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit1.getText().toString();
                text1 = text.substring(0,text.length());
                edit1.setText(edit1.getText() + "-");
                min = true;
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit1.getText().toString();
                text1 = text.substring(0,text.length());
                edit1.setText(edit1.getText() + "*");
                mul=true;
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit1.getText().toString();
                text1 = text.substring(0,text.length());
                edit1.setText(edit1.getText() + "/");
                div =true;
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit1.getText().toString();
                if (text.length() == 0) {
                    edit2.setText("");
                    edit1.setText(text.substring(0, text.length()));
                } else {
                    edit1.setText(text.substring(0, text.length() - 1));
                }
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit1.getText().toString();
                double v1 = Double.parseDouble(text1);
                text2 = text.substring(text1.length()+1,text.length());
                double v2 = Double.parseDouble(text2);
                if (add == true) {
                    edit2.setText((v1 + v2) + "");
                    add = false;
                    edit1.setText((v1 + v2) + "");
                    text = edit2.getText().toString();
                    v1= Double.parseDouble(text);

                }
                if (min == true) {
                    edit2.setText((v1 - v2) + "");
                    min = false;
                    edit1.setText((v1 - v2) + "");
                    text = edit2.getText().toString();
                    v1= Double.parseDouble(text);
                }
                 if (mul == true) {
                    edit2.setText((v1 * v2) + "");
                    mul = false;
                    edit1.setText((v1 * v2) + "");
                     text = edit2.getText().toString();
                     v1= Double.parseDouble(text);
                }
                 if (div == true) {
                    edit2.setText((v1/v2)+"");
                    div = false;
                    edit1.setText((v1/v2) + "");
                     text = edit2.getText().toString();
                     v1= Double.parseDouble(text);
                }

            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("result",edit1.getText().toString());
        outState.putString("result",edit2.getText().toString());

    }


}
