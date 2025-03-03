import java.util.*;

class CardCollection {
    private static Map<String, List<String>> cards = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Card\n2. Search Cards by Symbol\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    searchCards();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addCard() {
        System.out.print("Enter Card Symbol (e.g., Hearts, Spades): ");
        String symbol = scanner.nextLine();
        System.out.print("Enter Card Value (e.g., Ace, King, 10): ");
        String value = scanner.nextLine();
        
        cards.putIfAbsent(symbol, new ArrayList<>());
        cards.get(symbol).add(value);
    }

    private static void searchCards() {
        System.out.print("Enter Symbol to search: ");
        String symbol = scanner.nextLine();
        
        if (cards.containsKey(symbol)) {
            System.out.println("Cards in " + symbol + ": " + cards.get(symbol));
        } else {
            System.out.println("No cards found for this symbol");
        }
    }
}