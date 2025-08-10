import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {
    private final List<Livro> acervo;
    private final Set<Usuario> usuarios;
    private final List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
        this.usuarios = new HashSet<>();
        this.emprestimos = new ArrayList<>();
    }


    public void cadastrarLivro(Livro novoLivro) {
        this.acervo.add(novoLivro);
        System.out.println("Livro '" + novoLivro.getTitulo() + "' cadastrado com sucesso!");
    }

    public void cadastrarAluno(Estudante novoAluno) {
        this.usuarios.add(novoAluno);
        // Mensagem de sucesso agora mostra o ID gerado
        System.out.println("Aluno '" + novoAluno.getNome() + "' cadastrado com sucesso! (ID: " + novoAluno.getId() + ")");
    }

    public void cadastrarProfessor(Professor novoProfessor) {
        this.usuarios.add(novoProfessor);
        // Mensagem de sucesso agora mostra o ID gerado
        System.out.println("Professor '" + novoProfessor.getNome() + "' cadastrado com sucesso! (ID: " + novoProfessor.getId() + ")");
    }

    private Livro buscarLivroPorTitulo(String titulo) throws LivroException {
        return acervo.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElseThrow(() -> new LivroException("Erro: Livro com o título '" + titulo + "' não encontrado."));
    }

    private Usuario buscarUsuarioPorId(int id) throws UsuarioException {
        return usuarios.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UsuarioException("Erro: Usuário com o ID " + id + " não encontrado."));
    }


    public void realizarEmprestimo(String tituloLivro, int idUsuario) throws LivroException, UsuarioException {
        Livro livro = buscarLivroPorTitulo(tituloLivro);
        Usuario usuario = buscarUsuarioPorId(idUsuario);

        if (livro.isEmprestado()) {
            throw new LivroException("Erro: O livro '" + livro.getTitulo() + "' já está emprestado.");
        }

        livro.emprestar();
        Emprestimo novoEmprestimo = new Emprestimo(livro, usuario, LocalDate.now().plusDays(14));
        this.emprestimos.add(novoEmprestimo);

        System.out.println("Empréstimo realizado com sucesso!");
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Data para devolução: " + novoEmprestimo.getDataDevolucaoPrevista());
    }

    public void registrarDevolucao(String tituloLivro) throws LivroException {
        Emprestimo emprestimoAtivo = emprestimos.stream()
                .filter(e -> e.getLivro().getTitulo().equalsIgnoreCase(tituloLivro) && e.getDataDevolucaoReal() == null)
                .findFirst()
                .orElseThrow(() -> new LivroException("Erro: Não há um empréstimo ativo para o livro '" + tituloLivro + "'."));

        emprestimoAtivo.getLivro().devolver();
        emprestimoAtivo.setDataDevolucaoReal(LocalDate.now());

        double valorAPagar = emprestimoAtivo.calculaPagamento();

        System.out.println("Devolução do livro '" + tituloLivro + "' registrada com sucesso.");
        if (valorAPagar > emprestimoAtivo.getLivro().getPrecoEmprestimo()) {
            System.out.printf("Atenção: Houve atraso na devolução. Valor da multa: R$ %.2f%n", (valorAPagar - emprestimoAtivo.getLivro().getPrecoEmprestimo()));
        }
        System.out.printf("Valor total a pagar: R$ %.2f%n", valorAPagar);
    }

    // Relatórios
    public void listarLivrosCadastrados() {
        if (acervo.isEmpty()) {
            System.out.println("Nenhum livro cadastrado no sistema.");
            return;
        }

        System.out.println("\n-=-=-==-=Lista de Livros Cadastrados-=-=-==-=");
        for (Livro livro : acervo) {
            String status = livro.isEmprestado() ? "Emprestado" : "Disponível";
            System.out.println(" -> Título: " + livro.getTitulo() + " | Autor: " + livro.getAutor() + " | Status: " + status);
        }
    }

    public void listarLivrosMaisEmprestados() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo foi realizado ainda.");
            return;
        }

        Map<String, Long> contagem = emprestimos.stream()
                .collect(Collectors.groupingBy(e -> e.getLivro().getTitulo(), Collectors.counting()));

        System.out.println("\n-=-=-==-=Relatório: Livros Mais Emprestados-=-=-==-=");
        contagem.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println("-> " + entry.getKey() + ": " + entry.getValue() + " empréstimo(s)"));
    }


    public void listarUsuariosCadastrados() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado no sistema.");
            return;
        }

        System.out.println("\n-=-=-==-=Lista de Usuários Cadastrados-=-=-==-=");
        for (Usuario usuario : usuarios) {
            String tipo = "";
            if (usuario instanceof Estudante) {
                tipo = "Aluno";
            } else if (usuario instanceof Professor) {
                tipo = "Professor";
            }
            System.out.println(" -> ID: " + usuario.getId() + " | Nome: " + usuario.getNome() + " | Tipo: " + tipo);
        }
    }
}