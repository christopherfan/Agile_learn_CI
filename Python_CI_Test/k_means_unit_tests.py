###
# Implement simple k-means clustering using 1 dimensional data
# trying to change and push changes    ...
#
##/

import unittest 
from random import sample
from k_means import *

class clusterUnitTests(unittest.TestCase):
    # Test Distance Function
    def test_shouldBe0Distance1and1(self):
        self.assertEqual(0, distance(1,1))
    def test_shouldBe4Distane2andMinus2(self):
        self.assertEqual(4,distance(2,-2))
        self.assertEqual(4,distance(-2,2))
        
    # Test Centroid (mean) of list of numbers
    def test_shouldBeNaNCentroidEmptyList(self):
        self.assertRaises(ValueError, centroid,[])
        
    def test_shouldBe5CentroidList1_2_3_4_5_6_7_8_9_10(self):
        x = [1,2,3,4,5,6,7,8,9,10]
        self.assertEqual(5.5, centroid(x))
    def test_shouldBe0CentroidList(self):
        self.assertEqual(0,centroid([-2,0,2,-10,10]))
        
    # Test Initial Centroid
    def test_pickCentroidRandomNonRepeatSample(self):
        x = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
        centroids = pick_centroids(x, 3)
        for centroid in centroids:
            self.assertTrue(centroid in x)
    # Test assign to Cluster
    def test_assignCluster1(self):
        centroids = [-10,0,10]
        numbers = [-11,-12,-13,-1,2,3,11,24,19]
        expectedCluster = [[-11,-12,-13], [-1,2,3] , [11,24,19]] 
        
        clusters = cluster(numbers, centroids)
        # print clusters
        for index, eachCluster in enumerate(clusters):
            for sampleNumber in eachCluster:
                self.assertTrue(sampleNumber in expectedCluster[index])
    def test_assignCluster1(self):
        centroids = [-10,0,10]
        numbers = [-11,-12,-13,-1,2,3,11,24,19]
        expectedCluster = [[-11,-12,-13], [-1,2,3] , [11,24,19]] 
        
        clusters = cluster(numbers, centroids)
        # print clusters
        for index, eachCluster in enumerate(clusters):
            for sampleNumber in eachCluster:
                self.assertTrue(sampleNumber in expectedCluster[index])                

    #Test Iterative Cluster
    def test_SampleCluster(self):
        dataset = [-11,-12,-13,-1,2,3,11,24,19]
        k = 3
        initial_centroids = pick_centroids(dataset, k)
        final_centroids, final_clusters = iterate_centroids(dataset, initial_centroids)
        print "\nCalculating Cluster for: " , dataset
        for centroid, cluster in zip(final_centroids, final_clusters):
            print "Centroid: %s" % centroid
            print "Cluster contents: %r" % cluster    

    def test_SampleCluster2(self):
        dataset = [1,2,3,8,9,10,25]
        k = 2
        initial_centroids = pick_centroids(dataset, k)
        final_centroids, final_clusters = iterate_centroids(dataset, initial_centroids)
        print "\nCalculating Cluster for: " , dataset
        for centroid, cluster in zip(final_centroids, final_clusters):
            print "Centroid: %s" % centroid
            print "Cluster contents: %r" % cluster    
    # Test Cluster Variation
    def test_shouldBe196ClusterVariation(self):
        clusters = [[1,2,3], [8,9,10,25]]
        means = [2,13]
        self.assertEqual(196, clusterVariation(means, clusters))

    def test_shouldBe196ClusterVariation(self):
        clusters = [[1,2,3,8], [9,10,25]]
        means = [3.5,14.67]
        self.assertTrue(.01> abs(189.67 - clusterVariation(means, clusters)))
        
if __name__ == '__main__':
  unittest.main()
  # main()        
        