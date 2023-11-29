package it.softre.thip.base.connettori;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.thera.thermfw.batch.BatchRunnable;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;

import it.softre.thip.base.connettori.descrittori.YConnDescriptor;
import it.softre.thip.base.connettori.descrittori.YConnDescriptorTM;
import it.softre.thip.base.connettori.utils.YApiManagement;
import it.softre.thip.base.connettori.utils.YFunzioniSales2App;
import it.softre.thip.base.connettori.utils.YPsnDatiConnPthSl2app;
import it.thera.thip.api.client.ApiRequest.Method;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.cs.ThipException;

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

public class YConnettoreSales2App extends BatchRunnable {

	protected YPsnDatiConnPthSl2app persDatiConnettore;

	private String authToken = null;

	private String urlCall;

	protected List<String> errors;

	public YPsnDatiConnPthSl2app getPersDatiConnettore() {
		return persDatiConnettore;
	}

	public void setPersDatiConnettore(YPsnDatiConnPthSl2app persDatiConnettore) {
		this.persDatiConnettore = persDatiConnettore;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public boolean initializeBatchJob() throws Exception {
		boolean initialize = super.initializeBatchJob();
		this.setPersDatiConnettore((YPsnDatiConnPthSl2app) YPsnDatiConnPthSl2app.elementWithKey(
				YPsnDatiConnPthSl2app.class, KeyHelper.buildObjectKey(new String[] { Azienda.getAziendaCorrente() }),
				PersistentObject.NO_LOCK));
		if (getPersDatiConnettore() != null) {
			urlCall = getPersDatiConnettore().getUrlCalls() + "/" + getPersDatiConnettore().getApiKey();
		}
		return initialize;
	}

	@Override
	protected boolean run() {
		writeLog("*** Start connettore Panthera --> Sales2App *** \n");
		try {
			login();
			if (authToken != null) { // sono loggato
				processa();
			} else {
				writeLog("Impossibile loggarsi con utente e pwd indicati nella personalizzazione dati");
			}
		} catch (JSONException e) {
			writeLog(e.getMessage());
			e.printStackTrace();
		} catch (ThipException e) {
			e.printStackTrace();
		}
		return false;
	}

	protected void login() throws JSONException {
		writeLog("\\ Per poter effettuare chiamate, provo a ricevere l'authToken loggandomi all'endpoint : // \n");
		writeLog("\\ " + urlCall + "/" + YFunzioniSales2App.ACCOUNT + "/" + YFunzioniSales2App.LOGIN + " \n");
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("username", getPersDatiConnettore().getUserCalls());
		parameters.put("password", getPersDatiConnettore().getPwdCalls());
		JSONObject response = ((JSONObject) YApiManagement.callApi(
				urlCall + "/" + YFunzioniSales2App.ACCOUNT + "/" + YFunzioniSales2App.LOGIN + "", Method.GET,
				MediaType.APPLICATION_JSON, null, parameters, null, true));
		if (response != null && response.toString().contains("authToken")) {
			JSONObject responseJSON = (JSONObject) response.get("response");
			this.authToken = (String) responseJSON.get("authToken");
			writeLog("\\ Login avvenuto correttamente, token == " + authToken + " \n");
		} else {
			if (response.toString().contains("error")) {
				int result = response.getInt("error");
				writeLog("Impossibile effettuare il login, codice errore =" + result);
			}

		}
	}

	@SuppressWarnings("unchecked")
	protected void processa() throws ThipException {
		try {
			Vector<YConnDescriptor> descriptors = YConnDescriptor.retrieveList(YConnDescriptor.class,
					" " + YConnDescriptorTM.ABILITATO + " = 'Y' ", " "+YConnDescriptorTM.SEQUENZA_LANCIO+" DESC ", false);
			for (Iterator<YConnDescriptor> iterator = descriptors.iterator(); iterator.hasNext();) {
				YConnDescriptor descriptor = (YConnDescriptor) iterator.next();
				if (descriptor != null) {
					YConnector connector = (YConnector) Factory.createObject(descriptor.getFunzione().getRunnerClass());
					connector.setDescriptor(descriptor);
					connector.setPersDatiConnettore(getPersDatiConnettore());
					connector.setOutput(getOutput());
					connector.setAuthToken(authToken);
					connector.setUrlCalls(urlCall);
					connector.processa();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getClassAdCollectionName() {
		return "YConnettoreSales2App";
	}

	protected void writeLog(String text) {
		System.out.println(text);
		getOutput().println(text);
	}

}
