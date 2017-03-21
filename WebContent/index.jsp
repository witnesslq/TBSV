<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctp" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大连市交通大数据可视化信息系统</title>
<!--引入百度地图的jssdk，这里需要使用你在百度地图开发者平台申请的 ak-->
<script
	src="http://api.map.baidu.com/api?v=2.0&ak=5II3dyLWO4UzRyBnmB2DiqD7h2wSSaa1"></script>
<!-- 引入 ECharts -->
<script src="${ctp}/static/echarts.min.js"></script>
<!-- 引入百度地图扩展 -->
<script src="${ctp}/static/bmap.min.js"></script>
<!--jQuery 的主文件-->
<script type="text/javascript" src="${ctp}/static/easyui/jquery.min.js"></script>
<!--easyUI 的主文件...-->
<script src="${ctp}/static/easyui/jquery.easyui.min.js"></script>
<!--easyui 的主样式文件...-->
<link rel="stylesheet"
	href="${ctp}/static/easyui/themes/default/easyui.css">
<!--easyui 的主样式文件...-->
<link rel="stylesheet" href="${ctp}/static/easyui/themes/icon.css">
<!--引入坐标 文件-->
<script type="text/javascript" src="${ctp}/static/js/commons.js"></script>
<!--引入卡口统计脚本-->
<script type="text/javascript" src="${ctp}/static/js/kakoustatistics.js"></script>
<!--引入轨迹追踪脚本-->
<script type="text/javascript" src="${ctp}/static/js/trace.js"></script>
<!--引入od分析脚本-->
<script type="text/javascript" src="${ctp}/static/js/od.js"></script>
<!--引入旅游分析脚本-->
<script type="text/javascript" src="${ctp}/static/js/travel.js"></script>
<!--引入Moran分析脚本-->
<script type="text/javascript" src="${ctp}/static/js/moran.js"></script>

