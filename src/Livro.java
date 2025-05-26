import java.io.Serializable;

public class Livro implements Serializable { // Serializable permite salvar objetos em arquivos
    private String isbn; //Conjunto de caracteres, por isso String
    private String titulo;
    private String autor;
    private int ano;
    private int copias;

public Livro(String isbn, String titulo, String autor, int ano, int copias) {
    this.isbn = isbn;
    this.titulo = titulo;
    this.autor = autor;
    this.ano = ano;
    this.copias = copias;
}

public String getIsbn() { 
    return isbn;
}
public String getTitulo() {
    return titulo;
}
public int getCopias() { 
    return copias; 
}
public void setCopias(int copias) { 
    this.copias = copias;
}
public void setIsbn(String isbn){
    this.isbn = isbn;
}
public void setAutor(String autor){
    this.autor = autor;
}
public void setTitulo(String titulo){
    this.titulo = titulo;
}
public void setAno(int ano){
    this.ano = ano;
}

public void reduzirCopias() {
    if (this.copias > 0) {
        this.copias--; // Reduz uma cópia ao emprestar
    }
}

public void aumentarCopias() {
    this.copias++; // Aumenta uma cópia ao devolver
}
}


