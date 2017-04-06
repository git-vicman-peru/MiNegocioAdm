<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon"/>
	<title>Gestor de suscripciones</title>
	<script src="resources/js/jquery-2.2.3.min.js"></script>
	<script src="resources/js/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<link href="resources/js/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="resources/js/bootstrap-3.3.7/css/bootstrap-theme.min.css" rel="stylesheet"/>
	<script src="resources/js/bootbox.min.js"></script>
	<link href="resources/styles/minegocioadm.css" rel="stylesheet"/>
	<style>
		#success_message{ display: none;}
		
		.bottomplus{
			margin-bottom: 13px;
		}
		hr { 
		    display: block;
		    color:white;
		    margin-top: 0.5em;
		    margin-bottom: 0.5em;
		    margin-left: auto;
		    margin-right: auto;
		    border-style: inset;
		    border-width: 1px;
		}
		 .puffed-up {
		 margin-left:5px;
		 margin-right:5px;
	    background-color:#E7DDDB;
	    border:1px solid #ccc;
	    border-bottom:2px solid #bbb;
	    border-top:1px solid #ddd;
	    border-radius:10px;
	    -webkit-border-radius:10px;
	    -moz-border-radius:10px;
	}
  
	</style>
	<script type="text/javascript">
	$(document).ready(function(){
		var srchUrl = "<c:out value='${searchUrl}'/>"; 
		$('#vouch_fecha').val(formattedDate(new Date()));
		var ssE = "<c:out value='${erref.getTag()}'/>";
		var empFields = ssE.split(";");
		var hasErrors = "<c:out value='${erref.getFlg()}'/>";
		if (hasErrors){
			var ctlName = "<c:out value='${erref.getFldName()}'/>";
			var errMsg = "<c:out value='${erref.getMsg()}'/>";
			Ctrl_SetErrorMode(ctlName, errMsg);
		}
		$('#frmSus').submit(function(){
			console.log("about to send ...");
			console.log("empFields: ");
			console.log(empFields);
			/*
			if (checkForErrors(empFields)){
				return false;
			}
			*/
			return true;
		});
		$('#bnBuscar').click(function(e){
			bootbox.prompt("Escriba lo que desea buscar:", function(result){ 
				console.log(result); 
			});
			e.preventDefault();
		});
		$('#bnVerLista').click(function(e){
			if (srchUrl){
				window.location.replace(srchUrl);
			}
			e.preventDefault();
		});
	});
	
	function checkForErrors(flds){
		for(var i=0; i<flds.length; i++){
			var fld = flds[i];
			var cref = document.getElementById(fld);
			Ctrl_ResetMode(fld);
			if (isNullOrEmpty($(cref))){
				Ctrl_SetErrorMode(fld, "No puede estar vacio.");
				return true;
			}
		}
		return false;
	}
	
	function Ctrl_SetErrorMode(ctname, msg){
		var div = $("[name='"+ctname+"']").closest('div');
		var formdiv = div.parent('.form-group');
		formdiv.addClass("has-error has-feedback");
		div.append("<span class='glyphicon glyphicon-remove form-control-feedback'></span>");
		div.append('<span class="help-block">'+msg+'</span>');
	}
	
	function Ctrl_ResetMode(ctname){
		var div = $("[name='"+ctname+"']").closest('div');
		var formdiv = div.parent('.form-group');
		div.find('span').remove();
		formdiv.removeClass("has-error has-feedback");
	}
	
	function isNullOrEmpty(inputCtrl){
		var v = inputCtrl.val();
		if ((v==null)||(v=="")){
			return true;
		}
		return false;
	}
	
	function formattedDate(date) {
	    var d = new Date(date || Date.now()),
	        month = '' + (d.getMonth() + 1),
	        day = '' + d.getDate(),
	        year = d.getFullYear();

	    if (month.length < 2) month = '0' + month;
	    if (day.length < 2) day = '0' + day;

	    return [month, day, year].join('/');
	}
	
	function hasDateFormat(sfecha){
		return ((sfecha.indexOf("/")>-1)||(sfecha.indexOf("-")>-1))
	}
	
	function getDateSep(sfecha){
		if (sfecha.indexOf("/")>-1){
			return "/";
		}
		if (sfecha.indexOf("-")>-1){
			return "-";
		}
		return "";
	}
	
	function isDateFormatOk(sfecha,ssep,spattern){
		var parts = sfecha.split(ssep);
		
	}
	
	function dateGetMonth(fechaParts){
		var y="2000";
		var m="12";
		var d="31";
		var v=0;
		for(var i=0; i<fechaParts.length; i++){
			if (fechaParts[i].length>3){
				y = fechaParts[i];
			}else{
				v = parseInt(fechaParts[i]);
				if (v <= 12){
					m = fechaParts[i];
				}else{
					d = fechaParts[i];
				}
			}
		}
	}
	
	</script>
