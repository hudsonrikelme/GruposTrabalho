package br.edu.ifnmg.web.grupostrabalho;

/**
 *
 * @author Hudson Rikelme <hudson.rikelme at ifnmg.edu.br>
 */
public class NomeEnderecoDTO {

    private String nome;
    private Endereco endereco;

    public NomeEnderecoDTO(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public NomeEnderecoDTO() {
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

//</editor-fold>
    @Override
    public String toString() {
        return "NomeEndereco{"
                + "nome=" + nome
                + ", endereco=" + endereco + '}';
    }

}
