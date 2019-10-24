package springboot.security.calcu.service.imp;

import org.springframework.stereotype.Component;

import springboot.security.calcu.service.ICalServices;



/**
 * Esta clse representa la implementacionm de los serviccios de la calculadora
 */
@Component(value = "opServices")
public class OpServices implements ICalServices {
	@Override
	public double makeOperation(double num1, double num2, String opr) throws Exception {
		double fin = 0.0;
		
		if (opr.charAt(0) == '+') {
			fin = num1 + num2;
		}

		if (opr.charAt(0) == '-') {
			fin = num1 - num2;
		}

		if (opr.charAt(0) == '*') {
			fin = num1 * num2;
		}

		if (opr.charAt(0) == '/') {
			if (num2 != 0) {
				fin = num1 / num2;
			} else {
				throw new Exception("cann't be divide by 0");
			}
		}
		return fin;
	}
}