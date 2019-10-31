package vn.edu.poly.testduan2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import vn.edu.poly.testduan2.R;
import vn.edu.poly.testduan2.adapter.MilkTeaAdapter;
import vn.edu.poly.testduan2.adapter.MilkTeaAdapterMenu2;
import vn.edu.poly.testduan2.model.MilkTea;
import vn.edu.poly.testduan2.sqliteDAO.MilkTeaDAO;

public class MilkTeaFragmentMenu2 extends Fragment implements View.OnClickListener {

    CardView cardView;
    ImageView imageMilkTea;
    List<MilkTea> listMilkt;
    RecyclerView lsMilkt;
    MilkTeaAdapterMenu2 milkTeaAdapterMenu2;
    MilkTeaDAO milkTeaDAO;
    int position;
    public static final int Request_image_Edit = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_milk_tea_menu_2, container, false);

        listMilkt = new ArrayList<MilkTea>();
        lsMilkt = view.findViewById(R.id.lsMilk);
        imageMilkTea = view.findViewById(R.id.imgMilk);
        registerForContextMenu(lsMilkt);
        lsMilkt.setItemAnimator(new SlideInUpAnimator());
        lsMilkt.setHasFixedSize(true);

        milkTeaDAO = new MilkTeaDAO(getContext());

        listMilkt = new ArrayList<MilkTea>();
        listMilkt = milkTeaDAO.getAllMilkTea();
        milkTeaAdapterMenu2 = new MilkTeaAdapterMenu2(getContext(), R.layout.content_main, listMilkt);
        lsMilkt.setAdapter(milkTeaAdapterMenu2);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(), 3);
        lsMilkt.setLayoutManager(manager);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
