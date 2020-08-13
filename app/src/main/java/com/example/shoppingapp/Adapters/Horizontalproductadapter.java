package com.example.shoppingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.Model.HorizontalProductmodel;
import com.example.shoppingapp.R;

import java.util.List;

public class Horizontalproductadapter extends RecyclerView.Adapter<Horizontalproductadapter.Holder> {
    Context context;
    private List<HorizontalProductmodel> productmodelList;

    public Horizontalproductadapter(List<HorizontalProductmodel> productmodelList) {

        this.productmodelList = productmodelList;
    }

    @NonNull
    @Override
    public Horizontalproductadapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horrizontal_scroll_item_layout, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Horizontalproductadapter.Holder holder, int position) {
        int productimage=productmodelList.get(position).getProductimage();
        String productname=productmodelList.get(position).getProductName();
        String productdescription=productmodelList.get(position).getProductDescription();
        String productprice=productmodelList.get(position).getProductPrice();
        holder.setProductimage(productimage);
        holder.setProductName(productname);
        holder.setProductDescription(productdescription);
        holder.setProductPrice(productprice);

    }

    @Override
    public int getItemCount() {
        return productmodelList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private ImageView product_image;
        private TextView product_name;
        private TextView product_description;
        private TextView product_price;


        public Holder(@NonNull View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.product_image);
            product_name = itemView.findViewById(R.id.text_product_name);
             product_description = itemView.findViewById(R.id.text_product_description);
            product_price = itemView.findViewById(R.id.text_product_price);
        }
        private  void setProductimage(int resource)
        {
            product_image.setImageResource(resource);
        }
        private  void setProductName(String name)
        {
            product_name.setText(name);
        }
        private  void setProductDescription(String description)
        {
            product_description.setText(description);
        }
        private  void setProductPrice(String price)
        {
            product_price.setText(price);
        }
    }
}
