package exercicio1.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Em seguida, o programa deve ler o número de meses para
parcelamento do contrato, e daí gerar os registros de parcelas a serem pagas (data e valor),
sendo a primeira parcela a ser paga um mês após a data do contrato, a segunda parcela dois
meses após o contrato e assim por diante. Mostrar os dados das parcelas na tela.
 * @author RafaelRodrigues1
 */
public class Installments {
    
    private Date installmentDate;
    private Double installmentAmount;
    
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Installments(Date installmentDate, Double installmentAmount) {
        this.installmentDate = installmentDate;
        this.installmentAmount = installmentAmount;
    }

    public Installments() {
    }
    
    public Date getInstallmentDate() {
        return installmentDate;
    }

    public void setInstallmentDate(Date installmentDate) {
        this.installmentDate = installmentDate;
    }

    public Double getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(Double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }
    
    public String toString(){
        return sdf.format(getInstallmentDate()) + " - " + String.format("%.2f", getInstallmentAmount());
    }
}
