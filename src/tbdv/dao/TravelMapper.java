package tbdv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tbdv.entity.TravelRecord;

public interface TravelMapper {
	
	@Select("select * from TRAVEL where DKDM=#{dkdm} and trunc(TGSJ)=to_date(#{date},'yyyy-mm-dd')")
	public List<TravelRecord> getAllByDKDMOfDate(@Param("dkdm")String dkdm,@Param("date")String date);

}
