package cn.heydong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@RequestMapping(value = "File")
@Controller
public class FileController {
    @Value("${upload.file.path}")
    private String fileRoot;
    @RequestMapping(value = "Upload.do", method = RequestMethod.POST)
    public String upload(@RequestParam("uploadFiles") MultipartFile []files, HttpServletRequest request) throws RuntimeException {

        for(int i = 0;i<files.length;i++){
            System.out.println("fileName---------->" + files[i].getOriginalFilename());

            if(!files[i].isEmpty()){
                int pre = (int) System.currentTimeMillis();
                try {
                    //拿到输出流，同时重命名上传的文件
                    FileOutputStream os = new FileOutputStream(fileRoot + files[i].getOriginalFilename());
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
                    int finaltime = (int) System.currentTimeMillis();
                    System.out.println(finaltime - pre);

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
