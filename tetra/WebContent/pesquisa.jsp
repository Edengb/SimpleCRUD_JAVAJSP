<!DOCTYPE html>
<html>
	<head>
		<title>Treta Soft - Pesquisa</title>
		<meta charset="UTF-8"/>
		<link rel="stylesheet" href="css/simplesReset.css"/>
		<link rel="stylesheet" href="css/estilo.css"/>
		<link rel="stylesheet" href="css/pesquisa.css"/>
		<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
		<script type="text/javascript" src="js/pesquisaPorPalavras.js"></script>
		<script type="text/javascript" src="js/addStyleSheet.js"></script>
		<script type="text/javascript">
			window.onload = function() {
				addStyleSheet();
			}
		
		</script>
	<head>
	<body>
		<header>
			<h1 class="logo"><img src="img/logo.png" alt="TretaSoft" /></h1>
			<h1><i>SISTEMA DEMONSTRAÇÃO</i></h1>
		</header>
		<div>
			<nav class="menu-opcoes">
				<ul>
					<li>MENU</li>
					<li><a href="cadastro.jsp">CADASTRO</a></li>
					<li><a href="#">PESQUISA</a></li>
				</ul>
			</nav>
		</div>
		<div class="container">
			<div class="pesquisa">
				<h2><span class="first-letter">P</span>ESQUISA DE <span class="first-letter">C</span>LIENTES</h2>
				<form>
					  <div class="Divlabel">
					  	<label  class="labelfiltro">Filtro por Nome:</label>
					  	<br />
					  	<label  class="labelfiltro">Filtro por E-mail:</label>
					  </div>
					  <div class="Divinput">
					  	<input class="inputPesquisa" type="text" id="inputNome" onkeyup="pesquisarNome()"/>
					  	<br />
					  	<input class="inputPesquisa" type="text" id="inputEmail" onkeyup="pesquisarEmail()" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" />
					  </div>
				</form>
			</div>
			<div class="resultado" id="resultado">
				<h3 class="teste">RESULTADOS</h3>                                       

<script type="text/javascript">
    function getJsonData()
    {
 
      var table="<html><table id='myTable' border=\'1px\'>";
 	
      table=table+"<tr ><th> Nome </th><th> Email </th><th> Telefone </th><th> Ações </th></tr>";
 
      $.ajax({
 
            type: "GET",
                        url: "/tetra/ServletClienteJSON",
                        dataType: 'json',
                        success : function(json) {
 
                            var info1=json.JSonDataFinal;
 
                          $.each(info1, function(index, element) {
                              var info = element.JsonData;
 							  
                              table=table+"<tr>";
 	
                                  $.each(info, function(index, element) {
                                	  
                                      table=table+"<td>" + element.nome +"</td><td>"
                                      + element.email +"</td><td>" + element.telefone +"</td><td><a href='"
                                      + "cadastro.jsp?status=editar&id=" + element.id + "&nome=" + 
                                      element.nome + "&email=" + element.email + "&endereco=" + element.endereco + "&telefone=" 
                                      + element.telefone + "&sexo=" + element.sexo + "&newsletter=" + element.newsletter 
                                   	   + "&salvar=salvar'>edita</a></td>";
                                    });
                                  table=table+"</tr>";
 
                          });
                          table=table+="</table></html>";
 
                          $("#resultado").append(table);
                        },
                        async: false,
                        global: false,
                        error: function () {
                           alert("Errr is occured");
                        }
                    });
      
}
    getJsonData();
</script>
	</div>
	</body>
</html>
