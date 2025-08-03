public class Professor extends Usuario{
    private String departamento;

    public Professor(int id, String nome, String departamento){
        super(id, nome);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return this.departamento;
    }
}
