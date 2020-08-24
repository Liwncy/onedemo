package com.liwncy.common.base.model;

public class QueryParam {

    public String key;
    public String value;
    public String operation;
    public String orAnd;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOrAnd() {
        if(orAnd==null||"".equals(orAnd))return "Normal";
        return orAnd;
    }

    public void setOrAnd(String orAnd) {

        orAnd = orAnd;
    }

}
