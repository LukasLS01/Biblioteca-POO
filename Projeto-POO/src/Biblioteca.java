import java.util.*;

public class Biblioteca {
    private List<Livro> acervo;
    private Set<Usuario> estudantes;
    private Set<Usuario> professores;
    private  List<Emprestimo> emprestimos;

    public Biblioteca (List<Livro> acervo) {
        this.acervo = new ArrayList<>();
    }

    public void cadastrarLivro(Livro Novolivro) {
        System.out.println("Livro Cadastrado!");
        this.acervo.add(Novolivro);
    }
    public void cadastrarAluno(Usuario Novousuario) {
        this.estudantes.add(Novousuario);
    }
    public void cadastrarProfessor(Usuario Novousuario) {
        this.professores.add(Novousuario);
    }

    // public void realizarEmprestimo (Livro livro) {
    //     if (this.professores.idExistente() || (this.estudantes.idExistente()) {
    //         livro.emprestar();
    //     } else {
    //         System.out.println("Id Inexistente");
    //     }
    // }

}
