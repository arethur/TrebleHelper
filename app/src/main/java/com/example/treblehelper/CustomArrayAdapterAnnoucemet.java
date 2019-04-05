package com.example.treblehelper;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomArrayAdapterAnnoucemet extends ArrayAdapter {

    private  Activity context;
    private  List<String> Array;

    public CustomArrayAdapterAnnoucemet(Activity context, List <String> nameArrayParam){
        super(context, R.layout.annoucementlayout, nameArrayParam);

        this.context = context;
        this.Array = nameArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater= context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.annoucementlayout, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.Annoucment);

        //this code sets the values of the objects to values from the arrays
           String [] element = Array.toArray(new String [0]);
           nameTextField.setText(element[position]);

        return rowView;

    }
}
