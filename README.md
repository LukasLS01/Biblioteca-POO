# Sistema de Gerenciamento de Biblioteca

Um sistema de gerenciamento de biblioteca desenvolvido em Java que permite o controle de empréstimos de livros, cadastro de usuários e gerenciamento de multas.

## Funcionalidades

- Cadastro de livros
- Cadastro de alunos e professores
- Realização de empréstimos
- Registro de devoluções
- Cálculo automático de multas por atraso
- Relatórios:
  - Livros cadastrados
  - Usuários cadastrados
  - Livros mais emprestados

## Pré-requisitos

- Java JDK 8 ou superior
- IDE Java (recomendado: IntelliJ IDEA ou Eclipse)

## Como Executar

1. Clone este repositório:
```bash
git clone [URL_DO_SEU_REPOSITORIO]
```

2. Abra o projeto em sua IDE

3. Execute a classe `Main.java`

4. O sistema já inicia com alguns dados de exemplo para facilitar os testes

## Menu de Opções

O sistema apresenta as seguintes opções:

1. Cadastrar Professor
2. Cadastrar Aluno
3. Cadastrar Livro
4. Realizar Empréstimo
5. Registrar Devolução
6. Relatório: Livros Mais Emprestados
7. Listar Livros Cadastrados
8. Listar Usuários Cadastrados
0. Sair

## Regras de Negócio

- O sistema gera IDs automáticos para usuários
- Prazo padrão de empréstimo: 14 dias
- Multa por atraso: R$ 20,00 por dia
- Cada livro possui um preço base de empréstimo
- O valor total a pagar inclui o preço do empréstimo + multa (se houver)

## Estrutura do Projeto

O projeto utiliza os seguintes conceitos de POO:

- Herança
- Polimorfismo
- Encapsulamento
- Interfaces
- Classes abstratas
- Coleções (List, Set)
- Tratamento de exceções

