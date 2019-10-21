package springboot.security.calcu.service.imp;

import org.springframework.stereotype.Component;

import springboot.security.calcu.service.ICalServices;

@Component(value = "opServices")
public class OpServices implements ICalServices {
	@Override
	public double makeOperation(double num1, double num2, String op) throws Exception {
		double fin = 0.0;
		
		if (op.charAt(0) == '+') {
			fin = num1 + num2;
		}

		if (op.charAt(0) == '-') {
			fin = num1 - num2;
		}

		if (op.charAt(0) == '*') {
			fin = num1 * num2;
		}

		if (op.charAt(0) == '/') {
			if (num2 != 0) {
				fin = num1 / num2;
			} else {
				throw new Exception("cann't be divide by 0");
			}
		}
		return fin;
	}
}