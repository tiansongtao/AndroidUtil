package com.tian.task;

import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tiansongtao, Email:769001510@qq.com
 * @date 2020/3/24 11:33
 *
 * 单一线程池，主要用于线程顺序执行
 */
public class SingleTaskExecutor implements TaskExecutor {

    private final ExecutorService executorService;

    public SingleTaskExecutor(String threadPrefix){
        executorService = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                TaskThreadFactoryBuilder.newThreadFactory(threadPrefix));
    }

    @Override
    public void execute(Task task) {
        executorService.submit(new TaskWapper(task));
    }

    @Override
    public void executeDelayed(Task task, long delayMillis) {
        Log.e("SingleTaskExecutor", "  this executor not support delay");
    }
}
