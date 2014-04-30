package edu.berkeley.ischool.aep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// understands its children
public class Node {

    public List<Link> children = new ArrayList<Link>();
    public List<Integer> cost = new ArrayList<Integer>();
    static int NO_PATH = Integer.MAX_VALUE;

    public void addChild(Link child) {
        children.add(child);
    }

    public boolean canReach(Node node) {
        return distanceTo(node, new HashSet<Node>(),new  Link.hopStrategy()) != NO_PATH;
    }


//    public int hopsTo(Node to) {
//        int hops = hopsTo(to, new HashSet<Node>());
//        if (hops == NO_PATH) throw new UnreachableException();
//        return hops;
//    }

//    int hopsTo(Node node, Set<Node> visited) {
//        if (!visited.add(this)) return NO_PATH;
//        if (node.equals(this)) return 0;
//        int minChildHops = NO_PATH;
//        for (Link child : children) {
//            int childHops = child.hopsTo(node, new HashSet<edu.berkeley.ischool.aep.Node>(visited));
//            if (childHops < minChildHops) {
//                minChildHops =  childHops;
//            }
//        }
//        return minChildHops;
//    }

//    public int costTo(Node to) {
//        int hops = costTo(to, new HashSet<Node>());
//        if (hops == NO_PATH) throw new UnreachableException();
//        return hops;
//    }

//    int costTo(Node node, Set<Node> visited) {
//        if (!visited.add(this)) return NO_PATH;
//        if (node.equals(this)) return 0;
//        int minChildCost = NO_PATH;
//        for (Link child : children) {
//            int childCost = child.costTo(node, new HashSet<edu.berkeley.ischool.aep.Node>(visited));
//            if (childCost < minChildCost) {
//                minChildCost =  childCost;
//            }
//        }
//        return minChildCost;
//    }


    public int hopsTo(Node to) {
        int hops = distanceTo(to, new HashSet<Node>(),new Link.hopStrategy());
        if (hops == NO_PATH) throw new UnreachableException();
        return hops;
    }

    public int costTo(Node to) {
        int hops = distanceTo(to, new HashSet<Node>(),new Link.costStrategy());
        if (hops == NO_PATH) throw new UnreachableException();
        return hops;
    }

    int distanceTo(Node node, Set<Node> visited, Strategy distance){
        if (!visited.add(this)) return NO_PATH;
        if (node.equals(this)) return 0;
        int minChildCost = NO_PATH;
        for (Link child : children) {
            int childCost = child.distanceTo(node, new HashSet<edu.berkeley.ischool.aep.Node>(visited),distance);
            if (childCost < minChildCost) {
                minChildCost =  childCost;
            }
        }
        return minChildCost;

    }

}