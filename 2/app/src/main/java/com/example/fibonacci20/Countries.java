package com.example.fibonacci20;

import org.json.JSONObject;

class Countries extends JSONObject {

    public String capital;
    public String name;
    public String internationalName;
    public String sigla;

    public Countries(String capital, String name, String internationalName, String sigla) {
        this.capital = capital;
        this.name = name;
        this.internationalName = internationalName;
        this.sigla = sigla;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternationalName() {
        return internationalName;
    }

    public void setInternationalName(String internationalName) {
        this.internationalName = internationalName;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }


}
