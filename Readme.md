# LeetCodeInputHelper
 [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
## 概述
将力扣[...]格式的输入样例直接转换成可用的数据结构！

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
在测试类前加上@LeetCodeData注解，该注解包含1个参数
- value：数据内容，支持`[...]`的字符串格式，此外最外层的中括号也可以去除，如`@LeetCodeData(value = "1,2,3")
`

此外你也可以用@LeetCodeExample样例输入一整串样例，如
```java
@LeetCodeExample("s=[7,8,9],b=\"abcdefg\",c=[['A','B','C'],['B','C'],['C']],d=[1,null,0,0,1]")
```

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

对于所有get方法都有解析Example的版本：
- `T getT(int expIndex,int index)`：解析指定Example注解的第i项数据，同样从0开始

```java
@LeetCodeExample("s=[7,8,9],b=\"abcdefg\",c=[['A','B','C'],['B','C'],['C']],d=[1,null,0,0,1]")
public class Main{
    public static void main(String[] args){
        LeetCodeContext lcc=new LeetCodeContext(Main.class);
        TreeNode root=lcc.getBinaryTree(0,3);
    }
}
```

当同时包含多个Data注解或者Example注解时，index按照代码顺序分配，从0开始，且二者彼此独立如：
```java
@LeetCodeData("[1,null,0,0,1]")//index 0
@LeetCodeData("[1,2,3]")//index 1
...
@LeetCodeExample("s=[1,2,3],b=[4,5,6]")//expIndex 0
@LeetCodeExample("s=[7,8,9],b=\"abcdefg\",c=[['A','B','C'],['B','C'],['C']]")//Index 1
```

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

