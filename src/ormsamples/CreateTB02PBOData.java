/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class CreateTB02PBOData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = com.mercubuana.tugasbesar2.TB02PBOPersistentManager.instance().getSession().beginTransaction();
		try {
			com.mercubuana.tugasbesar2.Buku lcommercubuanatugasbesar2Buku = com.mercubuana.tugasbesar2.BukuDAO.createBuku();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : peminjam, sisaBuku, jumlahBuku, jenisBuku, namaBuku
			com.mercubuana.tugasbesar2.BukuDAO.save(lcommercubuanatugasbesar2Buku);
			com.mercubuana.tugasbesar2.Peminjam lcommercubuanatugasbesar2Peminjam = com.mercubuana.tugasbesar2.PeminjamDAO.createPeminjam();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : bukuid_buku, tanggalPinjam, jenisBuku, namaPeminjam
			com.mercubuana.tugasbesar2.PeminjamDAO.save(lcommercubuanatugasbesar2Peminjam);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateTB02PBOData createTB02PBOData = new CreateTB02PBOData();
			try {
				createTB02PBOData.createTestData();
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
