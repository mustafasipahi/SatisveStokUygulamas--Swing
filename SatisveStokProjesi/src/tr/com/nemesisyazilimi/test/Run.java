package tr.com.nemesisyazilimi.test;

import javax.swing.SwingUtilities;

import tr.com.nemesisyazilimi.dao.UrunlerDao;
import tr.com.nemesisyazilimi.frontend.AnaPencere;
import tr.com.nemesisyazilimi.frontend.Login;

public class Run {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				//new AnaPencere();
				new Login();
			}
		});
	}
}
