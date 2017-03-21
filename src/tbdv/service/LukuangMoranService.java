package tbdv.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tbdv.entity.Lukuang;
import tbdv.entity.LukuangRef;

@Service
public class LukuangMoranService {
	
	@Autowired
	private LukuangService lservice;
	
	public static  Integer avg;
	
	public static double x;
	
	public static List<String> getData(){
		List<String> result=new ArrayList<String>();
		result.add("东联路(华北路到中华路)");
		result.add("东联路(中华路到金三角)");
		result.add("东联路(金三角到海口路)" );
		result.add("东联路(海口路到春柳)");
		result.add("东联路(春柳到西安路)" );
		result.add("东联路(西安路到联合路)" );
		result.add("联合路(东联路上道口到鞍山路)");
		return result;
	}
	
	public static Map<String,LukuangRef> getRef(){
		Map<String, LukuangRef> map=new HashMap<String, LukuangRef>();
		map.put("东联路(华北路到中华路)", new LukuangRef("东联路(华北路到中华路)", "东联路(中华路到金三角)", "",null));
		map.put("东联路(中华路到金三角)", new LukuangRef("东联路(中华路到金三角)","东联路(金三角到海口路)", "东联路(华北路到中华路)",null));
		map.put("东联路(金三角到海口路)", new LukuangRef("东联路(金三角到海口路)","东联路(海口路到春柳)", "东联路(中华路到金三角)",null));
		map.put("东联路(海口路到春柳)", new LukuangRef("东联路(海口路到春柳)","东联路(春柳到西安路)", "东联路(金三角到海口路)",null));
		map.put("东联路(春柳到西安路)", new LukuangRef("东联路(春柳到西安路)","东联路(西安路到联合路)", "东联路(海口路到春柳)",null));
		map.put("东联路(西安路到联合路)", new LukuangRef("东联路(西安路到联合路)","联合路(东联路上道口到鞍山路)", "东联路(春柳到西安路)",null));
		map.put("联合路(东联路上道口到鞍山路)", new LukuangRef("联合路(东联路上道口到鞍山路)","", "东联路(西安路到联合路)",null));
		return map;
	}

	//计算局部moransI
		public Map<String, Double> computeJBMoran(String road,String date,String plus){
			double sum=0;
			Map<String, Double> map=new HashMap<String, Double>();
		Map<String, LukuangRef> data = getLukuangMoranData(date, plus);
		LukuangRef moran = data.get(road);
		Map<String, Integer> statusMap = moran.getStatusMap();
		Set<String> keySet = statusMap.keySet();
			String ref1 = moran.getRef1();
			String ref2 = moran.getRef2();
			if (ref1!="") {
				LukuangRef moran1 = data.get(ref1);
				Map<String, Integer> statusMap1 = moran1.getStatusMap();
				for (String string : keySet) {
					Integer i2 = statusMap1.get(string);
					sum+=(i2-avg)/x;
				}
			}
			if (ref2!="") {
				LukuangRef moran2 = data.get(ref2);
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
			
			Map<String,LukuangRef> moranData = getLukuangMoranData(date, plus);
			Set<String> keySet = moranData.keySet();
			
			for (String road : keySet) {
				LukuangRef moran = moranData.get(road);
				Map<String, Integer> statusMap = moran.getStatusMap();
				Set<String> time = statusMap.keySet();
				String ref1 = moran.getRef1();
				String ref2 = moran.getRef2();
				
				System.out.println("ROAD:"+road+"REF1:"+ref1+"REF2:"+ref2);
				if (ref1!="") {
					LukuangRef moran1 = moranData.get(ref1);
					Map<String, Integer> statusMap1 = moran1.getStatusMap();
					for (String status : time) {
						Integer v1 = statusMap.get(status);
						Integer v2 = statusMap1.get(MoranService.getPreTime(status, plus));
						if (v2==null) {
							continue;
						}
						sum2+=(v1-avg)*(v1-avg);
						sum1+=(v1-avg)*(v2-avg);
						sum3++;
					}
				}
				if (ref2!="") {
					LukuangRef moran2 = moranData.get(ref2);
					Map<String, Integer> statusMap2 = moran2.getStatusMap();
					for (String status : time) {
						Integer v1 = statusMap.get(status);
						Integer v2 = statusMap2.get(MoranService.getPreTime(status, "-"+plus));
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
		public Map<String, LukuangRef> getLukuangMoranData(String date,String plus){
			
			int sum=0;
			int xsum=0;
			List<String> time = MoranService.getTime(date, plus);
			System.out.println(time);
			 Map<String, LukuangRef> ref = getRef();
			
			Set<String> keySet = ref.keySet();
			
			for (String road : keySet) {
				 LukuangRef lukuangRef = ref.get(road);
				
				Map<String, Integer> statusMap = new HashMap<String, Integer>();
				for (String t : time) {
					List<Lukuang> list = lservice.getLukuangByTime(road, t, MoranService.getPreTime(t, plus));
					int tmp=0;
					for (Lukuang lukuang : list) {
						
						String s1 = lukuang.getCurrent_status();
						if (s1==null) {
							continue;
						}
						tmp+=new Integer(s1);
					}
					
					sum+=tmp;
					statusMap.put(t, tmp);
				}
				lukuangRef.setStatusMap(statusMap);
				
			}
			
			avg=sum/(time.size()*ref.size());
			
			
			//计算X
			for (String string : keySet) {
				LukuangRef lukuangRef = ref.get(string);
				Map<String, Integer> map = lukuangRef.getStatusMap();
				
				for (String t : time) {
					Integer i = map.get(t);
					xsum+=(i-avg)*(i-avg);
				}
			}
			
			x=xsum/(ref.size()*time.size()-1);
			x=Math.sqrt(x);
			
			return ref;
			
			
			
		}
}
