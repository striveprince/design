package com.wmt.design.gradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class LinearGradientTextView extends TextView {

	private TextPaint paint;
	private LinearGradient linearGradient;
	private Matrix matrix;
	private float translateX;
	private float deltaX = 20;

	public LinearGradientTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		paint = getPaint();
		//GradientSize=�������ֵĴ�С
		String text = getText().toString();
		float textWidth = paint.measureText(text);
		int GradientSize =(int) (3*textWidth/text.length()); 
		linearGradient = new LinearGradient(-GradientSize, 0, 0, 0, new int[]{0x22ffffff,0xffffffff,0x22ffffff}, new float[]{0,0.5f,1}, TileMode.CLAMP);//��Ե�ں�
		paint.setShader(linearGradient);
		matrix = new Matrix();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		float textWidth = getPaint().measureText(getText().toString());
		translateX += deltaX;
		if(translateX > textWidth + 1|| translateX < 1){
			deltaX = -deltaX;
		}
//		matrix.setScale(sx, sy)
		matrix.setTranslate(translateX, 0);
		linearGradient.setLocalMatrix(matrix);
		
		postInvalidateDelayed(50);
	}

}
