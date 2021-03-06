package me.csxiong.uiux.ui.seek;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import me.csxiong.library.base.BaseActivity;
import me.csxiong.uiux.R;
import me.csxiong.uiux.databinding.ActivitySeekBarBinding;

/**
 * @Desc : Seekbar测试界面
 * @Author : csxiong - 2020-01-13
 */
@Route(path = "/main/seekbar", name = "Seekbar测试界面")
public class SeekBarActivity extends BaseActivity<ActivitySeekBarBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_seek_bar;
    }

    @Override
    public void initView() {
        mViewBinding.xsb.setEnableExpandMode(true);
        mViewBinding.xsb.setOnProgressChangeListener(new XSeekBar.OnProgressChangeListener() {
            @Override
            public void onStartTracking(int progress, float leftDx) {
                mViewBinding.xsb.expand(true);
                mViewBinding.rlBubble.animate().cancel();
                mViewBinding.rlBubble.animate().setDuration(200)
                        .alpha(1)
                        .setStartDelay(0)
                        .start();
                mViewBinding.rlBubble.setVisibility(View.VISIBLE);
                mViewBinding.rlBubble.setTranslationX(leftDx - mViewBinding.rlBubble.getWidth() / 2f);
            }

            @Override
            public void onProgressChange(int progress, float leftDx, boolean fromUser) {

            }

            @Override
            public void onPositionChange(int progress, float leftDx) {
                mViewBinding.tvProgress.setText(progress + "");
                mViewBinding.rlBubble.setTranslationX(leftDx - mViewBinding.rlBubble.getWidth() / 2f);
            }

            @Override
            public void onStopTracking(int progress, float leftDx, boolean fromUser) {
                mViewBinding.xsb.expand(false);
                mViewBinding.rlBubble.animate().cancel();
                mViewBinding.rlBubble.animate().setDuration(200)
                        .alpha(0)
                        .setStartDelay(500)
                        .start();
                mViewBinding.rlBubble.setTranslationX(leftDx - mViewBinding.rlBubble.getWidth() / 2f);
            }
        });


        mViewBinding.xsb1.setEnableCenterPoint(true);
        mViewBinding.xsb1.setCenterPointPercent(0);
        mViewBinding.xsb1.setMinProgress(0);
        mViewBinding.xsb1.setMaxProgress(100);

        mViewBinding.xsb2.setCenterPointPercent(0.3f);
        mViewBinding.xsb2.setMinProgress(-30);
        mViewBinding.xsb2.setMaxProgress(70);
        mViewBinding.xsb2.setEnableStroke(true);

        mViewBinding.btn
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewBinding.xcsb.start();
                        i = 1 - i;
                        boolean isUp = i == 0;
                        if (isUp) {
                            mViewBinding.xsb.setProgress(100, true);
                        } else {
                            mViewBinding.xsb.setProgress(-80, true);
                        }
                    }
                });
    }

    private int i = 0;

    @Override
    public void initData() {

    }
}
