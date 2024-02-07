public final class Testers {
    private Testers() {}
    public static final CFTester firstToSixthAlphabetic = Helper.getPartMaker(
            "Inserisci i primi sei caratteri (devono essere delle lettere)",
            Helper::onlyChars,
            6,
            "Dovevi scrivere solamente caratteri!"
    );

    public static final CFTester seventhAndEighthDigits = Helper.getPartMaker(
            "Inserisci due numeri",
            Helper::onlyNums,
            2,
            "Dovevi scrivere solamente due numeri!"
    );

    public static final CFTester ninthLetter = Helper.getPartMaker(
            "Inserisci una lettera",
            Helper::onlyChars,
            1,
            "Dovevi scrivere solo una lettera!"
    );

    public static final CFTester tenthAndEleventhDigits = seventhAndEighthDigits;

    public static final CFTester twelfthLetter = ninthLetter;

    public static final CFTester thirteenthToFifteenthDigits = Helper.getPartMaker(
            "Inserisci tre numeri",
            Helper::onlyNums,
            3,
            "Dovevi scrivere solo tre numeri!"
    );

    public static final CFTester sixteenthLetter = ninthLetter;
}
