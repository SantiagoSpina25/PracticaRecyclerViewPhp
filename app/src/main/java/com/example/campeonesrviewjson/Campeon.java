package com.example.campeonesrviewjson;

public class Campeon {

    private int id;
    private String nombreCampeon;
    private int imagenCampeon;
    private int fechaMundial;

    public Campeon(int id, String nombreCampeon, int fechaMundial){
        this.nombreCampeon = nombreCampeon;
        this.imagenCampeon = imagenCampeon;
        this.fechaMundial = fechaMundial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCampeon() {
        return nombreCampeon;
    }

    public void setNombreCampeon(String nombreCampeon) {
        this.nombreCampeon = nombreCampeon;
    }

//    public int getImagenCampeon() {
//        return imagenCampeon;
//    }
//
//    public void setImagenCampeon(int imagenCampeon) {
//        this.imagenCampeon = imagenCampeon;
//    }

    public int getFechaMundial() {
        return fechaMundial;
    }

    public void setFechaMundial(int fechaMundial) {
        this.fechaMundial = fechaMundial;
    }
}
