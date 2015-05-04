package com.example.navigationdrawerexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class KUFragment extends Fragment {
	WebView webView;
	public KUFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_ku, container, false);
		webView=(WebView) rootView.findViewById(R.id.web_ku);
		webView.getSettings().setJavaScriptEnabled(true);
		 webView.getSettings().setBuiltInZoomControls(true);
		 webView.loadUrl("file:///android_asset/ku/ku.html");
		return rootView;
	}

}
