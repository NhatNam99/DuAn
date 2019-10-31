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
import vn.edu.poly.testduan2.adapter.FruitAdapter;
import vn.edu.poly.testduan2.adapter.FruitAdapterMenu2;
import vn.edu.poly.testduan2.model.Fruit;
import vn.edu.poly.testduan2.sqliteDAO.FruitDAO;

public class FruitFragmentMenu2 extends Fragment {

    List<Fruit> lsFruit;
    RecyclerView listFruit;
    FruitAdapterMenu2 fruitAdapterMenu2;
    FruitDAO fruitDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.fragment_fruit_menu_2, container, false);
        lsFruit = new ArrayList<Fruit>();
        listFruit = view.findViewById(R.id.lsFruit);
        registerForContextMenu(listFruit);
        listFruit.setItemAnimator(new SlideInUpAnimator());
        listFruit.setHasFixedSize(true);

        fruitDAO = new FruitDAO(getContext());

        lsFruit = new ArrayList<Fruit>();
        lsFruit = fruitDAO.getAllFruit();
        fruitAdapterMenu2 = new FruitAdapterMenu2(getContext(), R.layout.content_main, lsFruit);
        RecyclerView lsFruit = view.findViewById(R.id.lsFruit);
        lsFruit.setAdapter(fruitAdapterMenu2);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(), 3);
        lsFruit.setLayoutManager(manager);
        return view;
    }
}
