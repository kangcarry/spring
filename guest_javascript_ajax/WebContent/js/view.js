/**
 * 	view.js
 */
 //export를 해야 다른서버에서 import가 가능하다
 export function render(templateId='#guest-main-template',jsonResult={},contentId="#content"){
	let templateHtml = document.querySelector(templateId).innerHTML;
	let bindTemplate = Handlebars.compile(templateHtml);
	let resultTemplate = bindTemplate(jsonResult);
	document.querySelector(contentId).innerHTML =resultTemplate;
}