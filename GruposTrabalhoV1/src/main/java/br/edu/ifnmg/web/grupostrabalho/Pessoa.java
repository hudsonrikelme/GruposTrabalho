package br.edu.ifnmg.web.grupostrabalho;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Hudson Rikelme <hudson.rikelme at ifnmg.edu.br>
 */
@Entity
//<editor-fold defaultstate="collapsed" desc="Queries">
@NamedQueries({
    @NamedQuery(
            name = "Pessoa.findAll",
            query = "SELECT p FROM Pessoa p"
    ),
    @NamedQuery(
            name = "Pessoa.name",
            query = "SELECT p.nome FROM Pessoa p"
    ),
    @NamedQuery(
            name = "Pessoa.nameAndAdressDTO",
            query = "SELECT new br.edu.ifnmg.web.grupostrabalho.NomeEnderecoDTO(p.nome, p.endereco) FROM Pessoa p"
    ),
    @NamedQuery(
            name = "Pessoa.findPeopleAvenue",
            query = "SELECT p FROM Pessoa p "
            + "JOIN p.endereco e "
            + "WHERE e.tipologradouro = "
            + ":tipo"
    ),
    @NamedQuery(
            name = "Pessoa.findPeopleNotSquare",
            query = "SELECT p FROM Pessoa p "
            + "JOIN p.endereco e "
            + "WHERE e.tipologradouro != "
            + ":tipo"
    ),
    @NamedQuery(
            name = "Pessoa.findPeopleAndPhones",
            query = "SELECT p.nome, t.ddd, t.numero "
            + "FROM Pessoa p "
            + "JOIN p.telefones t "
    ),
    @NamedQuery(
            name = "Grupo.findGroupInative",
            query = "SELECT g FROM Grupo g WHERE g.ativo = false"
    ), 
    @NamedQuery(
            name = "Pessoa.findPeopleBirth",
            query = "SELECT p FROM Pessoa p WHERE p.nascimento"
            + " BETWEEN :dataMinima AND :dataMaxima"
    ),
    @NamedQuery(
            name = "Pessoa.findPeopleNotPhone",
            query = "SELECT p FROM Pessoa p WHERE p.telefones IS EMPTY"
    ),
    @NamedQuery(
            name = "Pessoa.findQuantityPhone",
            query = "SELECT p.nome, COUNT(t.id)"
                    + " FROM Pessoa p JOIN p.telefones t GROUP BY p.nome"
    ),
    
})

//</editor-fold>
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65, nullable = false)
    private String nome;

    @Column(length = 250, nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate nascimento;

    //Notação Transient não utilizada para que a idade fosse persistida no BD
//    @Transient
    private Byte idade;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "pessoa",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Atuacao> atuacoes;

    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Endereco endereco;

    @OneToMany(mappedBy = "lider",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Grupo> grupoLider;

    public Pessoa() {
        telefones = new ArrayList<>();
        atuacoes = new ArrayList<>();
        grupoLider = new ArrayList<>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        idade = (byte) Period.between(nascimento, LocalDate.now()).getYears();
    }

    public Byte getIdade() {
        return idade;
    }

    public void setIdade(Byte idade) {
        this.idade = idade;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Grupo> getGrupoLider() {
        return grupoLider;
    }

    public void setGrupoLider(List<Grupo> grupoLider) {
        this.grupoLider = grupoLider;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Hash/Equals/To String">
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{"
                + "id=" + id
                + "<br>, nome=" + nome
                + "<br>, email=" + email
                + "<br>, nascimento=" + nascimento
                + "<br>, idade=" + idade
                + "<br>, telefones=" + telefones
                + "<br>, atuacoes=" + atuacoes
                + "<br>, endereco=" + endereco
                + '}';
    }

//</editor-fold>
}
