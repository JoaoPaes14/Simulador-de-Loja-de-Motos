package entities;

import java.util.Locale;
import java.util.Scanner;


public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(new Locale("en", "US"));
        boolean validOption = false;
        double valorMoto = 0;
        double parcelas = 0;

        AtributosDasMotos atributosDasMotos = new AtributosDasMotos();
        MetodoDePagamento Pagamentos = new MetodoDePagamento();

        System.out.println("\n\n-------------------- Modelos --------------------\n\n");
        System.out.println(
                "CG160 Modelos: \n \nStart = R$13,280.\nFan = R$14.570. \nTitan = R$15.810. \nCargo = R$14.760.  \n\nBIZ Modelos:\n \nElite125 = R$12.330. \nPop110i = R$9,010.\n\nCB Modelos:\n \nX-ADV = R$88.672\n");

        while (!validOption) {
            try {
                System.out.println("Escolha um modelo:");
                atributosDasMotos.option = sc.nextLine();

                if (!atributosDasMotos.isValidOption(atributosDasMotos.option)) {
                    throw new IllegalArgumentException(
                            "Opção inválida. Certifique-se de escolher um dos modelos listados.");
                }
                validOption = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        System.out.println("Você escolheu o modelo: " + atributosDasMotos.option);
        System.out.println();

        String corEscolhida = atributosDasMotos.EscolherCor(sc);
        atributosDasMotos.corEscolhida = corEscolhida;

        switch (atributosDasMotos.option) {
            case "Start":
                valorMoto = 13280;
                break;
            case "Fan":
                valorMoto = 14570;
                break;
            case "Titan":
                valorMoto = 15810;
                break;
            case "Cargo":
                valorMoto = 14760;
                break;
            case "Elite125":
                valorMoto = 12330;
                break;
            case "Pop110i":
                valorMoto = 9010;
                break;
            case "X-ADV":
                valorMoto = 88672;
                break;
        }
        System.out.println("\nModelo da moto:" + atributosDasMotos.option + "\nValor da moto sem acréscimos:"
                + valorMoto + "\nCor Escolhida: " + atributosDasMotos.corEscolhida + ".");

        System.out.println("\nPor favor, insira suas informações:");
        System.out.println("Nome: ");
        String nomeCliente = sc.nextLine();
        System.out.println("Email: ");
        String emailCliente = sc.nextLine();
        System.out.println("CPF: ");
        String cpfCliente = sc.nextLine();
        System.out.println("Número: ");
        String numeroCliente = sc.nextLine();
        System.out.println("CEP: ");
        String cepCliente = sc.nextLine();

        Cliente cliente = new Cliente(nomeCliente, emailCliente, cpfCliente, cepCliente, numeroCliente);

        System.out.println("\nDeseja pagar à vista ou parcelar a compra? (1 - à vista, 2 - parcelado): ");
        int opcaoPagamento = sc.nextInt();
        if (opcaoPagamento == 1) {
            Pagamentos.valorMoto = valorMoto;

            System.out.println("\nValor final da compra à vista: " + Pagamentos.PagamentoAvista());
            
            String codigoBarras = GerarBoleto.gerarCodigoBarrasAleatorio();
            GerarBoleto.FazerBoleto(atributosDasMotos.option, corEscolhida, Pagamentos.getValorMoto(),
                    Pagamentos.getValorFinal(), 0, cliente, opcaoPagamento, 0, codigoBarras);
            System.out.println("Boleto gerado com sucesso!.Se diriga a concessionária Sandero mais perto para retirada da sua moto!");
        } else if (opcaoPagamento == 2) {

            do {
                System.out.println("Quantas parcelas? (1 - 24): ");
                parcelas = sc.nextInt();
                if (parcelas < 1 || parcelas > 24) {
                    System.out.println("Número de parcelas inválido. Escolha entre 1 e 24.");
                }
            } while (parcelas < 1 || parcelas > 24);
            System.out.println("Você gostaria de dar uma entrada? (1 - Para sim, 2 - Para não)");
            int opcaoDeEntrada = sc.nextInt();
            if (opcaoDeEntrada == 1) {
                System.out.println("Digite o valor da entrada:");
                double entrada = sc.nextDouble();

                Pagamentos.entrada = entrada;
                Pagamentos.valorMoto = valorMoto;

                System.out.println("O valor com entrada fica em:" + Pagamentos.PagamentoParceladoComEntrada());

                String codigoBarras = GerarBoleto.gerarCodigoBarrasAleatorio();
                GerarBoleto.FazerBoleto(atributosDasMotos.option, corEscolhida, Pagamentos.getValorMoto(),
                        Pagamentos.getValorFinal(), Pagamentos.getEntrada(), cliente, opcaoPagamento, opcaoDeEntrada,
                        codigoBarras);
                System.out.println("Boleto gerado com sucesso!.Se diriga a concessionária Sandero mais perto para retirada da sua moto!");

            } else if (opcaoDeEntrada == 2) {
                Pagamentos.valorMoto = valorMoto;
                Pagamentos.parcelar = parcelas;

                System.out.println("O valor parcelado fica em:" + Pagamentos.PagamentoParceladoSemEntrada());
                System.out.println("O valor das parcelas ficam em:" + Pagamentos.ValorDasParcelas());

                String codigoBarras = GerarBoleto.gerarCodigoBarrasAleatorio();
                GerarBoleto.FazerBoleto(atributosDasMotos.option, corEscolhida, Pagamentos.getValorMoto(),
                        Pagamentos.getValorFinal(), 0, cliente, opcaoPagamento, opcaoDeEntrada, codigoBarras);
                System.out.println("Boleto gerado com sucesso!.Se diriga a concessionária Sandero mais perto para retirada da sua moto!");

            }

        }

        sc.close();
    }
}
