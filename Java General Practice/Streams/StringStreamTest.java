/**
 * @author Tyler Crill
 * @version 1/14/18
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class StringStreamTest
{
    public static void main(String[] args){
        String str = "It was all so sad, but it was all so beautiful too.";
        String quote = "Oh Lord Most High, Creator of the Cosmos, Spinner of Galaxies," +
                " Soul of Electromagnetic Waves, Inhaler and Exhaler of Inconceivable Volumes of Vacuum, " +
                "Spitter of Fire and Rock, Trifler with Millennia — what could we do for Thee that Thou couldst not do for Thyself one octillion times better? " +
                "Nothing. What could we do or say that could possibly interest Thee? Nothing. Oh, Mankind, rejoice in the apathy of our Creator, for it makes us free and truthful and dignified at last. " +
                "No longer can a fool point to a ridiculous accident of good luck and say, 'Somebody up there likes me.' And no longer can a tyrant say, 'God wants this or that to happen, and anyone who doesn't help this or that to happen is against God." +
                "' O Lord Most High, what a glorious weapon is Thy Apathy, for we have unsheathed it, have thrust and slashed mightily with it, and the claptrap that has so often enslaved us or driven us into the madhouse lies slain!\" -The prayer of the Reverend C. Horner Redwine";
        String result = str.replaceAll("[^\\w\\s]",""); // Any character except word characters and whitespace
        String quoteResult = quote.replaceAll("[^\\w\\s]","");
        List<String> quoteList = Arrays.asList(quoteResult.split(" "));
        List<String> words = Arrays.asList(result.split(" "));

        List<String> quoteFilter = quoteList.stream()   //Converts list to stream
                .filter(wrd -> !"of".equals(wrd))       //Filters 'of' from stream - allows non 'of' words to pass
                .collect(toList());          //Collects remaining output and converts stream to list

        for(String wrd : quoteFilter){  // could use quoteFilter.forEach(System.out::println) but this hides inner workings
            System.out.println(wrd);
        }

        List<TestObject> testObj = Stream.generate(TestObject::new).limit(5).collect(toList());


        testObj.stream().forEach(System.out::println);

        

    }
}
