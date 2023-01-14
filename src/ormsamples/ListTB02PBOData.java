/**
 * Licensee: 
 * License Type: Evaluation
 */
package ormsamples;

import org.orm.*;
public class ListTB02PBOData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Buku...");
		com.mercubuana.tugasbesar2.Buku[] commercubuanatugasbesar2Bukus = com.mercubuana.tugasbesar2.BukuDAO.listBukuByQuery(null, null);
		int length = Math.min(commercubuanatugasbesar2Bukus.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commercubuanatugasbesar2Bukus[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Peminjam...");
		com.mercubuana.tugasbesar2.Peminjam[] commercubuanatugasbesar2Peminjams = com.mercubuana.tugasbesar2.PeminjamDAO.listPeminjamByQuery(null, null);
		length = Math.min(commercubuanatugasbesar2Peminjams.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(commercubuanatugasbesar2Peminjams[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Buku by Criteria...");
		com.mercubuana.tugasbesar2.BukuCriteria lcommercubuanatugasbesar2BukuCriteria = new com.mercubuana.tugasbesar2.BukuCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommercubuanatugasbesar2BukuCriteria.idBuku.eq();
		lcommercubuanatugasbesar2BukuCriteria.setMaxResults(ROW_COUNT);
		com.mercubuana.tugasbesar2.Buku[] commercubuanatugasbesar2Bukus = lcommercubuanatugasbesar2BukuCriteria.listBuku();
		int length =commercubuanatugasbesar2Bukus== null ? 0 : Math.min(commercubuanatugasbesar2Bukus.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commercubuanatugasbesar2Bukus[i]);
		}
		System.out.println(length + " Buku record(s) retrieved."); 
		
		System.out.println("Listing Peminjam by Criteria...");
		com.mercubuana.tugasbesar2.PeminjamCriteria lcommercubuanatugasbesar2PeminjamCriteria = new com.mercubuana.tugasbesar2.PeminjamCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lcommercubuanatugasbesar2PeminjamCriteria.idPeminjam.eq();
		lcommercubuanatugasbesar2PeminjamCriteria.setMaxResults(ROW_COUNT);
		com.mercubuana.tugasbesar2.Peminjam[] commercubuanatugasbesar2Peminjams = lcommercubuanatugasbesar2PeminjamCriteria.listPeminjam();
		length =commercubuanatugasbesar2Peminjams== null ? 0 : Math.min(commercubuanatugasbesar2Peminjams.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(commercubuanatugasbesar2Peminjams[i]);
		}
		System.out.println(length + " Peminjam record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListTB02PBOData listTB02PBOData = new ListTB02PBOData();
			try {
				listTB02PBOData.listTestData();
				//listTB02PBOData.listByCriteria();
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
