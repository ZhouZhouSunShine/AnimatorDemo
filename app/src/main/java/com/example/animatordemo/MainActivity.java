package com.example.animatordemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * 属性动画
 */

public class MainActivity extends AppCompatActivity {

    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //显示当前页面布局
        setContentView(R.layout.activity_main);
        icon = (ImageView) findViewById(R.id.main_icon);
    }

    //Hello World的点击监听
    public void onClick(View view){

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
        icon.animate().alpha(0.5f)
                .translationX(100f)
                .rotation(180)
                .scaleX(2)
                .scaleY(2)
                .setDuration(3000)
                .start();
    }

}
