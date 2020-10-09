package es.um.asio.service.proxy;

import java.util.List;

import es.um.asio.service.dto.DeltaDto;

public interface DeltaProxy {

	List<DeltaDto> getDelta(String currentVersion, String targetVersion);

}
