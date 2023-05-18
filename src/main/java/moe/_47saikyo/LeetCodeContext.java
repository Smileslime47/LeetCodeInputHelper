package moe._47saikyo;

import moe._47saikyo.annotations.LeetCodeData;
import moe._47saikyo.annotations.LeetCodeDatas;
import moe._47saikyo.annotations.LeetCodeExample;
import moe._47saikyo.annotations.LeetCodeExamples;
import moe._47saikyo.data_structure.ListNode;
import moe._47saikyo.data_structure.TreeNode;

import java.util.*;

public class LeetCodeContext {
    private final Class<?> superClass;

    public LeetCodeContext(Class<?> cls) {
        superClass = cls;
    }

    /**
     * Retrieves a specific LeetCodeData instance based on a given index.
     * <p>
     * This method first attempts to get a LeetCodeData annotation from the superClass.
     * If no such annotation is found, it tries to get a LeetCodeDatas annotation from the superClass.
     * <p>
     * If neither a LeetCodeData nor a LeetCodeDatas annotation can be found, the method throws an IllegalArgumentException,
     * indicating that no data could be found.
     * <p>
     * If a LeetCodeData annotation is found, it is returned immediately.
     * <p>
     * If a LeetCodeDatas annotation is found, the method checks to see if its value (an array of LeetCodeData)
     * is non-null and has a length greater than the provided index. If not, it throws an IllegalArgumentException,
     * indicating that the index is out of bounds.
     * <p>
     * If the LeetCodeDatas annotation's value is non-null and has a length greater than the index,
     * the method returns the LeetCodeData at the specified index.
     *
     * @param index The index of the LeetCodeData to retrieve.
     * @return The LeetCodeData at the specified index.
     * @throws IllegalArgumentException If no data could be found or if the index is out of bounds.
     */
    private String  getData(int index) {
        LeetCodeDatas arrs = superClass.getAnnotation(LeetCodeDatas.class);
        LeetCodeData arr = superClass.getAnnotation(LeetCodeData.class);


        if (arr == null && arrs == null) {
            throw new IllegalArgumentException("no data");
        }

        if (arr != null) {
            return arr.value();
        }

        if (arrs.value() == null || arrs.value().length <= index) {
            throw new IllegalArgumentException("index larger than the number of data");
        }
        return arrs.value()[index].value();
    }
    private String getData(int expIndex,int index) {
        LeetCodeExamples exps = superClass.getAnnotation(LeetCodeExamples.class);
        LeetCodeExample exp = superClass.getAnnotation(LeetCodeExample.class);
        String originData;

        if (exp == null && exps == null) {
            throw new IllegalArgumentException("no data");
        }

        if (exp != null) {
            originData=exp.value();
            return StringParser.delimit_Example(originData).get(index);
        }

        if (exps.value() == null || exps.value().length <= expIndex) {
            throw new IllegalArgumentException("index larger than the number of data");
        }
        originData=exps.value()[expIndex].value();
        return StringParser.delimit_Example(originData).get(index);
    }

    public int getInt(int expIndex,int index) throws Exception {return getInt(getData(expIndex,index));}
    public int getInt(int index) throws Exception {return getInt(getData(index));}
    private int getInt(String data) throws Exception {
        List<String> list = StringParser.delimit(data);
        Object[] objs = StringParser.getArray(list);
        return (int) objs[0];
    }

