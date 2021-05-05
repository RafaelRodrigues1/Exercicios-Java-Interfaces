package exercicio1.model.services;

import exercicio1.model.entities.Contract;
import exercicio1.model.entities.Installments;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author RafaelRodrigues1
 */
public class ContractService {
    
    private OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    public void installmentCalculation(Contract contract, int month){
        Double parcialQuota = contract.getTotalValue()/month;
        for(int i=1; i<=month; i++){
            Double insterest = paymentService.interest(parcialQuota, i);
            Double fee = paymentService.paymentFee(parcialQuota+insterest);
            Double installmentAmount = parcialQuota + insterest + fee;
            Date installmentDate = installmentMonth(contract.getContractDate(), i);
            contract.getInstallmentsList().add(new Installments(installmentDate, installmentAmount));
        }
    }
    
    public Date installmentMonth(Date date, int month){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }
    
}
