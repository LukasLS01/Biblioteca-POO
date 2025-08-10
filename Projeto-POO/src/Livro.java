public class Livro implements Emprestavel{
    private String titulo;
    private String autor;
    private boolean emprestado;
    private double precoEmprestimo;

    public Livro (String titulo,String autor, boolean emprestado, double precoEmprestimo) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = emprestado;
        this.precoEmprestimo = precoEmprestimo;
    }

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

    public double getPrecoEmprestimo() {
        return precoEmprestimo;
    }

    public void setPrecoEmprestimo(double precoEmprestimo) {
        this.precoEmprestimo = precoEmprestimo;
    }

    @Override
    public void devolver() {
        this.emprestado = false;
    }
    
}
