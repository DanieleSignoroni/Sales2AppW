<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///K:/Thip/4.7.0/websrcsvil/dtd/xhtml1-transitional.dtd">
<html>
<!-- WIZGEN Therm 2.0.0 as Form - multiBrowserGen = true -->
<%=WebGenerator.writeRuntimeInfo()%>
<head>
<%@ page contentType="text/html; charset=Cp1252"%>
<%@ page import= " 
  java.sql.*, 
  java.util.*, 
  java.lang.reflect.*, 
  javax.naming.*, 
  com.thera.thermfw.common.*, 
  com.thera.thermfw.type.*, 
  com.thera.thermfw.web.*, 
  com.thera.thermfw.security.*, 
  com.thera.thermfw.base.*, 
  com.thera.thermfw.ad.*, 
  com.thera.thermfw.persist.*, 
  com.thera.thermfw.gui.cnr.*, 
  com.thera.thermfw.setting.*, 
  com.thera.thermfw.collector.*, 
  com.thera.thermfw.batch.web.*, 
  com.thera.thermfw.batch.*, 
  com.thera.thermfw.pref.* 
"%> 
<%
  ServletEnvironment se = (ServletEnvironment)Factory.createObject("com.thera.thermfw.web.ServletEnvironment"); 
  BODataCollector YConnDescriptorBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YConnDescriptorForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YConnDescriptorForm", "YConnDescriptor", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/softre/thip/base/connettori/descrittori/YConnDescriptor.js"); 
  YConnDescriptorForm.setServletEnvironment(se); 
  YConnDescriptorForm.setJSTypeList(jsList); 
  YConnDescriptorForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YConnDescriptorForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YConnDescriptorForm.setWebFormModifierClass("it.softre.thip.base.connettori.descrittori.web.YConnDescriptorFormModifier"); 
  YConnDescriptorForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YConnDescriptorForm.getMode(); 
  String key = YConnDescriptorForm.getKey(); 
  String errorMessage; 
  boolean requestIsValid = false; 
  boolean leftIsKey = false; 
  boolean conflitPresent = false; 
  String leftClass = ""; 
  try 
  {
     se.initialize(request, response); 
     if(se.begin()) 
     { 
        YConnDescriptorForm.outTraceInfo(getClass().getName()); 
        String collectorName = YConnDescriptorForm.findBODataCollectorName(); 
                YConnDescriptorBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YConnDescriptorBODC instanceof WebDataCollector) 
            ((WebDataCollector)YConnDescriptorBODC).setServletEnvironment(se); 
        YConnDescriptorBODC.initialize("YConnDescriptor", true, 0); 
        YConnDescriptorForm.setBODataCollector(YConnDescriptorBODC); 
        int rcBODC = YConnDescriptorForm.initSecurityServices(); 
        mode = YConnDescriptorForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YConnDescriptorForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YConnDescriptorBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YConnDescriptorForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YConnDescriptorForm); 
   request.setAttribute("menuBar", menuBar); 
%> 
<jsp:include page="/com/thera/thermfw/common/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="menuBar"/> 
</jsp:include> 
<% 
  menuBar.write(out); 
  menuBar.writeChildren(out); 
%> 
<% 
  WebToolBar myToolBarTB = new com.thera.thermfw.web.WebToolBar("myToolBar", "24", "24", "16", "16", "#f7fbfd","#C8D6E1"); 
  myToolBarTB.setParent(YConnDescriptorForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/com/thera/thermfw/common/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
<body onbeforeunload="<%=YConnDescriptorForm.getBodyOnBeforeUnload()%>" onload="<%=YConnDescriptorForm.getBodyOnLoad()%>" onunload="<%=YConnDescriptorForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YConnDescriptorForm.writeBodyStartElements(out); 
%> 

	<table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YConnDescriptorForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YConnDescriptorBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YConnDescriptorForm.getServlet()%>" method="post" name="YConnDescriptorForm" style="height:100%"><%
  YConnDescriptorForm.writeFormStartElements(out); 
%>

		<table cellpadding="0" cellspacing="0" height="100%" id="emptyborder" width="100%">
			<tr>
				<td style="height: 0"><% menuBar.writeElements(out); %> 
</td>
			</tr>
			<tr>
				<td style="height: 0"><% myToolBarTB.writeChildren(out); %> 
</td>
			</tr>
			<tr>
				<td height="100%"><!--<span class="tabbed" id="mytabbed">-->
<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="padding-right:1px">
   <tr valign="top">
     <td><% 
  WebTabbed mytabbed = new com.thera.thermfw.web.WebTabbed("mytabbed", "100%", "100%"); 
  mytabbed.setParent(YConnDescriptorForm); 
 mytabbed.addTab("tab1", "it.softre.thip.base.connettori.descrittori.resources.YConnDescriptor", "tab1", "YConnDescriptor", null, null, null, null); 
 mytabbed.addTab("tab2", "it.softre.thip.base.connettori.descrittori.resources.YConnDescriptor", "tab2", "YConnDescriptor", null, null, null, null); 
 mytabbed.addTab("tab3", "it.softre.thip.base.connettori.descrittori.resources.YConnDescriptor", "tab3", "YConnDescriptor", null, null, null, null); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;"> <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab1")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab1"); %>
							<table style="width: 100%;">
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YConnDescriptor", "IdFunzione", null); 
   label.setParent(YConnDescriptorForm); 
