fun main(args: Array<String>) {
    // 첫째 줄에 N 입력 받음
    val num = readLine()!!.toInt()

    // Int로 이루어진 2차원 List 생성
    var input_list: MutableList<MutableList<Int>> = ArrayList()

    // (숫자, 원래 위치(인덱스)) 입력 받음
    repeat(num) {
        input_list.add(mutableListOf<Int>(readLine()!!.toInt(), it))
    }

    // 버블 정렬
    bubble_sort(num, input_list)
}

fun bubble_sort(num:Int, num_list: MutableList<MutableList<Int>>) {
    // 2차원 리스트를 입력받은 숫자에 해당하는 값을 기준으로 오름차순 정렬
    val sorted = num_list.sortedBy { it.first() }

    // 최대값을 저장할 변수 max
    var max = 0

    // 전체 중 '원래 위치-현재 위치'의 값이 max보다 크다면 max에 저장
    repeat(num) {
        if (max < sorted[it][1]-it)
            max = sorted[it][1]-it
    }

    // 이미 정렬되어 있더라도 한 번 체크하니 max+1 반환
    println(max+1)
}