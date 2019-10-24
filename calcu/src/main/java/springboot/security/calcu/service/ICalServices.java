package springboot.security.calcu.service;


/**
 * interface de los servicios de la calculadora
 */
public interface ICalServices {

    public double Operations(double num1 , double num2 , String opr) throws Exception;
}