def main() :
    # B 입력
    B = int(input())
    
    # 부가세를 제외한 가격 출력
    print(vat_to_origin(B))

# 부가세를 제외한 가격
def vat_to_origin(price) :
    
    # 가격을 10/11로 만들기
    return price/11*10
    
if __name__ == "__main__" :
    main()