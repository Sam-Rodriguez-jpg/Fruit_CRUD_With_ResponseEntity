package com.fruitsSpringMvcAndResponseEntity.Module6_Week2_Activity1.models;

public class FruitModel {
    private String idFruit;
    private String nameFruit;
    private String colorFruit;
    private String priceFruit;

    // Id Auto-Increment
    private static int idFruitAutoIncrement = 1;

    // Constructors


    public FruitModel() {}

    public FruitModel(String nameFruit, String colorFruit, String priceFruit) {
        this.idFruit = String.valueOf(idFruitAutoIncrement++);
        this.nameFruit = nameFruit;
        this.colorFruit = colorFruit;
        this.priceFruit = priceFruit;
    }

    // Getters And Setters
    public String getIdFruit() {
        return idFruit;
    }

    public void setIdFruit(String idFruit) {
        this.idFruit = idFruit;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public void setNameFruit(String nameFruit) {
        this.nameFruit = nameFruit;
    }

    public String getColorFruit() {
        return colorFruit;
    }

    public void setColorFruit(String colorFruit) {
        this.colorFruit = colorFruit;
    }

    public String getPriceFruit() {
        return priceFruit;
    }

    public void setPriceFruit(String priceFruit) {
        this.priceFruit = priceFruit;
    }

    // To String
    @Override
    public String toString() {
        return "Información de la fruta: " +
                "ID: #" + idFruit + " - " +
                "Nombre: " + nameFruit + " - " +
                "Color: " + colorFruit + " - " +
                "Precio: $" + priceFruit;
    }
}
