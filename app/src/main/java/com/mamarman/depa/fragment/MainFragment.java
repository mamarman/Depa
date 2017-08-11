package com.mamarman.depa.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mamarman.depa.R;
import com.mamarman.depa.activity.MainActivity;

/**
 * Created by Malic on 8/7/2017.
 */

public class MainFragment  extends Fragment{

   private WebView webView;
    private ImageView imageDepa;
    private  Animation animation;
    SwipeRefreshLayout swipeRefresh;

    String url = "https://www.depadigitalworkforce.com/";



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_webview, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void initInstances(View rootView, Bundle savedInstanceState) {

        webView = (WebView) rootView.findViewById(R.id.webViewdepa);
        imageDepa = (ImageView) rootView.findViewById(R.id.img_depa);
        swipeRefresh = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefresh);

        animation = AnimationUtils.loadAnimation(getActivity(),R.anim.animfade_out);


        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!DetectConnection.chackInternetConnettion(getContext())){
                    Toast.makeText(getActivity()
                            ,"No internet",Toast.LENGTH_LONG).show();
                    swipeRefresh.setRefreshing(false);
                }
                else if (DetectConnection.chackInternetConnettion(getContext())){
                    Webload();
                    swipeRefresh.setRefreshing(false);
                }
            }
        });

        if (!DetectConnection.chackInternetConnettion(getContext())){
            Toast.makeText(getActivity()
                    ,"No internet",Toast.LENGTH_LONG).show();
            }
        else {
            if (savedInstanceState == null){
                imageDepa.startAnimation(animation);

                Webload();
            }
        }
    }

    private void Webload() {
        webView.loadUrl(url);
        webView.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null){
            webView.restoreState(savedInstanceState);
        }
    }

}
