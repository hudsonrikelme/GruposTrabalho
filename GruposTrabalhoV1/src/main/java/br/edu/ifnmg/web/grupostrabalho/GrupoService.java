
package br.edu.ifnmg.web.grupostrabalho;

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
    
    //Buscar Grupos e Lideres
    @Override
    public List<GrupoLiderDTO> buscarLideres() {
        return em.createNamedQuery("Grupo.findGroupLeader", GrupoLiderDTO.class)
                .getResultList();
    }

    
    
    
    
    
    
}
