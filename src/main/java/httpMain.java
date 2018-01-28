import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.puze.o2o.api.entity.ERPRefundOrder;
import com.puze.o2o.api.entity.ERPRefundOrderDetail;
import com.puze.o2o.api.entity.RefundGoods;
import com.puze.o2o.api.entity.RefundInfo;
import com.pzhealth.erppre.facade.dto.BaseRes;
import com.pzhealth.erppre.facade.dto.o2o.OrderCreateDto;
import com.pzhealth.erppre.facade.dto.o2o.OrderDetailDto;
import http.HttpUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.*;

public class httpMain {


    public static String buildOrderInfo(){

        OrderCreateDto createDto = new OrderCreateDto();
        createDto.setBillno("2201710180931144871");
        createDto.setStdSum(new BigDecimal("30.0"));
        createDto.setNetSum(new BigDecimal("30.0"));
        createDto.setAccDate(new Date());
        createDto.setAddress("山东省烟台市长岛县南长山街道山东省烟台市长岛县南长山街道乐园大街134号");
        createDto.setBillLogisticsType("配送");
        createDto.setBusno(1000);
        createDto.setCustomName("刘莹");
        createDto.setMemcardNo(null);
        createDto.setTelphone("15900709506");

        List<OrderDetailDto> orderDetail =new ArrayList<OrderDetailDto>();
        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setNetprice(new BigDecimal("10.0"));
        orderDetailDto.setStdprice(new BigDecimal("10.0"));
        orderDetailDto.setWareid(11906l);
        orderDetailDto.setWareqty(1l);

        OrderDetailDto orderDetailDto2 = new OrderDetailDto();
        orderDetailDto2.setNetprice(new BigDecimal("20.0"));
        orderDetailDto2.setStdprice(new BigDecimal("20.0"));
        orderDetailDto2.setWareid(11906l);
        orderDetailDto2.setWareqty(1l);

        orderDetail.add(orderDetailDto2);

        orderDetail.add(orderDetailDto);
        createDto.setOrderDetailDto(orderDetail);


        String json = JSON.toJSONString(createDto);
        System.out.println(json);

        return json;
    }


    public static void postOrder() throws IOException {

        String jsonStr = httpMain.buildOrderInfo();
        final String url = "http://localhost:8080/o2oOrder/orderCreate/";

        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        formParams.add(new BasicNameValuePair("orderInfo", jsonStr));

        String result = "";

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        HttpEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");

        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity httpEntity = response.getEntity();
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);

        Gson gson = new GsonBuilder().create();
        ContentType contentType = ContentType.getOrDefault(httpEntity);
        Charset charset = contentType.getCharset();
        Reader reader = new InputStreamReader(httpEntity.getContent(), charset);
        BaseRes baseRes = gson.fromJson(reader, BaseRes.class);
        System.out.println(baseRes);
    }

    public static void postOrderCancel() throws IOException {

    }

    public static void postTest(){

        final String url ="http://localhost:8080/o2oOrder/test/";
        final String jsonStr = "test";

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity("str="+jsonStr, Charset.forName("utf-8")));

        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println();

    }

    public static String buildRefundInfo(){
//
//        ERPRefundOrder erpRefundOrder = new ERPRefundOrder();
//        erpRefundOrder.setCode(1111L);
//        erpRefundOrder.setBillNo("1111");
//        erpRefundOrder.setNetSum(new Integer("3333"));
//        erpRefundOrder.setStdSum(new Integer("4444"));
//        erpRefundOrder.setReturnMess("退货原因");
//
//        List<ERPRefundOrderDetail> erpRefundOrderDetailList = new ArrayList<>();
//
//        ERPRefundOrderDetail erpRefundOrderDetail1 = new ERPRefundOrderDetail();
//        erpRefundOrderDetail1.setNetPrice(new Integer("1111"));
//        erpRefundOrderDetail1.setStdPrice(new Integer("1111"));
//        erpRefundOrderDetail1.setWareId(1111L);
//        erpRefundOrderDetail1.setWareQty(2);
//
//        ERPRefundOrderDetail erpRefundOrderDetail2 = new ERPRefundOrderDetail();
//        erpRefundOrderDetail2.setNetPrice(new Integer("1111"));
//        erpRefundOrderDetail2.setStdPrice(new Integer("1111"));
//        erpRefundOrderDetail2.setWareId(1111L);
//        erpRefundOrderDetail2.setWareQty(2);
//
//        erpRefundOrderDetailList.add(erpRefundOrderDetail1);
//        erpRefundOrderDetailList.add(erpRefundOrderDetail2);
//
//        erpRefundOrder.setErpRefundOrderDetailList(erpRefundOrderDetailList);
//
//        String json = JSON.toJSONString(erpRefundOrder);
//        System.out.println(json);
//
//        return json;

        return null;

    }






    public static void main(String[] args) {

//        final String url = "http://localhost:8080/o2oOrder/orderCreate/";
//        final String jsonstr = httpMain.buildOrderInfo();
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("orderInfo",jsonstr);
//
//        BaseRes result = null;
//        try {
//            result = HttpUtil.<BaseRes>postJson(url,map,BaseRes.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(result.getResCode());
//        System.out.println(result.getResMsg());


//        final String url = "http://localhost:8080/o2oOrder/orderCancel/";
//        final String jsonstr = "8888888";
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("orderId",jsonstr);
//
//        BaseRes result = null;
//        try {
//            result = HttpUtil.<BaseRes>postJson(url,map,BaseRes.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(result);


        final String url = "http://localhost:8080/erpOrder.refund/";
        final String jsonstr = buildRefundInfo();
        Map<String,String> map = new HashMap<String,String>();
        map.put("orderRefundInfo",jsonstr);

        Map result = null;
        try {
            result = HttpUtil.<HashMap>postJson(url,map,HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject object = JSON.parseObject((String)result.get("content"));
        System.out.println(object.get("code"));
        System.out.println(object.get("desc"));

//        System.out.println(new BigDecimal((double)50/100).setScale(2, BigDecimal.ROUND_HALF_UP));

//        final String url = "http://localhost:8080/erp.test";
//        Map result = null;
//        try {
//            result = HttpUtil.<HashMap>postJson(url,null,HashMap.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JSONObject object = JSON.parseObject((String)result.get("content"));
//        System.out.println(object.get("a"));
//        System.out.println(object.get("b"));

//        final String url = "http://localhost:8080/erpOrder.status/";
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("orderId","2201710181523005382");
//        map.put("orderStatus","1");
//        Map result = null;
//        try {
//            result = HttpUtil.<HashMap>postJson(url,map,HashMap.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JSONObject object = JSON.parseObject((String)result.get("content"));
//        System.out.println(object.get("code"));
//        System.out.println(object.get("desc"));



    }
}
