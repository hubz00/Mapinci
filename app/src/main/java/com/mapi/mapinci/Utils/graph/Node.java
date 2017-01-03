package com.mapi.mapinci.Utils.graph;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Comparator;

public class Node implements Comparable<Node>{

    private long id;
    private Double longitude;
    private Double latitude;

    protected Node (long id){
        this.id = id;
    }

    protected Node() {}

    public Node(Long id, Double longitude, Double latitude){
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public long getId() {
        return id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    @Override
    public int compareTo(Node n) {
        if(id == n.getId())
            return 0;
        else
            return id > n.getId() ? 1 : -1;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        try {
            json.put("id", id);
            json.put("longitude", longitude);
            json.put("latitude", latitude);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;

    }

    public void changeCoordinatesToProper(Double height) {
        this.latitude = height - this.latitude;
    }
}
