package com.example.navigationdrawerexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class RupshaFragment extends Fragment {
	WebView webView;
	public RupshaFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_rupsha, container, false);
		webView=(WebView) rootView.findViewById(R.id.web_Rupsha_Bridge);
		webView.getSettings().setJavaScriptEnabled(true);
		 webView.getSettings().setBuiltInZoomControls(true);
		 webView.loadUrl("file:///android_asset/rupshaBridge/rupsha.html");
		return rootView;
	}

}
