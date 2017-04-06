<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de suscripciones</title>
		<script src="resources/js/jquery-2.2.3.min.js"></script>
		<script src="resources/js/bootstrap-3.3.7/js/bootstrap.min.js"></script>
		<link href="resources/js/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
		<link href="resources/js/bootstrap-3.3.7/css/bootstrap-theme.min.css" rel="stylesheet"/>
	
		<link href="resources/js/datatables1-10-13/css/jquery.dataTables.min.css" rel="stylesheet"/>
		<script src="resources/js/datatables1-10-13/jquery.dataTables.min.js"></script>
		<link href="resources/styles/minegocioadm.css" rel="stylesheet"/>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){

			
			var tblList = $('#tblLista').DataTable({
				"ajax":{
					"url":"/MiNegocioAdm/suscrips/all",
					"type":"GET",
					"success": function(data){
						$.each(data, function(ind, obj){
							console.log(obj.accesos);
							var chkActivo = "<input type='checkbox' id='fld"+obj.id_sus+"'>";
							var child = "<input type='button' id='bnAc-"+obj.id_sus+"' class='buttonAccess' value='Accesos'><input type='hidden' id='hf"+obj.id_sus+"' value='some value'>";
							if (obj.activo)
								chkActivo = "<input type='checkbox' checked id=''>";
							tblList.row.add([
								chkActivo,obj.id_emp,obj.vouch_nro,obj.vouch_fecha,obj.vouch_bank,obj.vouch_monto,obj.tipo,obj.obs,child
							]).draw();
						});
					}
				}
				
			});

			$(document).on('click','.buttonAccess',function(){
				var def = this.id.split('-');
				console.log(def);
				alert(def[1]);
			});
			
		});
	</script>
<body>
<c:set var="activemenuitem" value="listar" scope="session" />
<%@include file="menu.jsp" %>
<div class="container pageborder">
	<h1>Lista de suscripciones</h1>
	<table id="tblLista" class="display">
        <thead>
            <tr>
            	<th>activo</th>
                <th>id_emp</th>
                <th>vouch_nro</th>
                <th>vouch_fecha</th>
                <th>vouch_bank</th>
                <th>vouch_monto</th>
                <th>tipo</th>
                <th>obs</th>
                <th>...</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
            	<th>activo</th>
                <th>id_emp</th>
                <th>vouch_nro</th>
                <th>vouch_fecha</th>
                <th>vouch_bank</th>
                <th>vouch_monto</th>
                <th>tipo</th>
                <th>obs</th>
                <th>...</th>
            </tr>
        </tfoot>
    </table>
</div>
</body>
</html>