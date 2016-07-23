
var devices = ['ipad', 'iphone', 'midp', 'ucweb', 'android', 'windows ce', 'windows mobile'];
var userAgent = navigator.userAgent.toLowerCase();
var header = $('.form_header').get(0);
var isMobile;

//isMobile:是否移动设备
for( var i=0; i<devices.length; i++ ){
	if( userAgent.indexOf(devices[i]) != -1 ){
		isMobile = true;
	}
}

var MyDatePickerUtils = {
	//日期对象格式化工具：yyyy-MM-dd	
	getFormatDate : function(givenDate) {
		var day = givenDate;
		var Year = 0;
		var Month = 0;
		var Day = 0;
		var CurrentDate = "";
		// 初始化时间
		// Year= day.getYear();//有火狐下2008年显示108的bug
		Year = day.getFullYear();// ie火狐下都可以
		Month = day.getMonth() + 1;
		Day = day.getDate();
		// Hour = day.getHours();
		// Minute = day.getMinutes();
		// Second = day.getSeconds();
		CurrentDate += Year + "-";
		if (Month >= 10) {
			CurrentDate += Month + "-";
		} else {
			CurrentDate += "0" + Month + "-";
		}
		if (Day >= 10) {
			CurrentDate += Day;
		} else {
			CurrentDate += "0" + Day;
		}
		return CurrentDate;
	}
}

$('.form_header').click(function(ev){
	if(ev.target != $('.chooseDate').get(0)){
		hideDate();
	}
});
$('.form_main').click(function(ev){
	hideDate();
});

function hideDate(){
	$('#laydate_box').css('display', 'none');
}

$('.chooseDate').click(function() {
//	var _this = $('.theDate');
	if($('#laydate_box').css('display') == 'block'){
		$('#laydate_box').css('display', 'none');
	}else{
		$('#laydate_box').css('display', 'block');
	}
	laydate({
		istime : true,
		format : 'YYYY-MM-DD',
		choose : function(datas) {
//			_this.html(datas.substr(5));
			var currDay = MyDatePickerUtils.getFormatDate(new Date());
			if(datas <= currDay) {
				//屏蔽undefined对静态页的影响
//				var conditionCode = "";
//				if(page.conditionCode) {
//					conditionCode = page.conditionCode;
//				}
				window.location = page.basePath + page.reportLink
						+ "&reportDate=" + datas
						+ "&from_entity=" + page.from_entity
						+ "&outputMode=" + page.outputMode
						+ "&conditionCode=" + page.conditionCode
						+ "&city=" + page.city
						+"&date="+new Date();
			} else {
				alert("请选择正确的报表日期");
			}
		}
	});
});



	
	
	
	
	
	
	
	
	
	
	