package exercicio1.aplication;

import exercicio1.model.entities.Contract;
import exercicio1.model.entities.Installments;
import exercicio1.model.services.ContractService;
import exercicio1.model.services.PaypalPaymentService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *Uma empresa deseja automatizar o processamento de seus contratos. O processamento de
um contrato consiste em gerar as parcelas a serem pagas para aquele contrato, com base no
número de meses desejado.
A empresa utiliza um serviço de pagamento online para realizar o pagamento das parcelas.
Os serviços de pagamento online tipicamente cobram um juro mensal, bem como uma taxa
por pagamento. Por enquanto, o serviço contratado pela empresa é o do Paypal, que aplica
juros simples de 1% a cada parcela, mais uma taxa de pagamento de 2%.
Fazer um programa para ler os dados de um contrato (número do contrato, data do contrato,
e valor total do contrato). Em seguida, o programa deve ler o número de meses para
parcelamento do contrato, e daí gerar os registros de parcelas a serem pagas (data e valor),
sendo a primeira parcela a ser paga um mês após a data do contrato, a segunda parcela dois
meses após o contrato e assim por diante. Mostrar os dados das parcelas na tela.

 * @author RafaelRodrigues1
 */
public class Program {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Enter contract data");
        System.out.print("Number: ");
        Integer contractNumber = in.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        Date date = new Date();
        try {
            date = sdf.parse(in.next());
        } catch (ParseException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        System.out.print("Contrat value: ");
        Double contractValue = in.nextDouble();
        System.out.print("Enter number of installments: ");
        Integer installmentsNumber = in.nextInt();
        Contract contract = new Contract(contractNumber, date, contractValue);
        ContractService contractService = new ContractService(new PaypalPaymentService());
        contractService.installmentCalculation(contract, installmentsNumber);
        System.out.println("Installments:");
        for(Installments installment: contract.getInstallmentsList()){
            System.out.println(installment);
        }
    }   
}
