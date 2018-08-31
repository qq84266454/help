package com.weijun.helpcircle.pojo;


public class ResponseBean<T> {

    /**
     * interfaceName : friendListGet
     * interfaceVersion : 1.1
     * resCode : 000
     * resMsg : success
     * resDataNumber : 2
     * resData : [{"userId":"uid7y8w9i02is8xox0xps0s84w5e6f7c","userName":"雷锋","userIcon":"https://118.178.193.11/uploadFilesList?url=19s8djsaa9","userIntroduce":"互助社区组织者，小企业家协会发起人","userAddFriendTime":"2018-11-10 11:28","hash16":"q1a2z3x4s5w6e7d"},{"userId":"uid7y8w9i02is8xox0xps0s84w5e6f7c","userName":"白求恩","userIcon":"https://118.178.193.11/uploadFilesList?url=19s7h9oi9","userIntroduce":"互助社区组织者，小企业家协会发起人","userAddFriendTime":"2018-11-10 11:28","hash16":"q1a2z3x4s5w6e7d"}]
     */

    private String interfaceName;
    private String interfaceVersion;
    private String resCode;
    private String resMsg;
    private String resDataNumber;
    private T resData;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getInterfaceVersion() {
        return interfaceVersion;
    }

    public void setInterfaceVersion(String interfaceVersion) {
        this.interfaceVersion = interfaceVersion;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public String getResDataNumber() {
        return resDataNumber;
    }

    public void setResDataNumber(String resDataNumber) {
        this.resDataNumber = resDataNumber;
    }

    public T getResData() {
        return resData;
    }

    public void setResData(T resData) {
        this.resData = resData;
    }
}
