package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos contribuintes você vai digitar? ");
        int contribuintes_qt = sc.nextInt();

        List<TaxPayer> contribuintes = new ArrayList<>();

        for (int i = 0; i < contribuintes_qt; i++){
            System.out.printf("\nDigite os dados do %do contribuinte: \n", (i+1));
            System.out.print("Renda anual com salário: ");
            double rendaSal = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            double rendaServico = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double rendaCapital = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            double gastosMedicos = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double gastosEducacionais = sc.nextDouble();

            TaxPayer taxPayer = new TaxPayer(rendaSal, rendaServico, rendaCapital, gastosMedicos, gastosEducacionais);
            contribuintes.add(taxPayer);

        }

        int cont = 1;
        for (TaxPayer contribuinte : contribuintes){
            System.out.printf("\nResumo do %do contribuinte:\n", cont);
            System.out.printf("Imposto bruto total: %.2f\n", contribuinte.grossTax());
            System.out.printf("Abatimento: %.2f\n", contribuinte.taxRebate());
            System.out.printf("Imposto devido: %.2f\n", contribuinte.netTax());
            cont++;
        }

        sc.close();
    }
}
