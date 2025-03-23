package br.upe.desafio_picpay.infra.enums;

import jakarta.persistence.Enumerated;

public enum UserTypeEnum {

    SHOPKEEPER("Shopkeeper"),
    COMMON("Common");

    private final String userType;

    UserTypeEnum(String userType) {
        this.userType = userType;
    }

    public String getTipoUsuario(){
        return userType;
    }
}
