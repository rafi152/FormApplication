package org.meicode.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private EditText phoneeditText,nameedittext,ageeditText,heighteditText,passWordEditText;
   private Button button1,button2,store,retrieve,delete;
   private TextView tvshow;
    private String text;
    private int number,password,age,height;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameedittext=findViewById(R.id.nameedittext);
        phoneeditText=findViewById(R.id.phoneeditText);
        passWordEditText=findViewById(R.id.passWordEditText);
        ageeditText=findViewById(R.id.ageeditText);
        heighteditText=findViewById(R.id.heighteditText);
        store=findViewById(R.id.store);
        retrieve=findViewById(R.id.retrieve);
        delete=findViewById(R.id.delete);
        sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        tvshow=findViewById(R.id.tvshow);

       button1=findViewById(R.id.button1);
       button2=findViewById(R.id.button2);

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

//        EditText editText=(EditText) findViewById(R.id.editTextPhone1);
//        EditText editText1=(EditText) findViewById(R.id.editTextPhone2);
//        EditText editText2=(EditText) findViewById(R.id.editTextPhone3);
//        EditText editText3=(EditText) findViewById(R.id.editTextPhone4);
//        EditText editText4=(EditText) findViewById(R.id.passWordEditText);

//        Button button=(Button) findViewById(R.id.button1);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView=(ImageView) findViewById(R.id.imageView);
                imageView.setBackgroundResource(R.drawable.rafi);
            }
        });
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("nameedittext",nameedittext.getText().toString());
                editor.putString("phoneeditText",phoneeditText.getText().toString());
                editor.putString("passWordEditText",passWordEditText.getText().toString());
                editor.putString("ageeditText",ageeditText.getText().toString());
                editor.putString("heighteditText",heighteditText.getText().toString());

                editor.apply();
                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();





                //one field sharedpreference

//                String msg=nameedittext.getText().toString();
//
//                SharedPreferences shp=getSharedPreferences("demo",MODE_PRIVATE);
//                SharedPreferences.Editor editor1=shp.edit();
//                editor1.putString("str",msg);
//                editor1.apply();
//                tvshow.setText(msg);






              //  validate show
//
                if (TextUtils.isEmpty(nameedittext.getText().toString())){
                    nameedittext.setError("Name is compulsary");
                    return;
                }
                if (TextUtils.isEmpty(phoneeditText.getText().toString())) {
                    phoneeditText.setError("Number is important");
                    return;
                }
                if (TextUtils.isEmpty(passWordEditText.getText().toString())) {
                    passWordEditText.setError("password is must");
                    return;
                }
                if (TextUtils.isEmpty(ageeditText.getText().toString())) {
                    ageeditText.setError("Age is compulsary");
                    return;
                }
                if (TextUtils.isEmpty(heighteditText.getText().toString())) {
                    heighteditText.setError("Height is necessary");
                    return;
                }

                Toast.makeText(MainActivity.this,"Successfully done",Toast.LENGTH_LONG).show();

                //one field validate

//                if (editTextPhone1.getText().length()==0) {
//                    Toast.makeText(MainActivity.this, "You did not enter a username", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                tvshow.setText(nameedittext.getText().toString()+"\n"+ phoneeditText.getText().toString()
                                +"\n"+passWordEditText.getText().toString()+"\n"+ ageeditText.getText().toString()+
                        "\n"+ heighteditText.getText().toString()+"\n");
            }
        });
//
//        SharedPreferences getshared=getSharedPreferences("demo",MODE_PRIVATE);
//        String value=getshared.getString("str","save a note it will show up here");
//        tvshow.setText(value);

        retrieve.setOnClickListener(new View.OnClickListener() {
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
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                nameedittext.setText("");
                phoneeditText.setText("");
                passWordEditText.setText("");
                ageeditText.setText("");
                heighteditText.setText("");
                Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }
    public void sendData(){
        text=nameedittext.getText().toString().trim();
        number= Integer.parseInt(heighteditText.getText().toString().trim());
        password= Integer.parseInt(passWordEditText.getText().toString().trim());
        age= Integer.parseInt(ageeditText.getText().toString().trim());
        height= Integer.parseInt(phoneeditText.getText().toString().trim());

        Intent i =new Intent(MainActivity.this,MainActivity2.class);

        i.putExtra(MainActivity2.NAME,text);
        i.putExtra(MainActivity2.NUMBER,number);
        i.putExtra(MainActivity2.PASSWORD,password);
        i.putExtra(MainActivity2.AGE,age);
        i.putExtra(MainActivity2.HEIGHT,height);

        startActivity(i);
    }
}