    public int[] getIntArray(int expIndex,int index) throws Exception {return getIntArray(getData(expIndex,index));}
    public int[] getIntArray(int index) throws Exception {return getIntArray(getData(index));}
    private int[] getIntArray(String data) throws Exception {
        if(Objects.equals(data,""))return new int[0];
        List<String> list = StringParser.delimit(data);

        int[] ret = new int[list.size()];
        Object[] objs = StringParser.getArray(list);
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (int) objs[i];
        }
        return ret;
    }

    public int[][] getIntArrays(int expIndex,int index) throws Exception {return getIntArrays(getData(expIndex,index));}
    public int[][] getIntArrays(int index) throws Exception {return getIntArrays(getData(index));}
    private int[][] getIntArrays(String data) throws Exception {
        if(Objects.equals(data,""))return new int[0][];
        List<String> list = StringParser.delimit(data);

        int[][] ret = new int[list.size()][];
        Object[][] objs = StringParser.getArrays(list);
        for (int i = 0; i < list.size(); i++) {
            ret[i] = new int[objs[i].length];
            for (int j = 0; j < objs[i].length; j++) {
                ret[i][j] = (int) objs[i][j];
            }
        }
        return ret;
    }

    public char getChar(int expIndex,int index) throws Exception {return getChar(getData(expIndex,index));}
    public char getChar(int index) throws Exception {return getChar(getData(index));}
    private char getChar(String data) throws Exception {
        List<String> list = StringParser.delimit(data);
        Object[] objs = StringParser.getArray(list);
        return (char) objs[0];
    }

    public char[] getCharArray(int expIndex,int index) throws Exception {return getCharArray(getData(expIndex,index));}
    public char[] getCharArray(int index) throws Exception {return getCharArray(getData(index));}
    private char[] getCharArray(String data) throws Exception {
        if(Objects.equals(data,""))return new char[0];
        List<String> list = StringParser.delimit(data);

        char[] ret = new char[list.size()];
        Object[] objs = StringParser.getArray(list);
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (char) objs[i];
        }
        return ret;
    }


    public char[][] getCharArrays(int expIndex,int index) throws Exception {return getCharArrays(getData(expIndex,index));}
    public char[][] getCharArrays(int index) throws Exception {return getCharArrays(getData(index));}
    private char[][] getCharArrays(String data) throws Exception {
        if(Objects.equals(data,""))return new char[0][];
        List<String> list = StringParser.delimit(data);

        char[][] ret = new char[list.size()][];
        Object[][] objs = StringParser.getArrays(list);
        for (int i = 0; i < list.size(); i++) {
            ret[i] = new char[objs[i].length];
            for (int j = 0; j < objs[i].length; j++) {
                ret[i][j] = (char) objs[i][j];
            }
        }
        return ret;
    }

    public String getString(int expIndex,int index) throws Exception {return getString(getData(expIndex,index));}
    public String getString(int index) throws Exception {return getString(getData(index));}
    private String getString(String data) throws Exception {
        if(Objects.equals(data,""))return "";
        List<String> list = StringParser.delimit(data);

        Object[] objs = StringParser.getArray(list);
        String ret = (String) objs[0];
        return ret;
    }

    public String[] getStringArray(int expIndex,int index) throws Exception {return getStringArray(getData(expIndex,index));}
    public String[] getStringArray(int index) throws Exception {return getStringArray(getData(index));}
    private String[] getStringArray(String data) throws Exception {
        if(Objects.equals(data,""))return new String[0];
        List<String> list = StringParser.delimit(data);

        String[] ret = new String[list.size()];
        Object[] objs = StringParser.getArray(list);
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (String) objs[i];
        }
        return ret;
    }

    public List<Integer> getIntList(int expIndex,int index) throws Exception {
        int[] arr = getIntArray(expIndex,index);
        List<Integer> ret = new ArrayList<>();
        for (int i : arr) ret.add(i);
        return ret;
    }
    public List<Integer> getIntList(int index) throws Exception {
        int[] arr = getIntArray(index);
        List<Integer> ret = new ArrayList<>();
        for (int i : arr) ret.add(i);
        return ret;
    }

    public TreeNode getBinaryTree(int expIndex,int index) throws Exception {return getBinaryTree(getData(expIndex,index));}
    public TreeNode getBinaryTree(int index) throws Exception {return getBinaryTree(getData(index));}
    private TreeNode getBinaryTree(String data) throws Exception {
        if(Objects.equals(data,""))return null;
        List<String> list = StringParser.delimit(data);
        Object[] objs = StringParser.getArray(list);

        TreeNode root = new TreeNode((int) objs[0]), node;
        Queue<TreeNode> build = new LinkedList<>();
        build.add(root);
        int i = 1;
        while (i < objs.length) {
            node = build.remove();
            if (objs[i] == null) {
                node.left = null;
            } else {
                node.left = new TreeNode((int) objs[i]);
                build.add(node.left);
            }
            i++;
            if (objs[i] == null) {
                node.right = null;
            } else {
                node.right = new TreeNode((int) objs[i]);
                build.add(node.right);
            }
            i++;
        }
        return root;
    }

    public ListNode getListNode(int expIndex,int index) throws Exception {return getListNode(getData(expIndex,index));}
    public ListNode getListNode(int index) throws Exception {return getListNode(getData(index));}
    private ListNode getListNode(String data) throws Exception {
        if(Objects.equals(data, ""))return null;
        List<String> list = StringParser.delimit(data);
        Object[] objs = StringParser.getArray(list);
        ListNode head=new ListNode((int)objs[0]);
        ListNode tail=head;
        int i=1;
        while (i<objs.length){
            tail.next=new ListNode((int)objs[i]);
            i++;
            tail=tail.next;
        }
        return head;
    }
}