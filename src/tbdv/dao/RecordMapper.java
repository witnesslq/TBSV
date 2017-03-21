package tbdv.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tbdv.entity.OdRecord;
import tbdv.entity.Record;


//卡口记录查询类
public interface RecordMapper {
	
	
	
	//查询某卡口某天的总流量
	@Select("select count(*) from MYURBAN where DKDM=#{dkdm} and trunc(TGSJ)=to_date(#{date},'yyyy-mm-dd')")
	public int getOneDayTrafficByDKDM(@Param("dkdm")String dkdm,@Param("date")String date);

	//查询所有卡口某天某段时间的所有车流量
		@Select("select count(*) from RECORD where DKDM=#{dkdm} and TGSJ between to_date(#{begin},'yyyy-mm-dd hh24:mi:ss') and to_date(#{end},'yyyy-mm-dd hh24:mi:ss')")
		public int getTrafficByDKDMofTime(@Param("dkdm")String dkdm,@Param("begin")String begin,@Param("end")String end);
		
	
		//查询一辆车在一个时间内的记录
		@Select("select * from MYURBAN where HPHM=#{HPHM} and trunc(TGSJ)=to_date(#{date},'yyyy-mm-dd')")
		public List<Record> getRecordForADayByHP(@Param("HPHM")String hphm,@Param("date")String date);
		
		 

		//查询一辆车在一个时间内的记录
		@Select("select * from MYURBAN where HPHM=#{HPHM} and TGSJ between to_date(#{begin},'yyyy-mm-dd hh24:mi:ss') and to_date(#{end},'yyyy-mm-dd hh24:mi:ss')")
		public List<Record> getRecordForSomeTimeByHP(@Param("HPHM")String hphm,@Param("begin")String begin,@Param("end")String end);
		
		//查询车辆轨迹
		@Select("select TGSJ,HPHM,DKDM from MYURBAN where HPHM=#{HPHM} and TGSJ between to_date(#{begin},'yyyy-mm-dd hh24:mi:ss') and to_date(#{end},'yyyy-mm-dd hh24:mi:ss') ORDER BY TGSJ")
		public List<Record> getTraceForSomeTimeByHP(@Param("HPHM")String hphm,@Param("begin")String begin,@Param("end")String end);
		
		//东联路OD
		@Select("select DISTINCT HPHM from DLL where TGSJ between to_date(#{begin},'yyyy-mm-dd hh24:mi:ss') and to_date(#{end},'yyyy-mm-dd hh24:mi:ss') ")
		public List<Record> getDLLAllHphm(@Param("begin")String begin,@Param("end")String end);
		
		//星海湾大桥OD
		@Select("select DISTINCT HPHM from XHWDQDATA where TGSJ between to_date(#{begin},'yyyy-mm-dd hh24:mi:ss') and to_date(#{end},'yyyy-mm-dd hh24:mi:ss') ")
		public List<Record> getXHWAllHphm(@Param("begin")String begin,@Param("end")String end);
		
		@Select("select DISTINCT DKDM from DLL")
		public List<Record> getKakouOfDLL();
		
		@Select("select DISTINCT DKDM from XHWDQDATA")
		public List<Record> getKakouOfXHW();
		
		@Select("select t.tgsj,t.hphm,t.dkdm,k.name,k.lat,k.lon from dll t inner join kakou k on t.dkdm=k.dkdm where hphm in(select hphm from dll t  where  TGSJ between to_date(#{begin},'yyyy-mm-dd hh24:mi:ss') and to_date(#{end},'yyyy-mm-dd hh24:mi:ss') group by hphm having count(hphm)>1) order by t.hphm,t.tgsj")
		public List<OdRecord> getDLLOD(@Param("begin")String begin,@Param("end")String end);
		
		@Select("select t.tgsj,t.hphm,t.dkdm,k.name,k.lat,k.lon from XHWDQDATA t inner join kakou k on t.dkdm=k.dkdm where hphm in(select hphm from XHWDQDATA t  where  TGSJ between to_date(#{begin},'yyyy-mm-dd hh24:mi:ss') and to_date(#{end},'yyyy-mm-dd hh24:mi:ss') group by hphm having count(hphm)>1) order by t.hphm,t.tgsj")
		public List<OdRecord> getXHWOD(@Param("begin")String begin,@Param("end")String end);
		
}
