package vic.apps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vic.apps.model.Config;
import vic.apps.service.ConfigService;

@RestController
@RequestMapping("configs")
public class ConfigRestController {
	
	@Autowired
	private ConfigService cfgSvr;
	
	@RequestMapping(value="/nuevo", method = RequestMethod.POST, headers = "Accept=application/json")
	public Config addOne(@RequestBody Config cfg){
		System.out.println(cfg.toString());
		cfgSvr.add(cfg);
		return cfg;
	}
	
	@RequestMapping(value="/{cfgId}", method=RequestMethod.GET, headers="Accept=application/json")
	public Config readOne(@PathVariable int cfgId){
		Config c = cfgSvr.getConfig(cfgId);
		return c;
	}
}
