/*
 * @(#)YOpportunitaInseriteTM.java
 */

/**
 * YOpportunitaInseriteTM
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
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class YOpportunitaInseriteTM extends TableManager {

  
  /**
   * Attributo ID_AZIENDA
   */
  public static final String ID_AZIENDA = "ID_AZIENDA";

  /**
   * Attributo STATO
   */
  public static final String STATO = "STATO";

  /**
   * Attributo R_UTENTE_CRZ
   */
  public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

  /**
   * Attributo TIMESTAMP_CRZ
   */
  public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

  /**
   * Attributo R_UTENTE_AGG
   */
  public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

  /**
   * Attributo TIMESTAMP_AGG
   */
  public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

  /**
   * Attributo R_HASH
   */
  public static final String R_HASH = "R_HASH";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "YOPPORTUNITA_INSERITE";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.softre.thip.connettori.tabelle.YOpportunitaInserite.class.getName();

  
  /**
   *  getInstance
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    CodeGen     Codice generato da CodeGenerator
   *
   */
  public synchronized static TableManager getInstance() throws SQLException {
    if (cInstance == null) {
      cInstance = (TableManager)Factory.createObject(YOpportunitaInseriteTM.class);
    }
    return cInstance;
  }

  /**
   *  YOpportunitaInseriteTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YOpportunitaInseriteTM() throws SQLException {
    super();
  }

  /**
   *  initialize
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected void initialize() throws SQLException {
    setTableName(TABLE_NAME);
    setObjClassName(CLASS_NAME);
    init();
  }

  /**
   *  initializeRelation
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  protected void initializeRelation() throws SQLException {
    super.initializeRelation();
    addAttribute("IdAzienda", ID_AZIENDA);
    addAttribute("RHash", R_HASH);
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID_AZIENDA + "," + R_HASH);

    setTimestampColumn("TIMESTAMP_AGG");
    ((it.thera.thip.cs.DatiComuniEstesiTTM)getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
  }

  /**
   *  init
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    Wizard     Codice generato da Wizard
   *
   */
  private void init() throws SQLException {
    configure(ID_AZIENDA + ", " + R_HASH + ", " + STATO + ", " + R_UTENTE_CRZ
         + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
  }

}

