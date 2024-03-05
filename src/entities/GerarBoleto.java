package entities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GerarBoleto {
    public static void FazerBoleto(String modelo, String cor, double valorMoto, double valorFinal, double entrada, Cliente cliente, int opcaoPagamento, int opcaoDeEntrada, String codigoBarras) {
        String fileName = "compra.txt";
        MetodoDePagamento Pagamentos = new MetodoDePagamento();
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
        	writer.println("Loja de Motos Sandero");
        	writer.println("Modelo: " + modelo);
            writer.println("Cor: " + cor);
            if (opcaoPagamento == 1) {
                Pagamentos.valorMoto = valorMoto;
                writer.println("\nValor final da compra à vista: " + Pagamentos.PagamentoAvista());
            } else if (opcaoPagamento == 2) {
                if (opcaoDeEntrada == 1) {
                    Pagamentos.valorMoto = valorMoto;
                    Pagamentos.entrada = entrada;
                    writer.println("\nValor final da compra Parcelada com entrada: " + Pagamentos.PagamentoParceladoComEntrada());
                } else if (opcaoDeEntrada == 2) {
                    Pagamentos.valorMoto = valorMoto;
                    Pagamentos.parcelar = valorFinal;
                    writer.println("\nValor final da compra Parcelada sem entrada: " + Pagamentos.PagamentoParceladoSemEntrada());
                }
            }
            writer.println("Cliente:");
            writer.println("Nome: " + cliente.getNome());
            writer.println("Email: " + cliente.getEmail());
            writer.println("CPF: " + cliente.getCpf());
            writer.println("Número: " + cliente.getNumero());
            writer.println("CEP: " + cliente.getCep());
            writer.println("Opção de pagamento: " + (opcaoPagamento == 1 ? "À vista" : "Parcelado"));
            writer.println("Código de Barras: " + codigoBarras);
        } catch (IOException e) {
            System.out.println("Erro ao salvar a compra: " + e.getMessage());
        }
    }

    public static String gerarCodigoBarrasAleatorio() {
        Random random = new Random();
        StringBuilder codigoBarras = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            codigoBarras.append(random.nextInt(10));
        }
        return codigoBarras.toString();
    }
}
