package com.biton.rut.cosmetician_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class addnewtreatmentfragment extends Fragment {
    ImageView removerlBtn;
    ImageView lipsBtn;
    ImageView eyebrowsBtn;
    ImageView eyelinerBtn;
    String defaultSelesct;
    Spinner machineSpiner;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        defaultSelesct = TREATMENT_TYPE.REMOVER;
        View view =  inflater.inflate(R.layout.fragment_addnewtreatment, container, false);
        removerlBtn = view.findViewById(R.id.removerBtnID);
        eyelinerBtn = view.findViewById(R.id.eyelinerBtnID);
        eyebrowsBtn = view.findViewById(R.id.eyebrowsBtnID);
        lipsBtn = view.findViewById(R.id.lipsBtnID);
        machineSpiner = view.findViewById(R.id.machineSpinnerID);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, TREATMENT_TYPE.REMOVER_MACHINE);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        machineSpiner.setAdapter(adapter);
        return view;

    }

}
