package com.example.proyecto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FactoFragment extends Fragment {

    MyViewModelFactos myViewModelFactos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_facto, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myViewModelFactos = new ViewModelProvider(requireActivity()).get(MyViewModelFactos.class);
        List listaImagenes = new ArrayList<>();
        listaImagenes.add(R.drawable.images1);
        listaImagenes.add(R.drawable.images2);
        listaImagenes.add(R.drawable.images3);
        listaImagenes.add(R.drawable.images4);
        listaImagenes.add(R.drawable.images5);
        listaImagenes.add(R.drawable.images6);
        listaImagenes.add(R.drawable.images7);
        listaImagenes.add(R.drawable.images8);
        listaImagenes.add(R.drawable.images9);
        listaImagenes.add(R.drawable.images10);
        TextView textView = view.findViewById(R.id.facto);
        ImageView imageView = view.findViewById(R.id.imageView);

        myViewModelFactos.getFact().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(String s) {
               Random random = new Random();
                int randomIndex = random.nextInt(listaImagenes.size());
                imageView.setImageResource((Integer) listaImagenes.get(randomIndex));
                textView.setText(s);
            }
        });
        ToggleButton toggleButton = view.findViewById(R.id.toggle_star);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myViewModelFactos.getFacto();
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                  List<String> tempList = myViewModelFactos.getFavoritos().getValue();
                  tempList.add((String) textView.getText());
                  myViewModelFactos.getFavoritos().setValue(tempList);
                    Toast.makeText(requireActivity(), "Favorito añadido", Toast.LENGTH_SHORT).show();
                } else {


                }
            };

    });
}
}