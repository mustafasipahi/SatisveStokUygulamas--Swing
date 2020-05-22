package tr.com.nemesisyazilimi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.nemesisyazilimi.contract.KategoriContract;
import tr.com.nemesisyazilimi.contract.PersonelContract;
import tr.com.nemesisyazilimi.core.ObjectHelper;
import tr.com.nemesisyazilimi.interfaces.DAOInterface;

public class PersonelDao extends ObjectHelper implements DAOInterface<PersonelContract>{

	@Override
	public void Insert(PersonelContract entity) {
		
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Personel (AdiSoyadi,Email) VALUES ('"+entity.getAdiSoyadi()+"','"+entity.getEmail()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<PersonelContract> GetAll() {
		
		List<PersonelContract> dataContracts = new ArrayList<PersonelContract>();
		Connection connection = getConnection();
		PersonelContract contract;
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Personel");
			
			while(resultSet.next()) {
				contract = new PersonelContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdiSoyadi(resultSet.getString("AdiSoyadi"));
				contract.setEmail(resultSet.getString("Email"));
				
				dataContracts.add(contract);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dataContracts;
	}

	@Override
	public PersonelContract Delete(PersonelContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Upate(PersonelContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PersonelContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
