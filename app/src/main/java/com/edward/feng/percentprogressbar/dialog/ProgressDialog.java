package com.edward.feng.percentprogressbar.dialog;

import com.edward.feng.percentprogressbar.R;
import com.edward.feng.percentprogressbar.view.CircleImageView;
import com.edward.feng.percentprogressbar.view.PercentProgressBar;
import com.edward.feng.percentprogressbar.view.PercentProgressBar1;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * 功能描述：
 *
 * @author (作者) edward（冯丰枫）
 * @link http://www.jianshu.com/u/f7176d6d53d2
 * 创建时间： 2018/4/17 0017
 */
public class ProgressDialog {
    private final Dialog mDialog;
    private final PercentProgressBar1 mPercentProgress;
    private final CircleImageView mCircleImageView;

    public ProgressDialog(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null);
        mPercentProgress = view.findViewById(R.id.circle_percent_view);
        mCircleImageView = view.findViewById(R.id.circle_image_view);
        mDialog = new Dialog(context, R.style.Custom_Progress);
        mDialog.setContentView(view);
        mDialog.setCanceledOnTouchOutside(true);
    }

    public void show() {
        mDialog.show();
    }

    public void setPercentProgress(int percentProgress) {
        mPercentProgress.setPercentProgress(percentProgress);
        mCircleImageView.setAlpha((float) percentProgress/100);
    }

    public void dismiss() {
        mDialog.dismiss();
    }
}
