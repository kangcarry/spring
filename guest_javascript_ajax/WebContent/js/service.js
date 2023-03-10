/**
 * 
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