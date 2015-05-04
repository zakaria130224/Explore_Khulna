package com.example.navigationdrawerexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class Sundarbans_Fragment extends Fragment {
	WebView webView;
	

	public Sundarbans_Fragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_sundarbans, container, false);
		webView=(WebView) rootView.findViewById(R.id.web_create);
		webView.getSettings().setJavaScriptEnabled(true);
		 webView.getSettings().setBuiltInZoomControls(false);
		 webView.loadUrl("file:///android_asset/Sundarban/sundarban.html");

		return rootView;
	}

}
