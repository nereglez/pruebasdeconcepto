package pruebas.de.concepto.api.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AppTest.class)
public class MyDefaultMethodServiceImplTest {
	
	@Resource(name="myDefaultMethodServiceImpl")
	DefaultMethodInterfaceService defaultMethodService;

	@Test
	public void generateMessageTest() {
		String lowercaseMessage = defaultMethodService.generateMessageLowercase();
		String uppercasMessage = defaultMethodService.generateMessageUppercase();
		
		System.out.println(lowercaseMessage);
		System.out.println(uppercasMessage);
		
		assertTrue(lowercaseMessage.equalsIgnoreCase(uppercasMessage));
		assertFalse(lowercaseMessage.equals(uppercasMessage));
	}
}
