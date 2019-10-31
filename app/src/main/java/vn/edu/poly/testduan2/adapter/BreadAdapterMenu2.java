package vn.edu.poly.testduan2.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.poly.testduan2.BreadProductDetailActivity;
import vn.edu.poly.testduan2.MilkTeaProductDetailActivity;
import vn.edu.poly.testduan2.R;
import vn.edu.poly.testduan2.model.Bread;

public class BreadAdapterMenu2 extends RecyclerView.Adapter<BreadAdapterMenu2.ViewHolder>  {

    List<Bread> list;
    Context context;
    int resource;

    public BreadAdapterMenu2(@NonNull Context context, int resource, @NonNull List<Bread> lsBread) {
        this.context = context;
        this.resource = resource;
        this.list = lsBread;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_bread, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Bread bread = list.get(position);
        Bitmap bmHinhDaiDien = BitmapFactory.decodeByteArray(bread.getImgBread(), 0, bread.getImgBread().length);
        holder.imgAnh.setImageBitmap(bmHinhDaiDien);
        holder.tvTen.setText(bread.getTitle());
        holder.imgAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BreadProductDetailActivity.class);
                intent.putExtra("ImageBread", list.get(position).getImgBread());
                intent.putExtra("Type", list.get(position).getType());
                intent.putExtra("TitleBread", list.get(position).getTitle());
                intent.putExtra("Price1", list.get(position).getPrice1());
                intent.putExtra("Price2", list.get(position).getPrice2());
                intent.putExtra("Topping", list.get(position).getTopping());
                context.startActivity(intent);
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BreadProductDetailActivity.class);
                intent.putExtra("ImageBread", list.get(position).getImgBread());
                intent.putExtra("Type", list.get(position).getType());
                intent.putExtra("TitleBread", list.get(position).getTitle());
                intent.putExtra("Price1", list.get(position).getPrice1());
                intent.putExtra("Price2", list.get(position).getPrice2());
                intent.putExtra("Topping", list.get(position).getTopping());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgAnh;
        public TextView tvTen;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            imgAnh = itemView.findViewById(R.id.imgBread);
            tvTen = itemView.findViewById(R.id.tvBread);
            cardView = itemView.findViewById(R.id.cardBread);
        }
    }
}
