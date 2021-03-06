package com.biton.rut.cosmetician_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //sql  DB
        sqLiteHelper = new SQLiteHelper(this, "CustomersDB.sqlite", null, 1);
//        sqLiteHelper.queryData("DROP TABLE IF EXISTS CUSTOMERS");
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS CUSTOMERS(Id INTEGER PRIMARY KEY AUTOINCREMENT, firstName VARCHAR,lastName VARCHAR,email VARCHAR, phoneNumber VARCHAR, addressC VARCHAR,addressS VARCHAR,addressB VARCHAR,addressA VARCHAR,isFavorite VARCHAR,haveContract VARCHAR,haveTreats VARCHAR,profileImage BLOB)");
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS TREATMENTS(Id INTEGER PRIMARY KEY AUTOINCREMENT, customerID INTEGER, dateDay VARCHAR, dateTime VARCHAR, treatment_type VARCHAR,machine_type VARCHAR,colorTreatment VARCHAR, treatmentImage BLOB , treatmentCost FLOAT)");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        goToCustomerPage();

    }

    private void goToCustomerPage(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContentID, new CustomersFragment()).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fragmentManager = getSupportFragmentManager();

        int id = item.getItemId();

        if (id == R.id.nav_customer) {
            fragmentManager.beginTransaction().replace(R.id.mainContentID, new CustomersFragment()).commit();
            // Handle the camera action
        } else if (id == R.id.nav_construct) {
            fragmentManager.beginTransaction().replace(R.id.mainContentID, new ContractsFragment()).commit();

        }  else if (id == R.id.nav_tool) {
            fragmentManager.beginTransaction().replace(R.id.mainContentID, new CustomerDetailsFragment()).commit();

        }
        else if (id == R.id.nav_gallery) {
            fragmentManager.beginTransaction().replace(R.id.mainContentID, new GalleryFragment()).commit();

        }
        else if (id == R.id.nav_treatment) {
            fragmentManager.beginTransaction().replace(R.id.mainContentID, new TreatmentFragment()).commit();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
