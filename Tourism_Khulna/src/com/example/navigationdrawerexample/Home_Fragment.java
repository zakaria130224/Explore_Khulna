package com.example.navigationdrawerexample;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class Home_Fragment extends Fragment {
Button about;
Button em;
	

	public Home_Fragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_home, container, false);

		about=(Button) rootView.findViewById(R.id.about);
		about.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "@zakaria Ahammed \n Mob:01612130224 \n CSE,Khulna University ",Toast.LENGTH_LONG).show();
			}
		});
		em=(Button) rootView.findViewById(R.id.button1);
		em.setOnClickListener(new OnClickListener() {
			
			

			@Override
			public void onClick(View arg0) {
				
				
			}
		});
		
		return rootView; 
	}
	public void bAbout(View v) {
	
		Toast.makeText(getActivity(), "@zakaria Ahammed \n mob:01612130224",Toast.LENGTH_LONG).show();
	}

}
