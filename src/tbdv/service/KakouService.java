package tbdv.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tbdv.dao.KakouMapper;
import tbdv.entity.Kakou;
import tbdv.entity.KakouResult;

@Service
public class KakouService {

	@Autowired
	private KakouMapper kakouMapper;

	@Autowired
	private RecordService recordService;

	//查询单个卡口
	public Kakou getKakouByDKDM(String dkdm) {
		Kakou k = kakouMapper.getKakouByDKDM(dkdm);
		return k;
	}

	//查询所有的卡口
	public List<Kakou> getAllKakous() {
		List<Kakou> kakous = kakouMapper.getAllKakous();
		return kakous;
	}

	//返回一天中所有卡口的车流量统计
	public List<KakouResult> allKakouTrafficOfOneDay(String date) {
		List<KakouResult> result = new ArrayList<KakouResult>();
		List<Kakou> kakous = getAllKakous();
		for (Kakou kakou : kakous) {
			result.add(new KakouResult(kakou.getName(), recordService
					.getOneDayTrafficByDKDM(kakou.getDkdm(), date)));

		}
		return result;
	}
	
	//返回指定时刻所有卡口的车流量统计
	public List<KakouResult> kakouResultsForTime(String day,String begin,String end){
		List<KakouResult> result = new ArrayList<KakouResult>();
		List<Kakou> kakous = getAllKakous();
		for (Kakou kakou : kakous){
			result.add(new KakouResult(kakou.getName(),recordService.getTrafficByDKDMofTime(kakou.getDkdm(), day, begin, end)));
		}
		return result;
	}

}
