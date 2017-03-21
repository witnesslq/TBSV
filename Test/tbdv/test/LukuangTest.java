package tbdv.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tbdv.entity.Lukuang;
import tbdv.service.LukuangMoranService;
import tbdv.service.LukuangService;

public class LukuangTest {
	

	private ApplicationContext ctx=null;
	private LukuangService lService;
	private LukuangMoranService lmservice=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		lService=ctx.getBean(LukuangService.class);
		lmservice=ctx.getBean(LukuangMoranService.class);
	}

	@Test
	public void test() {
		List<Lukuang> list = lService.getLukuangByRoad("东联路(春柳到西安路)","2016-4-7");
		System.out.println(list);
		System.out.println(list.size());
		
		List<Lukuang> list2 = lService.getLukuangByTime("东联路(春柳到西安路)","2016-4-7 08:00:00","2016-4-7 10:00:00");
		System.out.println(list2);
		
	}
	
	@Test
	public void tes1t() {
		double d = lmservice.computeQJMoran("2016-4-7", "60");
		System.out.println(d);
		
	}
	
	@Test
	public void tes2t() {
	Map<String, Double> moran = lmservice.computeJBMoran("东联路(海口路到春柳)","2016-4-7", "15");
		System.out.println(moran);
		
	}

}
