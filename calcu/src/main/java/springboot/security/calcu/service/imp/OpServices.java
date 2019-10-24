package springboot.security.calcu.service.imp;

import org.springframework.stereotype.Component;

import springboot.security.calcu.service.ICalServices;

/**
 * Esta clse representa la implementacionm de los serviccios de la calculadora
 */
@Component(value = "opServices")
public class OpServices implements ICalServices {
	@Override
	public double Operations(double first, double second, String opr) throws Exception {
		double result = 0.0;
		System.out.println(opr);

		switch (opr.charAt(0)) {
		case '1':
			result = first + second;
			break;
		case '2':
			result = first - second;
			break;
		case '3':
			result = first * second;
			break;
		case '4':
			if (second != 0) {
				result = first / second;
			} else {
				throw new Exception("No se puede divir por 0");
			}
			break;

		}
		return result;
	}
}