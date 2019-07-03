package cn.edu.cqu.caijimovie.utils;

public class UrlUtils {
    private static String baseurl = "http://192.168.43.94:8090/";

    public static String Signin(String mail, String password) {
        return baseurl + "api/user?mail=" + mail + "&password=" + password;
    }


}
