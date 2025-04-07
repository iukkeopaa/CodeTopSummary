## 给定一个奇数位升序，偶数位降序的链表，将其重新排序。

```text
输入: 1->8->3->6->5->4->7->2->NULL
输出: 1->2->3->4->5->6->7->8->NULL
```

CodeLink[ReorderLinkedList](src/main/java/org/wqz/Code/ReorderLinkedList.java)


## 现有n个编译项，编号为0 ~ n-1。给定一个二维数组，表示编译项之间有依赖关系。如[0, 1]表示1依赖于0。若存在循环依赖则返回空；不存在依赖则返回可行的编译顺序。

CodeLink1[CompilationOrder](src/main/java/org/wqz/Code/CompilationOrder.java)
CodeLink2[TopologicalSort](src/main/java/org/wqz/Code/TopologicalSort.java)


## 36进制由0-9，a-z，共36个字符表示。 要求按照加法规则计算出任意两个36进制正整数的和，如1b + 2x = 48  （解释：47+105=152） 要求：不允许使用先将36进制数字整体转为10进制，相加后再转回为36进制的做法

CodeLink1[Base36Addition](src/main/java/org/wqz/Code/Base36Addition.java)


## 给定长度为n的数组，每个元素代表一个木头的长度，木头可以任意截断，从这堆木头中截出至少k个相同长度为m的木块。已知k，求max(m)。输入两行，第一行n, k，第二行为数组序列。输出最大值。

CodeLink[WoodCutting](src/main/java/org/wqz/Code/WoodCutting.java)


## 给定一个数组，要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：区间中的最小数 * 区间所有数的和。数组中的元素都是非负数。输入两行，第一行n表示数组长度，第二行为数组序列。输出最大值

CodeLink[MaxProductInterval](src/main/java/org/wqz/Code/MaxProductInterval.java)
CodeLink[MaxProductInterval2](src/main/java/org/wqz/Code/MaxProductInterval2.java)

## 立方根

CodeLink[CubeRootManual](src/main/java/org/wqz/Code/CubeRootManual.java)


## 阿拉伯数字转为中文

CodeLink[ArabicToChinese](src/main/java/org/wqz/Code/ArabicToChinese.java)


CodeLink2[ArabicToChinese](src/main/java/org/wqz/Code/ArabicToChinese2.java)

## 将ip地址转换成10进制整数。例如，ip地址为10.0.3.193，把每段拆分成一个二进制形式组合起来为00001010 00000000 00000011 11000001，然后把这个二进制数转变成十进制整数就是167773121

CodeLink[IpToDecimal](src/main/java/org/wqz/Code/IpToDecimal.java)
CodeLink[IpToDecimal2](src/main/java/org/wqz/Code/IpToDecimal2.java)

## 给定三角形3个点的坐标，在给定一个点(x,y)，判断该点是否在三角形中。ps:坐标值均为double型

CodeLink[PointInTriangle](src/main/java/org/wqz/Code/PointInTriangle.java)
CodeLink[PointInTriangleByArea](src/main/java/org/wqz/Code/PointInTriangleByArea.java)

## 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的差 

注意：

num1 和num2 都只会包含数字 0-9
num1 和num2 都不包含任何前导零
你不能使用任何內建 BigInteger 库


CodeLink[StringSubtraction](src/main/java/org/wqz/Code/StringSubtraction.java)