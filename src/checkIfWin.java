import java.util.ArrayList;

public class checkIfWin {
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    ArrayList<Integer> list3 = new ArrayList<>();

    ArrayList<ArrayList<Integer>> grid = new ArrayList<>();


    static public boolean checkIfWinner(ArrayList<ArrayList<Integer>> inputArrayGrid){
        boolean returnBoolean = false;
        int times = inputArrayGrid.size();
        StringBuilder actual = new StringBuilder();
        StringBuilder check = new StringBuilder();
        for (int i = 0; i < inputArrayGrid.size(); i++) {
            times = (times * i) + 1;
            for (int j = 0; j < inputArrayGrid.get(i).size(); j++) {
                if (inputArrayGrid.get(i).get(j) == j + times);
                int a = (j + 1) + (i * inputArrayGrid.size());
                actual.append(inputArrayGrid.get(i).get(j));
                check.append(a);
            }
        }
        if (actual.toString().equalsIgnoreCase(check.toString())) {
            returnBoolean = true;
        }
        return returnBoolean;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(list1);
        grid.add(list2);
        grid.add(list3);
        System.out.println(checkIfWinner(grid));
    }
}
