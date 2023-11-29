/*
 * @(#)YOpportunitaSales2AppTM.java
 */

/**
 * YOpportunitaSales2AppTM
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 27/11/2023 at 14:40:33
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 27/11/2023    Wizard     Codice generato da Wizard
 *
 */
package it.softre.thip.base.connettore.dati;
import com.thera.thermfw.persist.*;
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class YOpportunitaSales2AppTM extends TableManager {

  
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
   * Attributo HASH
   */
  public static final String HASH = "HASH";

  /**
   * Attributo TITLE
   */
  public static final String TITLE = "TITLE";

  /**
   * Attributo STATUS
   */
  public static final String STATUS = "STATUS";

  /**
   * Attributo R_ACTIVITY
   */
  public static final String R_ACTIVITY = "R_ACTIVITY";

  /**
   * Attributo R_CUSTOMER
   */
  public static final String R_CUSTOMER = "R_CUSTOMER";

  /**
   * Attributo DESCRIPTION
   */
  public static final String DESCRIPTION = "DESCRIPTION";

  /**
   * Attributo SUCCESS_RATE
   */
  public static final String SUCCESS_RATE = "SUCCESS_RATE";

  /**
   * Attributo ECONOMIC_VALUE
   */
  public static final String ECONOMIC_VALUE = "ECONOMIC_VALUE";

  /**
   * Attributo ECONOMIC_VALUE_RECURRING
   */
  public static final String ECONOMIC_VALUE_RECURRING = "ECONOMIC_VALUE_RECURRING";

  /**
   * Attributo NOTE
   */
  public static final String NOTE = "NOTE";

  /**
   * Attributo R_CLIENTE_PTH
   */
  public static final String R_CLIENTE_PTH = "R_CLIENTE_PTH";

  /**
   * Attributo R_ATTIVITA
   */
  public static final String R_ATTIVITA = "R_ATTIVITA";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "YOPPORTUNITA_SALES_2_APP";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.softre.thip.base.connettore.dati.YOpportunitaSales2App.class.getName();

  
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
      cInstance = (TableManager)Factory.createObject(YOpportunitaSales2AppTM.class);
    }
    return cInstance;
  }

  /**
   *  YOpportunitaSales2AppTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 27/11/2023    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YOpportunitaSales2AppTM() throws SQLException {
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
    addAttribute("Hash", HASH);
    addAttribute("Title", TITLE);
    addAttribute("Status", STATUS);
    addAttribute("RActivity", R_ACTIVITY);
    addAttribute("RCustomer", R_CUSTOMER);
    addAttribute("Description", DESCRIPTION);
    addAttribute("SuccessRate", SUCCESS_RATE, "getIntegerObject");
    addAttribute("EconomicValue", ECONOMIC_VALUE);
    addAttribute("EconomicValueRecurr", ECONOMIC_VALUE_RECURRING);
    addAttribute("Note", NOTE);
    addAttribute("IdAzienda", ID_AZIENDA);
    addAttribute("RClientePth", R_CLIENTE_PTH);
    addAttribute("RAttivita", R_ATTIVITA, "getIntegerObject");
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID_AZIENDA + "," + HASH);

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
    configure(HASH + ", " + TITLE + ", " + STATUS + ", " + R_ACTIVITY
         + ", " + R_CUSTOMER + ", " + DESCRIPTION + ", " + SUCCESS_RATE + ", " + ECONOMIC_VALUE
         + ", " + ECONOMIC_VALUE_RECURRING + ", " + NOTE + ", " + ID_AZIENDA + ", " + R_CLIENTE_PTH
         + ", " + R_ATTIVITA + ", " + STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ
         + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG);
  }

}

