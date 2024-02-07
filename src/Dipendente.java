import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class Dipendente {
    private static final ArrayList<Dipendente> dipendenti = new ArrayList<>();

    @Setter
    private double salario;

    private String codiceFiscale;

    public static String showDipendenti() {
        var sb = new StringBuilder("Dipendenti:");
        dipendenti.forEach(sb::append);
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("- %s, $%.2f\n", getCodiceFiscale(), getSalario());
    }

    public static void addDipendente(Dipendente dipendente) throws LunghezzaCFException {
        if (dipendenti.size() == 100) {
            throw new LunghezzaCFException();
        }

        dipendenti.add(dipendente);
    }
}
