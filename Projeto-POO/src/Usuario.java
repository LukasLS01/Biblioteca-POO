abstract class Usuario {
    private static int contadorId = 1; // 1. Contador estático para gerar IDs
    private final int id;
    private final String nome;

    // 2. O construtor agora só precisa do nome
    public Usuario(String nome){
        this.nome = nome;
        this.id = contadorId++; // 3. Atribui o ID atual e incrementa para o próximo
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return this.id;
    }
}