public class TuposDapanis {
    public String kodikos;
    public String perigrafi;
    public double megistiMiniaiaApozimiosi;
    public double posotita_aksia; // We need this for printing information ex.We have an expense for 30km
    public int tupos;

    public TuposDapanis(String kodikos, String perigrafi, double megistiMiniaiaApozimiosi){
        this.kodikos = kodikos;
        this.perigrafi = perigrafi;
        this.megistiMiniaiaApozimiosi = megistiMiniaiaApozimiosi;
        this.tupos = 0;
    }

    public double upologismosDapanis (double p) {
        this.posotita_aksia = p;
        return 0.0;
    }

    public String toString(){
      return kodikos + " " + perigrafi + " " + megistiMiniaiaApozimiosi;
    }

}

class TuposDapanis1 extends TuposDapanis{
    public double timiAnaMonada;
    public String monadaMetrisis;

    public TuposDapanis1(String kodikos, String perigrafi, double megistiMiniaiaApozimiosi, double timi, String monada) {
        super (kodikos, perigrafi, megistiMiniaiaApozimiosi);
        this.timiAnaMonada = timi;
        this.monadaMetrisis = monada;
        this.tupos = 1;
    }

    public double upologismosDapanis(double p) {
        this.posotita_aksia = p;
        return posotita_aksia * timiAnaMonada;
    }

    public String toString(){ //(okay)
      return perigrafi + " | " + posotita_aksia + monadaMetrisis;
    }

}

class TuposDapanis2 extends TuposDapanis{
    public double posostoApozimiosis;

    public TuposDapanis2 (String kodikos, String perigrafi, double megistiMiniaiaApozimiosi, double posostoApozimiosis){
        super(kodikos, perigrafi, megistiMiniaiaApozimiosi);
        this.posostoApozimiosis = posostoApozimiosis;
        this.tupos = 2;
    }

    public double upologismosDapanis(double p) {
        this.posotita_aksia = p;
        return posotita_aksia * posostoApozimiosis;
    }

    public String toString(){
      return perigrafi + " " + posostoApozimiosis * 100 + " " + megistiMiniaiaApozimiosi;
    }
}
