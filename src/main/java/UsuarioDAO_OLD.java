

import br.edu.fateclins.javacafe.dao.JPAUtil;
import br.edu.fateclins.javacafe.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author apazi
 */
public class UsuarioDAO_OLD {

    private List<Usuario> tabelaUsuario;

    public UsuarioDAO_OLD() {
        tabelaUsuario = new ArrayList<>();
        povoarTabelaUsuario();
    }

    private void povoarTabelaUsuario() {
        EntityManager em = JPAUtil.getEntityManager();
        Query q = em.createQuery("select u from Usuario u", Usuario.class);
        tabelaUsuario = q.getResultList();
      
    }

    public Usuario buscarUsuario(String email) {
        for (Usuario usuario : tabelaUsuario) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }
}
