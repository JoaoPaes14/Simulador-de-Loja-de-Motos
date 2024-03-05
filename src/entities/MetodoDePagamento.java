package entities;

public class MetodoDePagamento {
	public double  PagarAvista;
	public double imposto = 1.2;
	public double valorMoto=0;
	public double parcelar;
	public double juros =1.1;
	public double entrada=0;
	public double valorFinal=0;
	
	public MetodoDePagamento() {
		
		
	}

	public MetodoDePagamento(double valorFinal, double imposto, double valorMoto, double parcelar, double juros,double entrada) {
		
		this.valorFinal = valorFinal;
		this.imposto = imposto;
		this.valorMoto = valorMoto;
		this.parcelar = parcelar;
		this.juros = juros;
		this.entrada=entrada;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}

	public double getValorMoto() {
		return valorMoto;
	}

	public void setValorMoto(double valorMoto) {
		this.valorMoto = valorMoto;
	}

	public double getParcelar() {
		return parcelar;
	}

	public void setParcelar(double parcelar) {
		this.parcelar = parcelar;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}
	
	public double getEntrada() {
		return entrada;
	}

	public void setEntrada(double entrada) {
		this.entrada = entrada;
	}

	public double PagamentoAvista() {
        return valorFinal = valorMoto * imposto;
}
	
	public double PagamentoParceladoComEntrada() {
        return valorFinal = (valorMoto*imposto*juros)-entrada;
   }
	public double PagamentoParceladoSemEntrada() {
        return valorFinal = valorMoto * imposto*juros;
   }
	public double ValorDasParcelas() {
		return parcelar = valorFinal/ parcelar;
	}
}
