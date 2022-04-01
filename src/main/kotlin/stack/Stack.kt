package stack

// TODO Documentation will be added later
class Stack<T : Any> {
    val list: MutableList<T> = mutableListOf()
    var top: Int = -1

    fun push(value: T) {
        list.add(value)
        top += 1
    }

    fun pop(): T? {
        return if (0 <= top) {
            list.removeAt(top--)
        } else null
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Top\t")
                     .append(list.asReversed())
                     .append("\tBottom")
        return stringBuilder.toString()
    }
}

fun main() {
    val stack = Stack<Int>()

    stack.push(2)
    stack.push(1)
    stack.push(6)
    stack.push(8)
    stack.push(3)

    println(stack)

    stack.pop()
    stack.pop()
    stack.pop()
    stack.pop()
    stack.pop()
    stack.pop()

    println(stack)
}