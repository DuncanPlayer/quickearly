package net.messi.early.service.impl;

import net.messi.early.constant.FilterCategory;
import net.messi.early.constant.IPAddress;
import net.messi.early.constant.SpecificationConstant;
import net.messi.early.dto.*;
import net.messi.early.mapper.*;
import net.messi.early.pojo.*;
import net.messi.early.service.GoodsService;
import net.messi.early.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("goodsService")
public class GoodsImpl implements GoodsService {


    @Autowired
    private NideshopGoodsMapper goodsMapper;

    @Autowired
    private NideshopCategoryMapper categoryMapper;

    @Autowired
    private NideshopGoodsGalleryMapper galleryMapper;

    @Autowired
    private NideshopGoodsAttributeMapper attributeMapper;

    @Autowired
    private NideshopGoodsIssueMapper issueMapper;

    @Autowired
    private EarlyshopPricticeMapper pricticeMapper;

    @Autowired
    private EarlyshopFeelMapper feelMapper;

    @Autowired
    private NideshopSpecificationMapper specificationMapper;

    @Autowired
    private NideshopGoodsSpecificationMapper goodsSpecificationMapper;

    @Autowired
    private NideshopUserMapper userMapper;

    @Autowired
    private NideshopCommentMapper commentMapper;

    @Autowired
    private NideshopCommentPictureMapper pictureMapper;

    @Autowired
    private NideshopCartMapper cartMapper;


    @Override
    public List<NideshopGoods> newGoods() {
        List<NideshopGoods> newsGoods = goodsMapper.findGoodsByNewGoods();
        return newsGoods;
    }

    @Override
    public List<NideshopGoods> hotGoods() {
        List<NideshopGoods> hotGoods = goodsMapper.findGoodsByHotGoods();
        return hotGoods;
    }

    //floorGooods
    @Override
    public List<FloorGoodsDTO> floorGoods() {
        //goods
        //category
        NideshopCategoryExample categoryExample = new NideshopCategoryExample();
        NideshopCategoryExample.Criteria categoryExampleCriteria = categoryExample.createCriteria();
        List<String> categoryIds = Arrays.asList(new String[]{"11012", "1107", "11025"});
        categoryExampleCriteria.andCategoryIdIn(categoryIds);

        List<NideshopCategory> categories = categoryMapper.selectByExample(categoryExample);

        //FlorGoodsDTO
        FloorGoodsDTO goodsDTO = null;
        List<NideshopGoods> goodsList = new ArrayList<>();
        List<FloorGoodsDTO> dtoList = new ArrayList<>();
        for (NideshopCategory category : categories) {
            goodsDTO = new FloorGoodsDTO();
            goodsDTO.setId(Integer.parseInt(category.getCategoryId() + ""));
            goodsDTO.setName(category.getName());

            NideshopGoodsExample example = new NideshopGoodsExample();
            NideshopGoodsExample.Criteria criteria = example.createCriteria();
            criteria.andCategoryIdEqualTo(Integer.parseInt(category.getCategoryId()));
            goodsList = goodsMapper.selectByExample(example);

            goodsList = goodsList.subList(0, 7);

            goodsDTO.setGoodsList(goodsList);
            dtoList.add(goodsDTO);
        }
        return dtoList;
    }

    /**
     * goodsCount
     *
     * @return
     */
    @Override
    public Integer goodsCount() {
        return goodsMapper.goodsCount();
    }


    @Override
    public List<NideshopGoods> findGoodsByCategoryId(Integer categoryId, Integer page, Integer size) {

        if (page > 0) {
            page = (page - 1) * size;
        }
        return goodsMapper.findGoodsByCategoryId(categoryId, page, size);
    }

