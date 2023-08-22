package com.example.bibliotecasena.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bibliotecasena.R;
import com.example.bibliotecasena.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        final LinearLayout capa=(LinearLayout) root.findViewById(R.id.capa);
        final TextView cr_dispo=(TextView) root.findViewById(R.id.cr_dispo);
        final ImageView img=(ImageView) root.findViewById(R.id.img);
        final EditText codigo=(EditText) root.findViewById(R.id.codigo);
        final EditText serial=(EditText) root.findViewById(R.id.serial);
        final EditText referencia=(EditText) root.findViewById(R.id.referencia);
        final Spinner estado =(Spinner) root.findViewById(R.id.estado);
        final LinearLayout capa2 =(LinearLayout) root.findViewById(R.id.capa2);
        final Button guardar=(Button) root.findViewById(R.id.guardar);
        final Button cancelar=(Button) root.findViewById(R.id.cancelar);

        final Spinner sp_dispo =(Spinner) root.findViewById(R.id.sp_dispo);

        sp_dispo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                 switch (position){
                     case 0:
                         capa.setVisibility(View.INVISIBLE);
                         break;
                     case 1:
                         capa.setVisibility(View.VISIBLE);
                         cr_dispo.setText(parent.getSelectedItem().toString());
                         img.setImageResource(R.drawable.video);
                         break;
                     case 2 :
                         capa.setVisibility(View.VISIBLE);
                         cr_dispo.setText(parent.getSelectedItem().toString());
                         img.setImageResource(R.drawable.por);
                         break;
                     case 3:
                         capa.setVisibility(View.VISIBLE);
                         cr_dispo.setText(parent.getSelectedItem().toString());
                         img.setImageResource(R.drawable.mouse);
                         break;
                     case 4:
                         capa.setVisibility(View.VISIBLE);
                         cr_dispo.setText(parent.getSelectedItem().toString());
                         img.setImageResource(R.drawable.tecla);
                         break;
                     case 5:
                         capa.setVisibility(View.VISIBLE);
                         cr_dispo.setText(parent.getSelectedItem().toString());
                         img.setImageResource(R.drawable.cable);
                         break;





                 }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}