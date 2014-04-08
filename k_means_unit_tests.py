###
# Implement simple k-means clustering using 1 dimensional data
# trying to change and push changes....
#
##/

import unittest 
from random import sample
from k_means import *

# ###
# # Helper functions
# # Fill in TODOs where needed
# ##/

# def pick_centroids(xs, num):
    # """Return list of num centroids given a list of numbers in xs"""
    # ###
    # # TODO select and return centroids    
    # return sample(xs, num)
    # # return [1, 2]
    # ##/


# def distance(a, b):
    # """Return the distance of numbers a and b"""
    # ###
    # # TODO return correct expression
    # return abs(a-b)
    # ##/

    
# def centroid(xs):
    # """Return the centroid number given a list of numbers, xs"""
    # ###
    # # TODO calculate and return centroid
    # if len(xs) ==0:        
        # raise ValueError("Empty List")
    # return sum(xs)/float(len(xs))
    # ##/


# def cluster(xs, centroids):
    # """Return a list of clusters centered around the given centroids.  Clusters
    # are lists of numbers."""

    # clusters = [[] for c in centroids]

    # for x in xs:
        # # find the closest cluster to x
        # dist, cluster_id = min(
            # (distance(x, c), cluster_id) for cluster_id, c in enumerate(centroids)
        # )
        # # place x in cluster
        # clusters[cluster_id].append(x)

    # return clusters


# def iterate_centroids(xs, centroids):
    # """Return stable centroids given a dataset and initial centroids"""

    # err = 0.001  # minimum amount of allowed centroid movement
    # observed_error = 1  # Initialize: maxiumum amount of centroid movement
    # new_clusters = [[] for c in centroids]  # Initialize: clusters

    # while observed_error > err:
        # new_clusters = cluster(xs, centroids)
        # new_centroids = map(centroid, new_clusters)

        # observed_error = max(abs(new - old) for new, old in zip(new_centroids, centroids))
        # centroids = new_centroids

    # return (centroids, new_clusters)

# def clusterVariation(centroids, clusters):
    # variation = 0
    # set =  zip(clusters, centroids)
    # for numbers,mean in set:
        # for number in numbers:
            # variation += (number - mean)**2
    
    # return variation
    
# ###
# # Main part of program:
# # Pick initial centroids
# # Iterative to find final centroids
# # Print results
# ##/
def main ():

    dataset = [
        -13.65089255716321, -0.5409562932238607, -88.4726466247223,
        39.30158828358612, 4.066458182574449, 64.64143300482378,
        38.68269424751338, 33.42013676314311, 31.18603331719732,
        -0.2027616409406292, 45.13590038987272, 30.791899783552395,
        61.1727490302448, 18.167220741624856, 88.88077709786394,
        -1.3808002119514704, 50.14991362212521, 55.92029956281276,
        -6.759813255299466, 34.28290084421072
    ]

    k = 2  # number of clusters
    cluster_attempts = []
    for tries in xrange(9):
        initial_centroids = pick_centroids(dataset, k)
        final_centroids, final_clusters = iterate_centroids(dataset, initial_centroids)
        variation = clusterVariation(final_centroids, final_clusters)
        # for centroid, cluster in zip(final_centroids, final_clusters):
            # print "Centroid: %s" % centroid
            # print "Cluster contents: %r" % cluster
        # print "Cluster Variation: %f\n" % variation
        cluster_attempts.append((variation, (final_centroids,final_clusters)))
        
    print ">>>>>>>>>>>>>>>>>>>>Cluster with lowest variation after 5 attempts: " 
    min_cluster = min(cluster_attempts)
    # print zip(min_cluster[1][0], min_cluster[1][1])
    for centroid, cluster in zip(min_cluster[1][0],min_cluster[1][1]):
        print "Centroid: %f" % centroid
        print "Cluster contents: %r" % cluster
    print "\nCluster Variation: %f" % min_cluster[0]
        
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
        