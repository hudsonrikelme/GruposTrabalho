package br.edu.ifnmg.web.grupostrabalho;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

/**
 *
 * @author Hudson Rikelme <hudson.rikelme at ifnmg.edu.br>
 */
@WebServlet(name = "RelatoriosServlet", urlPatterns = {"/Relatorios"})
@Transactional
public class RelatoriosServlet extends HttpServlet {

    @Inject
    PessoaServiceLocal pessoaservice;

    @Inject
    GrupoServiceLocal gruposervice;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //Testes com JPQL
            //Buscar Todas as Pessoas
            List<Pessoa> todasPessoas = pessoaservice.buscarTodasPessoas();
            List<Pessoa> todasPessoasTQ = pessoaservice.buscarTodasPessoasTypedQuery();
            List<Pessoa> todasPessoasNQ = pessoaservice.buscarTodasPessoasNamedQuery();

            //Buscar Nome das Pessoas
            List<String> nomePessoas = pessoaservice.buscarNomes();
            List<Object[]> nomePessoasTQ = pessoaservice.buscarNomesTypedQuery();
            List<Object[]> nomePessoasNQ = pessoaservice.buscarNomesNamedQuery();

            //Buscar Nome e Endereco
            List<NomeEnderecoDTO> nomesEnderecos = pessoaservice.buscarNomesEnderecos();
            List<NomeEnderecoDTO> nomesEnderecosTQ = pessoaservice.buscarNomesEnderecosTypedQuery();
            List<NomeEnderecoDTO> nomesEnderecosNQ = pessoaservice.buscarNomesEnderecosNamedQuery();

            //Buscar Todas as Pessoas que Moram em Avenidas
            List<Pessoa> pessoaAvenida = pessoaservice.buscarPessoasAvenida();
            List<Pessoa> pessoaAvenidaTQ = pessoaservice.buscarPessoasAvenidaTypedQuery();
            List<Pessoa> pessoaAvenidaNQ = pessoaservice.buscarPessoasAvenidaNamedQuery();

            //Buscar Pessoas que não Moram em Pracas
            List<Pessoa> pessoaNaoPraca = pessoaservice.buscarPessoasNaoPraca();
            List<Pessoa> pessoaNaoPracaTQ = pessoaservice.buscarPessoasNaoPracaTypedQuery();
            List<Pessoa> pessoaNaoPracaNQ = pessoaservice.buscarPessoasNaoPracaNamedQuery();

            //Buscar Pessoas e Seus Respectivos Telefones
            List<Object[]> pessoaTelefones = pessoaservice.buscarPessoaTelefones();
            List<Object[]> pessoaTelefonesTQ = pessoaservice.buscarPessoaTelefonesTypedQuery();
            List<Object[]> pessoaTelefonesNQ = pessoaservice.buscarPessoaTelefonesNamedQuery();

            //Buscar Grupos Inativos
            List<Grupo> grupoinativo = pessoaservice.buscarGruposInativos();
            List<Grupo> grupoinativoTQ = pessoaservice.buscarGruposInativosTypedQuery();
            List<Grupo> grupoinativoNQ = pessoaservice.buscarGrupoInativosNamedQuery();
            //Buscar Pessoas Nascimento
            List<Pessoa> pessoaNascimento = pessoaservice.
                    buscarNascimento(
                            LocalDate.of(2001, Month.APRIL, 01),
                            LocalDate.of(2004, Month.APRIL, 30)
                    );

            //Pessoas sem Telefone
            List<Pessoa> pessoaNaoTelefone = pessoaservice.buscarSemTelefone();

            //Buscar Grupos e respectivos Líderes
            List<GrupoLiderDTO> grupoLider = gruposervice.buscarLideres();

            //Buscar Quantidade de Telefones por pessoa
            List<Object[]> quantidadeTelefone = pessoaservice.buscarQtdTelefone();

            //Membros do Estudo IV
            List<String> grupoMembros = gruposervice.buscarMembrosGrupo("Estudo IV");
     
            //Encontrar Grupos Lider Beatriz Yana
            List<Grupo> Lidergrupo = gruposervice.buscarGruposLider("Beatriz Yana");
            
            //Quais são as datas de início e de término da atuação e os grupos (nomes) nos quais “Cecília Xerxes” é membro?
            List<Object[]> datasGrupoNome = gruposervice.buscarDatasNomeGrupoMembro("Cecília Xerxes");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RelatoriosServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>JPQL</h1>");

