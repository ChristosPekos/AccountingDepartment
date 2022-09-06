public class DapaniErgazomenou {
    public Ergazomenos ergazomenos;
    public TuposDapanis tuposDapanis;
    public double aksiaApozimiosis;

    public DapaniErgazomenou (Ergazomenos e, TuposDapanis d, double aksiaApozimiosis) {
        this.ergazomenos = e;
        this.tuposDapanis = d;
        this.aksiaApozimiosis = aksiaApozimiosis;
    }

    public String toString() {
        return ergazomenos.toString() + " | " + tuposDapanis.toString() + " | " + aksiaApozimiosis;
    }
}
