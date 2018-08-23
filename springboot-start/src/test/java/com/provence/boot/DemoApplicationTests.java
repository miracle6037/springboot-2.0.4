package com.provence.boot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@LocalServerPort
	private int port;

	private URL url;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void before() throws MalformedURLException {
		this.url = new URL("http://localhost:" + port + "/api/v1/hello");
	}

	@Test
	public void testHello() {
		ResponseEntity<String> responseEntity =restTemplate.getForEntity(url.toString(), String.class);
        Assert.assertEquals(responseEntity.getBody(), "Hello World...");
	}

}
