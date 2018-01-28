public enum BillType {

    MERCHANT_SEND(2,"配送"),
    SELF_GET(1,"自提");

    int code;
    String desc;

    BillType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }



    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static BillType getByCode(final int code){

        for (BillType e : BillType.values()) {

            if(e.code == code ){
                return e;
            }
        }
        return null;
    }
}
