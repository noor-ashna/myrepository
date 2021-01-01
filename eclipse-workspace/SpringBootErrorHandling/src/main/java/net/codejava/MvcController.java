package net.codejava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

	@GetMapping("/users")
	public String viewUsers(Model model) throws Exception {
		if (model.getAttribute("abc") == null) {
			throw new Exception("Random Exception");
		}
		return "users";
	}
}
