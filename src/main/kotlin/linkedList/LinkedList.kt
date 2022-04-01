/**
 * Author: Sait Göktuğ Doğan
 * Date: 04.01.2022
 *
 * Here lies a custom generic Linked List implementation, not sorted version.
*/

package linkedList

data class ListNode<T> (
    var value: T,
    var next: ListNode<T>?
) {
    override fun toString(): String {
        return if (next != null) {
            "$value --> ${next.toString()}"
        } else {
            "$value"
        }
    }
}

class LinkedList<T> (private var root: ListNode<T>?) {
    /**
     * 1) If root is null, just insert node as root
     * 2) If root is not null, find the last node in list, and insert
     *    new node as next of the last node.
     */
    fun insert(value: T) {
        if (root == null) {
            root = ListNode(value, null)
            return
        }
        var node: ListNode<T>? = root

        while(node?.next != null) {
            node = node.next
        }

        node?.next = ListNode(value, null)
    }

    /**
     * 1) If root is the removed value, change root to previous
     *    root's next Node.
     * 2) If root is not removed value, search for the value in
     *    list :
     *    a) If value is found, set previous Node's next Node to
     *       value's next Node.
     *    b) If value is not found, do nothing. - TODO We may return a warning here.
     */
    fun remove(value: Int) {
        if (root == null) return

        if (root?.value == value) {
            root = root?.next
            return
        }

        var previousNode: ListNode<T>? = root
        var currentNode: ListNode<T>? = root

        while(currentNode?.value != value) {
            previousNode = currentNode
            currentNode = currentNode?.next
        }

        previousNode?.next = currentNode.next
    }

    override fun toString(): String {
        return if (root == null) "Empty linked list" else root.toString()
    }
}


/**
 *  Initial list: 1 -> 2 -> 5
 *  Insert 20:    1 -> 2 -> 5 -> 20
 *  Remove 2:     1 -> 5 -> 20
 *  Remove 20:    1 -> 5
 *  Remove 1:     5
 *  Remove 5:     Empty Linked List
 *  Remove 3:     Empty Linked List (it was empty already before.)
 *  Insert 7:     7
 */
fun main() {
    val linkedList: LinkedList<Int> = LinkedList(ListNode(1, ListNode(2, ListNode(5, null))))
    println(linkedList)

    linkedList.insert(20)
    println(linkedList)

    linkedList.remove(2)
    println(linkedList)

    linkedList.remove(20)
    println(linkedList)

    linkedList.remove(1)
    println(linkedList)

    linkedList.remove(5)
    println(linkedList)

    linkedList.remove(3)
    println(linkedList)

    linkedList.insert(7)
    println(linkedList)
}