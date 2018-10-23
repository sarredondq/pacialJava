public class Elefante{
    private int peso;
    private int ci;
    private int pocision;
    public void Elefante(int peso,int ci,int pocision){
        this.peso = peso;
        this.ci = ci;
        this.pocision = pocision;
    }
    public void setPeso(int peso){
        this.peso = peso;
    }
    public void setCi(int ci){
        this.ci = ci;
    }
    public void setPocision(int pocision){
        this.pocision = pocision;
    }
    public int getPeso(){
        return this.peso;
    }
    public int getCi(){
        return this.ci;
    }
    public int getPosicion(){
        return this.pocision;
    }
}