</head>
<body>
<c:set var="activemenuitem" value="suscribir" scope="session" />
<%@include file="menu.jsp" %>
<div class="container pageborder">
<form id="frmSus" action="savesus" method="post" >
	<fieldset>
		<div class="row bottomplus">
			<div class="col-md-1"></div>
			<div class="col-md-5 puffed-up"><h4>Registro de suscripci&oacute;n</h4></div>
			<div class="col-md-1"></div>
			<div class="col-md-5 puffed-up"><h4>Credenciales</h4></div>
		</div>
		<div class="row">

					<div class="col-md-1"></div>
					<div class="col-md-5">
					
						<div class="form-group">
							<label class="control-label col-md-4 text-right" for="razonsocial">Raz&oacute;n social</label>
							<div class="input-group col-md-5">
								<input id="razonsocial" class="form-control" name="razonsocial" type="text" value="${sus.razonsocial}"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4 text-right" for="vouch_nro">vouch_nro</label>
							<div class="input-group col-md-4">
								<input id="vouch_nro" class="form-control" name="vouch_nro" type="text" value="${sus.vouch_nro}"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4 text-right" for="vouch_fecha">vouch_fecha</label>
							<div class="input-group col-md-4">
								<input id="vouch_fecha" class="form-control" name="vouch_fecha" type="date" value="${sus.vouch_fecha}"/>
							</div>
						</div>
						<div class="form-group">		
							<label class="control-label col-md-4 text-right" for="vouch_bank">vouch_bank</label>
							<div class="input-group col-md-5">
								<input id="vouch_bank" class="form-control" name="vouch_bank" type="text" value="${sus.vouch_bank}"/>
							</div>
						</div>	
						<div class="form-group">
							<label class="control-label col-md-4 text-right" for="vouch_monto">vouch_monto</label>
							<div class="input-group col-md-3">
								<input id="vouch_monto" class="form-control" name="vouch_monto" type="number" value="${sus.vouch_monto}"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4 text-right" for="tipo">Tipo</label>
							<div class="input-group col-md-4">
								<input id="tipo" class="form-control" name="tipo" type="text" value="${sus.tipo}" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4 text-right" for="activo">Activo</label>
							<div class="input-group col-md-4">
								<input id="activo" name="activo" type="checkbox" class="checkbox" value="${sus.activo}" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4 text-right" for="obs">Obs</label>
							<div class="input-group col-md-5">
								<input id="obs" class="form-control" name="obs" type="text" value="${sus.obs}"/>
							</div>
						</div>
						
					</div>
					<div class="col-md-1"></div>
					<div class="col-md-5">
						<div class="form-group">
							<label class="control-label col-md-4 text-right" for="usuario">Usuario:</label>
							<div class="input-group col-md-4">
								<input id="usuario" class="form-control" name="usuario" type="text" value="${acc.usuario}" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4 text-right" for="clave">Clave:</label>
							<div class="input-group col-md-4">
								<input id="clave" class="form-control" name="clave" type="text" value="${acc.clave}"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4 text-right" for="vigente">Vigente:</label>
							<div class="input-group col-md-4">
								<input id="vigente" class="checkbox" name="vigente" type="checkbox" value="${acc.vigente}" />
							</div>
						</div>
					</div>
			
		</div>
		<div class="form-group">
			<hr>
			<div class="container">
				<button type="submit" class="btn btn-warning" name="grabar" value="grabar">Grabar</button>
				<button id="bnBuscar" class="btn btn-warning"  name="buscar" value="buscar">Buscar</button>
				<button id="bnVerLista" class="btn btn-warning"  name="listar" value="listar">Ver Lista</button>
			</div>
		</div>
	</fieldset>
</form>
</div>
</body>
</html>