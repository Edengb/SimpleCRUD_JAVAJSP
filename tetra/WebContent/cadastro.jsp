
<! document html>

<%@page import="br.com.tetra.model.*"%>
<%@page import="br.com.tetra.DAO.*"%>
<%@page import="br.com.tetra.JSON.*"%>
<%@	page import="java.util.*"%>
<html>
	<head>
		<title>Treta Soft - Cadastro</title>
		<meta charset="UTF-8"/>
		<link rel="stylesheet" href="css/simplesReset.css"/>
		<link rel="stylesheet" href="css/estilo.css"/>
		<script type="text/javascript" src="js/preencherCampos.js"></script>
		<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
		<script type="text/javascript" src="js/addStyleSheet.js"></script>
		<script type="text/javascript">
			window.onload = function() {
				console.log("Primeiro Script");
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
					<li><a href="pesquisa.jsp">PESQUISA</a></li>
				</ul>
			</nav>
		</div>

		<div class="container">
			<h2><span class="first-letter">C</span>ADASTRO DE <span class="first-letter">C</span>LIENTES</h2>
			<form action="cadastro.jsp">
				  <input type="hidden" name="status" id="status" value="cadastrar" />
				   <input type="hidden" name="id" id="id"  />
				  <div class="divLabel">
				  	<label>Nome:</label><br/>
				  	<label>E-mail:</label><br/>
				  	<label>Endereço: </label><br/>
				  	<label>Telefone:</label><br/>
				  	<label>Sexo:</label><br/>
				  	<label>Newsletters: </label>
				  </div>
				  <div class="divInput">
				  	<input type="text" id="nome" name="nome" required/>
				  	<br/>
				  	<input type="text" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required/>
				  	<br/>
				  	<input type="text" id="endereco" name="endereco" />
   				 	<br/>	
   				 	<input type="text" id="telefone" name="telefone" placeholder="(99) 9999-9999" title="Numero de telefone invalido!"  pattern="[0-9]{2}[0-9]{4}[0-9]{4}" /> 
				  	<br/>
				  	<input type="radio" id="m" name="sexo" value="M" checked> masculino
				  	<input type="radio" id="f" name="sexo" value="F"> feminino
				 	<br/>
				 	<input type="checkbox" id="newsletter" name="newsletter" value="true"> sim 
				  </div>								 				  
				  <input type="submit" name="salvar" value="salvar" />
			</form>
		</div>
			<%	
		if (request.getParameter("status") == null) {
			// Faça nada
		} else if(request.getParameter("status").equals("cadastrar")) {
			
	    	String nome = request.getParameter("nome");
	    	String email = request.getParameter("email");
	    	String endereco = request.getParameter("endereco");
	    	String telefone = request.getParameter("telefone");
	    	char sexo = request.getParameter("sexo").charAt(0);
	    	boolean newsletter;
	    	if(request.getParameter("newsletter") == null || request.getParameter("newsletter").equals("false")) {
	    		newsletter = false;
	    	} else {
	    		newsletter = true;
	    	}
	    	
	    	Cliente cliente = new Cliente(nome, email, endereco, telefone, sexo, newsletter);
	    	ClienteDAO clienteDAO = new ClienteDAO();
	     	
	    	if (!clienteDAO.persistir(cliente)) {
	     	%>
			<script>
				window.onload = function() {
					addStyleSheet();
					preencher(window);
					alert("Esse email já possui cadastro!");
				}
			</script>
	     	<% 
	     	} else {
// 	     		%>
					<script>
						alert("Cadastrado com sucesso!");
					</script>
				<% 

	     	}
		} else if(request.getParameter("status").equals("editar")) {
			%>
			<script>
				window.onload = function() {
					addStyleSheet();
					preencher(window);
					alert("Modo de Edição");
					var input = document.getElementById('status').value = "atualizar";			
					var url_string = window.location.href;
					var url = new URL(url_string);
					var id = url.searchParams.get("id");
					var inputId = document.getElementById("id");
					inputId.value = id;	
				}
			</script>
		<%	
		} else if(request.getParameter("status").equals("atualizar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nome = request.getParameter("nome");
	    	String email = request.getParameter("email");
	    	String endereco = request.getParameter("endereco");
	    	String telefone = request.getParameter("telefone");
	    	char sexo = request.getParameter("sexo").charAt(0);
	    	boolean newsletter;
	    	if(request.getParameter("newsletter") == null || request.getParameter("newsletter").equals("false")) {
	    		newsletter = false;
	    	} else {
	    		newsletter = true;
	    	}
			
	    	Cliente cliente = new Cliente(id, nome, email, endereco, telefone, sexo, newsletter);
			ClienteDAO clienteDAO = new ClienteDAO();
			if(!clienteDAO.atualizar(cliente)) {
				%>
				<script>
					window.onload = function() {
						
						addStyleSheet();
						preencher(window);
						alert("Esse email já possui cadastro!");
						var input = document.getElementById('status').value = "atualizar";			
						var url_string = window.location.href;
						var url = new URL(url_string);
						var id = url.searchParams.get("id");
						var inputId = document.getElementById("id");
						inputId.value = id;
						
					}
				</script>
	     	   <% 				
			} else  {
// 	     		Mensagem Atualizado com sucesso
				%>
				<script>
						alert("Atualizado com sucesso!");
				</script>
				<% 
			}
		}
	%> 
		
		
		
	</body>

</html>

	
