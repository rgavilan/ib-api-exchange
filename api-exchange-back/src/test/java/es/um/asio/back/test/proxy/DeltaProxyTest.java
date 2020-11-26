package es.um.asio.back.test.proxy;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.back.test.TestApplication;
import es.um.asio.service.proxy.DeltaProxy;
import es.um.asio.service.proxy.impl.DeltaProxyImpl;
import es.um.asio.service.service.DeltaService;

@RunWith(SpringRunner.class)
@WebMvcTest(DeltaProxyTest.class)
@ActiveProfiles("unit-test")
public class DeltaProxyTest {

	/**
	 * Proxy Delta
	 */
	@Autowired
	private DeltaProxy proxy;

	@MockBean
	private DeltaService service;

	@TestConfiguration
	@Import(TestApplication.class)
	static class UserProxyTestConfiguration {
		@Bean
		public DeltaProxy userProxy() {
			return new DeltaProxyImpl();
		}
	}

	@Test
	public void test_Infraestructure() {
		assertNotNull(proxy);
	}

}
