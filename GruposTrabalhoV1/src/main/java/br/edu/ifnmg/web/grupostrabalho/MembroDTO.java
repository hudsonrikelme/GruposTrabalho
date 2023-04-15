package br.edu.ifnmg.web.grupostrabalho;

import java.time.LocalDate;

/**
 *
 * @author Hudson Rikelme <hudson.rikelme at ifnmg.edu.br>
 */
public class MembroDTO {

    private String grupoNome;
    private String pessoaNome;
    private LocalDate dataInicio;

    public MembroDTO(String grupoNome, String pessoaNome, LocalDate dataInicio) {
        this.grupoNome = grupoNome;
        this.pessoaNome = pessoaNome;
        this.dataInicio = dataInicio;
    }

    public MembroDTO() {
    }

    public String getGrupoNome() {
        return grupoNome;
    }

    public void setGrupoNome(String grupoNome) {
        this.grupoNome = grupoNome;
    }

    public String getPessoaNome() {
        return pessoaNome;
    }

    public void setPessoaNome(String pessoaNome) {
        this.pessoaNome = pessoaNome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "MembroDTO{" + "grupoNome=" + grupoNome + ", pessoaNome=" + pessoaNome + ", dataInicio=" + dataInicio + '}';
    }
}
