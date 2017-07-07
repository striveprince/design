package com.wmt.design.mask.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import com.wmt.design.R;

public class MaskFilterView extends View {
	/**
	 * 1.PorterDuff.Mode.CLEAR　　 　所绘制不会提交到画布上
	 2.PorterDuff.Mode.SRC　　　　　显示上层绘制图片
	 3.PorterDuff.Mode.DST　　　　　显示下层绘制图片
	 4.PorterDuff.Mode.SRC_OVER　　正常绘制显示，上下层绘制叠盖。
	 5.PorterDuff.Mode.DST_OVER　　上下层都显示。下层居上显示。
	 6.PorterDuff.Mode.SRC_IN　　　　取两层绘制交集。显示上层。
	 7.PorterDuff.Mode.DST_IN　　　　取两层绘制交集。显示下层。
	 8.PorterDuff.Mode.SRC_OUT　　　取上层绘制非交集部分。
	 9.PorterDuff.Mode.DST_OUT　　　取下层绘制非交集部分。
	 10.PorterDuff.Mode.SRC_ATOP　　取下层非交集部分与上层交集部分
	 11.PorterDuff.Mode.DST_ATOP　　取上层非交集部分与下层交集部分
	 12.PorterDuff.Mode.XOR　　　　　异或：去除两图层交集部分
	 13.PorterDuff.Mode.DARKEN　　　取两图层全部区域，交集部分颜色加深
	 14.PorterDuff.Mode.LIGHTEN　　　取两图层全部，点亮交集部分颜色
	 15.PorterDuff.Mode.MULTIPLY　　取两图层交集部分叠加后颜色
	 16.PorterDuff.Mode.SCREEN　　　 取两图层全部区域，交集部分变为透明色

	 滤镜效果和颜色通道过滤

	 1.自定义控件
	 2.动画--属性动画、补间动画、自绘动画（ValueAnimator+onDraw）
	 3.渲染效果--高级渲染、滤镜效果、颜色通道过滤（矩阵变换--高等数学，颜色矩阵）


	 一、滤镜效果
	 对图像进行一定的过滤加工处理。使用Paint设置滤镜效果。
	 1.Alpha滤镜处理
	 MaskFilter
	 paint.setMaskFilter(maskfilter)
	 (1).模糊遮罩滤镜（BlurMaskFilter）
	 (2).浮雕遮罩滤镜（EmbossMaskFilter）

	 2.颜色RGB的滤镜处理
	 ColorMatrix
	 滤镜的所有处理效果都是通过颜色矩阵的变换实现的。
	 比如：美颜相机实现的特效（高光、复古、黑白）

	 （1）什么是矩阵？

	 R
	 G>>1
	 B>>2

	 (2)例子：通过矩阵变换讲一个图片、颜色块，过滤掉其中的红色、绿色（只留下蓝色）

	 （3）色彩运算
	 1.色彩的平移运算（加法运算）

	 2.色彩的缩放运算（乘法运算）

	 运用：反相效果
	 RGB=100，200，250
	 RGB=155，55，5
	 效果：1.黑白图片处理
	 2.色彩发色效果



	 研究ColorMatrix的API
	 1、构造方法
	 ColorMatrix matrix = new ColorMatrix(new float[]{
	 ColorMatrix matrix = new ColorMatrix();
	 matrix.set(src)
	 2.设置色彩的缩放函数
	 matrix.setScale(1, 1, 1.4f, 1);
	 3.设置饱和度
	 饱和度设置（1，是原来不变；0灰色；>1增加饱和度）
	 matrix.setSaturation(progress);
	 4.色彩旋转函数

	 * axis,代表绕哪一个轴旋转，0,1,2
	 * 	(0红色轴，1绿色，2蓝色)
	 * degrees：旋转的度数

	 matrix.setRotate(0, progress);



	 5.ColorFilter使用的子类
	 ColorMatrixColorFilter：色彩矩阵的颜色顾虑器。
	 LightingColorFilter：过滤颜色和增强色彩的方法。（光照颜色过滤器）
	 PorterDuffColorFilter：图形混合滤镜（图形学的一个理论飞跃）

	 Xfermode

	 practise：把图片里面的红绿蓝分别抽出显示颜色。

	 * */



//	public MaskFilterView(Context context, AttributeSet attrs) {
//		super(context, attrs);
//	}

	private float progress;

	public MaskFilterView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
//		//需要关闭硬件加速（没有关闭则没效果）
//		setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//		paint.setColor(Color.RED);
//		RectF r = new RectF(100, 100, 300, 300);
		/**模糊遮罩滤镜效果
		 * BlurMaskFilter.Blur.INNER
		 * BlurMaskFilter.Blur.NORMAL
		 * BlurMaskFilter.Blur.OUTER
		 * BlurMaskFilter.Blur.SOLID
		 */
//		paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID));
		//浮雕滤镜效果（实现凸起的立体效果）
		/**
		 * direction, 指定长度为xxx的数组标量[x,y,z]，用来指定光源的位置
		 * ambient, 指定周边背景光源（0~1）
		 * specular, 指镜面反射系数
		 * blurRadius 指定模糊半径
		 */
//		paint.setMaskFilter(new EmbossMaskFilter(new float[]{30,30,30}, 0.2f, 60, 80));
//		canvas.drawRect(r , paint);
//		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.chrysanthemum2);
//		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon3);
//		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.btn_dialog);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.f_girl_dress);
//		canvas.drawBitmap(bitmap, 100, 300, paint);
		
