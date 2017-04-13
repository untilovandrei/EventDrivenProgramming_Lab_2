package com.example.andrei.tissotwatches;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;

public class Image extends AppCompatActivity implements View.OnClickListener {


    private ImageView img_1;
    private ImageView img_2;
    private ImageView img_3;
    private ImageView img_4;
    private ImageView img_5;
    private ListView listView;
    private ImageView imgPreviewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        img_1=(ImageView)findViewById(R.id.img_1);
        img_2=(ImageView)findViewById(R.id.img_2);
        img_3=(ImageView)findViewById(R.id.img_3);
        img_4=(ImageView)findViewById(R.id.img_4) ;
        img_5=(ImageView)findViewById(R.id.img_5) ;
        listView=(ListView)findViewById(R.id.listView);
        imgPreviewList=(ImageView)findViewById(R.id.imgPreviewList);

        img_1.setOnClickListener(this);
        img_2.setOnClickListener(this);
        img_3.setOnClickListener(this);
        img_4.setOnClickListener(this);
        img_5.setOnClickListener(this);

        String[] models={"Le Locle" , "Heritage","T-Classic" , "T-Sport" ,"T-Lady" , "T-Pocket"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_layout,models);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String m=(String)parent.getItemAtPosition(position);
                setImageView(m);
            }


        });


    }


    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        ByteArrayOutputStream bs=new ByteArrayOutputStream();
        Bitmap bitmap;
        switch(v.getId()){
            case R.id.img_1:
                img_1.buildDrawingCache();
                bitmap=img_1.getDrawingCache();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,bs);
                intent.putExtra("backgroundImage",bs.toByteArray());
                break;
            case R.id.img_2:
                img_2.buildDrawingCache();
                bitmap=img_2.getDrawingCache();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,bs);
                intent.putExtra("backgroundImage",bs.toByteArray());
                break;
            case R.id.img_3:
                img_3.buildDrawingCache();
                bitmap=img_3.getDrawingCache();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,bs);
                intent.putExtra("backgroundImage",bs.toByteArray());
                break;
            case R.id.img_4:
                img_4.buildDrawingCache();
                bitmap=img_4.getDrawingCache();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,bs);
                intent.putExtra("backgroundImage",bs.toByteArray());
                break;
            case R.id.img_5:
                img_5.buildDrawingCache();
                bitmap=img_5.getDrawingCache();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,bs);
                intent.putExtra("backgroundImage",bs.toByteArray());
                break;
        }
        setResult(RESULT_OK,intent);
        finish();
    }


    private void setImageView(String model){
        switch (model){
            case "Le Locle":
                    imgPreviewList.setImageResource(R.drawable.tlelocle);
                    break;
            case "Heritage":
                    imgPreviewList.setImageResource(R.drawable.theritage);
                    break;
            case "T-Classic":
                    imgPreviewList.setImageResource(R.drawable.tclassic);
                    break;
            case "T-Sport":
                    imgPreviewList.setImageResource(R.drawable.tsport);
                    break;
            case "T-Lady":
                    imgPreviewList.setImageResource(R.drawable.tlady);
                    break;
            case "T-Pocket":
                    imgPreviewList.setImageResource(R.drawable.tpocket);
                    break;
        }
    }

}
