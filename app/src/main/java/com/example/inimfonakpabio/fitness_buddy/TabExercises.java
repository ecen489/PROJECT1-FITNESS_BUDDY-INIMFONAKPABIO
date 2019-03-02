package com.example.inimfonakpabio.fitness_buddy;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class TabExercises extends Fragment {

    ListView listExercises;
    CustomListAdapter cListAdapter;
    ArrayList<Exercise> allExercises;

    public TabExercises() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercises, container, false);
        listExercises = (ListView) view.findViewById(R.id.listExercises);
        allExercises = new ArrayList<>();
        PopulateArray();

        cListAdapter = new CustomListAdapter(getContext(), R.layout.custom_listview, allExercises);
        listExercises.setAdapter(cListAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listExercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Exercise curEx = allExercises.get(i);
                Intent intent = new Intent(getContext(), GuideActivity.class);
                intent.putExtra("CURRENT_EXERCISE", curEx);
                startActivity(intent);
            }
        });
    }

    public void PopulateArray() {
        //String exNmae, int img, String musGrps, String equip, String instr
        allExercises.add(new Exercise("Bicep Curls", R.drawable.img_1, "Biceps", "Dumbbells",
                "Now, keeping the upper arms stationary, curl the weights while contracting your biceps.\n" +
                        "Raise the weights until your biceps are fully contracted and the dumbbells are at shoulder level.\n" +
                        "Hold the contracted position as you squeeze your biceps and return to the start position.\n"));
        allExercises.add(new Exercise("Overhead press", R.drawable.img_11, "(compound) Shoulders, upperbody", "Dumbbells, Barbells",
                "Stand with the bar on your front shoulders, and your hands next to your shoulders\n" +
                        "Press the bar over your head, until it’s balanced over your shoulders and mid-foot\n" +
                        "Lock your elbows at the top, and shrug your shoulders to the ceiling."));
        allExercises.add(new Exercise("Benchpress", R.drawable.img_9, "(compound) Arms, Chest, Shoulders, Back", "Flat Bench, Barbell",
                "Dismount the barbell using a grip that is a little over shoulder-width apart.\n" +
                        "Inhale as you lower the barbell to your chest, keeping your elbows tucked in at a 45-degree angle.\n" +
                        "Exhale as you press the barbell back up to the starting position."));
        allExercises.add(new Exercise("Dips", R.drawable.img_3, "Triceps, Chest, Front shoulders", "horizontal Bar",
                "Straighten your armss and lower your body by bending your arms while leaning forward.\n" +
                        "Dip down until your shoulders are below your elbows.\n" +
                        "Lift your body up by straightening your arms.\n" +
                        "Lock your elbows at the top."));
//        allExercises.add(new Exercise("Inclined Press", R.drawable.img_6, "Chest", "Dumbbell",
//                "Grab a barbell with an overhand grip that's shoulder-width apart and hold it above your chest.\n" +
//                        "Extend arms upward, locking out elbows."));
    }
}
