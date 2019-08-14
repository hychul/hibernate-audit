package com.hychul.hibernate.audit.controller.model;

public class ManyDto {
    public Long id;
    public String name;
    public OneDto oneDto;

    public ManyDto() {

    }

    public ManyDto(Long id, String name, OneDto oneDto) {
        this.id = id;
        this.name = name;
        this.oneDto = oneDto;
    }
}
