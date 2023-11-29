package it.softre.thip.base.connettori;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.thera.thermfw.persist.AbstractTableManager;
import com.thera.thermfw.persist.AttributeRelation;
import com.thera.thermfw.persist.CachedStatement;
import com.thera.thermfw.persist.ConnectionManager;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.persist.PersistentObject;

import it.softre.thip.base.connettore.dati.YOpportunitaSales2App;
import it.softre.thip.base.connettori.dati.YAttivitaSales2App;
import it.softre.thip.base.connettori.dati.YAttivitaSales2AppTM;
import it.softre.thip.base.connettori.dati.transformers.YOpportunityTransformers;
import it.softre.thip.base.connettori.descrittori.YConnDescrJsonStructure;
import it.softre.thip.base.connettori.descrittori.YConnDescrTableInsField;
import it.softre.thip.base.connettori.descrittori.YConnDescriptor;
import it.softre.thip.base.connettori.legami.YLegameAgenteUtente;
import it.softre.thip.base.connettori.tabelle.YClientiInseriti;
import it.softre.thip.base.connettori.tabelle.YClientiInseritiTM;
import it.softre.thip.base.connettori.tabelle.YSettoriInseritiTM;
import it.softre.thip.base.connettori.utils.YApiManagement;
import it.softre.thip.base.connettori.utils.YFunzioniSales2App;
import it.softre.thip.base.connettori.utils.YPsnDatiConnPthSl2app;
import it.thera.thip.api.client.ApiRequest.Method;
import it.thera.thip.api.client.ApiResponse;
import it.thera.thip.base.agentiProvv.Agente;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.cliente.ClientePrimrose;
import it.thera.thip.base.cliente.ClienteVendita;
import it.thera.thip.base.cliente.ClienteVenditaTM;
import it.thera.thip.base.wpu.admin.WpuRubricaContatti;

/**
 * <h1>Softre Solutions</h1>
 * 
 * @version 1.01 <br>
 * @author Daniele Signoroni 16/10/2023 <br>
 *         <br>
 *         <b>71261 DSSOF3 16/10/2023</b>
 *         <p>
 *         Prima stesura.
 *         </p>
 *         <b>71289 DSSOF3 03/11/2023</b>
 *         <p>
 *         <b>Importazione prospect</b>: nell'importazione prospect creo
 *         {@link WpuRubricaContatti}, se questo contatto diventa
 *         {@link ClienteVendita} allora devo aggiornare in Sales 2 App il
 *         prospect che mi e' arrivato cambiando il Tipo Account a
 *         {@link TipiAccount#CLIENTE}.<br>
 *         </br>
 *         <b>Esportazione clienti</b>: nell'importazione clienti voglio che in
 *         Sales 2 App l'utente di assegnazione sia relativo all'agente del
 *         cliente.Per poter fare cio' in panthera sono state create due nuove
 *         etensioni entita':
 *         <ul>
 *         <li>{@link YUtentiSales2App} dove posso inserire un record relativo
 *         ad un utente di Sales 2 App</li>
 *         <li>{@link YLegameAgenteUtente} dove posso legare un {@link Agente}
 *         ad un {@link YUtentiSales2App}</li>
 *         </ul>
 *         In questo modo posso sia in edit che in add andare a passare il
 *         valore 'assigns[]' (utente di appartenenza)
 *         </p>
 */

public class YConnector {

	protected YPsnDatiConnPthSl2app persDatiConnettore;

	protected YConnDescriptor descriptor;

	protected PrintWriter output;

	protected List<String> errors;

	protected String authToken;

	protected String urlCalls;

	protected PersistentObject dataObject;

	protected PersistentObject tableInseritiObject;

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

	public PrintWriter getOutput() {
		return output;
	}

