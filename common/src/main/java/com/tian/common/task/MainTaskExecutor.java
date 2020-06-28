package com.tian.common.task;

import android.os.Handler;
import android.os.Looper;

/**
 * @author tiansongtao, Email:769001510@qq.com
 * @date 2020/3/24 11:08
 *
 * 主线程执行的线程方式
 */
public class MainTaskExecutor implements TaskExecutor {

    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(Task task) {
        mHandler.post(new TaskWapper(task));
    }

    @Override
    public void executeDelayed(Task task, long delayMillis) {
        mHandler.postDelayed(new TaskWapper(task), delayMillis);
    }
}
