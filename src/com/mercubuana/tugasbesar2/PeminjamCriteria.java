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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PeminjamCriteria extends AbstractORMCriteria {
	public final IntegerExpression idPeminjam;
	public final StringExpression namaPeminjam;
	public final CharacterExpression jenisBuku;
	public final DateExpression tanggalPeminjam;
	public final IntegerExpression bukuid_bukuId;
	public final AssociationExpression bukuid_buku;
	
	public PeminjamCriteria(Criteria criteria) {
		super(criteria);
		idPeminjam = new IntegerExpression("idPeminjam", this);
		namaPeminjam = new StringExpression("namaPeminjam", this);
		jenisBuku = new CharacterExpression("jenisBuku", this);
		tanggalPeminjam = new DateExpression("tanggalPeminjam", this);
		bukuid_bukuId = new IntegerExpression("bukuid_buku.idBuku", this);
		bukuid_buku = new AssociationExpression("bukuid_buku", this);
	}
	
	public PeminjamCriteria(PersistentSession session) {
		this(session.createCriteria(Peminjam.class));
	}
	
	public PeminjamCriteria() throws PersistentException {
		this(TugasBesar02PersistentManager.instance().getSession());
	}
	
	public BukuCriteria createBukuid_bukuCriteria() {
		return new BukuCriteria(createCriteria("bukuid_buku"));
	}
	
	public Peminjam uniquePeminjam() {
		return (Peminjam) super.uniqueResult();
	}
	
	public Peminjam[] listPeminjam() {
		java.util.List list = super.list();
		return (Peminjam[]) list.toArray(new Peminjam[list.size()]);
	}
}

