package br.com.tetra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tetra.model.Cliente;


public class ClienteDAO {
	
	public boolean persistir(Cliente cliente) throws SQLException {
		if(this.isEmailDuplicado(cliente)) {
			return false;
		};
		
		ConexaoBD.conectar();
		Connection connection = ConexaoBD.getConnection();				
		
		String sql = null;
		PreparedStatement stmt;
		
		sql = 
				"INSERT INTO clientes " +
                "(nome, email, endereco, telefone, sexo, newsletter) " +
                "VALUES (?,?,?,?,?,?)";
		
		stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getEmail());
		stmt.setString(3, cliente.getEndereco());
		stmt.setString(4, cliente.getTelefone());
		stmt.setString(5, String.valueOf(cliente.getSexo()));
		stmt.setString(6, String.valueOf((cliente.isNewsLetter() ? 1 : 0)));
	    
		stmt.execute();
	    
        stmt.close();
        ConexaoBD.desconectar();
        return true;
	}
	
	public boolean atualizar(Cliente cliente) throws SQLException {
		if(this.isEmailDuplicado(cliente)) {
			return false;
		};
		
		ConexaoBD.conectar();
		Connection connection = ConexaoBD.getConnection();
			
		String sql = null;
		PreparedStatement stmt;
		
		sql = 
				"UPDATE clientes set "
				+ "nome = ?, "
				+ "email = ?, "
				+ "endereco = ?, "
				+ "telefone = ?, "
				+ "sexo = ?, "
				+ "newsletter = ? "
				+ "where id = ?";
		
		stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, cliente.getNome());		
		stmt.setString(2, cliente.getEmail());
		stmt.setString(3, cliente.getEndereco());
		stmt.setString(4, cliente.getTelefone());
		stmt.setString(5, String.valueOf(cliente.getSexo()));
		stmt.setString(6, String.valueOf((cliente.isNewsLetter() ? 1 : 0)));
		stmt.setInt(7, cliente.getId());
	    
		stmt.execute();
		
	    
        stmt.close();
        ConexaoBD.desconectar();
		return true;
	}
	
	public List<Cliente> getClientes() throws SQLException {
		ConexaoBD.conectar();
		Connection connection = ConexaoBD.getConnection();
		
		String sql = null;
		PreparedStatement stmt;

		sql = "SELECT * FROM clientes";
		
		stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        int idResultSet;
    	String nomeResultSet;
    	String emailResultSet;
    	String enderecoResultSet;
    	String telefoneResultSet;
    	char sexoResultSet;
    	boolean newsLetterResultSet;
        
        while(rs.next()) {
        	idResultSet = rs.getInt("id");
        	nomeResultSet = rs.getString("nome");
        	emailResultSet = rs.getString("email");
        	enderecoResultSet = rs.getString("endereco");
        	telefoneResultSet = rs.getString("telefone");
        	sexoResultSet = rs.getString("sexo").charAt(0);
        	newsLetterResultSet = rs.getBoolean("newsletter");
        	clientes.add(new Cliente(idResultSet, nomeResultSet, emailResultSet, enderecoResultSet, telefoneResultSet, sexoResultSet, newsLetterResultSet));
        }
        
        rs.close();
        stmt.close();
        ConexaoBD.desconectar();
        
		return clientes;
	}
	
	public List<Cliente> getClientes(String nome, String email) throws SQLException {
		ConexaoBD.conectar();
		Connection connection = ConexaoBD.getConnection();
		
		String sql = null;
		PreparedStatement stmt;

		sql = "SELECT * FROM clientes "
				+ "WHERE "
				+ "LOWER(clientes.nome) LIKE ? "
				+ "AND LOWER(clientes.email) LIKE ?";
		
		stmt = connection.prepareStatement(sql);
        
		stmt.setString(1, "%" + nome + "%");
		stmt.setString(2, "%" + email + "%");
		
		ResultSet rs = stmt.executeQuery();
        
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        int idResultSet;
    	String nomeResultSet;
    	String emailResultSet;
    	String enderecoResultSet;
    	String telefoneResultSet;
    	char sexoResultSet;
    	boolean newsLetterResultSet;
        
        while(rs.next()) {
        	idResultSet = rs.getInt("id");
        	nomeResultSet = rs.getString("nome");
        	emailResultSet = rs.getString("email");
        	enderecoResultSet = rs.getString("endereco");
        	telefoneResultSet = rs.getString("telefone");
        	sexoResultSet = rs.getString("sexo").charAt(0);
        	newsLetterResultSet = rs.getBoolean("newsletter");
        	clientes.add(new Cliente(idResultSet, nomeResultSet, emailResultSet, enderecoResultSet, telefoneResultSet, sexoResultSet, newsLetterResultSet));
        }
        
        rs.close();
        stmt.close();
        ConexaoBD.desconectar();
        
		return clientes;
	}

	private boolean isEmailDuplicado(Cliente cliente) throws SQLException {
		ConexaoBD.conectar();
		Connection connection = ConexaoBD.getConnection();
		
		String sql = null;
		PreparedStatement stmt;

		if(cliente.getId() == 0) {
			sql = "SELECT * FROM clientes where email = ?";
		} else {
			sql = "SELECT * FROM clientes where email = ? and id <> ?";
		}
						
		stmt = connection.prepareStatement(sql);
		stmt.setString(1, cliente.getEmail());		
		
		if(cliente.getId() != 0) {
			stmt.setInt(2, cliente.getId());
		}
		
        ResultSet rs = stmt.executeQuery();
        
        boolean isEmailDuplicado = rs.next();
        
        rs.close();
        stmt.close();
        ConexaoBD.desconectar();
		return isEmailDuplicado;
	};
	
}
