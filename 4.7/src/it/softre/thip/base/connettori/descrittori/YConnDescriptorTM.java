package it.softre.thip.base.connettori.descrittori;

import java.sql.SQLException;

import com.thera.thermfw.base.SystemParam;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.TableManager;

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

public class YConnDescriptorTM extends TableManager {

	public static final String BUSINESS_CLASS_DATI = "BUSINESS_CLASS_DATI";

	public static final String R_FUNZIONE = "R_FUNZIONE";

	public static final String BUSINESS_CLASS_TABELLA = "BUSINESS_CLASS_TABELLA";

	public static final String ABILITATO = "ABILITATO";

	public static final String LOG_CHIAMATE = "LOG_CHIAMATE";

	public static final String WHERE_ESCLUSIONE_DATI = "WHERE_ESCLUSIONE_DATI";

	public static final String CLASS_TRANSFORMER_JSON = "CLASS_TRANSFORMER_JSON";

	public static final String ID_JSON_OBJ_TO_TRANSFORM = "ID_JSON_OBJ_TO_TRANSFORM";

	public static final String SEQUENZA_LANCIO = "SEQUENZA_LANCIO";

	public static final String TABLE_NAME = SystemParam.getSchema("SOFTRE") + "YCONN_DESCR";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.softre.thip.base.connettori.descrittori.YConnDescriptor.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager) Factory.createObject(YConnDescriptorTM.class);
		}
		return cInstance;
	}

	public YConnDescriptorTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

	protected void initializeRelation() throws SQLException {
		super.initializeRelation();
		addAttribute("BusinessClass", BUSINESS_CLASS_DATI);
		addAttribute("BusinessClassTabella", BUSINESS_CLASS_TABELLA);
		addAttribute("Abilitato", ABILITATO);
		addAttribute("WhereEsclusioneDati", WHERE_ESCLUSIONE_DATI);
		addAttribute("IdFunzione", R_FUNZIONE);
		addAttribute("LogChiamate", LOG_CHIAMATE);
		addAttribute("ClassTransformerJSON", CLASS_TRANSFORMER_JSON);
		addAttribute("IdJSONObjectToTransform", ID_JSON_OBJ_TO_TRANSFORM);
		addAttribute("SequenzaLancio", SEQUENZA_LANCIO);

		setKeys(R_FUNZIONE);
	}

	private void init() throws SQLException {
		configure();
	}

}
