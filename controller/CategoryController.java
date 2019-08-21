package net.messi.early.controller;

import net.messi.early.dto.CategoryDTO;
import net.messi.early.dto.CurrentCategoryDTO;
import net.messi.early.service.CategoryService;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("catalog")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @ResponseBody
    @RequestMapping("/index")
    public JSONResult categoryIndex() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryList(service.navList(null));
        categoryDTO.setCurrentCategory(service.currentCategory());
        return JSONResult.ok(categoryDTO);
    }

    @ResponseBody
    @RequestMapping("/current")
    public JSONResult categoryCurrent(Integer id) {
        CurrentCategoryDTO dto = service.currentCategory(id);
        return JSONResult.ok(dto);
    }

}
