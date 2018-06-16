package self.demo.geo;

import java.math.BigDecimal;
import java.util.Random;

//import com.jttx.poi.entity.Point;

 
/**
 * Created by louis on 2014/9/2.
 */
public class GeoUtils {
    /**
     * 计算两经纬度点之间的距离（单位：米）
     * @param lng1  经度
     * @param lat1  纬度
     * @param lng2
     * @param lat2
     * @return
     */
    public static double getDistance(double lng1,double lat1,double lng2,double lat2){
        double radLat1 = Math.toRadians(lat1);
        double radLat2 = Math.toRadians(lat2);
        System.out.println("getDistance radLat1:"+radLat1+"radLat2:"+radLat2);
        double a = radLat1 - radLat2;
        double b = Math.toRadians(lng1) - Math.toRadians(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * 6378137.0;// 取WGS84标准参考椭球中的地球长半径(单位:m)
        s = Math.round(s * 10000) / 10000;
        return s;
    }
    
    private  static double EARTH_RADIUS = 6378.137;
    
    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }
    public static double getDistance2( double lng1,double lat1, double lng2, double lat2)
    {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        System.out.println("getDistance radLat1:"+radLat1+"radLat2:"+radLat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + 
         Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }
 
    /**
     * 计算TP值
     * @param curPoint      当前点
     * @param relatedPoint  偏移点
     * @param isGeography   是否是地理坐标 false为2d坐标
     * @return              tp值
     */
    /*
    public static double getDirAngle(Point curPoint,Point relatedPoint,boolean isGeography){
        double result = 0;
        if(isGeography){
            double y2 = Math.toRadians(relatedPoint.getLat());
            double y1 = Math.toRadians(curPoint.getLat());
            double alpha = Math.atan2(relatedPoint.getLat() - curPoint.getLat(), (relatedPoint.getLng() - curPoint.getLng()) * Math.cos((y2 - y1) / 2));//纬度方向乘以cos(y2-y1/2)
            double delta =alpha<0?(2*Math.PI+alpha):alpha;
            result = Math.toDegrees(delta);
        }else {
            double alpha = Math.atan2(relatedPoint.getLat() - curPoint.getLat(), relatedPoint.getLng() - curPoint.getLng());
            double delta=alpha<0?(2*Math.PI+alpha):alpha;
            result = Math.toDegrees(delta);
        }
        return result;
    }*/
    public static String randomLonLat(double min1, double max1,double min2, double max2) {  
        Random random = new Random();  
        BigDecimal db = new BigDecimal(Math.random() * (max1 - min1) + min1);  
        String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();//小数后6位  
        db = new BigDecimal(Math.random() * (max2 - min2) + min2);  
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();  
        return lon+" "+lat;  
    }
    public static void main(String[] args) {
        System.out.println(getDistance(121.446014,31.215937,121.446028464238,31.2158502442799  ));
        System.out.println(getDistance2(121.446014,31.215937,121.446028464238,31.2158502442799  ));
    }
 
}