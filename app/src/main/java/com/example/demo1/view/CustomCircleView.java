package com.example.demo1.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomCircleView extends View {
    private Paint paint;

    public CustomCircleView(Context context) {
        super(context);
        init();
    }

    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED); // 设置画笔颜色为红色
        paint.setStyle(Paint.Style.FILL); // 设置画笔风格为填充
        paint.setAntiAlias(true); // 设置抗锯齿
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 获取视图的宽度和高度
        int width = getWidth();
        int height = getHeight();

        // 计算圆心的坐标
        float centerX = width / 2;
        float centerY = height / 2;

        // 计算圆的半径（这里取视图宽度和高度中较小的一个的一半）
        float radius = Math.min(width, height) / 2;

        // 绘制圆形
        canvas.drawCircle(centerX, centerY, radius, paint);
    }

}
