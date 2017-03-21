package tbdv.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tbdv.dao.KakouMapper;
import tbdv.dao.RecordMapper;
import tbdv.entity.Kakou;
import tbdv.entity.OdRecord;
import tbdv.entity.Record;
import tbdv.entity.Trace;
import tbdv.entity.Trail;

@Service
public class TraceService {
	
	@Autowired
	private RecordMapper rMapper;
	
	@Autowired
	private KakouService kService;

	

	//查询指定号牌在指定时间段的行车记录
	public Trace getRecordForSomeTimeByHP(String hphm,String day,String begin,String end){
		if (begin==null||begin=="") {
			begin="00:00:00";
		}
		if (end==null||end=="") {
			end="23:59:59";
		}
		Trace trace=new Trace();
		List<Trail> trail = trace.getTrail();
		trace.setHp(hphm);
		trace.setDate(day);
		trace.setBegin(begin);
		trace.setEnd(end);
		begin=day+" "+begin;
		end=day+" "+end;
		List<Record> list = rMapper.getTraceForSomeTimeByHP(hphm, begin, end);
	
		for (Record record : list) {
			Kakou k = kService.getKakouByDKDM(record.getDkdm());
					trail.add(new Trail(record.getTgsj(), k));
		}
		
		trace.setTrail(trail);
		return trace;
	}
	
	
	//OD分析结果返回 (之前版本，先查询卡口，在查询每个号牌的记录)
		public List<Trace> getOD(String table,String day,String begin,String end){
			String obegin=day+" "+begin;
			String oend=day+" "+end;
			List<Trace> result=new ArrayList<Trace>();
			
			if (table.endsWith("dll")) {
				List<OdRecord> dllod = rMapper.getDLLOD(obegin, oend);
				getODResult(dllod, result);
				System.out.println("查询的是东联路");
			}else {
				List<OdRecord> xhwod = rMapper.getXHWOD(obegin, oend);
				getODResult(xhwod, result);
				System.out.println("查询的是星海湾大桥");
			}
			
			return result;
		}
	
	public void  getODResult(List<OdRecord> dllod,List<Trace> result){
		int index=0;
		Trace trace=new Trace();
		String odRecord = dllod.get(index).getHphm();
		trace.setHp(odRecord);
		for (int i = 0; i < dllod.size(); i++) {
			List<Trail> traillist = trace.getTrail();
			OdRecord record = dllod.get(i);
			Trail trail=new Trail(record.getTgsj(), new Kakou(record.getDkdm(), record.getName(), record.getLat(), record.getLon()));
			
			if (record.getHphm().equals(odRecord)) {
				traillist.add(trail);
			}else {
				result.add(trace);
				trace=new Trace();
				trace.setHp(record.getHphm());
				trace.getTrail().add(trail);
				index=i+1;
				odRecord = dllod.get(index).getHphm();
			}
		}
		result.add(trace);
	}

}
