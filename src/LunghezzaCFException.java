public class LunghezzaCFException extends Exception {
    public LunghezzaCFException() {
        this("Il CF non può avere più di 100 dipendenti!");
    }

    public LunghezzaCFException(String message) {
        super(message);
    }
}
