function preencher(window) {
	var url_string = window.location.href;
	var url = new URL(url_string);

	var nome = url.searchParams.get("nome");
	var inputNome = document.getElementById("nome");
	inputNome.setAttribute("value", nome);
	var email = url.searchParams.get("email");
	var inputEmail = document.getElementById("email");
	inputEmail.setAttribute("value", email);

	var endereco = url.searchParams.get("endereco");
	var inputEndereco = document.getElementById("endereco");
	inputEndereco.setAttribute("value", endereco);

	var telefone = url.searchParams.get("telefone");
	var inputTelefone = document.getElementById("telefone");
	inputTelefone.setAttribute("value", telefone);

	var sexo = url.searchParams.get("sexo");

	if(sexo == "M") {
		document.getElementById("m").checked = true;
	} else {
		document.getElementById("f").checked = true;
	}

	var newsletter = url.searchParams.get("newsletter");
	var inputNewsLetter = document.getElementById("newsletter");

	if(newsletter == null || newsletter == "false") {
		console.log("caiu falso ou null");
		inputNewsLetter.checked = false;
	} else {
		console.log("caiu true");
		inputNewsLetter.setAttribute("checked", "checked");
	}	
}

