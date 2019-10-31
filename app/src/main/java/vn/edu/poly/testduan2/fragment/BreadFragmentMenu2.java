package vn.edu.poly.testduan2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import vn.edu.poly.testduan2.R;
import vn.edu.poly.testduan2.adapter.BreadAdapter;
import vn.edu.poly.testduan2.adapter.BreadAdapterMenu2;
import vn.edu.poly.testduan2.model.Bread;
import vn.edu.poly.testduan2.sqliteDAO.BreadDAO;

public class BreadFragmentMenu2 extends Fragment {

    List<Bread> lsBread;
    RecyclerView listBread;
    BreadAdapterMenu2 breadAdapterMenu2;
    BreadDAO breadDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_bread, container, false);
        lsBread = new ArrayList<Bread>();
        listBread = view.findViewById(R.id.lsBread);
        registerForContextMenu(listBread);
        listBread.setItemAnimator(new SlideInUpAnimator());
        listBread.setHasFixedSize(true);

        breadDAO = new BreadDAO(getContext());

        lsBread = new ArrayList<Bread>();
        lsBread = breadDAO.getAllBread();
        breadAdapterMenu2 = new BreadAdapterMenu2(getContext(), R.layout.content_main, lsBread);
        RecyclerView lsBread = view.findViewById(R.id.lsBread);
        lsBread.setAdapter(breadAdapterMenu2);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(), 3);
        lsBread.setLayoutManager(manager);
        return view;
    }
}
