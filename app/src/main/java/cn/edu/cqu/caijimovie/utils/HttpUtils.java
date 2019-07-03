package cn.edu.cqu.caijimovie.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtils {
    /**
     * @param address  需要访问的URL网址
     * @param callback 添加回调方法
     */
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        //下面是OkHttp的使用步骤
        //首先创建OkHttpClient的对象
        OkHttpClient client = new OkHttpClient();
        //通过创建Request对象将URL绑定
        Request request = new Request.Builder().url(address).build();
        //添加回调方法，这样OkHttp的使用就完成了，在需要访问网络时只需要调用这个方法就可以了
        client.newCall(request).enqueue(callback);
    }

    public static void sendOkHttpRequest(String address, RequestBody formbody, okhttp3.Callback callback) {
        //下面是OkHttp的使用步骤
        //首先创建OkHttpClient的对象
        OkHttpClient client = new OkHttpClient();
        //通过创建Request对象将URL绑定
        Request request = new Request.Builder().url(address).post(formbody).build();
        //添加回调方法，这样OkHttp的使用就完成了，在需要访问网络时只需要调用这个方法就可以了
        client.newCall(request).enqueue(callback);

    }

}
