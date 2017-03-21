package tbdv.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tbdv.entity.Trace;
import tbdv.service.TraceService;

@Controller
public class TraceHandler {
	
	@Autowired
	private TraceService tService;
	
	
	@ResponseBody
	@RequestMapping(value="trace",method=RequestMethod.POST)
	public Trace getTraceByHPAndDate(String hphm,String date,String begin,String end){
		System.out.println(hphm);
		System.out.println(date);
		System.out.println(begin);
		System.out.println(end);
		Trace trace = tService.getRecordForSomeTimeByHP(hphm, date, begin, end);
		System.out.println(trace);
		return trace;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="od",method=RequestMethod.POST)
	public List<Trace> getOD(String table,String date,String begin,String end){
		System.out.println("查询的数据表名："+table);
		System.out.println(date);
		System.out.println(begin);
		System.out.println(end);
		List<Trace> od = tService.getOD(table, date, begin, end);
		System.out.println(od);
		return od;
		
	}
	

}
