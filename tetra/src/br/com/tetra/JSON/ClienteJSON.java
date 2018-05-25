package br.com.tetra.JSON;
import java.sql.SQLException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.tetra.DAO.ClienteDAO;
import br.com.tetra.model.Cliente;

public class ClienteJSON {

	public String getClientes(String nome, String endereco) throws  JSONException, SQLException
	{
		String jsonData="";

		JSONObject empDetails;
		JSONObject jSonDataObj;
		JSONObject jSonDataFinalObj;

		JSONArray empDetailsArr;
		JSONArray jSonDataFinalArr;
		jSonDataFinalArr =new JSONArray(); 
		
		
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> clientes = clienteDAO.getClientes(nome, endereco);
		
		for (Cliente cliente : clientes) {
			empDetails = new JSONObject();
			empDetails.put("id", cliente.getId());
			empDetails.put("nome", cliente.getNome());
			empDetails.put("email", cliente.getEmail());
			empDetails.put("endereco", cliente.getEndereco());
			empDetails.put("telefone", cliente.getTelefone());
			empDetails.put("sexo", (String.valueOf(cliente.getSexo())));
			empDetails.put("newsletter", cliente.isNewsLetter());
			empDetailsArr =new JSONArray();
			empDetailsArr.put(empDetails);

			jSonDataObj=new JSONObject();
			jSonDataObj.put("JsonData", empDetailsArr);
				        
			jSonDataFinalArr.put(jSonDataObj);			
		}

		jSonDataFinalObj = new JSONObject();

		jSonDataFinalObj.put("JSonDataFinal", jSonDataFinalArr);

		jsonData=jSonDataFinalObj.toString();


		return jsonData;
	}
	
	public String getClientes() throws  JSONException, SQLException
	{
		String jsonData="";

		JSONObject empDetails;
		JSONObject jSonDataObj;
		JSONObject jSonDataFinalObj;

		JSONArray empDetailsArr;
		JSONArray jSonDataFinalArr;
		jSonDataFinalArr =new JSONArray(); 
		
		
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> clientes = clienteDAO.getClientes();
		
		for (Cliente cliente : clientes) {
			empDetails = new JSONObject();
			empDetails.put("id", cliente.getId());
			empDetails.put("nome", cliente.getNome());
			empDetails.put("email", cliente.getEmail());
			empDetails.put("endereco", cliente.getEndereco());
			empDetails.put("telefone", cliente.getTelefone());
			empDetails.put("sexo", (String.valueOf(cliente.getSexo())));
			empDetails.put("newsletter", cliente.isNewsLetter());
			empDetailsArr =new JSONArray();
			empDetailsArr.put(empDetails);

			jSonDataObj=new JSONObject();
			jSonDataObj.put("JsonData", empDetailsArr);
				        
			jSonDataFinalArr.put(jSonDataObj);			
		}

		jSonDataFinalObj = new JSONObject();

		jSonDataFinalObj.put("JSonDataFinal", jSonDataFinalArr);

		jsonData=jSonDataFinalObj.toString();


		return jsonData;
	}


}