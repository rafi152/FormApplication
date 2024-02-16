package org.meicode.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    public static String NAME="name";
    public static String NUMBER="number";
    public static String PASSWORD="PASSWORD";
    public static String AGE="AGE";
    public static String HEIGHT="HEIGHT";
//    private TextView textview1,textview2,textview3,textview4,textview5;
    private TextView name1,number1,age1,height1,password1,tvshow;
    private String text;
    private int number,age,height,password;
    private Button retrieve2;
    private EditText phoneeditText,nameedittext,ageeditText,heighteditText,passWordEditText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        textview1=findViewById(R.id.textView2);
//        nameedittext=findViewById(R.id.nameedittext);
//        phoneeditText=findViewById(R.id.phoneeditText);
//        passWordEditText=findViewById(R.id.passWordEditText);
//        ageeditText=findViewById(R.id.ageeditText);
//        heighteditText=findViewById(R.id.heighteditText);
//        tvshow=findViewById(R.id.tvshow);
        retrieve2=findViewById(R.id.retrieve2);

        sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);

        retrieve2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.contains("nameedittext")){
                    nameedittext.setText(sharedPreferences.getString("nameedittext",""));
                }
                if (sharedPreferences.contains("phoneeditText")){
                    phoneeditText.setText(sharedPreferences.getString("phoneeditText",""));
                }
                if (sharedPreferences.contains("passWordEditText")){
                    passWordEditText.setText(sharedPreferences.getString("passWordEditTextt",""));
                }
                if (sharedPreferences.contains("ageeditText")){
                    ageeditText.setText(sharedPreferences.getString("ageeditText",""));
                }
                if (sharedPreferences.contains("heighteditText")){
                    heighteditText.setText(sharedPreferences.getString("heighteditText",""));
                }
                Toast.makeText(getApplicationContext(),"Retrieve",Toast.LENGTH_SHORT).show();

                tvshow.setText(nameedittext.getText().toString()+"\n"+ phoneeditText.getText().toString()
                        +"\n"+passWordEditText.getText().toString()+"\n"+ ageeditText.getText().toString()+
                        "\n"+ heighteditText.getText().toString()+"\n");
            }
        });

        name1=findViewById(R.id.textView2);
        number1=findViewById(R.id.textView3);
        password1=findViewById(R.id.textView6);
        age1=findViewById(R.id.textView4);
        height1=findViewById(R.id.textView5);

        Intent i= getIntent();
        text=i.getStringExtra(NAME);
        number=i.getIntExtra(NUMBER,0);
        password=i.getIntExtra(PASSWORD,0);
        age=i.getIntExtra(AGE,0);
        height=i.getIntExtra(HEIGHT,0);

        name1.setText("hi "+text);
        number1.setText("the number is "+number);
        password1.setText("the password is "+password);
        age1.setText("the age is "+age);
        height1.setText("the height is "+height);
    }
}