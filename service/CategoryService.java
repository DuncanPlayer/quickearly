package net.messi.early.service;

import net.messi.early.dto.CategoryOtherDTO;
import net.messi.early.dto.CurrentCategoryDTO;
import net.messi.early.pojo.NideshopCategory;

import java.util.List;

public interface CategoryService {

    List<NideshopCategory> navList(Integer id);

    //当前分类
    CurrentCategoryDTO currentCategory();

    CurrentCategoryDTO currentCategory(Integer id);


}
