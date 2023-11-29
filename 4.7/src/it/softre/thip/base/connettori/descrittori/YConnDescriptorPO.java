package it.softre.thip.base.connettori.descrittori;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.thera.thermfw.common.BaseComponentsCollection;
import com.thera.thermfw.common.BusinessObject;
import com.thera.thermfw.common.Deletable;
import com.thera.thermfw.persist.CopyException;
import com.thera.thermfw.persist.Copyable;
import com.thera.thermfw.persist.ErrorCodes;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.OneToMany;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.persist.Proxy;
import com.thera.thermfw.persist.TableManager;
import com.thera.thermfw.security.Authorizable;
import com.thera.thermfw.security.Conflictable;

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

public abstract class YConnDescriptorPO extends PersistentObject
		implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static YConnDescriptor cInstance;

	protected String iBusinessClass;

	protected String iBusinessClassTabella;

	protected boolean iAbilitato = true;

	protected boolean iLogChiamate = false;

	protected String iWhereEsclusioneDati;

	protected String iClassTransformerJSON;

	protected String iIdJSONObjectToTransform;

	protected Integer iSequenzaLancio;

	protected Proxy iFunzione = new Proxy(it.softre.thip.base.connettori.descrittori.YFunzioniConnSales2App.class);

	protected OneToMany iYJsonStructure = new OneToMany(
			it.softre.thip.base.connettori.descrittori.YConnDescrJsonStructure.class, this, 1, false);

	protected OneToMany iYCampiTabellaInseriti = new OneToMany(
			it.softre.thip.base.connettori.descrittori.YConnDescrTableInsField.class, this, 1, false);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic)
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YConnDescriptor) Factory.createObject(YConnDescriptor.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YConnDescriptor elementWithKey(String key, int lockType) throws SQLException {
		return (YConnDescriptor) PersistentObject.elementWithKey(YConnDescriptor.class, key, lockType);
	}

	public YConnDescriptorPO() {
		setAbilitato(true);
	}

	public void setBusinessClass(String businessClass) {
		this.iBusinessClass = businessClass;
		setDirty();
	}

	public String getBusinessClass() {
		return iBusinessClass;
	}

	public void setBusinessClassTabella(String businessClassTabella) {
		this.iBusinessClassTabella = businessClassTabella;
		setDirty();
	}

	public String getBusinessClassTabella() {
		return iBusinessClassTabella;
	}

	public void setAbilitato(boolean abilitato) {
		this.iAbilitato = abilitato;
		setDirty();
	}

	public boolean getAbilitato() {
		return iAbilitato;
	}

	public boolean isLogChiamate() {
		return iLogChiamate;
	}

	public void setLogChiamate(boolean iLogChiamate) {
		this.iLogChiamate = iLogChiamate;
	}

	public void setWhereEsclusioneDati(String whereEsclusioneDati) {
		this.iWhereEsclusioneDati = whereEsclusioneDati;
		setDirty();
	}

	public String getWhereEsclusioneDati() {
		return iWhereEsclusioneDati;
	}

	public String getClassTransformerJSON() {
		return iClassTransformerJSON;
	}

	public void setClassTransformerJSON(String iClassTransformerJSON) {
		this.iClassTransformerJSON = iClassTransformerJSON;
	}

	public String getIdJSONObjectToTransform() {
		return iIdJSONObjectToTransform;
	}

	public void setIdJSONObjectToTransform(String iIdJSONObjectToTransform) {
		this.iIdJSONObjectToTransform = iIdJSONObjectToTransform;
	}

	public void setFunzione(YFunzioniConnSales2App funzione) {
		this.iFunzione.setObject(funzione);
		setDirty();
		setOnDB(false);
		iYJsonStructure.setFatherKeyChanged();
		iYCampiTabellaInseriti.setFatherKeyChanged();
	}

	public Integer getSequenzaLancio() {
		return iSequenzaLancio;
	}

	public void setSequenzaLancio(Integer iSequenzaLancio) {
		this.iSequenzaLancio = iSequenzaLancio;
	}

	public YFunzioniConnSales2App getFunzione() {
		return (YFunzioniConnSales2App) iFunzione.getObject();
	}

	public void setFunzioneKey(String key) {
		iFunzione.setKey(key);
		setDirty();
		setOnDB(false);
		iYJsonStructure.setFatherKeyChanged();
		iYCampiTabellaInseriti.setFatherKeyChanged();
	}

	public String getFunzioneKey() {
		return iFunzione.getKey();
	}

	public void setIdFunzione(String idFunzione) {
		iFunzione.setKey(idFunzione);
		setDirty();
		setOnDB(false);
		iYJsonStructure.setFatherKeyChanged();
		iYCampiTabellaInseriti.setFatherKeyChanged();
	}

	public String getIdFunzione() {
		String key = iFunzione.getKey();
		return key;
	}

	@SuppressWarnings("rawtypes")
	public List getYJsonStructure() {
		return getYJsonStructureInternal();
	}

	@SuppressWarnings("rawtypes")
	public List getYCampiTabellaInseriti() {
		return getYCampiTabellaInseritiInternal();
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YConnDescriptorPO yConnDescriptorPO = (YConnDescriptorPO) obj;
		iFunzione.setEqual(yConnDescriptorPO.iFunzione);
		iYJsonStructure.setEqual(yConnDescriptorPO.iYJsonStructure);
		iYCampiTabellaInseriti.setEqual(yConnDescriptorPO.iYCampiTabellaInseriti);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdFunzione(key);
	}

	public String getKey() {
		return getIdFunzione();
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public int saveOwnedObjects(int rc) throws SQLException {
		rc = iYJsonStructure.save(rc);
		rc = iYCampiTabellaInseriti.save(rc);
		return rc;
	}

	public int deleteOwnedObjects() throws SQLException {
		int rcYJsonStructure = getYJsonStructureInternal().delete();
		if (rcYJsonStructure < ErrorCodes.NO_ROWS_UPDATED)
			return rcYJsonStructure;
		int rcYCampiTabellaInseriti = getYCampiTabellaInseritiInternal().delete();
		if (rcYCampiTabellaInseriti < ErrorCodes.NO_ROWS_UPDATED)
			return rcYCampiTabellaInseriti;
		return rcYJsonStructure + rcYCampiTabellaInseriti;
	}

	public boolean initializeOwnedObjects(boolean result) {
		result = iYJsonStructure.initialize(result);
		result = iYCampiTabellaInseriti.initialize(result);
		return result;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YConnDescriptorTM.getInstance();
	}

	protected OneToMany getYJsonStructureInternal() {
		if (iYJsonStructure.isNew())
			iYJsonStructure.retrieve();
		return iYJsonStructure;
	}

	protected OneToMany getYCampiTabellaInseritiInternal() {
		if (iYCampiTabellaInseriti.isNew())
			iYCampiTabellaInseriti.retrieve();
		return iYCampiTabellaInseriti;
	}

}
