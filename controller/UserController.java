package net.messi.early.controller;

import com.google.gson.Gson;
import net.messi.early.VO.UserInfo;
import net.messi.early.VO.UserVO;
import net.messi.early.pojo.NideshopUser;
import net.messi.early.service.UserService;
import net.messi.early.utils.IPAdressUtil;
import net.messi.early.utils.JSONResult;
import net.messi.early.utils.MD5Utils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @PostMapping("/login")
    public JSONResult userLogin(@RequestBody UserVO userVO, HttpServletRequest request) throws Exception {

        if (StringUtils.isBlank(userVO.getUsername()) || StringUtils.isBlank(userVO.getPassword())) {
        }
        NideshopUser nideshopUser = userService.userLogin(userVO.getUsername(), userVO.getPassword());

        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(nideshopUser, userInfo);
        userInfo.setPassword(MD5Utils.getMD5Str(userVO.getPassword()));
        //token
        userInfo.setToken(UUID.randomUUID().toString());

        if (nideshopUser != null) {
            request.getSession().setAttribute("nickName", userInfo);
            return JSONResult.ok(userInfo);
        } else {
            return JSONResult.ok("账号或密码错误");
        }
    }

    @ResponseBody
    @PostMapping("/register")
    public JSONResult userRegister(@RequestBody UserVO userVO,
                                   HttpServletRequest request) {
        NideshopUser nideshopUser = new NideshopUser();
        BeanUtils.copyProperties(userVO, nideshopUser);

        String ip = IPAdressUtil.getIpAddress(request);
        System.out.println(ip);
        nideshopUser.setRegisterIp(ip);
        //insert
        userService.userRegister(nideshopUser);

        return JSONResult.ok();
    }


    /**
     * 用户上传头像
     *
     * @param userId
     * @param files
     * @return
     * @throws Exception
     */
    @PostMapping("/uploadFace")
    public JSONResult uploadFace(String userId,
                                 @RequestParam("file") MultipartFile[] files) throws Exception {
        if (StringUtils.isBlank(userId)) {
            return JSONResult.errorMsg("用户id不能为空...");
        }

        // 文件保存的命名空间
        String fileSpace = "G:/weixinPlay/userImages";
        // 保存到数据库中的相对路径
        String uploadPathDB = "/" + userId + "/face";

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

        NideshopUser user = userService.findUserById(Integer.parseInt(userId));
        user.setAvatar(uploadPathDB);
        userService.uploadUserAvator(user);

        return JSONResult.ok(uploadPathDB);
    }

    @ResponseBody
    @GetMapping("/getUserInfo")
    public JSONResult getUserInfo(Integer userId) {
        Gson gson = new Gson();
        return JSONResult.ok(gson.toJson(userService.chatInit(userId).getData()));
    }


}
