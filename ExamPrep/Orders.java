import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        LinkedHashMap<String, TreeMap<String, Integer>> orders = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] command = scan.nextLine().split(" ");
            String customerName = command[0];
            int amount = Integer.parseInt(command[1]);
            String product = command[2];

            if (!orders.containsKey(product)){
                orders.put(product, new TreeMap<>());
                orders.get(product).put(customerName, amount);
            } else if (!orders.get(product).containsKey(customerName)){
                orders.get(product).put(customerName, amount);
            } else {
                orders.get(product).put(customerName, orders.get(product).get(customerName) + amount);
            }
        }

        for (String order : orders.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(order);
            sb.append(": ");
            TreeMap<String, Integer> values = orders.get(order);
            for (String customer : values.keySet()) {
                sb.append(customer);
                sb.append(" ");
                sb.append(values.get(customer));
                sb.append(", ");
            }

            System.out.println(sb.toString().substring(0, sb.length() - 2));
        }

    }
}
