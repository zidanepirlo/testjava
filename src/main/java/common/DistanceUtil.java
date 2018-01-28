package common;

import java.math.BigDecimal;

/**
 * Created by haoyanli on 2017/8/15.
 */
public class DistanceUtil {

    private static double EARTH_RADIUS = 6378.137;  //地球半径
    public static double SHIPPING_DISTANCE = 5;   //配送距离

    private static double rad(double d) {
        return d * Math.PI / 180.0;     //计算弧长
    }

    //计算两点间的直线距离
    public static double getDistance(double Lat1,double Lon1,double Lat2,double Lon2){
        double radLat1 = rad(Lat1);
        double radLat2 = rad(Lat2);
        double a =radLat1 - radLat2;
        double b =rad(Lon1) - rad(Lon2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + Math.cos(radLat1)* Math.cos(radLat2)* Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        BigDecimal bg = new BigDecimal(s);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    public static double getDistance_1(double Lat1,double Lon1,double Lat2,double Lon2){

        double distance = Math.sqrt(Math.pow((rad(Lat1)-rad(Lat2)),2)+Math.pow((rad(Lon1)-rad(Lon2)),2));
        BigDecimal bg = new BigDecimal(distance);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1*EARTH_RADIUS;
    }

    public static void main(String[] args) {

        System.out.println(DistanceUtil.getDistance(1.0,3.0,2.0,5.0));
        System.out.println(DistanceUtil.getDistance_1(1.0,3.0,2.0,5.0));
    }

}
