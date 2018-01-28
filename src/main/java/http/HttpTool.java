package http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

public class HttpTool {

    /**
     * ����post����
     *
     * @author Michael -----CSDN: http://blog.csdn.net/capmiachael
     * @param params
     *            ����
     * @param requestUrl
     *            �����ַ
     * @param authorization
     *            ��Ȩ��
     * @return ���ؽ��
     * @throws IOException
     */
    public static String sendPost(String params, String requestUrl,
                                  String authorization) throws IOException {

        byte[] requestBytes = params.getBytes("utf-8"); // ������תΪ��������
        HttpClient httpClient = new HttpClient();// �ͻ���ʵ����
        PostMethod postMethod = new PostMethod(requestUrl);
        //��������ͷAuthorization
        //postMethod.setRequestHeader("Authorization", "Basic " + authorization);
        // ��������ͷ  Content-Type
        postMethod.setRequestHeader("Content-Type", "application/json");
        InputStream inputStream = new ByteArrayInputStream(requestBytes, 0,
                requestBytes.length);
        RequestEntity requestEntity = new InputStreamRequestEntity(inputStream,
                requestBytes.length, "application/json; charset=utf-8"); // ������
        postMethod.setRequestEntity(requestEntity);
        httpClient.executeMethod(postMethod);// ִ������
        InputStream soapResponseStream = postMethod.getResponseBodyAsStream();// ��ȡ���ص���
        byte[] datas = null;
        try {
            datas = readInputStream(soapResponseStream);// ���������ж�ȡ����
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = new String(datas, "UTF-8");// ����������תΪString
        // ��ӡ���ؽ��
        // System.out.println(result);

        return result;
    }

    /**
     * ���������ж�ȡ����
     *
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();
        outStream.close();
        inStream.close();
        return data;
    }

    public static String sendPost(String url, String param) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = null;
            conn = (HttpURLConnection) realUrl.openConnection();
            // �򿪺�URL֮�������

            // ����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");    // POST����


            // ����ͨ�õ���������

            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            conn.connect();

            // ��ȡURLConnection�����Ӧ�������
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // �����������
            out.write(param);
            // flush������Ļ���
            out.flush();
            // ����BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("���� POST ��������쳣��"+e);
            e.printStackTrace();
        }
        //ʹ��finally�����ر��������������
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }


}
