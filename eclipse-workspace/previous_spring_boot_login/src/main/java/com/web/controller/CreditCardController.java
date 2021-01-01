package com.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.controller.vo.CreditCard;

@RestController
@RequestMapping("/v3")
public class CreditCardController {
	
	
	@GetMapping(value="/creditcards/{cvv}")
	//@PathVariable means reading data from URI
	public CreditCard geData(@PathVariable int cvv) {
		CreditCard creditCard = new CreditCard();
		creditCard.setCardHolder("Noor Ashna");
		creditCard.setCvv(cvv);
		creditCard.setExp("12/2024");
		creditCard.setName("VISA");
		return creditCard;
	}
	
	@GetMapping(value="/creditcards")
	public List<CreditCard> getCreditCards() {
		
		CreditCard tcreditCard = new CreditCard();
		tcreditCard.setCardHolder("Aman Sing");
		tcreditCard.setCvv(902);
		tcreditCard.setExp("01/2022");
		tcreditCard.setName("METRO");
		
		CreditCard creditCard = new CreditCard();
		creditCard.setCardHolder("NAGENDRA KUMAR");
		creditCard.setCvv(702);
		creditCard.setExp("12/2024");
		creditCard.setName("VISA");
		return Arrays.asList(tcreditCard,creditCard);
	}
	
	

}
