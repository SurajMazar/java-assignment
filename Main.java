import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Main {
    public static void main(String[] args) {
        InstructionReader ir = new InstructionReader();
        Map<Integer, Map<String, String>> instructions = ir.parseInstruction("instruction.txt");

        DataModal dm = new DataModal();

        Map<Integer, Map<String, String>> temp = new HashMap<>();

        for (int i = 0; i < instructions.size(); i++) {
            String instruction = instructions.get(i).get("instruction");
            if (Objects.equals(instruction, Instruction.ADD)) {
                if (temp.size() == 0) {
                    temp = dm.save(instructions.get(i));
                } else {
                    temp = dm.save(instructions.get(i), temp);
                }
            } else if (Objects.equals(instruction, Instruction.DELETE)) {
                if (temp.size() == 0) {
                    temp = dm.delete(instructions.get(i));
                } else {
                    temp = dm.delete(instructions.get(i), temp);
                }
            }
        }

        Main m = new Main();
        m.writeResult(temp);
    }


    public void writeResult(Map<Integer, Map<String, String>> data) {
        try {
            FileWriter fstream = new FileWriter("contacts-updated.txt");
            BufferedWriter info = new BufferedWriter(fstream);

            for (int i = 0; i < data.size(); i++) {
                if (data.containsKey(i)) {
                    Map<String, String> db_data = data.get(i);
                    if (db_data.containsKey("name")) {
                        info.write("name " + db_data.get("name"));
                        info.newLine();

                    }
                    if (db_data.containsKey("email")) {
                        info.write("email " + db_data.get("email"));
                        info.newLine();

                    }
                    if (db_data.containsKey("birthday")) {
                        info.write("birthday " + db_data.get("birthday"));
                        info.newLine();

                    }
                    if (db_data.containsKey("phone")) {
                        info.write("phone " + db_data.get("phone"));
                        info.newLine();

                    }
                    if (db_data.containsKey("address")) {
                        info.write("address " + db_data.get("address"));
                        info.newLine();
                    }

                    info.newLine();
                }
            }

            info.close();

        } catch (Exception e) {
            System.out.println("A write error has occurred");
        }
    }
}
