import sys
sys.setrecursionlimit(10**9)

def main() :
    print_result = ''
    while True :
        # 양의 정수 w(너비), h(높이)은 띄어쓰기로 구분
        w, h = map(int, sys.stdin.readline().split())
        
        if w == 0 or h == 0 :
            print(print_result)
            break
        else :
            island_map = []
            for _ in range(h) :
                island_map.append(list(map(int,sys.stdin.readline().split())))
            print_result = print_result + str(count_island(island_map, w, h)) + '\n'
        
# 섬을 세는 함수
def count_island(island_map, w, h) :

    # 초기 섬의 개수는 0개
    island = 0
    
    # 섬을 0,0부터 끝까지 전체 체크
    for x in range(w) :
        for y in range(h) :
            
            # 만약 해당 좌표가 '섬'이라면
            if island_map[y][x] == 1 :
                
                # 섬의 개수 추가
                island += 1
                
                # 방문했다고 표시
                island_map[y][x] = 'Visited'
                
                # 주변 섬 체크
                island_map = check_neighbor(x, y, island_map, w, h)
                
    # 최종 섬의 개수 반환
    return island

# 주변 섬을 체크하는 함수
def check_neighbor(coordinate_x, coordinate_y, map_list, max_width, max_height) :
    
    # 조건에 따라 주변 섬 체크 (이 때 이미 방문한 Visited가 아닌 1만 체크)
    if coordinate_x > 0 :
        if map_list[coordinate_y][coordinate_x-1] == 1 :
            map_list[coordinate_y][coordinate_x-1] = 'Visited'
            map_list = check_neighbor(coordinate_x-1, coordinate_y, map_list, max_width, max_height)
            
        if coordinate_y > 0 :
            if map_list[coordinate_y-1][coordinate_x-1] == 1 :
                map_list[coordinate_y-1][coordinate_x-1] = 'Visited'
                map_list = check_neighbor(coordinate_x-1, coordinate_y-1, map_list, max_width, max_height)
    
    if coordinate_y > 0 :
        if map_list[coordinate_y-1][coordinate_x] == 1 :
            map_list[coordinate_y-1][coordinate_x] = 'Visited'
            map_list = check_neighbor(coordinate_x, coordinate_y-1, map_list, max_width, max_height)
            
        if coordinate_x < max_width-1 :
            if map_list[coordinate_y-1][coordinate_x+1] == 1 :
                map_list[coordinate_y-1][coordinate_x+1] = 'Visited'
                map_list = check_neighbor(coordinate_x+1, coordinate_y-1, map_list, max_width, max_height)
            
    if coordinate_x < max_width-1 :
        if map_list[coordinate_y][coordinate_x+1] == 1 :
            map_list[coordinate_y][coordinate_x+1] = 'Visited'
            map_list = check_neighbor(coordinate_x+1, coordinate_y, map_list, max_width, max_height)
            
        if coordinate_y < max_height-1 :
            if map_list[coordinate_y+1][coordinate_x+1] == 1 :
                map_list[coordinate_y+1][coordinate_x+1] = 'Visited'
                map_list = check_neighbor(coordinate_x+1, coordinate_y+1, map_list, max_width, max_height)
                
    if coordinate_y < max_height-1 :
        if map_list[coordinate_y+1][coordinate_x] == 1 :
            map_list[coordinate_y+1][coordinate_x] = 'Visited'
            map_list = check_neighbor(coordinate_x, coordinate_y+1, map_list, max_width, max_height)
            
        if coordinate_x > 0 :
            if map_list[coordinate_y+1][coordinate_x-1] == 1 :
                map_list[coordinate_y+1][coordinate_x-1] = 'Visited'
                map_list = check_neighbor(coordinate_x-1, coordinate_y+1, map_list, max_width, max_height)
                
    # 방문한 지점이 1에서 Visited로 변경된 지도를 반환
    return map_list
                
if __name__ == "__main__":
    main()