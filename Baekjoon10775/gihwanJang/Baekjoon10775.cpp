#include <iostream>
#include <vector>

using namespace std;

int findRoot(vector<int>&gates_state, int p) {
    if(gates_state[p] == p) return p;
    return gates_state[p] = findRoot(gates_state, gates_state[p]);
}

void unionNode(vector<int>&gates_state, int p1, int p2) {
    int p1_root = findRoot(gates_state, p1);
    int p2_root = findRoot(gates_state, p2);

    if(p1_root == p2_root) return;

    gates_state[p1_root] = p2_root;
}

int getMaximumDocking(vector<int>&plane, int&g, int&p) {
    vector<int> gates_state(g);
    for(int i = 1; i <= g; ++i)
        gates_state[i] = i;
    
    for(int i = 0; i < p; ++i) {
        if(!findRoot(gates_state, plane[i]))
            return i;
        unionNode(gates_state, plane[i], findRoot(gates_state, plane[i]) - 1);
        /*
        for(int i = 0; i <= g; ++i)
            cout << gates_state[i] << ",";
        cout << "\n";
        */
    }
    return p;
}

int main(int argc, char const *argv[]) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int g, p;
    cin >> g >> p;

    vector<int> plane(p);
    for(int i = 0; i < p; ++i)
        cin >> plane[i];

    cout << getMaximumDocking(plane, g, p) << "\n";
    return 0;
}
