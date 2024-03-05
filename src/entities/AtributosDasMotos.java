package entities;

import java.util.Scanner;

public class AtributosDasMotos {
	public String option;
	String corEscolhida = "";
    boolean corValida = false;
	
	public AtributosDasMotos() {
		
	}
	public String EscolherCor(Scanner sc) {
	       
	        boolean corValida = false;
	        while (!corValida) {
	            System.out.println("\nEscolha uma opção de cor:\n");
	            System.out.println("[1]Branco\n[2]Vermelho\n[3]Preto\n");
	            String cor = sc.nextLine();
	            switch (cor) {
	                case "1":
	                    corEscolhida = "Branco";
	                    corValida = true;
	                    break;
	                case "2":
	                    corEscolhida = "Vermelho";
	                    corValida = true;
	                    break;
	                case "3":
	                    corEscolhida = "Preto";
	                    corValida = true;
	                    break;
	                default:
	                    System.out.println("Opção de cor inválida. Escolha uma opção válida.");
	                    break;
	            }
	        }
	        return corEscolhida;
	    }
	 public boolean isValidOption(String option) {
	        return option.equalsIgnoreCase("Start") ||
	               option.equalsIgnoreCase("Fan") ||
	               option.equalsIgnoreCase("Titan") ||
	               option.equalsIgnoreCase("Cargo") ||
	               option.equalsIgnoreCase("Elite125") ||
	               option.equalsIgnoreCase("Pop110i") ||
	               option.equalsIgnoreCase("X-ADV");
	    }

}
