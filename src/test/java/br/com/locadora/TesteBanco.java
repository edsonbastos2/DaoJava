package br.com.locadora;

import java.util.List;

import org.junit.Test;

import dao.UserDao;
import model.Cliente;

public class TesteBanco {
	
	@Test
	public void initBanco() {
		UserDao userdao = new UserDao();
		Cliente cliente = new Cliente();
		
		cliente.setNome("Alex green");
		cliente.setEmail("alex@gmail.com");
		cliente.setCpf("10987654321");
		
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
}
