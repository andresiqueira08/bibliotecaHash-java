public class Main {
    public static void main(String[] args) {
        // Inicializa o sistema
        TabelaHash tabelaHash = new TabelaHash();
        // Carrega os usuários do arquivo
    tabelaHash.setLivros(GerenciadorArquivoLivro.carregarLivros());
    tabelaHash.setUsuarios(GerenciadorArquivoUsuario.carregarUsuarios());

    System.out.println("Livros carregados: " + tabelaHash.getLivros());
    System.out.println("Usuários carregados: " + tabelaHash.getUsuarios());

        // Chama o menu interativo
        Biblioteca.main(args);
        
        // Antes de fechar, salva os usuários atualizados
        GerenciadorArquivoUsuario.salvarUsuarios(tabelaHash.getUsuarios());
        GerenciadorArquivoLivro.salvarLivros(tabelaHash.getLivros());
    }
}