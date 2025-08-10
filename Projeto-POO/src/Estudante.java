public class Estudante extends Usuario{
    private String matricula;


    public Estudante(String nome, String matricula){
        super(nome);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return this.matricula;
    }
}