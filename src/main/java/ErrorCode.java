/**
 * Created by PUZE-067 on 2017/5/23.
 */
public enum ErrorCode {
    /** 格式校验枚举 **/
    VALIDATE_ISNULL("100001","数据项为空!"),

    /** 系统枚举 **/
    SYS_SUCCESS("000000","正常"),
    SYS_FAILD("900000","系统异常"),
    SYS_ErrorActionCode("900001","没有操作权限"),
    SYS_SessionOutActionCode("900002","会话超时");


    private final String code;
    private final String desc;

    private ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


}
