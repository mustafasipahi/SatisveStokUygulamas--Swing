package tr.com.nemesisyazilimi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.nemesisyazilimi.contract.SehirlerContract;
import tr.com.nemesisyazilimi.core.ObjectHelper;
import tr.com.nemesisyazilimi.interfaces.DAOInterface;

public class SehirlerDao extends ObjectHelper implements DAOInterface<SehirlerContract> {

	@Override
	public void Insert(SehirlerContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Sehirler (Isim) VALUES ('"+entity.getIsim()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<SehirlerContract> GetAll() {
		List<SehirlerContract> list = new ArrayList<SehirlerContract>();
		
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Sehirler");
			SehirlerContract contract;
			while(resultSet.next()) {
				contract = new SehirlerContract();
				contract.setIsim(resultSet.getString("Isim"));
				list.add(contract);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public SehirlerContract Delete(SehirlerContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Upate(SehirlerContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SehirlerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
