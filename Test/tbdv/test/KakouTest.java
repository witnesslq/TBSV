package tbdv.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

import tbdv.entity.Kakou;
import tbdv.entity.KakouResult;
import tbdv.service.KakouService;

public class KakouTest {

	private ApplicationContext ctx=null;
	private KakouService rService=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		rService=ctx.getBean(KakouService.class);
	}
	
	@Test
	public void test() {
		Kakou k = rService.getKakouByDKDM("7001");
		System.out.println(k);
	}
	
//	@Test
//	public void test1() {
//		Map<String, Integer> map = rService.allKakouTrafficOfOneDay("2016-5-1");
//		List<Kakou> allKakous = rService.getAllKakous();
//		String string="[";
//		//{name: "海门", value: 9},
//		for (Kakou kakou : allKakous) {
//			String dkdm = kakou.getDkdm();
//			 kakou.setCount(map.get(dkdm));
//			string=string+"{name:\""+kakou.getName()+"\", value:"+kakou.getCount()+"},";
//		}
//		
////		String str=new Gson().toJson(allKakous);
//		System.out.println(string);
//	}
	
//	//所有卡口某天的所有过车量
//	@Test
//	public void test2() {
//		Map<String, Integer> map = rService.allKakouTrafficOfOneDay("2016-5-1");
//		System.out.println(map);
//	}
	
	@Test
	public void test3() {
		Gson gson=new Gson();
//		Map<String, Integer> map=new HashMap<String, Integer>();
//		map.put("7001", 111);
//		map.put("7002", 112);
//		map.put("7003", 113);
		List<KakouResult> k=new ArrayList<KakouResult>();
		k.add(new KakouResult("7001", 111));
		k.add(new KakouResult("7002", 111));
		k.add(new KakouResult("7003", 111));
		k.add(new KakouResult("7004", 111));
		System.out.println(gson.toJson(k));
		//[{"name":"7001","value":111},{"name":"7002","value":111},{"name":"7003","value":111},{"name":"7004","value":111}]

	}
	
	@Test
	public void test4() {
		
	List<KakouResult> list = rService.kakouResultsForTime("2016-5-1", "07:00:00", "08:00:00");
	System.out.println(list);

	}

}
