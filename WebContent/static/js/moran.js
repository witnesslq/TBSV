var weekMoranoption = {
        color: ['#3398DB'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : [],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'全局Moran`s I指数',
                type:'bar',
                barWidth: '45%',
                data:[]
            }
        ]
    };


    function weekMoanValue(obj,x,y){
        var names="";
        for(var name in obj){
            x.push(name);
            y.push(obj[name]);
        }

    }
    
    function parseMoranData(data,legend,series,value){
        for(var i=0;i<data.length;i++){
            legend.push(data[i].road);
            series.push(
            {
                name:data[i].road,
                        type:'bar',
                    data:display(data[i].ref),
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

            )

        }

        value=displayValue(data[0].ref);
        return false;
    }

    function displayValue(obj){
        var value=[];
        var names="";
        for(var name in obj){
            value.push(name.slice(11,19));
        }
        return value;
    }

    function display(obj){
        var data=[];
        var names="";
        for(var name in obj){
            data.push(obj[name]);
        }
        return data;
    }
    
  var  jbmoranoption = {

            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:[]
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
            series : [ ]
        };