package com.biton.rut.cosmetician_app;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class newCustomerActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST = 0;
    private static final int RESULT_LOAD_IMAGE = 1;
    private static final int GALLERY = 0;
    private static final int CAMERA = 1;

    ImageButton btn_save;
    Button loadFromMemory;
    Button imgFromCamera;
    ImageView profileImage;
    //SQLiteHelper sqLiteHelper;
    private String cameraFilePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);
        /*if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
          requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST);
        }*/
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED) {
requestPermissions( new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
                }
        init();
    }

    public void init() {
        profileImage = findViewById(R.id.profileImageView);
        loadFromMemory = findViewById(R.id.btnLooadFromMemory);
        loadFromMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImgFromMemoryFunc(view);
            }
        });
        imgFromCamera = findViewById(R.id.btnFromCamera);
        imgFromCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImgFromCameraFunc(view);
            }
        });
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


    public void loadImgFromMemoryFunc(View view) {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    public void loadImgFromCameraFunc(View view) {
        showPictureDialog();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);// have change????????????????
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case RESULT_LOAD_IMAGE:
                if(resultCode==RESULT_OK){
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();
                    profileImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                }
        }
    }*/


    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }


    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }
    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
        /*try {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", createImageFile()));
            startActivityForResult(intent, CAMERA);
        } catch (IOException ex) {
            ex.printStackTrace();
            Log.e("error", ex.getMessage());
        }*/
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                   // String path = saveImage(bitmap);
                    profileImage.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(newCustomerActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            //profileImage.setImageURI(Uri.parse(cameraFilePath));


            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
           profileImage.setImageBitmap(thumbnail);
            //saveImage(thumbnail);
        }
    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + "IMAGE_DIRECTORY");// have to change???????????????
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        //This is the directory in which the file will be created. This is the default location of Camera photos
        File storageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DCIM), "Camera");
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        // Save a file: path for using again
        cameraFilePath = "file://" + image.getAbsolutePath();
        return image;
    }
}
