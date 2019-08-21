package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopAdmin;
import net.messi.early.pojo.NideshopAdminExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopAdminMapper {
    int countByExample(NideshopAdminExample example);

    int deleteByExample(NideshopAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopAdmin record);

    int insertSelective(NideshopAdmin record);

    List<NideshopAdmin> selectByExample(NideshopAdminExample example);

    NideshopAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopAdmin record, @Param("example") NideshopAdminExample example);

    int updateByExample(@Param("record") NideshopAdmin record, @Param("example") NideshopAdminExample example);

    int updateByPrimaryKeySelective(NideshopAdmin record);

    int updateByPrimaryKey(NideshopAdmin record);
}