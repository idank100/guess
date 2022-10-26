package com.example.idanproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button button;
    Button me;
    int number=1;
    Button add;
    Button less;
    TextView shownumber;
    TextView message;
    Button send;
    int Random = 0;
    int co =2;
    Button Return;
    Button newgame;
    SharedPreferences sp;
    Button btnsave;
    EditText etFname,etLname;
    TextView tvDisplay;
    AlertDialog.Builder builder;
    AlertDialog.Builder builder1;
    TextView end;
    String strlname,strfname;
    int counter;
    TextView coguess;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);



        if(item.getItemId()==R.id.action_first)
        {
            Toast.makeText(MainActivity.this,"you have selected 1-10",Toast.LENGTH_LONG).show();
             Random = (int)(Math.random()*10)+1;
            return true;

        }
        if(item.getItemId()==R.id.action_second)
        {
            Toast.makeText(MainActivity.this,"you have selected 1-50",Toast.LENGTH_LONG).show();
            Random = (int)(Math.random()*50)+1;
            return true;
        }
        if(item.getItemId()==R.id.action_third)
        {
            Toast.makeText(MainActivity.this,"you have selected 1-100",Toast.LENGTH_LONG).show();
            Random = (int)(Math.random()*100)+1;
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        me = findViewById(R.id.me);
        button = findViewById(R.id.button);
        add = findViewById(R.id.button2);
        shownumber = findViewById(R.id.textView);
        less = findViewById(R.id.button3);
        send = findViewById(R.id.button4);
        message = findViewById(R.id.textView3);
        Return = findViewById(R.id.button5);
        newgame = findViewById(R.id.button6);
        etFname = findViewById(R.id.editTextTextPersonName);
        etLname = findViewById(R.id.editTextTextPersonName2);
        btnsave = findViewById(R.id.button7);
        tvDisplay = findViewById(R.id.textView6);
        builder = new AlertDialog.Builder(this);
        end = findViewById(R.id.textView5);
        coguess = findViewById(R.id.textView7);

        sp = getSharedPreferences("details1",0);

         strfname = sp.getString("fname",null);
         strlname = sp.getString("lname",null);
        if(strfname!=null&&strlname!=null)
        {

        }
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(btnsave==v)
              {
                  SharedPreferences.Editor editor = sp.edit();
                  editor.putString("fname",etFname.getText().toString());
                  editor.putString("lname",etLname.getText().toString());
                  editor.commit();

                  View a = findViewById(R.id.button);
                  a.setVisibility(View.VISIBLE);
                  View b = findViewById(R.id.me);
                  b.setVisibility(View.VISIBLE);
                  View c = findViewById(R.id.editTextTextPersonName);
                  c.setVisibility(View.GONE);
                  View d = findViewById(R.id.editTextTextPersonName2);
                  d.setVisibility(View.GONE);
                  View e = findViewById(R.id.button7);
                  e.setVisibility(View.GONE);
                  View f = findViewById(R.id.textView6);
                  f.setVisibility(View.GONE);
              }
            }
        });


        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(co==2)
                {
                    View me2 = findViewById(R.id.textView2);
                    me2.setVisibility(View.VISIBLE);
                    co=1;
                }
                else
                {
                    View me2 = findViewById(R.id.textView2);
                    me2.setVisibility(View.GONE);
                    co=2;
                }


            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View a = findViewById(R.id.button);
                a.setVisibility(View.GONE);
                View b = findViewById(R.id.me);
                b.setVisibility(View.GONE);
                View c = findViewById(R.id.textView2);
                c.setVisibility(View.GONE);
                View add = findViewById(R.id.button2);
                add.setVisibility(View.VISIBLE);
                View less = findViewById(R.id.button3);
                less.setVisibility(View.VISIBLE);
                View f = findViewById(R.id.button4);
                f.setVisibility(View.VISIBLE);
                View g = findViewById(R.id.textView);
                g.setVisibility(View.VISIBLE);
                View h = findViewById(R.id.textView4);
                h.setVisibility(View.VISIBLE);
                View i = findViewById(R.id.button5);
                i.setVisibility(View.VISIBLE);
                number =1;
                shownumber.setText(""+number);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                shownumber.setText(""+number);
            }
        });
        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(number>1) {
                    number--;
                    shownumber.setText(""+number);
                }




            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("guess");
                alert.setMessage("are you sure you want to send your guess");
                alert.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"YES",Toast.LENGTH_LONG).show();
                        counter++;
                        if(number>Random&&Random!=0)
                        {
                            message.setText("the number is too high");

                        }
                        if(number<Random)
                        {
                            message.setText("the number is too low");

                        }
                        if(number==Random)
                        {
                            View a = findViewById(R.id.button2);
                            a.setVisibility(View.GONE);
                            View b = findViewById(R.id.button3);
                            b.setVisibility(View.GONE);
                            View c = findViewById(R.id.button4);
                            c.setVisibility(View.GONE);
                            View d = findViewById(R.id.textView);
                            d.setVisibility(View.GONE);
                            View e = findViewById(R.id.textView3);
                            e.setVisibility(View.GONE);
                            View f = findViewById(R.id.textView4);
                            f.setVisibility(View.GONE);
                            View g = findViewById(R.id.textView5);
                            strfname = sp.getString("fname",null);
                            strlname = sp.getString("lname",null);
                            end.setText("well done "+strlname+" "+strfname+" you guessed the right number ");
                            shownumber.setText(""+number);
                            g.setVisibility(View.VISIBLE);
                            View u = findViewById(R.id.button5);
                            u.setVisibility(View.GONE);
                            View r = findViewById(R.id.button6);
                            r.setVisibility(View.VISIBLE);
                            View l = findViewById(R.id.textView7);
                            coguess.setText("Took you "+counter+" tries");
                            l.setVisibility(View.VISIBLE);

                        }
                        if(Random!=0&&Random!=number)
                        {
                            View a = findViewById(R.id.textView3);
                            a.setVisibility(View.VISIBLE);
                        }
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"I want to stay",Toast.LENGTH_LONG).show();

                    }
                });
                alert.create().show();
            }
        });

        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("return");
                alert.setMessage("are you sure you want to return to the start");
                alert.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"YES",Toast.LENGTH_LONG).show();

                        View a = findViewById(R.id.button);
                        a.setVisibility(View.VISIBLE);
                        View b = findViewById(R.id.me);
                        b.setVisibility(View.VISIBLE);
                        View add = findViewById(R.id.button2);
                        add.setVisibility(View.GONE);
                        View less = findViewById(R.id.button3);
                        less.setVisibility(View.GONE);
                        View f = findViewById(R.id.button4);
                        f.setVisibility(View.GONE);
                        View g = findViewById(R.id.textView);
                        g.setVisibility(View.GONE);
                        View h = findViewById(R.id.textView4);
                        h.setVisibility(View.GONE);
                        View r = findViewById(R.id.button5);
                        r.setVisibility(View.GONE);
                        View j = findViewById(R.id.textView3);
                        j.setVisibility(View.GONE);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"I want to stay",Toast.LENGTH_LONG).show();

                    }
                });
                alert.create().show();
            }
        });
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("return");
                alert.setMessage("are you sure you want to return to the guess page");
                alert.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"YES",Toast.LENGTH_LONG).show();
                        View a = findViewById(R.id.button2);
                        a.setVisibility(View.VISIBLE);
                        View b = findViewById(R.id.button3);
                        b.setVisibility(View.VISIBLE);
                        View c = findViewById(R.id.button4);
                        c.setVisibility(View.VISIBLE);
                        View d = findViewById(R.id.textView);
                        d.setVisibility(View.VISIBLE);
                        View e = findViewById(R.id.textView3);
                        e.setVisibility(View.GONE);
                        View f = findViewById(R.id.textView4);
                        f.setVisibility(View.VISIBLE);
                        View g = findViewById(R.id.textView5);
                        g.setVisibility(View.GONE);
                        View u = findViewById(R.id.button5);
                        u.setVisibility(View.VISIBLE);
                        View r = findViewById(R.id.button6);
                        r.setVisibility(View.GONE);
                        View l = findViewById(R.id.textView7);
                        l.setVisibility(View.GONE); 
                        number =1;
                        shownumber.setText(""+number);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"I want to stay",Toast.LENGTH_LONG).show();

                    }
                });
                alert.create().show();
            }
        });
    }}
