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
  BODataCollector YSettoriInseritiBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YSettoriInseritiForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YSettoriInseritiForm", "YSettoriInseriti", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/softre/thip/base/connettori/tabelle/YSettoriInseriti.js"); 
  YSettoriInseritiForm.setServletEnvironment(se); 
  YSettoriInseritiForm.setJSTypeList(jsList); 
  YSettoriInseritiForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YSettoriInseritiForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YSettoriInseritiForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YSettoriInseritiForm.getMode(); 
  String key = YSettoriInseritiForm.getKey(); 
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
        YSettoriInseritiForm.outTraceInfo(getClass().getName()); 
        String collectorName = YSettoriInseritiForm.findBODataCollectorName(); 
                YSettoriInseritiBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YSettoriInseritiBODC instanceof WebDataCollector) 
            ((WebDataCollector)YSettoriInseritiBODC).setServletEnvironment(se); 
        YSettoriInseritiBODC.initialize("YSettoriInseriti", true, 0); 
        YSettoriInseritiForm.setBODataCollector(YSettoriInseritiBODC); 
        int rcBODC = YSettoriInseritiForm.initSecurityServices(); 
        mode = YSettoriInseritiForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YSettoriInseritiForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YSettoriInseritiBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YSettoriInseritiForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YSettoriInseritiForm); 
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
  myToolBarTB.setParent(YSettoriInseritiForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YSettoriInseritiForm.getBodyOnBeforeUnload()%>" onload="<%=YSettoriInseritiForm.getBodyOnLoad()%>" onunload="<%=YSettoriInseritiForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YSettoriInseritiForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YSettoriInseritiForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YSettoriInseritiBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YSettoriInseritiForm.getServlet()%>" method="post" name="YSettoriInseritiForm" style="height:100%"><%
  YSettoriInseritiForm.writeFormStartElements(out); 
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
  WebTextInput YSettoriInseritiIdAzienda =  
     new com.thera.thermfw.web.WebTextInput("YSettoriInseriti", "IdAzienda"); 
  YSettoriInseritiIdAzienda.setParent(YSettoriInseritiForm); 
%>
<input class="<%=YSettoriInseritiIdAzienda.getClassType()%>" id="<%=YSettoriInseritiIdAzienda.getId()%>" maxlength="<%=YSettoriInseritiIdAzienda.getMaxLength()%>" name="<%=YSettoriInseritiIdAzienda.getName()%>" size="<%=YSettoriInseritiIdAzienda.getSize()%>" type="hidden"><% 
  YSettoriInseritiIdAzienda.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td>
            <% 
  WebTextInput YSettoriInseritiHash =  
     new com.thera.thermfw.web.WebTextInput("YSettoriInseriti", "Hash"); 
  YSettoriInseritiHash.setParent(YSettoriInseritiForm); 
%>
<input class="<%=YSettoriInseritiHash.getClassType()%>" id="<%=YSettoriInseritiHash.getId()%>" maxlength="<%=YSettoriInseritiHash.getMaxLength()%>" name="<%=YSettoriInseritiHash.getName()%>" size="<%=YSettoriInseritiHash.getSize()%>" type="hidden"><% 
  YSettoriInseritiHash.write(out); 
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
  mytabbed.setParent(YSettoriInseritiForm); 
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
  errorList.setParent(YSettoriInseritiForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YSettoriInseritiForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YSettoriInseritiForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YSettoriInseritiBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YSettoriInseritiForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YSettoriInseritiBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YSettoriInseritiBODC.getErrorList().getErrors()); 
           if(YSettoriInseritiBODC.getConflict() != null) 
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
     if(YSettoriInseritiBODC != null && !YSettoriInseritiBODC.close(false)) 
        errors.addAll(0, YSettoriInseritiBODC.getErrorList().getErrors()); 
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
     String errorPage = YSettoriInseritiForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YSettoriInseritiBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YSettoriInseritiForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