</head>
<body>
<!--南丁格尔玫瑰图窗口...-->
	<div id="pie"><div id="pieChart" style="height: 100%"></div></div>
	<div id="all"><div id="allChart" style="height: 100%"></div></div>
	<!--柱状图窗口...-->
	<div id="zzt">
		<div id="zztChart" style="height: 100%"></div>
	</div>
	<div id="jbmoran"><div id="jbmoranChart" style="height: 100%"></div></div>
	<div id="qjmoran"><div id="qjmoranChart" style="height: 100%"></div></div>
	<div id="layout" class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',title:'大连市交通信息大数据可视化平台',split:true,"
			style="height: 0px;"></div>

		<!--菜单目录...-->
		<div data-options="region:'west',title:'菜单',split:true"
			style="width: 200px;">

			<div id="menu" class="easyui-accordion" data-options="fit:true"
				style="width: 300px; height: 200px;">

				<div title="&nbsp道路路况统计分析" style="overflow: auto; padding: 10px;">

					<h4 style="color: #FF0000;">目前仅提供东联路2016年4月14日至4月21日一周内数据查询</h4>
					<h3 style="color: #0099FF;">日期选择</h3>
					<input id="Mdate" type="text" class="easyui-datebox" required="required" data-options="formatter:myformatter"  >
					<h3 style="color: #0099FF;">要素选择</h3>
					<select id="ysxz" style="width: 150px;">
						<option value="kkll">卡口流量</option>
						<option value="sslk">实时路况</option>
					</select> <br />

					<h3 style="color: #0099FF;">指数选择</h3>
					<select id="zsxz"  style="width: 150px;">
						<option value="quanju">全局时空Moran's指数</option>
						<option value="jubu">局部时空Moran's指数</option>
					</select> <br />
					
					<h3 style="color: #0099FF;">时间间隔</h3>
					
					<input id="plus" class="easyui-numberspinner" style="width:150px;"   
       				 required="required" data-options="min:1,max:60,editable:false">  
					
					
					<a id="cupbtn"
						style="margin-top: 20px; margin-left: 20px;" href="${ctp}/qjmoran"
						class="easyui-linkbutton" data-options="iconCls:'icon-sum'">计算</a>
						
					<a id="week"
                    style="margin-top: 20px; margin-left: 5px;" href="${ctp}/weekmoran"
                   class="easyui-linkbutton" data-options="iconCls:'icon-zhuxing'"
                   >一周全局Moran指数分析</a>

				</div>
				<!------------------------功能分割线-------------------------------------->
				<div title="&nbspOD分析可视化" style="padding: 10px;">
					<h4 style="color: #FF99FF;">为了保证显示效果，建议查询间隔不超过1小时！</h4>
					<h3 style="color: #0099FF;">日期选择</h3>
					<input id="ODdate" type="text" class="easyui-datebox" required="required" data-options="formatter:myformatter"  >

					<h3 style="color: #0099FF;">起始时间</h3>
					<input id="odbegintime" class="easyui-timespinner"
						style="width: 150px;" required="required"
						data-options="min:'00:00',showSeconds:true" />

					<h3 style="color: #0099FF;">终止时间</h3>
					<input id="odendtime" class="easyui-timespinner"
						style="width: 150px;" required="required"
						data-options="min:'00:00',showSeconds:true" hi /> 
						<a id="dllod" style="margin-top: 20px; margin-left: 5px;"
						href="${ctp}/od" class="easyui-linkbutton"
						data-options="iconCls:'icon-od'">东&nbsp;&nbsp;联&nbsp;&nbsp;路</a> 
						<a id="xhwod" style="margin-top: 20px; margin-left: 5px;" href="${ctp}/od"
						class="easyui-linkbutton" data-options="iconCls:'icon-od'">星海湾跨海大桥</a>
				</div>
				<!------------------------功能分割线-------------------------------------->
				<div title="&nbsp卡口统计分析" style="padding: 10px;">
				    <h3 style="color: #11264F;">流量统计</h3>
					<h3 style="color: #0099FF;">日期选择</h3>
					
			 <input id="dd" type="text" class="easyui-datebox" required="required" data-options="formatter:myformatter"  >
					
					</br> <a id="kakou" style="margin-top: 20px; margin-left: 5px;"
						href="${ctp}/kakouday" class="easyui-linkbutton"
						data-options="iconCls:'icon-search'">卡口总流量查询</a> <a id="tongjitu"
						onclick="zztView()" style="margin-top: 20px; margin-left: 5px;"
						class="easyui-linkbutton" data-options="iconCls:'icon-zhuxing'"
						disabled=true>卡口总流量统计</a>
						
				     <h3 style="color: #11264F;">旅游分析</h3>
                <a id="travel" style="margin-top: 20px; margin-left: 5px;"
                   href="${ctp}/travel" class="easyui-linkbutton"
                   data-options="iconCls:'icon-search'">旅游分析</a>

                <a id="alltravel"
                    style="margin-top: 20px; margin-left: 5px;" href="${ctp}/travel"
                   class="easyui-linkbutton" data-options="iconCls:'icon-zhuxing'"
                   >总量分析</a>
                   
                   <!-- ------------------------功能分割线---------------------------- --
					<h3 style="color: #11264F;">热力图分析</h3>
					<h3 style="color: #0099FF;">起始时间</h3>
					<input id="htbegintime" class="easyui-timespinner"
						style="width: 150px;" required="required"
						data-options="min:'00:00',showSeconds:true" />

					<h3 style="color: #0099FF;">终止时间</h3>
					<input id="htendtime" class="easyui-timespinner"
						style="width: 150px;" required="required"
						data-options="min:'00:00',showSeconds:true"  /> 
					<a id="hotmap" style="margin-top: 20px; margin-left: 5px;"
						href="${ctp}/hotmap" class="easyui-linkbutton"
						data-options="iconCls:'icon-od'">热力图显示</a> ----->
						
						
				</div>
				<!------------------------功能分割线-------------------------------------->
				<div title="&nbsp行车轨迹显示" style="padding: 10px;">

					<h3 style="color: #0099FF;">输入号牌号码</h3>
					<input id="hphm" style="width: 150px;" class="easyui-validatebox"
						data-options="required:true,
                        missingMessage:'请输入查询车辆号牌！'" />

					<h3 style="color: #0099FF;">日期选择</h3>
					<select id="tracedate" style="width: 150px;">
						<option value="2016-5-1">2016年5月1日</option>
						<option value="2016-5-2">2016年5月2日</option>
						<option value="2016-5-3">2016年5月3日</option>
						<option value="2016-5-4">2016年5月4日</option>
					</select>

					<h3 style="color: #0099FF;">起始时间</h3>
					<input id="begintime" class="easyui-timespinner"
						style="width: 150px;" data-options="min:'00:00',showSeconds:true" />

					<h3 style="color: #0099FF;">终止时间</h3>
					<input id="endtime" class="easyui-timespinner"
						style="width: 150px;" data-options="min:'00:00',showSeconds:true" />

					<a id="tracequery" style="margin-top: 20px; margin-left: 20px;"
						href="${ctp}/trace" class="easyui-linkbutton"
						data-options="iconCls:'icon-search'">查 询</a>

				</div>
			</div>
		</div>

		<div id="echart" data-options="region:'center',title:'地图可视化'"
			style="padding: 5px; background: #eee;"></div>
	</div>


	<script type="text/javascript">
	
	function myformatter(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'-'+m+'-'+d;
    }
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('echart'));

		option = {
			// 加载 bmap 组件
			bmap : {
				// 百度地图中心经纬度
				center : [ 121.616058, 38.940209 ],
				// 百度地图缩放
				zoom : 14,
				// 是否开启拖拽缩放，可以只设置 'scale' 或者 'move'
				roam : true,
				// 百度地图的自定义样式，见 http://developer.baidu.com/map/jsdevelop-11.htm
				mapStyle : {}
			},
			series : [ {
				type : 'scatter',
				// 使用百度地图坐标系
				coordinateSystem : 'bmap',
				// 数据格式跟在 geo 坐标系上一样，每一项都是 [经度，纬度，数值大小，其它维度...]
				data : [ [ 120, 30, 1 ] ]
			} ]
		}

		var xAxis;
		var yAxis;

		myChart.setOption(option);
		// 获取百度地图实例，使用百度地图自带的控件
		var bmap = myChart.getModel().getComponent('bmap').getBMap();
		bmap.addControl(new BMap.MapTypeControl());

		//全局jqery对象
		$(function() {
			$("#kakou").click(function(){
				allKakouTJ2()
				return false;
			});
			$("#tracequery").click(traceQuery());
			$("#dllod").click(function(){
				od("dll");
				return false;
			});
			$("#xhwod").click(function(){
				od("xhwdqdata");
				return false;
			});
			$("#travel").click(function(){
				travel();
				return false;
			});
			$("#alltravel").click(function(){
				allTravel();
				return false;
			});
			$("#hotmap").click(function(){
				hotmap();
				return false;
			});
			$("#week").click(function(){
				moranWeek();
				return false;
			});
			$("#cupbtn").click(function(){
				cupbtn();
				return false;
			});

		});

		
		
		function cupbtn(){	
				var date=$("#Mdate").datebox('getValue');
				console.log(date);
				var plus=$("#plus").val();
				if(plus==""){
					alert("请输入间隔时间！")
					return false;
				}
				 if(date=='2016-4-14'|date=='2016-4-15'|date=='2016-4-16'|date=='2016-4-17'|date=='2016-4-18'|date=='2016-4-19'|date=='2016-4-20'){
					 var option=$("#ysxz").val(); 
						
						var option1=$("#zsxz").val();
						
						var url=$("#cupbtn").attr("href");
						var url2="${ctp}/jbmoran"
						var args={"option":option,"plus":plus,"date":date}
						console.log(args);
						
						if(option1=="jubu"){
							url=url2;
							$.post(url,args,function(data){
								var legend=[];
								var series=[];
								var value=displayValue(data[0].ref);
								parseMoranData(data,legend,series,value);
								
								 jbmoranoption.series=series;
								 jbmoranoption.xAxis[0].data=value;
							     jbmoranoption.legend.data=legend;
							     $('#jbmoran').window({
					                  width : 1400,
					                  height : 650,
					                  modal : true,
					                  title : "东联路局部Moran`s I指数统计图"
					              });
								  var myChart = echarts.init(document.getElementById('jbmoranChart'));
					              myChart.setOption(jbmoranoption, true);
							},"json");
						}else{
							$.post(url,args,function(data){
								$.messager.alert('查询结果',"您查询的全局Moran`s I指数的结果为："+"<br/>"+data);
							},"json");
						}
						return false;
				}else{
					alert("请选择正确的查询日期！")
					return false;
				}
		}
		
		function moranWeek(){
			var option=$("#ysxz").val(); 
			var plus=$("#plus").val();
			if(plus==""){
				alert("请输入间隔时间！")
				return false;
			}
			var url = $("#week").attr("href");
			var args={option:option,plus:plus}
			console.log(args+url+plus);
			$.post(url,args,function(data){
				var x=[];
				var y=[];
				weekMoanValue(data,x,y);
				weekMoranoption.xAxis[0].data=x;
				weekMoranoption.series[0].data=y;
			        
			        $('#qjmoran').window({
		                  width : 800,
		                  height : 650,
		                  modal : true,
		                  title : "东联路7点至9点半早高峰一周全局Moran`s I指数统计图"
		              });
					  var myChart = echarts.init(document.getElementById('qjmoranChart'));
		              myChart.setOption(weekMoranoption, true);
				console.log(data);
			},"json");
			return false;
		}
		
		
		function allKakouTJ2(){
			
				var date=$("#dd").datebox('getValue');
	            if(date=='2016-5-1'|date=='2016-5-2'|date=='2016-5-3'|date=='2016-5-2'){
	            	$("#tongjitu").linkbutton('enable');
	            	var data;
	            	for(var i=0;i<tjData.length;i++){
		                  if(date==tjData[i].date){
		                      data=tjData[i].data;
		                  }
		              }
	            	xAxis=[];
	            	yAxis=[];
	            	
	            	//为柱状图准备数据
	            	for (var i = 0; i < data.length; i++) {
						xAxis.push(data[i].name);
						yAxis.push(data[i].value);

					};
					ksoption.series[0].data = convertData(data);
					ksoption.title.text = date + "市区卡口总流量统计图";
					var myChart = echarts.init(document
							.getElementById('echart'));
					myChart.setOption(ksoption, true);
					
	            }else{
	            	alert("没有所选日期的数据！");
	            }
	            
	            return false;
			
		}
		//统计一天的所有卡口流量
		function allKakouTJ() {
			$("#kakou").click(function(){
				 var date=$("#dd").datebox('getValue');
		            if(date=='2016-5-1'|date=='2016-5-2'|date=='2016-5-3'|date=='2016-5-2'){
		            	
		            	$("#tongjitu").linkbutton('enable');
						var url = $(this).attr("href");
						var args = {
							"date" : date
						};
						$.post(url, args, function(data) {
							//为柱状图准备数据
							for (var i = 0; i < data.length; i++) {
								xAxis.push(data[i].name);
								yAxis.push(data[i].value);

							};
							ksoption.series[0].data = convertData(data);
							ksoption.title.text = date + "市区卡口总流量统计图";
							var myChart = echarts.init(document
									.getElementById('echart'));
							myChart.setOption(ksoption, true);
						}, "json");
		            }else{
		                alert("没有所选日期的数据！");
		            }
				return false;
			});
			
		}
		
		//生成柱状统计图
		function zztView() {
			$('#zzt').window({
				width : 600,
				height : 400,
				modal : true,
				title : "柱状统计图"
			});

			var dom = document.getElementById("zztChart");
			var myChart = echarts.init(dom);
			zztoption.xAxis[0].data = xAxis;
			zztoption.series[0].data = yAxis;
			myChart.setOption(zztoption, true);
		}

		function od(table){
			var url="${ctp}/od";
			var date=$("#ODdate").datebox('getValue');
            if(date=='2016-5-1'|date=='2016-5-2'|date=='2016-5-3'|date=='2016-5-4'){
            	
            	var begin=$("#odbegintime").val();
                var end=$("#odendtime").val();
                var args={"table":table,"date":date,"begin":begin,"end":end};
               
               
                if(begin==""||end==""){
                    alert("请输入查询时间！");
                }else{
                	console.log(args);
                	$.post(url, args, function(data) {
            			console.log(data);
            			 if(table=="dll"){
            					odoption.series[0].data=dllPoint;
            				}else{
            					odoption.series[0].data=xhwPoint;
            				}
            			
            			odoption.series[1].data=initData(data)
            			var myChart = echarts.init(document.getElementById('echart'));
            			myChart.setOption(odoption, true); 
            		}, "json");
                }
            }else{
            	 alert("没有所选日期的数据！");
            }
            return false;
		}
		
		//旅游分析
		function travel(){
   				var data;
   				var date=$("#dd").datebox('getValue');
   				if(date=='2016-5-1'|date=='2016-5-2'|date=='2016-5-3'|date=='2016-5-2'){
   				 for(var i=0;i<travelData.length;i++){
	                  if(date==travelData[i].date){
	                      data=travelData[i].data;
	                  }
	              }
	              pieOption.title.subtext=date;
	              pieOption.series[0].data=data;

	              $('#pie').window({
	                  width : 550,
	                  height : 550,
	                  modal : true,
	                  title : "扇形图"
	              });

	              var myChart = echarts.init(document.getElementById('pieChart'));

	              myChart.setOption(pieOption, true);
   				}else{
   				 alert("没有所选日期的数据！");
   				}
		}
		//一周的旅游分析
		function allTravel(){
				  $('#all').window({
	                  width : 800,
	                  height : 650,
	                  modal : true,
	                  title : "黄金周旅游分析统计柱状图"
	              });
				  var myChart = echarts.init(document.getElementById('allChart'));
	              myChart.setOption(alloption, true);     
		}
			
		//车辆轨迹追踪
		function traceQuery(){
			$("#tracequery").click(function() {
				var lineData = [];
				var pointMarker = [];
				var myIcon = new BMap.Icon("${ctp}/static/img/cctv.png",new BMap.Size(25, 25));
				var symbol = 'image://${ctp}/static/img/slune.png';

				var url = $(this).attr("href");
				var reg = /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;//车牌号规则验证正则
				var hphm = $("#hphm").val();
				var date = $("#tracedate").val();
				var begin = $("#begintime").val();
				var end = $("#endtime").val()
				console.log(date);
				if (!reg.test(hphm)) {
							alert("车牌号非法,请重新输入！");
							return false;
					} else 
					{
						var args = {"hphm" : hphm,"date" : date,"begin" : begin,"end" : end};
							$.post(url,args,function(data) {
								console.log(data);
								initDataTrace(data,lineData,pointMarker,myIcon);

								traceoption.series[0].data[0].coords = lineData;
								traceoption.series[0].effect.symbol = symbol;
								// 基于准备好的dom，初始化echarts实例
							var myChart = echarts.init(document.getElementById('echart'));
							myChart.setOption(traceoption);
							// 获取百度地图实例，使用百度地图自带的控件
							var bmap = myChart.getModel().getComponent('bmap').getBMap();
							bmap.addControl(new BMap.MapTypeControl());
							for (var i = 0; i < pointMarker.length; i++) {
									bmap.addOverlay(pointMarker[i]);
							}}, 
							"json");
									return false;
								};
							});
		}
		
		//热力图的显示
		function hotmap(){
			var date=$("#dd").datebox('getValue');
			
			var url = $("#hotmap").attr("href");
			var begin=$("#htbegintime").val();
            var end=$("#htendtime").val();
            
            if(date=='2016-5-1'|date=='2016-5-2'|date=='2016-5-3'|date=='2016-5-2'){
            	 var args={"date":date,"begin":begin,"end":end};
            	 console.log(args);
            	 console.log(url);
                 $.post(url,args,function(data){
                 	console.log(data);
                 },"json");
            }else{
            	alert("没有所选日期的数据！");
            }
            return false;
		}
		
		function initDataTrace(data, lineData, pointMarker, myIcon) {
			var trail = data.trail;
			for (var i = 0; i < trail.length; i++) {
				// 整理echartsline数据
				var p = [ trail[i].kakou.lon, trail[i].kakou.lat ];
				lineData.push(p);
				// 实例化百度地图的点坐标
				var label = new BMap.Label(trail[i].time + "通过" + trail[i].kakou.name,
						{
							offset : new BMap.Size(-20, -20)
						});
				var point = new BMap.Point(trail[i].kakou.lon, trail[i].kakou.lat);
				var marker = new BMap.Marker(point, {
					icon : myIcon
				});
				marker.setLabel(label);
				pointMarker.push(marker);
			}
		}
		
	</script>

</body>
</html>