		//====================颜色RGB的滤镜处理======================
		//需要关闭硬件加速（没有关闭则没效果）
		setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//		paint.setColor(Color.argb(255, 200, 100, 100));
//		canvas.drawRect(0, 0, 400, 400, paint);
		canvas.drawBitmap(bitmap, null, new RectF(0, 0, 400, 400*bitmap.getHeight()/bitmap.getWidth()), paint);
		
		canvas.translate(400, 0);
		
//		ColorMatrix matrix = new ColorMatrix(new float[]{
//				0,0,0,0,0,
//				0,1,0,0,200,
//				0,0,1,0,0,
//				0,0,0,1,0,
//		});
		//反相效果
//		ColorMatrix matrix = new ColorMatrix(new float[]{
//				-1,0,0,0,255,
//				0,-1,0,0,255,
//				0,0,-1,0,255,
//				0,0,0,1,0,
//		});
		//颜色增强（可以起到一个变亮的效果）---矩阵缩放方式
//		ColorMatrix matrix = new ColorMatrix(new float[]{
//				1.2f,0,0,0,0,
//				0,1.2f,0,0,0,
//				0,0,1.2f,0,0,
//				0,0,0,1.2f,0,
//		});
		//处理图片为黑白图片（图像学：如何让图片成为灰色即黑白？R+G+B=1）
		/**
		 * 
		去色原理：只要把RGB三通道的色彩信息设置成一样；即：R＝G
		＝B，那么图像就变成了灰色，并且，为了保证图像亮度不变，
		同一个通道中的R+G+B=1:如：0.213+0.715+0.072＝1； 
		RGB=0.213, 0.715, 0.072； 
		三个数字是根据色彩光波频率及色彩心理学计算出来的.
		 */
//		ColorMatrix matrix = new ColorMatrix(new float[]{
//				0.213f, 0.715f,0.072f,0,0,
//				0.213f, 0.715f,0.072f,0,0,
//				0.213f, 0.715f,0.072f,0,0,
//				0, 		0,		0,	  1f,0,
//		});
		//发色效果（比如红色和绿色交换----把第一行和第二行交换）
//		ColorMatrix matrix = new ColorMatrix(new float[]{
//			0,1f,0,0,0,
//			1f,0,0,0,0,
//			0,0,1f,0,0,
//			0,0,0,1f,0,
//		});
		//复古风格
//		ColorMatrix matrix = new ColorMatrix(new float[]{
//				1/2f,1/2f,1/2f,0,0,
//				1/3f,1/3f,1/3f,0,0,
//				1/4f,1/4f,1/4f,0,0,
//				0,0,0,1f,0,
//			});
		ColorMatrix matrix = new ColorMatrix();
//		matrix.set(src)
//		matrix.reset();//重置
		//色彩缩放
//		matrix.setScale(1, 1, 1.4f, 1);
		//饱和度设置（1，是原来不变；0灰色；>1增加饱和度）
//		matrix.setSaturation(progress);
		/**
		 * axis,代表绕哪一个轴旋转，0,1,2 
		 * 	(0红色轴，1绿色，2蓝色)
		 * degrees：旋转的度数
		 */
//		matrix.setRotate(0, progress);
		
		
		//设置颜色过滤器
//		paint.setColorFilter(new ColorMatrixColorFilter(matrix ));
		/**
		 * mul,multiply相乘 ---缩放
		 * add，相加---平移
		 */
//		paint.setColorFilter(new LightingColorFilter(0x00ff00, 0xff0000));
//		paint.setColorFilter(new LightingColorFilter(0xffffff, (int) progress));
//		paint.setColorFilter(new LightingColorFilter(0xffffff, 0x000000));
//		canvas.drawRect(0, 0, 400, 400, paint);
//		Xfermode图形混合滤镜
//		android.graphics.PorterDuff.Mode.
		paint.setColorFilter(new PorterDuffColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN));
//		paint.setColorFilter(new PorterDuffColorFilter(Color.argb(255, 140, 90, 200), PorterDuff.Mode.MULTIPLY));
		canvas.drawBitmap(bitmap, null, new RectF(0, 0, 400, 400*bitmap.getHeight()/bitmap.getWidth()), paint);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
//			progress += 0.3f;
//			progress += 20f;
			progress = 0xff0000;
			invalidate();
			break;

		case MotionEvent.ACTION_UP:
			progress = 0x000000;
			invalidate();
			break;
		default:
			break;
		}
		return true;
	}
	
	
}
