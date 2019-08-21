package net.messi.early.service.impl;

import net.messi.early.dto.CurrentCategoryDTO;
import net.messi.early.mapper.NideshopCategoryMapper;
import net.messi.early.mapper.NideshopGoodsMapper;
import net.messi.early.pojo.NideshopCategory;
import net.messi.early.pojo.NideshopCategoryExample;
import net.messi.early.pojo.NideshopGoods;
import net.messi.early.pojo.NideshopGoodsExample;
import net.messi.early.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    private NideshopCategoryMapper categoryMapper;

    @Autowired
    private NideshopGoodsMapper goodsMapper;

    @Override
    public List<NideshopCategory> navList(Integer categoryId) {
        List<NideshopCategory> newList = new ArrayList<>();
        if (categoryId != null) {
            NideshopCategory nideshopCategory = categoryMapper.findOne(categoryId);
            //获取sub
            if (nideshopCategory.getParentId() == null || nideshopCategory.getParentId() == 0) {
                List<NideshopCategory> list = categoryMapper.navList();
                for (NideshopCategory category : list) {
                    if (category.getParentId() == 0 && category.getName().length() == 2) {
                        newList.add(category);
                    }
                }
            } else {
                newList = categoryMapper.subCategory(nideshopCategory.getParentId() + "");
                System.out.println(newList.size());
            }
        } else {
            List<NideshopCategory> list = categoryMapper.navList();
            for (NideshopCategory category : list) {
                if (category.getParentId() == 0 && category.getName().length() == 2) {
                    newList.add(category);
                }
            }
        }
        return newList;
    }

    /**
     * 获取当前分类的所有信息
     *
     * @return
     */
    @Override
    public CurrentCategoryDTO currentCategory() {
        return currentCategory(null);
    }

    @Override
    public CurrentCategoryDTO currentCategory(Integer id) {
        //返回值对象
        CurrentCategoryDTO currentCategoryDTO = new CurrentCategoryDTO();

        NideshopCategory currentCategory = null;

        if (id == null) {
            currentCategory = categoryMapper.currentCategory();
        } else {
            //当前Category
            currentCategory = categoryMapper.findByCategoryId(id);
        }

        //parentCategory查找子category
        List<NideshopCategory> categoryList = new ArrayList<>();
        categoryList = categoryMapper.subCategory(currentCategory.getCategoryId());

        currentCategoryDTO.setSubCategoryList(categoryList);
        currentCategoryDTO.setId(Integer.parseInt(currentCategory.getCategoryId()));
        currentCategoryDTO.setWapBannerUrl(currentCategory.getWapBannerUrl());
        currentCategoryDTO.setFrontName(currentCategory.getFrontName());
        currentCategoryDTO.setName(currentCategory.getName());

        return currentCategoryDTO;
    }
}
