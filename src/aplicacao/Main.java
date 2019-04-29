package aplicacao;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entidades.Vendedor;

public class Main {

	public static void main(String[] args) {

		
		VendedorDao vendedorDao = FabricaDao.createVendedorDao();
		
		Vendedor vendedor = vendedorDao.consultaPorId(3);
		
		System.out.println(vendedor);
		
	}

}
