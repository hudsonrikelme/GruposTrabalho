package br.edu.ifnmg.web.grupostrabalho;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hudson Rikelme <hudson.rikelme at ifnmg.edu.br>
 */
@Local
public interface GrupoServiceLocal {
    List<GrupoLiderDTO> buscarLideres();

    List<String> buscarMembrosGrupo(String grupo);

    List<Grupo> buscarGruposLider(String lider);

    List<Object[]> buscarDatasNomeGrupoMembro(String nome);

    List<Grupo> buscarGrupoNomeParte(String nome);

    List<Object[]> buscarNomesQtdMembros();

    List<Object[]> buscarNomesMaiorQtd(Integer qtd);

    List<String> buscarGrupoDataNome(Integer ano, Long grupoid);

    List<Object[]> buscarNomesMembrosSemTermino();

    List<Object[]> buscarNomeLiderMembros();

    List<MembroDTO> buscarNomesMembrosInicioParam(Long gid, LocalDate data);
}
