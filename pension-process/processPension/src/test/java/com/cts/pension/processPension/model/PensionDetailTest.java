package com.cts.pension.processPension.model;


import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PensionDetailTest {

		@Test
		void testPensionerBean() {		
			final BeanTester beanTester = new BeanTester();
			beanTester.getFactoryCollection();
			beanTester.testBean(PensionDetail.class);
		}
}
