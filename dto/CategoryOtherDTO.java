package net.messi.early.dto;

import net.messi.early.pojo.NideshopCategory;

import java.io.Serializable;
import java.util.List;

public class CategoryOtherDTO implements Serializable {

    private List<NideshopCategory> brotherCategory;

    private NideshopCategory currentCategory;

    public List<NideshopCategory> getBrotherCategory() {
        return brotherCategory;
    }

    public void setBrotherCategory(List<NideshopCategory> brotherCategory) {
        this.brotherCategory = brotherCategory;
    }

    public NideshopCategory getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(NideshopCategory currentCategory) {
        this.currentCategory = currentCategory;
    }
}
