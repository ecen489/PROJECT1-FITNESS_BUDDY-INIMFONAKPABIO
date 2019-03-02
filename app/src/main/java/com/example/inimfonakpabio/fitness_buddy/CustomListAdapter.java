package com.example.inimfonakpabio.fitness_buddy;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Exercise> {

    private int resourceLayout;
    private Context mContext;

    public CustomListAdapter(Context context, int resource, List<Exercise> exercises) {
        super(context, resource, exercises);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View row, ViewGroup parents) {
        View cRow = row;
        if(cRow == null) {
            cRow = LayoutInflater.from(mContext).inflate(resourceLayout, parents, false);
        }
        Exercise curExercise = getItem(position);

        TextView textEx = (TextView) cRow.findViewById(R.id.textEx);
        TextView textMs = (TextView) cRow.findViewById(R.id.textMs);
        ImageView imageEx = (ImageView) cRow.findViewById(R.id.imageEx);

        if (curExercise != null) {
            textEx.setText(curExercise.exerciseName);
            textMs.setText(curExercise.muscleGroups);

            if(position == 0) {
                imageEx.setImageResource(curExercise.imageRes);
            } else if(position == 1) {
                imageEx.setImageResource(curExercise.imageRes);
            } else if(position == 2) {
                imageEx.setImageResource(curExercise.imageRes);
            } else {
                imageEx.setImageResource(curExercise.imageRes);
            }
        }


        return cRow;
    }
}