            //Questao 1
            out.println("<ul>");
            out.println("<h2>01 - Pessoas Cadastradas</h2>");
            out.println("<ul>");
            out.println("<h2>a)Por Meio de Query</h2>");
            out.println("<ul>");
            for (Pessoa pessoa : todasPessoas) {
                out.println("<li>" + pessoa + "</li>");
            }
            out.println("</ul>");

            out.println("<h2>b)Por meio de TypedQuery</h2>");
            out.println("<ul>");
            for (Pessoa pessoa : todasPessoasTQ) {
                out.println("<li>" + pessoa + "</li>");
            }
            out.println("</ul>");

            out.println("<h2>c)Por meio de NamedQuery</h2>");
            out.println("<ul>");
            for (Pessoa pessoa : todasPessoasNQ) {
                out.println("<li>" + pessoa + "</li>");
            }
            out.println("</ul>");

            //Questao 2
            out.println("</ul>");
            out.println("<h2>02 - Nomes das Pessoas Cadastradas</h2>");
            out.println("<ul>");
            out.println("<h2>a)Por Meio de Query</h2>");
            out.println("<ul>");

            for (String s : nomePessoas) {
                out.println("<li>" + s + "</li>");
            }
            out.println("</ul>");

            out.println("<h2>b)Por meio de TypedQuery</h2>");
            out.println("<ul>");
            for (Object o : nomePessoasTQ) {
                out.println("<li>" + o + "</li>");
            }
            out.println("</ul>");

            out.println("<h2>c)Por meio de NamedQuery</h2>");
            out.println("<ul>");
            for (Object o : nomePessoasNQ) {
                out.println("<li>" + o + "</li>");
            }
            out.println("</ul>");

            //Questao 3
            out.println("</ul>");
            out.println("<h2>03 - Nomes e Endereços das Pessoas Cadastradas </h2>");
            out.println("<ul>");
            out.println("<h2>a)Por meio de Query</h2>");
            out.println("<ul>");
            for (NomeEnderecoDTO nomesEndereco : nomesEnderecos) {
                out.println("<li>" + nomesEndereco + "</li>");
            }
            out.println("</ul>");
            out.println("<h2>b)Por meio de TypedQuery</h2>");
            out.println("<ul>");
            for (NomeEnderecoDTO o : nomesEnderecosTQ) {
                out.println("<li>" + o.getNome() + "," + o.getEndereco() + "</li>");
            }
            out.println("</ul>");
            out.println("<h2>c)Por meio de NamedQuery</h2>");
            out.println("<ul>");
            for (NomeEnderecoDTO o : nomesEnderecosNQ) {
                out.println("<li>" + o.getNome() + "," + o.getEndereco() + "</li>");
            }
            out.println("</ul>");
            //Questao 4
            out.println("</ul>");
            out.println("<h2>04 - Pessoas que Moram em Avenidas</h2>");
            out.println("<ul>");
            out.println("<h2>a)Por Meio de Query</h2>");
            out.println("<ul>");

            for (Pessoa pessoa : pessoaAvenida) {
                out.println("<li>" + pessoa.getNome() + " --> " + pessoa.getEndereco().getTipologradouro() + "</li>");
            }
            out.println("</ul>");
            out.println("<h2>b)Por meio de TypedQuery</h2>");
            out.println("<ul>");
            for (Pessoa pessoa : pessoaAvenidaTQ) {
                out.println("<li>" + pessoa.getNome() + "-->" + pessoa.getEndereco().getTipologradouro() + "</li>");
            }
            out.println("</ul>");

            out.println("<h2>c)Por meio de NamedQuery</h2>");
            out.println("<ul>");
            for (Pessoa pessoa : pessoaAvenidaNQ) {
                out.println("<li>" + pessoa.getNome() + "-->" + pessoa.getEndereco().getTipologradouro() + "</li>");
            }
            out.println("</ul>");

            //Questao 5
            out.println("</ul>");
            out.println("<h2>05 - Pessoas que não Moram em Pracas</h2>");
            out.println("<ul>");
            out.println("<h2>a)Por Meio de Query</h2>");
            out.println("<ul>");

