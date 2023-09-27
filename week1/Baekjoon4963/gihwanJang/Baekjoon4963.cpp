#include <iostream>
#include <vector>

using namespace std;

struct Point{int r, c;};

bool verificationPoint(Point p, int h, int w) {
    return (0 <= p.r && p.r < h) && (0 <= p.c && p.c < w);
}

vector<Point> getDirection() {
    vector<Point> direction = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}, 
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };
    return direction;
}

void travleIsland(vector<vector<bool>>&map, vector<vector<bool>>&visited, Point p) {
    if(visited[p.r][p.c]) return;

    visited[p.r][p.c] = true;

    for(Point d : getDirection())
        if(verificationPoint({p.r + d.r, p.c + d.c}, map.size(), map[0].size()) && map[p.r + d.r][p.c + d.c])
            travleIsland(map, visited, {p.r + d.r, p.c + d.c});
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int w, h;

    while(1) {
        cin >> w >> h;
        if(!w && !h) break;

        int val;
        int island_cnt = 0;
        vector<vector<bool>> map(h, vector<bool>(w));
        vector<vector<bool>> visited(h, vector<bool>(w));
        
        for(int r = 0; r < h; ++r)
            for(int c = 0; c < w; ++c){
                cin >> val;
                map[r][c] = val;
            }

        for(int r = 0; r < h; ++r)
            for(int c = 0; c < w; ++c)
                if(map[r][c] && !visited[r][c]) {
                    travleIsland(map, visited, {r, c});
                    ++island_cnt;
                }

        cout << island_cnt << "\n";
    }
    return 0;
}
