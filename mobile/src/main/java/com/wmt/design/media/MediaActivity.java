package com.wmt.design.media;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.wmt.design.R;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：9:52
 * modify developer：  admin
 * modify time：9:52
 * modify remark：
 *
 * @version 2.0
 */


public class MediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void onBtnClick(View view) {
        calculation(3);
    }

    Random random = new Random();

    private void calculation(int width) {
        int result = 0;
        int array[] = new int[width];

        for (int i = 0; i < width; i++) {
            int num = getRandomNum(random);
            array[i] = num;
        }
        for (int i = 0; i < width; i++) result += array[i];
        if (Math.abs(result) > 20) calculation(width);
        else {
            Integer[] sum = new Integer[width + 1];
            //Arrays.copy
            for (int i = 0; i < width; i++) sum[i] = array[i];
            sum[width] = result;
            transformArray(sum);//数组变换
        }

    }

    private void transformArray(Integer[] sum) {
        int length = sum.length;
        List<Integer> list = Arrays.asList(sum);
        Collections.shuffle(list);
        Integer[] sums = list.toArray(new Integer[length]);
        if (!printf(sums, random.nextInt(length)))//未知数随机值
            calculation(length-1);//此处可以去进行正负号变换，再使用transformArray
    }

    private boolean printf(Integer[] sum, int index) {
        int length = sum.length;
        if (sum[0] <= 0) return false;
        StringBuilder builder = new StringBuilder();
        if (sum[length - 1] < 0) return false;
        if (index == length - 1) {
            for (int i = 0; i < length - 1; i++) {
                builder.append(sum[i] > 0 ? "+" : "-");
            }
        } else {
            for (int i = 0; i < length - 1; i++) {
                if (index == i) {
                    if (i > 0)//第一个数没有正负号
                        builder.append(sum[i] > 0 ? "+" : "-");
                    builder.append("(__)");
                    continue;
                }
                if (i > 0 && sum[i] > 0) builder.append("+");
                builder.append(sum[i]);
            }
            builder.append("=");
            builder.append(sum[length - 1]);
        }
        if (builder.length() < length) return false;
        Log.i("builder", builder.toString());
        return true;
    }

    public int getRandomNum(Random random) {
        int num = random.nextInt(40) - 20;
        if (num == 0) return getRandomNum(random);
        return num;
    }

//        Arrays.copyOf()
//        if (result >= 0) {
//            array = dealWith(array);
//            if (array[0] < 0) calculation(width);
//            StringBuilder builder = new StringBuilder();
//            for (int i = 0; i < width; i++) {
//                if (i>0&&array[i] > 0) builder.append("+");
//                builder.append(array[i]);
//            }
//            builder.append("=(___)");
//            System.out.print(builder.toString());
//        }else{
//
//        }
//    /**
//     * 如果第一个是负数，这将第一个数与后面的正数做替换
//     * */
//    private int[] dealWith(int[] array) {
//        int result;
//        if (array[0] < 0) {
//            for (int i = 1; i < array.length; i++) {
//                result = array[i];
//                if (array[i] > 0) {
//                    array[i] = array[0];
//                    array[0] = result;//和array[0]交换数据
//                    break;
//                }
//            }
//        }
//        return array;
//    }

}
