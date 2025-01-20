package com.example.proyecto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DogFact {
    @SerializedName("data")
    private List<DataItem> data;

    public List<DataItem> getData() {
        return data;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    // Clase interna que representa el objeto dentro de "data"
    public static class DataItem {
        @SerializedName("id")
        private String id;

        @SerializedName("type")
        private String type;

        @SerializedName("attributes")
        private Attributes attributes;

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }
    }

    // Clase interna para el objeto "attributes"
    public static class Attributes {
        @SerializedName("body")
        private String body;

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }
}
