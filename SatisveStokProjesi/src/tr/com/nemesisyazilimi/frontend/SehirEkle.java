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

import tr.com.nemesisyazilimi.contract.SehirlerContract;
import tr.com.nemesisyazilimi.dao.SehirlerDao;
import tr.com.nemesisyazilimi.interfaces.FEInterface;

public class SehirEkle extends JDialog implements FEInterface {

	public SehirEkle() {
		initPencere();
	}
	
	@Override
	public void initPencere() {
		
		JPanel panel = initPanel();		
		panel.setBorder(BorderFactory.createTitledBorder("Şehir Ekle"));
		add(panel);		
		setTitle("Şehir Ekle");
		setModalityType(DEFAULT_MODALITY_TYPE);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(2,2));		
		JLabel sehirLabel = new JLabel("Şehir Adı :",JLabel.RIGHT);
		panel.add(sehirLabel);
		JTextField sehirField = new JTextField(15);
		panel.add(sehirField);		
		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("İptal");
		panel.add(iptalButton);
		
		kaydetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SehirlerContract contract = new SehirlerContract();
				contract.setIsim(sehirField.getText());				
				new SehirlerDao().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getIsim() + " İsimli Şehir Başarıyla Eklenmiştir.");
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
