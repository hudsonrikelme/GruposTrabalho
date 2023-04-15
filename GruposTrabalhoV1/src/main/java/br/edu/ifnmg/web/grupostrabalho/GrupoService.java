package br.edu.ifnmg.web.grupostrabalho;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Hudson Rikelme <hudson.rikelme at ifnmg.edu.br>
 */
@Stateless
public class GrupoService implements GrupoServiceLocal {

    @PersistenceContext
    private EntityManager em;

    //<editor-fold defaultstate="collapsed" desc="Buscar Grupos e Lideres">
    @Override
    public List<GrupoLiderDTO> buscarLideres() {
        return em.createNamedQuery("Grupo.findGroupLeader", GrupoLiderDTO.class)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Pessoas do grupo de estudo 4">
    /**
     * Quais são os membros (nomes) do grupo com nome “Estudo IV” com ordenação
     * alfabética inversa?
     */
    @Override
    public List<String> buscarMembrosGrupo(String grupo) {

        return em.createNamedQuery("Atuacao.findMemberGroup", String.class)
                .setParameter("grupo", grupo)
                .getResultList();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="grupos liderados Beatriz Yana">
    /**
     * Quais são os grupos (dados completos) liderados por “Beatriz Yana”?
     */
    @Override
    public List<Grupo> buscarGruposLider(String lider) {

        return em.createNamedQuery("Grupo.findLeaderGroup", Grupo.class)
                .setParameter("nome", lider)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Datas Membro do Grupo">
    @Override
    public List<Object[]> buscarDatasNomeGrupoMembro(String nome) {
        return em.createNamedQuery("Atuacao.findDatasNomeGrupoMembro", Object[].class)
                .setParameter("nome", nome)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Grupo Nome Parte">
    @Override
    public List<Grupo> buscarGrupoNomeParte(String nome) {
        return em.createNamedQuery("Grupo.findGroupPart", Grupo.class)
                .setParameter("nome", nome)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Quantidade de Membros">
    @Override
    public List<Object[]> buscarNomesQtdMembros() {
        return em.createNamedQuery("Grupo.findNomeQtdMembros", Object[].class)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Nomes Maiores">
    @Override
    public List<Object[]> buscarNomesMaiorQtd(Integer qtd) {

        return em.createNamedQuery("Grupo.findNomesQtdAtuacoes", Object[].class)
                .setParameter("qtd", qtd)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Grupo Data Nome">
    @Override
    public List<String> buscarGrupoDataNome(Integer ano, Long grupoid) {
        return em.createNamedQuery("Grupo.findMembrosAPartirData", String.class)
                .setParameter("ano", ano)
                .setParameter("id", grupoid)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Nomes de Membros Inicio">
    @Override
    public List<MembroDTO> buscarNomesMembrosInicioParam(Long gid, LocalDate data) {
        return em.createNamedQuery("Grupo.findNomesMembrosEntradaParam", MembroDTO.class)
                .setParameter("gid", gid)
                .setParameter("data", data)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Membros Sem Termino">
    @Override
    public List<Object[]> buscarNomesMembrosSemTermino() {
        return em.createNamedQuery("Grupo.endlessMember", Object[].class)
                .getResultList();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="LiderMembros">
    @Override
    public List<Object[]> buscarNomeLiderMembros() {
        return em.createNamedQuery("Grupo.findLeaderMember", Object[].class)
                .getResultList();
    }

//</editor-fold>
}
