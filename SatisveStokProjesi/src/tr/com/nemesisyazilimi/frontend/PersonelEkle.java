package tr.com.nemesisyazilimi.frontend;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.nemesisyazilimi.contract.PersonelContract;
import tr.com.nemesisyazilimi.dao.PersonelDao;
import tr.com.nemesisyazilimi.interfaces.FEInterface;

public class PersonelEkle extends JDialog implements FEInterface{

	public PersonelEkle() {
		initPencere();
	}
	
	@Override
	public void initPencere() {
		
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Personel Ekle"));
		add(panel);		
		setTitle("Personel Ekle");
		pack();
		setLocationRelativeTo(null);		
		setModalityType(DEFAULT_MODALITY_TYPE);		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3,2));
		
		JLabel adıSoyadılJLabel = new JLabel("Adı Soyadı : ",JLabel.RIGHT);
		panel.add(adıSoyadılJLabel);
		JTextField adıSoyaField = new JTextField(10);
		panel.add(adıSoyaField);
		JLabel emaiLabel = new JLabel("E-Mail : ",JLabel.RIGHT);
		panel.add(emaiLabel);
		JTextField emailField = new JTextField(15);
		panel.add(emailField);
		
		JButton kaydetButonuButton = new JButton("Kaydet");
		panel.add(kaydetButonuButton);
		JButton iptalButon = new JButton("İptal");
		panel.add(iptalButon);
		
		
		kaydetButonuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PersonelContract contract = new PersonelContract();
				contract.setAdiSoyadi(adıSoyaField.getText());
				contract.setEmail(emailField.getText());
				
				new PersonelDao().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdiSoyadi()+" Adlı Personel Eklenmiştir.");
			}
		});
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
