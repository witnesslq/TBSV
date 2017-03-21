package tbdv.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tbdv.entity.Kakou;

//卡口查询数据操作接口
public interface KakouMapper {
	
	//查询单个卡口
	@Select("select * from KAKOU where DKDM=#{dkdm}")
	public Kakou getKakouByDKDM(@Param("dkdm")String dkdm);
	
	//查询所有的卡口
	@Select("select * from KAKOU")
	public List<Kakou> getAllKakous();
	
	
	@Select("select distinct ORI from tonorth")
	public List<String> getORIToNorth();
	
	@Select("select distinct REL from tonorth")
	public List<String> getRELToNorth();
	

	@Select("select distinct ORI from tosouth")
	public List<String> getORIToSouth();
	
	@Select("select distinct ORI from tosouth")
	public List<String> getRELToSouth();
	
	@Select("select REL from tonorth where ORI=#{dkdm}")
	public String getRefByDkDMON(@Param("dkdm")String dkdm);
	
	@Select("select REL from tosouth where ORI=#{dkdm}")
	public String getRefByDkDMOS(@Param("dkdm")String dkdm);
		
	

}
