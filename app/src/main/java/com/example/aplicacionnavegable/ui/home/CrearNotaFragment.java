package com.example.aplicacionnavegable.ui.home;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aplicacionnavegable.R;
import com.example.aplicacionnavegable.databinding.CrearNotaFragmentBinding;
import com.example.aplicacionnavegable.databinding.FragmentHomeBinding;

public class CrearNotaFragment extends Fragment {

    private CrearNotaViewModel mViewModel;
    private CrearNotaFragmentBinding binding;

    public static CrearNotaFragment newInstance() {
        return new CrearNotaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding =  CrearNotaFragmentBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(this).get(CrearNotaViewModel.class);
        View root = binding.getRoot();

        binding.BGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = binding.ETTitulo.getText().toString();
                String cuerpo = binding.ETCuerpo.getText().toString();
                mViewModel.crearNota(titulo,cuerpo);
            }
        });
        mViewModel.getok().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Toast.makeText(getContext(), "El resultado fue :"+aBoolean.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }


}