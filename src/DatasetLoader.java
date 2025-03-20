import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatasetLoader {
    public static List<double[]> loadData(String filePath) {

        List<double[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                double[] features = Arrays.stream(parts)
                        .limit(parts.length-1)
                        .mapToDouble(Double::parseDouble)
                        .toArray();

                data.add(features);
            }

            br.close();


        } catch (Exception e){
            e.printStackTrace();
        }

        return data;
    }

    public static List<Integer> loadLabels(String filePath) {
        List<Integer> labels = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String label = parts[parts.length-1];

                if ("Iris-versicolor".equals(label)) {
                    labels.add(0);  // Assign 0 for Iris-versicolor
                } else if ("Iris-virginica".equals(label)) {
                    labels.add(1);  // Assign 1 for Iris-virginica
                }
            }



            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        return labels;
    }

}
