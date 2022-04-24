package com.example.aplicacionnavegable.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.aplicacionnavegable.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button boton  = binding.button;
        EditText textoEditable = binding.ETNombre;
        final TextView textView = binding.textSlideshow;
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre =  textoEditable.getText().toString();
                slideshowViewModel.setNombreMutable(nombre);
            }
        });
        slideshowViewModel.getnombreMutable().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String nombre) {
                textView.setText(nombre);
            }
        });

        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}