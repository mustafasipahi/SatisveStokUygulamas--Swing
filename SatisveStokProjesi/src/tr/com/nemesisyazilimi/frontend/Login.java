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

import tr.com.nemesisyazilimi.contract.PersonelContract;
import tr.com.nemesisyazilimi.dao.AccountDao;
import tr.com.nemesisyazilimi.dao.PersonelDao;
import tr.com.nemesisyazilimi.interfaces.FEInterface;

public class Login extends JDialog implements FEInterface {

	public static JComboBox emailBox;
	
	public Login() {
		initPencere();
	}
	
	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Lütfen Bilgilerinizi Giriniz"));
		add(panel);		
		setTitle("Lütfen Giriş Yapınız");
		setModalityType(DEFAULT_MODALITY_TYPE);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3,2));
		
		JLabel emaiLabel = new JLabel("Email:",JLabel.RIGHT);
		panel.add(emaiLabel);
		emailBox = new JComboBox(new PersonelDao().GetAll().toArray());
		panel.add(emailBox);
		JLabel passwordJLabel = new JLabel("Şifreniz:",JLabel.RIGHT);
		panel.add(passwordJLabel);
		JPasswordField passwordField = new JPasswordField(15);
		panel.add(passwordField);
		
		JButton loginButton = new JButton("Giriş Yap");
		panel.add(loginButton);
		JButton iptalButton = new JButton("İptal");
		panel.add(iptalButton);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PersonelContract contract = (PersonelContract) emailBox.getSelectedItem();
				
				if (new AccountDao().GetPersonelIdveSifre(contract.getId(), passwordField.getText()).getId() != 0) {
					setVisible(false);
					new AnaPencere();
				}
				else {
					JOptionPane.showMessageDialog(null, "Giriş Başarısız");
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
