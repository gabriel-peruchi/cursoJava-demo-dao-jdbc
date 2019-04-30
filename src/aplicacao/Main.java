package aplicacao;

import java.util.Date;
import java.util.List;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entidades.Departamento;
import model.entidades.Vendedor;

public class Main {

	public static void main(String[] args) {

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

	}

}
