<style>
 .menuback{
	background: rgba(226,226,226,1);
	background: -moz-linear-gradient(top, rgba(226,226,226,1) 0%, rgba(209,209,209,1) 51%, rgba(254,254,254,1) 100%);
	background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(226,226,226,1)), color-stop(51%, rgba(209,209,209,1)), color-stop(100%, rgba(254,254,254,1)));
	background: -webkit-linear-gradient(top, rgba(226,226,226,1) 0%, rgba(209,209,209,1) 51%, rgba(254,254,254,1) 100%);
	background: -o-linear-gradient(top, rgba(226,226,226,1) 0%, rgba(209,209,209,1) 51%, rgba(254,254,254,1) 100%);
	background: -ms-linear-gradient(top, rgba(226,226,226,1) 0%, rgba(209,209,209,1) 51%, rgba(254,254,254,1) 100%);
	background: linear-gradient(to bottom, rgba(226,226,226,1) 0%, rgba(209,209,209,1) 51%, rgba(254,254,254,1) 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#e2e2e2', endColorstr='#fefefe', GradientType=0 ); 
 }

</style>
<script type="text/javascript">

	$(document).ready(function(){
		setActiveMenuItem();
		
	});
	
	function readAMI(){
		return "<c:out value="${sessionScope.activemenuitem}" />";
	}

	function setActiveMenuItem(){
		var selecteditemname = readAMI();
		if (selecteditemname=="suscribir"){
			document.getElementById("liSuscribir").className = "active";
		}
		if (selecteditemname=="listar"){
			document.getElementById("liListar").className = "active";
		}
	}
</script>
<div class="container menuback" style="margin-bottom: 11px;">
	<ul class="nav nav-tabs">
		<li id="liSuscribir" role="presentation" class=""><a href="/MiNegocioAdm/">Registro General</a></li>
		<li id="liListar" role="presentation" class=""><a href="/MiNegocioAdm/verlista">Listado Global</a></li>
		<li id="liEstad" role="presentation" class=""><a href="#">Estad&iacute;sticas</a></li>
	</ul>
</div>