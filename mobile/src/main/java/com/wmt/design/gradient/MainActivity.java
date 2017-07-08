package com.wmt.design.gradient;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyGradientView view = new MyGradientView(this);
//		ZoomImageView view = new ZoomImageView(this);
		setContentView(view);
		
//		setContentView(R.layout.activity_main);
	}

}
