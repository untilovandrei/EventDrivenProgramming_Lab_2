package com.example.andrei.tissotwatches;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class SwipeAdapter extends PagerAdapter {

    private int[] swipe_layout_resources={R.drawable.tissot_01,R.drawable.tissot_02,
            R.drawable.roamer_01,R.drawable.roamer_02,R.drawable.swissmilitary_01,R.drawable.swissmilitary_02};

    private Context context;
    private LayoutInflater layout_inflater;

    public SwipeAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return swipe_layout_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layout_inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layout_inflater.inflate(R.layout.swipe_layout,container,false);
        ImageView image_view=(ImageView)view.findViewById(R.id.image_view);
        image_view.setImageResource(swipe_layout_resources[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout)object);
    }


}
