package sha;

import java.security.MessageDigest;

/**
 * Created by yuan on 2017/7/2.
 */
public class SHACoder {

    /**
     * SHA-1��ϢժҪ
     * @param ���������ϢժҪ
     * @author kongqz
     *
     * **/
    public static byte[] encodeSHA(byte[] data) throws Exception{

        //��ʼ��MessageDisgest
        MessageDigest md= MessageDigest.getInstance("SHA");

        return md.digest(data);
    }
    /**
     * SHA-256��ϢժҪ
     * @param ���������ϢժҪ
     * @author kongqz
     *
     * **/
    public static byte[] encodeSHA256(byte[] data) throws Exception{

        //��ʼ��MessageDisgest
        MessageDigest md= MessageDigest.getInstance("SHA-256");

        return md.digest(data);
    }

    /**
     * SHA-384��ϢժҪ
     * @param ���������ϢժҪ
     * @author kongqz
     *
     * **/
    public static byte[] encodeSHA384(byte[] data) throws Exception{

        //��ʼ��MessageDisgest
        MessageDigest md= MessageDigest.getInstance("SHA-384");

        return md.digest(data);
    }

    /**
     * SHA-512��ϢժҪ
     * @param ���������ϢժҪ
     * @author kongqz
     *
     * **/
    public static byte[] encodeSHA512(byte[] data) throws Exception{

        //��ʼ��MessageDisgest
        MessageDigest md= MessageDigest.getInstance("SHA-512");

        return md.digest(data);
    }
    public static void main(String[] args) throws Exception {

        String str = "java֧�ֵ�SHA ��ϢժҪ�㷨";
        System.out.println("ԭ�ģ�" + str);
        byte[] data1 = SHACoder.encodeSHA(str.getBytes());
        System.out.println("SHA/SHA1����ϢժҪ�㷨ֵ��" + data1.toString());

        byte[] data2 = SHACoder.encodeSHA256(str.getBytes());
        System.out.println("SHA-256����ϢժҪ�㷨ֵ��" + data2.toString());


        byte[] data3 = SHACoder.encodeSHA384(str.getBytes());
        System.out.println("SHA-384����ϢժҪ�㷨ֵ��" + data3.toString());


        byte[] data4 = SHACoder.encodeSHA512(str.getBytes());
        System.out.println("SHA-512����ϢժҪ�㷨ֵ��" + data4.toString());
    }
}
