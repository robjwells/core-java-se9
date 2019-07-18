import java.util.ArrayList;

class Ex1_15 {
    static ArrayList<Integer> arrayListWith1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        return list;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ArrayList<ArrayList<Integer>> pascalsTriangle = new ArrayList<>();
        pascalsTriangle.add(arrayListWith1());

        for (int level = 1; level <= n; level++) {
            ArrayList<Integer> levelList = arrayListWith1();
            pascalsTriangle.add(levelList);

            ArrayList<Integer> previousLevel = pascalsTriangle.get(level - 1);
            for (int item = 1; item < level; item++) {
                levelList.add(previousLevel.get(item - 1) + previousLevel.get(item));
            }

            levelList.add(1);
        }
        pascalsTriangle.stream().forEach(System.out::println);
    }
}
