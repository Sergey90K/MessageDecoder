import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageDecoder {
    public static String decode(String messageFile) {
        List<String> lines = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(messageFile))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> messageWords = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            messageWords.add("");
        }
        for (String line : lines) {
            int number = Integer.parseInt(line.split(" ")[0]);
            for (int i = 0; i < 100; i++) {
                if (number == ((i * i + i) / 2)) {
                    messageWords.set(i, line.split(" ")[1]);
                    break;
                }
            }
        }
        StringBuilder text = new StringBuilder();
        for (String word : messageWords) {
            if (!word.equals("")) {
                text.append(word).append(" ");
            }
        }
        return text.toString();
    }

    public static void main(String[] args) {
        String filePath = "coding_qual_input.txt";
        String decodedMessage = decode(filePath);
        System.out.println(decodedMessage);
    }
}