    @Override
    public GoodsDetailDTO goodsDetail(Integer id) {
        GoodsDetailDTO detailDTO = new GoodsDetailDTO();
        //记录当前时间
        detailDTO.setDate(DateUtil.numToDate(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        //商品信息
        NideshopGoods goods = goodsMapper.selectByPrimaryKey(id);
        if (goods.getName().length() > 10) {
            goods.setName(goods.getName().substring(0, 10) + "...");
        }
        detailDTO.setInfo(goods);
        //feel
        EarlyshopFeel feel = feelMapper.selectByPrimaryKey(id);
        detailDTO.setFeel(feel);

        NideshopGoodsGalleryExample galleryExample = new NideshopGoodsGalleryExample();
        NideshopGoodsGalleryExample.Criteria criteria = galleryExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<NideshopGoodsGallery> goodsGalleries = galleryMapper.selectByExample(galleryExample);
        detailDTO.setGallery(goodsGalleries);

        List<NideshopGoodsAttribute> attributes = new ArrayList<>();
        attributes = attributeMapper.findAttributeListByGoodsSn(goods.getGoodsSn());
        detailDTO.setAttribute(attributes);


        NideshopGoodsIssueExample issueExample = new NideshopGoodsIssueExample();
        NideshopGoodsIssueExample.Criteria issueCri = issueExample.createCriteria();
        issueCri.andQuestionIsNotNull();
        List<NideshopGoodsIssue> issues = issueMapper.selectByExample(issueExample);
        detailDTO.setIssue(issues);

        List<EarlyshopPrictice> prictices = pricticeMapper.findPricticeListByGoodsSn(goods.getGoodsSn());
        detailDTO.setPrictice(prictices);

        //SpecificationList  规格信息
        List<SpecificationDTO> specificationDTOS = new ArrayList<>();
        SpecificationDTO specificationDTO = null;

        NideshopSpecificationExample specificationExample = new NideshopSpecificationExample();
        NideshopSpecificationExample.Criteria speEx = specificationExample.createCriteria();
        speEx.andIdIsNotNull();
        List<NideshopSpecification> sps = specificationMapper.selectByExample(specificationExample);
        if (Arrays.asList(SpecificationConstant.contains).contains(goods.getCategoryId())) {
            for (NideshopSpecification specification : sps) {
                specificationDTO = new SpecificationDTO();
                specificationDTO.setSpecificationId(specification.getId());
                specificationDTO.setName(specification.getName());
                //valueList
                NideshopGoodsSpecificationExample goodsSpecificationExample = new NideshopGoodsSpecificationExample();
                NideshopGoodsSpecificationExample.Criteria goodsSpe = goodsSpecificationExample.createCriteria();
                goodsSpe.andSpecificationIdEqualTo(specification.getId());
                List<NideshopGoodsSpecification> goodsSpecifications = goodsSpecificationMapper.selectByExample(goodsSpecificationExample);
                //setValueList
                specificationDTO.setValueList(goodsSpecifications);
                specificationDTOS.add(specificationDTO);
            }
            //规格信息
            detailDTO.setSpecificationList(specificationDTOS);
        } else {
            detailDTO.setSpecificationList(null);
        }
        //评论
        NideshopCommentExample commentExample = new NideshopCommentExample();
        NideshopCommentExample.Criteria commentCri = commentExample.createCriteria();
        commentCri.andValueIdEqualTo(Integer.parseInt(goods.getGoodsSn()));
        List<NideshopComment> commentList = commentMapper.selectByExample(commentExample);
        NideshopComment comment = null;
        if (commentList != null && commentList.size() > 0) {
            comment = commentList.get(0);
            //user信息
            NideshopUser user = userMapper.selectByPrimaryKey(comment.getUserId());
            //图片列表
            NideshopCommentPictureExample pictureExample = new NideshopCommentPictureExample();
            NideshopCommentPictureExample.Criteria pictureCri = pictureExample.createCriteria();
            pictureCri.andCommentIdEqualTo(comment.getId());
            List<NideshopCommentPicture> pictures = pictureMapper.selectByExample(pictureExample);
            for (NideshopCommentPicture picture : pictures) {
                picture.setPicUrl("http://" + IPAddress.IPADDRESS + ":8080/early" + picture.getPicUrl());
            }

            comment.setCount(commentList.size());
            comment.setDateStr(DateUtil.numToDate(comment.getAddTime(), "yyyy.MM.dd-HH:mm:ss"));
            comment.setUser(user);
            comment.setCommentPicture(pictures);
            detailDTO.setComment(comment);
        } else {
            detailDTO.setComment(null);
        }

        //店铺信息
        detailDTO.setBrand(null);

        detailDTO.setProductList(goods.getGoodsNumber());

        return detailDTO;
    }


    @Override
    public List<NideshopGoods> findRelateGoodsById(List<Integer> id) {
        List<NideshopGoods> goodsList = new ArrayList<>();
        for (Integer gid : id) {
            goodsList.add(goodsMapper.findGoodsByGoodsSn(gid + ""));
        }
        return goodsList;
    }

    @Override
    public NewGoodsDTO findNewGoodsDTO(Integer isNew, Integer page, Integer size, String order, String sort, String categoryId) {
        NewGoodsDTO newGoodsDTO = new NewGoodsDTO();
        //1 limit 1 20 default/price(asc/desc)
        List<NideshopGoods> goodsList = null;
        if (categoryId.equals("0") || Integer.parseInt(categoryId) == 0) {
            if (sort.equals("default")) {
                goodsList = goodsMapper.findGoodsByDefault(isNew, page, size);
            } else if (sort.equalsIgnoreCase("price")) {
                if (order.equals("asc")) {
                    goodsList = goodsMapper.findGoodsByPriceASC(isNew, page, size, order);
                } else if (order.equals("desc")) {
                    goodsList = goodsMapper.findGoodsByPriceDESC(isNew, page, size, order);
                }
            }
        } else {
            goodsList = goodsMapper.findGoodsByCategoryIdAndIsNew(isNew, page, size, categoryId);
        }
        newGoodsDTO.setGoodsList(goodsList);

        //2 查找filteCategory
        List<NideshopCategory> categories = new ArrayList<>();
        for (int i = 0; i < FilterCategory.categories.length; i++) {
            Integer typeId = FilterCategory.categories[i];
            NideshopCategory category = categoryMapper.findByCategoryId(typeId);
            categories.add(category);
        }
        LinkedList<NideshopCategory> categoryLinkedList = new LinkedList<>(new HashSet<>(categories));
        newGoodsDTO.setFilterCategory(categoryLinkedList);

        if (!categoryId.equals("0") || Integer.parseInt(categoryId) != 0) {
            for (NideshopCategory category : categories) {
                if (category.getCategoryId().equals(categoryId)) {

                    category.setIsChecked("true");
                }
                category.setIsChecked("false");
            }
        }

        return newGoodsDTO;
    }

    @Override
    public NewGoodsDTO findHotGoodsDTO(Integer isHot, Integer page, Integer size, String order, String sort, String categoryId) {
        NewGoodsDTO newGoodsDTO = new NewGoodsDTO();
        //1 limit 1 20 default/price(asc/desc)
        List<NideshopGoods> goodsList = null;
        if (categoryId.equals("0") || Integer.parseInt(categoryId) == 0) {
            if (sort.equals("default")) {
                goodsList = goodsMapper.findGoodsByDefaultByHot(isHot, page, size);
            } else if (sort.equalsIgnoreCase("price")) {
                if (order.equals("asc")) {
                    goodsList = goodsMapper.findGoodsByPriceASCByHot(isHot, page, size, order);
                } else if (order.equals("desc")) {
                    goodsList = goodsMapper.findGoodsByPriceDESCByHot(isHot, page, size, order);
                }
            }
        } else {
            goodsList = goodsMapper.findGoodsByCategoryIdAndByHot(isHot, page, size, categoryId);
        }
        newGoodsDTO.setGoodsList(goodsList);

        //2 查找filteCategory
        List<NideshopCategory> categories = new ArrayList<>();
        for (int i = 0; i < FilterCategory.categoriesHot.length; i++) {
            Integer typeId = FilterCategory.categoriesHot[i];
            NideshopCategory category = categoryMapper.findByCategoryId(typeId);
            categories.add(category);
        }
        LinkedList<NideshopCategory> categoryLinkedList = new LinkedList<>(new HashSet<>(categories));
        newGoodsDTO.setFilterCategory(categoryLinkedList);

        return newGoodsDTO;
    }

    @Override
    public void insertItemCf(Integer uid, Integer gid, Integer val) {
        goodsMapper.insertItemCf(uid, gid, val);
    }

    @Override
    public NideshopGoods findGoodsById(Integer id) {
        return goodsMapper.findGoodsById(id);
    }

    @Override
    public List<String> findHelpKeyword(String keyword) {
        List<NideshopGoods> goodsList = goodsMapper.findHelpKeyword(keyword);
        List<String> stringList = new ArrayList<>();
        for (NideshopGoods goods : goodsList) {
            stringList.add(goods.getName());
        }
        return stringList;
    }

    @Override
    public NideshopGoods findByGoodsSn(Integer valueId) {
        NideshopGoodsExample goodsExample = new NideshopGoodsExample();
        NideshopGoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andGoodsSnEqualTo(valueId + "");
        List<NideshopGoods> goodsList = goodsMapper.selectByExample(goodsExample);
        return goodsList.get(0);
    }

    @Override
    public CommentCout commentCount(String valueId, Integer typeId) {
        CommentCout count = new CommentCout();
        NideshopCommentExample commentExample = new NideshopCommentExample();
        NideshopCommentExample.Criteria commentCri = commentExample.createCriteria();
        commentCri.andValueIdEqualTo(Integer.parseInt(valueId));
        List<NideshopComment> commentList = commentMapper.selectByExample(commentExample);

        Integer pictureCount = 0;
        for (NideshopComment comment : commentList) {
            NideshopCommentPictureExample pictureExample = new NideshopCommentPictureExample();
            NideshopCommentPictureExample.Criteria pictureCri = pictureExample.createCriteria();
            pictureCri.andCommentIdEqualTo(comment.getId());
            List<NideshopCommentPicture> pictures = pictureMapper.selectByExample(pictureExample);
            if (pictures.size() > 0) {
                pictureCount++;
            }
        }

        count.setAllCount(commentList.size());
        count.setHasPicCount(pictureCount);
        //好2
        List<NideshopComment> commentsHigh = commentMapper.findElseTwo(valueId, 2);
        if (commentsHigh.size() > 0) {
            count.setHighPraise(commentsHigh.size());
        }
        //中3
        List<NideshopComment> commentsMiddle = commentMapper.findElseTwo(valueId, 3);
        if (commentsMiddle.size() > 0) {
            count.setHighPraise(commentsMiddle.size());
        }
        //差4
        List<NideshopComment> commentsBad = commentMapper.findElseTwo(valueId, 4);
        if (commentsBad.size() > 0) {
            count.setHighPraise(commentsBad.size());
        }

        return count;
    }

    /**
     * 更新库存
     *
     * @param goodsId
     */
    @Override
    public void updateInventory(Integer goodsId,Integer sellNum) {
        goodsMapper.updateInventory(goodsId,sellNum);
    }

    @Override
    public Integer lasteInventory(Integer goodsId) {
        return goodsMapper.lasteInventory(goodsId);
    }
}
