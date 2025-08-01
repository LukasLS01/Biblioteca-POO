public class Livro implements Emprestavel{
    private String titulo;
    private String autor;
    private boolean emprestado;

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    @Override
    public void emprestar() {
        this.emprestado = true;
    }

    @Override
    public void devolver() {
        this.emprestado = false;
    }
}
