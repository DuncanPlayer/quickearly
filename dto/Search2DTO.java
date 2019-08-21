package net.messi.early.dto;

import net.messi.early.pojo.NideshopCategory;
import net.messi.early.pojo.NideshopGoods;

import java.io.Serializable;
import java.util.List;

public class Search2DTO implements Serializable {

    private List<NideshopGoods> data;

    private List<NideshopCategory> filterCategory;

    private Integer currentPage;

    private Integer numsPerPage;


    public List<NideshopGoods> getData() {
        return data;
    }

    public void setData(List<NideshopGoods> data) {
        this.data = data;
    }

    public List<NideshopCategory> getFilterCategory() {
        return filterCategory;
    }

    public void setFilterCategory(List<NideshopCategory> filterCategory) {
        this.filterCategory = filterCategory;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getNumsPerPage() {
        return numsPerPage;
    }

    public void setNumsPerPage(Integer numsPerPage) {
        this.numsPerPage = numsPerPage;
    }
}
