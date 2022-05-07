package com.example.aplicacionnavegable.ui.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacionnavegable.R;
import com.example.aplicacionnavegable.ui.entidades.Nota;

import java.util.List;

public class NotaAdapter  extends RecyclerView.Adapter<NotaAdapter.MiViewHolder>{
    private List<Nota> lista;
    private View root ;
    private LayoutInflater inflater;

    public NotaAdapter(List<Nota> lista, View root, LayoutInflater inflater) {
        this.lista = lista;
        this.root = root;
        this.inflater = inflater;
    }


    @NonNull
    @Override
    public NotaAdapter.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.nota_item, parent, false);
        return new NotaAdapter.MiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotaAdapter.MiViewHolder holder, int position) {

        Nota i = lista.get(position);
        holder.TVTitulo.setText(i.getTitulo());
        holder.TVCuerpo.setText(i.getCuerpo());
//        holder.BTVer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("inmueble",i);
//                Navigation.findNavController(root).navigate(R.id.contratoDetalleFragment,bundle);
//
//            }
//        });
        holder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("nota", i);
                Navigation.findNavController(root).navigate(R.id.crearNotaFragment,bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder {

        private TextView TVTitulo,TVCuerpo;
        private Button editar;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            TVTitulo = itemView.findViewById(R.id.TVTitulo);
            editar = itemView.findViewById(R.id.BTEditar);
            TVCuerpo = itemView.findViewById(R.id.TVCuerpo);

        }
    }
}