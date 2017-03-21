package tbdv.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tbdv.dao.TravelMapper;
import tbdv.entity.TravelRecord;
import tbdv.entity.TravelResult;

@Service
public class TravelService {

	@Autowired
	private TravelMapper tMapper;

	public static List<String> travelKakous = new ArrayList<String>();
	public  static List<String> dates = new ArrayList<String>();
	public  static List<TravelResult> results = new ArrayList<TravelResult>();

	// 查询这些卡口在五一黄金周的车牌归属
	public void getHPGuishu() {
		for (String date : dates) {
			TravelResult travelResult = new TravelResult();
			travelResult.setDate(date);
			Integer Ashenyang = 0;
			Integer Bdalian = 0;
			Integer Canshan = 0;
			Integer Dfushun = 0;
			Integer Ebenxi = 0;
			Integer Fdandong = 0;
			Integer Gjinzhou = 0;
			Integer Hyingkou = 0;
			Integer Jfuxin = 0;
			Integer Kliaoyang = 0;
			Integer Lpanjin = 0;
			Integer Mtieling = 0;
			Integer Nchaoyang = 0;
			Integer Phuludao = 0;
			Integer Vshengzhi = 0;
			Integer other = 0;
			
			for (String kakou : travelKakous) {
				
				List<TravelRecord> list = tMapper.getAllByDKDMOfDate(kakou,
						date);
				for (TravelRecord travelRecord : list) {
					String hphm = travelRecord.getHphm();
					char first = hphm.charAt(0);
					char second = hphm.charAt(1);
					
					if (first == '辽') {
						switch (second) {
						case 'A':Ashenyang++;break;
						case 'B':Bdalian++;break;
						case 'C':Canshan++;break;
						case 'D':Dfushun++;break;
						case 'E':Ebenxi++;break;
						case 'F':Fdandong++;break;
						case 'G':Gjinzhou++;break;
						case 'H':Hyingkou++;break;
						case 'J':Jfuxin++;break;
						case 'K':Kliaoyang++;break;
						case 'L':Lpanjin++;break;
						case 'M':Mtieling++;break;
						case 'N':Nchaoyang++;break;
						case 'P':Phuludao++;break;
						case 'V':Vshengzhi++;break;
						}
					} else {
						other++;
					}
				}
			}
			Map<String, Integer> result = travelResult.getResult();
			result.put("沈阳市", Ashenyang);
			result.put("大连市", Bdalian);
			result.put("鞍山市", Canshan );
			result.put("抚顺市", Dfushun );
			result.put("本溪市", Ebenxi );
			result.put("丹东市", Fdandong );
			result.put("锦州市", Gjinzhou );
			result.put("营口市", Hyingkou );
			result.put("阜新市", Jfuxin);
			result.put("辽阳市", Kliaoyang);
			result.put("盘锦市", Lpanjin);
			result.put("铁岭市", Mtieling);
			result.put("朝阳市", Nchaoyang);
			result.put("葫芦岛市", Phuludao);
			result.put("省直属", Vshengzhi);
			result.put("外省", other);
		    travelResult.setResult(result);
			results.add(travelResult);
		}

	}

	static {
		travelKakous.add("7098");
		travelKakous.add("7097");
		travelKakous.add("7220");
		travelKakous.add("7204");
		travelKakous.add("7085");
		travelKakous.add("7084");
		travelKakous.add("7083");
		travelKakous.add("7082");
		travelKakous.add("7081");
		travelKakous.add("7063");
		travelKakous.add("7062");
		dates.add("2016-5-1");
		dates.add("2016-5-2");
		dates.add("2016-5-3");
		dates.add("2016-5-4");
		dates.add("2016-5-5");
	}
}
