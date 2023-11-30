/**
 *
 * 1 ≤ want의 길이 = number의 길이 ≤ 10
 * 1 ≤ number의 원소 ≤ 10
 * number[i]는 want[i]의 수량을 의미하며, number의 원소의 합은 10입니다.
 * 10 ≤ discount의 길이 ≤ 100,000
 * want와 discount의 원소들은 알파벳 소문자로 이루어진 문자열입니다.
 * 1 ≤ want의 원소의 길이, discount의 원소의 길이 ≤ 12
 *
 *  원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입
 *
 *  회원 등록 시 원하는 제품을 모두 할일 받을 수 있는 회원등록 날짜의 총 일수 를 return
 */




class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        var buyerMaps = mutableMapOf<String,Int>()
        for(i in 0..want.size-1){
            buyerMaps.put(want[i],number[i])
        }
        // buyerMaps 와 discount 가 10번 이상 충족 하면! answer++
        var tempMaps = buyerMaps.filter{true}.toMutableMap()
        var count = 0
        for(day in 1..discount.size){
            for(i in day-1..discount.size-day-2){
                if(tempMaps.contains(discount[i]))
                {
                    //가입 할 경우 처리
                    if(count>=10) {

                        answer++

                        //각 값들 초기화
                        count =0
                        tempMaps = buyerMaps.filter{true}.toMutableMap()
                        break
                    }


                    // 원하는 상품이 없으면 가입 안함
                    if(tempMaps[discount[i]]!! <0){
                        //각 값들 초기화
                        count =0
                        tempMaps = buyerMaps.filter{true}.toMutableMap()
                        break
                    }



                    // 하나씩 차감
                    tempMaps[discount[i]] = tempMaps[discount[i]]!! - 1
                    count++
                }

            }
        }
        //


        return answer
    }
}
fun main()
{
    var a = Solution()

    a.solution(arrayOf("banana", "apple", "rice", "pork", "pot"), intArrayOf(3,2,2,2,1), arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"))
    //3

    a.solution(arrayOf("apple"), intArrayOf(10),arrayOf("banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"))
    //0

}