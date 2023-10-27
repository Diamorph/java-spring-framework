package com.diamorph.transactionmanagement;

import com.diamorph.transactionmanagement.services.BankAccountService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionmanagementApplicationTests {

	@Autowired
	BankAccountService bankAccountService;


	@Test
	void contextLoads() {
	}

	@Test
	void testTransfer() {
		bankAccountService.transfer(200);
	}

}
