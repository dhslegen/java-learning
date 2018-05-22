package javaStudy.SpringMVC.文件上传配置;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    //使用MultipartFile接受上传的文件
    public String upload(MultipartFile file) {
        try {
            FileUtils.writeByteArrayToFile(new File("e:/upload/" + file.getOriginalFilename()), file.getBytes());
            return "OK";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }
    }
}
