import java.io.*;
import java.util.*;


public class InstructionReader {

    public Map<Integer, Map<String, String>> parseInstruction(String path) {
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);

            Map<Integer, Map<String, String>> instructions = new HashMap<Integer, Map<String, String>>();
            int i = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(!Objects.equals(line, "")) {
                    if (line.contains(Instruction.ADD)) {
                        instructions.put(i, this.generateInstructionData(line, Instruction.ADD));
                    } else if (line.contains(Instruction.DELETE)) {
                        instructions.put(i, this.generateInstructionDeleteData(line, Instruction.DELETE));
                    } else if (line.contains(Instruction.SAVE)){
                        instructions.put(i, this.generateInstructionData(line, Instruction.SAVE));
                    }
                    i++;
                }
            }
            return instructions;
        } catch (Exception e) {
            System.out.println("Error occurred while reading the instructions !");
        }
        return new HashMap<>();
    }


    public Map<String, String> generateInstructionData(String instructionData, String instruction) {
        Map<String, String> data = new HashMap<String, String>();
        String[] splited = this.sanitizeString(instructionData).split(";");
        for (int i = 0; i < splited.length; i++) {
            if (splited[i].contains("name")) {
                data.put("name", splited[i].replace("name", "").trim());
            } else if (splited[i].contains("birthday")) {
                data.put("birthday", splited[i].replace("birthday", "").trim());
            } else if (splited[i].contains("phone")) {
                data.put("phone", splited[i].replace("phone", "").trim());
            }else if (splited[i].contains("email")) {
                data.put("email", splited[i].replace("email", "").trim());
            } else if (splited[i].contains("ress")) {
                data.put("address", splited[i].replace("ress", "").trim());
            }
        }

        data.put("instruction", instruction);
        return data;
    }

    public Map<String, String> generateInstructionDeleteData(String instructionData, String instruction) {
        Map<String, String> data = new HashMap<String, String>();
        String[] splited = this.sanitizeString(instructionData).split(";");
        data.put("name", splited[0].replace("name", "").trim());
        data.put("birthday", splited[1].replace("birthday", "").trim());
        data.put("instruction", instruction);
        return data;
    }


    public String sanitizeString(String str) {
        return str.replace(Instruction.ADD, "").replace(Instruction.DELETE, "").replace(Instruction.SAVE, "");
    }
}
