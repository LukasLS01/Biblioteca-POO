```mermaid
classDiagram
    class Biblioteca {
        -List~Livro~ acervo
        -List~Usuario~ usuarios
        -List~Emprestimo~ emprestimos
        +cadastrarLivro(Livro livro)
        +cadastrarUsuario(Usuario usuario)
        +realizarEmprestimo(Livro livro, Usuario usuario)
        +registrarDevolucao(Emprestimo emprestimo)
        +gerarRelatorioMaisEmprestados()
    }
    class Livro {
        -String titulo
        -String autor
        -String isbn
        -boolean emprestado
        +getTitulo()
        +isEmprestado()
        +setEmprestado(boolean status)
        +emprestar()
        +devolver()
    }
    class Usuario {
        <<Abstract>>
        -String nome
        -int id
        +getNome()
    }
    class Estudante {
        +String matricula
    }
    class Professor {
        +String departamento
    }
    class Emprestimo {
        -Livro livro
        -Usuario usuario
        -LocalDate dataEmprestimo
        -LocalDate dataDevolucaoPrevista
        -LocalDate dataDevolucaoReal
        +calcularMulta()
        +calcularPagamento()
    }
    class Emprestavel{
        <<interface>>
        +emprestar()
        +devolver()
    }
    class Pagavel{
        <<interface>>
        +calcularPagamento()
    }

    Biblioteca "1" -- "0..*" Livro : contém
    Biblioteca "1" -- "0..*" Usuario : gerencia
    Biblioteca "1" -- "0..*" Emprestimo : registra
    Emprestimo "1" -- "1" Livro
    Emprestimo "1" -- "1" Usuario
    Usuario <|-- Estudante
    Usuario <|-- Professor
    Livro ..|> Emprestavel
    Emprestimo ..|> Pagavel
