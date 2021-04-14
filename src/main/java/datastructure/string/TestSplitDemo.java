package datastructure.string;

import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author Shadowalker
 */
@Data
public class TestSplitDemo {

    @Data
    private static class PO {
        private BigDecimal bigDecimal;
        private Integer integer;
    }

    public static void main(String[] args) {
        // String s = "abc|de|f|";


        PO po = new PO();
        BigDecimal bigDecimal = new BigDecimal("5000.1264000000");
        po.setBigDecimal(bigDecimal);
        DecimalFormat df = new DecimalFormat("0.00000");
        BigDecimal b = po.bigDecimal;
        System.out.println(b);
        System.out.println(df.format(b));

    }
}
