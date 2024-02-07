public class Main {
    public static void main(String[] args) {
        var shouldContinue = true;
        while (shouldContinue) {
            var oneToSix = Helper.repeatUntilFine(Testers.firstToSixthAlphabetic);
            var sevenEight = Helper.repeatUntilFine(Testers.seventhAndEighthDigits);
            var ninth = Helper.repeatUntilFine(Testers.ninthLetter);
            var tenthEleventh = Helper.repeatUntilFine(Testers.tenthAndEleventhDigits);
            var twelfth = Helper.repeatUntilFine(Testers.twelfthLetter);
            var thirteenthToFifteenth = Helper.repeatUntilFine(Testers.thirteenthToFifteenthDigits);
            var sixteenth = Helper.repeatUntilFine(Testers.sixteenthLetter);

            var result = oneToSix
                    .concat(sevenEight)
                    .concat(ninth)
                    .concat(tenthEleventh)
                    .concat(twelfth)
                    .concat(thirteenthToFifteenth)
                    .concat(sixteenth);

            var salary = Helper.getDouble("Quanto ha di salario?", "Non un numero!");

            try {
                Dipendente.addDipendente(new Dipendente(salary, result));
            } catch (LunghezzaCFException e) {
                System.out.println(e.getMessage());
            }

            shouldContinue = Helper.getBool("Vuoi continuare?");
        }

        System.out.println(Dipendente.showDipendenti());
    }
}