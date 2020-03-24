package com.tian.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author tiansongtao, Email:769001510@qq.com
 * @date 2020/3/24 11:27
 *
 * 线程池创建线程的工厂， 设置线程的名字
 */
public class TaskThreadFactoryBuilder {


    static ThreadFactory newThreadFactory(String threadPrefix) {
        TaskThreadFactoryBuilder builder = new TaskThreadFactoryBuilder(threadPrefix);
        return builder.build();
    }

    private final String threadPrefix;
    private final AtomicLong seq = new AtomicLong(0);

    private TaskThreadFactoryBuilder(String threadPrefix) {
        this.threadPrefix = threadPrefix;
    }


    private ThreadFactory build() {
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = Executors.defaultThreadFactory().newThread(r);
                t.setName(threadPrefix + "-" + seq.incrementAndGet());
                return t;
            }
        };
    }

}
