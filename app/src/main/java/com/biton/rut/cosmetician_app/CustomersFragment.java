package com.biton.rut.cosmetician_app;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomersFragment extends Fragment implements AdapterView.OnItemClickListener {

    ImageButton btn_plus;
    ArrayList<Customer> list;
    int itemCounter;
    ListView listView;
    LinearLayout searchPart;
    EditText searchText;
    private static CustomerAdapter adapter;
    private Cursor cursor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("!!!!!!!!!!!!!!!!!!!!!!", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        View rootView = inflater.inflate(R.layout.fragment_customers, container, false);
        //return inflater.inflate(R.layout.fragment_customers, container, false);
        Log.d("!!!!!!!!!!!!!!!!!!!!!!", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        return  rootView;
    }




    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
          init(view);
        Log.d("!!!!!!!!!!!!!!!!!!!!!!", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    }
    public void init(View view) {
        Toast.makeText(getContext(), "get HERE", Toast.LENGTH_SHORT).show();
        Log.d("!!!!!!!!!!!!!!!!!!!!!!", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        listView = (ListView) view.findViewById(R.id.customersList);
        searchText = (EditText)view.findViewById(R.id.searchInput);

        listView.setOnItemClickListener(this);

        cursor = getOption();
        getListItems(cursor);
         btn_plus = view.findViewById(R.id.plusBtn);
        btn_plus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent contact = new Intent(getContext(), newCustomerActivity.class);
                startActivity(contact);

            }
        });


    }



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private void getListItems(Cursor cursor)
    {
        list = new ArrayList<>();
        // get all data from sqlite
        for(int i=0; i<0; i++){
            Log.e("info", ""+i);
            Log.e("info", "" + cursor.moveToPosition(i));
            if(cursor.moveToPosition(i)) {
                String fname = cursor.getString(1);
                String lname = cursor.getString(2);
                String email = cursor.getString(3);
                String phoneNumber = cursor.getString(4);
                String addressC = cursor.getString(5);
                String addressS = cursor.getString(6);
                String addressB = cursor.getString(7);
                String addressA = cursor.getString(8);
                // have finish???????????????????????????????????????????????????
                byte[] image = cursor.getBlob(12);
                list.add(new Customer(fname, lname, addressC, email, phoneNumber, image));
            }

        }
       /* if(cursor!=null &&cursor.moveToFirst()) {
            do {
                Log.e("info", "" + cursor.moveToNext());

                int id = cursor.getInt(0);
                String fname = cursor.getString(1);
                String lname = cursor.getString(2);
                String email = cursor.getString(3);
                String phoneNumber = cursor.getString(4);
                String addressC = cursor.getString(5);
                String addressS = cursor.getString(6);
                String addressB = cursor.getString(7);
                String addressA = cursor.getString(8);
                // have finish???????????????????????????????????????????????????
                byte[] image = cursor.getBlob(12);
                list.add(new Customer(fname, lname, addressC, email, phoneNumber, image));
            }while (cursor.moveToNext());
            cursor.close();
        }*/
        //   Collections.reverse(list);
        if(list.isEmpty()){
            //show snake
            Snackbar.make(listView, "No Items in List", Snackbar.LENGTH_LONG)
                    .setAction("OK", null).show();

        }
        adapter = new CustomerAdapter(list,getContext());
        listView.setAdapter(adapter);
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    private Cursor getOption()
    {
        return Main2Activity.sqLiteHelper.getData("SELECT * FROM CUSTOMERS");
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
    {
        Customer item = (Customer) adapterView.getItemAtPosition(position);



    }






}
