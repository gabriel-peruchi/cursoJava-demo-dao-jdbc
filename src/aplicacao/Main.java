package aplicacao;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entidades.Vendedor;

public class Main {

	public static void main(String[] args) {

		
		VendedorDao vendedorDao = FabricaDao.createVendedorDao();
		
		
		System.out.println("=== TESTE VENDEDOR BUSCAR POR ID ===");
		Vendedor vendedor = vendedorDao.consultaPorId(3);
		
		System.out.println(vendedor);
		
	}

}
