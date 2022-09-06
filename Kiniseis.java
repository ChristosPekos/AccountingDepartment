import java.util.ArrayList;

public class Kiniseis{

  public Ergazomenos ergazomenos;
  public double aksiaApozimiosis;
  public int tupos;

  public Kiniseis(Ergazomenos erg, double aksia){
    this.ergazomenos = erg;
    this.aksiaApozimiosis=aksia;
    this.tupos = 0;

  }

  public static double upologismosKinhseon(ArrayList<Kiniseis> kiniseisErgazomenou){
        double aksiaKiniseonApozimiosis = 0;
        double aksiaKiniseonProkatavolis = 0;
        double aksiaKiniseonDiaforas = 0;
        for (Kiniseis kinisi : kiniseisErgazomenou){
            if (kinisi instanceof KiniseisApozimiosis){
                aksiaKiniseonApozimiosis+= kinisi.aksiaApozimiosis;
            }
            else if(kinisi instanceof KiniseisProkatavolis){
                aksiaKiniseonProkatavolis+= kinisi.aksiaApozimiosis;
            }
            else {
                aksiaKiniseonDiaforas += kinisi.aksiaApozimiosis;
            }

        }

        return aksiaKiniseonApozimiosis - aksiaKiniseonProkatavolis - aksiaKiniseonDiaforas;

    }

  public String toString(){
      return ergazomenos.epitheto + " " + aksiaApozimiosis;
  }

}

class KiniseisApozimiosis extends Kiniseis{

    public TuposDapanis tuposDapanis;

    public KiniseisApozimiosis(Ergazomenos ergazomenos, double aksiaApozimiosis, TuposDapanis tuposDap){
      super(ergazomenos, aksiaApozimiosis);
      this.tuposDapanis  = tuposDap;
      this.tupos = 1;
    }

    public String toString(){
      return "Compensation " + ergazomenos.epitheto + " " + tuposDapanis + " " + aksiaApozimiosis;

    }

}

class KiniseisDiaforas extends Kiniseis{

    public KiniseisDiaforas(Ergazomenos ergazomenos, double aksiaApozimiosis){
      super(ergazomenos, aksiaApozimiosis);
      this.tupos = 2;
    }

    public String toString(){
      return "Difference " + ergazomenos.epitheto + " " + aksiaApozimiosis;

    }
}


class KiniseisProkatavolis extends Kiniseis{

    public KiniseisProkatavolis(Ergazomenos ergazomenos, double aksiaApozimiosis){
      super(ergazomenos, aksiaApozimiosis);
      this.tupos = 3;

    }

    public String toString(){
      return "Payment in advance " + ergazomenos.epitheto + " " + aksiaApozimiosis;

    }
}
class KiniseisTelikisApozimiosis extends  Kiniseis {
    public KiniseisTelikisApozimiosis(Ergazomenos ergazomenos, double aksiaApozimiosis){
        super(ergazomenos, aksiaApozimiosis);
        this.tupos = 4;

    }

    public String toString(){
        return "Final compensation " + ergazomenos.epitheto + " " + aksiaApozimiosis;

    }
}
