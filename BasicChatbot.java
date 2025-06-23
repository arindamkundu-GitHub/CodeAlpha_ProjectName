import java.util.*;
import java.util.regex.Pattern;
import java.util.Scanner;


public class BasicChatbot {
    private static Map<String, String> responses = new HashMap<>();
    private static List<String> greetings = Arrays.asList("hello", "hi", "hey", "good morning", "good afternoon", "good evening");
    private static List<String> farewells = Arrays.asList("bye", "goodbye", "see you", "talk to you later");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userText;

        System.out.println("Hello! I'm your BasicChatbot. How can I help you?");

        responses.put("how are you", "I'm doing well, thanks for asking!");
        responses.put("what is your name", "My name is BasicChatbot.");

        while (true) {
            userText = scanner.nextLine().toLowerCase();

            if (isGreeting(userText)) {
                System.out.println("Hello there!");
            } else if (isFarewell(userText)) {
                System.out.println("Goodbye!");
                break;
            } else {
                String response = findResponse(userText);
                if (response != null) {
                    System.out.println(response);
                } else {
                    System.out.println("I didn't quite understand that.");
                }
            }
        }
    }

    private static boolean isGreeting(String text) {
        for (String greeting : greetings) {
            if (text.contains(greeting)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isFarewell(String text) {
        for (String farewell : farewells) {
            if (text.contains(farewell)) {
                return true;
            }
        }
        return false;
    }

    private static String findResponse(String text) {
        for (Map.Entry<String, String> entry : responses.entrySet()) {
            if (text.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
}