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

public class BukuCriteria extends AbstractORMCriteria {
	public final IntegerExpression idBuku;
	public final StringExpression namaBuku;
	public final CharacterExpression jenisBuku;
	public final IntegerExpression jumlahBuku;
	public final IntegerExpression sisaBuku;
	public final CollectionExpression peminjam;
	
	public BukuCriteria(Criteria criteria) {
		super(criteria);
		idBuku = new IntegerExpression("idBuku", this);
		namaBuku = new StringExpression("namaBuku", this);
		jenisBuku = new CharacterExpression("jenisBuku", this);
		jumlahBuku = new IntegerExpression("jumlahBuku", this);
		sisaBuku = new IntegerExpression("sisaBuku", this);
		peminjam = new CollectionExpression("ORM_Peminjam", this);
	}
	
	public BukuCriteria(PersistentSession session) {
		this(session.createCriteria(Buku.class));
	}
	
	public BukuCriteria() throws PersistentException {
		this(TugasBesar02PersistentManager.instance().getSession());
	}
	
	public PeminjamCriteria createPeminjamCriteria() {
		return new PeminjamCriteria(createCriteria("ORM_Peminjam"));
	}
	
	public Buku uniqueBuku() {
		return (Buku) super.uniqueResult();
	}
	
	public Buku[] listBuku() {
		java.util.List list = super.list();
		return (Buku[]) list.toArray(new Buku[list.size()]);
	}
}

