package br.edu.ifnmg.web.grupostrabalho;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Hudson Rikelme <hudson.rikelme at ifnmg.edu.br>
 */
@Singleton
@Startup
public class CargaDados implements CargaDadosLocal {

    @Inject
    private PessoaServiceLocal psl;

    @PostConstruct
    @Override
    public void PopularBanco() {

        //Enderecos
        Endereco e = new Endereco();
        e.setBairro("Bairro Humberto");
        e.setLogradouro("Rua 1");
        e.setTipologradouro(Endereco.TipoLogradouro.RUA);
        e.setNumero(1111);

        Endereco e1 = new Endereco();
        e1.setBairro("Bairro Doisberto");
        e1.setLogradouro("Avenida 2");
        e1.setTipologradouro(Endereco.TipoLogradouro.AVENIDA);
        e1.setNumero(2222);

        Endereco e2 = new Endereco();
        e2.setBairro("Bairro Trêsberto");
        e2.setLogradouro("Avenida 3");
        e2.setTipologradouro(Endereco.TipoLogradouro.AVENIDA);
        e2.setNumero(3333);

        Endereco e3 = new Endereco();
        e3.setBairro("Bairro Quatroberto");
        e3.setLogradouro("Praca 4");
        e3.setTipologradouro(Endereco.TipoLogradouro.PRACA);
        e3.setNumero(4444);

        //Telefones
        Telefone tel = new Telefone();
        tel.setDdd((byte) 11);
        tel.setNumero(11111111);

        Telefone tel1 = new Telefone();
        tel1.setDdd((byte) 12);
        tel1.setNumero(12121212);

        Telefone tel2 = new Telefone();
        tel2.setDdd((byte) 13);
        tel2.setNumero(13131313);

        Telefone tel3 = new Telefone();
        tel3.setDdd((byte) 22);
        tel3.setNumero(22222222);

        Telefone tel4 = new Telefone();
        tel4.setDdd((byte) 44);
        tel4.setNumero(44444444);

        Telefone tel5 = new Telefone();
        tel5.setDdd((byte) 45);
        tel5.setNumero(45454545);

        //Pessoas
        Pessoa p = new Pessoa();
        p.setNome("Ana Zaira");
        p.setEmail("ana@mail.com");
        p.setNascimento(LocalDate.of(2001, 01, 01));
        p.setEndereco(e);
        p.getTelefones().add(tel);
        p.getTelefones().add(tel1);
        p.getTelefones().add(tel2);

        Pessoa p1 = new Pessoa();
        p1.setNome("Beatriz Yana");
        p1.setEmail("beatriz@mail.com");
        p1.setNascimento(LocalDate.of(2002, 02, 02));
        p1.setEndereco(e1);
        p1.getTelefones().add(tel3);

        Pessoa p2 = new Pessoa();
        p2.setNome("Cecília Xerxes");
        p2.setEmail("Cecilia@mail.com");
        p2.setNascimento(LocalDate.of(2003, 03, 03));
        p2.setEndereco(e2);

        Pessoa p3 = new Pessoa();
        p3.setNome("Débora Wendel");
        p3.setEmail("Debora@mail.com");
        p3.setNascimento(LocalDate.of(2004, 04, 04));
        p3.setEndereco(e3);
        p3.getTelefones().add(tel4);
        p3.getTelefones().add(tel5);

        /**
         * Estudo 1 - Inativo Atuaçoes Lider e Membros
         */
        Grupo g = new Grupo();
        g.setNome("Estudo 1");
        g.setAtivo(Boolean.FALSE);

        Atuacao a = new Atuacao();
        a.setInicio(LocalDate.of(2011, 01, 01));
        a.setTermino(LocalDate.of(2021, 11, 11));
        a.setGrupo(g);
        a.setPessoa(p);
        //Colocando o Lider do Grupo
        g.setLider(p);

        Atuacao a1 = new Atuacao();
        a1.setGrupo(g);
        a1.setInicio(LocalDate.of(2012, 01, 01));
        a1.setTermino(LocalDate.of(2022, 11, 11));
        a1.setPessoa(p);

        Atuacao a2 = new Atuacao();
        a2.setGrupo(g);
        a2.setInicio(LocalDate.of(2012, 01, 02));
        a2.setTermino(LocalDate.of(2021, 01, 12));
        a2.setPessoa(p1);

        Atuacao a3 = new Atuacao();
        a3.setGrupo(g);
        a3.setInicio(LocalDate.of(2013, 01, 03));
        a3.setTermino(LocalDate.of(2021, 01, 13));
        a3.setPessoa(p2);

        Atuacao a4 = new Atuacao();
        a4.setGrupo(g);
        a4.setInicio(LocalDate.of(2014, 01, 04));
        a4.setTermino(LocalDate.of(2021, 01, 14));
        a4.setPessoa(p3);

        g.getAtuacoes().add(a);
        g.getAtuacoes().add(a1);
        g.getAtuacoes().add(a2);
        g.getAtuacoes().add(a3);
        g.getAtuacoes().add(a4);

        p.getAtuacoes().add(a);
        p.getAtuacoes().add(a1);
        p1.getAtuacoes().add(a2);
        p2.getAtuacoes().add(a3);
        p3.getAtuacoes().add(a4);

        /**
         * Estudo 2 - Ativo Atuaçoes Lider e Membros
         */
        Grupo g1 = new Grupo();
        g1.setNome("Estudo 2");
        g1.setAtivo(Boolean.TRUE);

        Atuacao a5 = new Atuacao();
        a5.setInicio(LocalDate.of(2012, 01, 02));
        a5.setGrupo(g1);
        a5.setPessoa(p1);
        //Colocando o Lider do Grupo
        g1.setLider(p1);

        Atuacao a6 = new Atuacao();
        a6.setGrupo(g1);
        a6.setInicio(LocalDate.of(2012, 01, 02));
        a6.setPessoa(p3);

        g1.getAtuacoes().add(a5);
        g1.getAtuacoes().add(a6);

        p1.getAtuacoes().add(a5);
        p3.getAtuacoes().add(a6);

        /**
         * Estudo 3 - Inativo Atuaçoes Lider e Membros
         */
        Grupo g2 = new Grupo();
        g2.setNome("Estudo 3");
        g2.setAtivo(Boolean.FALSE);

        Atuacao a7 = new Atuacao();
        a7.setInicio(LocalDate.of(2012, 01, 03));
        a7.setTermino(LocalDate.of(2023, 01, 13));
        a7.setGrupo(g2);
        a7.setPessoa(p2);
        //Colocando o Lider do Grupo
        g2.setLider(p2);

        Atuacao a8 = new Atuacao();
        a8.setGrupo(g2);
        a8.setInicio(LocalDate.of(2012, 01, 03));
        a8.setTermino(LocalDate.of(2023, 01, 13));
        a8.setPessoa(p3);

        g2.getAtuacoes().add(a7);
        g2.getAtuacoes().add(a8);

        p2.getAtuacoes().add(a7);
        p3.getAtuacoes().add(a8);

        /**
         * Estudo 4 - Ativo Atuaçoes Lider e Membros
         */
        Grupo g3 = new Grupo();
        g3.setNome("Estudo 4");
        g3.setAtivo(Boolean.TRUE);

        Atuacao a9 = new Atuacao();
        a9.setInicio(LocalDate.of(2012, 01, 04));
        a9.setTermino(LocalDate.of(2024, 01, 14));
        a9.setGrupo(g3);
        a9.setPessoa(p1);
        //Colocando o Lider do Grupo
        g3.setLider(p1);

        Atuacao a10 = new Atuacao();
        a10.setGrupo(g3);
        a10.setInicio(LocalDate.of(2012, 01, 04));
        a10.setTermino(LocalDate.of(2024, 01, 14));
        a10.setPessoa(p2);

        Atuacao a11 = new Atuacao();
        a11.setGrupo(g3);
        a11.setInicio(LocalDate.of(2012, 01, 04));
        a11.setTermino(LocalDate.of(2024, 01, 14));
        a11.setPessoa(p3);

        g3.getAtuacoes().add(a9);
        g3.getAtuacoes().add(a10);
        g3.getAtuacoes().add(a11);

        p1.getAtuacoes().add(a9);
        p2.getAtuacoes().add(a10);
        p3.getAtuacoes().add(a11);

        // Salvamento via beans de sessão
        psl.salvar(p);
        psl.salvar(p1);
        psl.salvar(p2);
        psl.salvar(p3);

    }

}