%><label class="<%=label.getClassType()%>" for="Funzione"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebMultiSearchForm YConnDescriptorFunzione =  
     new com.thera.thermfw.web.WebMultiSearchForm("YConnDescriptor", "Funzione", false, false, true, 1, null, null); 
  YConnDescriptorFunzione.setParent(YConnDescriptorForm); 
  YConnDescriptorFunzione.write(out); 
%>
<!--<span class="multisearchform" id="Funzione"></span>--></td>
								</tr>
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YConnDescriptor", "BusinessClass", null); 
   label.setParent(YConnDescriptorForm); 
%><label class="<%=label.getClassType()%>" for="BusinessClass"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebTextInput YConnDescriptorBusinessClass =  
     new com.thera.thermfw.web.WebTextArea("YConnDescriptor", "BusinessClass"); 
  YConnDescriptorBusinessClass.setParent(YConnDescriptorForm); 
%>
<textarea class="<%=YConnDescriptorBusinessClass.getClassType()%>" cols="60" id="<%=YConnDescriptorBusinessClass.getId()%>" maxlength="<%=YConnDescriptorBusinessClass.getMaxLength()%>" name="<%=YConnDescriptorBusinessClass.getName()%>" rows="5" size="<%=YConnDescriptorBusinessClass.getSize()%>"></textarea><% 
  YConnDescriptorBusinessClass.write(out); 
%>
</td>
								</tr>
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YConnDescriptor", "WhereEsclusioneDati", null); 
   label.setParent(YConnDescriptorForm); 
%><label class="<%=label.getClassType()%>" for="WhereEsclusioneDati"><%label.write(out);%></label><%}%>
									</td>
									<td valign="top"><% 
  WebTextInput YConnDescriptorWhereEsclusioneDati =  
     new com.thera.thermfw.web.WebTextArea("YConnDescriptor", "WhereEsclusioneDati"); 
  YConnDescriptorWhereEsclusioneDati.setParent(YConnDescriptorForm); 
%>
<textarea class="<%=YConnDescriptorWhereEsclusioneDati.getClassType()%>" cols="60" id="<%=YConnDescriptorWhereEsclusioneDati.getId()%>" maxlength="<%=YConnDescriptorWhereEsclusioneDati.getMaxLength()%>" name="<%=YConnDescriptorWhereEsclusioneDati.getName()%>" rows="5" size="<%=YConnDescriptorWhereEsclusioneDati.getSize()%>"></textarea><% 
  YConnDescriptorWhereEsclusioneDati.write(out); 
%>
</td>
								</tr>
								<tr>
									<td valign="top"><% 
  WebCheckBox YConnDescriptorAbilitato =  
     new com.thera.thermfw.web.WebCheckBox("YConnDescriptor", "Abilitato"); 
  YConnDescriptorAbilitato.setParent(YConnDescriptorForm); 
%>
<input id="<%=YConnDescriptorAbilitato.getId()%>" name="<%=YConnDescriptorAbilitato.getName()%>" type="checkbox" value="Y"><%
  YConnDescriptorAbilitato.write(out); 
%>
</td>
									<td valign="top"></td>
								</tr>
								<tr>
									<td valign="top"><% 
  WebCheckBox YConnDescriptorLogChiamate =  
     new com.thera.thermfw.web.WebCheckBox("YConnDescriptor", "LogChiamate"); 
  YConnDescriptorLogChiamate.setParent(YConnDescriptorForm); 
%>
<input id="<%=YConnDescriptorLogChiamate.getId()%>" name="<%=YConnDescriptorLogChiamate.getName()%>" type="checkbox" value="Y"><%
  YConnDescriptorLogChiamate.write(out); 
%>
</td>
									<td valign="top"></td>
								</tr>
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YConnDescriptor", "SequenzaLancio", null); 
   label.setParent(YConnDescriptorForm); 
