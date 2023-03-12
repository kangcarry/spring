/**
 * 이 함수를 호출하면 AJAX 요청을 보내고, 요청이 완료되면 받아온 JSON 데이터를 반환합니다.
 */
 import {ajaxRequest} from './request.js'; 
 
 function guestService(method,url,params){
	let returnJsonResult={};
	ajaxRequest(method,
				url,
				function(jsonResult){
					returnJsonResult=jsonResult;
				},
				params,
				false);
	//ajax요청
	
	return returnJsonResult;	
}

export{guestService}