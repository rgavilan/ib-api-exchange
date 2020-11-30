package es.um.asio.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.DeltaDto;
import es.um.asio.service.proxy.DeltaProxy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(DeltaController.Mappings.BASE)
@Api(value = "API for Delta files", tags = "API for Delta files")
public class DeltaController {
	
	
	@Autowired
	DeltaProxy deltaProxy;

	
	@ApiOperation(value = "Check if server is Alive", notes = "Check if server is Alive")
	@RequestMapping(method={RequestMethod.GET},value={Mappings.HEALTH})
	public String getHealth() {
		return "Alive";
	}
	
	
	 @GetMapping(value = "/{currentVersion}/{targetVersion}")
	 public List<DeltaDto> getDelta(@PathVariable("currentVersion") final String currentVersion,@PathVariable("targetVersion") final String targetVersion) {
		    
	        return deltaProxy.getDelta(currentVersion,targetVersion);
	    }
	
	/**
     * Mappings.
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static final class Mappings {
    	
    	/** The Constant LOCAL_RESOURCE. */
		public static final String HEALTH = "health";
    	
        /**
         * Controller request mapping.
         */
        protected static final String BASE = "/ontology";

    }
}
