def main() :
    # N, A, B 입력 받음
    N, A, B = map(int, input().split())
    
    # 각 가게의 상품을 입력 받을 리스트
    shop1 = list()
    shop2 = list()
    
    # 두 가게의 같은 종류의 물건 값의 차이
    diff_shops = list()
    
    # 반복문을 통해 정보를 입력 받음
    for i in range(N) :
        prod1, prod2 = map(int, input().split())
        shop1.append(prod1)
        shop2.append(prod2)
        
        # 이 때 [물건 값의 차이, 물건의 index]를 함께 입력 받음
        diff_shops.append([prod1-prod2, i])
    
    # 물건 값의 합의 최소를 찾는다.
    # 이 때 (상점 1의 가격 - 상점 2의 가격)이 작은 순서대로 정렬
    print(find_least_sum(A, B, shop1, shop2, sorted(diff_shops)))
        
# 물건 값의 합의 최소를 찾는 함수
def find_least_sum(A, B, shop1, shop2, diff) :
    # 최소 합을 초기값 0으로 정의
    least_sum = 0
    
    # 상점2의 가격이 더 많이 싼 것을 B만큼 2번 가게에서 뽑아준다
    for _ in range(B) :
        least_sum += shop2[diff.pop()[1]]
        
    # 나머지를 1번 가게에서 뽑아준다
    for _ in range(A) :
        least_sum += shop1[diff.pop()[1]]
    
    # 최소 합을 반환
    return least_sum
         
if __name__ == "__main__" :
    main()