            for (Pessoa pessoa : pessoaNaoPraca) {
                out.println("<li>" + pessoa.getNome() + " --> " + pessoa.getEndereco().getTipologradouro() + "</li>");
            }
            out.println("</ul>");
            out.println("<h2>b)Por meio de TypedQuery</h2>");
            out.println("<ul>");
            for (Pessoa pessoa : pessoaNaoPracaTQ) {
                out.println("<li>" + pessoa.getNome() + "-->" + pessoa.getEndereco().getTipologradouro() + "</li>");
            }
            out.println("</ul>");

            out.println("<h2>c)Por meio de NamedQuery</h2>");
            out.println("<ul>");
            for (Pessoa pessoa : pessoaNaoPracaNQ) {
                out.println("<li>" + pessoa.getNome() + "-->" + pessoa.getEndereco().getTipologradouro() + "</li>");
            }
            out.println("</ul>");

            //Questao 6
            out.println("</ul>");
            out.println("<h2>06 - Pessoas e Seus Respectivos Telefones</h2>");
            out.println("<ul>");
            out.println("<h2>a)Por Meio de Query</h2>");
            out.println("<ul>");

            for (Object[] resultado : pessoaTelefones) {
                String nome = (String) resultado[0];
                Byte ddd = (Byte) resultado[1];
                Integer numero = (Integer) resultado[2];
                out.println("<li>" + nome + "--> (" + ddd + ") " + numero + "</li>");
            }
            out.println("</ul>");
            out.println("<h2>b)Por meio de TypedQuery</h2>");
            out.println("<ul>");
            for (Object[] resultado : pessoaTelefonesTQ) {
                String nome = (String) resultado[0];
                Byte ddd = (Byte) resultado[1];
                Integer numero = (Integer) resultado[2];
                out.println("<li>" + nome + "--> (" + ddd + ") " + numero + "</li>");
            }
            out.println("</ul>");

            out.println("<h2>c)Por meio de NamedQuery</h2>");
            out.println("<ul>");
            for (Object[] resultado : pessoaTelefonesNQ) {
                String nome = (String) resultado[0];
                Byte ddd = (Byte) resultado[1];
                Integer numero = (Integer) resultado[2];
                out.println("<li>" + nome + "--> (" + ddd + ") " + numero + "</li>");
            }
            out.println("</ul>");
            //Questao 7
            out.println("</ul>");
            out.println("<h2>07 - Pessoas Nascimento entre abril de 2001 e abril de 2004</h2>");
            out.println("<ul>");
            out.println("<ul>");

            for (Pessoa p : pessoaNascimento) {
                out.println("<li>" + p.getNome() + " ; "
                        + p.getNascimento() + "</li>");
            }
            out.println("</ul>");

            //Questao 9
            out.println("</ul>");
            out.println("<h2>09 - Pessoas que nao tem Telefone</h2>");
            out.println("<ul>");
            out.println("<ul>");

            for (Pessoa p : pessoaNaoTelefone) {
                out.print("<p>" + p.getNome() + "-->" + p.getTelefones() + "</p>");
            }

            out.println("</ul>");

            //Questao 10
            out.println("</ul>");
            out.println("<h2>10 - Quantidade de Telefones por Pessoa</h2>");
            out.println("<ul>");
            out.println("<ul>");

            for (Object[] p : quantidadeTelefone) {
                out.print("<li>" + p[0] + "-->" + p[1] + "</li>");
            }

            out.println("</ul>");

            //Questao 11
            out.println("</ul>");
            out.println("<h2>11 - Grupos não ativos</h2>");
            out.println("<ul>");
            out.println("<h2>a)Por Meio de Query</h2>");
            out.println("<ul>");

            for (Grupo g : grupoinativo) {
                out.println("<li>" + g + "</li>");
            }
            out.println("</ul>");
            out.println("<h2>b)Por meio de TypedQuery</h2>");
            out.println("<ul>");
            for (Grupo g : grupoinativoTQ) {
                out.println("<li>" + g + "</li>");
            }

            out.println("</ul>");

            out.println("<h2>c)Por meio de NamedQuery</h2>");
            out.println("<ul>");
            for (Grupo g : grupoinativoNQ) {
                out.println("<li>" + g + "</li>");
            }

            out.println("</ul>");

            //Questao 12
            out.println("</ul>");
            out.println("<h2>12 - Grupos e Respectivos Lideres</h2>");
            out.println("<ul>");
            for (GrupoLiderDTO grupo : grupoLider) {
                out.print("<li>" + grupo + "</li>");
            }

            
            
