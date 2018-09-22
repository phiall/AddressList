package cn.heydong.entity;


import java.util.Date;

public class Image {

  private long id;
  private String uuid;
  private String fileType;
  private String path;
  private long uploadedBy;
  private Date uploadedAt;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public long getUploadedBy() {
    return uploadedBy;
  }

  public void setUploadedBy(long uploadedBy) {
    this.uploadedBy = uploadedBy;
  }


  public Date getUploadedAt() {
    return uploadedAt;
  }

  public void setUploadedAt(Date uploadedAt) {
    this.uploadedAt = uploadedAt;
  }

}
