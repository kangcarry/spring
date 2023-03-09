function ajaxRequest(method,url,params,callbackFunction){
	let xhr=new XMLHttpRequest(); 	//request초기화
	method = (method) ? method:'GET';	//"GET,POST로 초기화"
	method = (method!='GET'&& method!='POST')?'GET':method;
	params = (params)? params:null;	
	url = (method=='GET'&& params!=null) ? url+"?"+params : url; 
	
	xhr.open(method,url,true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.onload=function(){
		callbackFunction(xhr);
	};
	xhr.send((method=='POST')?params:null);
}