%><label class="<%=label.getClassType()%>" for="SequenzaLancio"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebTextInput YConnDescriptorSequenzaLancio =  
     new com.thera.thermfw.web.WebTextInput("YConnDescriptor", "SequenzaLancio"); 
  YConnDescriptorSequenzaLancio.setParent(YConnDescriptorForm); 
%>
<input class="<%=YConnDescriptorSequenzaLancio.getClassType()%>" id="<%=YConnDescriptorSequenzaLancio.getId()%>" maxlength="<%=YConnDescriptorSequenzaLancio.getMaxLength()%>" name="<%=YConnDescriptorSequenzaLancio.getName()%>" size="<%=YConnDescriptorSequenzaLancio.getSize()%>"><% 
  YConnDescriptorSequenzaLancio.write(out); 
%>
</td>
								</tr>
								<tr>
									<td colspan="2" valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YConnDescriptor", null, "YJsonStructure"); 
   label.setParent(YConnDescriptorForm); 
%><label class="<%=label.getClassType()%>" for="YJsonStructure"><%label.write(out);%></label><%}%>
									</td>
								</tr>
								<tr>
									<td colspan="2" valign="top"><!--<span class="editgrid" id="YJsonStructure">--><% 
  WebEditGrid YConnDescriptorYJsonStructure =  
     new com.thera.thermfw.web.WebEditGrid("YConnDescriptor", "YJsonStructure", 8, new String[]{"ChiaveValore", "Valore", "DefaultValue"}, 1, null, null,false,"com.thera.thermfw.web.servlet.GridActionAdapterForIndependentRow"); 
 YConnDescriptorYJsonStructure.setParent(YConnDescriptorForm); 
 YConnDescriptorYJsonStructure.setNoControlRowKeys(false); 
 YConnDescriptorYJsonStructure.write(out); 
%>
<BR><% 
   request.setAttribute("parentForm", YConnDescriptorForm); 
   String CDForYJsonStructure = "YJsonStructure"; 
%>
<jsp:include page="/it/softre/thip/base/connettori/descrittori/YConnDescrJsonStructure.jsp" flush="true"> 
<jsp:param name="EditGridCDName" value="<%=CDForYJsonStructure%>"/> 
<jsp:param name="Mode" value="NEW"/> 
</jsp:include> 
<!--</span>--></td>
								</tr>
							</table>
					<% mytabbed.endTab(); %> 
</div> <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab2")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab2"); %>
							<table style="width: 100%;">
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YConnDescriptor", "BusinessClassTabella", null); 
   label.setParent(YConnDescriptorForm); 
%><label class="<%=label.getClassType()%>" for="BusinessClassTabella"><%label.write(out);%></label><%}%>
									</td>
									<td valign="top"><% 
  WebTextInput YConnDescriptorBusinessClassTabella =  
     new com.thera.thermfw.web.WebTextArea("YConnDescriptor", "BusinessClassTabella"); 
  YConnDescriptorBusinessClassTabella.setParent(YConnDescriptorForm); 
%>
<textarea class="<%=YConnDescriptorBusinessClassTabella.getClassType()%>" cols="60" id="<%=YConnDescriptorBusinessClassTabella.getId()%>" maxlength="<%=YConnDescriptorBusinessClassTabella.getMaxLength()%>" name="<%=YConnDescriptorBusinessClassTabella.getName()%>" rows="5" size="<%=YConnDescriptorBusinessClassTabella.getSize()%>"></textarea><% 
  YConnDescriptorBusinessClassTabella.write(out); 
%>
</td>
								</tr>
								<tr>
									<td colspan="2" valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YConnDescriptor", null, "YCampiTabellaInseriti"); 
   label.setParent(YConnDescriptorForm); 
%><label class="<%=label.getClassType()%>" for="YCampiTabellaInseriti"><%label.write(out);%></label><%}%></td>
								</tr>
								<tr>
									<td colspan="2" valign="top"><!--<span class="editgrid" id="YCampiTabellaInseriti">--><% 
  WebEditGrid YConnDescriptorYCampiTabellaInseriti =  
     new com.thera.thermfw.web.WebEditGrid("YConnDescriptor", "YCampiTabellaInseriti", 8, new String[]{"KeyValue", "IdFunzione", "Value", "DefaultValue"}, 1, null, null,false,"com.thera.thermfw.web.servlet.GridActionAdapterForIndependentRow"); 
 YConnDescriptorYCampiTabellaInseriti.setParent(YConnDescriptorForm); 
 YConnDescriptorYCampiTabellaInseriti.setNoControlRowKeys(false); 
 YConnDescriptorYCampiTabellaInseriti.write(out); 
