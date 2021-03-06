package br.com.locadora;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserDao;
import model.Cliente;

public class TesteBanco {
	
	@Test
	public void initBanco() {
		UserDao userdao = new UserDao();
		Cliente cliente = new Cliente();
		
		cliente.setNome("Carlos José");
		cliente.setEmail("carlos@gmail.com");
		cliente.setCpf("10987654678");
		
		userdao.salvar(cliente);
	}
	
	@Test
	public void initListar() {
		UserDao userdao = new UserDao();
		try {
			List<Cliente> list = userdao.listar();
			
			for(Cliente cliente : list) {
				System.out.println(cliente);
				System.out.println("-----------------------------------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void initBuscar() {
		UserDao userdao = new UserDao();
		
		try {
			Cliente cliente  = userdao.buscar(1);
			System.out.println(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void intiAtualizar() {
		UserDao dao = new UserDao();
		
		try {
			Cliente objetoBanco = dao.buscar(2);
			objetoBanco.setNome("Bob Dylan");
			dao.atualizar(objetoBanco);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeletar() {
		UserDao dao = new UserDao();
		dao.delete(6);
	}
	
	
	
	
	
	
	
	
}
