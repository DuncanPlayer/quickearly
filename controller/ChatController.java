package net.messi.early.controller;

import com.google.gson.Gson;
import net.messi.early.VO.ImageSrc;
import net.messi.early.constant.IPAddress;
import net.messi.early.utils.JSONResult;
import net.messi.early.utils.PhoneUploadResult;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@RestController
@RequestMapping("chat")
public class ChatController {

    @ResponseBody
    @RequestMapping("/upload")
    public JSONResult chatUpload(@RequestParam("file") MultipartFile[] files) throws Exception {
        // 文件保存的命名空间
        String fileSpace = "G:/weixinPlay/userImages";
        //保存到数据库中的相对路径
        String uploadPathDB = "/" + "chat" + "/face";

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if (files != null && files.length > 0) {

                String fileName = files[0].getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    // 文件上传的最终保存路径
                    String finalFacePath = fileSpace + uploadPathDB + "/" + fileName;
                    // 设置数据库保存的路径
                    uploadPathDB += ("/" + fileName);

                    File outFile = new File(finalFacePath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        // 创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files[0].getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } else {
                return JSONResult.errorMsg("上传出错...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JSONResult.errorMsg("上传出错...");
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        return JSONResult.ok(uploadPathDB);
    }


    @ResponseBody
    @RequestMapping("/phoneUpload")
    public String phoneUpload(@RequestParam("file") MultipartFile[] files) throws Exception {
        // 文件保存的命名空间
        String fileSpace = "G:/weixinPlay/userImages";
        //保存到数据库中的相对路径
        String uploadPathDB = "/" + "chat" + "/face";

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;
        try {
            if (files != null && files.length > 0) {

                String fileName = files[0].getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)) {
                    // 文件上传的最终保存路径
                    String finalFacePath = fileSpace + uploadPathDB + "/" + fileName;
                    // 设置数据库保存的路径
                    uploadPathDB += ("/" + fileName);

                    File outFile = new File(finalFacePath);
                    if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
                        // 创建父文件夹
                        outFile.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(outFile);
                    inputStream = files[0].getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } else {
                return "上传出错...";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "上传出错...";
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        ImageSrc src = new ImageSrc();
        src.setSrc("http://" + IPAddress.IPADDRESS + ":8080/early" + uploadPathDB);
        Gson gson = new Gson();

        return gson.toJson(PhoneUploadResult.ok(src));
    }
}
