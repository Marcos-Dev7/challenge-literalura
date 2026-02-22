package com.alura.literalura.service;

public interface IConverteDados {
    public default <T> T converteDados(String json, Class<T> classe) {
        return null;
    }

}
