/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class DeleteTugasBesar02Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = com.mercubuana.tugasbesar2.TugasBesar02PersistentManager.instance().getSession().beginTransaction();
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
			DeleteTugasBesar02Data deleteTugasBesar02Data = new DeleteTugasBesar02Data();
			try {
				deleteTugasBesar02Data.deleteTestData();
			}
			finally {
				com.mercubuana.tugasbesar2.TugasBesar02PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
