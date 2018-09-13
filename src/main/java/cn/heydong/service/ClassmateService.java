package cn.heydong.service;

import cn.heydong.entity.Classmate;
import cn.heydong.mapper.ClassmateMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
指定为Service类，影响到Controller的注入，可以自定义名称
 */
@Service(value = "classmateService")
public class ClassmateService {

    /*
    spring会根据类型自动装配
     */
    @Resource
    private ClassmateMapper classmateMapper;

    //增加学生信息
    public int insertClassmate(Classmate classmate)
    {
        return classmateMapper.insertClassmate(classmate);
    }
    //通过id查找学生信息
    public Classmate getClassmateById(long id)
    {
        return classmateMapper.getClassmateById(id);
    }
    public List<Classmate> getClassmates()
    {
        return classmateMapper.getClassmates();
    }
    public Classmate getClassmateByName(String name)
    {
        return classmateMapper.getClassmateByName(name);
    }
    //修改学生信息
    public int updateClassmate(Classmate classmate)
    {
        return classmateMapper.updateClassmate(classmate);
    }
    //通过id删除学生
    public int deleteClassmate(long id)
    {
        return classmateMapper.deleteClassmate(id);
    }
}
