package tr.com.nemesisyazilimi.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import tr.com.nemesisyazilimi.contract.MusteriContract;
import tr.com.nemesisyazilimi.core.ObjectHelper;
import tr.com.nemesisyazilimi.interfaces.DAOInterface;

public class MusteriDao extends ObjectHelper implements DAOInterface<MusteriContract> {

	@Override
	public void Insert(MusteriContract entity) {
		
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Musteri (AdiSoyadi,Telefon,Adres,Sehir) VALUES ('"+entity.getAdiSoyadi()+"','"+entity.getTelefon()+"','"+entity.getAdres()+"','"+entity.getSehir()+"') ");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MusteriContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MusteriContract Delete(MusteriContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Upate(MusteriContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MusteriContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
