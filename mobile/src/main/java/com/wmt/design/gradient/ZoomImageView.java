package com.wmt.design.gradient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.MotionEvent;
import android.view.View;

import com.wmt.design.R;

public class ZoomImageView extends View {

	private Bitmap bitmap;
	private ShapeDrawable drawable;
	//�Ŵ���
	private static final int FACTOR = 3;
	//�Ŵ󾵵İ뾶
	private static final int RADIUS = 100;
	private Matrix matrix = new Matrix();

	public ZoomImageView(Context context) {
		super(context);
		bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.icon2);
		Bitmap bmp = bitmap;
		//�Ŵ�������ͼƬ
		bmp = Bitmap.createScaledBitmap(bmp, bmp.getWidth()*FACTOR, bmp.getHeight()*FACTOR, true);
		//����һ��Բ�ε�ͼƬ(�Ŵ�ľֲ�)������canvas����
		BitmapShader shader = new BitmapShader(bmp, TileMode.CLAMP, TileMode.CLAMP);
		drawable = new ShapeDrawable(new OvalShape());
		drawable.getPaint().setShader(shader);
		//�г���������---���ڻ���Բ������Բ��
		drawable.setBounds(0, 0, RADIUS*2, RADIUS*2);
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawBitmap(bitmap, 0, 0, null);
		//�������õ�Բ��ͼƬ
		drawable.draw(canvas);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();
		
		matrix.setTranslate(RADIUS - x*FACTOR, RADIUS - y*FACTOR);
		drawable.getPaint().getShader().setLocalMatrix(matrix);
		
		drawable.setBounds(x-RADIUS, y-RADIUS, x+RADIUS, y+RADIUS);
		
		invalidate();
		return true;
	}
	
}
