package com.cts.pension.processPension.model;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PensionerTest {

	Pensioner pensioner = new Pensioner();
	BankDetail bankDetail = new BankDetail() ;


	@Test
	void testPensionerBean() {
		final BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection();
		beanTester.testBean(Pensioner.class);
	}

}
