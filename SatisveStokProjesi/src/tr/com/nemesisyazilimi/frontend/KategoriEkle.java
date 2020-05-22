package tr.com.nemesisyazilimi.frontend;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.SwingUtilities;

import tr.com.nemesisyazilimi.contract.KategoriContract;
import tr.com.nemesisyazilimi.dao.KategoriDao;
import tr.com.nemesisyazilimi.interfaces.FEInterface;

public class KategoriEkle extends JDialog implements FEInterface {

	public KategoriEkle() {
		initPencere();
	}
	
	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Kategori Ekle"));
		
		add(panel);
		setTitle("Kategori Ekle");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public JPanel initPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));
		JLabel adiLabel = new JLabel("Kategori Adı:",JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiTextField = new JTextField(10);
		panel.add(adiTextField);
		JLabel kategoriLabel = new JLabel("Kategori Seç",JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategoriBox = new JComboBox(new KategoriDao().GetAllParentId().toArray());
		panel.add(kategoriBox);
		kategoriBox.insertItemAt("--Kategori Seçiniz--", 0);
		kategoriBox.setSelectedIndex(0);
		JButton kaydetButonu = new JButton("Kaydet");
		panel.add(kaydetButonu);
		kaydetButonu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				KategoriContract contract = new KategoriContract();				
				
				if (kategoriBox.getSelectedIndex() != 0) {
					KategoriContract castContract = (KategoriContract)(kategoriBox.getSelectedItem());
					contract.setAdi(adiTextField.getText());
					contract.setParentId(castContract.getId());
					
					new KategoriDao().Insert(contract);
					JOptionPane.showMessageDialog(null, contract.getAdi() + " adlı Kategori Başarılı Bir Şekilde Eklenmiştir.");
				}
				else {
					contract.setAdi(adiTextField.getText());
					contract.setParentId(kategoriBox.getSelectedIndex());
					
					new KategoriDao().Insert(contract);
					JOptionPane.showMessageDialog(null, contract.getAdi() + " adlı Kategori Başarılı Bir Şekilde Eklenmiştir.");
				}
				
				
				
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
