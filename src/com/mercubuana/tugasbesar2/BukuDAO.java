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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class BukuDAO {
	public static Buku loadBukuByORMID(int idBuku) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadBukuByORMID(session, idBuku);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku getBukuByORMID(int idBuku) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return getBukuByORMID(session, idBuku);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku loadBukuByORMID(int idBuku, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadBukuByORMID(session, idBuku, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku getBukuByORMID(int idBuku, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return getBukuByORMID(session, idBuku, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku loadBukuByORMID(PersistentSession session, int idBuku) throws PersistentException {
		try {
			return (Buku) session.load(com.mercubuana.tugasbesar2.Buku.class, Integer.valueOf(idBuku));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku getBukuByORMID(PersistentSession session, int idBuku) throws PersistentException {
		try {
			return (Buku) session.get(com.mercubuana.tugasbesar2.Buku.class, Integer.valueOf(idBuku));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku loadBukuByORMID(PersistentSession session, int idBuku, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Buku) session.load(com.mercubuana.tugasbesar2.Buku.class, Integer.valueOf(idBuku), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku getBukuByORMID(PersistentSession session, int idBuku, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Buku) session.get(com.mercubuana.tugasbesar2.Buku.class, Integer.valueOf(idBuku), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBuku(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return queryBuku(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBuku(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return queryBuku(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku[] listBukuByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return listBukuByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku[] listBukuByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return listBukuByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBuku(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Buku as Buku");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryBuku(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Buku as Buku");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Buku", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku[] listBukuByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryBuku(session, condition, orderBy);
			return (Buku[]) list.toArray(new Buku[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku[] listBukuByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryBuku(session, condition, orderBy, lockMode);
			return (Buku[]) list.toArray(new Buku[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku loadBukuByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadBukuByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku loadBukuByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadBukuByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku loadBukuByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Buku[] bukus = listBukuByQuery(session, condition, orderBy);
		if (bukus != null && bukus.length > 0)
			return bukus[0];
		else
			return null;
	}
	
	public static Buku loadBukuByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Buku[] bukus = listBukuByQuery(session, condition, orderBy, lockMode);
		if (bukus != null && bukus.length > 0)
			return bukus[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBukuByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return iterateBukuByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBukuByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return iterateBukuByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBukuByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Buku as Buku");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateBukuByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Buku as Buku");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Buku", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku createBuku() {
		return new com.mercubuana.tugasbesar2.Buku();
	}
	
	public static boolean save(com.mercubuana.tugasbesar2.Buku buku) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().saveObject(buku);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(com.mercubuana.tugasbesar2.Buku buku) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().deleteObject(buku);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mercubuana.tugasbesar2.Buku buku)throws PersistentException {
		try {
			com.mercubuana.tugasbesar2.Peminjam[] lPeminjams = buku.peminjam.toArray();
			for(int i = 0; i < lPeminjams.length; i++) {
				lPeminjams[i].setBukuid_buku(null);
			}
			return delete(buku);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mercubuana.tugasbesar2.Buku buku, org.orm.PersistentSession session)throws PersistentException {
		try {
			com.mercubuana.tugasbesar2.Peminjam[] lPeminjams = buku.peminjam.toArray();
			for(int i = 0; i < lPeminjams.length; i++) {
				lPeminjams[i].setBukuid_buku(null);
			}
			try {
				session.delete(buku);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(com.mercubuana.tugasbesar2.Buku buku) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().getSession().refresh(buku);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(com.mercubuana.tugasbesar2.Buku buku) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().getSession().evict(buku);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Buku loadBukuByCriteria(BukuCriteria bukuCriteria) {
		Buku[] bukus = listBukuByCriteria(bukuCriteria);
		if(bukus == null || bukus.length == 0) {
			return null;
		}
		return bukus[0];
	}
	
	public static Buku[] listBukuByCriteria(BukuCriteria bukuCriteria) {
		return bukuCriteria.listBuku();
	}
}
