```mermaid
classDiagram
    class Biblioteca {
        -livros : List<Livro>
        -usuarios : List<Usuario>
        -emprestimos : List<Emprestimo>
        +cadastrarLivro(livro : Livro) : void
        +cadastrarAluno(estudante : Estudante) : void
        +cadastrarProfessor(professor : Professor) : void
        +realizarEmprestimo(titulo : String, idUsuario : int) : void
        +registrarDevolucao(titulo : String) : void
        +listarLivrosCadastrados() : void
        +listarUsuariosCadastrados() : void
    }

    class Usuario {
        <<Abstract>>
        -id : int
        -nome : String
        +getNome() : String
        +getId() : int
    }

    class Professor {
        -departamento : String
        +getDepartamento() : String
    }

    class Estudante {
        -matricula : String
        +getMatricula() : String
    }

    class Livro {
        -titulo : String
        -autor : String
        -emprestado : boolean
        +emprestar() : void
        +devolver() : void
    }

    class Emprestavel {
        <<interface>>
        +emprestar() : void
        +devolver() : void
    }

    class Emprestimo {
        -livro : Livro
        -usuario : Usuario
        -dataEmprestimo : LocalDate
        -dataDevolucaoPrevista : LocalDate
        -dataDevolucaoReal : LocalDate
        +calculaPagamento() : double
    }

    class Multa {
        -multaDiaria : double
        +IsAtrasado(dataDevolucaoPrevista : LocalDate, dataDevolucaoReal : LocalDate) : boolean
    }

    Usuario <|-- Professor
    Usuario <|-- Estudante
    Multa <|-- Emprestimo


    Livro ..|> Emprestavel

    Emprestimo "1" --o "1" Livro
    Emprestimo "1" --o "1" Usuario
    Biblioteca o-- Livro
    Biblioteca o-- Usuario
    Biblioteca o-- Emprestimo
