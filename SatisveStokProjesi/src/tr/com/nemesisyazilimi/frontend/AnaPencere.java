package tr.com.nemesisyazilimi.frontend;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import tr.com.nemesisyazilimi.complexcontract.StokContractComplex;
import tr.com.nemesisyazilimi.contract.PersonelContract;
import tr.com.nemesisyazilimi.contract.SatisContract;
import tr.com.nemesisyazilimi.contract.StockContract;
import tr.com.nemesisyazilimi.contract.UrunlerContract;
import tr.com.nemesisyazilimi.dao.SatisContractDao;
import tr.com.nemesisyazilimi.dao.StockDao;
import tr.com.nemesisyazilimi.dao.UrunlerDao;
import tr.com.nemesisyazilimi.interfaces.FEInterface;

public class AnaPencere extends JFrame implements FEInterface{

	public AnaPencere() {
		initPencere();
	}
	
	@Override
	public void initPencere() {

		JMenuBar bar = initBar();
		JPanel panel = initPanel();
		add(panel);
		//add(tabs);
		setJMenuBar(bar);
		setTitle("Satış ve Stok Programı");
		setSize(600,250);
		//pack(); // Panelleri Otomatik Olarak Ayarlamak için
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JTabbedPane pane = initTabs();
		panel.add(pane,BorderLayout.CENTER);
		return panel;
	}

	@Override
	public JMenuBar initBar() {
		JMenuBar bar = Menuler.initBar();
		return bar;
	}

	@Override
	public JTabbedPane initTabs() {
		
		ImageIcon icon = new ImageIcon("icons/stok.png");
		
		JTabbedPane pane = new JTabbedPane();
		
		JPanel stokJPanel = new JPanel(new BorderLayout());
		JPanel satısJPanel = new JPanel(new BorderLayout());
		
		//Stok İşlemleri
		
		JPanel stoksolPanel = new JPanel(new BorderLayout());			
		JPanel stoksolUstJPanel = new JPanel(new GridLayout(4,2));
		JPanel stoksolALTJPanel = new JPanel();
		
		stoksolPanel.setBorder(BorderFactory.createTitledBorder("Stok İşlemleri"));
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Personel Adı");
		model.addColumn("Ürün Adı");
		model.addColumn("Adeti");
		model.addColumn("Tarihi");
		
		JTable table = new JTable(model);
		JScrollPane stokpane = new JScrollPane(table);
		
		for(StokContractComplex cotract : new StockDao().GetAllStok()) {
			model.addRow(cotract.getVeriler());
		}
		
		JLabel stokurunadı = new JLabel("Ürün Adı",JLabel.RIGHT);
		stoksolUstJPanel.add(stokurunadı);
		JComboBox stokurunadıBox = new JComboBox(new UrunlerDao().GetAll().toArray());
		stoksolUstJPanel.add(stokurunadıBox);		
		JLabel stokadetLabel = new JLabel("Adet :",JLabel.RIGHT);
		stoksolUstJPanel.add(stokadetLabel);
		JTextField stokadeTextField = new JTextField(10);
		stoksolUstJPanel.add(stokadeTextField);
		JLabel stoktarihJLabel = new JLabel("Stok Tarihi :",JLabel.RIGHT);
		stoksolUstJPanel.add(stoktarihJLabel);
		JDateChooser stokTarih = new JDateChooser();
		stoksolUstJPanel.add(stokTarih);
		
		JButton stokekleButton = new JButton("Stok Ekle");
		stoksolUstJPanel.add(stokekleButton);
		JButton stokyenileButton = new JButton("Yenile");
		stoksolUstJPanel.add(stokyenileButton);
		
		stokekleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				StockContract contract = new StockContract();
				UrunlerContract urunlerContract = (UrunlerContract) stokurunadıBox.getSelectedItem(); 
				PersonelContract pContract = (PersonelContract) Login.emailBox.getSelectedItem();
				
				contract.setPersonelId(pContract.getId());
				contract.setUrunId(urunlerContract.getId());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String date = format.format(stokTarih.getDate());
				contract.setTarih(date);
				contract.setAdet(Integer.parseInt(stokadeTextField.getText()));
				
				new StockDao().Insert(contract);
				JOptionPane.showMessageDialog(null, urunlerContract.getAdi()+" Adlı Ürün Eklenmiştir.");
			}
		});
		
		stoksolPanel.add(stoksolUstJPanel,BorderLayout.NORTH);
		stoksolPanel.add(stoksolALTJPanel,BorderLayout.SOUTH);
		
		stokJPanel.add(stoksolPanel,BorderLayout.WEST);
		stokJPanel.add(stokpane,BorderLayout.CENTER);
		
		//Satış İşlemleri
		
		JPanel satissagPanel = new JPanel(new BorderLayout());			
		JPanel satissagUstJPanel = new JPanel(new GridLayout(4,2));
		JPanel satissagALTJPanel = new JPanel();
				
		satissagPanel.setBorder(BorderFactory.createTitledBorder("Satış İşlemleri"));
		
		DefaultTableModel satismodel = new DefaultTableModel();
		satismodel.addColumn("Id");
		satismodel.addColumn("Personel Adı");
		satismodel.addColumn("Müşteri Adı :");
		satismodel.addColumn("Ürün Adı");
		satismodel.addColumn("Adeti");
		satismodel.addColumn("Tarihi");
		
		JTable satistable = new JTable(satismodel);
		JScrollPane satispane = new JScrollPane(satistable);
		
		JLabel satisurunadı = new JLabel("Ürün Adı",JLabel.RIGHT);
		satissagUstJPanel.add(satisurunadı);
		JComboBox satisurunadıBox = new JComboBox();
		satissagUstJPanel.add(satisurunadıBox);		
		JLabel satisadetLabel = new JLabel("Adet :",JLabel.RIGHT);
		satissagUstJPanel.add(satisadetLabel);
		JTextField satisadeTextField = new JTextField(10);
		satissagUstJPanel.add(satisadeTextField);
		JLabel satistarihJLabel = new JLabel("Satış Tarihi :",JLabel.RIGHT);
		satissagUstJPanel.add(satistarihJLabel);
		JDateChooser satisTarih = new JDateChooser();
		satissagUstJPanel.add(satisTarih);
		
		JButton satisekleButton = new JButton("Satış Yap");
		satissagUstJPanel.add(satisekleButton);
		JButton satisyenileButton = new JButton("Yenile");
		satissagUstJPanel.add(satisyenileButton);
		
		satissagPanel.add(satissagUstJPanel,BorderLayout.NORTH);
		satissagPanel.add(satissagALTJPanel,BorderLayout.SOUTH);		
		
		satısJPanel.add(satissagPanel,BorderLayout.EAST);
		satısJPanel.add(satispane,BorderLayout.CENTER);		
		
		
		pane.addTab("Stoklar", icon,stokJPanel,"");
		pane.addTab("Satışlar", icon,satısJPanel,"yazı");
		return pane;
	}

}
