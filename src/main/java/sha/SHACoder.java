package sha;

import java.security.MessageDigest;

/**
 * Created by yuan on 2017/7/2.
 */
public class SHACoder {

    /**
     * SHA-1消息摘要
     * @param 待处理的消息摘要
     * @author kongqz
     *
     * **/
    public static byte[] encodeSHA(byte[] data) throws Exception{

        //初始化MessageDisgest
        MessageDigest md= MessageDigest.getInstance("SHA");

        return md.digest(data);
    }
    /**
     * SHA-256消息摘要
     * @param 待处理的消息摘要
     * @author kongqz
     *
     * **/
    public static byte[] encodeSHA256(byte[] data) throws Exception{

        //初始化MessageDisgest
        MessageDigest md= MessageDigest.getInstance("SHA-256");

        return md.digest(data);
    }

    /**
     * SHA-384消息摘要
     * @param 待处理的消息摘要
     * @author kongqz
     *
     * **/
    public static byte[] encodeSHA384(byte[] data) throws Exception{

        //初始化MessageDisgest
        MessageDigest md= MessageDigest.getInstance("SHA-384");

        return md.digest(data);
    }

    /**
     * SHA-512消息摘要
     * @param 待处理的消息摘要
     * @author kongqz
     *
     * **/
    public static byte[] encodeSHA512(byte[] data) throws Exception{

        //初始化MessageDisgest
        MessageDigest md= MessageDigest.getInstance("SHA-512");

        return md.digest(data);
    }
    public static void main(String[] args) throws Exception {

        String str = "java支持的SHA 消息摘要算法";
        System.out.println("原文：" + str);
        byte[] data1 = SHACoder.encodeSHA(str.getBytes());
        System.out.println("SHA/SHA1的消息摘要算法值：" + data1.toString());

        byte[] data2 = SHACoder.encodeSHA256(str.getBytes());
        System.out.println("SHA-256的消息摘要算法值：" + data2.toString());


        byte[] data3 = SHACoder.encodeSHA384(str.getBytes());
        System.out.println("SHA-384的消息摘要算法值：" + data3.toString());


        byte[] data4 = SHACoder.encodeSHA512(str.getBytes());
        System.out.println("SHA-512的消息摘要算法值：" + data4.toString());
    }
}
