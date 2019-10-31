package vn.edu.poly.testduan2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class BreadProductDetailActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvType, tvName, tvPrice1, tvPrice2, tvTopping;
    ImageView imageBread;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        viewId();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Thông tin món ăn");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(this);

        Intent intent = getIntent();
        byte[] Image = getIntent().getByteArrayExtra("ImageBread");
        Bitmap bitmap = BitmapFactory.decodeByteArray(Image, 0, Image.length);
        String Type = intent.getExtras().getString("Type");
        String Name = intent.getExtras().getString("TitleBread");
        int Price1 = intent.getExtras().getInt("Price1");
        int Price2 = intent.getExtras().getInt("Price2");
        String Topping = intent.getExtras().getString("Topping");

        imageBread.setImageBitmap(bitmap);
        tvType.setText(Type);
        tvName.setText(Name);
        tvPrice1.setText(String.valueOf(Price1) + " VNĐ") ;
        tvPrice2.setText(String.valueOf(Price2) + " VNĐ");
        tvTopping.setText(Topping);
    }

    public void viewId(){
        tvType = findViewById(R.id.type);
        tvName = findViewById(R.id.name);
        tvPrice1 = findViewById(R.id.price1);
        tvPrice2 = findViewById(R.id.price2);
        tvTopping = findViewById(R.id.topping);
        imageBread = findViewById(R.id.image_product);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
