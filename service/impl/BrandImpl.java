package net.messi.early.service.impl;

import net.messi.early.mapper.NideshopBrandMapper;
import net.messi.early.pojo.NideshopBrand;
import net.messi.early.pojo.NideshopBrandExample;
import net.messi.early.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandImpl implements BrandService {

    @Autowired
    private NideshopBrandMapper mapper;

    @Override
    public List<NideshopBrand> brandList() {

        NideshopBrandExample example = new NideshopBrandExample();
        NideshopBrandExample.Criteria criteria = example.createCriteria();
        criteria.andAppListPicUrlIsNotNull();

        List<NideshopBrand> brandList = mapper.selectByExample(example);
        //去前4条做展示
        return brandList.subList(6, 10);
    }
}
