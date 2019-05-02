package aplicacao;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.DepartamentoDao;
import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;


public class Main {

	public static void main(String[] args) {

		System.out.println("===== TESTE COM OS VENDEDORES =====");
		
		VendedorDao vendedorDao = FabricaDao.createVendedorDao();

		System.out.println("=== TESTE VENDEDOR BUSCAR POR ID ===");
		Vendedor vendedor = vendedorDao.consultaPorId(3);
		System.out.println(vendedor);

		System.out.println("\n=== TESTE BUSCAR VENDEDORES POR DEPARTAMENTO ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> listaVendedores = vendedorDao.consultaPorDepartamento(departamento);
		for (Vendedor vend : listaVendedores) {
			System.out.println(vend.toString());
		}

		System.out.println("\n=== TESTE BUSCAR TODOS OS VENDEDORES ===");
		listaVendedores = vendedorDao.consultaTodos();
		for (Vendedor vend : listaVendedores) {
			System.out.println(vend.toString());
		}

		System.out.println("\n=== TESTE INSERIR UM VENDEDOR ===");
		Vendedor vend = new Vendedor(null, "José Peruchi", "jose@gmail.com", new Date(), 1500.00, departamento);
		vendedorDao.inserir(vend);
		System.out.println("Inserido id = " + vend.getId());
		
		
		System.out.println("\n=== TESTE ATUALIZAR UM VENDEDOR ===");
		vend = vendedorDao.consultaPorId(16);
		vend.setNome("Mateus Peruchi");
		vendedorDao.update(vend);
		System.out.println("Atualizado com sucesso!");
		
		System.out.println("\n=== TESTE DELETAR UM VENDEDOR ===");
		vendedorDao.deletePorId(Integer.parseInt(JOptionPane.showInputDialog("Digite um id para ser exluido: ")));
		System.out.println("Deletado com sucesso!");
		
		
		System.out.println("===== TESTE COM OS DEPARTAMENTOS =====");
		
		DepartamentoDao depDao = FabricaDao.createDepartamentoDao();
		
		System.out.println("=== TESTE INSERIR DEPARTAMENTO ===");
		depDao.inserir(new Departamento(null, "Comida"));
		
		System.out.println("=== TESTE DELETA DEPARTAMENTO POR ID ===");
		depDao.deletePorId(6);
		
		System.out.println("=== TESTE UPDATE DEPARTAMENTO POR ID ===");
		Departamento dep = new Departamento(3, "SexShop");
		depDao.update(dep);
		
		System.out.println("=== TESTE CONSULTA DEPARTAMENTO POR ID ===");
		dep = depDao.consultaPorId(3);
		System.out.println(dep.toString());
		
		System.out.println("=== TESTE CONSULTA TODOS DEPARTAMENTOS ===");
		List<Departamento> listDep = depDao.consultaTodos();
		for(Departamento x : listDep) {
			System.out.println(x.toString());
		}
		
		
		
		
		
	}

}
