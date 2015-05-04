package com.example.navigationdrawerexample;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.navigationdrawerexample.R;


public class KotkaFragment extends Fragment {
	WebView webView;
	

	public KotkaFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_kotka, container, false);
		webView=(WebView) rootView.findViewById(R.id.web_create);
		webView.getSettings().setJavaScriptEnabled(true);
		 webView.getSettings().setBuiltInZoomControls(false);
		webView.loadUrl("file:///android_asset/kotka/kotka.html");

		return rootView;
	}

}
