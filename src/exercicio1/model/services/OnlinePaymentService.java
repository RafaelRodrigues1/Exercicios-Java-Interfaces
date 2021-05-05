package exercicio1.model.services;

/**
 *
 * @author RafaelRodrigues1
 */
public interface OnlinePaymentService {
    
    double paymentFee(double amount);
    double interest(double amount, int month);
}
