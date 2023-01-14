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

public class Peminjam {
	public Peminjam() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PEMINJAM_BUKUID_BUKU) {
			this.bukuid_buku = (com.mercubuana.tugasbesar2.Buku) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idPeminjam;
	
	private String namaPeminjam;
	
	private char jenisBuku;
	
	private java.util.Date tanggalPeminjam;
	
	private com.mercubuana.tugasbesar2.Buku bukuid_buku;
	
	private void setIdPeminjam(int value) {
		this.idPeminjam = value;
	}
	
	public int getIdPeminjam() {
		return idPeminjam;
	}
	
	public int getORMID() {
		return getIdPeminjam();
	}
	
	public void setNamaPeminjam(String value) {
		this.namaPeminjam = value;
	}
	
	public String getNamaPeminjam() {
		return namaPeminjam;
	}
	
	public void setJenisBuku(char value) {
		this.jenisBuku = value;
	}
	
	public char getJenisBuku() {
		return jenisBuku;
	}
	
	public void setTanggalPeminjam(java.util.Date value) {
		this.tanggalPeminjam = value;
	}
	
	public java.util.Date getTanggalPeminjam() {
		return tanggalPeminjam;
	}
	
	public void setBukuid_buku(com.mercubuana.tugasbesar2.Buku value) {
		if (bukuid_buku != null) {
			bukuid_buku.peminjam.remove(this);
		}
		if (value != null) {
			value.peminjam.add(this);
		}
	}
	
	public com.mercubuana.tugasbesar2.Buku getBukuid_buku() {
		return bukuid_buku;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Bukuid_buku(com.mercubuana.tugasbesar2.Buku value) {
		this.bukuid_buku = value;
	}
	
	private com.mercubuana.tugasbesar2.Buku getORM_Bukuid_buku() {
		return bukuid_buku;
	}
	
	public String toString() {
		return String.valueOf(getNamaPeminjam());
	}
	
}
