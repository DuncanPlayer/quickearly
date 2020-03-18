package net.messi.early.mapper;

import java.util.List;

import net.messi.early.pojo.EarlyshopReservation;
import net.messi.early.pojo.EarlyshopReservationExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopReservationMapper {
    int countByExample(EarlyshopReservationExample example);

    int deleteByExample(EarlyshopReservationExample example);

    int insert(EarlyshopReservation record);

    int insertSelective(EarlyshopReservation record);

    List<EarlyshopReservation> selectByExample(EarlyshopReservationExample example);

    int updateByExampleSelective(@Param("record") EarlyshopReservation record, @Param("example") EarlyshopReservationExample example);

    int updateByExample(@Param("record") EarlyshopReservation record, @Param("example") EarlyshopReservationExample example);

    EarlyshopReservation findLastRecord();

    List<EarlyshopReservation> selectReservationOrderListByUserIdDesc(@Param("userId") Integer userId);
}