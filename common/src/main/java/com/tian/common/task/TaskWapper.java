package com.tian.common.task;

import android.util.Log;

/**
 * @author tiansongtao, Email:769001510@qq.com
 * @date 2020/3/24 11:10
 */
public class TaskWapper implements Runnable {

    private final Task task;

    public TaskWapper(Task task) {
        this.task = task;
    }


    @Override
    public void run() {
        try {
            task.run();
        } catch (Error error) {
            Log.e("Task Error", error.getMessage());
        } catch (Exception e) {
            Log.e("Task exception", e.getMessage());
        }
    }
}
