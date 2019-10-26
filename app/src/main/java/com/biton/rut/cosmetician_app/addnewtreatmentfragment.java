package com.biton.rut.cosmetician_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

public class addnewtreatmentfragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        //get the spinner from the xml.
//        Spinner dropdown = findViewById(R.id.spinner1);
////create a list of items for the spinner.
//        String[] items = new String[]{"1", "2", "three"};
////create an adapter to describe how the items are displayed, adapters are used in several places in android.
////There are multiple variations of this, but this is the basic variant.
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
////set the spinners adapter to the previously created one.
//        dropdown.setAdapter(adapter);
        return inflater.inflate(R.layout.fragment_addnewtreatment, container, false);
    }
}
