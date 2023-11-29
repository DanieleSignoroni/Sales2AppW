package it.softre.thip.base.connettori.utils;

import java.sql.SQLException;
import java.util.Vector;

import com.thera.thermfw.common.BaseComponentsCollection;
import com.thera.thermfw.common.BusinessObject;
import com.thera.thermfw.common.Deletable;
import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.Proxy;
import com.thera.thermfw.persist.TableManager;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

import it.softre.thip.base.connettori.YUtentiSales2App;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.cs.EntitaAzienda;

/**
 * <h1>Softre Solutions</h1> <br>
 * 
 * @author Daniele Signoroni 16/10/2023 <br>
 *         <br>
 *         <b>71261 DSSOF3 16/10/2023</b>
 *         <p>
 *         Prima stesura.
 *         </p>
 */

public abstract class YPsnDatiConnPthSl2appPO extends EntitaAzienda
		implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static YPsnDatiConnPthSl2app cInstance;

	protected String iApiKey;

	protected String iUserCalls;

	protected String iPwdCalls;

	protected String iUrlCalls;

	protected String iHashUserJolly;

	protected Proxy iUtenteJolly = new Proxy(it.softre.thip.base.connettori.YUtentiSales2App.class);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YPsnDatiConnPthSl2app) Factory.createObject(YPsnDatiConnPthSl2app.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YPsnDatiConnPthSl2app elementWithKey(String key, int lockType) throws SQLException {
		return (YPsnDatiConnPthSl2app) PersistentObject.elementWithKey(YPsnDatiConnPthSl2app.class, key, lockType);
	}

	public YPsnDatiConnPthSl2appPO() {
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setApiKey(String apiKey) {
		this.iApiKey = apiKey;
		setDirty();
	}

	public String getApiKey() {
		return iApiKey;
	}

	public void setUserCalls(String userCalls) {
		this.iUserCalls = userCalls;
		setDirty();
	}

	public String getUserCalls() {
		return iUserCalls;
	}

	public void setPwdCalls(String pwdCalls) {
		this.iPwdCalls = pwdCalls;
		setDirty();
	}

	public String getPwdCalls() {
		return iPwdCalls;
	}

	public void setUrlCalls(String urlCalls) {
		this.iUrlCalls = urlCalls;
		setDirty();
	}

	public String getUrlCalls() {
		return iUrlCalls;
	}

	public void setIdAzienda(String idAzienda) {
		iAzienda.setKey(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public void setUtenteJolly(YUtentiSales2App utente) {
		this.iUtenteJolly.setObject(utente);
		setDirty();
	}

	public YUtentiSales2App getUtenteJolly() {
		return (YUtentiSales2App) iUtenteJolly.getObject();
	}

	public void setUtenteJollyKey(String key) {
		iUtenteJolly.setKey(key);
		setDirty();
	}

	public String getUtenteJollyKey() {
		return iUtenteJolly.getKey();
	}

	public void setHashUserJolly(String idUtenteS2App) {
		iUtenteJolly.setKey(idUtenteS2App);
		setDirty();
	}

	public String getHashUserJolly() {
		String key = iUtenteJolly.getKey();
		return key;
	}

	public String getIdAzienda() {
		String key = iAzienda.getKey();
		return key;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(key);
	}

	public String getKey() {
		return getIdAzienda();
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YPsnDatiConnPthSl2appTM.getInstance();
	}

}
