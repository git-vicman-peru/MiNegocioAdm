package vic.apps.rest;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vic.apps.model.Greeting;
import vic.apps.model.Suscrip;
import vic.apps.model.fix.SuscripX;
import vic.apps.service.SuscripService;
import vic.apps.service.SuscripXService;

@RestController
@RequestMapping("suscrips")
public class SuscripRest {
	@Autowired
	private SuscripService susSvr;
	
	@Autowired
	private SuscripXService susxserv;
	
	@Autowired
	private SessionFactory sesfac;
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	@RequestMapping(value="/saludo/{nombre}", method=RequestMethod.GET)
	public String saludarIni(@PathVariable String nombre){
		String h = "Hola "+nombre;
		return h;
	}
	
	@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Suscrip> readAllSuscrips(){
		return (List<Suscrip>)susSvr.getAllSuscrip();
	}
	
	@RequestMapping(value="/addsusone", method = RequestMethod.POST, headers = "Accept=application/json")
	public Suscrip addSuscripOne(@RequestBody Suscrip sus){
		susSvr.add(sus);
		return sus;
	}
	
	@RequestMapping(value="/{idemp}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Suscrip readSingle(@PathVariable int idemp){
		Suscrip s = null;
		Session session;
		Transaction ts;
		try{
			session = this.sesfac.getCurrentSession();
		}catch(Exception ex){
			//ex.printStackTrace();
			session = this.sesfac.openSession();
		}
		ts = session.beginTransaction();
		s = susSvr.filterByIdEmp(idemp);
		ts.commit();
		session.close();
		
		if (s==null){
		s = new Suscrip();
		s.setId_emp(12);
		s.setVouch_nro("938829");
		s.setVouch_bank("BBVA");
		s.setVouch_fecha(new Date());
		s.setVouch_monto(350.4f);
		s.setTipo("Regular");
		s.setObs("solo de prueba");
		s.setActivo(true);
		}
		return s;
	}
	
	@RequestMapping(value="/byid/{idsus}", method=RequestMethod.GET)
	public Suscrip readSuscripById(@PathVariable int idsus){
		Suscrip s = susSvr.getSuscrip(idsus);
		return s;
	}
	
	@RequestMapping(value="/leeuno/{susid}", method = RequestMethod.GET, headers = "Accept=application/json")
	public SuscripX leerUno(@PathVariable int susid){
		return susxserv.getSuscrip(susid);
	}
	
	@RequestMapping(value="/addxone", method = RequestMethod.POST, headers = "Accept=application/json")
	public SuscripX addXone(@RequestBody SuscripX sus){
		susxserv.addSuscrip(sus);
		return sus;
	}
}
