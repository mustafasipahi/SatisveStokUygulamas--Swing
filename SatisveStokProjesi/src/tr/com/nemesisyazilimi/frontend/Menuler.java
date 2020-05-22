package tr.com.nemesisyazilimi.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import tr.com.nemesisyazilimi.contract.PersonelContract;
import tr.com.nemesisyazilimi.dao.AccountDao;

public class Menuler {

	public static JMenuBar initBar() {
		JMenuBar bar = new JMenuBar();	
		
		JMenu dosyaMenu = new JMenu("Dosya");			
		JMenuItem cikisItem = new JMenuItem("Çıkış");
		dosyaMenu.add(cikisItem);
		//Ürünler Menüsü
		JMenu urunlerMenu = new JMenu("Ürünler");
		JMenuItem urunEkle = new JMenuItem("Ürün Ekle");
		urunlerMenu.add(urunEkle);
		JMenuItem kategoriEkle = new JMenuItem("Kategori Ekle");
		urunlerMenu.add(kategoriEkle);
		urunlerMenu.addSeparator();
		JMenuItem urunDuzunle = new JMenuItem("Ürünü Düzenle");
		urunlerMenu.add(urunDuzunle);
		JMenuItem kategoriDüzenle = new JMenuItem("Kategoriyi Düzenle");
		urunlerMenu.add(kategoriDüzenle);	
		//Personel Menüsü
		JMenu personeJMenu = new JMenu("Personel İşlemleri");		
		JMenuItem personelEkleItem = new JMenuItem("Personel Ekle");
		personeJMenu.add(personelEkleItem);
		JMenuItem yetkItem = new JMenuItem("Yetki Ekle");
		personeJMenu.add(yetkItem);
		JMenuItem sifreBelirleItem = new JMenuItem("Şifre Belirle");
		personeJMenu.add(sifreBelirleItem);
		personeJMenu.addSeparator();		
		JMenuItem personelDuzenleItem = new JMenuItem("Personel Düzenle");
		personeJMenu.add(personelDuzenleItem);
		JMenuItem yetkiDuzenleItem = new JMenuItem("Yetki Ekle");
		personeJMenu.add(yetkiDuzenleItem);
		JMenuItem sifreDuzenleItem = new JMenuItem("Şifre Düzenle");
		personeJMenu.add(sifreDuzenleItem);
		//Müşteri Menüsü
		JMenu musteriJMenu = new JMenu("Müşteri İşlemleri");		
		JMenuItem musteriekleItem = new JMenuItem("Müşreir Ekle");
		musteriJMenu.add(musteriekleItem);
		JMenuItem sehirekleItem = new JMenuItem("Şehir Ekle");
		musteriJMenu.add(sehirekleItem);
		musteriJMenu.addSeparator();
		
		JMenuItem musteriduzenleItem = new JMenuItem("Müşteri Düzenle");
		musteriJMenu.add(musteriduzenleItem);
		JMenuItem sehirduzenleItem = new JMenuItem("Şehir Düzenle");
		musteriJMenu.add(sehirduzenleItem);
		
		PersonelContract contract = (PersonelContract) Login.emailBox.getSelectedItem();
		
		if (new AccountDao().GetYetkiId(contract.getId()).getYettkiId() == 3) {
						
			personeJMenu.hide();
		}
		else if (new AccountDao().GetYetkiId(contract.getId()).getYettkiId() == 4) {
			musteriJMenu.hide();
			personeJMenu.hide();
			urunlerMenu.hide();
		}
		
		
		bar.add(dosyaMenu);
		bar.add(urunlerMenu);	
		bar.add(personeJMenu);
		bar.add(musteriJMenu);
		
		urunEkle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new UrunEkle();						
					}
				});
			}
		});
		
		kategoriEkle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new KategoriEkle();
					}
				});
			}
		});
		
		personelEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new PersonelEkle();				
			}
		});
		
		yetkItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new YetkiEkle();
					}
				});
			}
		});
		
		sifreBelirleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new SifreEkle();
					}
				});
			}
		});
		
		musteriekleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new MusteriEkle();
					}
				});
			}
		});
		
		sehirekleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new SehirEkle();
					}
				});
			}
		});
		
		return bar;
	}
}
