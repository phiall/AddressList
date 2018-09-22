package cn.heydong.mapper;

import cn.heydong.entity.Image;

public interface ImageMapper {
    public int insertImage(Image iamge);
    public Image getImageByUuid(String uuid);
}
