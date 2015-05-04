package com.example.navigationdrawerexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class KromjalFragment extends Fragment {
	WebView webView;
	

	public KromjalFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment__kromjal, container, false);
		webView=(WebView) rootView.findViewById(R.id.web_create);
		webView.getSettings().setJavaScriptEnabled(true);
		 webView.getSettings().setBuiltInZoomControls(false);
		 webView.loadUrl("file:///android_asset/kromjal/kromjol.html");

		return rootView;
	}

}
