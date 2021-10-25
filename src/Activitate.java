import java.io.FileWriter;
public class Activitate {
    private String nume;
    private String prioritate;
    private int index;
    public static int lastindex;

    public Activitate(String nume) {
        this.nume = nume;
        this.prioritate = "optional";

    }

    public Activitate(String nume, String prioritate) {
        this.nume = nume;
        this.prioritate = prioritate;

    }

    public void setNume(String nume) {
        this.nume = nume;

    }

    public void setPrioritate(String prioritate) {
        this.prioritate = prioritate;
    }

    public String getNume() {
        return this.nume;
    }

    public String getPrioritate() {
        return this.prioritate;
    }

    public String toString() {
        StringBuffer res=new StringBuffer(this.index-1+"");
        res.append("nume: "+this.nume);
        res.append(" prenume: "+this.prioritate);

        return res.toString();
    }

    public int getLastIndex(){
        return this.lastindex;
    }
    public void addIndex(int lastindex){
        this.index=lastindex+1;
    }
    public void minusIndex() {
        if (this.index != 0) {
            this.index -= 1;

        }
    }
    public void addLastIndex(){
        this.lastindex+=1;
    }
    public void minusLastIndex(){
        this.lastindex-=1;
    }
    public boolean validareNume(String temp){
        if(temp.equals("")){
            return false;
        }else
            return true;
    }
}


