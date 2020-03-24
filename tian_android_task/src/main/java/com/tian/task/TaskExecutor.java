package com.tian.task;

/**
 * @author tiansongtao, Email:769001510@qq.com
 * @date 2020/3/24 11:05
 *
 * 线程池执行的框架接口
 *
 */
public interface TaskExecutor {
    /**
     * 执行线程
     * @param task 线程内方法
     */
    void execute(Task task);

    /**
     * 延迟执行线程
     * @param task 线程内方法
     * @param delayMillis  延迟时间
     */
    void executeDelayed(Task task, long delayMillis);
}
