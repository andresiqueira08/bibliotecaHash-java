import java.util.Scanner;

public class Biblioteca{
    public static void iniciarSistema(TabelaHash tabelaHash, Scanner scanner, Emprestimo emprestimo) { 
        int opcao;
        do {
            System.out.println("\n===== Biblioteca Interativa =====");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Usuário");
            System.out.println("3 - Buscar Livro");
            System.out.println("4 - Buscar Usuário");
            System.out.println("5 - Atualizar Livro");
            System.out.println("6 - Atualizar Usuário");
            System.out.println("7 - Empréstimo de Livro");
            System.out.println("8 - Devolução de Livro");
            System.out.println("9 - Listar Empréstimos");
            System.out.println("10 - Remover Livro");
            System.out.println("11 - Remover usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch(opcao) {
                case 1:
                    cadastrarLivro(scanner, tabelaHash);
                    break;
                case 2:
                    cadastrarUsuario(scanner, tabelaHash);
                    break;
                case 3:
                    buscarLivro(scanner, tabelaHash);
                    break;
                case 4:
                    buscarUsuario(scanner, tabelaHash);
                    break;
                case 5:
                    atualizarLivro(scanner, tabelaHash);
                    break;
                case 6:
                    atualizarUsuario(scanner, tabelaHash);
                    break;
                case 7:
                    emprestarLivro(scanner, emprestimo);
                    break;
                case 8:
                    devolverLivro(scanner, emprestimo);
                    break;
                case 9:
                    emprestimo.listarEmprestimos();
                    break;
                case 10:
                    removerLivro(scanner, tabelaHash);
                    break;
                case 11:
                    removerUsuario(scanner, tabelaHash);
                    break;
                case 0:
                    System.out.println("Saindo... Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

    }
    

    // Função para cadastrar um novo livro
private static void cadastrarLivro(Scanner scanner, TabelaHash tabelaHash) {
    System.out.print("Digite o ISBN: ");
    String isbn = scanner.nextLine();
    System.out.print("Digite o título: ");
    String titulo = scanner.nextLine();
    System.out.print("Digite o autor: ");
    String autor = scanner.nextLine();
    System.out.print("Digite o ano: ");
    int ano = scanner.nextInt();
    System.out.print("Número de cópias: ");
    int copias = scanner.nextInt();
    scanner.nextLine();

    Livro novoLivro = new Livro(isbn, titulo, autor, ano, copias);
    tabelaHash.adicionarLivro(novoLivro); // Adiciona o livro à memória

    GerenciadorArquivoLivro.salvarLivros(tabelaHash.getLivros());
    System.out.println("Livro cadastrado e salvo com sucesso!");

}

// Função para cadastrar um novo usuário
    private static void cadastrarUsuario(Scanner scanner, TabelaHash tabelaHash) {
        System.out.print("Digite o ID do usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();

        Usuario novoUsuario = new Usuario(id, nome, email, telefone);
        tabelaHash.adicionarUsuario(novoUsuario); // Adiciona o livro à memória

        GerenciadorArquivoUsuario.salvarUsuarios(tabelaHash.getUsuarios());
        System.out.println("Usuario cadastrado e salvo com sucesso!");

    }

    // Função para buscar um livro pelo ISBN
    private static void buscarLivro(Scanner scanner, TabelaHash tabelaHash) {
        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine();
        Livro livro = tabelaHash.buscarLivro(isbn);
        if (livro != null) {
            System.out.println("Livro encontrado: " + livro.getTitulo());
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    // Função para buscar um usuário pelo ID
    private static void buscarUsuario(Scanner scanner, TabelaHash tabelaHash) {
        System.out.print("Digite o ID do usuário: ");
        int id = scanner.nextInt();
        Usuario usuario = tabelaHash.buscarUsuario(id);
        if (usuario != null) {
            System.out.println("Usuário encontrado: " + usuario.getNome());
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    // Função para atualizar um livro
    private static void atualizarLivro(Scanner scanner, TabelaHash tabelaHash) {
        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine();
        System.out.print("Novo título: ");
        String novoTitulo = scanner.nextLine();
        System.out.print("Novo autor: ");
        String novoAutor = scanner.nextLine();
        System.out.print("Novo ano: ");
        int novoAno = scanner.nextInt();
        System.out.print("Novo número de cópias: ");
        int novoCopias = scanner.nextInt();

        tabelaHash.atualizarLivro(isbn, novoTitulo, novoAutor, novoAno, novoCopias);
        System.out.println("Livro atualizado com sucesso!");
    }

    // Função para atualizar um usuário
    private static void atualizarUsuario(Scanner scanner, TabelaHash tabelaHash) {
        System.out.print("Digite o ID do usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo e-mail: ");
        String novoEmail = scanner.nextLine();
        System.out.print("Novo telefone: ");
        String novoTelefone = scanner.nextLine();

        tabelaHash.atualizarUsuario(id, novoNome, novoEmail, novoTelefone);
        System.out.println("Usuário atualizado com sucesso!");
    }

    // Função para emprestar um livro
    private static void emprestarLivro(Scanner scanner, Emprestimo emprestimo) {
        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine();
        System.out.print("Digite o ID do usuário: ");
        int idUsuario = scanner.nextInt();
        emprestimo.emprestarLivro(isbn, idUsuario);
    }

    // Função para devolver um livro
    private static void devolverLivro(Scanner scanner, Emprestimo emprestimo) {
        System.out.print("Digite o ISBN do livro a devolver: ");
        String isbn = scanner.nextLine();
        emprestimo.devolverLivro(isbn);
    }
    private static void removerLivro(Scanner scanner, TabelaHash tabelaHash) {
    System.out.print("Digite o ISBN do livro a ser removido: ");
    String isbn = scanner.nextLine();
    tabelaHash.removerLivro(isbn);
}

    private static void removerUsuario(Scanner scanner, TabelaHash tabelaHash) {
        System.out.print("Digite o ID do usuário a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        tabelaHash.removerUsuario(id);
}
}