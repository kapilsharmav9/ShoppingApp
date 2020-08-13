package com.example.shoppingapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shoppingapp.Model.HorizontalProductmodel;
import com.example.shoppingapp.R;

import java.util.List;

public class GridProductAdapter extends BaseAdapter {
    List<HorizontalProductmodel> hpmodelList;

    public GridProductAdapter(List<HorizontalProductmodel> hpmodelList) {
        this.hpmodelList = hpmodelList;
    }

    View  view;
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if (convertView==null)
       {
           view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horrizontal_scroll_item_layout,null);
           ImageView productimage=view.findViewById(R.id.product_image);
          TextView product_name = view.findViewById(R.id.text_product_name);
         TextView  product_description = view.findViewById(R.id.text_product_description);
         TextView  product_price = view.findViewById(R.id.text_product_price);
            productimage.setImageResource(hpmodelList.get(position).getProductimage());
           product_name.setText(hpmodelList.get(position).getProductName());
           product_description.setText(hpmodelList.get(position).getProductDescription());
           product_price.setText(hpmodelList.get(position).getProductPrice());
       }else
           {
               view =convertView;
           }
       return  view;
    }
}
