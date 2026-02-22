package com.alura.literalura.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
    public <T> T converteDados(String json, Class<T> classe) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.readValue(json, classe);
            return mapper.readValue(json, classe);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
}