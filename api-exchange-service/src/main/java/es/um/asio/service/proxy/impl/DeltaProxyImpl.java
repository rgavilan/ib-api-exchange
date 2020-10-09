package es.um.asio.service.proxy.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.DeltaDto;
import es.um.asio.service.proxy.DeltaProxy;
import es.um.asio.service.service.DeltaService;

@Service
public class DeltaProxyImpl implements DeltaProxy {
	
	@Autowired
	DeltaService deltaService;

	@Override
	public List<DeltaDto> getDelta(String currentVersion, String targetVersion) {
		
		return deltaService.getDelta(currentVersion,targetVersion);
	}

}
