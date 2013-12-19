package com.lujianfei.view_pager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private ArrayList<View> listViews=null;
	ViewPager viewPager = null;
	private LinearLayout smalldots;
	int numOfPager = 3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
		
		initData();
	}
	private void initData() {
		ImageView dot=null;
		ImageView pager=null;
		//Ìí¼Ó»¬¶¯Ð¡Ô²µã
		for(int i=0;i<numOfPager;i++){
			dot=new ImageView(this);
			LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			lp.setMargins(0, 0, 10, 0);
			dot.setLayoutParams(lp);
			dot.setImageResource(R.drawable.selector_iv_dot);
			smalldots.addView(dot);
		}
		smalldots.getChildAt(0).setSelected(true);
		listViews = new ArrayList<View>();
		for(int i=0;i<numOfPager;i++){
			pager=new ImageView(this);
			pager.setImageResource(R.drawable.ic_launcher);
			pager.setFocusable(false);
			listViews.add(pager);
		}
		viewPager.setAdapter(new MyPagerAdapter(listViews));
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}
	private void initView() {
		smalldots=(LinearLayout) findViewById(R.id.smalldots);
		viewPager = (ViewPager) findViewById(R.id.viewPager);
	}

	/**
	* ViewPagerÊÊÅäÆ÷
	*/
    class MyPagerAdapter extends PagerAdapter{
		public List<View> mListViews;

		public MyPagerAdapter(List<View> mListViews) {
		this.mListViews = mListViews;
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
		((ViewPager) arg0).removeView(mListViews.get(arg1));
		}

		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public int getCount() {
		return mListViews.size();
		}

		@Override
		public Object instantiateItem(View arg0, final int position) {
		 View view = mListViews.get(position);
		 view.setOnClickListener(new OnClickListener() {
			 @Override
			   public void onClick(View v) {
			   }
		  });
		  ViewPager viewPager = (ViewPager) arg0;
		  viewPager.addView(view);
		  return mListViews.get(position);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == (arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		@Override
		public Parcelable saveState() {
		return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}
    }
    /**
	* Ò³¿¨ÇÐ»»¼àÌý
	*/
	public class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageSelected(int arg0) {
			ImageView child=null;
			if(viewPager.getAdapter().getCount()>0){
				for(int i=0;i<smalldots.getChildCount();i++){
					child=(ImageView) smalldots.getChildAt(i);
					if(i==arg0){
						child.setSelected(true);
					}else{
						child.setSelected(false);
					}
				}
			}
			
		}
	
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
