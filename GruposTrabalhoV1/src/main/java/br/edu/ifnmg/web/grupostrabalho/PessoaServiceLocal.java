package br.edu.ifnmg.web.grupostrabalho;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hudson Rikelme <hudson.rikelme at ifnmg.edu.br>
 */
@Local
public interface PessoaServiceLocal {

    void salvar(Pessoa pessoa);

    List<Pessoa> buscarTodasPessoas();

    List<Pessoa> buscarTodasPessoasTypedQuery();

    List<Pessoa> buscarTodasPessoasNamedQuery();

    List<Object[]> buscarNomesTypedQuery();

    List<Object[]> buscarNomesNamedQuery();

    List<String> buscarNomes();

    List<NomeEnderecoDTO> buscarNomesEnderecos();

    List<NomeEnderecoDTO> buscarNomesEnderecosTypedQuery();

    List<NomeEnderecoDTO> buscarNomesEnderecosNamedQuery();

    List<Pessoa> buscarPessoasAvenida();

    List<Pessoa> buscarPessoasAvenidaTypedQuery();

//    List<Pessoa> buscarPessoasAvenidaNamedQuery();
}
