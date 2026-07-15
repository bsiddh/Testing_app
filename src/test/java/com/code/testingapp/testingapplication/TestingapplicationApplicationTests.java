package com.code.testingapp.testingapplication;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@Slf4j
class TestingapplicationApplicationTests {

	@BeforeEach
	void setUp(){
		log.info("starting the method, setting up config - @BeforeEach");
	}

     @AfterEach
	void tearDown(){
		log.info("tearing down the method - @AfterEach");
	}

	@BeforeAll
	static void setUpOnce(){
		log.info("setup  Once.. - @BeforeAll");
	}

	@AfterAll
	static void tearDownOnce(){
		log.info("Tearing down all.... - @AfterAll");
	}

	@Test
//	@Disabled
	void testNumberOne(){
   int a= 4;
   int b = 6;

   int result = addTwoNumbers(a,b);
//   Assertions.assertEquals(10,result);
//   Assertions.

//		assertThat(result)
//				.isEqualTo(10)
//				.isCloseTo(11, Offset.offset(1));

		assertThat("Apple")
				.isEqualTo("Apple")
				.startsWith("App")
				.endsWith("le")
				.hasSize(5);

	}

	@Test
//	@DisplayName("displayNameTwo")
	void testDivideTwoNumbers_whenDenominaterIsZero_ThenArithmaticException(){
            int a=5;
			int b=0;

		assertThatThrownBy(()-> divideTwoNumbers(a,b))
				.isInstanceOf(Exception.class)
				.hasMessage("Tried to divide by ");
	}

	int addTwoNumbers(int a,int b){
		return a+b;
	}

	double divideTwoNumbers(int a,int b){
		try{
             return a/b;
		}catch(ArithmeticException e){
			log.error("Arithmatic exception occured :"+e.getLocalizedMessage());
			throw new ArithmeticException(("Tried to divide by zero"));
		}
	}

}
