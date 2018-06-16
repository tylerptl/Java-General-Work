public class Driver{
    public static void main(String... args){
        Alphabet alpha = new Alphabet();
        SubstitutionCipher sc = new SubstitutionCipher();
        String text = "It was the best of times, it was the worst of times, it was\n" +
                "the age of wisdom, it was the age of foolishness, it was the\n" +
                "epoch of belief, it was the epoch of incredulity, it was the\n" +
                "season of Light, it was the season of Darkness, it was the\n" +
                "spring of hope, it was the winter of despair, we had\n" +
                "everything before us, we had nothing before us, we were\n" +
                "all going direct to Heaven, we were all going direct the\n" +
                "other way—in short, the period was so far like the present\n" +
                "period, that some of its noisiest authorities insisted on its\n" +
                "being received, for good or for evil, in the superlative\n" +
                "degree of comparison only. ";

        alpha.setKey("testasdf");
        alpha.createCodedAlphabet();
        String
        System.out.println(alpha.toString());
    }


}