            //Questao 13
            out.println("</ul>");
            out.println("<h2>13 - Membros do Estudo IV</h2>");
            out.println("<ul>");
            for (String g : grupoMembros) {
                out.print("<li>" + g + "</li>");
            }

//            out.println("</ul>");
            
            
            //Questao 14
            out.println("</ul>");
            out.println("<h2>14 - Grupos que Beatriz Yana é lider</h2>");
            out.println("<ul>");
            for (Grupo g : Lidergrupo) {
                out.print("<li>" + g + "</li>");
            }
            out.println("</ul>");
            
            
            //Questao 15
            out.println("</ul>");
            out.println("<h2>15 - datas de início e de término da atuação e os grupos (nomes) nos quais “Cecília"
                    + " Xerxes” é membro?</h2>");
            out.println("<ul>");
            for (Object[] grupo : datasGrupoNome) {
                out.print("<li>" + "Inicio: " + grupo[0] + " ; "
                        + "Termino: " + grupo[1]
                        + " ; " + "Nome: " + grupo[2] + "</li>");
            }
            out.println("</ul>");
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 16">
            out.println("<h2>16 - Quais são os grupos (dados completos) que contêm “II” em seus nomes?</h2>");
            List<Grupo> grupoNomeParte = gruposervice.buscarGrupoNomeParte("II");
            out.println("<ul>");
            for (Grupo grupo : grupoNomeParte) {
                out.print("<li>" + grupo + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 17">
            out.println("<h2>17 - Quais são os grupos (nomes) e os respectivos"
                    + " totais de membros distintos já alocados?</h2>");
            List<Object[]> nomesQtdMembros = gruposervice.buscarNomesQtdMembros();
            out.println("<ul>");
            for (Object[] nomeqtd : nomesQtdMembros) {
                out.print("<li>" + nomeqtd[0] + " ; " + nomeqtd[1] + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 18">
            out.println("<h2>18 - Quais grupos (nomes) têm 3 ou mais atuações "
                    + "de membros e quanto são esses totais de atuações?</h2>");
            List<Object[]> nomesQtdAtuacoes = gruposervice.buscarNomesMaiorQtd(3);
            out.println("<ul>");
            for (Object[] nomeqtd : nomesQtdAtuacoes) {
                out.print("<li>" + nomeqtd[0] + " ; " + nomeqtd[1] + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 19">
            out.println("<h2>19 - Quais membros (nomes) entraram a partir de 2012 no primeiro grupo?</h2>");
            List<String> nomeDataGrupo = gruposervice.buscarGrupoDataNome(2012, 1L);
            out.println("<ul>");
            for (String nome : nomeDataGrupo) {
                out.print("<li>" + nome + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 20">
            out.println("<h2>20 - Quais os grupos (nomes), membros (nomes) e as respectivas datas de entrada daqueles que"
                    + " entraram a partir de 2012 em qualquer grupo?</h2>");
            List<MembroDTO> nomeMembroData = gruposervice
                    .buscarNomesMembrosInicioParam(1L, LocalDate.of(2012, Month.JANUARY, 01));
            out.println("<ul>");
            for (MembroDTO nmd : nomeMembroData) {
                out.print("<li>" + nmd + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 21">
            out.println("<h2>21 - Quais os grupos (nomes) e respectivos membros (nomes)"
                    + "que não possuem data de término de "
                    + "atuação em seus grupos?</h2>");
            List<Object[]> nomeMembroSemTermino = gruposervice
                    .buscarNomesMembrosSemTermino();
            out.println("<ul>");
            for (Object[] nmst : nomeMembroSemTermino) {
                out.print("<li>" + nmst[0] + " ; " + nmst[1] + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="QUESTÃO 22">
            out.println("<h2>22 - Quais são os grupos (nomes) e líderes (nomes) com respectivos membros (nomes)?</h2>");
            List<Object[]> nomeLiderMembros = gruposervice
                    .buscarNomeLiderMembros();
            out.println("<ul>");
            for (Object[] nlm : nomeLiderMembros) {
                out.print("<li> Nome do Grupo: " + nlm[0] + " ; "
                        + "Nome do Lider: " + nlm[1] + " ; "
                        + " Membros: " + nlm[2] + "</li>");
            }
            out.println("</ul>");
//</editor-fold>
            
            
            
            
            
            
            

            out.println("</body>");
            out.println("</html>");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
