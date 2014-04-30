package edu.berkeley.ischool.aep;

import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by chrisfan on 4/11/14.
 */
public class NodeTest {

    Node h = new Node();
    Node b = new Node();
    Node c = new Node();
    Node d = new Node();
    Node e = new Node();
    Node a = new Node();
    Node f = new Node();
    Node g = new Node();
    public NodeTest() {
        h.addChild(new Link(b,4));
        b.addChild(new Link(c,3));
        b.addChild(new Link(a,1));
        a.addChild(new Link(f, 4));
        c.addChild(new Link(d, 4));
        c.addChild(new Link(e, 1));
        c.addChild(new Link(e, 3));
        d.addChild(new Link(e, 6));
        e.addChild(new Link(b, 2));
    }
    @Test
    public void nodeShouldReachSelf () {
        Node node = new Node();
        assertTrue(node.canReach(node));
    }

    @Test
    public void nodeShouldBeAbleToReachChild () {
        assertTrue(h.canReach(b));
    }

    @Test
    public void nodeShouldNotBeAbleToReachUnreachableNode() {
        assertFalse(b.canReach(g));
    }

    @Test
    public void nodeShouldBeAbleToReachFurthestNode() {
        assertTrue(h.canReach(e));
    }

    @Test
    public void nodeHShouldBeAbleToReachNodeF() {
        assertTrue(h.canReach(f));
    }

    @Test
    public void hToCShouldBeTwoHops() {
        Assert.assertEquals(2, h.hopsTo(c));
    }

    @Test
    public void bToEShouldBeTwoHops() {
        Assert.assertEquals(2, b.hopsTo(e));
    }

    @Test
    public void bToFShouldBeTwoHops() {
        Assert.assertEquals(2, b.hopsTo(f));
    }

    @Test (expected = UnreachableException.class)
    public void tryingToReachUnreacableNodeShouldThrowExcpetion(){
        Assert.assertEquals(2, b.hopsTo(g));
    }

    @Test
    public void hToBShoudlCost4(){
        Assert.assertEquals(4, h.costTo(b));
    }

    @Test
    public void hTocShoudlCost7(){
        Assert.assertEquals(7, h.costTo(c));
    }

    @Test
    public void htodShouldCost11(){
        Assert.assertEquals(11, h.costTo(d));
    }

    @Test
    public void htoEShouldCost8(){
        Assert.assertEquals(8,h.costTo(e));
    }
}
