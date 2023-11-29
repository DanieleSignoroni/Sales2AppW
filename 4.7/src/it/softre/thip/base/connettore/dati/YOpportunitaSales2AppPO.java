package it.softre.thip.base.connettore.dati;

import java.math.BigDecimal;
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

import it.softre.thip.base.connettori.dati.YAttivitaSales2App;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.cliente.ClienteVendita;
import it.thera.thip.cs.EntitaAzienda;

public abstract class YOpportunitaSales2AppPO extends EntitaAzienda
		implements BusinessObject, Authorizable, Deletable, Conflictable {

	/**
	 * instance
	 */
	private static YOpportunitaSales2App cInstance;

	/**
	 * Attributo iHash
	 */
	protected String iHash;

	/**
	 * Attributo iTitle
	 */
	protected String iTitle;

	/**
	 * Attributo iStatus
	 */
	protected char iStatus = 'A';

	/**
	 * Attributo iRActivity
	 */
	protected String iRActivity;

	/**
	 * Attributo iRCustomer
	 */
	protected String iRCustomer;

	/**
	 * Attributo iDescription
	 */
	protected String iDescription;

	/**
	 * Attributo iSuccessRate
	 */
	protected Integer iSuccessRate;

	/**
	 * Attributo iEconomicValue
	 */
	protected BigDecimal iEconomicValue;

	/**
	 * Attributo iEconomicValueRecurr
	 */
	protected BigDecimal iEconomicValueRecurr;

	/**
	 * Attributo iNote
	 */
	protected String iNote;

	/**
	 * Attributo iCliente
	 */
	protected Proxy iCliente = new Proxy(it.thera.thip.base.cliente.ClienteVendita.class);

	/**
	 * Attributo iAttivita
	 */
	protected Proxy iAttivita = new Proxy(it.softre.thip.base.connettori.dati.YAttivitaSales2App.class);

	/**
	 * retrieveList
	 * 
	 * @param where
	 * @param orderBy
	 * @param optimistic
	 * @return Vector
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 CodeGen Codice generato da
	 * CodeGenerator
	 *
	 */
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YOpportunitaSales2App) Factory.createObject(YOpportunitaSales2App.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	/**
	 * elementWithKey
	 * 
	 * @param key
	 * @param lockType
	 * @return YOpportunitaSales2App
	 * @throws SQLException
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 CodeGen Codice generato da
	 * CodeGenerator
	 *
	 */
	public static YOpportunitaSales2App elementWithKey(String key, int lockType) throws SQLException {
		return (YOpportunitaSales2App) PersistentObject.elementWithKey(YOpportunitaSales2App.class, key, lockType);
	}

	/**
	 * YOpportunitaSales2AppPO
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public YOpportunitaSales2AppPO() {
		setStatus('A');
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param hash
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setHash(String hash) {
		this.iHash = hash;
		setDirty();
		setOnDB(false);
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return String
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public String getHash() {
		return iHash;
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param title
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setTitle(String title) {
		this.iTitle = title;
		setDirty();
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return String
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public String getTitle() {
		return iTitle;
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param status
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setStatus(char status) {
		this.iStatus = status;
		setDirty();
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return char
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public char getStatus() {
		return iStatus;
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param rActivity
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setRActivity(String rActivity) {
		this.iRActivity = rActivity;
		setDirty();
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return String
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public String getRActivity() {
		return iRActivity;
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param rCustomer
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setRCustomer(String rCustomer) {
		this.iRCustomer = rCustomer;
		setDirty();
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return String
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public String getRCustomer() {
		return iRCustomer;
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param description
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setDescription(String description) {
		this.iDescription = description;
		setDirty();
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return String
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public String getDescription() {
		return iDescription;
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param successRate
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setSuccessRate(Integer successRate) {
		this.iSuccessRate = successRate;
		setDirty();
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return Integer
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public Integer getSuccessRate() {
		return iSuccessRate;
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param economicValue
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setEconomicValue(BigDecimal economicValue) {
		this.iEconomicValue = economicValue;
		setDirty();
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return BigDecimal
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public BigDecimal getEconomicValue() {
		return iEconomicValue;
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param economicValueRecurr
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setEconomicValueRecurr(BigDecimal economicValueRecurr) {
		this.iEconomicValueRecurr = economicValueRecurr;
		setDirty();
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return BigDecimal
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public BigDecimal getEconomicValueRecurr() {
		return iEconomicValueRecurr;
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param note
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setNote(String note) {
		this.iNote = note;
		setDirty();
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return String
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public String getNote() {
		return iNote;
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param cliente
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setCliente(ClienteVendita cliente) {
		String oldObjectKey = getKey();
		String idAzienda = getIdAzienda();
		if (cliente != null) {
			idAzienda = KeyHelper.getTokenObjectKey(cliente.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iCliente.setObject(cliente);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return ClienteVendita
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public ClienteVendita getCliente() {
		return (ClienteVendita) iCliente.getObject();
	}

	/**
	 * setClienteKey
	 * 
	 * @param key
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setClienteKey(String key) {
		String oldObjectKey = getKey();
		iCliente.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	/**
	 * getClienteKey
	 * 
	 * @return String
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public String getClienteKey() {
		return iCliente.getKey();
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param rClientePth
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setRClientePth(String rClientePth) {
		String key = iCliente.getKey();
		iCliente.setKey(KeyHelper.replaceTokenObjectKey(key, 2, rClientePth));
		setDirty();
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return String
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public String getRClientePth() {
		String key = iCliente.getKey();
		String objRClientePth = KeyHelper.getTokenObjectKey(key, 2);
		return objRClientePth;
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param attivita
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setAttivita(YAttivitaSales2App attivita) {
		String oldObjectKey = getKey();
		String idAzienda = getIdAzienda();
		if (attivita != null) {
			idAzienda = KeyHelper.getTokenObjectKey(attivita.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iAttivita.setObject(attivita);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return YAttivitaSales2App
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public YAttivitaSales2App getAttivita() {
		return (YAttivitaSales2App) iAttivita.getObject();
	}

	/**
	 * setAttivitaKey
	 * 
	 * @param key
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setAttivitaKey(String key) {
		String oldObjectKey = getKey();
		iAttivita.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		if (!KeyHelper.areEqual(oldObjectKey, getKey())) {
			setOnDB(false);
		}
	}

	/**
	 * getAttivitaKey
	 * 
	 * @return String
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public String getAttivitaKey() {
		return iAttivita.getKey();
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param idAzienda
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setIdAzienda(String idAzienda) {
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return String
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public String getIdAzienda() {
		String key = iAzienda.getKey();
		return key;
	}

	/**
	 * Valorizza l'attributo.
	 * 
	 * @param rAttivita
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setRAttivita(Integer rAttivita) {
		String key = iAttivita.getKey();
		iAttivita.setKey(KeyHelper.replaceTokenObjectKey(key, 2, rAttivita));
		setDirty();
	}

	/**
	 * Restituisce l'attributo.
	 * 
	 * @return Integer
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public Integer getRAttivita() {
		String key = iAttivita.getKey();
		String objRAttivita = KeyHelper.getTokenObjectKey(key, 2);
		return KeyHelper.stringToIntegerObj(objRAttivita);
	}

	/**
	 * setEqual
	 * 
	 * @param obj
	 * @throws CopyException
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YOpportunitaSales2AppPO yOpportunitaSales2AppPO = (YOpportunitaSales2AppPO) obj;
		iCliente.setEqual(yOpportunitaSales2AppPO.iCliente);
		iAttivita.setEqual(yOpportunitaSales2AppPO.iAttivita);
	}

	/**
	 * checkAll
	 * 
	 * @param components
	 * @return Vector
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	/**
	 * setKey
	 * 
	 * @param key
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public void setKey(String key) {
		setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
		setHash(KeyHelper.getTokenObjectKey(key, 2));
	}

	/**
	 * getKey
	 * 
	 * @return String
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public String getKey() {
		String idAzienda = getIdAzienda();
		String hash = getHash();
		Object[] keyParts = { idAzienda, hash };
		return KeyHelper.buildObjectKey(keyParts);
	}

	/**
	 * isDeletable
	 * 
	 * @return boolean
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public boolean isDeletable() {
		return checkDelete() == null;
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	/**
	 * getTableManager
	 * 
	 * @return TableManager
	 * @throws SQLException
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 CodeGen Codice generato da
	 * CodeGenerator
	 *
	 */
	protected TableManager getTableManager() throws SQLException {
		return YOpportunitaSales2AppTM.getInstance();
	}

	/**
	 * setIdAziendaInternal
	 * 
	 * @param idAzienda
	 */
	/*
	 * Revisions: Date Owner Description 27/11/2023 Wizard Codice generato da Wizard
	 *
	 */
	protected void setIdAziendaInternal(String idAzienda) {
		iAzienda.setKey(idAzienda);
		String key2 = iCliente.getKey();
		iCliente.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
		String key3 = iAttivita.getKey();
		iAttivita.setKey(KeyHelper.replaceTokenObjectKey(key3, 1, idAzienda));
	}

}
