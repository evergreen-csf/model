import unittest

def createDNAStats(seq):
  return DNACounter(seq)

class DNAStatsTest(unittest.TestCase):

  seq1 = "CTAG"
  seq2 = "GGGCCC"
  seq3 = "GTGGGGGTGATGTCCACGATTACGCCGACCGGCTGG"
  stats1 = createDNAStats(seq1)
  stats2 = createDNAStats(seq2)
  stats3 = createDNAStats(seq3)

  def setUp(self):
    """Call before every test case."""
    pass

  def tearDown(self):
    """Call after every test case."""
    pass

  def testGCFraction(self):
    """Test that the correct fraction of GC base pairs is returned."""
    assert (abs(self.stats1.getGCFraction() - 0.25 ) < 0.001)

if __name__ == "__main__":
    unittest.main() # run all tests
