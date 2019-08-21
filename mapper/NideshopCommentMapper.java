package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.NideshopComment;
import net.messi.early.pojo.NideshopCommentExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopCommentMapper {
    int countByExample(NideshopCommentExample example);

    int deleteByExample(NideshopCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopComment record);

    int insertSelective(NideshopComment record);

    List<NideshopComment> selectByExample(NideshopCommentExample example);

    NideshopComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopComment record, @Param("example") NideshopCommentExample example);

    int updateByExample(@Param("record") NideshopComment record, @Param("example") NideshopCommentExample example);

    int updateByPrimaryKeySelective(NideshopComment record);

    int updateByPrimaryKey(NideshopComment record);

    //评论区
    List<NideshopComment> findAll(@Param("valueId") String valueId, @Param("size") Integer size, @Param("page") Integer page);

    List<NideshopComment> findElse(@Param("valueId") String valueId, @Param("typeId") Integer typeId, @Param("size") Integer size, @Param("page") Integer page, @Param("showType") Integer showType);

    List<NideshopComment> findElseTwo(@Param("valueId") String valueId, @Param("showType") Integer showType);

    NideshopComment findLastComment();
}