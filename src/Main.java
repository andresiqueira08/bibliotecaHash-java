import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();
        tabelaHash.setLivros(GerenciadorArquivoLivro.carregarLivros());
        tabelaHash.setUsuarios(GerenciadorArquivoUsuario.carregarUsuarios());

        Emprestimo emprestimo = new Emprestimo(tabelaHash.getUsuarios(), tabelaHash.getLivros());

        try (Scanner scanner = new Scanner(System.in)) {
            Biblioteca.iniciarSistema(tabelaHash, scanner, emprestimo); 
        }
        
        // Antes de fechar, salva os usuários atualizados
        GerenciadorArquivoUsuario.salvarUsuarios(tabelaHash.getUsuarios());
        GerenciadorArquivoLivro.salvarLivros(tabelaHash.getLivros());
    }
}