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
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import tr.com.nemesisyazilimi.contract.AccountsContract;
import tr.com.nemesisyazilimi.contract.PersonelContract;
import tr.com.nemesisyazilimi.contract.Yetkiler;
import tr.com.nemesisyazilimi.dao.AccountDao;
import tr.com.nemesisyazilimi.dao.PersonelDao;
import tr.com.nemesisyazilimi.dao.YetkilerDao;
import tr.com.nemesisyazilimi.interfaces.FEInterface;

public class SifreEkle extends JDialog implements FEInterface{

	public SifreEkle() {
		initPencere();
	}
	
	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Şifre Belirleme İşlemleri"));
		add(panel);		
		setTitle("Şifre Belirleme İşlemleri");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(5,2));
		JLabel personellabel = new JLabel("Personel Seç:",JLabel.RIGHT);
		panel.add(personellabel);
		JComboBox personBox = new JComboBox(new PersonelDao().GetAll().toArray());
		panel.add(personBox);
		JLabel yetkiJLabel = new JLabel("Yetki Seç:",JLabel.RIGHT);
		panel.add(yetkiJLabel);
		JComboBox yetkiBox = new JComboBox(new YetkilerDao().GetAll().toArray());
		panel.add(yetkiBox);
		JLabel password1Label = new JLabel("Şifre Belirle",JLabel.RIGHT);
		panel.add(password1Label);
		JPasswordField pass1Field = new JPasswordField(10);
		panel.add(pass1Field);
		JLabel passtekrarJLabel = new JLabel("Şifre Tekrar",JLabel.RIGHT);
		panel.add(passtekrarJLabel);
		JPasswordField passtekrarField = new JPasswordField(10);
		panel.add(passtekrarField);
		
		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptaiButton = new JButton("İptal");
		panel.add(iptaiButton);
		
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AccountsContract contract = new AccountsContract();
				PersonelContract pContract = (PersonelContract) personBox.getSelectedItem();
				Yetkiler yContract = (Yetkiler) yetkiBox.getSelectedItem();
				
				if (pass1Field.getText().equals(passtekrarField.getText())) {
					
					contract.setPersonelId(pContract.getId());
					contract.setYettkiId(yContract.getId());
					contract.setSifre(pass1Field.getText());
					new AccountDao().Insert(contract);
					JOptionPane.showMessageDialog(null, pContract.getAdiSoyadi() + " Adlı kişiye " + yContract.getAdi() +" Adlı Yetki Başarılı Bir Şekilde Atanmıştır.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Şifreler Uyuşmuyor");
				}
				
				
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
