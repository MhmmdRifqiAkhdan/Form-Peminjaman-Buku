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

public class PeminjamDAO {
	public static Peminjam loadPeminjamByORMID(int idPeminjam) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadPeminjamByORMID(session, idPeminjam);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam getPeminjamByORMID(int idPeminjam) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return getPeminjamByORMID(session, idPeminjam);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam loadPeminjamByORMID(int idPeminjam, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadPeminjamByORMID(session, idPeminjam, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam getPeminjamByORMID(int idPeminjam, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return getPeminjamByORMID(session, idPeminjam, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam loadPeminjamByORMID(PersistentSession session, int idPeminjam) throws PersistentException {
		try {
			return (Peminjam) session.load(com.mercubuana.tugasbesar2.Peminjam.class, Integer.valueOf(idPeminjam));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam getPeminjamByORMID(PersistentSession session, int idPeminjam) throws PersistentException {
		try {
			return (Peminjam) session.get(com.mercubuana.tugasbesar2.Peminjam.class, Integer.valueOf(idPeminjam));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam loadPeminjamByORMID(PersistentSession session, int idPeminjam, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Peminjam) session.load(com.mercubuana.tugasbesar2.Peminjam.class, Integer.valueOf(idPeminjam), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam getPeminjamByORMID(PersistentSession session, int idPeminjam, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Peminjam) session.get(com.mercubuana.tugasbesar2.Peminjam.class, Integer.valueOf(idPeminjam), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPeminjam(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return queryPeminjam(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPeminjam(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return queryPeminjam(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam[] listPeminjamByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return listPeminjamByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam[] listPeminjamByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return listPeminjamByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPeminjam(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Peminjam as Peminjam");
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
	
	public static List queryPeminjam(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Peminjam as Peminjam");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Peminjam", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam[] listPeminjamByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPeminjam(session, condition, orderBy);
			return (Peminjam[]) list.toArray(new Peminjam[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam[] listPeminjamByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPeminjam(session, condition, orderBy, lockMode);
			return (Peminjam[]) list.toArray(new Peminjam[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam loadPeminjamByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadPeminjamByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam loadPeminjamByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return loadPeminjamByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam loadPeminjamByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Peminjam[] peminjams = listPeminjamByQuery(session, condition, orderBy);
		if (peminjams != null && peminjams.length > 0)
			return peminjams[0];
		else
			return null;
	}
	
	public static Peminjam loadPeminjamByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Peminjam[] peminjams = listPeminjamByQuery(session, condition, orderBy, lockMode);
		if (peminjams != null && peminjams.length > 0)
			return peminjams[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePeminjamByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return iteratePeminjamByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePeminjamByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TugasBesar02PersistentManager.instance().getSession();
			return iteratePeminjamByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePeminjamByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Peminjam as Peminjam");
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
	
	public static java.util.Iterator iteratePeminjamByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From com.mercubuana.tugasbesar2.Peminjam as Peminjam");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Peminjam", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam createPeminjam() {
		return new com.mercubuana.tugasbesar2.Peminjam();
	}
	
	public static boolean save(com.mercubuana.tugasbesar2.Peminjam peminjam) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().saveObject(peminjam);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(com.mercubuana.tugasbesar2.Peminjam peminjam) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().deleteObject(peminjam);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mercubuana.tugasbesar2.Peminjam peminjam)throws PersistentException {
		try {
			if (peminjam.getBukuid_buku() != null) {
				peminjam.getBukuid_buku().peminjam.remove(peminjam);
			}
			
			return delete(peminjam);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(com.mercubuana.tugasbesar2.Peminjam peminjam, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (peminjam.getBukuid_buku() != null) {
				peminjam.getBukuid_buku().peminjam.remove(peminjam);
			}
			
			try {
				session.delete(peminjam);
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
	
	public static boolean refresh(com.mercubuana.tugasbesar2.Peminjam peminjam) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().getSession().refresh(peminjam);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(com.mercubuana.tugasbesar2.Peminjam peminjam) throws PersistentException {
		try {
			TugasBesar02PersistentManager.instance().getSession().evict(peminjam);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Peminjam loadPeminjamByCriteria(PeminjamCriteria peminjamCriteria) {
		Peminjam[] peminjams = listPeminjamByCriteria(peminjamCriteria);
		if(peminjams == null || peminjams.length == 0) {
			return null;
		}
		return peminjams[0];
	}
	
	public static Peminjam[] listPeminjamByCriteria(PeminjamCriteria peminjamCriteria) {
		return peminjamCriteria.listPeminjam();
	}
}
