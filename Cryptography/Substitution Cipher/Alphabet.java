import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class will create and hold both the base alphabet as well as the coded alphabet
 */
public class Alphabet {
    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public List<String> getPlainText() {
        return plainText;
    }

    public void setPlainText(List<String> plainText) {
        this.plainText = plainText;
    }

    public List<String> getCipherText() {
        return cipherText;
    }

    public void setCipherText(List<String> cipherText) {
        this.cipherText = cipherText;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    String alpha = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,y,z";
    List<String> plainText;
    List<String> cipherText;
    String key;

    Alphabet(){

    }

    void createCodedAlphabet(){
        plainText = new ArrayList(Arrays.asList(alpha.split(",")));
        cipherText = new ArrayList(Arrays.asList(key.split("(?!^)")));


        plainText.removeAll(cipherText);
        cipherText.addAll(plainText);

    }

    @Override
    public String toString() {
        return " plainText= " + plainText +
                "\n cipherText= " + cipherText +
                "\n key= " + key + '\'' +
                '}';
    }
}