%>
<BR><% 
   request.setAttribute("parentForm", YConnDescriptorForm); 
   String CDForYCampiTabellaInseriti = "YCampiTabellaInseriti"; 
%>
<jsp:include page="/it/softre/thip/base/connettori/descrittori/YConnDescrTableInsField.jsp" flush="true"> 
<jsp:param name="EditGridCDName" value="<%=CDForYCampiTabellaInseriti%>"/> 
<jsp:param name="Mode" value="NEW"/> 
</jsp:include> 
<!--</span>--></td>
								</tr>
							</table>
					<% mytabbed.endTab(); %> 
</div><div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab3")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab3"); %>
							<table style="width: 100%;">
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YConnDescriptor", "ClassTransformerJSON", null); 
   label.setParent(YConnDescriptorForm); 
%><label class="<%=label.getClassType()%>" for="ClassTransformerJSON"><%label.write(out);%></label><%}%>
									</td>
									<td valign="top"><% 
  WebTextInput YConnDescriptorClassTransformerJSON =  
     new com.thera.thermfw.web.WebTextArea("YConnDescriptor", "ClassTransformerJSON"); 
  YConnDescriptorClassTransformerJSON.setParent(YConnDescriptorForm); 
%>
<textarea class="<%=YConnDescriptorClassTransformerJSON.getClassType()%>" cols="60" id="<%=YConnDescriptorClassTransformerJSON.getId()%>" maxlength="<%=YConnDescriptorClassTransformerJSON.getMaxLength()%>" name="<%=YConnDescriptorClassTransformerJSON.getName()%>" rows="5" size="<%=YConnDescriptorClassTransformerJSON.getSize()%>"></textarea><% 
  YConnDescriptorClassTransformerJSON.write(out); 
%>
</td>
								</tr>
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YConnDescriptor", "IdJSONObjectToTransform", null); 
   label.setParent(YConnDescriptorForm); 
%><label class="<%=label.getClassType()%>" for="IdJSONObjectToTransform"><%label.write(out);%></label><%}%>
									</td>
									<td valign="top"><% 
  WebTextInput YConnDescriptorIdJSONObjectToTransform =  
     new com.thera.thermfw.web.WebTextInput("YConnDescriptor", "IdJSONObjectToTransform"); 
  YConnDescriptorIdJSONObjectToTransform.setParent(YConnDescriptorForm); 
%>
<input class="<%=YConnDescriptorIdJSONObjectToTransform.getClassType()%>" id="<%=YConnDescriptorIdJSONObjectToTransform.getId()%>" maxlength="<%=YConnDescriptorIdJSONObjectToTransform.getMaxLength()%>" name="<%=YConnDescriptorIdJSONObjectToTransform.getName()%>" size="<%=YConnDescriptorIdJSONObjectToTransform.getSize()%>"><% 
  YConnDescriptorIdJSONObjectToTransform.write(out); 
%>
</td>
								</tr>
							</table>
					<% mytabbed.endTab(); %> 
</div>
				</div><% mytabbed.endTabbed();%> 

     </td>
   </tr>
</table><!--</span>--></td>
			</tr>
			<tr>
				<td style="height: 0"><% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(YConnDescriptorForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>--></td>
			</tr>
		</table>
	<%
  YConnDescriptorForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YConnDescriptorForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YConnDescriptorBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


<%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YConnDescriptorForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YConnDescriptorBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YConnDescriptorBODC.getErrorList().getErrors()); 
           if(YConnDescriptorBODC.getConflict() != null) 
                conflitPresent = true; 
     } 
     else 
        errors.add(new ErrorMessage("BAS0000010")); 
  } 
  catch(NamingException e) { 
     errorMessage = e.getMessage(); 
     errors.add(new ErrorMessage("CBS000025", errorMessage));  } 
  catch(SQLException e) {
     errorMessage = e.getMessage(); 
     errors.add(new ErrorMessage("BAS0000071", errorMessage));  } 
  catch(Throwable e) {
     e.printStackTrace(Trace.excStream);
  }
  finally 
  {
     if(YConnDescriptorBODC != null && !YConnDescriptorBODC.close(false)) 
        errors.addAll(0, YConnDescriptorBODC.getErrorList().getErrors()); 
     try 
     { 
        se.end(); 
     }
     catch(IllegalArgumentException e) { 
        e.printStackTrace(Trace.excStream); 
     } 
     catch(SQLException e) { 
        e.printStackTrace(Trace.excStream); 
     } 
  } 
  if(!errors.isEmpty())
  { 
      if(!conflitPresent)
  { 
     request.setAttribute("ErrorMessages", errors); 
     String errorPage = YConnDescriptorForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YConnDescriptorBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YConnDescriptorForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
