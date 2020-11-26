package es.um.asio.back.test.controller;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.service.dto.DeltaDto;
import es.um.asio.service.service.DeltaService;
import es.um.asio.service.service.impl.DeltaServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(DeltaControllerTest.class)
@ActiveProfiles("unit-test")
public class DeltaControllerTest {

	@Autowired
	private DeltaService deltaService;

	@TestConfiguration
	static class DeltaControllerConfiguration {
		@Bean
		public DeltaService deltaService() {
			return new DeltaServiceImpl();
		}
	}

	@Test
	public void process() {

		List<DeltaDto> lista = deltaService.getDelta("000", "001");

		assertNotNull(lista);

	}
}
