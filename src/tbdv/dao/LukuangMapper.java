package tbdv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tbdv.entity.Lukuang;

public interface LukuangMapper {
	
	//查询单个路况
		@Select("select * from LUKUANG where road=#{road} and trunc(time)=to_date(#{date},'yyyy-mm-dd') ")
		public List<Lukuang> getLukuangByRoad(@Param("road")String road,@Param("date")String date);
		
		//查询单个路况
		@Select("select * from LUKUANG where road=#{road} and time between to_date(#{begin},'yyyy-mm-dd hh24:mi:ss') and to_date(#{end},'yyyy-mm-dd hh24:mi:ss')")
		public List<Lukuang> getLukuangByTime(@Param("road")String road,@Param("begin")String begin,@Param("end")String end);

}
