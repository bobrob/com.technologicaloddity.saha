
function applyAjaxResults(resultMap) {	
	var javascriptAfterRender = null;
	if(resultMap && resultMap['javascriptAfterRender']) {
		javascriptAfterRender = resultMap['javascriptAfterRender'];
		delete resultMap['javascriptAfterRender'];
	}
	$.each(resultMap, function(key,value) {
		if($('#'+key).is('*')) {
			$('#'+key).html(value);
		}
	});
	if(javascriptAfterRender) {
		eval(javascriptAfterRender);
	}
}