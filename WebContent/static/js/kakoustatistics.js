 //转换数据
var convertData = function (data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
            var geoCoord = geoCoordMap[data[i].name];
            if (geoCoord) {
                res.push({
                    name: data[i].name,
                    value: geoCoord.concat(data[i].value)
                });
            }
        }
        console.log(res);
        return res;

    };
    var mydata=[];
    //百度地图坐标的散点图
    var ksoption = {
            backgroundColor: '#404a59',
            title: {
                text: '',
                subtext: '',
                sublink: '',
                x: 'center',
                textStyle: {
                    color: '#fff'
                }
            },
            tooltip: {
                trigger: 'item',
                formatter: function (params) {
                    return params.name + ' : ' + params.value[2];
                }
            },
            legend: {
                orient: 'vertical',
                y: 'bottom',
                x: 'right',
                data: ['traffic'],
                textStyle: {
                    color: '#fff'
                }
            },
            visualMap: {
                min: 0,
                max: 60000,
                calculable: true,
                inRange: {
                    color: ['#50a3ba', '#eac736', '#d94e5d']
                },
                textStyle: {
                    color: '#fff'
                }
            },
            // 加载 bmap 组件
            bmap: {
                // 百度地图中心经纬度
                center: [121.616058, 38.940209],
                // 百度地图缩放
                zoom: 14,
                // 是否开启拖拽缩放，可以只设置 'scale' 或者 'move'
                roam: true,
                // 百度地图的自定义样式，见 http://developer.baidu.com/map/jsdevelop-11.htm
                mapStyle:blackMapStyle
            },

            series: [
                {
                    name: 'traffic',
                    type: 'scatter',
                    coordinateSystem: 'bmap',
                    data: [],
                    symbolSize: 15,
                    label: {
                        normal: {
                            show: false
                        },
                        emphasis: {
                            show: false
                        }
                    },
                    itemStyle: {
                        emphasis: {
                            borderColor: '#fff',
                            borderWidth: 1
                        }
                    }
                }
            ]
        };
    
    //柱状图相关
    zztoption = {
    	    title : {
    	        text: '市区卡口总流量统计图',
    	        subtext: '单位：车次'
    	    },
    	    tooltip : {
    	        trigger: 'axis'
    	    },
    	  
    	    toolbox: {
    	        show : true,
    	        feature : {
    	            dataView : {show: true, readOnly: false},
    	            magicType : {show: true, type: ['line', 'bar']},
    	            restore : {show: true},
    	            saveAsImage : {show: true}
    	        }
    	    },
    	    calculable : true,
    	    xAxis : [
    	        {
    	            type : 'category',
    	            data : []
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value'
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'总流量',
    	            type:'bar',
    	            data:[],
    	            markPoint : {
    	                data : [
    	                    {type : 'max', name: '最大值'},
    	                    {type : 'min', name: '最小值'}
    	                ]
    	            },
    	            markLine : {
    	                data : [
    	                    {type : 'average', name: '平均值'}
    	                ]
    	            }
    	        }
    	    ]
    	};

    
