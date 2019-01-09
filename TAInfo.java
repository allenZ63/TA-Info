package tainfo;

import java.io.*;
import java.util.*;

public class TAInfo {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<Integer, List<String>> taQtr = new HashMap<Integer, List<String>>();
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/apz/Documents/NetBeansProjects/TAInfo/tainfo.txt"));
        Scanner sc = new Scanner(br);

        String text = "";

        while (text != null) {
            text = br.readLine();
            if (text == null) {
                break;
            }

            String delimeter = "[ ]";
            String[] wordStorage = text.split(delimeter);

            if (wordStorage.length == 2) {
                String name = wordStorage[0];
                int number = Integer.parseInt(wordStorage[1]);
                if (taQtr.containsKey(number) == true) {
                    taQtr.get(number).add(name);
                }
                if (taQtr.containsKey(number) == false) {
                    taQtr.put(number, new ArrayList<String>());
                    taQtr.get(number).add(name);
                }
            }
        }
        for (Integer i : taQtr.keySet()) {
            System.out.println(i + ":");
            for(int j  = 0; j < taQtr.get(i).size(); j++){
                System.out.println(taQtr.get(i).get(j));
            }
            System.out.println("");
        }
    }
}



