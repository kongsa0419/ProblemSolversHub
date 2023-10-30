import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    // 입력값을 받음
    val n = nextInt()
    val x_array:MutableList<Int> = mutableListOf()
    repeat(n) {
        x_array.add(nextInt())
    }

    // 절대값 힙을 출력
    print_num(n, x_array)
}

fun print_num(n:Int, x_array: MutableList<Int>) {
    // 음수들이 들어갈 역순 정렬 Priority Queue
    val minus_queue = PriorityQueue<Int>() {o1, o2 -> o2.compareTo(o1)}

    // 양수들이 들어갈 Priority Queue
    val plus_queue = PriorityQueue<Int>()

    repeat(n) {
        val num = x_array[it]
        if (num > 0)
            // 양수면 plus_queue에 삽입
            plus_queue.offer(num)

        else if (num < 0)
            // 음수면 minus_queue에 삽입
            minus_queue.offer(num)

        else {
            // 각 큐의 사이즈를 구해서
            val ms = minus_queue.size
            val ps = plus_queue.size

            // 두 큐 모두 비어있다면 0 출력
            if (ms + ps == 0)
                println(0)

            // plus_queue만 있다면 plus_queue에서 출력 (최소값)
            else if (ms == 0)
                println(plus_queue.poll())

            // minus_queue만 있다면 minus_queue에서 출력 (최대값)
            else if (ps == 0)
                println(minus_queue.poll())

            else
            {
                // 음수의 최대값의 역수가 양수의 최소값보다 크다면
                if (-minus_queue.peek() > plus_queue.peek())
                    // plus_queue에서 최소값 출력
                    println(plus_queue.poll())

                // 반대라면
                else
                    // minus_queue에서 최대값 출력
                    println(minus_queue.poll())
            }
        }
    }
}