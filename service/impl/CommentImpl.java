package net.messi.early.service.impl;

import net.messi.early.dto.CommentAll;
import net.messi.early.mapper.*;
import net.messi.early.pojo.*;
import net.messi.early.service.CommentService;
import net.messi.early.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentImpl implements CommentService {

    @Autowired
    private NideshopCommentMapper commentMapper;

    @Autowired
    private NideshopUserMapper userMapper;

    @Autowired
    private NideshopCommentPictureMapper pictureMapper;

    @Autowired
    private NideshopOrderGoodsMapper orderGoodsMapper;

    @Autowired
    private NideshopOrderMapper orderMapper;

    @Autowired
    private EarlyshopReservationGoodsMapper reservationGoodsMapper;

    @Override
    public List<NideshopComment> commentList(String valueId, Integer typeId, Integer size) {
        NideshopCommentExample commentExample = new NideshopCommentExample();
        NideshopCommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andTypeIdEqualTo(typeId.byteValue());
        criteria.andValueIdEqualTo(Integer.parseInt(valueId));
        List<NideshopComment> comments = commentMapper.selectByExample(commentExample);

        for (NideshopComment comment : comments) {
            comment.setUser(userMapper.selectByPrimaryKey(comment.getUserId()));
            comment.setDateStr(DateUtil.numToDate(Long.valueOf(comment.getAddTime()), "yyyy.MM.dd-HH:mm:ss"));
        }
        if (comments != null) {
            return comments;
        } else {
            return null;
        }
    }

    @Override
    public void insertComment(Integer typeId, String valueId, String content, Integer userId) {
        NideshopComment comment = new NideshopComment();
        comment.setTypeId(typeId.byteValue());
        comment.setValueId(Integer.parseInt(valueId));
        comment.setAddTime(System.currentTimeMillis());
        comment.setUserId(userId);
        comment.setContent(content);
        comment.setStatus(new Byte("0"));
        commentMapper.insert(comment);
    }


    @Override
    public CommentAll commentAll(String valueId, Integer typeId, Integer size, Integer page, Integer showType) {
        CommentAll all = new CommentAll();
        Integer currentPage = (page - 1) * size;
        switch (showType) {
            case 0:  //全部
                List<NideshopComment> commentList = commentMapper.findAll(valueId, size, currentPage);
                commentList = publicData(commentList);
                all.setCommentList(commentList);
                all.setCurrentPage(page);
                break;
            case 1:   //有图
                List<NideshopComment> commentListpic = commentMapper.findElse(valueId, typeId, size, currentPage, showType);
                List<NideshopComment> commentCopy = new ArrayList<>();
                for (NideshopComment comment : commentListpic) {
                    NideshopCommentPictureExample pictureExample = new NideshopCommentPictureExample();
                    NideshopCommentPictureExample.Criteria pictureCri = pictureExample.createCriteria();
                    pictureCri.andCommentIdEqualTo(comment.getId());
                    List<NideshopCommentPicture> pictures = pictureMapper.selectByExample(pictureExample);
                    NideshopUser user = userMapper.selectByPrimaryKey(comment.getUserId());
                    comment.setDateStr(DateUtil.numToDate(comment.getAddTime(), "yyyy.MM.dd-HH:mm:ss"));
                    comment.setUser(user);
                    if (pictures.size() > 0) {
                        comment.setCommentPicture(pictures);
                        commentCopy.add(comment);
                    }
                }
                all.setCommentList(commentCopy);
                all.setCurrentPage(page);
                break;
            case 2:   //好评
                List<NideshopComment> commentListHigh = commentMapper.findElse(valueId, typeId, size, currentPage, showType);
                commentListHigh = publicData(commentListHigh);
                all.setCommentList(commentListHigh);
                all.setCurrentPage(page);
                break;
            case 3:   //中评
                List<NideshopComment> commentListMiddle = commentMapper.findElse(valueId, typeId, size, currentPage, showType);
                commentListMiddle = publicData(commentListMiddle);
                all.setCommentList(commentListMiddle);
                all.setCurrentPage(page);
                break;
            case 4:   //差评
                List<NideshopComment> commentListBad = commentMapper.findElse(valueId, typeId, size, currentPage, showType);
                commentListBad = publicData(commentListBad);
                all.setCommentList(commentListBad);
                all.setCurrentPage(page);
                break;
        }
        return all;
    }

    private List<NideshopComment> publicData(List<NideshopComment> commentList) {
        for (NideshopComment comment : commentList) {
            NideshopCommentPictureExample pictureExample = new NideshopCommentPictureExample();
            NideshopCommentPictureExample.Criteria pictureCri = pictureExample.createCriteria();
            pictureCri.andCommentIdEqualTo(comment.getId());
            List<NideshopCommentPicture> pictures = pictureMapper.selectByExample(pictureExample);
            NideshopUser user = userMapper.selectByPrimaryKey(comment.getUserId());
            comment.setDateStr(DateUtil.numToDate(comment.getAddTime(), "yyyy.MM.dd-HH:mm:ss"));
            comment.setUser(user);
            comment.setCommentPicture(pictures);
        }
        return commentList;
    }

    @Override
    public Integer evaluation(String goodsSn, Integer userId, String content, Integer orderId) {
        NideshopComment comment = new NideshopComment();
        //1、建立同义词库 分出好中差评
        byte typeid = 0;
        comment.setTypeId(typeid);
        comment.setValueId(Integer.parseInt(goodsSn));
        comment.setContent(content);
        comment.setAddTime(System.currentTimeMillis());
        comment.setUserId(userId);
        commentMapper.insertSelective(comment);
        NideshopComment commentLast = commentMapper.findLastComment();
        System.out.println("reservationId:"+orderId+" "+"goodsSn:"+goodsSn);
        //更新 is_real = true
        reservationGoodsMapper.updateIsRealToTrue(orderId,goodsSn);

//        NideshopOrderGoodsExample orderGoodsExample = new NideshopOrderGoodsExample();
//        NideshopOrderGoodsExample.Criteria orderCri = orderGoodsExample.createCriteria();
//        orderCri.andOrderIdEqualTo(orderId);
//        orderCri.andGoodsSnEqualTo(goodsSn);
//        orderGoodsMapper.deleteByExample(orderGoodsExample);
//
//        NideshopOrderGoodsExample orderGoodsExampleTwo = new NideshopOrderGoodsExample();
//        NideshopOrderGoodsExample.Criteria orderCriTwo = orderGoodsExampleTwo.createCriteria();
//        orderCriTwo.andOrderIdEqualTo(orderId);
//        List<NideshopOrderGoods> orderGoods = orderGoodsMapper.selectByExample(orderGoodsExampleTwo);
//        if (orderGoods.size() <= 0 || orderGoods == null) {
//            //评价完了，删除订单----可以日志分析
//            orderMapper.deleteByPrimaryKey(orderId);
//        }

        return commentLast.getId();
    }


}
