package com.example.andrei.tissotwatches;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import javax.xml.datatype.Duration;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    ViewPager viewPager;
    SwipeAdapter swipeAdapter;
    private final int IMAGE_CODE=1;
    private Button watches;
    private Button btn_input_event;

    private RelativeLayout activity_main;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager=(ViewPager)findViewById(R.id.view_pager);
        swipeAdapter= new SwipeAdapter(this);
        viewPager.setAdapter(swipeAdapter);
        watches=(Button)findViewById(R.id.btn_watches);
        btn_input_event=(Button)findViewById(R.id.btn_input_event);

        activity_main=(RelativeLayout)findViewById(R.id.activity_main);

        watches.setOnClickListener(this);
        btn_input_event.setOnClickListener(this);





    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.message:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Message Dialog")
                        .setMessage("You've selected Message Item")
                        .show();
                break;
            case R.id.backgroundColor:
                activity_main.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.redButton:
                watches.setBackgroundColor(Color.RED);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.custom_menu1,menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_watches:
                intent=new Intent(this,Image.class);
                startActivityForResult(intent,IMAGE_CODE);
                break;
            case R.id.btn_input_event:
                InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode==RESULT_OK){
            switch (requestCode){
                case IMAGE_CODE:
                    byte[] byteArray=data.getByteArrayExtra("backgroundImage");
                    Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
                    activity_main.setBackground(new BitmapDrawable(getResources(),bitmap));
                    break;

            }
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_SHIFT_LEFT:
                Toast.makeText(getApplicationContext(),"Shift key pressed" , Toast.LENGTH_SHORT).show();
                break;
            case KeyEvent.KEYCODE_ENTER:

                btn_input_event.setText("Enter pressed");
                break;
        }
        return true;
    }
}
