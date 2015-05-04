package com.example.navigationdrawerexample;

import android.os.Bundle;
import android.animation.AnimatorSet.Builder;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	// declare properties
	private String[] mNavigationDrawerItemTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;

	private ActionBarDrawerToggle mDrawerToggle;

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;
	public int SPosition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// for proper titles
		mTitle = mDrawerTitle = getTitle();

		// initialize properties
		mNavigationDrawerItemTitles = getResources().getStringArray(
				R.array.navigation_drawer_items_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// list the drawer items
		final ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[8];

		drawerItem[0] = new ObjectDrawerItem(R.drawable.home, "Home");
		drawerItem[1] = new ObjectDrawerItem(R.drawable.explor_khulna_logo,
				"সুন্দরবন");
		drawerItem[2] = new ObjectDrawerItem(R.drawable.explor_khulna_logo,
				"খুলনা বিশ্ববিদ্যালয়");
		drawerItem[3] = new ObjectDrawerItem(R.drawable.explor_khulna_logo,
				"রূপসা সেতু");
		drawerItem[4] = new ObjectDrawerItem(R.drawable.explor_khulna_logo,
				"করমজল");
		drawerItem[5] = new ObjectDrawerItem(R.drawable.explor_khulna_logo,
				"হিরন পয়েন্ট");
		drawerItem[6] = new ObjectDrawerItem(R.drawable.explor_khulna_logo,
				"কটকা");
		drawerItem[7] = new ObjectDrawerItem(R.drawable.explor_khulna_logo,
				"অন্যান্য");

		// Pass the folderData to our ListView adapter
		DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this,
				R.layout.listview_item_row, drawerItem);

		// Set the adapter for the list view
		mDrawerList.setAdapter(adapter);

		// set the item click listener
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// for app icon control for nav drawer
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.ic_drawer, /* nav drawer icon to replace 'Up' caret */
		R.string.drawer_open, /* "open drawer" description */
		R.string.drawer_close /* "close drawer" description */
		) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				getActionBar().setTitle(drawerItem[SPosition].name);
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getActionBar().setTitle(mDrawerTitle);
			}
		};

		// Set the drawer toggle as the DrawerListener
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		// enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			selectItem(0);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	// to change up caret
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	// navigation drawer click listener
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
			SPosition = position;
		}

	}

	private void selectItem(int position) {

		// update the main content by replacing fragments

		Fragment fragment = null;

		switch (position) {
		case 0:
			fragment = new Home_Fragment();
			break;
		case 1:
			fragment = new Sundarbans_Fragment();
			break;
		case 2:
			fragment = new KUFragment();
			break;
		case 3:
			fragment = new RupshaFragment();
			break;
		case 4:
			fragment = new KromjalFragment();
			break;
		case 5:
			fragment = new HironPointFragment();
			break;
		// case 6:
		// fragment = new Home_Fragment();
		// break;
		// case 7:
		// fragment = new Home_Fragment();
		// break;
		//
		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, fragment).commit();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(mNavigationDrawerItemTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);

		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}
	public void onBackPressed(){
		if (!mDrawerLayout.isDrawerOpen(mDrawerList)) {
			mDrawerLayout.openDrawer(mDrawerList);
		}
		  
		}

//	public void onBackPressed(View v) {
//
//		mDrawerLayout.openDrawer(Gravity.LEFT);

//		// TODO Auto-generated method stub
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//		// builder.setCancelable(false);
//		builder.setTitle("Wish u'll back soon");
//		builder.setMessage("Do you want to Exit?");
//		builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(), "Press Back once more",
//						Toast.LENGTH_LONG).show();
//
//				finish();
//			}
//		});
//		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				// TODO Auto-generated method stub
//				Toast.makeText(getApplicationContext(),
//						"i wanna stay on this page", Toast.LENGTH_LONG).show();
//				dialog.cancel();
//
//			}
//		});
//
//		AlertDialog alert = builder.create();
//		alert.show();
//		// super.onBackPressed();
	//}

}
