package tbdv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tbdv.dao.RecordMapper;
import tbdv.entity.Kakou;
import tbdv.entity.Record;

@Service
public class RecordService {
    
	@Autowired
	private RecordMapper recordMapper;
	
	@Autowired
	private KakouService kService;
	
	//测试指定卡口某一天的车流量
	public int getOneDayTrafficByDKDM(String dkdm,String date){
		int count = recordMapper.getOneDayTrafficByDKDM(dkdm, date);
		return count;
	}

	
	//测试指定卡口某天特定时间的车流量
	public int getTrafficByDKDMofTime(String dkdm,String day,String begin,String end){
		begin=day+" "+begin;
		end=day+" "+end;
		int countOfRange = recordMapper.getTrafficByDKDMofTime(dkdm,begin,end);
		return countOfRange;
	}
	
	public List<Kakou> getXHW(){
		List<Kakou> xhwKakous=new ArrayList<Kakou>();
		List<Record> list = recordMapper.getKakouOfXHW();
		for (Record record : list) {
			Kakou kakou = kService.getKakouByDKDM(record.getDkdm());
			xhwKakous.add(kakou);
		}
		return xhwKakous;
	}
	
	public List<Kakou> getDLL(){
		List<Kakou> dllKakous=new ArrayList<Kakou>();
		List<Record> list = recordMapper.getKakouOfDLL();
		for (Record record : list) {
			Kakou kakou = kService.getKakouByDKDM(record.getDkdm());
			dllKakous.add(kakou);
		}
		return dllKakous;
	}
	
}
