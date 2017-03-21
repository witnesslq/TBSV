var data1=[
    {value:19, name:'省直属'},
    {value:1363, name:'鞍山市'},
    {value:265, name:'本溪市'},
    {value:75797, name:'大连市'},
    {value:415, name:'锦州市'},
    {value:292, name:'丹东市'},
    {value:1143, name:'营口市'},
    {value:581, name:'辽阳市'},
    {value:191, name:'朝阳市'},
    {value:266, name:'阜新市'},
    {value:153, name:'葫芦岛市'},
    {value:564, name:'盘锦市'},
    {value:3214, name:'沈阳市'},
    {value:6669, name:'外省'},
    {value:345, name:'抚顺市'},
    {value:280, name:'铁岭市'}
];

var data2=[
    {value:6, name:'省直属'},
    {value:705, name:'鞍山市'},
    {value:134, name:'本溪市'},
    {value:52530, name:'大连市'},
    {value:218, name:'锦州市'},
    {value:158, name:'丹东市'},
    {value:527, name:'营口市'},
    {value:238, name:'辽阳市'},
    {value:130, name:'朝阳市'},
    {value:147, name:'阜新市'},
    {value:85, name:'葫芦岛市'},
    {value:250, name:'盘锦市'},
    {value:1600, name:'沈阳市'},
    {value:4635, name:'外省'},
    {value:236, name:'抚顺市'},
    {value:86, name:'铁岭市'}
];

var data3=[
    {value:3, name:'省直属'},
    {value:153, name:'鞍山市'},
    {value:112, name:'本溪市'},
    {value:32774, name:'大连市'},
    {value:71, name:'锦州市'},
    {value:56, name:'丹东市'},
    {value:137, name:'营口市'},
    {value:52, name:'辽阳市'},
    {value:29, name:'朝阳市'},
    {value:45, name:'阜新市'},
    {value:32, name:'葫芦岛市'},
    {value:47, name:'盘锦市'},
    {value:450, name:'沈阳市'},
    {value:7367, name:'外省'},
    {value:112, name:'抚顺市'},
    {value:57, name:'铁岭市'}
];

var data4=[
    {value:14, name:'省直属'},
    {value:279, name:'鞍山市'},
    {value:122, name:'本溪市'},
    {value:64448, name:'大连市'},
    {value:111, name:'锦州市'},
    {value:115, name:'丹东市'},
    {value:213, name:'营口市'},
    {value:98, name:'辽阳市'},
    {value:77, name:'朝阳市'},
    {value:94, name:'阜新市'},
    {value:38, name:'葫芦岛市'},
    {value:107, name:'盘锦市'},
    {value:758, name:'沈阳市'},
    {value:7344, name:'外省'},
    {value:160, name:'抚顺市'},
    {value:79, name:'铁岭市'}
];

var data4=[
    {value:14, name:'省直属'},
    {value:279, name:'鞍山市'},
    {value:122, name:'本溪市'},
    {value:64448, name:'大连市'},
    {value:111, name:'锦州市'},
    {value:115, name:'丹东市'},
    {value:213, name:'营口市'},
    {value:98, name:'辽阳市'},
    {value:77, name:'朝阳市'},
    {value:94, name:'阜新市'},
    {value:38, name:'葫芦岛市'},
    {value:107, name:'盘锦市'},
    {value:758, name:'沈阳市'},
    {value:7344, name:'外省'},
    {value:160, name:'抚顺市'},
    {value:79, name:'铁岭市'}
];

var data5=[
    {value:6, name:'省直属'},
    {value:126, name:'鞍山市'},
    {value:36, name:'本溪市'},
    {value:33450, name:'大连市'},
    {value:55, name:'锦州市'},
    {value:44, name:'丹东市'},
    {value:117, name:'营口市'},
    {value:36, name:'辽阳市'},
    {value:31, name:'朝阳市'},
    {value:48, name:'阜新市'},
    {value:11, name:'葫芦岛市'},
    {value:42, name:'盘锦市'},
    {value:357, name:'沈阳市'},
    {value:1779, name:'外省'},
    {value:69, name:'抚顺市'},
    {value:36, name:'铁岭市'}
];
var travelData=[{"date":"2016-5-1","data":data1},
    {"date":"2016-5-2","data":data2},
    {"date":"2016-5-3","data":data3},
    {"date":"2016-5-4","data":data4},
    {"date":"2016-5-5","data":data5}];

var pieOption = {
    title : {
        text: '旅游分析南丁格尔玫瑰图',
        subtext: '',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },

    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true,
                type: ['pie', 'funnel']
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    legend: {
        x : 'center',
        y : 'bottom',
        data:['省直属','鞍山市','本溪市','大连市','锦州市', '丹东市', '营口市', '辽阳市', '朝阳市', '阜新市', '葫芦岛市','盘锦市', '沈阳市', '外省', '抚顺市', '铁岭市']
    },
    calculable : true,
    series : [

        {
            name:'面积模式',
            type:'pie',
            radius : [15, 130],
            center : ['50%', '50%'],
            roseType : 'area',
            data:[

            ]
        }
    ]
};

var alloption = {
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    legend: {
        data:['省直属','鞍山市','本溪市','大连市','锦州市', '丹东市', '营口市', '辽阳市', '朝阳市', '阜新市', '葫芦岛市','盘锦市', '沈阳市', '外省', '抚顺市', '铁岭市']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis:  {
        type: 'value'
    },
    yAxis: {
        type: 'category',
        data: ['2016-5-1','2016-5-2','2016-5-3','2016-5-4','2016-5-5']
    },
    series: [
        {
            name: '省直属',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [19, 6, 3, 14, 6]
        },
        {
            name: '鞍山市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [1363, 705, 153, 279, 126]
        },
        {
            name: '本溪市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [265, 134, 112, 122, 36]
        },
        {
            name: '大连市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [75797, 52530, 32774, 64448, 33450]
        },
        {
            name: '锦州市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [415, 218, 71, 111, 55]
        },
        {
            name: '丹东市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [292, 158, 56, 115, 44]
        },
        {
            name: '营口市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [1143, 527, 137, 213, 117]
        },
        {
            name: '辽阳市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [581, 238, 52, 98, 36]
        },
        {
            name: '朝阳市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [191, 130, 29, 77, 31]
        },
        {
            name: '阜新市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [266, 147, 45, 94, 48]
        },
        {
            name: '葫芦岛市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [153, 85, 32, 38, 11]
        },
        {
            name: '盘锦市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [564, 250, 47, 107, 42]
        },
        {
            name: '沈阳市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [3214, 1600, 450, 758, 357]
        },
        {
            name: '外省',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [6669, 4635, 7367, 7344, 1779]
        },
        {
            name: '铁岭市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [280, 86, 57, 79, 36]
        },
        {
            name: '抚顺市',
            type: 'bar',
            stack: '车流量',
            label: {
                normal: {
                    show: true,
                    position: 'insideRight'
                }
            },
            data: [345, 236, 112, 160, 69]
        }
    ]
};