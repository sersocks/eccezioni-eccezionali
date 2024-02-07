    @FunctionalInterface
    public interface CFTester {
        String get() throws FormatoCFException, LunghezzaCFException;
    }