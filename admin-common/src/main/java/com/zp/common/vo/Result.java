package com.zp.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Result<T> {
    private static final int SUCCESS = 200;
    private static final int FAIL = 200;
    private int code;
    private String message;
    private T data;
    public static <T> Result<T> success(){
        return new Result<>(SUCCESS,"操作成功!",null);
    }
    public static <T> Result<T> success(String message){
        return new Result<>(SUCCESS,message,null);
    }
    public static <T> Result<T> success(T data){
        return new Result<>(SUCCESS,"操作成功!",data);
    }
    public static <T> Result<T> success(String message,T data){
        return new Result<>(SUCCESS,message,data);
    }
    public static <T> Result<T> fail(){
        return new Result<>(SUCCESS,"操作失败!",null);
    }
    public static <T> Result<T> fail(String message){
        return new Result<>(SUCCESS,message,null);
    }
    public static <T> Result<T> fail(T data){
        return new Result<>(SUCCESS,"操作失败!",data);
    }
    public static <T> Result<T> fail(String message,T data){
        return new Result<>(SUCCESS,message,data);
    }

















}
