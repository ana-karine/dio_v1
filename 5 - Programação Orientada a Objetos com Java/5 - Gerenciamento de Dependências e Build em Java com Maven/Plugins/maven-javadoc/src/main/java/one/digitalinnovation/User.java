package one.digitalinnovation;

/**
 * Classe User. Atributos: usuario, senha, status
 */
public class User {
    private String usuario;
    private String senha;
    private StatusUser status;

    public User() {

    }

    public User(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public StatusUser getStatus() {
        return status;
    }

    /**
     * Método habilitarUsuario(): habilita o usuário
     */
    public void habilitarUsuario() {
        this.status = StatusUser.HABILITADO;
    }

    /**
     * Método desabilitarUsuario(): desahabilita o usuário
     */
    public void desabilitarUsuario() {
        this.status = StatusUser.DESABILITADO;
    }

    /**
     * Método bloquearUsuario(): bloqueia o usuário
     */
    public void bloquearUsuario() {
        this.status = StatusUser.BLOQUEADO;
    }
}
