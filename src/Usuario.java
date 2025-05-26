import java.io.Serializable;

public class Usuario implements Serializable { // Serializable permite salvar objetos em arquivos
    private int id;
    private String nome;
    private String email;
    private String telefone;

public Usuario(int id, String nome, String email, String telefone) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
}

public int getId() {
    return id; 
}
public String getNome(){
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public void setEmail(String email) {
    this.email = email;
}

public void setTelefone(String telefone) {
    this.telefone = telefone;
}
}