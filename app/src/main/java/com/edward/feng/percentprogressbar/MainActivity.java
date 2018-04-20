package com.edward.feng.percentprogressbar;

import com.edward.feng.percentprogressbar.dialog.ProgressDialog;
import com.edward.feng.percentprogressbar.util.IPublishProgress;
import com.edward.feng.percentprogressbar.util.MyAsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressDialog = new ProgressDialog(this);
        findViewById(R.id.main_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLoad();
            }
        });
    }

    private void downLoad() {
        MyAsyncTask.<Void, Integer, Void>newBuilder()
                .setPreExecute(new MyAsyncTask.IPreExecute() {
                    @Override
                    public void onPreExecute() {
                        mProgressDialog.show();
                    }
                })
                .setDoInBackground(new MyAsyncTask.IDoInBackground<Void, Integer, Void>() {
                    @Override
                    public Void doInBackground(IPublishProgress<Integer> publishProgress, Void... voids) {
                        try {
                            for (int i = 0; i <= 100; i++) {
                                Thread.sleep(50);
                                publishProgress.showProgress(i);
                            }
                        } catch (Exception ignore) {
                        }
                        return null;
                    }
                })
                .setProgressUpdate(new MyAsyncTask.IProgressUpdate<Integer>() {
                    @Override
                    public void onProgressUpdate(Integer... values) {
                        mProgressDialog.setPercentProgress(values[0]);
                    }
                })
                .setViewActive(new MyAsyncTask.IIsViewActive() {
                    @Override
                    public boolean isViewActive() {
                        return MainActivity.this.isViewActive();
                    }
                })
                .setPostExecute(new MyAsyncTask.IPostExecute<Void>() {
                    @Override
                    public void onPostExecute(Void aVoid) {
                        mProgressDialog.dismiss();
                    }
                })
                .start();
    }

    public boolean isViewActive() {
        return !(isFinishing() || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && isDestroyed()));
    }


}
