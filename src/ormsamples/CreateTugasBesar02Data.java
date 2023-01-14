/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class CreateTugasBesar02Data {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = com.mercubuana.tugasbesar2.TugasBesar02PersistentManager.instance().getSession().beginTransaction();
		try {
			com.mercubuana.tugasbesar2.Buku lcommercubuanatugasbesar2Buku = com.mercubuana.tugasbesar2.BukuDAO.createBuku();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : peminjam, sisaBuku, jumlahBuku, jenisBuku, namaBuku
			com.mercubuana.tugasbesar2.BukuDAO.save(lcommercubuanatugasbesar2Buku);
			com.mercubuana.tugasbesar2.Peminjam lcommercubuanatugasbesar2Peminjam = com.mercubuana.tugasbesar2.PeminjamDAO.createPeminjam();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : bukuid_buku, tanggalPeminjam, jenisBuku, namaPeminjam
			com.mercubuana.tugasbesar2.PeminjamDAO.save(lcommercubuanatugasbesar2Peminjam);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateTugasBesar02Data createTugasBesar02Data = new CreateTugasBesar02Data();
			try {
				createTugasBesar02Data.createTestData();
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
