package entities;

public class Cliente {
	private String nome;
	private String email;
	private String cpf;
	private String cep;
	private String numero;
	
	public Cliente() {
		
	}

	public Cliente(String nome, String email, String cpf, String cep, String numero) {		
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cep = cep;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}
}


