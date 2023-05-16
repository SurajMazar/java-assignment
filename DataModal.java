import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class DataModal {

    public Map<Integer, Map<String, String>> get() {
        try {
            File file = new File("contacts.txt");
            Scanner sc = new Scanner(file);

            Map<Integer, Map<String, String>> data = new HashMap<Integer, Map<String, String>>();
            int i = 0;
            Map<String, String> temp = new HashMap<String, String>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (Objects.equals(line, "")) {
                    temp = new HashMap<String, String>();
                    i++;
                } else {
                    if (line.contains("name")) {
                        temp.put("name", line.replace("name", "").trim());
                    } else if (line.contains("email")) {
                        temp.put("email", line.replace("email", "").trim());
                    } else if (line.contains("birthday")) {
                        temp.put("birthday", line.replace("birthday", "").trim());
                    } else if (line.contains("phone")) {
                        temp.put("phone", line.replace("phone", "").trim());
                    } else if (line.contains("address")) {
                        temp.put("address", line.replace("address", "").trim());
                    }
                    data.put(i, temp);
                }
            }
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading the instructions !");
        }
        return new HashMap<>();
    }


    public Map<Integer, Map<String, String>> save(Map<String, String> data) {
        Map<Integer, Map<String, String>> existing_data = this.get();
        int index = -1;

        Map<String, String> comp2 = new HashMap<>();
        String name1 = data.get("name").trim();
        String birthday1 = data.get("birthday").trim();
        comp2.put("name", name1);
        comp2.put("birthday", birthday1);


        int size = existing_data.size();

        for (int i = 0; i < size; i++) {
            Map<String, String> comp1 = new HashMap<>();
            if (existing_data.containsKey(i)) {
                String name = existing_data.get(i).get("name").trim();
                String birthday = existing_data.get(i).get("birthday").trim();
                comp1.put("name", name);
                comp1.put("birthday", birthday);
                if (comp1.equals(comp2)) {
                    index = i;
                    break;
                }
            }
        }

        data.remove("instruction");
        if (index < 0) {
            existing_data.put(existing_data.size(), data);
        } else {
            Map<String, String> temp = existing_data.get(index);
            data.putAll(temp);
            existing_data.put(index, data);
        }

        return existing_data;
    }

    public Map<Integer, Map<String, String>> save(Map<String, String> data, Map<Integer, Map<String, String>> existing_data) {
        int index = -1;
        Map<String, String> comp2 = new HashMap<>();
        String name1 = data.get("name").trim();
        String birthday1 = data.get("birthday").trim();
        comp2.put("name", name1);
        comp2.put("birthday", birthday1);


        int size = existing_data.size();

        for (int i = 0; i < size; i++) {
            Map<String, String> comp1 = new HashMap<>();
            if (existing_data.containsKey(i)) {
                String name = existing_data.get(i).get("name").trim();
                String birthday = existing_data.get(i).get("birthday").trim();
                comp1.put("name", name);
                comp1.put("birthday", birthday);
                if (comp1.equals(comp2)) {
                    index = i;
                    break;
                }
            }
        }

        data.remove("instruction");
        if (index < 0) {
            existing_data.put(existing_data.size(), data);
        } else {
            Map<String, String> temp = existing_data.get(index);
            data.putAll(temp);
            existing_data.put(index, data);
        }

        return existing_data;
    }


    public Map<Integer, Map<String, String>> delete(Map<String, String> data) {
        Map<Integer, Map<String, String>> existing_data = this.get();
        int index = -1;

        Map<String, String> comp2 = new HashMap<>();
        String name1 = data.get("name").trim();
        String birthday1 = data.get("birthday").trim();
        comp2.put("name", name1);
        comp2.put("birthday", birthday1);


        int size = existing_data.size();

        for (int i = 0; i < size; i++) {
            Map<String, String> comp1 = new HashMap<>();
            if (existing_data.containsKey(i)) {
                String name = existing_data.get(i).get("name").trim();
                String birthday = existing_data.get(i).get("birthday").trim();
                comp1.put("name", name);
                comp1.put("birthday", birthday);
                if (comp1.equals(comp2)) {
                    index = i;
                    break;
                }
            }
        }

        data.remove("instruction");
        if (index >= 0) {
            existing_data.remove(index);
        }

        return existing_data;
    }

    public Map<Integer, Map<String, String>> delete(Map<String, String> data, Map<Integer, Map<String, String>> existing_data) {
        int index = -1;
        Map<String, String> comp2 = new HashMap<>();
        String name1 = data.get("name").trim();
        String birthday1 = data.get("birthday").trim();
        comp2.put("name", name1);
        comp2.put("birthday", birthday1);


        int size = existing_data.size();

        for (int i = 0; i < size; i++) {
            Map<String, String> comp1 = new HashMap<>();
            if (existing_data.containsKey(i)) {
                String name = existing_data.get(i).get("name").trim();
                String birthday = existing_data.get(i).get("birthday").trim();
                comp1.put("name", name);
                comp1.put("birthday", birthday);
                if (comp1.equals(comp2)) {
                    index = i;
                    break;
                }
            }
        }

        data.remove("instruction");
        if (index >= 0) {
            existing_data.remove(index);
        }

        return existing_data;
    }

}
