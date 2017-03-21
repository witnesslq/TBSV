package tbdv.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tbdv.entity.KakouResult;
import tbdv.service.KakouService;

@Controller
public class KakouHandler {
	
	@Autowired
	private KakouService kakouService;
	
	@ResponseBody
	@RequestMapping(value="kakouday",method=RequestMethod.POST)
	public List<KakouResult> getKakouForADay(String date){
		System.out.println(date);
		 List<KakouResult> list = kakouService.allKakouTrafficOfOneDay(date);
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="hotmap",method=RequestMethod.POST)
	public List<KakouResult> getKakouForTime(String date,String begin,String end){
		System.out.println(date);
		System.out.println(begin);
		System.out.println(end);
		 List<KakouResult> list = kakouService.kakouResultsForTime(date, begin, end);
		System.out.println(list);
		return list;
	}

	
	
	

}
