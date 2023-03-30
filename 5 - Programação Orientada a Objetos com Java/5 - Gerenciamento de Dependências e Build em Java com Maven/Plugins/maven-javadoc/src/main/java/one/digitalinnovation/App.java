package one.digitalinnovation;

/**
 * Classe App - contém o método main
 */
public class App 
{
    public static void main( String[] args )
    {
        User user = new User("ana", "1234");

        user.habilitarUsuario();

        System.out.println("Usuário: " + user.getUsuario());
        System.out.println("Senha: " + user.getSenha());
        System.out.println("Status: " + user.getStatus());
    }
}
