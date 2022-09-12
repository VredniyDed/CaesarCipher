import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //введення вхідного тексту
        System.out.println("Введіть вхідний текст:");
        Scanner scan = new Scanner(System.in);
        String cryptoText = scan.nextLine();
        //введення ключа та перевірка його на відповідність умовам
        System.out.println("Введіть ключ:");
        int key = scan.nextInt();
        while (key > 33 || key < 0) {
            System.out.println("Ключ має бути у межах 0 - 32:");
            key = scan.nextInt();
        }
        CaesarCipher text1 = new CaesarCipher();
        //виклик методу шифрування
        char []chipherText = text1.cpiher(cryptoText.trim(),key);
        //виклик методу перебору
        text1.decrypt(chipherText);
    }
}