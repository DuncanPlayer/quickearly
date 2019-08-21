package net.messi.early.service;

import net.messi.early.dto.CommentAll;
import net.messi.early.pojo.NideshopComment;

import java.util.List;

public interface CommentService {
    List<NideshopComment> commentList(String valueId, Integer typeId, Integer size);

    void insertComment(Integer typeId, String valueId, String content, Integer userId);

    CommentAll commentAll(String valueId, Integer typeId, Integer size, Integer page, Integer showType);

    Integer evaluation(String goodsSn, Integer userId, String content, Integer orderId);
}
