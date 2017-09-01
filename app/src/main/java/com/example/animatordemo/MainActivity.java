package com.example.animatordemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 属性动画
 */

public class MainActivity extends AppCompatActivity {

    private ImageView icon;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //显示当前页面布局
        setContentView(R.layout.activity_main);
        icon = (ImageView) findViewById(R.id.main_icon);
        container = (LinearLayout) findViewById(R.id.container);
    }

    //Hello World的点击监听
    public void onClick(View view) {

        //属性动画 ValueAnimator 的用法  ,属性动画本质是值动画
        //参数是多参的  可以随意设置
        //ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f,1f,0.5f);   设置渐变使用

        //ValueAnimator valueAnimator = ValueAnimator.ofInt(0,400);   int类型   设置缩放从小到大

        //ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f,1f); float类型 设置缩放从小到大

        //设置执行的时间
        //valueAnimator.setDuration(2000);
        //改变的监听事件
        //valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        //@Override
        //public void onAnimationUpdate(ValueAnimator animation) {
                /*float animatedValue = (float) animation.getAnimatedValue();
                设置执行动画的方式   (alpha  渐变  用有到无)
                icon.setAlpha(animatedValue);*/

                /*//int类型  缩放 从小到大
                int animatedValue = (int) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = icon.getLayoutParams();
                layoutParams.width = animatedValue;
                layoutParams.height = animatedValue;
                icon.setLayoutParams(layoutParams);*/

        //float类型 缩放从小到大
                /*float animatedValue = (float) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = icon.getLayoutParams();
                layoutParams.width = (int) (animatedValue*600);
                layoutParams.height = (int) (animatedValue*600);
                icon.setLayoutParams(layoutParams);*/
        //}
        //});
        //执行动画
        //valueAnimator.start();

        //ObjectAnimator的用法
        //透明度变化
        /*ObjectAnimator alphaObjectAnimator = ObjectAnimator.ofFloat(icon,"alpha",0f,1f,0.5f);
        alphaObjectAnimator.setDuration(2000).start();*/

        //缩放变化(原位置  旋转缩放)
        /*ObjectAnimator scaleObjectAnimator = ObjectAnimator.ofFloat(icon,"scaleX",0f,1f,0.5f);
        scaleObjectAnimator.setDuration(2000).start();*/

        /*//平移变化  (从左向右)
        ObjectAnimator translationXObjectAnimator = ObjectAnimator.ofFloat(icon,"translationX",0f,1000f);
        translationXObjectAnimator.setDuration(2000).start();*/

        //旋转+平移动画                                                            //反向旋转  一周
        /*ObjectAnimator rotationObjectAnimator = ObjectAnimator.ofFloat(icon,"rotation",0f,-360f);
        //设置执行的时间
        rotationObjectAnimator.setDuration(2000);
        //设置重复的次数
        rotationObjectAnimator.setRepeatCount(3);
        //设置重复的模式                                    //反向
        rotationObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);

        rotationObjectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        //启动动画
        rotationObjectAnimator.start();*/

        //ViewPropertyAnimator的用法  综合用法
        /*icon.animate().alpha(0.5f)
                .translationX(100f)
                .rotation(180)
                .scaleX(2)
                .scaleY(2)
                .setDuration(3000)
                .start();*/

        /*//AnimatorSet 组合动画
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator alphaObjectAnimator = ObjectAnimator.ofFloat(icon,"alpha",0f,1f,0.5f);
        ObjectAnimator scaleXObjectAnimator = ObjectAnimator.ofFloat(icon,"scaleX",0f,1f,0.5f);
        //几种不同的组合方式  有with together   渐变+缩放旋转
        //animatorSet.play(alphaObjectAnimator).with(scaleXObjectAnimator);
        //animatorSet.playTogether(alphaObjectAnimator,scaleXObjectAnimator);
        //有先后顺序的执行   先渐变之后再旋转
        //animatorSet.playSequentially(alphaObjectAnimator,scaleXObjectAnimator);
        animatorSet.setDuration(3000);
        animatorSet.start();*/

        //ObjectAnimator也可以来实现组合动画
        //渐变+缩放
        /*PropertyValuesHolder alphaXPropertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", 0f, 1f, 0.5f);
        PropertyValuesHolder scaleXPropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleX", 1f, 2f);
        ObjectAnimator rotationObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(icon,alphaXPropertyValuesHolder,scaleXPropertyValuesHolder);
        rotationObjectAnimator.setDuration(3000);
        rotationObjectAnimator.start();*/

        //用valueAnimator实现组合动画
        //渐变+缩放   从小到大
        /*ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = icon.getLayoutParams();
                layoutParams.width = (int) (animatedValue * 300);
                layoutParams.height = (int) (animatedValue * 300);
                icon.setLayoutParams(layoutParams);
                icon.setAlpha(animatedValue);
            }
        });
        valueAnimator.start();*/

        /**
         * XML文件格式的组合动画
         */

        //用AnimatorInflater去加载ValueAnimator对应的xml文件
        //实现动画渐变效果
        /*ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this,R.animator.value_animator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                icon.setAlpha(animatedValue);
            }
        });
        valueAnimator.setDuration(3000);
        valueAnimator.start();*/

        //用AnimatorInflater去加载ObjectAnimator对应的xml文件
        //渐变效果
        /*ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.object_animator);
        objectAnimator.setDuration(3000);
        objectAnimator.setTarget(icon);
        objectAnimator.start();*/

        //用AnimatorInflater去加载AnimatorSet对应的xml文件
        //组合动画
        /*Animator animator = AnimatorInflater.loadAnimator(this,R.animator.animator_set);
        animator.setTarget(icon);
        animator.start();*/

        //利用ValueAnimator进行颜色变化动画
        //改变背景颜色
        /*ValueAnimator valueAnimator;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            valueAnimator = ValueAnimator.ofArgb(0xffff0000, 0xff0000ff, 0xff00ff00);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int colorValue = (int) animation.getAnimatedValue();
                    container.setBackgroundColor(colorValue);
                }
            });
            valueAnimator.setDuration(2000);
            valueAnimator.start();
        }*/

        //自定义圆形动画
        Point startPoint = new Point(0, 0);
        Point endPoint = new Point(1000, 1000);
        //fraction是一个从0到1变化的值
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new TypeEvaluator<Point>() {
            @Override
            public Point evaluate(float fraction, Point startValue, Point endValue) {
                float startX = startValue.getX();
                float endX = endValue.getX();
                float currentX = startX + fraction * (endX - startX);

                float startY = startValue.getY();
                float endY = endValue.getY();
                float currentY = startY + fraction * (endY - startY);
                return new Point(currentX, currentY);
            }
        }, startPoint, endPoint);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();
            }
        });


    }

}
