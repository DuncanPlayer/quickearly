package net.messi.early.controller;

import net.messi.early.dto.CategoryDTO;
import net.messi.early.mapper.NideshopRegionMapper;
import net.messi.early.pojo.NideshopRegion;
import net.messi.early.pojo.NideshopRegionExample;
import net.messi.early.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("region")
public class RegionController {

    @Autowired
    private NideshopRegionMapper regionMapper;

    @ResponseBody
    @RequestMapping("/list")
    public JSONResult regionList(Integer parentId) {
        NideshopRegionExample regionExample = new NideshopRegionExample();
        NideshopRegionExample.Criteria criteria = regionExample.createCriteria();
        criteria.andParentIdEqualTo(parentId.shortValue());
        List<NideshopRegion> regions = regionMapper.selectByExample(regionExample);
        for (NideshopRegion region : regions) {
            if (region.getType() == true) {
                region.setRegionType(1);
            }
        }
        return JSONResult.ok(regions);
    }
}
