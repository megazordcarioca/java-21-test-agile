package com.josiasdasilva.agiletestrestfulapi;

import com.josiasdasilva.agiletestrestfulapi.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class AgiletestrestfulapiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testNewProduct(){
		final String ProductA = "PlayStation 4", ProductB = "Xbox Series X", ProductC = "Nintendo Switch";

	}

}
