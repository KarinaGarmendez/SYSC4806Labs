package sysc4806.kg.ta;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class RestServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private AddressBookController adController;

	@Autowired
	private BuddyInfoController biController;

    @Autowired
    private RestTestClient restTestClient;

	@Test
	void contextLoadsAddressBook() throws Exception {
		assertThat(adController).isNotNull();
	}

	@Test
	void contextLoadsBuddyInfo() throws Exception {
		assertThat(biController).isNotNull();
	}

	@Test
	void buddyInfoShouldReturnDefaultMessage() {
		restTestClient.get().uri("http://localhost:%d/buddy".formatted(port))
				.exchange()
				.expectBody(String.class)
				.isEqualTo("buddy");
	}

	@Test
	void addressBookShouldReturnDefaultMessage() {
		restTestClient.get().uri("http://localhost:%d/addresses".formatted(port))
				.exchange()
				.expectBody(String.class)
				.isEqualTo("addresses");
	}
}
