public class Multa extends Emprestimo {
    private double multaDiaria;

    public boolean IsAtrasado () {
        return dataDevolucaoPrevista < dataDevolucaoReal;
    }

    private double multa () {
        if (IsAtrasado()) {
            return multaDiaria*(dataDevolucaoReal-dataDevolucaoPrevista);
        }
        return 0;
    }
}
