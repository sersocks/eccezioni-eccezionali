import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public final class Helper {
    public static Scanner scan = new Scanner(System.in);
    private Helper() {}
    private static void badFormat(String msg) throws FormatoCFException {
        throw new FormatoCFException(msg);
    }

    public static String getInput(String prompt) {
        System.out.println(prompt);
        System.out.print("> ");
        return scan.nextLine().trim();
    }

    public static double getDouble(String prompt, String onFail) {
        System.out.println(prompt);
        System.out.print("> ");
        try {
            var numStr = scan.nextLine();
            return Double.parseDouble(numStr);
        } catch (NumberFormatException e) {
            return getDouble(onFail, onFail);
        }
    }

    public static boolean getBool(String prompt) {
        System.out.println(prompt);
        System.out.print("[y/N] ");
        var input = scan.nextLine();
        if (input.isBlank()) {
            return false;
        }

        var choice = input.charAt(0);
        return choice == 'y' || choice == 'Y';
    }

    public static CFTester getPartMaker(String prompt, Predicate<String> pred, int length, String onFail) {
        return () -> {
            var input = getInput(prompt);

            if (input.length() != length) {
                badFormat("La lunghezza %d non corrisponde con quella desiderata, %d".formatted(input.length(), length));
            }

            if (!pred.test(input)) {
                badFormat(onFail + "\nHai scritto: " + input);
            }

            return input;
        };
    }

    public static boolean onlyChars(String str) {
        var len = str.length();
        return str.matches("[A-Za-z]{%d}".formatted(len));
    }

    public static boolean onlyNums(String str) {
        var len = str.length();
        return str.matches("[0-9]{%d}".formatted(len));
    }

    public static String repeatUntilFine(CFTester tester) {
        try {
            return tester.get();
        } catch (LunghezzaCFException | FormatoCFException e) {
            System.out.println(e.getMessage());
            return repeatUntilFine(tester);
        }
    }
}
