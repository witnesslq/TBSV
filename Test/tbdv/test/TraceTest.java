package tbdv.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tbdv.entity.OdRecord;
import tbdv.entity.Trace;
import tbdv.service.TraceService;

public class TraceTest {
	
	private ApplicationContext ctx=null;
	private TraceService rService=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		rService=ctx.getBean(TraceService.class);
	}

	
	
	@Test
	public void test1() {
		Trace trace = rService.getRecordForSomeTimeByHP("辽HHC661", "2016-5-1", null, null);
		System.out.println(trace);

	}
	
	
	
	@Test
	public void test3() {
	List<Trace> od = rService.getOD("dll", "2016-5-1", "08:00:00", "08:05:00");
	for (Trace trace : od) {
		System.out.println(trace.getHp()+"---"+trace.getTrail().size()+"个道口"+trace.getTrail().toString());
	}
		System.out.println("一共有记录数："+od.size());

	}

}
