function addStyleSheet() {
	
	
	var browser = navigator.userAgent.toLowerCase();
	if(browser.indexOf('firefox') > -1) {
		var newStylesheet = $("<link />", {
			rel: "stylesheet",
			href: "css/estiloAlt.css"
		});
		$('head').append(newStylesheet);
	}
					
}

