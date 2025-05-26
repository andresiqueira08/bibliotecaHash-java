import java.util.HashMap;

public class Emprestimo {
    private HashMap<Integer, Usuario> tabelaUsuarios;
    private HashMap<String, Livro> tabelaLivros;
    private HashMap<String, Integer> emprestimos = new HashMap<>(); // Mapeia ISBN e ID do usuário

    // Construtor recebe as tabelas já existentes
    public Emprestimo(HashMap<Integer, Usuario> tabelaUsuarios, HashMap<String, Livro> tabelaLivros) {
        this.tabelaUsuarios = tabelaUsuarios;
        this.tabelaLivros = tabelaLivros;
    }

    

public boolean emprestarLivro(String isbn, int idUsuario){
    Livro livro = tabelaLivros.get(isbn);
    if (livro == null) {
        System.out.println("Livro não encontrado.");
        return false;
    }
    
    if (!emprestimos.containsKey(isbn) && livro.getCopias() > 0) {
        emprestimos.put(isbn, idUsuario);
        livro.reduzirCopias(); // Agora estamos chamando o método no objeto correto
        System.out.println("Livro emprestado com sucesso!");
        return true;
    } else {
        System.out.println("Livro indisponível ou já emprestado!");
        return false;
    }
}
public boolean devolverLivro(String isbn) {
    // Verifica se o livro está emprestado
    if (emprestimos.containsKey(isbn)) {
        Livro livro = tabelaLivros.get(isbn); // Obtém o objeto Livro
        if (livro != null) {
            emprestimos.remove(isbn); // Remove empréstimo
            livro.aumentarCopias(); // Restaura a cópia disponível
            System.out.println("Livro devolvido com sucesso!");
            return true;
        }
    } 

    System.out.println("Este livro não está emprestado.");
    return false;
}

    public void listarEmprestimos() {
        System.out.println("\n===== Livros Emprestados =====");
        for (String isbn : emprestimos.keySet()) {
            int idUsuario = emprestimos.get(isbn);
            System.out.println("Livro ISBN " + isbn + " está com o usuário ID " + idUsuario);
        }
    }
}
