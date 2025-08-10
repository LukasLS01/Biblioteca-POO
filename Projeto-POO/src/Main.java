import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int op = 9;

        // Dados de exemplo para facilitar o teste
        biblioteca.cadastrarLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", false, 5.00));
        biblioteca.cadastrarLivro(new Livro("Java para Iniciantes", "Herbert Schildt", false, 3.50));
        biblioteca.cadastrarAluno(new Estudante("Carlos Silva", "2025101A"));
        biblioteca.cadastrarProfessor(new Professor("Ana Costa", "Computação"));
        System.out.println("----------------------------------------------");
        System.out.println("Sistema iniciado com alguns dados de exemplo.");
        System.out.println("----------------------------------------------");


        while (op != 0) {
            System.out.println("\n-=-=-==-=Sistema de Biblioteca-=-=-==-=");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Aluno");
            System.out.println("3. Cadastrar Livro");
            System.out.println("4. Realizar Empréstimo");
            System.out.println("5. Registrar Devolução");
            System.out.println("6. Relatório: Livros Mais Emprestados");
            System.out.println("7. Listar Livros Cadastrados");
            System.out.println("8. Listar Usuários Cadastrados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                op = sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1:
                        System.out.print("Nome do professor: ");
                        String nomeProf = sc.nextLine();
                        System.out.print("Departamento: ");
                        String depto = sc.nextLine();
                        biblioteca.cadastrarProfessor(new Professor(nomeProf, depto));
                        break;
                    case 2:
                        System.out.print("Nome do aluno: ");
                        String nomeAluno = sc.nextLine();
                        System.out.print("Matrícula: ");
                        String matricula = sc.nextLine();
                        biblioteca.cadastrarAluno(new Estudante(nomeAluno, matricula));
                        break;
                    case 3:
                        System.out.print("Título do livro: ");
                        String titulo = sc.nextLine();
                        System.out.print("Autor do livro: ");
                        String autor = sc.nextLine();
                        System.out.print("Preço do empréstimo: ");
                        double preco = sc.nextDouble();
                        biblioteca.cadastrarLivro(new Livro(titulo, autor, false, preco));
                        break;
                    case 4:
                        System.out.print("Título do livro para emprestar: ");
                        String tituloEmprestimo = sc.nextLine();
                        System.out.print("ID do usuário (aluno/professor): ");
                        int idUsuario = sc.nextInt();
                        biblioteca.realizarEmprestimo(tituloEmprestimo, idUsuario);
                        break;
                    case 5:
                        System.out.print("Título do livro para devolver: ");
                        String tituloDevolucao = sc.nextLine();
                        biblioteca.registrarDevolucao(tituloDevolucao);
                        break;
                    case 6:
                        biblioteca.listarLivrosMaisEmprestados();
                        break;
                    case 7:
                        biblioteca.listarLivrosCadastrados();
                        break;
                    case 8: // Novo case para chamar a listagem
                        biblioteca.listarUsuariosCadastrados();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira o tipo de dado correto.");
                sc.nextLine();
                op = 9;
            } catch (LivroException | UsuarioException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}