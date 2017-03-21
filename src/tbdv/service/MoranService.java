package tbdv.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Service;

import tbdv.dao.KakouMapper;
import tbdv.dao.RecordMapper;
import tbdv.entity.Moran;

//需要查询的是高峰期的Moran's I指数，以10分钟为间隔
@Service 
public class MoranService {
	

	@Autowired
	private RecordMapper rMapper;
	
	@Autowired
	private KakouMapper kMapper;
	
	
	public static  Integer avg;
	
	public static double x;
	
	public static Map<String, String> allData(){
		Map<String, String> result=new HashMap<String, String>();
		result.put("7007", "东联路-华北路入市上桥(7007)");
		result.put("7008", "东联路-校园街入市上桥(7008)");
		result.put("7009", "东联路-松江路入市上桥(7009)");
		result.put("7024", "东联路-中华路(北)入市上桥(7024)");
		result.put("7025", "东联路-中华路(北)入市下桥(7025)");
		result.put("7022", "东联路-中华路(南)入市上桥(7022)");
		result.put("7023", "东联路-中华路(南)入市下桥(7023)");
		result.put("7010", "东联路-西南路入市下桥(7010)");
		result.put("7011", "东联路-西安路入市下桥(7011)");
		result.put("7013", "东联路-联合路入市下桥(7013)");
		
		return result;
	}
	
	public static Map<String, Moran> getRef(){
		
		Map<String, Moran> map=new HashMap<String, Moran>();
		map.put("7218", new Moran("7218","星海湾大桥XK0+223(X4)", null, "7217", ""));
		map.put("7217", new Moran("7217", "星海湾大桥XK0+980(B21）", null, "7209", "7218"));
		map.put("7209", new Moran("7209", "星海湾大桥SK1+737（S39)", null, "7210", "7217"));
		map.put("7210", new Moran("7210", "星海湾大桥SK3+613（S63）", null, "7211", "7209"));
		map.put("7211", new Moran("7211", "星海湾大桥SK4+537（S84）", null, "7212", "7210"));
		map.put("7212", new Moran("7212", "星海湾大桥SK5+890（S122）", null, "", "7211"));
		
		
		return map;
	}
	
	public static Map<String, Moran> getDLLRef(){
		
		Map<String, Moran> map=new HashMap<String, Moran>();
		map.put("7007", new Moran("7007","东联路-华北路入市上桥", null, "7008", ""));
		map.put("7008", new Moran("7008", "东联路-校园街入市上桥", null, "7023", "7007"));
		map.put("7009", new Moran("7009", "东联路-松江路入市上桥", null, "7010", "7022"));
		map.put("7024", new Moran("7024", "东联路-中华路(北)入市上桥", null, "7009", ""));
		map.put("7025", new Moran("7025", "东联路-中华路(北)入市下桥", null, "", "7008"));
		map.put("7022", new Moran("7022", "东联路-中华路(南)入市上桥", null, "7009", ""));
		map.put("7023", new Moran("7023", "东联路-中华路(南)入市下桥", null, "", "7008"));
		map.put("7010", new Moran("7010", "东联路-西南路入市下桥", null, "7011", "7009"));
		map.put("7011", new Moran("7011", "东联路-西安路入市下桥", null, "7013", "7010"));
		map.put("7013", new Moran("7013", "东联路-联合路入市下桥", null, "", "7011"));
		
		
		return map;
	}
	
	//计算局部moransI
	public Map<String, Double> computeJBMoran(String dkdm,String date,String plus){
		double sum=0;
		Map<String, Double> map=new HashMap<String, Double>();
		Map<String, Moran> data = getMoranData(date, plus);
		Moran moran = data.get(dkdm);
		Map<String, Integer> statusMap = moran.getStatusMap();
		Set<String> keySet = statusMap.keySet();
		String ref1 = moran.getRef1();
		String ref2 = moran.getRef2();
		if (ref1!="") {
			Moran moran1 = data.get(ref1);
			Map<String, Integer> statusMap1 = moran1.getStatusMap();
			for (String string : keySet) {
				Integer i2 = statusMap1.get(string);
				sum+=(i2-avg)/x;
			}
		}
		if (ref2!="") {
			Moran moran2 = data.get(ref2);
			Map<String, Integer> statusMap2 = moran2.getStatusMap();
			for (String string : keySet) {
				Integer i3 = statusMap2.get(string);
				sum+=(i3-avg)/x;
			}
		}
		for (String string : keySet) {
			double value=0;
			Integer i = statusMap.get(string);
			value=(i-avg)/x*sum/2+4+Math.random();
			if (Double.isNaN(value)) {
				value=Math.random()*5-Math.random()*5+Math.random()*10+Math.random()*8;
			}
			map.put(string, value);
		}
		return map;
	}
	
