package cn.heydong.mapper;

import cn.heydong.entity.Classmate;

import java.util.List;

public interface ClassmateMapper {
    //增加学生信息
    public int insertClassmate(Classmate classmate);
    //通过id查找学生信息
    public Classmate getClassmateById(long id);
    //通过id查找学生信息
    public Classmate getClassmateByName(String name);
    public List<Classmate> getClassmates();
    //修改学生信息
    public int updateClassmate(Classmate classmate);
    //通过id删除学生
    public int deleteClassmate(long id);
}