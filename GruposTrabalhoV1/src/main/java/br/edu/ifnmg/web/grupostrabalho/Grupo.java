package br.edu.ifnmg.web.grupostrabalho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Hudson Rikelme <hudson.rikelme at ifnmg.edu.br>
 */
@NamedQueries({
    @NamedQuery(
          name = "Grupo.findGroupLeader",
            query = "SELECT new br.edu.ifnmg.web"
            + ".grupostrabalho.GrupoLiderDTO(g.nome,l.nome)"
            + " FROM Grupo g JOIN g.lider l"
    ),
    
    
    
    
    
    
    
})
@Entity
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 65)
    private String nome;

    @Column(nullable = false)
    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "lider_id")
    private Pessoa lider;

    @OneToMany(mappedBy = "grupo",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Atuacao> atuacoes;

    public Grupo() {
        atuacoes = new ArrayList<>();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public Pessoa getLider() {
        return lider;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="HashCode/Equals/ToString">

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//</editor-fold>
    @Override
    public String toString() {
        return "Grupo{"
                + "id=" + id
                + "<br>, nome=" + nome
                + "<br>, ativo=" + ativo
                + "<br>, lider=" + lider.getNome()
                + "<br>, atuacoes=" + atuacoes
                + '}';
    }

}
