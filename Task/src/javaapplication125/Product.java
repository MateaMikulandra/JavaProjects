package JavaApplication125;
public abstract class Product {
        public String productName;
        public String barCode;
        double basicPrice;
        final double tax = 1.20;
        
        Product(String productName, String barCode, double basicPrice){
            this.productName = productName;
            this.barCode = barCode;
            this.basicPrice = basicPrice;
        }
        public double price(){       
            return this.basicPrice * this.tax;
        }
        @Override
            public String toString(){
            return "Name of product:" + "\n" + this.productName + "\n" + 
            "BarCode of product:" + "\n" + this.barCode + "\n" + 
            "Price of product without PDV(20%):" + "\n" + this.basicPrice + 
            " din " + "\n" + "The final price of product with PDV(20%):" + "\n" + 
            this.price() + " din " + "\n";
    }   
    }