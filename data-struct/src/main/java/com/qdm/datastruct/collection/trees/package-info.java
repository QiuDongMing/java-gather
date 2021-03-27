/**
 * @author qiudm
 * @date 2019/1/14 15:39
 * @desc
 */
package com.qdm.datastruct.collection.trees;
/**
 *一、BST树（二叉搜索树、二叉查找树、二叉排序树）
 * 定义：
 * 1.所有非叶子结点至多拥有两个儿子（Left和Right）；
 * 2.所有结点存储一个关键字；
 * 3.非叶子结点的左指针指向小于其关键字的子树，右指针指向大于其关键字的子树
 *  BST树的搜索，从根结点开始，如果查询的关键字与结点的关键字相等，那么就命中；
 *  否则，如果查询关键字比结点关键字小，就进入左儿子；如果比结点关键字大，就进
 *  入右儿子；如果左儿子或右儿子的指针为空，则报告找不到相应的关键字
 *
 *二、AVL树（平衡二叉搜索树）
 * 定义：平衡二叉树或为空树,或为如下性质的二叉排序树
 * （1）左右子树深度之差的绝对值不超过1;
 * （2）左右子树仍然为平衡二叉树
 *
 * 三、RBT（红黑树）
 * AVL是严格平衡树，因此在增加或者删除节点的时候，根据不同情况，旋转的次数比红黑树要多；
 * 红黑是弱平衡的，用非严格的平衡来换取增删节点时候旋转次数的降低；
 * 所以简单说，搜索的次数远远大于插入和删除，那么选择AVL树，如果搜索，插入删除次数几乎差不多，应该选择RB树。
 *
 * 红黑树上每个结点内含五个域，color，key，left，right，p。如果相应的指针域没有，则设为NIL。
 * 一般的，红黑树，满足以下性质，即只有满足以下全部性质的树，我们才称之为红黑树：
 * 1）每个结点要么是红的，要么是黑的。
 * 2）根结点是黑的。
 * 3）每个叶结点，即空结点（NIL）是黑的。
 * 4）如果一个结点是红的，那么它的俩个儿子都是黑的。
 * 5）对每个结点，从该结点到其子孙结点的所有路径上包含相同数目的黑结点
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
