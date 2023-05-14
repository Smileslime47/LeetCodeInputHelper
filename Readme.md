# LeetCodeInputHelper
 [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
## 概述
一个将力扣[...]格式的输入样例直接转换成可用的数据结构！

样例：
```java
@LeetCodeData(value = "[1,null,0,0,1]", index = 0)
public class Main{
    public static void main(String[] args){
        LeetCodeContext lcc=new LeetCodeContext(Main.class);
        TreeNode root=lcc.getBinaryTree(0);
    }
}
```

## 使用方法
在测试类前加上@LeetCodeData注解，该注解包含两个参数
- value：数据内容，支持`[...]`的字符串格式，此外最外层的中括号也可以去除，如`@LeetCodeData(value = "1,2,3")
`
- index：在输入多组数据时，通过index区分不同数据，不输入默认为0

在main函数中创建`LeetCodeContext`类，并在构造参数中输入所在类的Class对象，如：
```java
LeetCodeContext lcc=new LeetCodeContext(Main.class);
```

LeetCodeContext支持的方法：
- `int[] getIntArray(int index)`：按照一维int数组解析指定index的注解
- `List<Integer> getIntList(int index)`：按照一维int数组解析指定index的注解，并返回一个对应的ArrayList
- `int[][] getIntArrays(int index)`：按照二维int数组解析指定index的注解
- `char[] getCharArray(int index)`：按照一维char数组解析指定index的注解
- `char[][] getCharArrays(int index)`：按照二维char数组解析指定index的注解
- `String getString(int index)`：按照字符串解析指定index的注解
- `String[] getStringArray(int index)`：按照字符串数组解析指定index的注解
- `TreeNode getBinaryTree(int index)`：按照LeetCode常用的TreeNode类解析指定index的注解，并返回一个二叉树的根节点
- `ListNode getListNode(int index)`：按照LeetCode常用的ListNode类解析指定index的注解，并返回一个链表的根节点


## 支持格式
### 一维数组
```java
@LeetCodeData(value = "[1,2,3]", index = 1)
@LeetCodeData(value = "['A','B','C','D']", index = 3)
```

### 二维数组
```java
@LeetCodeData(value = "[[1,2,3],[1,2],[3]]", index = 2)
@LeetCodeData(value = "[['A','B','C'],['B','C'],['C']]", index = 4)
```

### 字符串
```java
@LeetCodeData(value = "abcdefg", index = 5)
```

### 字符串数组 
```java
@LeetCodeData(value = "[\"tars\",\"rats\",\"arts\",\"star\"]", index = 6)
```

### LeetCode提供的二叉树和链表等
```java
@LeetCodeData(value = "[1,null,0,0,1]", index = 0)
```

