package exercicio1.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Fazer um programa para ler os dados de um contrato (número do contrato, data do contrato,
e valor total do contrato).
 * @author RafaelRodrigues1
 */
public class Contract {
    
    private Integer contractNumber;
    private Date contractDate;
    private Double totalValue;
    private List<Installments> installments = new ArrayList<>();

    public Contract() {
    }

    public Contract(Integer contractNumber, Date contractDate, Double totalValue ) {
        this.contractNumber = contractNumber;
        this.contractDate = contractDate;
        this.totalValue = totalValue;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public List<Installments> getInstallmentsList() {
        return installments;
    }
}
