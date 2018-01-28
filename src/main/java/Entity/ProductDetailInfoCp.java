package Entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
public class ProductDetailInfoCp implements Serializable {

    private String name;

    private String subTitle;

    private String brand;

    private Integer retaiPrice;

    private Integer mainlandPrice;

    private SpecInfo specInfo;

    private String[] imageUrls;

    @Setter
    @Getter
    public class SpecInfo implements Serializable {


        public SpecInfo(Long id, String spec){
            this.id = id;
            this.spec = spec;
        }

        private Long id;
        private String spec;
    }

    public SpecInfo getSpecInfoInsatnce(final Long id, final String spec ){
        return new SpecInfo(id,spec);
    }
}
