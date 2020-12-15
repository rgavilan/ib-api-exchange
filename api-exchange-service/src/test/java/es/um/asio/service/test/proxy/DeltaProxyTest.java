package es.um.asio.service.test.proxy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.service.dto.DeltaDto;
import es.um.asio.service.proxy.DeltaProxy;

@RunWith(SpringRunner.class)
public class DeltaProxyTest {

	/**
	 * Delta proxy
	 */
	@Autowired
	@MockBean
	private DeltaProxy deltaProxy;

	@Before
	public void set_Up() {
		Mockito.when(deltaProxy.getDelta("000", "001")).then(invocation -> {
			List<DeltaDto> listdelta = new ArrayList<>();
			DeltaDto delta = new DeltaDto();
			delta.setAction("Test");
			delta.setEntity("Project");
			delta.setFromType("");
			delta.setToType("");
			delta.setProperty(null);
			delta.setToName("test");
			delta.setType("string");

			listdelta.add(delta);

			return listdelta;

		});
	}

	@Test
	public void proxyGetDelta() {
		final List<DeltaDto> delta = this.deltaProxy.getDelta("000", "001");

		for (DeltaDto d : delta) {
			System.out.println("Action:" + d.getAction());
			System.out.println("Entity:" + d.getEntity());
			System.out.println("FromType:" + d.getFromType());
			System.out.println("Property:" + d.getProperty());
			System.out.println("ToName:" + d.getToName());
			System.out.println("ToType:" + d.getToType());
			System.out.println("Type:" + d.getType());
		}

		assertThat(delta).isNotEmpty();
	}
}
