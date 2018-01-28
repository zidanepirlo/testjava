public enum ERPOrder {

    ORDER_COMMIT("orderCreate","orderInfo"),
    ORDER_CANCEL("orderCancel","orderId");

    String reqMap;
    String reqVar;

    public String getReqMap() {
        return reqMap;
    }

    public void setReqMap(String reqMap) {
        this.reqMap = reqMap;
    }

    public String getReqVar() {
        return reqVar;
    }

    public void setReqVar(String reqVar) {
        this.reqVar = reqVar;
    }

    private ERPOrder(String reqMap, String reqVar) {
        this.reqMap = reqMap;
        this.reqVar = reqVar;
    }


}
