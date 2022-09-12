import static java.lang.Character.toUpperCase;

public class CaesarCipher {
    //алфавіт
    char []alph = new char[] {
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є','Ж', 'З', 'И', 'І', 'Ї', 'Й',
            'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ь', 'Ю', 'Я'
    };
    //метод шифрування Цезаря
    char[] cpiher(String cryptoText, int key){
        char []text = new char[cryptoText.length()];
        for (int i = 0; i < cryptoText.length(); i++){
            for (int j = 0; j < alph.length; j++){
                if (toUpperCase(cryptoText.charAt(i)) == alph[j]){
                    text[i] = (char) (alph[ (j+key) % alph.length]);
                }
            }
        }
        System.out.println("Криптограма:");
        System.out.print(text );
        System.out.println();
        return text;
    }
    //метод повного перебору для розшифрування криптограми
    void decrypt(char[] cryptoText){
        int possibleKey = 0;
        String []variants = new String[alph.length];
        for (int k = 0; k < alph.length; k++){
            variants[k] = "";
            for (int i = 0; i < cryptoText.length; i++){
                for (int j = 0; j < alph.length; j++){
                    if (toUpperCase(cryptoText[i]) == alph[j]){
                        if (j < possibleKey) variants[k] +=  (Character.toString(alph[ (j - possibleKey + alph.length) % alph.length]));
                        else variants[k] +=  (Character.toString(alph[ (j - possibleKey) % alph.length]));
                    }
                }
            }
            possibleKey++;
        }
        System.out.println("----------Варіанти розшифровки----------");
        for (int k = 0; k < alph.length; k++) {
            System.out.println("Ключ = " + k + '\t' +  variants[k] );
        }
    }
}