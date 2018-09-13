package cn.heydong.interceptor;
import java.io.File;

import javax.interceptor.Interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 登录拦截器
 *
 *
 */
@Interceptor
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String[] IGNORE_URI = { "/loginPage", "/checkLogin", "/hello" };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//        String applicationName = "/"
//                + request.getContextPath().split("/")[request.getContextPath().split("/").length - 1] + "/";
//        String requestUrl = request.getRequestURL().toString();
//        if (requestUrl.endsWith(applicationName)) {
//            return true;
//        }
//        boolean flag = false;
//        String url = request.getRequestURL().toString();
//        for (String s : IGNORE_URI) {
//            if (url.contains(s)) {
//                flag = true;
//                break;
//            }
//        }
//        if (!flag) {
//            //User user = SJLoginController.getLoginUser(request);
//            if (null != null) {
//                // List<String> urls =
//                // SJLoginController.getUserRoleUrls(request);
//                // if(urls.contains(url)){
//                // flag = true;
//                // }
//                flag = true;
//            }
//        }
        return true;
    }

}