package Farmacia.Entity;

public class OrdineFarmaco {

    private int quantità;
    private Farmaco farmaco;
    
    public OrdineFarmaco(int quantità, Farmaco farmaco) {
    	this.quantità = quantità;
    	this.farmaco = farmaco;
    }
    
    public int getQuantità(){
    	return quantità;
    }
    
    public void setQuantità(int quantità) {
    	this.quantità = quantità;
    }
    
    public Farmaco getFarmaco() {
    	return farmaco;
    }
    	
    public void setFarmaco(Farmaco farmaco) {
    	this.farmaco = farmaco;
    }
    
    public String toString() {
    	return farmaco.getNome() + ", Quantità= " + quantità;
    }
}