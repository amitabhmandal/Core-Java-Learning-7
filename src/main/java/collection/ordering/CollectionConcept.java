package collection.ordering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionConcept {

    public static void main(String[] args) {
        Product door = new Product("wooden door" , 35);
        Product floorPanel = new Product("floor Panel" , 25);
        Product window = new Product("Glass window" , 10);
        
        Collection<Product> products = new ArrayList<Product>();
        products.add(door);
        products.add(floorPanel);
        
        //add method returns true
        
        
        System.out.println(products.add(window));
        System.out.println(products);
        
        
        Collection<Product> subProducts = new ArrayList<Product>();
        subProducts.add(floorPanel);
        subProducts.add(window);
        
        // addAll returns true
        System.out.println(products.addAll(subProducts));
        System.out.println(products);
        
        
        final Iterator<Product> productIterator = products.iterator();
        
        while(productIterator.hasNext()) {
            System.out.println(productIterator.next());
        }
        
        
        
        
        
        
        
        
    }

}
