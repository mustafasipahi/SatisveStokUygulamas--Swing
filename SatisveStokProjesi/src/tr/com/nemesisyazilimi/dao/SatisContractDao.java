package tr.com.nemesisyazilimi.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import tr.com.nemesisyazilimi.contract.SatisContract;
import tr.com.nemesisyazilimi.core.ObjectHelper;
import tr.com.nemesisyazilimi.interfaces.DAOInterface;

public class SatisContractDao extends ObjectHelper implements DAOInterface<SatisContract> {

	@Override
	public void Insert(SatisContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Satis (UrunId,MusteriId,Tarih,Adet,PersonelId)"
					+ " VALUES ("+entity.getUrunId()+","+entity.getMusteriId()+",'"+entity.getTarih()+"',"+entity.getAdet()+","+entity.getPersonelId()+")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<SatisContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SatisContract Delete(SatisContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Upate(SatisContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SatisContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
