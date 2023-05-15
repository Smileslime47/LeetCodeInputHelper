import moe._47saikyo.LeetCodeContext;
import moe._47saikyo.annotations.LeetCodeData;
import moe._47saikyo.data_structure.ListNode;
import moe._47saikyo.data_structure.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@LeetCodeData(value = "[1,null,0,0,1]", index = 0)
@LeetCodeData(value = "1,2,3", index = 1)
@LeetCodeData(value = "[[1,2,3],[1,2],[3]]", index = 2)
@LeetCodeData(value = "['A','B','C','D']", index = 3)
@LeetCodeData(value = "[['A','B','C'],['B','C'],['C']]", index = 4)
@LeetCodeData(value = "abcdefg", index = 5)
@LeetCodeData(value = "[\"tars\",\"rats\",\"arts\",\"star\"]", index = 6)
@LeetCodeData(value = "", index = 7)
public class LeetCodeContextTest {
    LeetCodeContext lcc;

    @Before
    public void init() {
        lcc = new LeetCodeContext(LeetCodeContextTest.class);
    }

    @Test
    public void IntArrTest() throws Exception {
        int[] expected = {1, 2, 3};
        int[] actual = lcc.getIntArray(1);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void IntArrsTest() throws Exception {
        int[][] expected = {{1, 2, 3}, {1, 2}, {3}};
        int[][] actual = lcc.getIntArrays(2);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void CharArrTest() throws Exception {
        char[] expected = {'A', 'B', 'C', 'D'};
        char[] actual = lcc.getCharArray(3);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void CharArrsTest() throws Exception {
        char[][] expected = {{'A', 'B', 'C'}, {'B', 'C'}, {'C'}};
        char[][] actual = lcc.getCharArrays(4);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void StringTest() throws Exception {
        String expected = "abcdefg";
        String actual = lcc.getString(5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void StringArrTest() throws Exception {
        String[] expected = {"tars", "rats", "arts", "star"};
        String[] actual = lcc.getStringArray(6);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void ListNodeTest() throws Exception {
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);

        ListNode actual = lcc.getListNode(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void EmptyTest() throws Exception {
        Assert.assertEquals("", lcc.getString(7));
    }

    @Test
    public void BinaryTreeTest() throws Exception {
        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(1);
        expected.right.left = new TreeNode(0);
        expected.right.right = new TreeNode(1);
        TreeNode actual = lcc.getBinaryTree(0);
    }
}