var data1=[{"name":"东北路-五一广场(北行)","value":36391},{"name":"东快路-黄河街出市","value":11832},{"name":"东快路-疏港路东出市","value":20186},{"name":"东北路--海达广场(南行)","value":57712},{"name":"东快路-工人村入市","value":13102},{"name":"东快路-疏港路西入市","value":13503},{"name":"东联路-华北路入市上桥","value":22815},{"name":"东联路-校园街入市上桥","value":13675},{"name":"东联路-松江路入市上桥","value":14037},{"name":"东联路-西南路入市下桥","value":21002},{"name":"东联路-西安路入市下桥","value":11369},{"name":"东联路-疏港路入市上桥","value":8551},{"name":"东联路-联合路入市下桥","value":27687},{"name":"东联路-联合路出市上桥","value":21903},{"name":"东联路-西南路出市上桥","value":23649},{"name":"东联路-松江路出市下桥","value":10418},{"name":"东联路-校园街出市下桥","value":20148},{"name":"绿标路-中山路-五一路(西)","value":5330},{"name":"绿标路-中山路-联合路(东)","value":30433},{"name":"东联路-中华路(南)入市上桥","value":3937},{"name":"东联路-中华路(南)入市下桥","value":8173},{"name":"东联路-中华路(北)入市上桥","value":3571},{"name":"东联路-中华路(北)入市下桥","value":8985},{"name":"东联路-中华路(南)出市上桥","value":2336},{"name":"东联路-中华路(南)出市下桥","value":4132},{"name":"东联路-中华路(北)出市上桥","value":419},{"name":"东联路-中华路(北)出市下桥","value":4095},{"name":"东北路--海达广场(北行)","value":67882},{"name":"绿标路-会展路-太原街(南)","value":6135},{"name":"绿标路-中山路-大同街(东)","value":33471},{"name":"绿标路-中山路-大同街(西)","value":32907},{"name":"绿标路-会展路-星河街(南)","value":5401},{"name":"绿标路-会展路-会展东路(南)","value":8587},{"name":"绿标路-会展路-会展西路(南)","value":3502},{"name":"绿标路-中山路-会展南路(东)","value":19982},{"name":"绿标路-胜利路-白山路(南)","value":7801},{"name":"西快路-中山路(匝道)(北行)","value":5453},{"name":"西快路-中山路(桥上)(南行)","value":12731},{"name":"西快路-五四路(匝道)(南行)","value":11838},{"name":"西快路-五四路(匝道)(北行)","value":2296},{"name":"西快路-胜利路(南行)","value":19894},{"name":"东北路-五一广场(南行)","value":33785},{"name":"莲花山隧道(WK2+845)","value":12443},{"name":"莲花山隧道(NK0+765)","value":6365},{"name":"莲花山隧道(WK1+767-NK0)","value":4368},{"name":"莲花山隧道（WK0+918）","value":17262},{"name":"莲花山隧道(WK0)","value":17322},{"name":"星海湾大桥BHXLK0+060","value":6172},{"name":"星海湾大桥AK1+009（B15)","value":6165},{"name":"星海湾大桥SK0+940(S20)","value":17229},{"name":"星海湾大桥SK1+737（S39)","value":23360},{"name":"星海湾大桥SK3+613（S63）","value":12344},{"name":"星海湾大桥SK4+537（S84）","value":23374},{"name":"星海湾大桥SK5+890（S122）","value":23385},{"name":"星海湾大桥XK5+871","value":23083},{"name":"星海湾大桥XK4+578（X84）","value":15851},{"name":"星海湾大桥XK3+654（X63）","value":21411},{"name":"星海湾大桥XK1+778（X39)","value":20277},{"name":"星海湾大桥XK0+980(B21）","value":15773},{"name":"星海湾大桥XK0+223(X4)","value":16205},{"name":"星海湾大桥BK0+172(B4)","value":7343},{"name":"莲花山隧道(EK0)","value":16054},{"name":"莲花山隧道(EK0+875)","value":16354},{"name":"莲花山隧道(EK1+775-SK0)","value":16021},{"name":"莲花山隧道(EK2+985)","value":12745},{"name":"莲花山隧道(SK0+780)","value":4828},{"name":"公交-高尔基路-太原街","value":25148},{"name":"公交-高尔基路-白山路","value":1348},{"name":"公交-高尔基路-民运街","value":9315},{"name":"公交-高尔基路-纪念街","value":21121}];
var data2=[{"name":"东北路-五一广场(北行)","value":36579},{"name":"东快路-黄河街出市","value":11123},{"name":"东快路-疏港路东出市","value":19139},{"name":"东北路--海达广场(南行)","value":54878},{"name":"东快路-工人村入市","value":14582},{"name":"东快路-疏港路西入市","value":12699},{"name":"东联路-华北路入市上桥","value":24397},{"name":"东联路-校园街入市上桥","value":12731},{"name":"东联路-松江路入市上桥","value":13593},{"name":"东联路-西南路入市下桥","value":20796},{"name":"东联路-西安路入市下桥","value":11516},{"name":"东联路-疏港路入市上桥","value":8356},{"name":"东联路-联合路入市下桥","value":26834},{"name":"东联路-联合路出市上桥","value":18892},{"name":"东联路-西南路出市上桥","value":22444},{"name":"东联路-松江路出市下桥","value":9803},{"name":"东联路-校园街出市下桥","value":18067},{"name":"绿标路-中山路-五一路(西)","value":4998},{"name":"绿标路-中山路-联合路(东)","value":27569},{"name":"东联路-中华路(南)入市上桥","value":4129},{"name":"东联路-中华路(南)入市下桥","value":8672},{"name":"东联路-中华路(北)入市上桥","value":3502},{"name":"东联路-中华路(北)入市下桥","value":8352},{"name":"东联路-中华路(南)出市上桥","value":2352},{"name":"东联路-中华路(南)出市下桥","value":3802},{"name":"东联路-中华路(北)出市上桥","value":435},{"name":"东联路-中华路(北)出市下桥","value":4133},{"name":"东北路--海达广场(北行)","value":62435},{"name":"绿标路-会展路-太原街(南)","value":4614},{"name":"绿标路-中山路-大同街(东)","value":31912},{"name":"绿标路-中山路-大同街(西)","value":32124},{"name":"绿标路-会展路-星河街(南)","value":3221},{"name":"绿标路-会展路-会展东路(南)","value":6352},{"name":"绿标路-会展路-会展西路(南)","value":2796},{"name":"绿标路-中山路-会展南路(东)","value":14676},{"name":"绿标路-胜利路-白山路(南)","value":6895},{"name":"西快路-中山路(匝道)(北行)","value":4779},{"name":"西快路-中山路(桥上)(南行)","value":11844},{"name":"西快路-五四路(匝道)(南行)","value":8414},{"name":"西快路-五四路(匝道)(北行)","value":1485},{"name":"西快路-胜利路(南行)","value":14330},{"name":"东北路-五一广场(南行)","value":26954},{"name":"莲花山隧道(WK2+845)","value":6928},{"name":"莲花山隧道(NK0+765)","value":3272},{"name":"莲花山隧道(WK1+767-NK0)","value":2433},{"name":"莲花山隧道（WK0+918）","value":11910},{"name":"莲花山隧道(WK0)","value":11907},{"name":"星海湾大桥BHXLK0+060","value":4011},{"name":"星海湾大桥AK1+009（B15)","value":3856},{"name":"星海湾大桥SK0+940(S20)","value":11295},{"name":"星海湾大桥SK1+737（S39)","value":14863},{"name":"星海湾大桥SK3+613（S63）","value":7789},{"name":"星海湾大桥SK4+537（S84）","value":15050},{"name":"星海湾大桥SK5+890（S122）","value":15821},{"name":"星海湾大桥XK5+871","value":14996},{"name":"星海湾大桥XK4+578（X84）","value":8232},{"name":"星海湾大桥XK3+654（X63）","value":14806},{"name":"星海湾大桥XK1+778（X39)","value":8755},{"name":"星海湾大桥XK0+980(B21）","value":6973},{"name":"星海湾大桥XK0+223(X4)","value":11431},{"name":"星海湾大桥BK0+172(B4)","value":3790},{"name":"莲花山隧道(EK0)","value":11191},{"name":"莲花山隧道(EK0+875)","value":11447},{"name":"莲花山隧道(EK1+775-SK0)","value":11318},{"name":"莲花山隧道(EK2+985)","value":9193},{"name":"莲花山隧道(SK0+780)","value":4233},{"name":"公交-高尔基路-太原街","value":23335},{"name":"公交-高尔基路-白山路","value":2114},{"name":"公交-高尔基路-民运街","value":8361},{"name":"公交-高尔基路-纪念街","value":19291}];
var data3=[{"name":"东北路-五一广场(北行)","value":39226},{"name":"东快路-黄河街出市","value":11758},{"name":"东快路-疏港路东出市","value":18806},{"name":"东北路--海达广场(南行)","value":46869},{"name":"东快路-工人村入市","value":10269},{"name":"东快路-疏港路西入市","value":13898},{"name":"东联路-华北路入市上桥","value":16532},{"name":"东联路-校园街入市上桥","value":12659},{"name":"东联路-松江路入市上桥","value":13591},{"name":"东联路-西南路入市下桥","value":15581},{"name":"东联路-西安路入市下桥","value":10754},{"name":"东联路-疏港路入市上桥","value":7417},{"name":"东联路-联合路入市下桥","value":17901},{"name":"东联路-联合路出市上桥","value":21404},{"name":"东联路-西南路出市上桥","value":18486},{"name":"东联路-松江路出市下桥","value":10628},{"name":"东联路-校园街出市下桥","value":16575},{"name":"绿标路-中山路-五一路(西)","value":6240},{"name":"绿标路-中山路-联合路(东)","value":27378},{"name":"东联路-中华路(南)入市上桥","value":4782},{"name":"东联路-中华路(南)入市下桥","value":7240},{"name":"东联路-中华路(北)入市上桥","value":3310},{"name":"东联路-中华路(北)入市下桥","value":7113},{"name":"东联路-中华路(南)出市上桥","value":2755},{"name":"东联路-中华路(南)出市下桥","value":4290},{"name":"东联路-中华路(北)出市上桥","value":642},{"name":"东联路-中华路(北)出市下桥","value":4552},{"name":"东北路--海达广场(北行)","value":57902},{"name":"绿标路-会展路-太原街(南)","value":5119},{"name":"绿标路-中山路-大同街(东)","value":33234},{"name":"绿标路-中山路-大同街(西)","value":30065},{"name":"绿标路-会展路-星河街(南)","value":2883},{"name":"绿标路-会展路-会展东路(南)","value":5036},{"name":"绿标路-会展路-会展西路(南)","value":1907},{"name":"绿标路-中山路-会展南路(东)","value":9729},{"name":"绿标路-胜利路-白山路(南)","value":5045},{"name":"西快路-中山路(匝道)(北行)","value":5806},{"name":"西快路-中山路(桥上)(南行)","value":7975},{"name":"西快路-五四路(匝道)(南行)","value":8471},{"name":"西快路-五四路(匝道)(北行)","value":794},{"name":"西快路-胜利路(南行)","value":8091},{"name":"东北路-五一广场(南行)","value":23132},{"name":"莲花山隧道(WK2+845)","value":4616},{"name":"莲花山隧道(NK0+765)","value":3138},{"name":"莲花山隧道(WK1+767-NK0)","value":1621},{"name":"莲花山隧道（WK0+918）","value":6526},{"name":"莲花山隧道(WK0)","value":7554},{"name":"星海湾大桥BHXLK0+060","value":3112},{"name":"星海湾大桥AK1+009（B15)","value":2808},{"name":"星海湾大桥SK0+940(S20)","value":10461},{"name":"星海湾大桥SK1+737（S39)","value":14800},{"name":"星海湾大桥SK3+613（S63）","value":7007},{"name":"星海湾大桥SK4+537（S84）","value":15521},{"name":"星海湾大桥SK5+890（S122）","value":13761},{"name":"星海湾大桥XK5+871","value":12303},{"name":"星海湾大桥XK4+578（X84）","value":11299},{"name":"星海湾大桥XK3+654（X63）","value":13588},{"name":"星海湾大桥XK1+778（X39)","value":12639},{"name":"星海湾大桥XK0+980(B21）","value":12418},{"name":"星海湾大桥XK0+223(X4)","value":12863},{"name":"星海湾大桥BK0+172(B4)","value":2348},{"name":"莲花山隧道(EK0)","value":10875},{"name":"莲花山隧道(EK0+875)","value":10918},{"name":"莲花山隧道(EK1+775-SK0)","value":9972},{"name":"莲花山隧道(EK2+985)","value":8915},{"name":"莲花山隧道(SK0+780)","value":3869},{"name":"公交-高尔基路-太原街","value":15794},{"name":"公交-高尔基路-白山路","value":741},{"name":"公交-高尔基路-民运街","value":5497},{"name":"公交-高尔基路-纪念街","value":15227}];
var data4=[{"name":"东北路-五一广场(北行)","value":36071},{"name":"东快路-黄河街出市","value":14257},{"name":"东快路-疏港路东出市","value":23262},{"name":"东北路--海达广场(南行)","value":59234},{"name":"东快路-工人村入市","value":12899},{"name":"东快路-疏港路西入市","value":17687},{"name":"东联路-华北路入市上桥","value":25351},{"name":"东联路-校园街入市上桥","value":16417},{"name":"东联路-松江路入市上桥","value":17251},{"name":"东联路-西南路入市下桥","value":20230},{"name":"东联路-西安路入市下桥","value":15225},{"name":"东联路-疏港路入市上桥","value":9605},{"name":"东联路-联合路入市下桥","value":33628},{"name":"东联路-联合路出市上桥","value":25530},{"name":"东联路-西南路出市上桥","value":23740},{"name":"东联路-松江路出市下桥","value":12633},{"name":"东联路-校园街出市下桥","value":21476},{"name":"绿标路-中山路-五一路(西)","value":7761},{"name":"绿标路-中山路-联合路(东)","value":33627},{"name":"东联路-中华路(南)入市上桥","value":5851},{"name":"东联路-中华路(南)入市下桥","value":9572},{"name":"东联路-中华路(北)入市上桥","value":4347},{"name":"东联路-中华路(北)入市下桥","value":9383},{"name":"东联路-中华路(南)出市上桥","value":3179},{"name":"东联路-中华路(南)出市下桥","value":5346},{"name":"东联路-中华路(北)出市上桥","value":719},{"name":"东联路-中华路(北)出市下桥","value":5116},{"name":"东北路--海达广场(北行)","value":76061},{"name":"绿标路-会展路-太原街(南)","value":7403},{"name":"绿标路-中山路-大同街(东)","value":36960},{"name":"绿标路-中山路-大同街(西)","value":38586},{"name":"绿标路-会展路-星河街(南)","value":3590},{"name":"绿标路-会展路-会展东路(南)","value":7379},{"name":"绿标路-会展路-会展西路(南)","value":3894},{"name":"绿标路-中山路-会展南路(东)","value":15474},{"name":"绿标路-胜利路-白山路(南)","value":8359},{"name":"西快路-中山路(匝道)(北行)","value":6342},{"name":"西快路-中山路(桥上)(南行)","value":15189},{"name":"西快路-五四路(匝道)(南行)","value":12597},{"name":"西快路-五四路(匝道)(北行)","value":1973},{"name":"西快路-胜利路(南行)","value":21525},{"name":"东北路-五一广场(南行)","value":36655},{"name":"莲花山隧道(WK2+845)","value":10201},{"name":"莲花山隧道(NK0+765)","value":4703},{"name":"莲花山隧道(WK1+767-NK0)","value":3182},{"name":"莲花山隧道（WK0+918）","value":14415},{"name":"莲花山隧道(WK0)","value":14473},{"name":"星海湾大桥BHXLK0+060","value":4948},{"name":"星海湾大桥AK1+009（B15)","value":4933},{"name":"星海湾大桥SK0+940(S20)","value":14236},{"name":"星海湾大桥SK1+737（S39)","value":18586},{"name":"星海湾大桥SK3+613（S63）","value":10063},{"name":"星海湾大桥SK4+537（S84）","value":19096},{"name":"星海湾大桥SK5+890（S122）","value":18989},{"name":"星海湾大桥XK5+871","value":19164},{"name":"星海湾大桥XK4+578（X84）","value":15402},{"name":"星海湾大桥XK3+654（X63）","value":17839},{"name":"星海湾大桥XK1+778（X39)","value":19187},{"name":"星海湾大桥XK0+980(B21）","value":19110},{"name":"星海湾大桥XK0+223(X4)","value":14685},{"name":"星海湾大桥BK0+172(B4)","value":4509},{"name":"莲花山隧道(EK0)","value":14754},{"name":"莲花山隧道(EK0+875)","value":14950},{"name":"莲花山隧道(EK1+775-SK0)","value":12879},{"name":"莲花山隧道(EK2+985)","value":12062},{"name":"莲花山隧道(SK0+780)","value":3558},{"name":"公交-高尔基路-太原街","value":25170},{"name":"公交-高尔基路-白山路","value":2074},{"name":"公交-高尔基路-民运街","value":10601},{"name":"公交-高尔基路-纪念街","value":22250}];

var tjData=[{"date":"2016-5-1","data":data1},
            {"date":"2016-5-2","data":data2},
            {"date":"2016-5-3","data":data3},
            {"date":"2016-5-4","data":data4}];