package com.example.restservice3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestService3ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test0() {
		assertEquals(2, 1+1, "1+1 failed!");
	}


}
