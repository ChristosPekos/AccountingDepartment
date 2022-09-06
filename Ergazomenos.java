import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ergazomenos {
    public String kwdikos;
    public String onoma;
    public String epitheto;
    public double megistiMiniaiaApozimiosi;
    ArrayList<Kiniseis> kiniseisErgazomenou = new ArrayList<Kiniseis>();


    public Ergazomenos(String k, String n, String s, double c){
        this.kwdikos = k;
        this.onoma = n;
        this.epitheto = s;
        this.megistiMiniaiaApozimiosi = c;
    }

    public String toString(){
        return onoma + " " + epitheto;
    }

}
