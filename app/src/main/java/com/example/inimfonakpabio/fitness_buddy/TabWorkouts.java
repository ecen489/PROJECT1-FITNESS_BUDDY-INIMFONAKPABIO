package com.example.inimfonakpabio.fitness_buddy;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;

public class TabWorkouts extends Fragment {

    GridLayout mainGrid;

    public TabWorkouts() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workouts, container, false);

        mainGrid = view.findViewById(R.id.mainGrid);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for(int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView card = (CardView) mainGrid.getChildAt(i);
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getContext(), GuideActivity.class);
                    switch (view.getId()) {
                        case R.id.W1:
                            intent.putExtra("VIDEORES", R.raw.vid1);
                            startActivity(intent);
                        case R.id.W2:
                            intent.putExtra("VIDEORES", R.raw.vid2);
                            startActivity(intent);
                        case R.id.W3:
                            intent.putExtra("VIDEORES", R.raw.vid3);
                            startActivity(intent);
                        case R.id.W4:
                            intent.putExtra("VIDEORES", R.raw.vid4);
                            startActivity(intent);
                        default:
                            //do nothing
                    }
                }
            });
        }
    }
}
