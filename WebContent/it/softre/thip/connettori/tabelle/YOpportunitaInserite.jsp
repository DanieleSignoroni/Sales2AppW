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
  BODataCollector YOpportunitaInseriteBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YOpportunitaInseriteForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YOpportunitaInseriteForm", "YOpportunitaInserite", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/softre/thip/connettori/tabelle/YOpportunitaInserite.js"); 
  YOpportunitaInseriteForm.setServletEnvironment(se); 
  YOpportunitaInseriteForm.setJSTypeList(jsList); 
  YOpportunitaInseriteForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YOpportunitaInseriteForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YOpportunitaInseriteForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YOpportunitaInseriteForm.getMode(); 
  String key = YOpportunitaInseriteForm.getKey(); 
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
        YOpportunitaInseriteForm.outTraceInfo(getClass().getName()); 
        String collectorName = YOpportunitaInseriteForm.findBODataCollectorName(); 
                YOpportunitaInseriteBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YOpportunitaInseriteBODC instanceof WebDataCollector) 
            ((WebDataCollector)YOpportunitaInseriteBODC).setServletEnvironment(se); 
        YOpportunitaInseriteBODC.initialize("YOpportunitaInserite", true, 0); 
        YOpportunitaInseriteForm.setBODataCollector(YOpportunitaInseriteBODC); 
        int rcBODC = YOpportunitaInseriteForm.initSecurityServices(); 
        mode = YOpportunitaInseriteForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YOpportunitaInseriteForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YOpportunitaInseriteBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YOpportunitaInseriteForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YOpportunitaInseriteForm); 
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
  myToolBarTB.setParent(YOpportunitaInseriteForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YOpportunitaInseriteForm.getBodyOnBeforeUnload()%>" onload="<%=YOpportunitaInseriteForm.getBodyOnLoad()%>" onunload="<%=YOpportunitaInseriteForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YOpportunitaInseriteForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YOpportunitaInseriteForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YOpportunitaInseriteBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YOpportunitaInseriteForm.getServlet()%>" method="post" name="YOpportunitaInseriteForm" style="height:100%"><%
  YOpportunitaInseriteForm.writeFormStartElements(out); 
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
  WebTextInput YOpportunitaInseriteIdAzienda =  
     new com.thera.thermfw.web.WebTextInput("YOpportunitaInserite", "IdAzienda"); 
  YOpportunitaInseriteIdAzienda.setParent(YOpportunitaInseriteForm); 
%>
<input class="<%=YOpportunitaInseriteIdAzienda.getClassType()%>" id="<%=YOpportunitaInseriteIdAzienda.getId()%>" maxlength="<%=YOpportunitaInseriteIdAzienda.getMaxLength()%>" name="<%=YOpportunitaInseriteIdAzienda.getName()%>" size="<%=YOpportunitaInseriteIdAzienda.getSize()%>" type="hidden"><% 
  YOpportunitaInseriteIdAzienda.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput YOpportunitaInseriteRHash =  
     new com.thera.thermfw.web.WebTextInput("YOpportunitaInserite", "RHash"); 
  YOpportunitaInseriteRHash.setParent(YOpportunitaInseriteForm); 
%>
<input class="<%=YOpportunitaInseriteRHash.getClassType()%>" id="<%=YOpportunitaInseriteRHash.getId()%>" maxlength="<%=YOpportunitaInseriteRHash.getMaxLength()%>" name="<%=YOpportunitaInseriteRHash.getName()%>" size="<%=YOpportunitaInseriteRHash.getSize()%>" type="hidden"><% 
  YOpportunitaInseriteRHash.write(out); 
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
  mytabbed.setParent(YOpportunitaInseriteForm); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;">
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
  errorList.setParent(YOpportunitaInseriteForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YOpportunitaInseriteForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YOpportunitaInseriteForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YOpportunitaInseriteBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YOpportunitaInseriteForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YOpportunitaInseriteBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YOpportunitaInseriteBODC.getErrorList().getErrors()); 
           if(YOpportunitaInseriteBODC.getConflict() != null) 
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
     if(YOpportunitaInseriteBODC != null && !YOpportunitaInseriteBODC.close(false)) 
        errors.addAll(0, YOpportunitaInseriteBODC.getErrorList().getErrors()); 
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
     String errorPage = YOpportunitaInseriteForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YOpportunitaInseriteBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YOpportunitaInseriteForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
