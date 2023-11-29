package it.softre.thip.base.connettori.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspWriter;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.thera.thermfw.persist.PersistentObject;
import com.thera.thermfw.web.WebFormModifier;

import it.softre.thip.base.connettori.utils.YApiManagement;
import it.softre.thip.base.connettori.utils.YFunzioniSales2App;
import it.softre.thip.base.connettori.utils.YPsnDatiConnPthSl2app;
import it.thera.thip.api.client.ApiRequest.Method;
import it.thera.thip.api.client.ApiResponse;
import it.thera.thip.base.azienda.Azienda;

/**
 * 
 * <h1>Softre Solutions</h1> <br>
 * 
 * @version 1.0
 * @author Daniele Signoroni 03/11/2023 <br>
 *         <br>
 *         <b>71289 DSSOF3 03/11/2023</b>
 *         <p>
 *         Estensione entita' in cui posso registrare gli utenti di Sales 2 App
 *         che prendo tramite chiamata http, con parametri presenti in
 *         {@link YPsnDatiConnPthSl2app}
 *         </p>
 */

public class YUtentiSales2AppFormModifier extends WebFormModifier {

	private String authToken;
	private String urlCalls;

	@Override
	public void writeHeadElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeBodyStartElements(JspWriter out) throws IOException {
		Map<String, String> parameters = new HashMap<String, String>();
		try {
			YPsnDatiConnPthSl2app persDatiConn = (YPsnDatiConnPthSl2app) YPsnDatiConnPthSl2app.elementWithKey(
					YPsnDatiConnPthSl2app.class, Azienda.getAziendaCorrente(), PersistentObject.NO_LOCK);
			if (persDatiConn != null) {
				urlCalls = persDatiConn.getUrlCalls() + "/" + persDatiConn.getApiKey();
			}
			parameters.put("username", persDatiConn.getUserCalls());
			parameters.put("password", persDatiConn.getPwdCalls());
			JSONObject response = ((JSONObject) YApiManagement.callApi(
					urlCalls + "/" + YFunzioniSales2App.ACCOUNT + "/" + YFunzioniSales2App.LOGIN + "", Method.GET,
					MediaType.APPLICATION_JSON, null, parameters, null, true));
			if (response != null && response.toString().contains("authToken")) {
				JSONObject responseJSON = (JSONObject) response.get("response");
				this.authToken = (String) responseJSON.get("authToken");
			}
			if (this.authToken != null && !this.authToken.isEmpty()) {
				ApiResponse users = YApiManagement.callApi(urlCalls + "/" + this.authToken + "/users/list_qlik",
						Method.GET, MediaType.APPLICATION_JSON, null, null, null);
				if (users.success()) {
					JSONObject list = users.getBodyAsJSONObject();
					JSONArray arr = (JSONArray) list.get("response");
					JsonArray arrJSON = new JsonArray();
					for (int i = 0; i < arr.length(); i++) {
						JsonParser p = new JsonParser();
						JSONObject obj = arr.getJSONObject(i);
						arrJSON.add(p.parse(obj.toString()));
					}
					out.print("<script>");
					out.print("var json = '" + arrJSON.toString() + "';");
					out.print("</script>");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeFormStartElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeFormEndElements(JspWriter out) throws IOException {

	}

	@Override
	public void writeBodyEndElements(JspWriter out) throws IOException {

	}

}
