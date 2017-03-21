package tbdv.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

import tbdv.entity.TravelResult;
import tbdv.service.TravelService;

public class TestTravel {

	private ApplicationContext ctx=null;
	private TravelService rService=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		rService=ctx.getBean(TravelService.class);
	}
	
	@Test
	public void test() {
		rService.getHPGuishu();
		Map<String, ArrayList<Integer>> result=new HashMap<String, ArrayList<Integer>>();
		Set<String> keySet=	rService.results.get(0).getResult().keySet();
		for (String s:keySet) {
			result.put(s, new ArrayList<Integer>());
		}
		
		for (TravelResult t:rService.results) {
			System.out.println(t.getDate());
			Map<String, Integer> result1 = t.getResult();
			for (String s:keySet) {
				result.get(s).add(result1.get(s));
			}
		}
		
		System.out.println(result);
//		Gson gson=new Gson();
//		String gString=gson.toJson(rService.results);
//		System.out.println(rService.results);
//		System.out.println(gString);
	}

}
