package br.edu.ifnmg.web.grupostrabalho;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Hudson Rikelme <hudson.rikelme at ifnmg.edu.br>
 */
@Stateless
public class PessoaService implements PessoaServiceLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Pessoa pessoa) {
        em.persist(pessoa);
    }

    //<editor-fold defaultstate="collapsed" desc="Pessoas">
    /**
     * Buscar Todas as Pessoas Salvas no Banco, por Query, TypedQuery e
     *
     * @return
     */
    @Override
    public List<Pessoa> buscarTodasPessoas() {
        Query q = em.createQuery("SELECT p FROM Pessoa p");
        return (List<Pessoa>) q.getResultList();

    }

    @Override
    public List<Pessoa> buscarTodasPessoasTypedQuery() {
        TypedQuery q = em.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> buscarTodasPessoasNamedQuery() {
        return em.createNamedQuery("Pessoa.findAll", Pessoa.class)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="NomesPessoas">
    /**
     * Buscar Todos os nomes das Pessoas Salvas no Banco, por Query, TypedQuery
     * e NamedQuery
     *
     *
     * @return
     */
    @Override
    public List<String> buscarNomes() {
        return (List<String>) em.createQuery("SELECT p.nome FROM Pessoa p").getResultList();
    }

    @Override
    public List<Object[]> buscarNomesTypedQuery() {
        TypedQuery q = em.createNamedQuery("Pessoa.name", Object.class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> buscarNomesNamedQuery() {
        return em.createNamedQuery("Pessoa.name", Object[].class)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="NomesEnderecos">
    /**
     * Buscar Todos os nomes e Endereços das Pessoas Salvas no Banco, por Query,
     *
     */
    @Override
    public List<NomeEnderecoDTO> buscarNomesEnderecos() {
        return (List<NomeEnderecoDTO>) em.createQuery("SELECT new "
                + "br.edu.ifnmg.web.grupostrabalho.NomeEnderecoDTO(p.nome, p.endereco)"
                + "FROM Pessoa p", NomeEnderecoDTO.class)
                .getResultList();
    }

    @Override
    public List<NomeEnderecoDTO> buscarNomesEnderecosTypedQuery() {
        TypedQuery q = em.createNamedQuery("Pessoa.nameAndAdressDTO",
                NomeEnderecoDTO.class);
        return q.getResultList();
    }

    @Override
    public List<NomeEnderecoDTO> buscarNomesEnderecosNamedQuery() {
        return em.createNamedQuery("Pessoa.nameAndAdressDTO",
                NomeEnderecoDTO.class)
                .getResultList();
    }

//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="PessoasAvenidas">
    /**
     * Pessoas que moram em Avenidas
     */
    @Override
    public List<Pessoa> buscarPessoasAvenida() {
        Query q = em.createQuery("SELECT p FROM Pessoa p "
                + "JOIN p.endereco e "
                + "WHERE e.tipologradouro = "
                + ":tipo", Pessoa.class);
        q.setParameter("tipo", Endereco.TipoLogradouro.AVENIDA);

        return q.getResultList();
    }

    @Override
    public List<Pessoa> buscarPessoasAvenidaTypedQuery() {
        TypedQuery q = em.createQuery("SELECT p FROM Pessoa p "
                + "JOIN p.endereco e "
                + "WHERE e.tipologradouro = "
                + ":tipo", Pessoa.class);
        q.setParameter("tipo", Endereco.TipoLogradouro.AVENIDA);

        return q.getResultList();
    }

    @Override
    public List<Pessoa> buscarPessoasAvenidaNamedQuery() {
        TypedQuery q = em.createNamedQuery("Pessoa.findPeopleAvenue", Pessoa.class);
        q.setParameter("tipo", Endereco.TipoLogradouro.AVENIDA);
        return q.getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Pessoas Que não Moram em Pracas">
    /**
     * Pessoas que não moram em pracas
     */
    @Override
    public List<Pessoa> buscarPessoasNaoPraca() {
        Query q = em.createQuery("SELECT p FROM Pessoa p "
                + "JOIN p.endereco e "
                + "WHERE e.tipologradouro != "
                + ":tipo");
        q.setParameter("tipo", Endereco.TipoLogradouro.PRACA);
        return (List<Pessoa>) q.getResultList();
    }

    @Override
    public List<Pessoa> buscarPessoasNaoPracaTypedQuery() {
        TypedQuery q = em.createQuery("SELECT p FROM Pessoa p "
                + "JOIN p.endereco e "
                + "WHERE e.tipologradouro != "
                + ":tipo", Pessoa.class);
        q.setParameter("tipo", Endereco.TipoLogradouro.PRACA);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> buscarPessoasNaoPracaNamedQuery() {
        TypedQuery q = em.createNamedQuery("Pessoa.findPeopleNotSquare", Pessoa.class);
        q.setParameter("tipo", Endereco.TipoLogradouro.PRACA);
        return q.getResultList();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Pessoas e Seus Respectivos Telefones">
    /**
     * Pessoas e Seus Respectivos Telefones
     */
    @Override
    public List<Object[]> buscarPessoaTelefones() {
        return em.createQuery("SELECT p.nome, t.ddd, t.numero "
                + "FROM Pessoa p JOIN p.telefones t")
                .getResultList();
    }

    @Override
    public List<Object[]> buscarPessoaTelefonesTypedQuery() {
        TypedQuery<Object[]> q = em.createQuery(
                "SELECT p.nome, t.ddd, t.numero FROM Pessoa p JOIN p.telefones t", Object[].class);
        return q.getResultList();
    }

    @Override
    public List<Object[]> buscarPessoaTelefonesNamedQuery() {
        TypedQuery<Object[]> q = em.createNamedQuery("Pessoa.findPeopleAndPhones", Object[].class);
        return q.getResultList();
    }
//</editor-fold>
    
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Grupos não Ativos">

    /**
     * Grupos Não Ativos
     */
    @Override
    public List<Grupo> buscarGruposInativos() {
        return em.createQuery("SELECT g FROM Grupo g WHERE g.ativo = false")
                .getResultList();
    }

    @Override
    public List<Grupo> buscarGruposInativosTypedQuery() {
        TypedQuery q = em.createQuery(
                "SELECT g FROM Grupo g WHERE g.ativo = false", Grupo.class);
        return q.getResultList();
    }

    @Override
    public List<Grupo> buscarGrupoInativosNamedQuery() {
        TypedQuery<Grupo> q = em.createNamedQuery("Grupo.findGroupInative", Grupo.class);
        return q.getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Líderes dos grupos">
//    @Override
//    public List<Object> buscarLideres() {
//        return em.createQuery("SELECT g.nome, g.lider FROM Grupo g ")
//                .getResultList();
//    }

//    @Override
//    public List<Grupo> buscarLideresTypedQuery() {
//        TypedQuery q = em.createQuery(
//                "SELECT g FROM Grupo g WHERE g.ativo = false", Grupo.class);
//        return q.getResultList();
//    }
//
//    @Override
//    public List<Grupo> buscarLideresNamedQuery() {
//        TypedQuery<Grupo> q = em.createNamedQuery("Grupo.findGroupInative", Grupo.class);
//        return q.getResultList();
//    }
//</editor-fold>
}
