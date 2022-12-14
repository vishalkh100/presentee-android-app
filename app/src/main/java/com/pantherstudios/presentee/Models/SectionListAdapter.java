package com.pantherstudios.presentee.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pantherstudios.presentee.R;

import java.util.ArrayList;

public class SectionListAdapter extends ArrayAdapter<Section> {

    public SectionListAdapter(Context context, ArrayList<Section> users) {
        super(context, 0, users);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Section section = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_section, parent, false);
        }

        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.sectionName);

        // Populate the data into the template view using the data object
        tvName.setText(section.name);

        // Return the completed view to render on screen
        return convertView;

    }

}