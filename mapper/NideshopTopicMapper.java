package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopTopic;
import net.messi.early.pojo.NideshopTopicExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopTopicMapper {
    int countByExample(NideshopTopicExample example);

    int deleteByExample(NideshopTopicExample example);

    int insert(NideshopTopic record);

    int insertSelective(NideshopTopic record);

    List<NideshopTopic> selectByExampleWithBLOBs(NideshopTopicExample example);

    List<NideshopTopic> selectByExample(NideshopTopicExample example);

    int updateByExampleSelective(@Param("record") NideshopTopic record, @Param("example") NideshopTopicExample example);

    int updateByExampleWithBLOBs(@Param("record") NideshopTopic record, @Param("example") NideshopTopicExample example);

    int updateByExample(@Param("record") NideshopTopic record, @Param("example") NideshopTopicExample example);
}