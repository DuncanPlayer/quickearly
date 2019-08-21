package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.EarlyshopMaterial;
import net.messi.early.pojo.EarlyshopMaterialExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopMaterialMapper {
    int countByExample(EarlyshopMaterialExample example);

    int deleteByExample(EarlyshopMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EarlyshopMaterial record);

    int insertSelective(EarlyshopMaterial record);

    List<EarlyshopMaterial> selectByExample(EarlyshopMaterialExample example);

    EarlyshopMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EarlyshopMaterial record, @Param("example") EarlyshopMaterialExample example);

    int updateByExample(@Param("record") EarlyshopMaterial record, @Param("example") EarlyshopMaterialExample example);

    int updateByPrimaryKeySelective(EarlyshopMaterial record);

    int updateByPrimaryKey(EarlyshopMaterial record);

    List<EarlyshopMaterial> findMaterialByDefault(@Param("page") Integer page, @Param("size") Integer size);

    List<EarlyshopMaterial> findMaterialByPriceAsc(@Param("page") Integer page, @Param("size") Integer size);

    List<EarlyshopMaterial> findMaterialByPriceDesc(@Param("page") Integer page, @Param("size") Integer size);

    List<EarlyshopMaterial> findMaterialByCategoryName(@Param("page") Integer page, @Param("size") Integer size, @Param("categoryName") String categoryName);

}