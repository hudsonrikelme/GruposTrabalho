package br.edu.ifnmg.web.grupostrabalho;

import java.io.IOException;
import java.io.PrintWriter;
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
