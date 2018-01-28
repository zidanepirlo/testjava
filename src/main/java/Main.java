import Entity.AAA;
import Entity.BBB;
import Entity.Student;
import Entity.XXXX;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Splitter;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import utils.MerchantStatus;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;
import Exception.*;

public class Main {

    private class NeighbourDistance
            implements Comparable<NeighbourDistance>
    {
        private Long busno;
        private double distance;

        public NeighbourDistance(Long busno, double distance) {
            this.busno = busno;
            this.distance = distance;
        }

        public double getDistance() {
            return distance;
        }


        @Override
        public int compareTo(NeighbourDistance nd) {
            BigDecimal distanceA = new BigDecimal(this.distance);
            BigDecimal distanceB = new BigDecimal(nd.getDistance());
            return  distanceA.compareTo(distanceB);
        }

        @Override
        public String toString(){
            return this.busno + ":" + this.distance;
        }
    }



    public void CollectionSort(){

        NeighbourDistance db1 = new NeighbourDistance(1L,3.17);
        NeighbourDistance db2 = new NeighbourDistance(2L,3.15);
        NeighbourDistance db3 = new NeighbourDistance(3L,3.16);
        NeighbourDistance db4 = new NeighbourDistance(3L,3.18);


        List<NeighbourDistance> list = new ArrayList<>();

        list.add(db1);
        list.add(db2);
        list.add(db3);
        list.add(db4);

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);
    }


    public static void fun1(){
        System.out.println("fun1()");
        throw new RuntimeException("fun1 RuntimeException");
    }

    public static void fun2(){
        fun1();
        System.out.println("fun2()");
    }


    public static void fun3() throws MyExcep1 {

//        int a = 1/0;
        throw new MyExcep1("fun3 MyExcep1");
    }

    public static void main(String[] args) throws Exception {

        try {
            Main.fun3();
        }catch (MyExcep1 ex){
            System.out.print(ex.getErrorMsg());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

//        double xxx =3.1415;
//        double yyy =3.1416;
//        System.out.println(new BigDecimal(xxx));
//        System.out.println(new BigDecimal(xxx).compareTo(new BigDecimal(yyy)));

//        new Main().CollectionSort();

//        int aaa ;
//        int bbb = aaa +1;
//        System.out.println(aaa);

//        String input = "apple,banana,orange";
////        String input = "apple";
//        List<String> result = Splitter.onPattern(",")
//                .omitEmptyStrings()
//                .splitToList(input);
//
//        for (String str:result){
//            System.out.println(str);
//        }


//        Integer count = new Integer("10000");
//        Integer result = count/3;
//        Integer result1 = result/100;
//
//        System.out.println(result);
//        System.out.println(result1);

//        long refundsCount = 1;
//
//        System.out.println(Integer.parseInt(refundsCount+""));

//        BBB bbb = new BBB();
//        bbb.setId("AAA");
//        bbb.setName("BBB");
//
//        System.out.println(bbb.getId());
//        System.out.println(bbb.getName());

//        Integer val = new Integer("2");
//        Long val2 = new Long(1);
//        long val1  = val-val2;
//
//        System.out.println(val1);

//        Main.fun2();

//        List<Student> list = new ArrayList<>();
//
//        Student student1 = new Student();
//        student1.setId("1");
//        student1.setAge(1);
//
//        Student student2 = new Student();
//        student2.setId("2");
//        student2.setAge(2);
//
//        list.add(student1);
//        list.add(student2);
//
//
//        String strjson = JSONObject.toJSONString(list);
//
//        List<XXXX> list1 = JSON.parseArray(strjson,XXXX.class);
//
//        System.out.println(list1);
//
//        for (XXXX xxx : list1){
//            System.out.println(xxx.getId());
//            System.out.println(xxx.getAge());
//        }

//        long goodsPrice = 41;
//        BigDecimal result = new BigDecimal((double)goodsPrice/(100*3)).setScale(2, RoundingMode.DOWN);
//        BigDecimal result1 = new BigDecimal((double)goodsPrice/(100*3));
//        System.out.println(new BigDecimal((double)(41-1)/100).setScale(2, BigDecimal.ROUND_HALF_UP));
//
//        long price1 = 980*3-2909;
//
//        System.out.println(new BigDecimal((double)price1/(100*3)).setScale(2, RoundingMode.DOWN));
//        System.out.println((new BigDecimal((double)price1/(100*3)).setScale(2, RoundingMode.DOWN)).multiply(new BigDecimal("3")));
//
//
//        long price2 = 300*3-891;
//
//        System.out.println(new BigDecimal((double)price2/(100*3)).setScale(2, RoundingMode.DOWN));
//        System.out.println((new BigDecimal((double)price2/(100*3)).setScale(2, RoundingMode.DOWN)).multiply(new BigDecimal("3")));

//        BigDecimal totalPrice = new BigDecimal("0.00");
//        BigDecimal netPrice = new BigDecimal("0.20");
//
//        totalPrice = totalPrice.add(netPrice.multiply(BigDecimal.valueOf(3)));
//
//        System.out.println(totalPrice);
//
//        Map<Long,String> map = new HashMap<>();
//
//        map.put(1L,"yuan");

//        List<String> list = new ArrayList<>();
//        list.add("4");
//        list.add("5");
//        list.add("9");
//
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
//
//        list.remove(list.get(0));
//
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }

//        Integer aaa =new Integer("1");
////        int bbb = aaa;
////        aaa = 3;
//        Integer bbb = aaa;
//        aaa = new Integer("4");
//
//        System.out.println(bbb);


//            System.out.println(new BigDecimal(String.valueOf((double)300/(100*10))).setScale(2, RoundingMode.DOWN));
//            System.out.println(new BigDecimal(String.valueOf((double)1/3)).setScale(2, RoundingMode.DOWN));

//            double temp = (double)300/(100*10);
//            String str = String.valueOf(temp);
//            System.out.println(new BigDecimal(str));

//            System.out.println(new BigDecimal((double)(301-0)/100).setScale(2, RoundingMode.DOWN));
//            System.out.println(new BigDecimal(String.valueOf((double)(301-0)/100)).setScale(2, RoundingMode.DOWN));


//        String str1 = new String("str1");
//        String str2 = str1;
//
//        System.out.println("str1="+str1);
//        System.out.println("str2="+str2);
//
//        str2 = "str2";
//
//        System.out.println("str1="+str1);
//        System.out.println("str2="+str2);
//
//        System.out.println("------------------");
//
//
//        AAA aaa1 = new AAA("aaa1");
//        AAA aaa2 = aaa1;
//
//        System.out.println("aaa1="+aaa1.getId());
//        System.out.println("aaa2="+aaa2.getId());
//
//        aaa2.setId("aaa2");
//
//        System.out.println("aaa1="+aaa1.getId());
//        System.out.println("aaa2="+aaa2.getId());

    }
}
