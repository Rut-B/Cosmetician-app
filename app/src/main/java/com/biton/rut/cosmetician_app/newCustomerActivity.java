package com.biton.rut.cosmetician_app;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class newCustomerActivity extends AppCompatActivity {
    ImageButton btn_save;
    //SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);
        init();
    }

    public void init() {
        //sqLiteHelper = new SQLiteHelper(this, "CustomersDB.sqlite", null, 1);
        btn_save = findViewById(R.id.saveNewBtn);
        btn_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //get all data from edit texts
                EditText fName = findViewById(R.id.fNameInput);
                EditText lName = findViewById(R.id.lNameInput);
                EditText addressCity = findViewById(R.id.addressCityInput);
                EditText addressStreet = findViewById(R.id.addressStreetInput);
                EditText addressBuilding = findViewById(R.id.addressBuildingInput);
                EditText addressApartment = findViewById(R.id.addressApartmentInput);

                EditText email = findViewById(R.id.emailInput);
                EditText phoneNumber = findViewById(R.id.phoneNumberInput);
                String fNameStr = fName.getText().toString().trim().toLowerCase();
                String lNameStr = lName.getText().toString().trim().toLowerCase();
                String addressCityStr = addressCity.getText().toString().trim().toLowerCase();
                String addressStreetStr = addressStreet.getText().toString().trim().toLowerCase();
                String addressBuildingStr = addressBuilding.getText().toString().trim().toLowerCase();
                String addressApartmentStr = addressApartment.getText().toString().trim().toLowerCase();
                String emailStr = email.getText().toString().trim().toLowerCase();
                String phoneNumberStr = phoneNumber.getText().toString().trim().toLowerCase();

                // check if required data was entered ??????????????????????????????
                //have  check if customer apears??????????????????????
                if(fNameStr.equals("")||lNameStr.equals("")||emailStr.equals("")) {
                    //returns, print error
                    Log.e("error", "required field is empty");
                    Toast.makeText(getApplicationContext(), "error! required field is empty",
                            Toast.LENGTH_LONG).show();
                    Snackbar.make(findViewById(R.id.scrollView), "No Items in List", Snackbar.LENGTH_LONG)
                            .setAction("OK", null).show();
                    return;

                }
                else {
                    try {
                        Main2Activity.sqLiteHelper.insertData(
                                fNameStr, lNameStr, emailStr, phoneNumberStr,
                                addressCityStr, addressStreetStr, addressBuildingStr, addressApartmentStr,
                                "false", "false", "false",
                                ImageHandler.imageViewToByte((ImageView)findViewById(R.id.profileImageView))
                        );
                        Toast.makeText(getApplicationContext(), "added successfully!",
                                Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Log.e("error", e.getMessage());
                        Toast.makeText(getApplicationContext(), "error!" +e.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                }



                Intent contact = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(contact);

            }
        });
    }
}
