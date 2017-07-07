package com.wmt.design.path.measure;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.wmt.design.R;

public class WaveView extends View {

	private Paint paint;
	private Path path;
	private int waveLength = 800;
	private int dx;
	private int dy;
	protected float fraction;
	private Bitmap mBitmap;
	private PathMeasure mPathMeasure;
	private float[] pos;
	private float[] tan;
	private Matrix mMatrix;

	public WaveView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		paint = new Paint();
		paint.setColor(Color.RED);
		paint.setStyle(Style.FILL_AND_STROKE);
		
		path = new Path();
		
		Options options = new BitmapFactory.Options();
		options.inSampleSize = 2;
		mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.timg,options );
		
		setPathData();
		mPathMeasure = new PathMeasure(path, false);
		
		pos = new float[2];
		tan = new float[2];
		mMatrix = new Matrix();
	}

	private void setPathData() {
		path.reset();
		int originY = 500;
//		if(dy<originY + 150){
//			dy += 30;
//		}
		int halfWaveLength = waveLength/2;
		path.moveTo(-waveLength+dx, originY-dy);
		//屏幕的宽度里面放多少个波长
		for (int i = -waveLength; i < getWidth() + waveLength; i += waveLength) {
			//相对绘制二阶贝塞尔曲线(相对于自己的起始点--也即是上一个曲线的终点  的距离dx1)
			path.rQuadTo(halfWaveLength/2, -150, halfWaveLength, 0);
			path.rQuadTo(halfWaveLength/2, 150, halfWaveLength, 0);
//			path.quadTo(x1, y1, x2, y2)
			
		}
		//颜色填充
		//画一个封闭的空间
		path.lineTo(getWidth(), getHeight());
		path.lineTo(0, getHeight());
		path.close();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		
		float length = mPathMeasure.getLength();
		
//		boolean posTan = mPathMeasure.getPosTan(length*fraction, pos, tan);
		
		mMatrix.reset();
		//方法一：自己计算
		//将tan值通过反三角函数得到对应的弧度；然后将弧度转换成度数degree
//		float degrees = (float) (Math.atan2(tan[1], tan[0])*180f/Math.PI);
//		mMatrix.postRotate(degrees , mBitmap.getWidth()/2, mBitmap.getHeight()/2);
//		mMatrix.postTranslate( pos[0]-mBitmap.getWidth()/2, pos[1]-mBitmap.getHeight());
		//方法二：使用API
		mPathMeasure.getMatrix(length*fraction, mMatrix, PathMeasure.TANGENT_MATRIX_FLAG|PathMeasure.POSITION_MATRIX_FLAG);//flag:表示要求哪一个值：tan或者pos
		//修改偏移值----即让图片中心点与当前坐标点一致 来绘制
		mMatrix.preTranslate(-mBitmap.getWidth()/2, -mBitmap.getHeight());
		
		canvas.drawPath(path, paint);
//		canvas.drawBitmap(mBitmap, pos[0]-mBitmap.getWidth()/2, pos[1]-mBitmap.getHeight(), paint);
		canvas.drawBitmap(mBitmap, mMatrix, paint);
	}
	
	public void startAnimation(){
//		ValueAnimator animator = ValueAnimator.ofInt(0,waveLength);
//		animator.setDuration(1000);
//		animator.setInterpolator(new LinearInterpolator());
//		//无限循环
//		animator.setRepeatCount(ValueAnimator.INFINITE);
//		animator.addUpdateListener(new AnimatorUpdateListener() {
//			
//			@Override
//			public void onAnimationUpdate(ValueAnimator animation) {
//				dx = (int) animation.getAnimatedValue();
//				postInvalidate();
//			}
//		});
//		animator.start();
		
		ValueAnimator animator = ValueAnimator.ofFloat(0,1);
		animator.setDuration(5000);
		animator.setInterpolator(new LinearInterpolator());
		//无限循环
		animator.setRepeatCount(ValueAnimator.INFINITE);
		animator.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				fraction = (float) animation.getAnimatedValue();
				postInvalidate();
			}
		});
		animator.start();
		
	}
	
}
