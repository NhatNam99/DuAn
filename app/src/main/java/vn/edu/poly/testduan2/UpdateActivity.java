package vn.edu.poly.testduan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.testduan2.model.MilkTea;
import vn.edu.poly.testduan2.sqliteDAO.MilkTeaDAO;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName, edtPrice1, edtPrice2;
    private ImageView imgProduct;
    private RadioGroup rdTopping;
    private Button btnUpdate, btnCancel;
    private Toolbar toolbar;
    private int topping;
    String title;
    MilkTeaDAO milkTeaDAO;
    List<MilkTea> lsMilk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        viewID();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Sửa thông tin món ăn");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(this);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        finish();
    }

    public void viewID() {
        edtName = findViewById(R.id.edtName);
        edtPrice1 = findViewById(R.id.edtPrice1);
        edtPrice2 = findViewById(R.id.edtPrice2);
        rdTopping = findViewById(R.id.rdTopping);
        imgProduct = findViewById(R.id.imgProduct);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnCancel = findViewById(R.id.btnCancelUpdate);
    }
}
