import unittest

from dna_counter import DNACounter

def createDNAStats(seq):
  return DNACounter(seq)

class DNAStatsTest(unittest.TestCase):

  String seq1 = "CTAG"
  String seq2 = "GGGCCC"
  String seq3 = "GTGGGGGTGATGTCCACGATTACGCCGACCGGCTGG"
  DNAStats stats1 = createDNAStats(seq1)
  DNAStats stats2 = createDNAStats(seq2)
  DNAStats stats3 = createDNAStats(seq3)

  def setUp(self):
    """Call before every test case."""
    pass
  
  def tearDown(self):
    """Call after every test case."""
    pass
 
  def testGCFraction(self):
    """Test that the correct fraction of GC base pairs is returned."""
    assert ((stats1.getGCFraction() - 0.25 ) < 0.001