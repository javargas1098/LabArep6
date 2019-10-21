package springboot.security.calcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import springboot.security.calcu.service.ICalServices;

@RestController
@RequestMapping(value = "/operation")
public class calController {
	@Autowired
	@Qualifier("opServices")
	ICalServices calServices;

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String getData() {
		System.out.println("Returning data from nt-ms data method");
		return "Hello from NT-MS-data method";
	}

	@GetMapping("/sum/{num1}/{num2}")
	public ResponseEntity<?> getSum(@PathVariable double num1, @PathVariable double num2) {
		try {
			return new ResponseEntity<>(calServices.makeOperation(num1, num2, "+"), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/res/{num1}/{num2}")
	public ResponseEntity<?> getRest(@PathVariable double num1, @PathVariable double num2) {
		try {
			return new ResponseEntity<>(calServices.makeOperation(num1, num2, "-"), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/mul/{num1}/{num2}")
	public ResponseEntity<?> getMultiplication(@PathVariable double num1, @PathVariable double num2) {
		try {
			return new ResponseEntity<>(calServices.makeOperation(num1, num2, "*"), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/div/{num1}/{num2}")
	public ResponseEntity<?> getDivision(@PathVariable double num1, @PathVariable double num2) {
		try {
			return new ResponseEntity<>(calServices.makeOperation(num1, num2, "/"), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
