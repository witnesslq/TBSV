function initData(data) {
          var finalData=[];
          for(var i=0;i<data.length;i++){
              var trail=data[i].trail;
              var lineData=[];
              for(var j=0;j<trail.length;j++){
                  //整理echartsline数据
                  var p=[trail[j].kakou.lon,trail[j].kakou.lat];
                  lineData.push(p);

              }
              finalData.push({ coords: lineData});
          }
          return finalData;
      }

      var odoption = {
          backgroundColor: '#404a59',
          title: {
              text: 'OD分析效果图',
              left: 'center',
              textStyle: {
                  color: '#c0c0c0'
              }
          },
          bmap: {
              // 百度地图中心经纬度
              center: [121.616058, 38.940209],
              // 百度地图缩放
              zoom: 14,
              // 是否开启拖拽缩放，可以只设置 'scale' 或者 'move'
              roam: true,
              // 百度地图的自定义样式，见 http://developer.baidu.com/map/jsdevelop-11.htm
              mapStyle: blackMapStyle
          },
          series: [
              {
                  name: '地点',
                  type: 'effectScatter',
                  coordinateSystem: 'bmap',
                  zlevel: 2,
                  rippleEffect: {
                      brushType: 'stroke'
                  },
                  label: {
                      emphasis: {
                          show: true,
                          position: 'right',
                          formatter: '{b}'
                      }
                  },
                  symbolSize: 5,
                  showEffectOn: 'render',
                  itemStyle: {
                      normal: {
                          color: '#ff0000'
                      }
                  },
                  data: []
              },
              {
                  name: '线路',
                  type: 'lines',
                  coordinateSystem: 'bmap',
                  zlevel: 2,
                  large: true,
                  effect: {
                      show: true,
                      constantSpeed: 30,
                      symbol: 'pin',
                      symbolSize: 8.5,
                      trailLength: 0
                  },
                  lineStyle: {

                      normal: {
                          color:'rgba(253, 244, 27, 0.5)',
//                          color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
//                              {
//                                  offset: 0, color: 'rgba(255, 215, 0, 0.5)'
//                              },
//                              {
//                                  offset: 1, color: '#66FF00'
//                              }
//                          ], false),
                          width: 1,
                          opacity: 0.2,
                          curveness: 0.1
                      }
                  },
                  data:[]
              }
          ]
      };