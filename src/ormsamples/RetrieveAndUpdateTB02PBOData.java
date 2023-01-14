/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateTB02PBOData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = com.mercubuana.tugasbesar2.TB02PBOPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mercubuana.tugasbesar2.Buku lcommercubuanatugasbesar2Buku = com.mercubuana.tugasbesar2.BukuDAO.loadBukuByQuery(null, null);
			// Update the properties of the persistent object
			com.mercubuana.tugasbesar2.BukuDAO.save(lcommercubuanatugasbesar2Buku);
			com.mercubuana.tugasbesar2.Peminjam lcommercubuanatugasbesar2Peminjam = com.mercubuana.tugasbesar2.PeminjamDAO.loadPeminjamByQuery(null, null);
			// Update the properties of the persistent object
			com.mercubuana.tugasbesar2.PeminjamDAO.save(lcommercubuanatugasbesar2Peminjam);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Buku by BukuCriteria");
		com.mercubuana.tugasbesar2.BukuCriteria lcommercubuanatugasbesar2BukuCriteria = new com.mercubuana.tugasbesar2.BukuCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommercubuanatugasbesar2BukuCriteria.idBuku.eq();
		System.out.println(lcommercubuanatugasbesar2BukuCriteria.uniqueBuku());
		
		System.out.println("Retrieving Peminjam by PeminjamCriteria");
		com.mercubuana.tugasbesar2.PeminjamCriteria lcommercubuanatugasbesar2PeminjamCriteria = new com.mercubuana.tugasbesar2.PeminjamCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lcommercubuanatugasbesar2PeminjamCriteria.idPeminjam.eq();
		System.out.println(lcommercubuanatugasbesar2PeminjamCriteria.uniquePeminjam());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateTB02PBOData retrieveAndUpdateTB02PBOData = new RetrieveAndUpdateTB02PBOData();
			try {
				retrieveAndUpdateTB02PBOData.retrieveAndUpdateTestData();
				//retrieveAndUpdateTB02PBOData.retrieveByCriteria();
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
