package ar.com.flexibility.examen.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mockito.InjectMocks;

import ar.com.flexibility.examen.domain.model.Message;
import ar.com.flexibility.examen.domain.service.impl.ProcessMessageServiceImpl;

public class ProcessMessageServiceTest {

	@InjectMocks
	private ProcessMessageServiceImpl messageService;

	@Test
	public void processMessage() {
		String messageTest = "TEST";
		Message message = messageService.processMessage(messageTest);

		assertNotNull(message);
		assertEquals(message.getMessage(), messageTest);
	}
}
