package vic.apps.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import vic.apps.model.Acceso;
import vic.apps.model.ErrorObj;
import vic.apps.model.Suscrip;
import vic.apps.service.SuscripService;

@Controller
public class SuscripController {

	private ErrorObj flgerr;
	
	@Autowired
	private SuscripService susSvr;
	//private ConfigService cfgServ;
	
	private Suscrip oldSus;
	private Acceso oldAcc;
	
	public SuscripController() {
		this.flgerr = new ErrorObj();
		this.flgerr.setTag("razonsocial;vouch_nro;vouch_fecha;vouch_monto;tipo;usuario;clave");
	}
	
	@ModelAttribute("erref")
	public ErrorObj errorFlag(){
		return this.flgerr;
	}
	
	/*
	@ModelAttribute("empties")
	public String checkForEmpties(){
		return ;
	}
	*/
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView suscribir(ModelMap map){
		//ObjectMapper mapper = new ObjectMapper();
		if (!this.flgerr.hasError()){
			this.flgerr.reset();
			Suscrip sus = new Suscrip();
			sus.setId_emp(0);
			sus.setRazonsocial("Razon Social");
			sus.setVouch_bank("BBVA");
			//sus.setVouch_fecha(new Date());
			sus.setVouch_monto(0);
			sus.setTipo("Regular");
			sus.setActivo(true);
			
			Acceso acc = new Acceso();
			acc.setUsuario("DemoUser");
			acc.setVigente(true);
			map.addAttribute("sus", sus);
			map.addAttribute("acc", acc);
		}else{
			map.addAttribute("sus", this.oldSus);
			map.addAttribute("acc", this.oldAcc);
		}
		map.addAttribute("searchUrl", "/MiNegocioAdm/verlista");
		//map.addAttribute("suslst",susSvr.getAllSuscrip());
		return new ModelAndView("suscribe");
	}
	
	@RequestMapping(value="/savesus", method=RequestMethod.POST)
	public String saveSuscripcion(Suscrip sus, Acceso acc){
		//@RequestParam String action, 
		this.oldSus = sus;
		this.oldAcc = acc;
		//System.out.println("action:" + action);
		//System.out.println(sus.toString());
		this.flgerr = sus.checkForErrors();
		if (this.flgerr.hasError()){
			System.out.println("Has errors");
			return "redirect:/";
		}
		susSvr.addBatch(sus, acc);
		//susSvr.addBatch(susacc.getSuscripcion(), susacc.getAcceso());
		return "redirect:/";
	}
	
	@RequestMapping(value="validator")
	public String validador(){
		return "validateForm";
	}
	
	@RequestMapping(value="verlista")
	public String showLista(){
		return "listasuscrip";
	}
	
	@RequestMapping(value="/single/{idsus}")
	@ResponseBody
	public Suscrip readSuscrip(@PathVariable int idsus){
		Suscrip s = susSvr.getSuscrip(idsus);
		//Suscrip s = new Suscrip();
		return s;
	}
}
