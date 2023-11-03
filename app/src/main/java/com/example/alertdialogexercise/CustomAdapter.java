package com.example.alertdialogexercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    //fields//attributes
    private Context myContext;
    private List<EmergencyContact> emergencyContactList;
    private LayoutInflater inflater;

    //constructor
    public CustomAdapter(Context myContext, List<EmergencyContact> emergencyContactList) {
        this.myContext = myContext;
        this.emergencyContactList = emergencyContactList;
        inflater = LayoutInflater.from(myContext);
    }

    @Override
    public int getCount() {
        return emergencyContactList.size();
    }

    @Override
    public Object getItem(int position) {
        return emergencyContactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.emergency_call_list_item, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textViewItem);

        imageView.setImageResource(emergencyContactList.get(position).getImgResourceId());
        textView.setText("Call:   " + emergencyContactList.get(position).getName() + "   : "
                                    + emergencyContactList.get(position).getPhoneNumber());

        return convertView;
    }
}