	public void setOutput(PrintWriter output) {
		this.output = output;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getUrlCalls() {
		return urlCalls;
	}

	public void setUrlCalls(String urlCalls) {
		this.urlCalls = urlCalls;
	}

	public YConnDescriptor getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(YConnDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	@SuppressWarnings("unchecked")
	protected void processa() {
		if (getDescriptor().getFunzione().getMetodoChiamata() == Method.POST) {
			dataObject = (PersistentObject) Factory.createObject(getDescriptor().getBusinessClass());
			try {
				writeLog("------------------------------------------------------------------------------------");
				writeLog("** Inizio processo funzione: " + getDescriptor().getFunzione().getIdFunzione() + " **");
				writeLog("\\ Endpoint di chiamata = " + getDescriptor().getFunzione().getEndpointCall() + " /");
				writeLog("\\ I dati verrano pesi dalla tabella = "
						+ dataObject.getAbstractTableManager().getMainTableName() + " /");
				if (getDescriptor().getBusinessClassTabella() != null) {
					tableInseritiObject = (PersistentObject) Factory
							.createObject(getDescriptor().getBusinessClassTabella());
					writeLog(
							"\\ La funzione " + getDescriptor().getIdFunzione() + " gestisce lo storico inserimento /");
					writeLog("\\ Lo storico verra' scritto nella tabella = "
							+ tableInseritiObject.getAbstractTableManager().getMainTableName() + " /");
				} else {
					writeLog("\\ La funzione " + getDescriptor().getIdFunzione()
							+ " non gestisce lo storico inserimento /");
				}
				List<PersistentObject> dataList = getListDataObjects();
				for (Iterator<PersistentObject> iterator = dataList.iterator(); iterator.hasNext();) {
					PersistentObject dataToManage = (PersistentObject) iterator.next();
					PersistentObject dataToEdit = null;
					try {
						writeLog("");
						if (getDescriptor().getFunzione().getIdFunzione().equals("sectors")) {
							dataToEdit = getSettoreInseritoByKeyPth(dataToManage.getKey());
							if (tableInseritiObject != null) { // anche edit
								if (dataToEdit != null) { // se gia inserito vado in aggiornamento
									editSector(dataToManage, dataToEdit);
								} else { // altrimenti prima insert
									addSector(dataToManage);
								}
							} else {
								addSector(dataToManage);
							}
						} else {
							dataToEdit = (PersistentObject) PersistentObject.elementWithKey(
									getDescriptor().getBusinessClassTabella(), dataToManage.getKey(),
									PersistentObject.NO_LOCK);
							if (tableInseritiObject != null) { // anche edit
								if (dataToEdit != null) { // se gia inserito vado in aggiornamento
									edit(dataToManage, dataToEdit);
								} else { // altrimenti prima insert
									add(dataToManage);
								}
							} else { // solo add
								add(dataToManage);
							}
							writeLog("");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				writeLog(e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					writeLog("** Termine processo funzione: " + getDescriptor().getFunzione().getIdFunzione() + " **");
					writeLog("------------------------------------------------------------------------------------");
				} catch (Exception e) {
					writeLog(e.getMessage());
					e.printStackTrace();
				}
			}
		} else if (getDescriptor().getFunzione().getMetodoChiamata() == Method.GET) {
			try {
				dataObject = (PersistentObject) Factory.createObject(getDescriptor().getBusinessClassTabella());
				writeLog("------------------------------------------------------------------------------------");
				writeLog("** Inizio processo funzione: " + getDescriptor().getFunzione().getIdFunzione() + " **");
				writeLog("\\ Endpoint di chiamata = " + getDescriptor().getFunzione().getEndpointCall() + " /");
				writeLog("\\ I dati verrano scritti sulla tabella = "
						+ dataObject.getAbstractTableManager().getMainTableName() + " /");
				if (getDescriptor().getClassTransformerJSON() != null) {
					writeLog("\\ Classe utilizzata per trasformare il JSON in oggetto : "
							+ getDescriptor().getClassTransformerJSON() + " /");
					writeLog("\\ L'id dell'oggetto JSON da tasformare e' == "
							+ getDescriptor().getIdJSONObjectToTransform() + " /");
				}
				ApiResponse response = YApiManagement.callApi(
						urlCalls + "/" + this.getAuthToken() + "/"
								+ this.getDescriptor().getFunzione().getEndpointCall() + "/" + YFunzioniSales2App.LIST,
						getDescriptor().getFunzione().getMetodoChiamata(), MediaType.APPLICATION_JSON, null,
						this.getDescriptor().getFunzione().getAdditionalParamsFunction(), null);
				if (response.success()) {
					try {
						JSONObject resp;
						resp = response.getBodyAsJSONObject().getJSONObject("response");
						JSONArray list = resp.getJSONArray("list");
						writeLog("\\ Gli oggetti sono : " + list.length());
						for (int i = 0; i < list.length(); i++) {
							boolean wasOnDB = false;
							JSONObject obj = list.getJSONObject(i)
									.getJSONObject(getDescriptor().getIdJSONObjectToTransform());
							Class<?> transformerClass = Class.forName(getDescriptor().getClassTransformerJSON());
							// Class<?> inseriti = Class.forName(getDescriptor().getBusinessClassTabella());
							Object objPOJO = new Gson().fromJson(obj.toString(), transformerClass);
							String hash = getHash("getId", transformerClass, objPOJO);
							if (response.success()) {
								java.lang.reflect.Method setHash = null;
								try {
									setHash = dataObject.getClass().getMethod("setHash",
											new Class<?>[] { String.class });
								} catch (NoSuchMethodException e) {
									e.printStackTrace();
									if (setHash == null) {
										setHash = dataObject.getClass().getMethod("setRHash",
												new Class<?>[] { String.class });
									}
								}
								if (setHash != null) {
									PersistentObject boInseriti = getPersistentObjectByHash(hash);
									PersistentObject dataObj = (PersistentObject) Factory
											.createObject(getDescriptor().getBusinessClass());
									;
									if (boInseriti != null) {
										wasOnDB = true;
										dataObj.setKey(boInseriti.getKey());
										if (dataObj.retrieve()) {
											writeLog("\\ Oggetto gia' presente su database, vado in aggiornamento ");
											Iterator<YConnDescrTableInsField> fieldsToBeSetted = getDescriptor()
													.getYCampiTabellaInseriti().iterator();
											while (fieldsToBeSetted.hasNext()) {
												YConnDescrTableInsField fieldToBeSetted = (YConnDescrTableInsField) fieldsToBeSetted
														.next();
												java.lang.reflect.Method getMethod = findGetMethod(fieldsToBeSetted,
														objPOJO, fieldToBeSetted.getValue());
												Class<?> setParTypes[] = { getMethod.getReturnType() };
												java.lang.reflect.Method setMethod = findSetMethod(fieldsToBeSetted,
														dataObj, fieldToBeSetted.getKeyValue(), setParTypes);
												Object value = getMethod.invoke(objPOJO);
												setMethod.invoke(dataObj, value);
											}
											if (hash != null && !hash.equals("null"))
												setHash.invoke(boInseriti, hash);
											dataObj.setOnDB(true);
										}
										if (dataObj instanceof WpuRubricaContatti) {
											// gest contatti
											if (((WpuRubricaContatti) dataObj).getAnagrBase() != null) {
												WpuRubricaContatti contatto = (WpuRubricaContatti) dataObj;
												ClienteVendita cliente = getClienteByAnagrafico(
														contatto.getIdAnagrBase());
												if (cliente != null) {
													YConnDescriptor connDescrCliente = (YConnDescriptor) YConnDescriptor
															.elementWithKey(YConnDescriptor.class,
																	YFunzioniSales2App.CLIENTI,
																	PersistentObject.NO_LOCK);
													// updata l'account di sales 2 app a cliente
													Map<String, String> params = new HashMap<String, String>();
													params.put("types[]",
															String.valueOf(TipiAccount.CLIENTE.getValue()));
													String json = getJSONAddByDescriptor(cliente, connDescrCliente);
													writeLog("Il contatto " + dataObj.getKey()
															+ " e' diventato cliente, aggiorno il tipo in sales 2 app... ");
													ApiResponse post = YApiManagement.callApi(
															urlCalls + "/" + this.getAuthToken() + "/"
																	+ this.getDescriptor().getFunzione()
																			.getEndpointCall()
																	+ "/" + YFunzioniSales2App.EDIT + "/" + hash,
															Method.POST, MediaType.APPLICATION_JSON, null, params,
															json);
													if (!post.success()) {
														writeLog(post.getBodyAsString());
													} else {
														// scrivere tabella clienti inseriti, cosi che non duplico
														// l'importazione
														YClientiInseriti clienteIns = (YClientiInseriti) Factory
																.createObject(YClientiInseriti.class);
														clienteIns.setKey(cliente.getKey());
														clienteIns.setHash(hash);
														if (clienteIns.retrieve()) {
															clienteIns.setOnDB(true); // salvo comunque per aggiornare
															// timestamp
														}
														if (clienteIns.save() > 0) {
															ConnectionManager.commit();
														} else {
															ConnectionManager.rollback();
														}
													}
												} else {
													// non e' ancora diventato cliente
												}
											}
										}
									} else {
										boInseriti = (PersistentObject) Factory
												.createObject(getDescriptor().getBusinessClassTabella());
										// insert
										writeLog("\\ Oggetto non presente su database, vado in inserimento ");
										Iterator<YConnDescrTableInsField> fieldsToBeSetted = getDescriptor()
												.getYCampiTabellaInseriti().iterator();
										dataObj = (PersistentObject) Factory
												.createObject(getDescriptor().getBusinessClass());
										while (fieldsToBeSetted.hasNext()) {
											YConnDescrTableInsField fieldToBeSetted = (YConnDescrTableInsField) fieldsToBeSetted
													.next();
											java.lang.reflect.Method getMethod = findGetMethod(fieldsToBeSetted,
													objPOJO, fieldToBeSetted.getValue());
											Class<?> setParTypes[] = { getMethod.getReturnType() };
											java.lang.reflect.Method setMethod = findSetMethod(fieldsToBeSetted,
													dataObj, fieldToBeSetted.getKeyValue(), setParTypes);
											Object value = getMethod.invoke(objPOJO);
											if (value != null)
												setMethod.invoke(dataObj, value);
										}
										if (hash != null && !hash.equals("null")) {
											setHash.invoke(boInseriti, hash);
										}
									}
									if (dataObj instanceof YOpportunitaSales2App) {
										YOpportunityTransformers opp = (YOpportunityTransformers) objPOJO;
										if (opp.customer != null) {
											String idClientePth = getCustomerByHash(opp.customer.id);
											if (idClientePth != null) {
												((YOpportunitaSales2App) dataObj).setRClientePth(idClientePth);
											}
										}
										if (opp.activity != null) {
											YAttivitaSales2App atv = getActivityByHash(opp.activity.id);
											if (atv != null) {
												((YOpportunitaSales2App) dataObj).setAttivita(atv);
											}
										}
									}
									if (dataObj.save(true) >= 0) {
										boInseriti.setKey(dataObj.getKey());
										if (wasOnDB)
											boInseriti.setOnDB(true);
										if (boInseriti.save() >= 0) {
											ConnectionManager.commit();
										} else {
											ConnectionManager.rollback();
										}
									}
								} else {
									writeLog("Nel persistent object: " + dataObject.getClass().getCanonicalName()
											+ " non e' stato definito il metodo setHash");
									writeLog("Termine funzione processa()");
									return;
								}
							}
						}
					} catch (Exception e) {
						writeLog(e.getMessage());
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					writeLog("** Termine processo funzione: " + getDescriptor().getFunzione().getIdFunzione() + " **");
					writeLog("------------------------------------------------------------------------------------");
				} catch (Exception e) {
					writeLog(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public PersistentObject getSettoreInseritoByKeyPth(String key) {
		String where = " " + YSettoriInseritiTM.ID_AZIENDA + " = '" + Azienda.getAziendaCorrente() + "'" + " AND "
				+ YSettoriInseritiTM.CHIAVE_PTH + " = '" + key + "' ";
		List objs = new ArrayList<PersistentObject>();
		writeLog("Where per eslcudere alcuni record --> " + where);
		try {
			objs = PersistentObject.retrieveList(tableInseritiObject, where, "", false);
			if (objs.size() > 0) {
				return (PersistentObject) objs.get(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	protected void addSector(PersistentObject dataToAdd) {
		writeLog("Provo ad aggiungere l'oggetto con chiave: " + dataToAdd.getKey());
		try {
			String jsonAdd;
			jsonAdd = getJSONAdd(dataToAdd);
			Map<String, String> params = this.getDescriptor().getFunzione().getAdditionalParamsFunction();
			if (jsonAdd != null) {
				ApiResponse response = YApiManagement.callApi(
						urlCalls + "/" + this.getAuthToken() + "/"
								+ this.getDescriptor().getFunzione().getEndpointCall() + "/" + YFunzioniSales2App.ADD,
						getDescriptor().getFunzione().getMetodoChiamata(), MediaType.APPLICATION_JSON, null, params,
						jsonAdd);
				if (this.getDescriptor().isLogChiamate()) {
					// writelog chiamata
				}
				if (response.success()) {
					writeLog("Stato chiamata = " + response.getStatus().toString());
					JSONObject body = response.getBodyAsJSONObject();
					JSONObject respJSON = body.getJSONObject("response");
					String hash = null;
					if (respJSON.get("id") != null) {
						if (!respJSON.get("id").equals(null)) {
							hash = (String) respJSON.get("id");
							try {
								if (tableInseritiObject != null) {
									PersistentObject recordTableInsert = (PersistentObject) Factory
											.createObject(getDescriptor().getBusinessClassTabella());
									Iterator<YConnDescrTableInsField> fieldsToBeSetted = getDescriptor()
											.getYCampiTabellaInseriti().iterator();
									while (fieldsToBeSetted.hasNext()) {
										YConnDescrTableInsField fieldToBeSetted = (YConnDescrTableInsField) fieldsToBeSetted
												.next();
										java.lang.reflect.Method getMethod = findGetMethod(fieldsToBeSetted, dataObject,
												fieldToBeSetted.getValue());
										Class<?> setParTypes[] = { getMethod.getReturnType() };
										java.lang.reflect.Method setMethod = findSetMethod(fieldsToBeSetted,
												recordTableInsert, fieldToBeSetted.getKeyValue(), setParTypes);
										Object value = getMethod.invoke(dataToAdd);
										setMethod.invoke(recordTableInsert, value);
									}
									java.lang.reflect.Method setId = recordTableInsert.getClass().getMethod("setHash",
											new Class<?>[] { String.class });
									if (setId != null) {
										if (hash != null && !hash.equals("null"))
											setId.invoke(recordTableInsert, hash);
										if (recordTableInsert.save() >= 0) {
											writeLog(
													"Record inserito in sales 2 app e inserito nello storico con successo");
											ConnectionManager.commit();
										} else {
											ConnectionManager.rollback();
										}
									} else {
										writeLog(
												"Non e' stato possibile recuperare il metodo di set dell'HASH nella classe = "
														+ recordTableInsert.getClass().getCanonicalName());
									}
								}
							} catch (SQLException e) {
								writeLog("Errore nella popolazione della tabella : "
										+ tableInseritiObject.getAbstractTableManager().getMainTableName() + " "
										+ e.getMessage());
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								writeLog(e.getMessage());
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								writeLog(e.getMessage());
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								writeLog(e.getMessage());
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								e.printStackTrace();
							} catch (SecurityException e) {
								e.printStackTrace();
							}
						}
					}
				} else {
					writeLog("Stato chiamata = " + response.getStatus().toString());
					writeLog("Chiamata terminata con errori per l'oggetto con chiave = " + dataToAdd.getKey());
					writeLog(response.getBodyAsString());
				}
			}
		} catch (SQLException e) {
			writeLog(e.getMessage());
			e.printStackTrace();
		} catch (JSONException e1) {
			writeLog(e1.getMessage());
		}
	}

	protected void editSector(PersistentObject dataToManage, PersistentObject dataToEdit) {
		// TODO Auto-generated method stub

	}

	protected String getHash(String string, Class<?> transformerClass, Object objPOJO) {
		String hash = null;
		java.lang.reflect.Method getHash;
		try {
			getHash = transformerClass.getMethod(string, new Class<?>[] {});
			hash = (String) getHash.invoke(objPOJO);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return hash;
	}

	@SuppressWarnings("unchecked")
	protected PersistentObject getPersistentObjectByHash(String hash) throws SQLException {
		String where = null;
		// Prendo il nome colonna dal tm configurato da therm.
		AbstractTableManager tbMng = dataObject.getAbstractTableManager();
		AttributeRelation ar = null;
		if (tbMng.getKeyRelations().get("RHash") != null) {
			ar = (AttributeRelation) tbMng.getKeyRelations().get("RHash");
			where = ar.getColumnName() + " = '" + hash + "' ";
		} else if (tbMng.getKeyRelations().get("Hash") != null) {
			ar = (AttributeRelation) tbMng.getKeyRelations().get("Hash");
			where = ar.getColumnName() + " = '" + hash + "' ";
		} else {
			return null;
		}
		// Fine
		try {
			Vector<PersistentObject> list = PersistentObject.retrieveList(dataObject, where, "", false);
			if (list.size() > 0) {
				return list.get(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void edit(PersistentObject dataToManage, PersistentObject dataToEdit) {
		writeLog("Provo ad aggiornare l'oggetto con chiave: " + dataToManage.getKey());
		java.lang.reflect.Method getHash;
		String hash = null;
		try {
			getHash = dataToEdit.getClass().getMethod("getHash", new Class<?>[] {});
			hash = (String) getHash.invoke(dataToEdit);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		if (hash != null && hash.length() == 40) {
			try {
				String jsonAdd;
				jsonAdd = getJSONAdd(dataToManage);
				Map<String, String> params = this.getDescriptor().getFunzione().getAdditionalParamsFunction();
				if (jsonAdd != null) {
					ApiResponse response = YApiManagement.callApi(
							urlCalls + "/" + this.getAuthToken() + "/"
									+ this.getDescriptor().getFunzione().getEndpointCall() + "/"
									+ YFunzioniSales2App.EDIT + "/" + hash,
							getDescriptor().getFunzione().getMetodoChiamata(), MediaType.APPLICATION_JSON, null, params,
							jsonAdd);
					if (this.getDescriptor().isLogChiamate()) {
						// writelog chiamata
					}
					if (response.success()) {
						writeLog("Stato chiamata = " + response.getStatus().toString());
						writeLog("Oggetto con chiave : " + dataToManage.getKey() + " aggiornato correttamente");
						try {
							if (dataToEdit.save() >= 0) {
								ConnectionManager.commit();
							} else {
								ConnectionManager.rollback();
							}
						} catch (SQLException e) {
							writeLog("Errore nella popolazione della tabella : "
									+ tableInseritiObject.getAbstractTableManager().getMainTableName() + " "
									+ e.getMessage());
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							writeLog(e.getMessage());
							e.printStackTrace();
						} catch (SecurityException e) {
							e.printStackTrace();
						}
					} else {
						writeLog("Stato chiamata = " + response.getStatus().toString());
						writeLog("Chiamata terminata con errori per l'oggetto con chiave = " + dataToManage.getKey());
						writeLog(response.getBodyAsString());
					}
				}
			} catch (SQLException e) {
				writeLog(e.getMessage());
				e.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				e1.printStackTrace();
			}
		} else {
			writeLog("Non e' stato possibile recuperare il valore dell'HASH per il record con chiave = "
					+ dataToEdit.getKey());
		}
	}

	@SuppressWarnings("unchecked")
	public void add(PersistentObject dataToAdd) {
		writeLog("Provo ad aggiungere l'oggetto con chiave: " + dataToAdd.getKey());
		try {
			String jsonAdd;
			jsonAdd = getJSONAdd(dataToAdd);
			Map<String, String> params = this.getDescriptor().getFunzione().getAdditionalParamsFunction();
			if (jsonAdd != null) {
				ApiResponse response = YApiManagement.callApi(
						urlCalls + "/" + this.getAuthToken() + "/"
								+ this.getDescriptor().getFunzione().getEndpointCall() + "/" + YFunzioniSales2App.ADD,
						getDescriptor().getFunzione().getMetodoChiamata(), MediaType.APPLICATION_JSON, null, params,
						jsonAdd);
				if (this.getDescriptor().isLogChiamate()) {
					// writelog chiamata
				}
				if (response.success()) {
					writeLog("Stato chiamata = " + response.getStatus().toString());
					JSONObject body = response.getBodyAsJSONObject();
					JSONObject respJSON = body.getJSONObject("response");
					String hash = null;
					if (respJSON.get("id") != null) {
						if (!respJSON.get("id").equals(null)) {
							hash = (String) respJSON.get("id");
							try {
								if (tableInseritiObject != null) {
									PersistentObject recordTableInsert = (PersistentObject) Factory
											.createObject(getDescriptor().getBusinessClassTabella());
									Iterator<YConnDescrTableInsField> fieldsToBeSetted = getDescriptor()
											.getYCampiTabellaInseriti().iterator();
									while (fieldsToBeSetted.hasNext()) {
										YConnDescrTableInsField fieldToBeSetted = (YConnDescrTableInsField) fieldsToBeSetted
												.next();
										java.lang.reflect.Method getMethod = findGetMethod(fieldsToBeSetted, dataObject,
												fieldToBeSetted.getValue());
										Class<?> setParTypes[] = { getMethod.getReturnType() };
										java.lang.reflect.Method setMethod = findSetMethod(fieldsToBeSetted,
												recordTableInsert, fieldToBeSetted.getKeyValue(), setParTypes);
										Object value = getMethod.invoke(dataToAdd);
										setMethod.invoke(recordTableInsert, value);
									}
									java.lang.reflect.Method setHash = recordTableInsert.getClass().getMethod("setHash",
											new Class<?>[] { String.class });
									if (setHash != null) {
										if (hash != null && !hash.equals("null"))
											setHash.invoke(recordTableInsert, hash);
										if (recordTableInsert.save() >= 0) {
											writeLog(
													"Record inserito in sales 2 app e inserito nello storico con successo");
											ConnectionManager.commit();
										} else {
											ConnectionManager.rollback();
										}
									} else {
										writeLog(
												"Non e' stato possibile recuperare il metodo di set dell'HASH nella classe = "
														+ recordTableInsert.getClass().getCanonicalName());
									}
								}
							} catch (SQLException e) {
								writeLog("Errore nella popolazione della tabella : "
										+ tableInseritiObject.getAbstractTableManager().getMainTableName() + " "
										+ e.getMessage());
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								writeLog(e.getMessage());
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								writeLog(e.getMessage());
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								writeLog(e.getMessage());
								e.printStackTrace();
							} catch (NoSuchMethodException e) {
								e.printStackTrace();
							} catch (SecurityException e) {
								e.printStackTrace();
							}
						}
					}
				} else {
					writeLog("Stato chiamata = " + response.getStatus().toString());
					writeLog("Chiamata terminata con errori per l'oggetto con chiave = " + dataToAdd.getKey());
					writeLog(response.getBodyAsString());
				}
			}
		} catch (SQLException e) {
			writeLog(e.getMessage());
			e.printStackTrace();
		} catch (JSONException e1) {
			writeLog(e1.getMessage());
		}
	}

	protected java.lang.reflect.Method findSetMethod(Iterator<YConnDescrTableInsField> fieldsToBeSetted,
			PersistentObject targetObject, String methodChain, Class<?>[] setParTypes) {
		java.lang.reflect.Method method = null;
		Object currentObject = targetObject;
		// Split the method chain into individual method calls
		String[] methodCalls = methodChain.split("\\.");
		for (String methodCall : methodCalls) {
			// Remove parentheses if they exist
			methodCall = methodCall.replaceAll("\\(.*\\)", "");
			// Get the method name
			String methodName = "set" + methodCall.substring(3);
			// Find the method in the current object's class
			Class<?> currentClass = currentObject.getClass();
			try {
				method = currentClass.getMethod(methodName, setParTypes);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			// Invoke the method to get the next object
		}
		return method;
	}

	protected java.lang.reflect.Method findGetMethod(Iterator<YConnDescrTableInsField> fieldsToBeSetted,
			Object targetObject, String methodChain) {
		java.lang.reflect.Method method = null;
		Object currentObject = targetObject;
		// Split the method chain into individual method calls
		String[] methodCalls = methodChain.split("\\.");
		for (String methodCall : methodCalls) {
			// Remove parentheses if they exist
			methodCall = methodCall.replaceAll("\\(.*\\)", "");
			// Get the method name
			String methodName = "get" + methodCall.substring(3);
			// Find the method in the current object's class
			Class<?> currentClass = currentObject.getClass();
			try {
				method = currentClass.getMethod(methodName);
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			// Invoke the method to get the next object
		}
		return method;
	}

	protected void writeLog(String text) {
		System.out.println(text);
		getOutput().println(text);
	}

	public static Object executeMethodChain(Object targetObject, String methodChain) throws Exception {
		Object currentObject = targetObject;
		// Split the method chain into individual method calls
		String[] methodCalls = methodChain.split("\\.");
		for (String methodCall : methodCalls) {
			// Remove parentheses if they exist
			methodCall = methodCall.replaceAll("\\(.*\\)", "");
			// Get the method name
			String methodName = "get" + methodCall.substring(3);
			// Find the method in the current object's class
			Class<?> currentClass = currentObject.getClass();
			java.lang.reflect.Method method = currentClass.getMethod(methodName);
			// Invoke the method to get the next object
			currentObject = method.invoke(currentObject);
		}
		return currentObject;
	}

	protected String getWhereExcludeData(PersistentObject table1, PersistentObject table2) {
		String where = this.getDescriptor().getWhereEsclusioneDati();
		if (where == null) {
			return "";
		} else {
			try {
				String tableName1 = table1.getAbstractTableManager().getMainTableName();
				String tableName2 = table2.getAbstractTableManager().getMainTableName();
				where = where.replace("TABLE1", tableName1);
				where = where.replace("TABLE2", tableName2);
				// Questo pezzo importantissimo per escludere dati di altre aziende
				if (table1.getAbstractTableManager().getKeyRelations().get("IdAzienda") != null) {
					AttributeRelation ar = (AttributeRelation) table1.getAbstractTableManager().getKeyRelations()
							.get("IdAzienda");
					where += " AND " + tableName1 + "." + ar.getColumnName() + " = '" + Azienda.getAziendaCorrente()
							+ "' ";
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return where;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<PersistentObject> getListDataObjects() {
		writeLog("Recupero i dati... ");
		List contatti = new ArrayList<PersistentObject>();
		String where = getWhereExcludeData(dataObject, tableInseritiObject);
		writeLog("Where per eslcudere alcuni record --> " + where);
		try {
			contatti = PersistentObject.retrieveList(dataObject, where, "", false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		writeLog("Ho trovato : " + contatti.size() + " dati da leggere");
		return contatti;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<PersistentObject> getListDataObjectsToEdit() {
		List contatti = new ArrayList<PersistentObject>();
		String where = getWhereExcludeData(dataObject, tableInseritiObject);
		if (where.contains("AND NOT EXIST")) {
			where = where.replace("AND NOT EXIST", "AND EXIST");
		}
		try {
			contatti = PersistentObject.retrieveList(dataObject, where, "", false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contatti;
	}

	public String getValueFromExecutedMethod(Object targetObject, String methodChain) {
		String value = "";
		try {
			Object ret = executeMethodChain(targetObject, methodChain);
			value = ret != null ? ret.toString() : "";
			if (ret != null) {
				if (ret instanceof Date) {
					SimpleDateFormat formatSls2App = new SimpleDateFormat("dd-MM-YYYY");
					value = formatSls2App.format(ret);
				}
				if (ret instanceof Time) {
					SimpleDateFormat formatSls2App = new SimpleDateFormat("HH:mm");
					value = formatSls2App.format(ret);
				}
			}
		} catch (Exception e) {
			writeLog("Il metodo :" + methodChain + " ha ritornato null.");
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	public String getJSONAdd(Object obj) {
		JsonObject jsonObject = new JsonObject();
		Iterator<YConnDescrJsonStructure> iterStructure = this.getDescriptor().getYJsonStructure().iterator();
		while (iterStructure.hasNext()) {
			YConnDescrJsonStructure jsonStructure = (YConnDescrJsonStructure) iterStructure.next();
			if (jsonStructure.getDefaultValue() != null && jsonStructure.getValore() == null) {
				if (jsonStructure.getDefaultValue() != null) {
					jsonObject.addProperty(jsonStructure.getChiaveValore(), jsonStructure.getDefaultValue().toString());
				} else {
					jsonObject.addProperty(jsonStructure.getChiaveValore(), jsonStructure.getDefaultValue());
				}
			} else {
				jsonObject.addProperty(jsonStructure.getChiaveValore(),
						getValueFromExecutedMethod(obj, jsonStructure.getValore()));
			}

		}
		if (getDescriptor().getIdFunzione().contains("contacts")) {
			String idAngrafico = getValueFromExecutedMethod(obj, "getIdAnagrafico");
			String hashCustomer = getHashCustomer(Integer.valueOf(idAngrafico));
			if (hashCustomer != null && !hashCustomer.isEmpty()) {
				jsonObject.addProperty("customer", hashCustomer);
			} else {
				return null;
			}
		}
		if (obj instanceof ClientePrimrose) {
			// gestione utenti agenti
			ClientePrimrose cliente = (ClientePrimrose) obj;
			try {
				if (cliente.getClienteVendita().getAgente() != null) {
					YLegameAgenteUtente legame = (YLegameAgenteUtente) YLegameAgenteUtente.elementWithKey(
							YLegameAgenteUtente.class, cliente.getClienteVendita().getAgenteKey(),
							PersistentObject.NO_LOCK);
					if (legame != null) {
						YUtentiSales2App utente = legame.getUtente();
						if (utente != null) {
							jsonObject.addProperty("assigns", utente.getId()); // utente di assegnazione
						}
					} else {
						jsonObject.addProperty("assigns", persDatiConnettore.getUtenteJolly().getId());
					}
				} else {
					jsonObject.addProperty("assigns", persDatiConnettore.getUtenteJolly().getId());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}

	@SuppressWarnings("unchecked")
	public String getJSONAddByDescriptor(Object obj, YConnDescriptor descriptor) {
		JsonObject jsonObject = new JsonObject();
		Iterator<YConnDescrJsonStructure> iterStructure = descriptor.getYJsonStructure().iterator();
		while (iterStructure.hasNext()) {
			YConnDescrJsonStructure jsonStructure = (YConnDescrJsonStructure) iterStructure.next();
			if (jsonStructure.getDefaultValue() != null && jsonStructure.getValore() == null) {
				if (jsonStructure.getDefaultValue() != null) {
					jsonObject.addProperty(jsonStructure.getChiaveValore(), jsonStructure.getDefaultValue().toString());
				} else {
					jsonObject.addProperty(jsonStructure.getChiaveValore(), jsonStructure.getDefaultValue());
				}
			} else {
				jsonObject.addProperty(jsonStructure.getChiaveValore(),
						getValueFromExecutedMethod(obj, jsonStructure.getValore()));
			}

		}
		return jsonObject.toString();
	}

	@SuppressWarnings("rawtypes")
	public String getHashCustomer(Integer idAnagrafico) {
		String where = " " + ClienteVenditaTM.R_ANAGRAFICO + " = '" + idAnagrafico + "' ";
		try {
			Vector cli = ClienteVendita.retrieveList(where, "", false);
			if (cli.size() > 0) {
				ClienteVendita cl = (ClienteVendita) cli.get(0);
				YClientiInseriti trovoHash = (YClientiInseriti) YClientiInseriti.elementWithKey(YClientiInseriti.class,
						KeyHelper.buildObjectKey(new String[] { Azienda.getAziendaCorrente(), cl.getIdCliente() }), 0);
				if (trovoHash != null) {
					return trovoHash.getHash();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";

	}

	public static String getCustomerByHash(String hash) {
		ResultSet rs = null;
		CachedStatement cs = null;
		String stmt = " SELECT " + YClientiInseritiTM.ID_CLIENTE + " FROM " + YClientiInseritiTM.TABLE_NAME + " "
				+ "WHERE " + YClientiInseritiTM.HASH + " = '" + hash + "' ";
		try {
			cs = new CachedStatement(stmt);
			rs = cs.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static YAttivitaSales2App getActivityByHash(String hash) {
		ResultSet rs = null;
		CachedStatement cs = null;
		String stmt = " SELECT " + YAttivitaSales2AppTM.ID_PROGRESSIVO + "," + YAttivitaSales2AppTM.ID_AZIENDA
				+ " FROM " + YAttivitaSales2AppTM.TABLE_NAME + " " + "WHERE " + YAttivitaSales2AppTM.HASH + " = '"
				+ hash + "' ";
		try {
			cs = new CachedStatement(stmt);
			rs = cs.executeQuery();
			if (rs.next()) {
				String c = KeyHelper.buildObjectKey(new String[] { rs.getString(YAttivitaSales2AppTM.ID_AZIENDA),
						rs.getString(YAttivitaSales2AppTM.ID_PROGRESSIVO) });
				if (c != null) {
					return (YAttivitaSales2App) YAttivitaSales2App.elementWithKey(YAttivitaSales2App.class, c,
							PersistentObject.NO_LOCK);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public ClienteVendita getClienteByAnagrafico(Integer idAnagrafico) {
		String where = " " + ClienteVenditaTM.R_ANAGRAFICO + " = '" + idAnagrafico + "' ";
		try {
			Vector cli = ClienteVendita.retrieveList(where, "", false);
			if (cli.size() > 0) {
				return (ClienteVendita) cli.get(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public enum TipiAccount {
		CLIENTE(1), PROSPECT(2), FORNITORE(3), PARTNER(4), RIVENDITORE(7), DISTRIBUTORE(9);

		private int value;

		private TipiAccount(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

}
