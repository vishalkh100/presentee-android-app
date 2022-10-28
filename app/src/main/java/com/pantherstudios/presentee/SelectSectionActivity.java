package com.pantherstudios.presentee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.pantherstudios.presentee.Functions.DataGetSet;
//import com.pantherstudios.presentee.Functions.TinyDB;
import com.pantherstudios.presentee.Models.Section;
import com.pantherstudios.presentee.Models.SectionListAdapter;

import java.util.ArrayList;

public class SelectSectionActivity extends AppCompatActivity {

    DataGetSet dataGetSet;
    TextView titleHeading;
    ImageView addButton;
    ImageView backButton;
    ListView sectionListView;

    LinearLayout listViewLayout;
    LinearLayout noEntryLayout;

    ArrayList<Section> arrayOfSections = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_select_section);

        setViews();
        onClickListeners();

        //TinyDB tinydb = new TinyDB(this);
        //ArrayList<Object> playerObjects = tinydb.getListObject("sectionList", Section.class);

        ArrayList<Section> sectionList = new ArrayList<>();

        dataGetSet = MainActivity.dataGetSet;

        sectionList.add(new Section("Main"));
        sectionList.add(new Section("Production"));
        sectionList.add(new Section("Finishing"));
        sectionList.add(new Section("Extra"));

//        for(Object objs : playerObjects){
//            sectionList.add((Section) objs);
//        }
        arrayOfSections = sectionList;
//        dataGetSet.setArrayOfSections(arrayOfSections);

        SectionListAdapter adapter = new SectionListAdapter(this, arrayOfSections);
        if(!arrayOfSections.isEmpty()) {
            listViewLayout.setVisibility(View.VISIBLE);
        } else {
            listViewLayout.setVisibility(View.GONE);
        }
        sectionListView.setAdapter(adapter);

    }

    private void setViews() {
        titleHeading = findViewById(R.id.titleSections);
        addButton = findViewById(R.id.addButton);
        backButton = findViewById(R.id.backImgViewProd);
        sectionListView = findViewById(R.id.sectionListView);
        listViewLayout = findViewById(R.id.sectionListLayout);
        noEntryLayout = findViewById(R.id.noEntryLayoutSections);
    }

    private void onClickListeners() {
        addButton.setOnClickListener(
                v -> openAddTableActivity()
        );

        backButton.setOnClickListener(
                v -> openMainActivity()
        );

        sectionListView.setOnItemClickListener((parent, view, position, id) -> {
            Section p = (Section) parent.getItemAtPosition(position);
            dataGetSet.setSelectedSection(p);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }

    public void openAddTableActivity(){
        //Intent intent = new Intent(this, AddSectionActivity.class);
        //startActivity(intent);
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}