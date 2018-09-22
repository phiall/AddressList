package cn.heydong.controller;

import cn.heydong.entity.Image;
import cn.heydong.service.ImageService;
import cn.heydong.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@RequestMapping(value = "File")
@Controller
public class FileController {
    @Value("${upload.file.path}")
    private String fileRoot;
    @Resource(name="imageService")
    private ImageService imageService;
    @RequestMapping(value = "Upload.do", method = RequestMethod.POST)
    public String upload(@RequestParam("uploadFiles") MultipartFile []files, HttpServletRequest request) throws RuntimeException {

        for(int i = 0;i<files.length;i++){
            System.out.println("fileName---------->" + files[i].getOriginalFilename());

            if(!files[i].isEmpty()){
                try {
                    Image image = new Image();
                    image.setUuid(UUIDUtil.makeUuid());
                    String orgFileName = files[i].getOriginalFilename();
                    image.setFileType(orgFileName.indexOf('.') == -1 ? null : orgFileName.split("\\.")[1].toLowerCase());
                    if(null == image.getFileType()) throw new RuntimeException();
                    image.setPath(UUIDUtil.makePathName(image.getUuid()));
                    String desPath = fileRoot + image.getPath();
                    File pathFile = new File(desPath);
                    if(!pathFile.exists() && !pathFile.isDirectory()) {
                        pathFile.mkdirs();
                    }
                    String targetFileName = desPath + image.getUuid() + "." + image.getFileType();
                    FileOutputStream os = new FileOutputStream(targetFileName);
                    //拿到上传文件的输入流
                    FileInputStream in = (FileInputStream) files[i].getInputStream();

                    //以写字节的方式写文件
                    int b = 0;
                    while((b=in.read()) != -1){
                        os.write(b);
                    }
                    os.flush();
                    os.close();
                    in.close();
                    image.setUploadedBy(1);
                    imageService.insertImage(image);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("上传出错");
                }
            }
        }
        return "/success";
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public String error(RuntimeException e, HttpServletRequest request) {
        request.setAttribute("e", e);//jsp页面显示 ${e.getMessage()}
        return "error";//跳转到异常页面
    }
}
