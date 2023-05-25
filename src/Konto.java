public class Konto {
    private final String numerKonta;
    private double saldo;

    public Konto(String numerKonta) {
        this.numerKonta = numerKonta;
        this.saldo = 0.0;
    }

    public void wplata(double kwota) {
        saldo += kwota;
        System.out.println("Wpłata zakończona pomyślnie. Aktualne saldo: " + saldo);
    }

    public void wyplata(double kwota) throws BrakSrodkowException {
        if (saldo >= kwota) {
            saldo -= kwota;
            System.out.println("Wypłata zakończona pomyślnie. Aktualne saldo: " + saldo);
        } else {
            throw new BrakSrodkowException("Brak wystarczających środków na koncie!");
        }
    }
}