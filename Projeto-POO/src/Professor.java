public class Professor extends Usuario{
    private String departamento;


    public Professor(String nome, String departamento){
        super(nome);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return this.departamento;
    }
}