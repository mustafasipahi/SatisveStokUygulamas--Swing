package tr.com.nemesisyazilimi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.nemesisyazilimi.contract.UrunlerContract;
import tr.com.nemesisyazilimi.core.ObjectHelper;
import tr.com.nemesisyazilimi.interfaces.DAOInterface;

public class UrunlerDao extends ObjectHelper implements DAOInterface<UrunlerContract> {

	@Override
	public void Insert(UrunlerContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Urunler (Adi,KategoriId,Tarih,Fiyat) " + "VALUES ('" + entity.getAdi()
					+ "'," + entity.getKategoriId() + ",'" + entity.getTarih() + "'," + entity.getFiyat() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UrunlerContract> GetAll() {
		
		List<UrunlerContract> dataList = new ArrayList<UrunlerContract>();
		UrunlerContract contract;
		Connection connection = getConnection();
		try {
			contract = new UrunlerContract();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Urunler");
			
			while(resultSet.next()) {
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				contract.setKategoriId(resultSet.getInt("KategoriId"));
				contract.setTarih(resultSet.getString("Tarih"));
				contract.setFiyat(resultSet.getInt("Fiyat"));
				
				dataList.add(contract);
				System.out.println(resultSet.getString("Adi"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dataList;
	}

	@Override
	public UrunlerContract Delete(UrunlerContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Upate(UrunlerContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UrunlerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
