package br.edu.ifnmg.web.grupostrabalho;

/**
 *
 * @author Hudson Rikelme <hudson.rikelme at ifnmg.edu.br>
 */
public class GrupoLiderDTO {
    private String grupoNome;
    private String liderNome;

    public GrupoLiderDTO() {
    }

    public GrupoLiderDTO(String grupoNome, String liderNome) {
        this.grupoNome = grupoNome;
        this.liderNome = liderNome;
    }

    public String getGrupoNome() {
        return grupoNome;
    }

    public void setGrupoNome(String grupoNome) {
        this.grupoNome = grupoNome;
    }

    public String getLiderNome() {
        return liderNome;
    }

    public void setLiderNome(String liderNome) {
        this.liderNome = liderNome;
    }

    @Override
    public String toString() {
        return "GrupoLiderDTO{" 
                + "grupoNome=" + grupoNome 
                + ", liderNome=" + liderNome 
                + '}';
    }
}
