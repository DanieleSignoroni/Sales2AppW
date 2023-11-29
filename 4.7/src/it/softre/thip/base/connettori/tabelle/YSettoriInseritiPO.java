/*
 * @(#)YSettoriInseritiPO.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 29/11/2023 at 10:47:37
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 29/11/2023    Wizard     Codice generato da Wizard
 *
 */
package it.softre.thip.base.connettori.tabelle;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.base.azienda.AziendaEstesa;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class YSettoriInseritiPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static YSettoriInseriti cInstance;

  /**
   * Attributo iChiavePth
   */
  protected String iChiavePth;

  /**
   * Attributo iHash
   */
  protected String iHash;

  
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
   * 29/11/2023    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (cInstance == null)
      cInstance = (YSettoriInseriti)Factory.createObject(YSettoriInseriti.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return YSettoriInseriti
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static YSettoriInseriti elementWithKey(String key, int lockType) throws SQLException {
    return (YSettoriInseriti)PersistentObject.elementWithKey(YSettoriInseriti.class, key, lockType);
  }

  /**
   * YSettoriInseritiPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public YSettoriInseritiPO() {
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param chiavePth
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public void setChiavePth(String chiavePth) {
    this.iChiavePth = chiavePth;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public String getChiavePth() {
    return iChiavePth;
  }

  /**
   * Valorizza l'attributo. 
   * @param hash
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public void setHash(String hash) {
    this.iHash = hash;
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
   * 29/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public String getHash() {
    return iHash;
  }

  /**
   * Valorizza l'attributo. 
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public void setIdAzienda(String idAzienda) {
    iAzienda.setKey(idAzienda);
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
   * 29/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public String getIdAzienda() {
    String key = iAzienda.getKey();
    return key;
  }

  /**
   * setEqual
   * @param obj
   * @throws CopyException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
  }

  /**
   * checkAll
   * @param components
   * @return Vector
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    Wizard     Codice generato da Wizard
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
   * 29/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public void setKey(String key) {
    setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
    setHash(KeyHelper.getTokenObjectKey(key, 2));
  }

  /**
   *  getKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    Wizard     Codice generato da Wizard
   *
   */
  public String getKey() {
    String idAzienda = getIdAzienda();
    String hash = getHash();
    Object[] keyParts = {idAzienda, hash};
    return KeyHelper.buildObjectKey(keyParts);
  }

  /**
   * isDeletable
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    Wizard     Codice generato da Wizard
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
   * 29/11/2023    Wizard     Codice generato da Wizard
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
   * 29/11/2023    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected TableManager getTableManager() throws SQLException {
    return YSettoriInseritiTM.getInstance();
  }

}

