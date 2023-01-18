package TestScenarios;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.*;


public class ProductsTest extends BaseClass {

    @Test
    public static void AddProductsToChart() throws InterruptedException {

        Map<Integer, Float> prices = new HashMap<>();

        Integer itemToDelete = null;
        
        driver.findElement(By.xpath("//a[@aria-label='Add “Flying Ninja” to your cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@aria-label='Add “Ninja Silhouette” to your cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@aria-label='Add “Patient Ninja” to your cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@aria-label='Add “Ship Your Idea” to your cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();
        Thread.sleep(2000);

        prices.put(1, Float.parseFloat(driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[2]")).getText().replace("$", "")));
        prices.put(2, Float.parseFloat(driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[4]")).getText().replace("$", "")));
        prices.put(3, Float.parseFloat(driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[6]")).getText().replace("$", "")));
        prices.put(4, Float.parseFloat(driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[8]")).getText().replace("$", "")));


        List<Map.Entry<Integer, Float> > list =
                new LinkedList<Map.Entry<Integer, Float> >(prices.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Float> >() {
            public int compare(Map.Entry<Integer, Float> o1,
                               Map.Entry<Integer, Float> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<Integer, Float> sortedPrices = new LinkedHashMap<Integer, Float>();
        for (Map.Entry<Integer, Float> aa : list) {
            sortedPrices.put(aa.getKey(), aa.getValue());
        }

        Float max =sortedPrices.get(sortedPrices.size() - 1);

        for (Map.Entry<Integer, Float> entry : sortedPrices.entrySet()) {
            itemToDelete = entry.getKey();
        }

        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/main[1]/article[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[" + itemToDelete + "]/td[1]/a[1]")).click();
        Thread.sleep(2000);

        System.out.println(max);
    }
}
