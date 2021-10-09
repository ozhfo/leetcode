package dsaa.栈;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * <p>
 * <p>
 * 说明：
 * <p>
 * 你只能使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * <p>
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * User: sam_zhan
 * DateTime: 2021/9/14 12:21 上午
 */
public class LC232_用栈实现队列 {

    public static void main(String[] args) {
        MyList myQueue = new MyList();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }


    static class MyList {

        private Stack<Integer> in, out;

        public MyList() {
            in = new Stack<>();
            out = new Stack<>();
        }

        /**
         * @param x
         */
        public void push(int x) {
            while (!out.isEmpty()) {
                in.push(out.pop());
            }
            in.push(x);
        }

        /**
         * @return
         */
        public int pop() {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.pop();
        }

        public int peek() {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.peek();
        }

        public boolean empty() {
            return out.isEmpty() && in.isEmpty();
        }
    }

    /**
     * xx
     */
    static class MyListBetter {
        private Stack<Integer> in, out;

        public MyListBetter() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) out.push(in.pop());
            }
            return out.peek();
        }

        public boolean empty() {
            return out.isEmpty() && in.isEmpty();
        }
    }
}