package tbdv.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tbdv.dao.LukuangMapper;
import tbdv.entity.KakouResult;
import tbdv.entity.MoranResult;
import tbdv.service.LukuangMoranService;
import tbdv.service.MoranService;

@Controller
public class MoranHandler {
	
	@Autowired
	private MoranService moranService;
	
	@Autowired
	private LukuangMoranService lkmoranService;
	
	private static List<String> getDate(){
		List<String> date=new ArrayList<String>();
		date.add("2016-4-14");
		date.add("2016-4-15");
		date.add("2016-4-16");
		date.add("2016-4-17");
		date.add("2016-4-18");
		date.add("2016-4-19");
		date.add("2016-4-20");
		return date;
	}
	
	@ResponseBody
	@RequestMapping(value="weekmoran",method=RequestMethod.POST)
	public Map<String, Double> getqjMoranForWeek(String option,String plus){
		Map<String, Double> result=new HashMap<String, Double>();
		List<String> date = getDate();
		System.out.println(option);
		if (option.equals("kkll")) {
			for (String day : date) {
				double d = moranService.computeQJMoran(day, plus);
				result.put(day, d);
			}
		}else {
			for (String day : date) {
				double d = lkmoranService.computeQJMoran(day, plus);
				result.put(day, d);
			}
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value="qjmoran",method=RequestMethod.POST)
	public Double getqjMoranForADay(String option,String plus,String date){
		if (option.equals("kkll")) {
				double d = moranService.computeQJMoran(date, plus);
				System.out.println("全局结果："+d);
				return new Double(d);
			
		}else {
				double d = lkmoranService.computeQJMoran(date, plus);
				System.out.println("全局结果："+d);
				return new Double(d);
		}
		
	}

	@ResponseBody
	@RequestMapping(value="jbmoran",method=RequestMethod.POST)
	public List<MoranResult> getJBMoranForADay(String option,String plus,String date){
		List<MoranResult> result=new ArrayList<MoranResult>();
	
		System.out.println(option);
		if (option.equals("kkll")) {
			 Map<String, String> allData = MoranService.allData();
			 Set<String> keySet = allData.keySet();
			for (String dkdm : keySet) {
				Map<String, Double> map = moranService.computeJBMoran(dkdm, date, plus);
				result.add(new MoranResult(allData.get(dkdm), map));
			
				}
		}else{
			List<String> data = LukuangMoranService.getData();
			for (String lukuang : data) {
				Map<String, Double> map = lkmoranService.computeJBMoran(lukuang, date, plus);
				result.add(new MoranResult(lukuang, map));
			}
		}
		
		return result;
	}

	
}
