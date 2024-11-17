package com.example.demo1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.animation.ValueAnimator;

public class AnimatedCircleView extends View {

    private Paint paint;
    private float radius = 50; // 初始半径
    private ValueAnimator animator;

    public AnimatedCircleView(Context context) {
        super(context);
        init();
    }

    public AnimatedCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AnimatedCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        // 创建动画
        animator = ValueAnimator.ofFloat(50, 100); // 半径从50变化到100
        animator.setDuration(1000); // 动画时长1秒
        animator.setInterpolator(new LinearInterpolator()); // 线性插值器
        animator.setRepeatCount(ValueAnimator.INFINITE); // 无限重复
        animator.setRepeatMode(ValueAnimator.REVERSE); // 往返重复

        // 添加动画更新监听器
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                radius = (float) animation.getAnimatedValue(); // 更新半径值
                invalidate(); // 重新绘制视图
            }
        });

        // 启动动画
        animator.start();
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

        // 绘制圆形
        canvas.drawCircle(centerX, centerY, radius, paint);
    }

    // 清理资源
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (animator != null && animator.isRunning()) {
            animator.cancel();
        }
    }
}