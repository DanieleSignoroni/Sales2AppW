/*
 * @(#)YOpportunitaInseritePO.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 27/11/2023 at 14:44:38
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 27/11/2023    Wizard     Codice generato da Wizard
 *
 */
package it.softre.thip.connettori.tabelle;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.base.azienda.AziendaEstesa;
import it.softre.thip.base.connettore.dati.YOpportunitaSales2App;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class YOpportunitaInseritePO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static YOpportunitaInserite cInstance;

  /**
   * Attributo iOpportunita
   */
  protected Proxy iOpportunita = new Proxy(it.softre.thip.base.connettore.dati.YOpportunitaSales2App.class);

  
  /**
   *  retrieveList
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
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (cInstance == null)
      cInstance = (YOpportunitaInserite)Factory.createObject(YOpportunitaInserite.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return YOpportunitaInserite
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static YOpportunitaInserite elementWithKey(String key, int lockType) throws SQLException {
    return (YOpportunitaInserite)PersistentObject.elementWithKey(YOpportunitaInserite.class, key, lockType);
  }

  /**
   * YOpportunitaInseritePO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public YOpportunitaInseritePO() {
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param opportunita
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public void setOpportunita(YOpportunitaSales2App opportunita) {
    String idAzienda = getIdAzienda();
    if (opportunita != null) {
      idAzienda = KeyHelper.getTokenObjectKey(opportunita.getKey(), 1);
    }
    setIdAziendaInternal(idAzienda);
    this.iOpportunita.setObject(opportunita);
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return YOpportunitaSales2App
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public YOpportunitaSales2App getOpportunita() {
    return (YOpportunitaSales2App)iOpportunita.getObject();
  }

  /**
   * setOpportunitaKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public void setOpportunitaKey(String key) {
    iOpportunita.setKey(key);
    String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
    setIdAziendaInternal(idAzienda);
    setDirty();
    setOnDB(false);
  }

  /**
   * getOpportunitaKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public String getOpportunitaKey() {
    return iOpportunita.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public void setIdAzienda(String idAzienda) {
    setIdAziendaInternal(idAzienda);
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public String getIdAzienda() {
    String key = iAzienda.getKey();
    return key;
  }

  /**
   * Valorizza l'attributo. 
   * @param rHash
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public void setRHash(String rHash) {
    String key = iOpportunita.getKey();
    iOpportunita.setKey(KeyHelper.replaceTokenObjectKey(key , 2, rHash));
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public String getRHash() {
    String key = iOpportunita.getKey();
    String objRHash = KeyHelper.getTokenObjectKey(key,2);
    return objRHash;
  }

  /**
   * setEqual
   * @param obj
   * @throws CopyException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
    YOpportunitaInseritePO yOpportunitaInseritePO = (YOpportunitaInseritePO)obj;
    iOpportunita.setEqual(yOpportunitaInseritePO.iOpportunita);
  }

  /**
   * checkAll
   * @param components
   * @return Vector
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public Vector checkAll(BaseComponentsCollection components) {
    Vector errors = new Vector();
    components.runAllChecks(errors);
    return errors;
  }

  /**
   *  setKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public void setKey(String key) {
    setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
    setRHash(KeyHelper.getTokenObjectKey(key, 2));
  }

  /**
   *  getKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public String getKey() {
    String idAzienda = getIdAzienda();
    String rHash = getRHash();
    Object[] keyParts = {idAzienda, rHash};
    return KeyHelper.buildObjectKey(keyParts);
  }

  /**
   * isDeletable
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public boolean isDeletable() {
    return checkDelete() == null;
  }

  /**
   * toString
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public String toString() {
    return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
  }

  /**
   *  getTableManager
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected TableManager getTableManager() throws SQLException {
    return YOpportunitaInseriteTM.getInstance();
  }

  /**
   * setIdAziendaInternal
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  protected void setIdAziendaInternal(String idAzienda) {
    iAzienda.setKey(idAzienda);
        String key2 = iOpportunita.getKey();
    iOpportunita.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
  }

}

