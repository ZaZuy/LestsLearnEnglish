package AppLetsLearnEnglish.Api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth/")
public class ADMINApplicationController {
	@GetMapping("/process")
	public String process() {
		return "process....";
	}

}
