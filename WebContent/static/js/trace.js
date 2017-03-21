

var traceoption = {
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
		type : 'lines',
		coordinateSystem : 'bmap',
		zlevel : 1,
		polyline : true,
		data : [ {
			coords : []
		} ],
		// 线上面的动态特效
		effect : {
			show : true,
			period : 6, // 特效动画时间
			trailLength : 0,// 尾巴长度，0-1
			color : '#f00',
			symbol : '',
			symbolSize : 70
		},
		lineStyle : {
			normal : {
				width : 0,
				type : 'dotted',
				color : '#a6c84c',
				curveness : 0.3
			}
		}
	} ]
};
