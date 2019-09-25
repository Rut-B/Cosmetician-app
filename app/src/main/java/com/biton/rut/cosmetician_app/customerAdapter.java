package com.biton.rut.cosmetician_app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.ArrayList;

public class CustomerAdapter extends ArrayAdapter < Customer > {

    private ArrayList < Customer > dataSet;
    private Context mContext;
    private int lastPosition = -1;
    // View lookup cache
    private static class ViewHolder
    {
        TextView txtName;
        TextView txtTreatDate;
        Button isFavoriteBtn;
        Button treatmentBtn;
        Button contractBtn;
        ImageView profileImg;
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public CustomerAdapter(ArrayList < Customer > data, Context context)
    {
        super(context, R.layout.customer_layout, data);
        this.dataSet = data;
        this.mContext = context;

    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        Customer dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        final View result;

        if (convertView == null)
        {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.customer_layout, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.customerNameView);
            viewHolder.profileImg = (ImageView) convertView.findViewById(R.id.profileImageViewInList);
            viewHolder.txtTreatDate = (TextView) convertView.findViewById(R.id.treatDateView);
            viewHolder.isFavoriteBtn = convertView.findViewById(R.id.isFavoriteView);
            viewHolder.treatmentBtn =  convertView.findViewById(R.id.buttonTreatmeent);
            viewHolder.contractBtn = convertView.findViewById(R.id.buttonContract1);


            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

       /* Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);*/
        lastPosition = position;

        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtTreatDate.setText(dataModel.getName());

        byte[] invoiceImage = dataModel.getCustomerImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(invoiceImage, 0, invoiceImage.length);
        viewHolder.profileImg.setImageBitmap(bitmap);
        viewHolder.profileImg.setTag(position);

if(!dataModel.getIsFavorite())
    viewHolder.isFavoriteBtn.setVisibility(View.INVISIBLE);
   // viewHolder.isFavoriteBtn.setImageResource(R.drawable.ic_action_name);
if(!dataModel.haveContract())
    viewHolder.contractBtn.setVisibility(View.INVISIBLE);
if(!dataModel.haveTreatments())
    viewHolder.treatmentBtn.setVisibility(View.INVISIBLE);



        // Return the completed view to render on screen
        return convertView;
    }
}