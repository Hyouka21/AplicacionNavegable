package com.example.aplicacionnavegable.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacionnavegable.R;
import com.example.aplicacionnavegable.databinding.FragmentHomeBinding;
import com.example.aplicacionnavegable.ui.adapter.NotaAdapter;
import com.example.aplicacionnavegable.ui.entidades.Nota;

import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView RVNota;
    private NotaAdapter notaAdapter;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        RVNota = binding.RVNotas;
        binding.BCrearNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(root).navigate(R.id.crearNotaFragment);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        homeViewModel.getList().observe(getViewLifecycleOwner(), new Observer<List<Nota>>() {
            @Override
            public void onChanged(List<Nota> notas) {
                RVNota.setLayoutManager(linearLayoutManager);
                notaAdapter = new NotaAdapter(notas,root,inflater);
                RVNota.setAdapter(notaAdapter);
            }
        });
        homeViewModel.setLista();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}