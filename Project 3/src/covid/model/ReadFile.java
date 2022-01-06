package covid.model;


import java.io.*;

public class ReadFile {
    public static String value = "";

    public static int num = 294;

    public static String readCellData(String file, int num) throws Exception {

        File folder = new File("CSV");
        for (final File fileEntry : folder.listFiles()) {

            BufferedReader br = null;
            try {

                br = new BufferedReader(new FileReader("CSV/" + fileEntry.getName()));
                String inputLine = null;
                int j = 0;
                while ((inputLine = br.readLine()) != null) {
                    j++;
                    if (j > 294) {j = 0;}

                    String[] data = inputLine.split(",");

                    HashTable<String, Integer> hash = new HashTable<>();
                    int i = Integer.parseInt(data[2]);
                    hash.put((data[1] + j), (i));

                    if (data[1].equals(file) && num == j) {
                        br.close();
                        value = data[2];
                        return value;
                    }
                }
            } catch (FileNotFoundException e) { e.printStackTrace(); }
            catch (IOException ex) {
                System.err.println("An IOException was caught!");
                ex.printStackTrace();
            } finally {
                if (br != null) {
                    try { br.close(); }
                    catch (IOException ex) {
                        System.err.println("An IOException was caught!");
                        ex.printStackTrace();
                    }
                }
            }
        }
        return value;
    }
}

// https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
// Data came from:
// https://data.cdc.gov/Case-Surveillance/United-States-COVID-19-Cases-and-Deaths-by-State-o/9mfq-cb36/data
// Hash Tables from:
// https://hendrix-cs.github.io/csci151/labs/tic-tac-toe.html
// System.out.println(data[1] +", " + j + ", " + data[2]);