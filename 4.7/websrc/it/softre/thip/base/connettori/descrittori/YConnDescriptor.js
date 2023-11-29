function YConnDescriptorOL() {
	redefinesendAjax();
}

function redefinesendAjax() {
	var oldEditGridNewRow = editGridNewRow;
	editGridNewRow = function(gridClassCD) {
		if (gridClassCD == 'YJsonStructure') {
			document.getElementById('BOAttributeName').addEventListener('change', function() {
				document.getElementById('YJsonStructure$$Valore').value = this.value;
			});
			var className = document.getElementById('BusinessClass').value;
			loadBoAttributes('get', className, 'BOAttributeName');
		} else if (gridClassCD == 'YCampiTabellaInseriti') {
			document.getElementById('getAttributeTabIns').addEventListener('change', function() {
				document.getElementById('YCampiTabellaInseriti$$Value').value = this.value;
			});
			loadBoAttributesGetter('get', className, 'getAttributeTabIns');
			var className = document.getElementById('BusinessClassTabella').value;
			document.getElementById('setAttributeTabIns').addEventListener('change', function() {
				document.getElementById('YCampiTabellaInseriti$$KeyValue').value = this.value;
			});
			var className = document.getElementById('BusinessClassTabella').value;
		}
		oldEditGridNewRow(gridClassCD);
	}
	var oldEditGridSelectedRow = editGridSelectRow;
	editGridSelectRow = function(gridClassCD, rowNum, colNum) {
		if (gridClassCD == 'YJsonStructure') {
			document.getElementById('BOAttributeName').addEventListener('change', function() {
				document.getElementById('YJsonStructure$$Valore').value = this.value;
			});
			var className = document.getElementById('BusinessClass').value;
			loadBoAttributes('get', className, 'BOAttributeName');
			var getPresente = document.getElementById('YJsonStructure$$Valore').value;
			if (getPresente != null && getPresente != undefined) {
				document.getElementById('BOAttributeName').value = document.getElementById('BOAttributeName').value;
			}
		} else if (gridClassCD == 'YCampiTabellaInseriti') {
			document.getElementById('getAttributeTabIns').addEventListener('change', function() {
				document.getElementById('YCampiTabellaInseriti$$Value').value = this.value;
			});
			document.getElementById('setAttributeTabIns').addEventListener('change', function() {
				document.getElementById('YCampiTabellaInseriti$$KeyValue').value = this.value;
			});
			//funzioni di getter
			var className = document.getElementById('BusinessClassTabella').value;
			loadBoAttributesGetter('get', className, 'getAttributeTabIns');
			var getPresente = document.getElementById('YCampiTabellaInseriti$$Value').value;
			if (getPresente != null && getPresente != undefined) {
				document.getElementById('getAttributeTabIns').value = document.getElementById('getAttributeTabIns').value;
			}
			//funzioni di settaggio
			var getPresente = document.getElementById('YCampiTabellaInseriti$$KeyValue').value;
			if (getPresente != null && getPresente != undefined) {
				document.getElementById('setAttributeTabIns').value = document.getElementById('setAttributeTabIns').value;
			}
		}
		oldEditGridSelectedRow(gridClassCD, rowNum, colNum);
	}
}

function loadBoAttributesGetter(method, className, comboId) {
	var key = document.getElementById('thKey').value;
	var url = "/" + webAppPath + "/" + servletPath + "/it.softre.thip.base.connettori.descrittori.web.YMethodsLoaderTabellaInseriti";
	url += "?ClassName=" + className;
	url += "&thKey="+key;
	var f = document.getElementById(errorsFrameName).contentWindow;
	setLocationOnWindow(f, url);
}

function loadBoAttributes(method, className, comboId) {
	var url = "/" + webAppPath + "/" + servletPath + "/it.softre.thip.base.connettori.descrittori.web.YMethodsLoader";
	url += "?ClassName=" + className;
	url += "&Method=" + method;
	url += "&ComboId=" + comboId;
	var f = document.getElementById(errorsFrameName).contentWindow;
	setLocationOnWindow(f, url);
}

function addBoAtt(name, selected, comboId) {
	var combo = document.getElementById(comboId);
	addOption(combo, name, name, selected);
}

function clearBoAtt() {
	clearCombobox('BOAttributeName');
}

function addOption(field, value, description, selected) {
	var option = new Option(value, description);
	option.selected = selected;
	field.options[field.options.length] = option;
}
