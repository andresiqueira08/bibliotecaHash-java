import java.io.*;
import java.util.HashMap;
public class GerenciadorArquivoLivro {
    public static void salvarLivros(HashMap<String, Livro> livros) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\LORENA\\andre_JAVA\\bibliotecaHASH\\dados\\livros.dat"))) {
            out.writeObject(livros);
        } catch (IOException e) {
            System.out.println("Erro ao salvar livros: " + e.getMessage());
        }
    }

public static HashMap<String, Livro> carregarLivros() {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\LORENA\\andre_JAVA\\bibliotecaHASH\\dados\\livros.dat"))) {
        Object obj = in.readObject(); // Lê o objeto do arquivo

        // Usa Pattern Matching com instanceof
        if (obj instanceof HashMap<?, ?> tempMap) {
            HashMap<String, Livro> livros = new HashMap<>();
            for (var entry : tempMap.entrySet()) {
                if (entry.getKey() instanceof String key && entry.getValue() instanceof Livro livro) {
                    livros.put(key, livro);
                }
            }
            return livros;
        }
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Erro ao carregar livros: " + e.getMessage());
    }
    return new HashMap<>(); // Retorna um HashMap vazio em caso de erro
}
}