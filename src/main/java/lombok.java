import Entity.ProductDetailInfo;
import Entity.ProductDetailInfoCp;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;

public class lombok {

    public static void main(String[] args) {

        ProductDetailInfo productDetailInfo = new ProductDetailInfo();
        productDetailInfo.setName("yuan");
        productDetailInfo.setBrand("qing");
        productDetailInfo.setSpecInfo(productDetailInfo.getSpecInfoInsatnce(1L,"1"));

        ProductDetailInfoCp productDetailInfoCopy = new ProductDetailInfoCp();

        BeanUtils.copyProperties(productDetailInfo,productDetailInfoCopy);

        System.out.println(productDetailInfoCopy);

    }
}
