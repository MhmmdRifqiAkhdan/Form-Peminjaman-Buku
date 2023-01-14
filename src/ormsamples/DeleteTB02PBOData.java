/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class DeleteTB02PBOData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = com.mercubuana.tugasbesar2.TB02PBOPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mercubuana.tugasbesar2.Buku lcommercubuanatugasbesar2Buku = com.mercubuana.tugasbesar2.BukuDAO.loadBukuByQuery(null, null);
			// Delete the persistent object
			com.mercubuana.tugasbesar2.BukuDAO.delete(lcommercubuanatugasbesar2Buku);
			com.mercubuana.tugasbesar2.Peminjam lcommercubuanatugasbesar2Peminjam = com.mercubuana.tugasbesar2.PeminjamDAO.loadPeminjamByQuery(null, null);
			// Delete the persistent object
			com.mercubuana.tugasbesar2.PeminjamDAO.delete(lcommercubuanatugasbesar2Peminjam);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteTB02PBOData deleteTB02PBOData = new DeleteTB02PBOData();
			try {
				deleteTB02PBOData.deleteTestData();
			}
			finally {
				com.mercubuana.tugasbesar2.TB02PBOPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
