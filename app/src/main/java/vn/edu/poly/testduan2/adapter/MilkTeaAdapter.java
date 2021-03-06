package vn.edu.poly.testduan2.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.poly.testduan2.MilkTeaProductDetailActivity;
import vn.edu.poly.testduan2.R;
import vn.edu.poly.testduan2.UpdateActivity;
import vn.edu.poly.testduan2.model.MilkTea;
import vn.edu.poly.testduan2.sqliteDAO.MilkTeaDAO;

public class MilkTeaAdapter extends RecyclerView.Adapter<MilkTeaAdapter.ViewHolder> {

    List<MilkTea> list;
    Context context;
    int resource;
    MilkTeaAdapter milkTeaAdapter;

    public MilkTeaAdapter(@NonNull Context context, int resource, @NonNull List<MilkTea> lsMilkt) {
        this.context = context;
        this.resource = resource;
        this.list = lsMilkt;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_milk_tea, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        MilkTea milkTea = list.get(position);
        Bitmap bmHinhDaiDien = BitmapFactory.decodeByteArray(milkTea.getImgMilk(), 0, milkTea.getImgMilk().length);
        holder.imgAnh.setImageBitmap(bmHinhDaiDien);
        holder.tvTen.setText(milkTea.getTitle());
        holder.imgAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MilkTeaProductDetailActivity.class);
                intent.putExtra("ImageMilkTea", list.get(position).getImgMilk());
                intent.putExtra("Type", list.get(position).getType());
                intent.putExtra("TitleMilkTea", list.get(position).getTitle());
                intent.putExtra("Price1", list.get(position).getPrice1());
                intent.putExtra("Price2", list.get(position).getPrice2());
                intent.putExtra("Topping", list.get(position).getTopping());
                context.startActivity(intent);
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MilkTeaProductDetailActivity.class);
                intent.putExtra("ImageMilkTea", list.get(position).getImgMilk());
                intent.putExtra("Type", list.get(position).getType());
                intent.putExtra("TitleMilkTea", list.get(position).getTitle());
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
            imgAnh = itemView.findViewById(R.id.imgMilk);
            tvTen = itemView.findViewById(R.id.tvMilk);
            cardView = itemView.findViewById(R.id.cardMilk);

            imgAnh.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    DialogFunction();
                    return false;
                }
            });
        }
    }

    private void DialogFunction() {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog);

        final TextView tvdelete = (TextView) dialog.findViewById(R.id.tvDelete);
        final TextView tvupdate = (TextView) dialog.findViewById(R.id.tvUpdate);

        tvupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent intent = new Intent(context, UpdateActivity.class);
                  context.startActivity(intent);
            }
        });


        tvdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Bạn có muốn xóa thông tin món ăn");
                builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MilkTea milkTea = new MilkTea();
                        final MilkTeaDAO milkTeaDAO = new MilkTeaDAO(context);
//                        list = milkTeaDAO.getAllMilkTea();
                        int result = milkTeaDAO.delete(milkTea);
                        if (result > 0) {
                            list.clear();
                            list.remove(result);
                            milkTeaAdapter.notifyItemRemoved(result);
                            Toast.makeText(context, "Xóa thông tin thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Xóa thông tin thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

        dialog.show();
    }
}

