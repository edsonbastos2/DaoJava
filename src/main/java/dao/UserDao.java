package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.SingleConnection;
import model.Cliente;

public class UserDao {
	
	private Connection connection;
	
	public UserDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Cliente cliente) {
		try {
			String sql = "insert into cliente (nome,email,cpf) values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, cliente.getNome());
			insert.setString(2, cliente.getEmail());
			insert.setString(3, cliente.getCpf());
			insert.execute();
			connection.commit();
		}catch(Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public List<Cliente> listar() throws SQLException{
		List<Cliente> list = new ArrayList<Cliente>();
		String sql = "select * from cliente";
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet resultado = stm.executeQuery();
		
		while(resultado.next()) {
			Cliente cliente = new Cliente();
			cliente.setNome(resultado.getString("nome"));
			cliente.setEmail(resultado.getString("email"));
			cliente.setCpf(resultado.getString("cpf"));
			
			list.add(cliente);
		}
		
		return list;
	}
	
	public Cliente buscar (int id) throws SQLException {
		
		Cliente retorno = new Cliente();
		
		String sql = "select * from cliente where idcliente = " + id;
		PreparedStatement stm = connection.prepareStatement(sql);
		ResultSet resultado = stm.executeQuery();
		
		while(resultado.next()) {
			retorno.setId(resultado.getInt("idcliente"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
			retorno.setCpf(resultado.getString("cpf"));		
		}
		
		return retorno;
		
	}
	
	public void atualizar(Cliente cliente) {
		String sql = "update cliente set nome = ? where idcliente = " + cliente.getId();
		
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			String sql = "delete from cliente where idcliente = " + id;
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.execute();
			connection.commit();
		}catch(Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
