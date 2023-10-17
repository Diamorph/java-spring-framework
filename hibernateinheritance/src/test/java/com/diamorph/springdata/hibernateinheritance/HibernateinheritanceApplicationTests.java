package com.diamorph.springdata.hibernateinheritance;

import com.diamorph.springdata.hibernateinheritance.entities.Check;
import com.diamorph.springdata.hibernateinheritance.entities.CreditCard;
import com.diamorph.springdata.hibernateinheritance.repositories.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HibernateinheritanceApplicationTests {

	@Autowired
	PaymentRepository paymentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createCreditCardPayment() {
		CreditCard cc = new CreditCard();
		cc.setId(1);
		int transactionAmount = 1000;
		cc.setAmount(transactionAmount);
		String creditCardNumber = "1234567890";
		cc.setCardNumber(creditCardNumber);
		CreditCard creditCard = paymentRepository.save(cc);
		assertEquals(creditCard.getCardNumber(), creditCardNumber);
		assertEquals(creditCard.getAmount(), transactionAmount);
	}

	@Test
	public void createCheckPayment() {
		Check ch = new Check();
		ch.setId(2);
		int transactionAmount = 1000;
		ch.setAmount(transactionAmount);
		String checkNumber = "1234567890";
		ch.setCheckNumber(checkNumber);
		Check check = paymentRepository.save(ch);
		assertEquals(check.getCheckNumber(), checkNumber);
		assertEquals(check.getAmount(), transactionAmount);
	}

}
