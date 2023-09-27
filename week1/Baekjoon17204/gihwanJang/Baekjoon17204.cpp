#include <iostream>
#include <vector>

using namespace std;

int getNumber(vector<int>&points, int&n, int&k) {
    vector<bool> visited(n);

    for(int i = 0, prev=0; i < n; ++i) {
        if(points[prev] == k)
            return i+1;

        if(visited[prev]) break;

        visited[prev] = true;
        prev = points[prev];
    }

    return -1;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k;
    cin >> n >> k;

    vector<int> points(n);
    for(int i = 0; i < n; ++i)
        cin >> points[i];

    cout << getNumber(points, n, k) << "\n";
    return 0;
}
