package cn.heydong.service;

import cn.heydong.entity.Image;
import cn.heydong.mapper.ImageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "imageService")
public class ImageService {
    @Resource
    private ImageMapper imageMapper;
    public int insertImage(Image image) {
        return imageMapper.insertImage(image);
    }
    public Image getImageByUuid(String uuid) {
        return imageMapper.getImageByUuid(uuid);
    }
}
