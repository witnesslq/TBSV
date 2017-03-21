package tbdv.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

import tbdv.dao.KakouMapper;
import tbdv.entity.Kakou;
import tbdv.entity.KakouResult;
import tbdv.entity.Moran;
import tbdv.service.KakouService;
import tbdv.service.MoranService;
import tbdv.service.RecordService;

public class Test1 {
	
	private ApplicationContext ctx=null;
	private RecordService rService=null;
	private KakouMapper kMapper=null;
	private MoranService mService=null;
	private KakouService kakouService=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		rService=ctx.getBean(RecordService.class);
		kMapper=ctx.getBean(KakouMapper.class);
		mService=ctx.getBean(MoranService.class);
		kakouService=ctx.getBean(KakouService.class);
		
	}

//	@Test
//	public void test() {
//		Date date=Date.valueOf("2016-5-1");
//		System.out.println(date.toString());
//	}

	//测试指定卡口某一天的车流量
	@Test
	public void test1() {
		int count = rService.getOneDayTrafficByDKDM("7021", "2016-5-1");
		System.out.println(count);
	}

	//测试指定卡口某天特定时间的车流量
	@Test
	public void test2() {
		String day="2016-5-1";
		String begin="08:00:00";
		String end="09:00:00";
		int count = rService.getTrafficByDKDMofTime("9066", day, begin, end);
		System.out.println(count);
	}
	
	@Test
	public void test3() {
		Gson gson=new Gson();
		List<Kakou> dll = rService.getDLL();
		
		List<Kakou> xhw = rService.getXHW();
		String dllStr = gson.toJson(dll);
		String xhwStr = gson.toJson(xhw);
		System.out.println(dllStr);
		System.out.println(dll.size());
		System.out.println(xhwStr);
		System.out.println(xhw.size());
	}
	
	@Test
	public void test4() {
		Date date = new Date();
	    long times = date.getTime();//时间戳
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String dateString = formatter.format(date);
	    System.out.println(dateString);
	}
	
	@Test
	public void test5() {

		 List<KakouResult> list = kakouService.allKakouTrafficOfOneDay("2016-5-4");
			System.out.println(list);
			Gson gson=new Gson();
			System.out.println(gson.toJson(list));
			
		
	}
	
	@Test
	public void test8() {
		Integer i=7;
		double d=2.1;
		System.out.println(i-d);
		
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		Integer integer = map.get("d");
		System.out.println(integer);
		
	}
	
	@Test
	public void test7() {
		double d = mService.computeQJMoran("2016-4-14", "15");
		System.out.println("全局Moran:"+d);
		
//		Map<String, Double> map = mService.computeJBMoran("7209", "2016-5-2", "5");
//		System.out.println(map);
	 
	}

	
	@Test
	public void test9() {
	
		Map<String, Double> map = mService.computeJBMoran("7218", "2016-5-1", "15");
		System.out.println(map);
	 
	}
	
	  
	@Test
	public void test11() {
	
		double d = mService.computeQJMoran("2016-4-15", "15");
		System.out.println(d);
	 
	}
}