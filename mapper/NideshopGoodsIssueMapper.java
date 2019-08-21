package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopGoodsIssue;
import net.messi.early.pojo.NideshopGoodsIssueExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopGoodsIssueMapper {
    int countByExample(NideshopGoodsIssueExample example);

    int deleteByExample(NideshopGoodsIssueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopGoodsIssue record);

    int insertSelective(NideshopGoodsIssue record);

    List<NideshopGoodsIssue> selectByExampleWithBLOBs(NideshopGoodsIssueExample example);

    List<NideshopGoodsIssue> selectByExample(NideshopGoodsIssueExample example);

    NideshopGoodsIssue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopGoodsIssue record, @Param("example") NideshopGoodsIssueExample example);

    int updateByExampleWithBLOBs(@Param("record") NideshopGoodsIssue record, @Param("example") NideshopGoodsIssueExample example);

    int updateByExample(@Param("record") NideshopGoodsIssue record, @Param("example") NideshopGoodsIssueExample example);

    int updateByPrimaryKeySelective(NideshopGoodsIssue record);

    int updateByPrimaryKeyWithBLOBs(NideshopGoodsIssue record);

    int updateByPrimaryKey(NideshopGoodsIssue record);
}