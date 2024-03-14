/**
 * @author LJ189
 */
import java.util.*;

public class PokerGame {

    static HashMap<Integer, String> hm  = new HashMap<Integer, String>();
    //牌盒
    static ArrayList<Integer> list = new ArrayList<>();
    //静态代码块
    //随着类的加载而加载，而且只执行一次
    static {
        //准备牌
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        Integer serialNumber = 1;
        for (String n : number) {
            for (String c : color) {
                hm.put(serialNumber, c + n);
                list.add(serialNumber);
                serialNumber++;
            }
        }
        hm.put(53, "小王");
        list.add(53);
        hm.put(54, "大王");
        list.add(54);

        System.out.println(hm);
    }
    public PokerGame() {
        //洗牌
        Collections.shuffle(list);

        //发牌
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            if (i < 3) {
                lord.add(list.get(i));
                continue;
            }
            if (i % 3 == 0) {
                player1.add(list.get(i));
            } else if (i % 3 == 1){
                    player2.add(list.get(i));
            } else {
                    player3.add(list.get(i));
            }
        }

        //看牌
        lookPoker("lord", lord);
        lookPoker("player1", player1);
        lookPoker("player2", player2);
        lookPoker("player3", player3);

    }
    //看牌
    //参数name:玩家名字，参数list:牌
    public void lookPoker(String name, TreeSet<Integer> list) {
        System.out.print(name + ": ");
        for (Integer i : list) {
            System.out.print(hm.get(i) + " ");
        }
        System.out.println();
    }
}
