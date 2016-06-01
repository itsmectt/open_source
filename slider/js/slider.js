// JavaScript Document
//1.数据定义
var data =[
		 {img: 1 , h1:'Creative', h2:'DUET'},
		 {img: 2 , h1:'Friendly', h2:'DEVIL'},
		 {img: 3 , h1:'Tuauiviv', h2: 'COMPATROIT'},
		 {img: 4 , h1:'Thjcghcjh',h2:'HUSSLER'},
		 {img: 5 , h1:'Vggqof',h2:'REBEL'},
		 {img: 6 , h1:'Beautiful',h2:'SEEKER'},
		 {img: 7 , h1:'Crazy',h2:'FRIEND'}
];

//2.通用函数
var g = function (id){
	if( id.substr(0,1) == '.' ){
		return document.getElementsByClassName(id.substr(1));
		}
	return document.getElementById(id);
	}
	
//3.添加幻灯片&按钮样式
function addSliders(){
	//3.1 获取模版
	var tpl_main=g('template_main').innerHTML.replace(/^\s*/,'') .replace(/\s*$/,'');
	var tpl_ctrlbar=g('template_ctrlbar').innerHTML.replace(/^\s*/,'') .replace(/\s*$/,'');
	//3.2 定义最终输出html的变量
	var out_main = [];
	var out_ctrl = [];
	//3.3 遍历所有数据
	for( i in data){
		var _html_main=tpl_main.replace(/{{index}}/g,data[i].img)
								 .replace(/{{h2}}/g,data[i].h1)
								 .replace(/{{h3}}/g,data[i].h2);
		var _html_ctrl=tpl_ctrlbar.replace(/{{index}}/g,data[i].img);
		out_main.push(_html_main);
		out_ctrl.push(_html_ctrl);
		}
	//3.4 把html回写到对应的dom里面
		g('template_main').innerHTML = out_main.join('');
		g('template_ctrlbar').innerHTML = out_ctrl.join('');
		
	//7 增加＃main_background
		g('template_main').innerHTML +=tpl_main.replace(/{{index}}/g,'{{index}}')
								 .replace(/{{h2}}/g,data[i].h1)
								 .replace(/{{h3}}/g,data[i].h2);
		g('main_{{index}}').id = 'main_background';
	}
	
//4.定义何时处理幻灯片的输出
	window.onload = function(){
	addSliders();
	switchSlider(2);
	setTimeout(function(){
		movePic();
		},100)
	}
//5.幻灯片的转换
function switchSlider(n){
	var main = g('main_'+n);
	var ctrl = g('ctrl_'+n);
	
	var clear_main= g('.main-ppt');
	var clear_ctrl= g('.ctrl-btn');
	//清除active样式
	for(i=0;i < clear_ctrl.length;i++){
		clear_ctrl[i].className = clear_ctrl[i].className.replace(' ctrl-btn_active','');
		clear_main[i].className = clear_main[i].className.replace(' main-ppt_active','');
		}
	//添加当前样式
	main.className +=' main-ppt_active';
	ctrl.className +=' ctrl-btn_active';
	
	//7.2 切换时复制上一张ppt
	setTimeout(function(){
		g('main_background').innerHTML = main.innerHTML;
		},1000)	
	}
	
	//6.动态调整图片的margin－top，是图片垂直居中
	function movePic(){
		var pic = g('.picture');
		for(i=0;i<pic.length;i++){
			pic[i].style.marginTop = (-1 * pic[i].clientHeight/2) + 'px';
			}
		}