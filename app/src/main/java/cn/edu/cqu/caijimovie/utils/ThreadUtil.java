package cn.edu.cqu.caijimovie.utils;

import android.os.Handler;

public class ThreadUtil {
    /*子线程执行TASK*/
    public static void runInThread(Runnable task){
        new Thread(task).start();
    }

    public static Handler mHandler = new Handler();
    /*UI线程执行TASK*/
    public static void runInUIThread(Runnable task){
        mHandler.post(task);
    }
}
