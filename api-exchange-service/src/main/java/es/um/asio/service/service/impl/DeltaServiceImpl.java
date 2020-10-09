package es.um.asio.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.um.asio.service.dto.DeltaDto;
import es.um.asio.service.service.DeltaService;

@Service
public class DeltaServiceImpl implements DeltaService {

	@Override
	public List<DeltaDto> getDelta(String currentVersion, String targetVersion) {
		// TODO LLAMADA PARA RECUPERAR INFORMACION Y MONTAR EL DELTA
		
		
		//MOCK
		List<DeltaDto> response;
		
		response = deltaConstruction(currentVersion,targetVersion);
		
		
		return response;
	}
	
	/*
	 * Mockc para 3 ejemplos
	 */
	private List<DeltaDto> deltaConstruction(String currentVersion,String targetVersion) {
		List<DeltaDto> response = new ArrayList<>();
	
		if( "000".equals(currentVersion) && "001".equals(targetVersion) ) {
			DeltaDto obj = new DeltaDto();
			
			obj.setAction("ADD");
			obj.setEntity("asio.Person");
			obj.setProperty("name");
			obj.setType("java.lang.String");
			
			response.add(obj);
			
			obj = new DeltaDto();
			obj.setAction("ADD");
			obj.setEntity("asio.Person");
			obj.setProperty("surname");
			obj.setType("java.lang.String");
			
			response.add(obj);			
			
			obj = new DeltaDto();
			obj.setAction("ADD");
			obj.setEntity("asio.Person");
			obj.setProperty("nationalId");
			obj.setType("java.lang.String");
			
			response.add(obj);
			
			obj = new DeltaDto();
			obj.setAction("ADD");
			obj.setEntity("asio.Person");
			obj.setProperty("bithDate");
			obj.setType("java.util.Date");
			
			response.add(obj);
			
			obj = new DeltaDto();
			obj.setAction("ADD");
			obj.setEntity("asio.Person");
			obj.setProperty("address");
			obj.setType("java.lang.String");
			
			response.add(obj);
			
			obj = new DeltaDto();
			obj.setAction("ADD");
			obj.setEntity("asio.Student");
			obj.setProperty("name");
			obj.setType("java.lang.String");
			
			response.add(obj);
			
		} else if ("001".equals(currentVersion) && "002".equals(targetVersion)) {
			DeltaDto obj = new DeltaDto();
			
			obj.setAction("UPDATE");
			obj.setEntity("asio.Person");
			obj.setProperty("address");
			obj.setFromType("java.lang.String");
			obj.setToType("asio.Address");
			
			response.add(obj);
			
			obj = new DeltaDto();
			obj.setAction("DELETE");
			obj.setEntity("asio.Student");
			obj.setProperty("name");
			
			response.add(obj);	

		} else if ("002".equals(currentVersion) && "003".equals(targetVersion)) {
			
			DeltaDto obj = new DeltaDto();
			
			obj.setAction("RENAME");
			obj.setEntity("asio.Person");
			obj.setToName("asio.Persona");

			response.add(obj);

		} else if("003".equals(currentVersion) && "004".equals(targetVersion)) {
			DeltaDto obj = new DeltaDto();
			
			obj.setAction("RENAME");
			obj.setEntity("asio.Person");
			obj.setProperty("name");
			obj.setToName("givenName");
			
			response.add(obj);

		}
		
		return response;
	}

}
