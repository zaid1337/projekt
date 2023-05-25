import java.util.*;    //Gwiazdka oznacza import wszystkich klas w pakiecie tu akurat jest hashmapa i mapa
public class Bank {
    private Map<String, Konto> konta;

    public Bank() {
        konta = new HashMap<>();
    }

    public void utworzKonto(String numerKonta) {
        Konto konto = new Konto(numerKonta);
        konta.put(numerKonta, konto);
        System.out.println("Utworzono nowe konto o numerze: " + numerKonta);
    }

    public Konto znajdzKonto(String numerKonta) throws BrakKontaException {
        if (konta.containsKey(numerKonta)) {
            return konta.get(numerKonta);
        } else {
            throw new BrakKontaException("Nie znaleziono konta o numerze: " + numerKonta);
        }
    }

    public void wykonajWplate(String numerKonta, double kwota) throws BrakKontaException {
        Konto konto = znajdzKonto(numerKonta);
        konto.wplata(kwota);
    }

    public void wykonajWyplate(String numerKonta, double kwota) throws BrakKontaException, BrakSrodkowException {
        Konto konto = znajdzKonto(numerKonta);
        konto.wyplata(kwota);
    }
}