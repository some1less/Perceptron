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
                labels.add(Integer.parseInt(parts[parts.length-1]));
            }

            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        return labels;
    }

}
