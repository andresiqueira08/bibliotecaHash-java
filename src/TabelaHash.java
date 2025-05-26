import java.util.HashMap;// a implementação do HashMap utiliza uma tabela de dispersão com listas encadeadas para tratar colisões.
//Utiliza sua própria função "hash" ou função de espalhamento

public class TabelaHash {
    private HashMap<String, Livro> tabelaLivros = new HashMap<>();
    private HashMap<Integer, Usuario> tabelaUsuarios = new HashMap<>();

    public void adicionarLivro(Livro livro) {
        tabelaLivros.put(livro.getIsbn(), livro);
        
    }

    public void adicionarUsuario(Usuario usuario) {
        tabelaUsuarios.put(usuario.getId(), usuario);
    }

    public Livro buscarLivro(String isbn) {
        return tabelaLivros.get(isbn);
    }
    public Usuario buscarUsuario(int id) {
        return tabelaUsuarios.get(id);
    }
public void atualizarUsuario(int id, String novoNome, String novoEmail, String novoTelefone) {
    Usuario usuario = tabelaUsuarios.get(id); // Busca usuário pelo ID
    if (usuario != null) {
        usuario.setNome(novoNome);
        usuario.setEmail(novoEmail);
        usuario.setTelefone(novoTelefone);
    } else {
        System.out.println("Usuário não encontrado.");
    }
}
public void atualizarLivro(String isbn, String novoTitulo, String novoAutor, int novoAno, int novoCopias){
    Livro livro = tabelaLivros.get(isbn);
    if (livro != null){
        livro.setTitulo(novoTitulo);
        livro.setAno(novoAno);
        livro.setAutor(novoAutor);
        livro.setCopias(novoCopias);
    }
    else{
        System.out.println("Livro não encontrado.");
    }
}
//As funções abaixo servem para permitir o acesso aos dados armazenados dentro da classe TabelaHash, sem expor diretamente suas variáveis internas.

public HashMap<Integer, Usuario> getUsuarios() {
    return tabelaUsuarios;
}

public HashMap<String, Livro> getLivros() {
    return tabelaLivros;
}
public void setLivros(HashMap<String, Livro> livros) {
    this.tabelaLivros = livros;
}
public void setUsuarios(HashMap<Integer, Usuario> usuarios) {
    this.tabelaUsuarios = usuarios;
}

}