package tr.com.nemesisyazilimi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.nemesisyazilimi.complexcontract.StokContractComplex;
import tr.com.nemesisyazilimi.contract.KategoriContract;
import tr.com.nemesisyazilimi.contract.StockContract;
import tr.com.nemesisyazilimi.core.ObjectHelper;
import tr.com.nemesisyazilimi.interfaces.DAOInterface;

public class StockDao extends ObjectHelper implements DAOInterface<StockContract>{

	@Override
	public void Insert(StockContract entity) {

		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Stok (UrunId,PersonelId,Tarih,Adet) VALUES ("+entity.getUrunId()+","
					+ " "+entity.getPersonelId()+","
					+ " '"+entity.getTarih()+"',"
					+ " "+entity.getAdet()+")");
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<StokContractComplex> GetAllStok(){
		
		List<StokContractComplex> dataContracts = new ArrayList<StokContractComplex>();
		Connection connection = getConnection();
		StokContractComplex contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT stokleft.Id,AdiSoyadi,Adi,Adet,stokleft.Tarih FROM stok" 
														+ "LEFT JOIN urunler on stokleft.UrunId = urunler.Id" 
														+ "LEFT JOIN personel on stokleft.PersonelId = personel.Id");
			while(resultSet.next()) {
				contract = new StokContractComplex();
				contract.setId(resultSet.getInt("Id"));
				contract.setPersonelAdi(resultSet.getString("AdiSoyadi"));
				contract.setUrunAdi(resultSet.getString("urunler.Adi"));
				contract.setAdet(resultSet.getInt("Adet"));
				contract.setTarih(resultSet.getString("stok.Tarih"));			
				
				dataContracts.add(contract);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dataContracts;
	}

	@Override
	public List<StockContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockContract Delete(StockContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Upate(StockContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StockContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
