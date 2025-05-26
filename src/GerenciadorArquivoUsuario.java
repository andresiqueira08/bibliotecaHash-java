import java.io.*;
import java.util.HashMap;

public class GerenciadorArquivoUsuario {
    
    private static final String CAMINHO_ARQUIVO = "C:\\Users\\LORENA\\andre_JAVA\\bibliotecaHash\\dados\\usuarios.dat"; // Define o caminho do arquivo

    // Método para salvar usuários no arquivo
    public static void salvarUsuarios(HashMap<Integer, Usuario> usuarios) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CAMINHO_ARQUIVO))) {
            out.writeObject(usuarios);
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

// Método para carregar usuários do arquivo
public static HashMap<Integer, Usuario> carregarUsuarios() {
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(CAMINHO_ARQUIVO))) {
        Object obj = in.readObject();

        // Usa Pattern Matching para instanceof
        if (obj instanceof HashMap<?, ?> tempMap) {
            HashMap<Integer, Usuario> usuarios = new HashMap<>();
            for (var entry : tempMap.entrySet()) {
                if (entry.getKey() instanceof Integer key && entry.getValue() instanceof Usuario usuario) {
                    usuarios.put(key, usuario);
                }
            }
            return usuarios;
        }
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Erro ao carregar usuários: " + e.getMessage());
    }
    return new HashMap<>();
}
}
