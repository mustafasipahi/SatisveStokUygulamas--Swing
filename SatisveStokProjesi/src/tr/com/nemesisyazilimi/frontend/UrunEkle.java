package tr.com.nemesisyazilimi.frontend;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import tr.com.nemesisyazilimi.contract.KategoriContract;
import tr.com.nemesisyazilimi.contract.UrunlerContract;
import tr.com.nemesisyazilimi.dao.KategoriDao;
import tr.com.nemesisyazilimi.dao.UrunlerDao;
import tr.com.nemesisyazilimi.interfaces.FEInterface;

public class UrunEkle extends JDialog implements FEInterface {

	public UrunEkle() {
		initPencere();
	}
	
	@Override
	public void initPencere() {

		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Ürün Kayıt Alanı"));  //Panele İsim vermek İçin
		add(panel);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE); //Arkadaki Jframe Öne Gelmemesi İçin
		setLocationRelativeTo(null);
		setTitle("Ürün Ekleyin");
		setVisible(true);

	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(5, 2));
		JLabel label = new JLabel("Ürün Adı:", JLabel.RIGHT);
		panel.add(label);
		JTextField textField = new JTextField(10);
		panel.add(textField);
		JLabel kategoriLabel = new JLabel("Kategori Seç", JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategoriBox = new JComboBox(new KategoriDao().GetAll().toArray());
		panel.add(kategoriBox);
		JLabel tarihLabel = new JLabel("Tarih Seç", JLabel.RIGHT);
		panel.add(tarihLabel);
		JDateChooser tarihDate = new JDateChooser();
		panel.add(tarihDate);
		JLabel fiyatLabel = new JLabel("Fiyat Gir", JLabel.RIGHT);
		panel.add(fiyatLabel);
		JTextField fiyatTextField = new JTextField(10);
		panel.add(fiyatTextField);
		JButton kaydetButonu = new JButton("Kaydet");
		panel.add(kaydetButonu);
		kaydetButonu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UrunlerContract contract = new UrunlerContract();
				KategoriContract castContract = (KategoriContract) kategoriBox.getSelectedItem();
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String date = format.format(tarihDate.getDate());
				contract.setAdi(textField.getText());
				contract.setKategoriId(castContract.getId());
				contract.setTarih(date);
				contract.setFiyat(Float.parseFloat(fiyatTextField.getText()));
				new UrunlerDao().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdi() + " Adlı Ürün Başarıyla Eklenmiştir.");
			}
		});
		JButton iptalButonu = new JButton("İptal");
		panel.add(iptalButonu);

		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
