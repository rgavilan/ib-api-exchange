package es.um.asio.service.service;

import java.util.List;

import es.um.asio.service.dto.DeltaDto;

public interface DeltaService {

	List<DeltaDto> getDelta(String currentVersion, String targetVersion);

}
