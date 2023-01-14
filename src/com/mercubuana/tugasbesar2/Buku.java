/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package com.mercubuana.tugasbesar2;

public class Buku {
	public Buku() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_BUKU_PEMINJAM) {
			return ORM_peminjam;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int idBuku;
	
	private String namaBuku;
	
	private char jenisBuku;
	
	private int jumlahBuku;
	
	private int sisaBuku;
	
	private java.util.Set ORM_peminjam = new java.util.HashSet();
	
	private void setIdBuku(int value) {
		this.idBuku = value;
	}
	
	public int getIdBuku() {
		return idBuku;
	}
	
	public int getORMID() {
		return getIdBuku();
	}
	
	public void setNamaBuku(String value) {
		this.namaBuku = value;
	}
	
	public String getNamaBuku() {
		return namaBuku;
	}
	
	public void setJenisBuku(char value) {
		this.jenisBuku = value;
	}
	
	public char getJenisBuku() {
		return jenisBuku;
	}
	
	public void setJumlahBuku(int value) {
		this.jumlahBuku = value;
	}
	
	public int getJumlahBuku() {
		return jumlahBuku;
	}
	
	public void setSisaBuku(int value) {
		this.sisaBuku = value;
	}
	
	public int getSisaBuku() {
		return sisaBuku;
	}
	
	private void setORM_Peminjam(java.util.Set value) {
		this.ORM_peminjam = value;
	}
	
	private java.util.Set getORM_Peminjam() {
		return ORM_peminjam;
	}
	
	public final com.mercubuana.tugasbesar2.PeminjamSetCollection peminjam = new com.mercubuana.tugasbesar2.PeminjamSetCollection(this, _ormAdapter, ORMConstants.KEY_BUKU_PEMINJAM, ORMConstants.KEY_PEMINJAM_BUKUID_BUKU, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getNamaBuku());
	}
	
}
