package com.bcrs.adminapp;

public class recyclerNewOrders {

    private String CusName;
    private String OrderId;
    private String Total;
    private String time;
    private String Message;



    public recyclerNewOrders(String cusName, String orderId, String total, String time, String message) {
        this.CusName = cusName;
        this.OrderId = orderId;
        this.Total = total;
        this.time = time;
        this.Message = message;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String cusName) {
        CusName = cusName;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
