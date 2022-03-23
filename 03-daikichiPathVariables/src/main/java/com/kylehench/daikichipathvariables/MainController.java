package com.kylehench.daikichipathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/daikichi")
public class MainController {

	@RequestMapping("/travel/{city}")
	public String travel(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city + "!";
	}
	
	@RequestMapping("/lotto/{number}")
	public String lotto(@PathVariable("number") String number) {
		if (Integer.valueOf(number)%2 == 0) {
			return "You will take a grand journey in the near future, but be wary of tempting offers";
		}
		if (Integer.valueOf(number)%2 == 1) {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with fmaily and friends.";
		}
		return "sad";
	}
}
