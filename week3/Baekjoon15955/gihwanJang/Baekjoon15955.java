import java.io.*;
import java.util.*;

class Point {
    int x, y, seq;

    public static Comparator<Point> comparatorWithX() {
        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return a.x - b.x;
            }
        };
        return comparator;
    }
    public static Comparator<Point> comparatorWithY() {
        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                return a.y - b.y;
            }
        };
        return comparator;
    }
}

class Query {
    int start, end, hp, seq;
    String result;

    public void setResult(boolean result) {
        if(result) this.result = "YES\n";
        else this.result = "NO\n";
    }

    public static Comparator<Query> comparatorWithHp() {
        Comparator<Query> comparator = new Comparator<Query>() {
            @Override
            public int compare(Query a, Query b) {
                return a.hp - b.hp;
            }
        };
        return comparator;
    }
    public static Comparator<Query> comparatorWithSeq() {
        Comparator<Query> comparator = new Comparator<Query>() {
            @Override
            public int compare(Query a, Query b) {
                return a.seq - b.seq;
            }
        };
        return comparator;
    }
}

class Edge implements Comparable<Edge> {
    int value, start, end;

    @Override
    public int compareTo(Edge o) {
        return value - o.value;
    }
}

class UnionFind {
    int size;
    int[] node;

    public UnionFind(int size) {
        this.size = size;
        this.node = new int[size];
        for(int i = 0; i < size; ++i)
            node[i] =i;
    }

    public int find(int n) {
        if(node[n] == n) return n;
        return node[n] = find(node[n]);
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        node[rootA] = rootB;
    }
}

public class Baekjoon15955 {
    private PriorityQueue<Edge> getEdges(List<Point> checkPoints) {
        PriorityQueue<Edge> edges = new PriorityQueue<>(checkPoints.size()*2);

        Collections.sort(checkPoints, Point.comparatorWithX());
        for (int i = 1; i < checkPoints.size(); ++i) {
            Edge edge = new Edge();
            edge.value = checkPoints.get(i).x - checkPoints.get(i-1).x;
            edge.start = checkPoints.get(i).seq;
            edge.end = checkPoints.get(i-1).seq;
            edges.add(edge);
        }
        Collections.sort(checkPoints, Point.comparatorWithY());
        for (int i = 1; i < checkPoints.size(); ++i) {
            Edge edge = new Edge();
            edge.value = checkPoints.get(i).y - checkPoints.get(i-1).y;
            edge.start = checkPoints.get(i).seq;
            edge.end = checkPoints.get(i-1).seq;
            edges.add(edge);
        }

        return edges;
    }

    public String solve(List<Point> checkPoints, List<Query> querys) {
        StringBuilder sb = new StringBuilder();
        UnionFind mst = new UnionFind(checkPoints.size());
        PriorityQueue<Edge> edges = getEdges(checkPoints);

        Collections.sort(querys, Query.comparatorWithHp());
        for (int i = 0; i < querys.size(); ++i) {
            Query query = querys.get(i);

            while(!edges.isEmpty()) {
                Edge edge = edges.peek();

                if(edge.value > query.hp) break;

                mst.union(edge.start, edge.end);
                edges.poll();
            }

            query.setResult(mst.find(query.start) == mst.find(query.end));
        }

        Collections.sort(querys, Query.comparatorWithSeq());
        for (int i = 0; i < querys.size(); ++i)
            sb.append(querys.get(i).result);
        
        return sb.toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        Baekjoon15955 problem = new Baekjoon15955();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        List<Point> checkPoints = new ArrayList<>(n);
        List<Query> querys = new ArrayList<>(q);

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            Point point = new Point();
            point.seq = i;
            point.x = Integer.parseInt(st.nextToken());
            point.y = Integer.parseInt(st.nextToken());
            checkPoints.add(point);
        }

        for (int i = 0; i < q; ++i) {
            st = new StringTokenizer(br.readLine());
            Query query = new Query();
            query.start = Integer.parseInt(st.nextToken()) - 1;
            query.end = Integer.parseInt(st.nextToken()) - 1;
            query.hp = Integer.parseInt(st.nextToken());
            query.seq = i;
            querys.add(query);
        }

        System.out.println(problem.solve(checkPoints, querys));
    }
}
