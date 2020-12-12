package es.um.asio.back.test.runners.stepdefs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import es.um.asio.service.ServiceConfig;
import es.um.asio.service.dto.DeltaDto;
import es.um.asio.service.service.DeltaService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {
		ServiceConfig.class })
public class DeltaStepDefinitionsTest {

	String currentVersion;

	String targetVersion;

	List<DeltaDto> listDelta;

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
		System.out.println("deltaService work with the data and make the response to Delta processor");
		listDelta = deltaConstruction(currentVersion, targetVersion);
	}

	@Then("^the api exchange sends the delta file to the Delta processor$")
	public void the_api_exchange_sends_the_delta_file_to_the_Delta_processor() {
		System.out.println("API REST respond with the next data:");

		for (DeltaDto delta : listDelta) {
			System.out.println("Delta: " + delta.toString());
		}
	}

	/*
	 * Mockc constructor
	 */
	private List<DeltaDto> deltaConstruction(String currentVersion, String targetVersion) {
		List<DeltaDto> response = new ArrayList<>();

		if ("000".equals(currentVersion) && "001".equals(targetVersion)) {
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

		}

		return response;
	}

}
