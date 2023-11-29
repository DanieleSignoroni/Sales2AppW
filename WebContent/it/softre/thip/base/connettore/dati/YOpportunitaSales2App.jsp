<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///W:\PthDev\Projects\Panthera\PthSales2App\WebContent\dtd/xhtml1-transitional.dtd">
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
  BODataCollector YOpportunitaSales2AppBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YOpportunitaSales2AppForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YOpportunitaSales2AppForm", "YOpportunitaSales2App", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/softre/thip/base/connettore/dati/YOpportunitaSales2App.js"); 
  YOpportunitaSales2AppForm.setServletEnvironment(se); 
  YOpportunitaSales2AppForm.setJSTypeList(jsList); 
  YOpportunitaSales2AppForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YOpportunitaSales2AppForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YOpportunitaSales2AppForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YOpportunitaSales2AppForm.getMode(); 
  String key = YOpportunitaSales2AppForm.getKey(); 
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
        YOpportunitaSales2AppForm.outTraceInfo(getClass().getName()); 
        String collectorName = YOpportunitaSales2AppForm.findBODataCollectorName(); 
                YOpportunitaSales2AppBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YOpportunitaSales2AppBODC instanceof WebDataCollector) 
            ((WebDataCollector)YOpportunitaSales2AppBODC).setServletEnvironment(se); 
        YOpportunitaSales2AppBODC.initialize("YOpportunitaSales2App", true, 0); 
        YOpportunitaSales2AppForm.setBODataCollector(YOpportunitaSales2AppBODC); 
        int rcBODC = YOpportunitaSales2AppForm.initSecurityServices(); 
        mode = YOpportunitaSales2AppForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YOpportunitaSales2AppForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YOpportunitaSales2AppBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YOpportunitaSales2AppForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YOpportunitaSales2AppForm); 
   request.setAttribute("menuBar", menuBar); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="menuBar"/> 
</jsp:include> 
<% 
  menuBar.write(out); 
  menuBar.writeChildren(out); 
