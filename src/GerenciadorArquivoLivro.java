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
    try (ObjectInputStream in = new ObjectInputStream(
            new FileInputStream("C:\\Users\\LORENA\\andre_JAVA\\bibliotecaHASH\\dados\\livros.dat"))) {

        Object obj = in.readObject();

        if (obj instanceof HashMap<?, ?>) {
            HashMap<?, ?> tempMap = (HashMap<?, ?>) obj;
            HashMap<String, Livro> livros = new HashMap<>();

            for (var entry : tempMap.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();

                if (key instanceof String && value instanceof Livro) {
                    livros.put((String) key, (Livro) value);
                }
            }
            return livros;
        }

    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Erro ao carregar livros: " + e.getMessage());
    }
    return new HashMap<>();
}

}