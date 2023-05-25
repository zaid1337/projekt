import java.util.*;    //Gwiazdka oznacza import wszystkich klas w pakiecie tu jest scanner i mishmashexception
public class ZarzadzanieBankiem {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {                             //Pętla, która nie zamyka nam programu po wcisnieciu case
            System.out.println("Wybierz operację:");
            System.out.println("1. Utwórz konto");
            System.out.println("2. Wpłać środki");
            System.out.println("3. Wypłać środki");
            System.out.println("4. Zakończ program");

            int wybor = scanner.nextInt();
            scanner.nextLine(); // Pobranie znaku nowej linii po wczytaniu liczby

            try {
                switch (wybor) {
                    case 1:
                        System.out.println("Podaj numer konta:");
                        String numerKonta = scanner.nextLine();
                        bank.utworzKonto(numerKonta);
                        break;
                    case 2:
                        System.out.println("Podaj numer konta:");
                        numerKonta = scanner.nextLine();
                        System.out.println("Podaj kwotę do wpłaty:");
                        double kwotaWplaty = scanner.nextDouble();
                        bank.wykonajWplate(numerKonta, kwotaWplaty);
                        break;
                    case 3:
                        System.out.println("Podaj numer konta:");
                        numerKonta = scanner.nextLine();
                        System.out.println("Podaj kwotę do wypłaty:");
                        double kwotaWyplaty = scanner.nextDouble();
                        bank.wykonajWyplate(numerKonta, kwotaWyplaty);
                        break;
                    case 4:
                        System.out.println("Program zakończony.");
                        System.exit(0);
                    default:
                        System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono nieprawidłowe dane. Spróbuj ponownie.");
                scanner.nextLine(); // Wyczyszczenie bufora skanera
            } catch (BrakKontaException | BrakSrodkowException e) {
                System.out.println("Błąd: " + e.getMessage());
            }
        }
    }
}