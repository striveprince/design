package com.wmt.design.canvas.search;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.wmt.design.R;

public class SearcgActivity extends Activity {

	private MySearchView searchView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		searchView = (MySearchView)findViewById(R.id.sv);
		searchView.setController(new Controller1());
		
	}
	
	public void start(View v){
		searchView.startAnimation();
	}
	public void reset(View v){
		searchView.resetAnimation();
	}

}
