/*
 * @(#)YSettoriInseritiTM.java
 */

/**
 * YSettoriInseritiTM
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
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class YSettoriInseritiTM extends TableManager {

  
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
   * Attributo CHIAVE_PTH
   */
  public static final String CHIAVE_PTH = "CHIAVE_PTH";

  /**
   * Attributo HASH
   */
  public static final String HASH = "HASH";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YSETTORI_INSERITI";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.softre.thip.base.connettori.tabelle.YSettoriInseriti.class.getName();

  
  /**
   *  getInstance
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    CodeGen     Codice generato da CodeGenerator
   *
   */
  public synchronized static TableManager getInstance() throws SQLException {
    if (cInstance == null) {
      cInstance = (TableManager)Factory.createObject(YSettoriInseritiTM.class);
    }
    return cInstance;
  }

  /**
   *  YSettoriInseritiTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YSettoriInseritiTM() throws SQLException {
    super();
  }

  /**
   *  initialize
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 29/11/2023    CodeGen     Codice generato da CodeGenerator
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
   * 29/11/2023    Wizard     Codice generato da Wizard
   *
   */
  protected void initializeRelation() throws SQLException {
    super.initializeRelation();
    addAttribute("ChiavePth", CHIAVE_PTH);
    addAttribute("Hash", HASH);
    addAttribute("IdAzienda", ID_AZIENDA);
    
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
   * 29/11/2023    Wizard     Codice generato da Wizard
   *
   */
  private void init() throws SQLException {
    configure(CHIAVE_PTH + ", " + HASH + ", " + ID_AZIENDA + ", " + STATO
         + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG + ", " + TIMESTAMP_AGG
        );
  }

}

