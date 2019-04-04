

public class Crypto {
    public static void main(String[] args){
    String test = "A :;´`'\"\\/-!?() l-ek/s,o n.";
        System.out.println(test);
        System.out.println(normalizeText(test));
        System.out.println(normalizeText("This is some \"really\" great. (Text)!?"));
        System.out.println(caesarify("DOG", 5));
    }


    public static String normalizeText(String str){
        str = str.replace( " " , "");
        str = str.replace( "." , "");
        str = str.replace( "," , "");
        str = str.replace( ":" , "");
        str = str.replace( ";" , "");
        str = str.replace( "´" , "");
        str = str.replace( "`" , "");
        str = str.replace( "'" , "");
        str = str.replace( "\"" , "");
        str = str.replace( "/" , "");
        str = str.replace( "\\" , "");
        str = str.replace( "-" , "");
        str = str.replace( "!" , "");
        str = str.replace( "?" , "");
        str = str.replace( "(" , "");
        str = str.replace( ")" , "");
        str = str.toUpperCase();
        return str;
    }


    private static String caesarify(String text, int change) {
        String newString = text;
        String result = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet2 = shiftAlphabet(change);
        for (int i = 0; i < newString.length(); i++) {
            for (int y = 0; y < alphabet.length(); y++) {
                if (Character.toString(newString.charAt(i)).equals(Character.toString(alphabet.charAt(y)))) {
                    result = result + alphabet2.charAt(y);
                }
            }
        }
        return text;
    }


        public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

}
