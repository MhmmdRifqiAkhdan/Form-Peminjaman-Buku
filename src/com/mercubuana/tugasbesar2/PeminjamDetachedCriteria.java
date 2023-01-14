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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PeminjamDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idPeminjam;
	public final StringExpression namaPeminjam;
	public final CharacterExpression jenisBuku;
	public final DateExpression tanggalPeminjam;
	public final IntegerExpression bukuid_bukuId;
	public final AssociationExpression bukuid_buku;
	
	public PeminjamDetachedCriteria() {
		super(com.mercubuana.tugasbesar2.Peminjam.class, com.mercubuana.tugasbesar2.PeminjamCriteria.class);
		idPeminjam = new IntegerExpression("idPeminjam", this.getDetachedCriteria());
		namaPeminjam = new StringExpression("namaPeminjam", this.getDetachedCriteria());
		jenisBuku = new CharacterExpression("jenisBuku", this.getDetachedCriteria());
		tanggalPeminjam = new DateExpression("tanggalPeminjam", this.getDetachedCriteria());
		bukuid_bukuId = new IntegerExpression("bukuid_buku.idBuku", this.getDetachedCriteria());
		bukuid_buku = new AssociationExpression("bukuid_buku", this.getDetachedCriteria());
	}
	
	public PeminjamDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mercubuana.tugasbesar2.PeminjamCriteria.class);
		idPeminjam = new IntegerExpression("idPeminjam", this.getDetachedCriteria());
		namaPeminjam = new StringExpression("namaPeminjam", this.getDetachedCriteria());
		jenisBuku = new CharacterExpression("jenisBuku", this.getDetachedCriteria());
		tanggalPeminjam = new DateExpression("tanggalPeminjam", this.getDetachedCriteria());
		bukuid_bukuId = new IntegerExpression("bukuid_buku.idBuku", this.getDetachedCriteria());
		bukuid_buku = new AssociationExpression("bukuid_buku", this.getDetachedCriteria());
	}
	
	public BukuDetachedCriteria createBukuid_bukuCriteria() {
		return new BukuDetachedCriteria(createCriteria("bukuid_buku"));
	}
	
	public Peminjam uniquePeminjam(PersistentSession session) {
		return (Peminjam) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Peminjam[] listPeminjam(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Peminjam[]) list.toArray(new Peminjam[list.size()]);
	}
}

