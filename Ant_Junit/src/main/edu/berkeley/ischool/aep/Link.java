package edu.berkeley.ischool.aep;

import java.util.Set;

/**
 * Created by chrisfan on 4/25/14.
 */
public class Link {
    private Node to;
    private int cost;
    public Link(Node b, int i) {
        to = b;
        cost = i;
    }

    public static class costStrategy implements Strategy {
        @Override
        public int calculate(Link link, int total) {
            return link.cost + total;
        }
    }

    public static class hopStrategy implements Strategy{
        @Override
        public int calculate(Link link, int total) {
            return 1 + total;
        }
    }

//    public int hopsTo(Node node, Set<Node> visited){
//        int hops = to.hopsTo(node,visited);
//
//        return hops == Node.NO_PATH ? Node.NO_PATH : 1 + hops;
//    }
//
//    public int costTo(Node node, Set<Node> visited){
//        int total = to.costTo(node, visited);
//        return total == Node.NO_PATH ? Node.NO_PATH  :  cost + total;
//
//    }

    public int distanceTo(Node node, Set<Node> visited, Strategy strat){
        int total = to.distanceTo(node, visited, strat);
        return total == Node.NO_PATH ? Node.NO_PATH  :  strat.calculate(this,total);
    }

}
