public class Estudante extends Usuario{
    private String matricula;

    public Estudante(int id, String nome, String matricula){
        super(id, nome);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return this.matricula;
    }
}
