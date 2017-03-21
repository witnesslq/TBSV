package tbdv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tbdv.dao.LukuangMapper;
import tbdv.entity.Lukuang;

@Service
public class LukuangService {
	
	@Autowired
	private LukuangMapper lukuangMapper;
	
	public List<Lukuang> getLukuangByRoad(String road,String date){
		return lukuangMapper.getLukuangByRoad(road,date);
	};

	public List<Lukuang> getLukuangByTime(String road,String begin,String end){
		return lukuangMapper.getLukuangByTime(road, begin, end);
	};

}
