package model.dao;

import bd.BD;
import model.dao.impl.VendedorDaoJDBC;

public class FabricaDao {

	public static VendedorDao createVendedorDao() {
		return new VendedorDaoJDBC(BD.getConexao());
	}
}
