package com.tian.common.task;

import android.os.Looper;

/**
 * @author tiansongtao, Email:769001510@qq.com
 * @date 2020/3/24 11:37
 */
public class TaskUtil {

    private static final MainTaskExecutor mainTaskExecutor = new MainTaskExecutor();
    private static final CommonTaskExecutor commonTaskExecutor = new CommonTaskExecutor("tian");


    /**
     * 判断线程知否运行在主线程
     *
     */
    public static boolean isMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }


    /**
     * 主线程中执行线程
     * @param task 执行代码
     */
    public static void executeMainThread(Task task) {
        mainTaskExecutor.execute(task);
    }


    /**
     * 在主线程中执行延迟代码， 这个使用很少，但是有时会用到很少的延迟时间来
     * 做一些操作，
     * @param task 要执行的代码
     * @param delayMillis 延迟时间
     */
    public static void executeMainThreadDelay(Task task, long delayMillis){
        mainTaskExecutor.executeDelayed(task, delayMillis);
    }


    /**
     * 在APP线程池中执行代码
     * @param task 要执行的代码
     */
    public static void executeCommonThread(Task task){
        commonTaskExecutor.execute(task);
    }



}
