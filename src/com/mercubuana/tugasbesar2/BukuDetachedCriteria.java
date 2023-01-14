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

public class BukuDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idBuku;
	public final StringExpression namaBuku;
	public final CharacterExpression jenisBuku;
	public final IntegerExpression jumlahBuku;
	public final IntegerExpression sisaBuku;
	public final CollectionExpression peminjam;
	
	public BukuDetachedCriteria() {
		super(com.mercubuana.tugasbesar2.Buku.class, com.mercubuana.tugasbesar2.BukuCriteria.class);
		idBuku = new IntegerExpression("idBuku", this.getDetachedCriteria());
		namaBuku = new StringExpression("namaBuku", this.getDetachedCriteria());
		jenisBuku = new CharacterExpression("jenisBuku", this.getDetachedCriteria());
		jumlahBuku = new IntegerExpression("jumlahBuku", this.getDetachedCriteria());
		sisaBuku = new IntegerExpression("sisaBuku", this.getDetachedCriteria());
		peminjam = new CollectionExpression("ORM_Peminjam", this.getDetachedCriteria());
	}
	
	public BukuDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, com.mercubuana.tugasbesar2.BukuCriteria.class);
		idBuku = new IntegerExpression("idBuku", this.getDetachedCriteria());
		namaBuku = new StringExpression("namaBuku", this.getDetachedCriteria());
		jenisBuku = new CharacterExpression("jenisBuku", this.getDetachedCriteria());
		jumlahBuku = new IntegerExpression("jumlahBuku", this.getDetachedCriteria());
		sisaBuku = new IntegerExpression("sisaBuku", this.getDetachedCriteria());
		peminjam = new CollectionExpression("ORM_Peminjam", this.getDetachedCriteria());
	}
	
	public PeminjamDetachedCriteria createPeminjamCriteria() {
		return new PeminjamDetachedCriteria(createCriteria("ORM_Peminjam"));
	}
	
	public Buku uniqueBuku(PersistentSession session) {
		return (Buku) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Buku[] listBuku(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Buku[]) list.toArray(new Buku[list.size()]);
	}
}

