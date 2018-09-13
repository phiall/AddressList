package cn.heydong.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Classmate {

  private long id;
  private String name;
  private long gender;
  private String password;
  private String phone;
  private String workCity;
  private String workAddr;
  private String homeTown;
  private String homeAddr;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//, timezone="GMT+8"
  private Date updatedAt;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public String getWorkAddr() {
        return workAddr;
    }

    public void setWorkAddr(String workAddr) {
        this.workAddr = workAddr;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Classmate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", workCity='" + workCity + '\'' +
                ", workAddr='" + workAddr + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", homeAddr='" + homeAddr + '\'' +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
