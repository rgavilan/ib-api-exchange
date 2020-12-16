package es.um.asio.back.test.runners.stepdefs;

import java.util.List;

import org.junit.Assume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fasterxml.classmate.TypeResolver;

import es.um.asio.service.ServiceConfig;
import es.um.asio.service.dto.DeltaDto;
import es.um.asio.service.service.DeltaService;
import es.um.asio.swagger.SwaggerAutoConfiguration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { ServiceConfig.class })
public class DeltaStepDefinitionsTest {

	String currentVersion;

	String targetVersion;

	List<DeltaDto> listDelta;

	@MockBean
	TypeResolver type;

	@MockBean
	SwaggerAutoConfiguration config;

	@MockBean
	SpringDataWebProperties properties;

	@Autowired
	@MockBean
	DeltaService service;

	@Given("^call to api exchange delta controller$")
	public void call_to_api_exchange_delta_controller() {

		currentVersion = "000";
		targetVersion = "001";
		System.out.println("Arrive to controller the next parameters, currentVersion: " + currentVersion
				+ " - targetVersion: " + targetVersion);
	}

	@Then("^the api exchange retrieves the data from the ontological infrastructure layer$")
	public void the_api_exchange_retrieves_the_data_from_the_ontological_infrastructure_layer() {
		service.getDelta(currentVersion, targetVersion);
		System.out.println("Controller invoque deltaService and this call ontogical_infractucture");
	}

	@Then("^the api exchange creates the delta file with the received data$")
	public void the_api_exchange_creates_the_delta_file_with_the_received_data() {

		Assume.assumeTrue(false);
//		System.out.println("deltaService work with the data and make the response to Delta processor");
//		listDelta = deltaConstruction(currentVersion, targetVersion);
	}

	@Then("^the api exchange sends the delta file to the Delta processor$")
	public void the_api_exchange_sends_the_delta_file_to_the_Delta_processor() {
		Assume.assumeTrue(false);
	}

	@Given("^api-exchange call ontological infrastructure to get data$")
	public void api_exchange_call_ontological_infrastructure_to_get_data() {
		Assume.assumeTrue(false);
	}

	@Then("^the api exchange construct file$")
	public void the_api_exchange_construct_file() {
		Assume.assumeTrue(false);
	}
}
