package digital.project.bookstorejava.entidade;

public class Cliente {

    private String nome;

    private String cpf;

    public Cliente() {
        this.nome = "Fulano";
        this.cpf = "123456789011";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{ nome='" + nome + "'}";
    }
}
