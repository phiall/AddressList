package cn.heydong.controller;
import cn.heydong.entity.Classmate;
import cn.heydong.service.ClassmateService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
默认为singleton单例模式，对应配置中的<bean scope="prototype"/>
 */
@Scope(value = "prototype")
/*
请求映射，链接地址第一层满足指定的value则进入这个控制类中的方法
 */
@RequestMapping(value = "/User")
/*
指定当前类为控制类，value可以重命名（无法自动装配）
不使用注解时，需实现org.springframework.web.servlet.mvc.Controller接口
 */
@Controller
public class ClassmateController {
    /*
    指定Service，需要在Spring中配置相关注解扫描（自动装配）
    可以使用
    @Autowired@Qualifier(value = "StuService")
    进行配置，也可以使用
    @Resource
     */
    @Resource(name = "classmateService")
    private ClassmateService classmateService;

    @RequestMapping(value = "Login.do", method = RequestMethod.POST)
    public String Login(@ModelAttribute("user") Classmate user) throws RuntimeException
    {
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        Classmate classmate = classmateService.getClassmateByName(user.getName());
        if(null != classmate) {
            if(classmate.getPassword().equals(user.getPassword())) {
                return "index";
            }
        }
        return "error";
    }
    @RequestMapping(value = "Classmates.do", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView getClassmates() throws RuntimeException
    {
        List<Classmate> classmates = classmateService.getClassmates();
        Map<String, Object> map = new HashMap<>();
        map.put("data", classmates);
        return new ModelAndView(new MappingJackson2JsonView(), map);
    }
    @RequestMapping(value = "Register.do", method = RequestMethod.POST)
    public String Register(@ModelAttribute("user") Classmate user) throws RuntimeException
    {
        System.out.println(user.toString());
        int ret = classmateService.insertClassmate(user);
        if(1 == ret) {
            return "index";
        }
        return "error";
    }

    /*
    全局异常处理配置
     <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
        <property name="exceptionMappings">
            <props>
                <prop key="java.lang.RuntimeException">error</prop>
            </props>
        </property>
    </bean>
    以下为局部异常处理方式
     */
    @ExceptionHandler(value = {RuntimeException.class})
    public String error(RuntimeException e, HttpServletRequest request) {
        request.setAttribute("e", e);//jsp页面显示 ${e.getMessage()}
        return "error";//跳转到异常页面
    }
}
