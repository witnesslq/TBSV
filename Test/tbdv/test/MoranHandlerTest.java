package tbdv.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tbdv.entity.MoranResult;
import tbdv.service.LukuangMoranService;
import tbdv.service.MoranService;

public class MoranHandlerTest {
	
	private ApplicationContext ctx=null;
	private MoranService moranService;
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
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		moranService=ctx.getBean(MoranService.class);
		lkmoranService=ctx.getBean(LukuangMoranService.class);
		
	}


	@Test
	public void test() {
		  String option="kkll";
		  String plus="10";
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
		System.out.println(result);
		
	}
	
//	@Test
//	public void test2() {
//		  String option="sslk";
//		  String plus="60";
//		  Map<String, MoranResult> result=new HashMap<String, MoranResult>();
//			
//			System.out.println(option);
//			if (option.equals("kkll")) {
//				List<String> allData = MoranService.allData();
//				for (String dkdm : allData) {
//					Map<String, Double> map = moranService.computeJBMoran(dkdm, "2016-4-14", plus);
//					result.put(dkdm, new MoranResult(dkdm, map));
//					}
//			}else{
//				List<String> data = LukuangMoranService.getData();
//				for (String lukuang : data) {
//					Map<String, Double> map = lkmoranService.computeJBMoran(lukuang, "2016-4-14", plus);
//					result.put(lukuang, new MoranResult(lukuang, map));
//				}
//			}
//			
//			System.out.println(result);
//	}

}
