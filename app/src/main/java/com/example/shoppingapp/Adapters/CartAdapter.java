package com.example.shoppingapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.Model.Cart;
import com.example.shoppingapp.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Holder> {
    private Context context;
    private List<Cart> cartList;

    public CartAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cart_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Holder holder, int position) {
        Cart cart=cartList.get(position);
        holder.itemName.setText(cart.getItemName());
        holder.itemPrice.setText("price: "+cart.getItemPrice());
        holder.itemQuantity.setText("Qty: "+cart.getItemQuantity());



    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class Holder  extends RecyclerView.ViewHolder{
        TextView itemName,itemPrice,itemQuantity;
        ImageView item_image;
        public Holder(@NonNull View itemView) {
            super(itemView);
            itemName=itemView.findViewById(R.id.item_name);
            itemPrice=itemView.findViewById(R.id.item_price);
            itemQuantity=itemView.findViewById(R.id.item_quantity);
            item_image=itemView.findViewById(R.id.image_item);

        }
    }
}
