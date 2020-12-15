package es.um.asio.service.test.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.service.dto.DeltaDto;
import es.um.asio.service.service.DeltaService;
import es.um.asio.service.service.impl.DeltaServiceImpl;

@RunWith(SpringRunner.class)
public class DeltaServiceTest {

    @TestConfiguration
    static class DeltaServiceTestConfiguration {
        @Bean
        public DeltaService userService() {
            return new DeltaServiceImpl();
        }
    }

    /**
     * Delta service
     */
    @Autowired
    private DeltaService deltaService;

    @Test
    public void whenGetDelta_thenDeltaIsReturned() {
        final List<DeltaDto> delta = this.deltaService.getDelta("000", "001");

        assertThat(delta).isNotEmpty();
    }
}
