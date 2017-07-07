package com.wmt.design.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path.Direction;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//绘制直线
		Paint paint = new Paint();
		paint.setColor(Color.RED);
//		paint.setStyle(Style.FILL);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(5);
		
		
//		canvas.drawLine(0, 0, 100, 100, paint);
		float []pts = {0,0,100,100,200,200,300,300};
//		canvas.drawLines(pts, paint);
//		canvas.drawLines(pts, 20, 2, paint);//通过offset设置线的间隔距离，可以实现虚线效果
		
		//		canvas.drawPoint(500, 500, paint);
//		canvas.drawPoints(pts, paint);
		//Rect int和RectF float
//		RectF r = new RectF(100, 100, 400, 500);
//		canvas.drawRect(r, paint);
//		canvas.drawRect(left, top, right, bottom, paint);
		//画圆角矩形
		//x-radius ,y-radius圆角的半径 
//		canvas.drawRoundRect(r, 30, 30, paint);
		
//		canvas.drawCircle(300, 300, 200, paint);
		paint.setColor(Color.GREEN);
//		canvas.drawOval(r, paint);
		
//		canvas.drawArc(
//				r, 
//				startAngle, //其实角度，相对X轴正方向
//				sweepAngle, //画多少角度的弧度
//				useCenter, //boolean, false：只有一个纯弧线；true：闭合的边
//				paint)；
//		canvas.drawArc(r, 0, 90, true, paint);//顺时针旋转90度
		
//		Path path = new Path();
//		path.moveTo(100, 100);//画笔落笔的位置
//		//移动
//		path.lineTo(200, 100);
////		path.lineTo(200, 200);
//		path.cubicTo(250, 200, 350, 300, 450, 400);
//		path.close();
//		
//		canvas.drawPath(path, paint);
		
		//圆角矩形路径
//		float radii[] = {10,10,10,10,10,10,50,60};
//		path.addRoundRect(r, radii, Direction.CCW);
//		path.addArc(oval, startAngle, sweepAngle)
//		canvas.drawPath(path, paint);
		
		
//		RectF r = new RectF(100, 100, 400, 500);
//		Path path = new Path();
//		path.addOval(r, Direction.CCW);
//		
//		//创建一块矩形的区域
//		Region region = new Region(100, 100, 400, 500);
//		Region region1 = new Region();
//		region1.setPath(path, region);//path的椭圆区域和矩形区域进行交集
//		
//		//结合区域迭代器使用（得到图形里面的所有的矩形区域）
//		RegionIterator iterator = new RegionIterator(region1);
//		
//		Rect rect = new Rect();
//		while (iterator.next(rect)) {
//			canvas.drawRect(rect, paint);
//		}
//		//合并
//		region.union(r);
//		region.op(r, Op.INTERSECT);//交集部分
		
		//--------------------Canvas变换技巧--------------------------
		//1.平移（Translate）
//		RectF r = new RectF(0, 0, 400, 500);
//		canvas.drawRect(r, paint);
//		paint.setColor(Color.BLUE);
//		//将画布平移
//		canvas.translate(50, 50);
//		//当canvas执行drawXXX的时候就会新建一个新的画布图层
//		canvas.drawRect(r, paint);
//		RectF r2 = new RectF(0, 0, 400, 500);
//		paint.setColor(Color.RED);
//		//虽然新建了一个画布图层，但是还是会沿用之前设置的平移变换。不可逆的。（save和restore来解决）
//		canvas.drawRect(r2, paint);
		//2.缩放Scale
//		RectF r = new RectF(0, 0, 400, 500);
//		canvas.drawRect(r, paint);
//		paint.setColor(Color.BLUE);
		//sx,sy：分别对x/y方向的一个缩放系数,画布的缩放会导致里面所有的绘制的东西都会有一个缩放效果
//		canvas.scale(1.5f, 0.5f);
//		canvas.drawRect(r, paint);
		
		//3.旋转Rotate
//		RectF r = new RectF(200, 200, 400, 500);
//		canvas.drawRect(r, paint);
//		paint.setColor(Color.BLUE);
//		canvas.rotate(45);
//		canvas.rotate(45, 200, 200);
//		canvas.drawRect(r, paint);
		
		//4.斜拉画布Skew
//		RectF r = new RectF(200, 200, 400, 500);
//		canvas.drawRect(r, paint);
//		paint.setColor(Color.BLUE);
//		//sx,sy倾斜度：X轴方向上倾斜60度，tan60=根号3
//		canvas.skew(1.73f, 0);
//		canvas.drawRect(r, paint);
		//5.裁剪画布clip
		RectF r = new RectF(200, 200, 400, 500);
		canvas.drawRect(r, paint);
		paint.setColor(Color.BLUE);
		canvas.clipRect(new Rect(250, 250, 300, 400));
		canvas.drawColor(Color.YELLOW);
		
		
		
	}
	
}
