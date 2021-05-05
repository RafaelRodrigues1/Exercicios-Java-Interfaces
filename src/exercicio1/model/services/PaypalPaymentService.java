package exercicio1.model.services;

import exercicio1.model.entities.Contract;
import exercicio1.model.entities.Installments;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * o serviço contratado pela empresa é o do Paypal, que aplica
juros simples de 1% a cada parcela, mais uma taxa de pagamento de 2%.
 * @author RafaelRodrigues1
 */
public class PaypalPaymentService implements OnlinePaymentService {
    
    private static final double PAYMENT_FEE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;
    

    @Override
    public double paymentFee(double amount) {
        return amount * PAYMENT_FEE;
    }

    @Override
    public double interest(double amount, int month) {
        return amount * MONTHLY_INTEREST * month;
    }
}