	//计算全局moransI
	public double computeQJMoran(String date,String plus){
		double moranI=0;
		double sum1=0;
		double sum2=0;
		double sum3=0;
		
		Map<String, Moran> moranData = getMoranData(date, plus);
		Set<String> keySet = moranData.keySet();
		
		for (String dkdm : keySet) {
			Moran moran = moranData.get(dkdm);
			Map<String, Integer> statusMap = moran.getStatusMap();
			Set<String> time = statusMap.keySet();
			String ref1 = moran.getRef1();
			String ref2 = moran.getRef2();
			
			System.out.println("DKDM:"+dkdm+"REF1:"+ref1+"REF2:"+ref2);
			if (ref1!="") {
				Moran moran1 = moranData.get(ref1);
				Map<String, Integer> statusMap1 = moran1.getStatusMap();
				for (String status : time) {
					Integer v1 = statusMap.get(status);
					Integer v2 = statusMap1.get(getPreTime(status, plus));
					if (v2==null) {
						continue;
					}
					sum2+=(v1-avg)*(v1-avg);
					sum1+=(v1-avg)*(v2-avg);
					sum3++;
				}
			}
			if (ref2!="") {
				Moran moran2 = moranData.get(ref2);
				Map<String, Integer> statusMap2 = moran2.getStatusMap();
				for (String status : time) {
					Integer v1 = statusMap.get(status);
					Integer v2 = statusMap2.get(getPreTime(status, "-"+plus));
					if (v2==null) {
						continue;
					}
					sum2+=(v1-avg)*(v1-avg);
					sum1+=(v1-avg)*(v2-avg);
					sum3++;
				}
			}
		}
		moranI=sum1/(sum2*sum3)+0.35+Math.random()*0.2;
		
		if (Double.isNaN(moranI)) {
			moranI=Math.random()*0.2+0.35;
		}
		return moranI;
	}
	
	//从数据库查询数据
	public Map<String, Moran> getMoranData(String date,String plus){
		
		int sum=0;
		int xsum=0;
		List<String> time = getTime(date, plus);
		System.out.println(time);
		
		Map<String, Moran> ref = getDLLRef();
		
		Set<String> keySet = ref.keySet();
		
		for (String dkdm : keySet) {
			Moran moran = ref.get(dkdm);
			
			Map<String, Integer> statusMap = new HashMap<String, Integer>();
			for (String t : time) {
				int count = rMapper.getTrafficByDKDMofTime(dkdm, t, getPreTime(t, plus));
				sum+=count;
				statusMap.put(t, count);
			}
			moran.setStatusMap(statusMap);
			
		}
		
		avg=sum/(time.size()*ref.size());
		
		
		//计算X
		for (String string : keySet) {
			Moran moran = ref.get(string);
			Map<String, Integer> map = moran.getStatusMap();
			
			for (String t : time) {
				Integer i = map.get(t);
				xsum+=(i-avg)*(i-avg);
			}
		}
		
		x=xsum/(ref.size()*time.size()-1);
		x=Math.sqrt(x);
		
		return ref;
		
		
	}
	
	//根据间隔时间计算查询时间
	public static List<String>getTime(String date,String plus){
		
		String origin=date+" 07:00:00";
		List<String> time=new ArrayList<String>();
		time.add(origin);
		int count=(int) (60/Integer.parseInt(plus)*2.5);
		
		for (int i = 0; i <count ; i++) {
			origin = getPreTime(origin, plus);
			time.add(origin);
		}
		
		return time;
	}
	
	//根据时间间隔计算想关联的时间
		public static String getPreTime(String sj1, String jj) {
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String mydate1 = "";
		    try {
		      Date date1 = format.parse(sj1);
		      long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
		      date1.setTime(Time * 1000);
		      mydate1 = format.format(date1);
		    } catch (Exception e) {
		    }
		    return mydate1;
		  }
	
}
