package JavaApplication125;
public class Chocolate extends Product{
double weight;

    Chocolate(String productName, String barCode, double basicPrice, double weight){
    super(productName,barCode,basicPrice);
    this.weight = weight;
    }

    @Override
    public String toString(){
    return super.toString() + "Weight of product is:" + "\n" + this.weight + " g " + "\n" ;

     }
}
