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

import tr.com.nemesisyazilimi.contract.Yetkiler;
import tr.com.nemesisyazilimi.dao.YetkilerDao;
import tr.com.nemesisyazilimi.interfaces.FEInterface;

public class YetkiEkle extends JDialog implements FEInterface {

	public YetkiEkle() {
		initPencere();
	}
	
	@Override
	public void initPencere() {
		
		JPanel panel = initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Yetki Ekle"));
		add(panel);		
		setTitle("Ekle");
		setModalityType(DEFAULT_MODALITY_TYPE);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(2,2));
		JLabel adJLabel = new JLabel("Yetki Adı:",JLabel.RIGHT);
		panel.add(adJLabel);
		JTextField adField = new JTextField(10);
		panel.add(adField);
		
		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("İptal");
		panel.add(iptalButton);
		
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Yetkiler contract = new Yetkiler();
				contract.setAdi(adField.getText());
								
				new YetkilerDao().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdi()+" Adlı Yetki Başarıyla Kaydedilmiştir.");
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
