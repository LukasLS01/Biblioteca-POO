
import java.time.LocalDate;

public class Emprestimo extends Multa {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal; // Esta data começa como null


    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataDevolucaoPrevista) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = null;
    }


    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public LocalDate getDataEmprestimo(){
        return dataEmprestimo;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public double calculaPagamento() {

        if (this.dataDevolucaoReal != null) {
            return super.multa(this.dataDevolucaoPrevista, this.dataDevolucaoReal) + this.livro.getPrecoEmprestimo();
        }
        return 0;
    }
}