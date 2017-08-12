package com.mamarman.depa.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mamarman.depa.R;
import com.mamarman.depa.activity.MainActivity;

/**
 * Created by Malic on 8/11/2017.
 */

public class InterLostFragment extends Fragment {

    SwipeRefreshLayout swRefreshLost;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.inter_lost, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void initInstances(View rootView, Bundle savedInstanceState) {

        swRefreshLost = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLostInternet);

        swRefreshLost.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!DetectConnection.chackInternetConnettion(getContext())){
                    swRefreshLost.setRefreshing(false);
                }
                else {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }

            }
        });


    }


    @Override
    public void onResume() {
        super.onResume();
        if (!DetectConnection.chackInternetConnettion(getContext())){
            Log.d("show","Intertlost");
        }
        else {
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
        }

    }

}
