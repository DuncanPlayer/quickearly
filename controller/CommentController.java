package net.messi.early.controller;

import net.messi.early.dto.CommentDTO;
import net.messi.early.holder.DyncmicDataSourceHolder;
import net.messi.early.mapper.NideshopCommentMapper;
import net.messi.early.mapper.NideshopCommentPictureMapper;
import net.messi.early.pojo.NideshopComment;
import net.messi.early.pojo.NideshopCommentPicture;
import net.messi.early.service.CommentService;
import net.messi.early.service.GoodsService;
import net.messi.early.utils.JSONResult;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private NideshopCommentPictureMapper pictureMapper;

    @Autowired
    private NideshopCommentMapper commentMapper;

    @ResponseBody
    @RequestMapping("/list")
    public JSONResult commentList(String valueId, Integer typeId, Integer size) {
        CommentDTO commentDTO = new CommentDTO();
        List<NideshopComment> comments = commentService.commentList(valueId, typeId, size);
        commentDTO.setData(comments);
        commentDTO.setCount(comments.size());
        return JSONResult.ok(commentDTO);
    }

    @ResponseBody
    @RequestMapping("/post")
    public JSONResult commentPost(Integer typeId, String valueId, String content, Integer userId) {
        //敏感词分析
        //插入数据库
        commentService.insertComment(typeId, valueId, content, userId);
        return JSONResult.ok(null);
    }

    @ResponseBody
    @RequestMapping("/count")
    public JSONResult commentCount(String valueId, Integer typeId) {
        //goodsService
        return JSONResult.ok(goodsService.commentCount(valueId, typeId));
    }

    @ResponseBody
    @RequestMapping("/list2")
    public JSONResult commentList2(String valueId, Integer typeId, Integer size, Integer page, Integer showType) {
        return JSONResult.ok(commentService.commentAll(valueId, typeId, size, page, showType));
    }

    @ResponseBody
    @RequestMapping("/evaluation")
    public JSONResult evaluation(String goodsSn, Integer userId, String content, Integer orderId) {
        DyncmicDataSourceHolder.setWrite();
        return JSONResult.ok(commentService.evaluation(goodsSn, userId, content, orderId));
    }

    @ResponseBody
    @RequestMapping("/uploadImage")
    public JSONResult uploadImage(Integer commentId,
                                  @RequestParam("file") MultipartFile[] files) throws Exception {
        DyncmicDataSourceHolder.setWrite();
        // 文件保存的命名空间
        String fileSpace = "/usr/local/userImages";
        //保存到数据库中的相对路径
        String uploadPathDB = "/" + "comment" + "/face";

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
        NideshopCommentPicture commentPicture = new NideshopCommentPicture();
        commentPicture.setCommentId(commentId);
        commentPicture.setPicUrl(uploadPathDB);
        pictureMapper.insertSelective(commentPicture);

        NideshopComment comment = commentMapper.selectByPrimaryKey(commentId);
        comment.setNewContent("1");
        commentMapper.updateByPrimaryKeySelective(comment);

        return JSONResult.ok(uploadPathDB);
    }
}
