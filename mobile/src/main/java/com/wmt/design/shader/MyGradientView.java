package com.wmt.design.shader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

import com.wmt.design.R;

public class MyGradientView extends View {

	private Bitmap bitmap;
	private Paint paint;
	private BitmapShader bitmapShader;
	private int width;
	private int height;
	private int[] colors = {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW};
	private RadialGradient radialGradient;
	private SweepGradient sweepGradient;
	private ComposeShader composeShader;

	public MyGradientView(Context context) {
		super(context);
		bitmap = ((BitmapDrawable)getResources().getDrawable(R.mipmap.icon)).getBitmap();
//		bitmap = ((BitmapDrawable)getResources().getDrawable(R.drawable.avatar3)).getBitmap();
		paint = new Paint();
		width = bitmap.getWidth();
		height = bitmap.getHeight();


	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);

//		canvas.drawBitmap(bitmap, 0, 0, paint);

		/**
		 * TileMode.CLAMP 拉伸最后一个像素去铺满剩下的地方
		 * TileMode.MIRROR 通过镜像翻转铺满剩下的地方。
		 * TileMode.REPEAT 重复图片平铺整个画面（电脑设置壁纸）
		 */
//		bitmapShader = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.MIRROR);
//		bitmapShader = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
		bitmapShader = new BitmapShader(bitmap, TileMode.REPEAT, TileMode.REPEAT);
		paint.setShader(bitmapShader);
//		paint.setAntiAlias(true);

		//设置像素矩阵，来调整大小，为了解决宽高不一致的问题。
//		float scale = Math.max(width, height)*1.0f/Math.min(width, height);
//		Matrix matrix = new Matrix();
//		matrix.setScale(scale, scale);//缩放比例
//		bitmapShader.setLocalMatrix(matrix);

//		canvas.drawRect(new Rect(0, 0, 800, 800), paint);
//		canvas.drawCircle(height/2, height/2, height/2, paint);
//		canvas.drawCircle(Math.min(width, height)/2f, scale*Math.max(width, height)/2f, Math.max(width, height)/2f, paint);

//		canvas.drawOval(new RectF(0, 0, width, height), paint);
//		canvas.drawOval(new RectF(0, 0, width, width), paint);

		//通过shapeDrawable也可以实现
//		ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
//		shapeDrawable.getPaint().setShader(bitmapShader);
//		shapeDrawable.setBounds(0, 0, width, width);
//		shapeDrawable.draw(canvas);


		/**线性渐变
		 * x0, y0, 起始点
		 *  x1, y1, 结束点
		 * int[]  colors, 中间依次要出现的几个颜色
		 * float[] positions,数组大小跟colors数组一样大，中间依次摆放的几个颜色分别放置在那个位置上(参考比例从左往右)
		 *    tile
		 */
//		LinearGradient linearGradient = new LinearGradient(0, 0, 400, 400, colors, null, TileMode.CLAMP);
		LinearGradient linearGradient = new LinearGradient(0, 0, 400, 400, colors, null, TileMode.REPEAT);
//		paint.setShader(linearGradient);
//		canvas.drawRect(0, 0, 400, 400, paint);

//		radialGradient = new RadialGradient(300, 300, 100, colors, null, TileMode.REPEAT);
//		paint.setShader(radialGradient);
//		canvas.drawCircle(300, 300, 300, paint);

//		sweepGradient = new SweepGradient(300, 300, colors, null);
//		paint.setShader(sweepGradient);
//		canvas.drawCircle(300, 300, 300, paint);

		composeShader = new ComposeShader(linearGradient, bitmapShader, PorterDuff.Mode.SRC_OVER);
		paint.setShader(composeShader);
		canvas.drawRect(0, 0, 800, 1000, paint);

	}

}
