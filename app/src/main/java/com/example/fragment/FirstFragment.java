package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class FirstFragment extends Fragment  implements RecyclerAdapter.OnclickListener {
    private RecyclerAdapter recyclerAdapter;
    private FirstFragment firstFragment;
    private RecyclerView recyclerView;

    private ArrayList<ItemModel> listModel = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        listModel.add(new ItemModel("Нарын","Кочкор"));
        listModel.add(new ItemModel("Ыссык кол","Тон"));
        listModel.add(new ItemModel("Баткен","Кадамжай "));
        listModel.add(new ItemModel("Бишкек","Перво Майский "));
        listModel.add(new ItemModel("Ош","Араван "));
        listModel.add(new ItemModel("Чуй","Сокулук "));
        listModel.add(new ItemModel("Жалал-Абад","Токтогул "));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        recyclerAdapter = new RecyclerAdapter(listModel,firstFragment);
        SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();


        return inflater.inflate(R.layout.fragment_first, container, false);


    }






    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_list);
        recyclerAdapter = new RecyclerAdapter(listModel,this);
        recyclerView.setAdapter(recyclerAdapter);

    }

    @Override
    public void clickItem(ItemModel item) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_ITEM",item);

        Fragment secondFrag = new SecondFragment();
        secondFrag.setArguments(bundle);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container,secondFrag);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}