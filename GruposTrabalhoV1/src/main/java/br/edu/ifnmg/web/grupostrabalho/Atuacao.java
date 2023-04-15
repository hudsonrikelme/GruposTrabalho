package br.edu.ifnmg.web.grupostrabalho;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Hudson Rikelme <hudson.rikelme at ifnmg.edu.br>
 */
@NamedQueries({
    @NamedQuery(
            name = "Atuacao.findMemberGroup",
            query = "SELECT a.pessoa.nome FROM Atuacao a"
            + " WHERE a.grupo.nome = :grupo "
            + "ORDER BY a.pessoa.nome DESC"
    ),
    @NamedQuery(
            name = "Atuacao.findDatasNomeGrupoMembro",
            query = "SELECT a.inicio,a.termino,a.grupo.nome FROM"
            + " Atuacao a WHERE a.pessoa.nome = :nome"
    )
})
@Entity
public class Atuacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private LocalDate inicio;

    private LocalDate termino;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Atuacao() {
//        pessoas = new ArrayList<>();
//        grupos = new ArrayList<>();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }

    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
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
        if (!(object instanceof Atuacao)) {
            return false;
        }
        Atuacao other = (Atuacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Atuacao{"
                + "id=" + id
                + "<br>, inicio=" + inicio
                + "<br>, termino=" + termino
                + "<br>, pessoa=" + pessoa.getNome()
                + "<br>, grupo=" + grupo.getNome()
                + '}';
    }

//</editor-fold>
}
