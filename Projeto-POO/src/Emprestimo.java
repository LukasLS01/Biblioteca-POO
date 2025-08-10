import javax.swing.*;
import java.time.LocalDate;

public class Emprestimo extends Multa {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;


    public Emprestimo(Livro livro, Usuario user, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista, LocalDate dataDevolucaoReal){
        this.livro = livro;
        this.usuario = user;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public double calcularPagamento(double valor){
        return valor - super.multa(this.dataDevolucaoPrevista, this.dataDevolucaoReal);
    }
}
