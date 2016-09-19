package com.ys.demo.commons;

/**
 * Created by yangshe on 2016/9/19.
 */
public enum Results {
    SUCCESS("操作成功",""),FAIL("","操作失败");
    private String success;
    private String fail;
    private Results(String success,String fail){
        this.success = success;
        this.fail = fail;
    }


}
