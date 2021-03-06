package com.semicolon.ds.core;


import com.semicolon.ds.Constants;

import java.util.ArrayList;


public class RoutingTable {
    private ArrayList<Neighbour> neighbours;

    public RoutingTable() {
        this.neighbours = new ArrayList<>();
    }

    public int addNeighbour(String address, int port) {
        for (Neighbour n: neighbours) {
            if (n.eaquals(address, port)){
                return 0;
            }
        }
        if (neighbours.size() >= Constants.MAX_NEIGHBOURS) {
            return 0;
        }
        neighbours.add(new Neighbour(address, port));
        return neighbours.size();
    }

    public int removeNeighbout(String address, int port) {
        Neighbour toRemove = null;
        for (Neighbour n:
             neighbours) {
            if (n.eaquals(address, port)) {
                toRemove = n;
            }
        }
        if (toRemove != null) {
            neighbours.remove(toRemove);
            return neighbours.size();
        }
        return 0;
    }
    public int getCount() {
        return neighbours.size();
    }

    public void print() {
        System.out.println("Total neighbours: " + neighbours.size());
        System.out.println("++++++++++++++++++++++++++");
        for (Neighbour n :neighbours) {
            System.out.println(
                    "Address: " + n.getAddress()
                    + " Port: " + n.getPort()
                    + "Pings: " + n.getPingPongs()
            );
        }
    }
    public ArrayList toList() {
        ArrayList<String> list = new ArrayList<>();
        for (Neighbour n: neighbours) {
            list.add(n.toString());
        }
        return list;
    }

}
