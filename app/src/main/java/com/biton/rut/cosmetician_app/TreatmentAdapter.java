package com.biton.rut.cosmetician_app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TreatmentAdapter extends ArrayAdapter < Treatment > {

    private ArrayList < Treatment > dataSet;
    private Context mContext;
    private int lastPosition = -1;
    // View lookup cache
    private static class ViewHolder
    {
        ImageView treatmentImg;
        TextView txtName;
        ImageView customerImg;
        TextView txtTreatDate;
        TextView txtTreatTime;

    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public TreatmentAdapter(ArrayList < Treatment > data, Context context)
    {
        super(context, R.layout.treatment_layout, data);
        this.dataSet = data;
        this.mContext = context;

    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        Treatment dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        final View result;

        if (convertView == null)
        {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.treatment_layout, parent, false);
            viewHolder.treatmentImg = (ImageView) convertView.findViewById(R.id.treatmentViewID);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.customerNameTreatID);
            viewHolder.customerImg = (ImageView) convertView.findViewById(R.id.imageCustomerID);
            viewHolder.txtTreatDate = (TextView) convertView.findViewById(R.id.treatDateViewID);
            viewHolder.txtTreatTime = (TextView) convertView.findViewById(R.id.treatTimeViewID);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

       /* Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);*/
        lastPosition = position;

        byte[] treatmentImage = dataModel.getTreatmentImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(treatmentImage, 0, treatmentImage.length);
        viewHolder.customerImg.setImageBitmap(bitmap);
        viewHolder.customerImg.setTag(position);

        viewHolder.txtName.setText(dataModel.getCustomerTreatment().getName());

        byte[] customerImage = dataModel.getCustomerTreatment().getCustomerImage();
        bitmap = BitmapFactory.decodeByteArray(customerImage, 0, customerImage.length);
        viewHolder.customerImg.setImageBitmap(bitmap);
        viewHolder.customerImg.setTag(position);

        viewHolder.txtTreatDate.setText(dataModel.getDate().toString());
        //TODO:
        //change to time only
        viewHolder.txtTreatTime.setText(dataModel.getDate().toString());


        // Return the completed view to render on screen
        return convertView;
    }
}