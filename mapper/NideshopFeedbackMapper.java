package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopFeedback;
import net.messi.early.pojo.NideshopFeedbackExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopFeedbackMapper {
    int countByExample(NideshopFeedbackExample example);

    int deleteByExample(NideshopFeedbackExample example);

    int deleteByPrimaryKey(Integer msgId);

    int insert(NideshopFeedback record);

    int insertSelective(NideshopFeedback record);

    List<NideshopFeedback> selectByExampleWithBLOBs(NideshopFeedbackExample example);

    List<NideshopFeedback> selectByExample(NideshopFeedbackExample example);

    NideshopFeedback selectByPrimaryKey(Integer msgId);

    int updateByExampleSelective(@Param("record") NideshopFeedback record, @Param("example") NideshopFeedbackExample example);

    int updateByExampleWithBLOBs(@Param("record") NideshopFeedback record, @Param("example") NideshopFeedbackExample example);

    int updateByExample(@Param("record") NideshopFeedback record, @Param("example") NideshopFeedbackExample example);

    int updateByPrimaryKeySelective(NideshopFeedback record);

    int updateByPrimaryKeyWithBLOBs(NideshopFeedback record);

    int updateByPrimaryKey(NideshopFeedback record);
}