%> 
<% 
  WebToolBar myToolBarTB = new com.thera.thermfw.web.WebToolBar("myToolBar", "24", "24", "16", "16", "#f7fbfd","#C8D6E1"); 
  myToolBarTB.setParent(YOpportunitaSales2AppForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YOpportunitaSales2AppForm.getBodyOnBeforeUnload()%>" onload="<%=YOpportunitaSales2AppForm.getBodyOnLoad()%>" onunload="<%=YOpportunitaSales2AppForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YOpportunitaSales2AppForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YOpportunitaSales2AppForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YOpportunitaSales2AppBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YOpportunitaSales2AppForm.getServlet()%>" method="post" name="YOpportunitaSales2AppForm" style="height:100%"><%
  YOpportunitaSales2AppForm.writeFormStartElements(out); 
%>

      <table cellpadding="0" cellspacing="0" height="100%" id="emptyborder" width="100%">
        <tr>
          <td style="height:0">
            <% menuBar.writeElements(out); %> 

          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% myToolBarTB.writeChildren(out); %> 

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput YOpportunitaSales2AppHash =  
     new com.thera.thermfw.web.WebTextInput("YOpportunitaSales2App", "Hash"); 
  YOpportunitaSales2AppHash.setParent(YOpportunitaSales2AppForm); 
%>
<input class="<%=YOpportunitaSales2AppHash.getClassType()%>" id="<%=YOpportunitaSales2AppHash.getId()%>" maxlength="<%=YOpportunitaSales2AppHash.getMaxLength()%>" name="<%=YOpportunitaSales2AppHash.getName()%>" size="<%=YOpportunitaSales2AppHash.getSize()%>" type="hidden"><% 
  YOpportunitaSales2AppHash.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td height="100%">
            <!--<span class="tabbed" id="mytabbed">-->
<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="padding-right:1px">
   <tr valign="top">
     <td><% 
  WebTabbed mytabbed = new com.thera.thermfw.web.WebTabbed("mytabbed", "100%", "100%"); 
  mytabbed.setParent(YOpportunitaSales2AppForm); 
 mytabbed.addTab("tab1", "it.softre.thip.base.connettore.dati.resources.YOpportunitaSales2App", "tab1", "YOpportunitaSales2App", null, null, null, null); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;">
              <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab1")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab1"); %>
                <table style="width: 100%;">
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YOpportunitaSales2App", "Title", null); 
   label.setParent(YOpportunitaSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="Title"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YOpportunitaSales2AppTitle =  
     new com.thera.thermfw.web.WebTextInput("YOpportunitaSales2App", "Title"); 
  YOpportunitaSales2AppTitle.setParent(YOpportunitaSales2AppForm); 
%>
<input class="<%=YOpportunitaSales2AppTitle.getClassType()%>" id="<%=YOpportunitaSales2AppTitle.getId()%>" maxlength="<%=YOpportunitaSales2AppTitle.getMaxLength()%>" name="<%=YOpportunitaSales2AppTitle.getName()%>" size="<%=YOpportunitaSales2AppTitle.getSize()%>"><% 
  YOpportunitaSales2AppTitle.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YOpportunitaSales2App", "Status", null); 
   label.setParent(YOpportunitaSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="Status"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebComboBox YOpportunitaSales2AppStatus =  
     new com.thera.thermfw.web.WebComboBox("YOpportunitaSales2App", "Status", null); 
  YOpportunitaSales2AppStatus.setParent(YOpportunitaSales2AppForm); 
%>
<select id="<%=YOpportunitaSales2AppStatus.getId()%>" name="<%=YOpportunitaSales2AppStatus.getName()%>"><% 
  YOpportunitaSales2AppStatus.write(out); 
%> 
</select>
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YOpportunitaSales2App", "RAttivita", null); 
   label.setParent(YOpportunitaSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="Attivita"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YOpportunitaSales2AppAttivita =  
     new com.thera.thermfw.web.WebMultiSearchForm("YOpportunitaSales2App", "Attivita", false, false, true, 1, null, null); 
  YOpportunitaSales2AppAttivita.setParent(YOpportunitaSales2AppForm); 
  YOpportunitaSales2AppAttivita.write(out); 
%>
<!--<span class="multisearchform" id="Attivita"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YOpportunitaSales2App", "RClientePth", null); 
   label.setParent(YOpportunitaSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="Cliente"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YOpportunitaSales2AppCliente =  
     new com.thera.thermfw.web.WebMultiSearchForm("YOpportunitaSales2App", "Cliente", false, false, true, 1, null, null); 
  YOpportunitaSales2AppCliente.setParent(YOpportunitaSales2AppForm); 
  YOpportunitaSales2AppCliente.write(out); 
%>
<!--<span class="multisearchform" id="Cliente"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YOpportunitaSales2App", "Description", null); 
   label.setParent(YOpportunitaSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="Description"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YOpportunitaSales2AppDescription =  
     new com.thera.thermfw.web.WebTextArea("YOpportunitaSales2App", "Description"); 
  YOpportunitaSales2AppDescription.setParent(YOpportunitaSales2AppForm); 
%>
<textarea class="<%=YOpportunitaSales2AppDescription.getClassType()%>" cols="60" id="<%=YOpportunitaSales2AppDescription.getId()%>" maxlength="<%=YOpportunitaSales2AppDescription.getMaxLength()%>" name="<%=YOpportunitaSales2AppDescription.getName()%>" rows="5" size="<%=YOpportunitaSales2AppDescription.getSize()%>"></textarea><% 
  YOpportunitaSales2AppDescription.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YOpportunitaSales2App", "SuccessRate", null); 
   label.setParent(YOpportunitaSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="SuccessRate"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YOpportunitaSales2AppSuccessRate =  
     new com.thera.thermfw.web.WebTextInput("YOpportunitaSales2App", "SuccessRate"); 
  YOpportunitaSales2AppSuccessRate.setParent(YOpportunitaSales2AppForm); 
%>
<input class="<%=YOpportunitaSales2AppSuccessRate.getClassType()%>" id="<%=YOpportunitaSales2AppSuccessRate.getId()%>" maxlength="<%=YOpportunitaSales2AppSuccessRate.getMaxLength()%>" name="<%=YOpportunitaSales2AppSuccessRate.getName()%>" size="<%=YOpportunitaSales2AppSuccessRate.getSize()%>"><% 
  YOpportunitaSales2AppSuccessRate.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YOpportunitaSales2App", "EconomicValue", null); 
   label.setParent(YOpportunitaSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="EconomicValue"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YOpportunitaSales2AppEconomicValue =  
     new com.thera.thermfw.web.WebTextInput("YOpportunitaSales2App", "EconomicValue"); 
  YOpportunitaSales2AppEconomicValue.setParent(YOpportunitaSales2AppForm); 
%>
<input class="<%=YOpportunitaSales2AppEconomicValue.getClassType()%>" id="<%=YOpportunitaSales2AppEconomicValue.getId()%>" maxlength="<%=YOpportunitaSales2AppEconomicValue.getMaxLength()%>" name="<%=YOpportunitaSales2AppEconomicValue.getName()%>" size="<%=YOpportunitaSales2AppEconomicValue.getSize()%>"><% 
  YOpportunitaSales2AppEconomicValue.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YOpportunitaSales2App", "EconomicValueRecurr", null); 
   label.setParent(YOpportunitaSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="EconomicValueRecurr"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YOpportunitaSales2AppEconomicValueRecurr =  
     new com.thera.thermfw.web.WebTextInput("YOpportunitaSales2App", "EconomicValueRecurr"); 
  YOpportunitaSales2AppEconomicValueRecurr.setParent(YOpportunitaSales2AppForm); 
%>
<input class="<%=YOpportunitaSales2AppEconomicValueRecurr.getClassType()%>" id="<%=YOpportunitaSales2AppEconomicValueRecurr.getId()%>" maxlength="<%=YOpportunitaSales2AppEconomicValueRecurr.getMaxLength()%>" name="<%=YOpportunitaSales2AppEconomicValueRecurr.getName()%>" size="<%=YOpportunitaSales2AppEconomicValueRecurr.getSize()%>"><% 
  YOpportunitaSales2AppEconomicValueRecurr.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YOpportunitaSales2App", "Note", null); 
   label.setParent(YOpportunitaSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="Note"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YOpportunitaSales2AppNote =  
     new com.thera.thermfw.web.WebTextArea("YOpportunitaSales2App", "Note"); 
  YOpportunitaSales2AppNote.setParent(YOpportunitaSales2AppForm); 
%>
<textarea class="<%=YOpportunitaSales2AppNote.getClassType()%>" cols="60" id="<%=YOpportunitaSales2AppNote.getId()%>" maxlength="<%=YOpportunitaSales2AppNote.getMaxLength()%>" name="<%=YOpportunitaSales2AppNote.getName()%>" rows="5" size="<%=YOpportunitaSales2AppNote.getSize()%>"></textarea><% 
  YOpportunitaSales2AppNote.write(out); 
%>

                    </td>
                  </tr>
                </table>
              <% mytabbed.endTab(); %> 
</div>
            </div><% mytabbed.endTabbed();%> 

     </td>
   </tr>
</table><!--</span>-->
          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(YOpportunitaSales2AppForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YOpportunitaSales2AppForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YOpportunitaSales2AppForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YOpportunitaSales2AppBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YOpportunitaSales2AppForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YOpportunitaSales2AppBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YOpportunitaSales2AppBODC.getErrorList().getErrors()); 
           if(YOpportunitaSales2AppBODC.getConflict() != null) 
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
     if(YOpportunitaSales2AppBODC != null && !YOpportunitaSales2AppBODC.close(false)) 
        errors.addAll(0, YOpportunitaSales2AppBODC.getErrorList().getErrors()); 
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
     String errorPage = YOpportunitaSales2AppForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YOpportunitaSales2AppBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YOpportunitaSales2AppForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
