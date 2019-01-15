package JavaApplication125;
public class Wine extends Product{
    double volume;
    final double tax1 = 1.10;

    Wine(String productName, String barCode, double basicPrice, double volume){
    super(productName,barCode,basicPrice);
    this.volume = volume;
    }

    public double price1(){
    return Math.round(this.price() * this.tax1);
    }      
          
    @Override
    public String toString(){
    return super.toString() + "Volume of product is:" + "\n" + this.volume +
            " l " + "\n" + "Price of product with 10%PDV: " + "\n" + this.price1() + "din" + 
            "\n";
    }
}