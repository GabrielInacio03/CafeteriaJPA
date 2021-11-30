package br.edu.fateclins.javacafe.daoTemp;

import br.edu.fateclins.javacafe.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apazi
 */
public class UsuarioDAO {
    
    private List<Usuario> tabelaUsuario;
    
    public UsuarioDAO(){
        tabelaUsuario=new ArrayList<>();
        povoarTabelaUsuario();
    }

    private void povoarTabelaUsuario() {
        Usuario u1 = new Usuario("Anderson", "123456", "anderson@email.com");
        Usuario u2 = new Usuario("Marcela", "654321", "marcela@email.com");
        Usuario u3 = new Usuario("João", "135246", "joao@email.com");
        tabelaUsuario.add(u1);
        tabelaUsuario.add(u2);
        tabelaUsuario.add(u3);
    }
    
    public Usuario buscarUsuario(String email){
        for(Usuario usuario : tabelaUsuario){
            if(usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }
}
