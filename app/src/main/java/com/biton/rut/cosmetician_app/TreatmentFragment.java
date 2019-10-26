package com.biton.rut.cosmetician_app;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class TreatmentFragment extends Fragment implements AdapterView.OnItemClickListener
{

    ImageButton btnAddTreatment;
    ArrayList<Treatment> treatmentList;
    int itemCounter;
    ListView listView;
    private static TreatmentAdapter treatmentAdapter;
    private Cursor cursor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_treatment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        listView = (ListView) view.findViewById(R.id.treatmentListID);
        listView.setOnItemClickListener(this);

        cursor = getOption();
        getListItems(cursor);
        btnAddTreatment = view.findViewById(R.id.addTreatmentBtnID);
        btnAddTreatment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//                Intent contact = new Intent(getContext(), newCustomerActivity.class);
//                startActivity(contact);
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.addNewTreatmentFragment, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();


                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.mainContentID, new addnewtreatmentfragment()).commit();
                DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

            }
        });
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private void getListItems(Cursor cursor) {
        treatmentList = new ArrayList<>();
        //TODO:
        return;
    }
//    {
//        File imgFile = new File("/F/Users/Rut Biton/Documents/cosmetician_app/app/src/main/res/drawable/eyebrows_icon.png");
//        Bitmap myBitmap= null;
//        if(imgFile.exists()) {
//
//            myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//        }
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        myBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//        byte[] image = stream.toByteArray();
//        Customer c = new Customer("Rut", "Biton", null, "0583298226","Gmail",null,null,null, image);
//        treatmentList.add(new Treatment(new Date(), c, TREATMENT_TYPE.LIPS, MACHINE_TYPE.ANAT_WILL, null, null, 5.5f , image));
//
//
//        if(treatmentList.isEmpty()){
//            //show snake
//            Snackbar.make(listView, "No Items in List", Snackbar.LENGTH_LONG)
//                    .setAction("OK", null).show();
//
//        }
//        treatmentAdapter = new TreatmentAdapter(treatmentList ,getContext());
//        listView.setAdapter(treatmentAdapter);
//    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    private Cursor getOption()
    {
        return Main2Activity.sqLiteHelper.getData("SELECT * FROM TREATMENTS");
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
    {
        Customer item = (Customer) adapterView.getItemAtPosition(position);
    }
}
