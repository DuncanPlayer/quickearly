package net.messi.early.service.impl;

import com.google.gson.Gson;
import com.hankcs.hanlp.HanLP;
import net.messi.early.dto.Search2DTO;
import net.messi.early.dto.SearchDTO;
import net.messi.early.holder.DyncmicDataSourceHolder;
import net.messi.early.mapper.*;
import net.messi.early.pojo.*;
import net.messi.early.service.SearchService;
import net.messi.early.utils.Duplicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchImpl implements SearchService {

    @Autowired
    private NideshopKeywordsMapper keywordsMapper;

    @Autowired
    private NideshopSearchHistoryMapper searchHistoryMapper;

    @Autowired
    private NideshopGoodsMapper goodsMapper;

    @Autowired
    private NideshopCategoryMapper categoryMapper;

    @Autowired
    private EarlyshopRecommendMapper recommendMapper;

    @Override
    public SearchDTO searchNavigation(Integer userId) {
        SearchDTO searchDTO = new SearchDTO();

        //defaultKeywordsList
        NideshopKeywordsKey keywordsKey = new NideshopKeywordsKey();
        keywordsKey.setId(238074);
        keywordsKey.setKeyword("金枪鱼三明治");
        searchDTO.setDefaultKeyword(keywordsKey);

        //hotKeywordsList
        NideshopKeywordsExample examplehot = new NideshopKeywordsExample();
        NideshopKeywordsExample.Criteria criteriahot = examplehot.createCriteria();
        criteriahot.andIsHotEqualTo(true);
        List<NideshopKeywords> hotKeywordsList = keywordsMapper.selectByExample(examplehot);
        searchDTO.setHotKeywordList(hotKeywordsList);

        //historyList
        NideshopSearchHistoryExample searchHistoryExample = new NideshopSearchHistoryExample();
        NideshopSearchHistoryExample.Criteria searchCriteria = searchHistoryExample.createCriteria();
        searchCriteria.andAddTimeIsNotNull();
        searchCriteria.andUserIdEqualTo(userId + "");
        List<NideshopSearchHistory> historyList = searchHistoryMapper.selectByExample(searchHistoryExample);
        searchDTO.setHistoryKeywordList(historyList);

        return searchDTO;
    }

    @Override
    public Search2DTO searchByKeyword(String keyword, Integer page, Integer size, String sort, String order, Integer categoryId, Integer userId) {
        Search2DTO search2DTO = new Search2DTO();
        //提取关键词
        List<String> keywordList = HanLP.extractKeyword(keyword, 5);
        List<NideshopGoods> goodsList = null;
        List<NideshopGoods> goodsListKeyWord = null;
        List<NideshopGoods> goodsLists = new ArrayList<>();

        goodsListKeyWord = goodsMapper.findGoodsByKeyword(keyword, page, size);
        goodsLists.addAll(0, goodsListKeyWord);

        if (categoryId.equals("0") || categoryId == 0) {
            if (sort.equals("default")) {
                for (String key : keywordList) {
                    goodsList = goodsMapper.findGoodsByKeyword(key, page, size);
                    goodsLists.addAll(goodsList);
                }
            } else if (sort.equalsIgnoreCase("price")) {
                if (order.equals("asc")) {
                    for (String key : keywordList) {
                        goodsList = goodsMapper.findGoodsByKeywordASC(key, page, size);
                        goodsLists.addAll(goodsList);
                    }
                } else if (order.equals("desc")) {
                    for (String key : keywordList) {
                        goodsList = goodsMapper.findGoodsByKeywordDesc(key, page, size);
                        goodsLists.addAll(goodsList);
                    }
                }
            }
        } else {
            for (String key : keywordList) {
                goodsList = goodsMapper.findGoodsByCategoryIdAndKeyword(key, page, size, categoryId);
                goodsLists.addAll(goodsList);
            }
        }
        //goodsList数据去重
        List<NideshopGoods> uniqueGoodsList = goodsLists.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(NideshopGoods::getName))), ArrayList::new)
        );

        LinkedList<NideshopGoods> linkedGoodsList = new LinkedList<>();
        //1 根据goods得categoryId查找category
        // 2  对检索词排名
        List<NideshopCategory> categories = new ArrayList<>();
        Iterator<NideshopGoods> linkgoods = uniqueGoodsList.iterator();
        while (linkgoods.hasNext()) {
            NideshopGoods goods = linkgoods.next();
            NideshopCategory category = categoryMapper.findByCategoryId(goods.getCategoryId());
            categories.add(category);
            if (goods.getName().contains(keyword)) {
                linkedGoodsList.add(goods);
                linkgoods.remove();
            }
        }
        linkedGoodsList.addAll(uniqueGoodsList);
        search2DTO.setData(linkedGoodsList);

        // categories去重
        LinkedList<NideshopCategory> categoryLinkedList = new LinkedList<>(new HashSet<>(categories));
        search2DTO.setFilterCategory(categoryLinkedList);

        search2DTO.setCurrentPage(page);
        search2DTO.setNumsPerPage(size);

        DyncmicDataSourceHolder.setWrite();
        //插入搜索记录
        NideshopSearchHistory history = new NideshopSearchHistory();
        history.setAddTime(new BigDecimal(System.currentTimeMillis()).intValue());
        history.setKeyword(keyword);
        history.setUserId(userId + "");
        NideshopSearchHistoryExample searchHistoryExample = new NideshopSearchHistoryExample();
        NideshopSearchHistoryExample.Criteria searchCriteria = searchHistoryExample.createCriteria();
        searchCriteria.andKeywordLike(keyword);
        List<NideshopSearchHistory> searchHistories = searchHistoryMapper.selectByExample(searchHistoryExample);
        if (searchHistories.size() <= 0 || null == searchHistories) {
            searchHistoryMapper.insert(history);
        }
        DyncmicDataSourceHolder.setWrite();
        //保存检索词
        EarlyshopRecommend earlyshopRecommend = new EarlyshopRecommend();
        earlyshopRecommend.setUid(userId.toString());
        earlyshopRecommend.setKeywords(new Gson().toJson(keywordList));
        recommendMapper.insert(earlyshopRecommend);

        return search2DTO;
    }

    @Override
    public void deleteHistorySearch(Integer userId) {
        DyncmicDataSourceHolder.setWrite();
        NideshopSearchHistoryExample historyExample = new NideshopSearchHistoryExample();
        NideshopSearchHistoryExample.Criteria criteria = historyExample.createCriteria();
        criteria.andUserIdEqualTo(userId + "");
        searchHistoryMapper.deleteByExample(historyExample);
    }
}
