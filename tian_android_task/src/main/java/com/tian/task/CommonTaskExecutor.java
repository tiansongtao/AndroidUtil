package com.tian.task;

import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tiansongtao, Email:769001510@qq.com
 * @date 2020/3/24 11:24
 *
 * 普通线程执行的线程池，主要用于子线程
 */
public class CommonTaskExecutor implements TaskExecutor {


    private static int kDefaultThreadPoolSize = 4;
    private static int maxThreadPoolSize = 40;
    private static int kKeepAliveTime = 30;
    private static TimeUnit kTimeUnit = TimeUnit.SECONDS;

    private final ExecutorService executorService;

    private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();


    /**
     * 线程池拒绝策略，直接再加入到线程池队列
     */
    private RejectedExecutionHandler handler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            queue.add(r);
        }
    };

    public CommonTaskExecutor(String threadPrefix) {
        //构建普通线程的线程池
        executorService = new ThreadPoolExecutor(kDefaultThreadPoolSize, maxThreadPoolSize,
                kKeepAliveTime, kTimeUnit, queue,
                TaskThreadFactoryBuilder.newThreadFactory(threadPrefix), handler);
    }


    @Override
    public void execute(Task task) {
        executorService.submit(new TaskWapper(task));
    }

    @Override
    public void executeDelayed(Task task, long delayMillis) {
        Log.e("CommonTaskExecutor", "  this executor not support delay");
    }
}
