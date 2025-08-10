import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Multa{
    private double multaDiaria = 20.00;

    public boolean IsAtrasado (LocalDate dataDevolucaoPrevista, LocalDate dataDevolucaoReal) {
        return dataDevolucaoReal.isAfter(dataDevolucaoPrevista);
    }

    public double getMultaDiaria() {
        return multaDiaria;
    }

    public void setMultaDiaria(double multaDiaria) {
        this.multaDiaria = multaDiaria;
    }

    protected double multa (LocalDate dataDevolucaoPrevista, LocalDate dataDevolucaoReal) {
        if (IsAtrasado(dataDevolucaoPrevista, dataDevolucaoReal)) {
            long diasAtraso = ChronoUnit.DAYS.between(dataDevolucaoPrevista, dataDevolucaoReal);
            return multaDiaria*diasAtraso;
        }
        return 0;
    }
}
