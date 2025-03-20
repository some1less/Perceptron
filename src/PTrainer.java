import java.util.Collections;
import java.util.List;

public class PTrainer {

    public static void main(String[] args) {

        List<double[]> trainData = DatasetLoader.loadData("data/perceptron.data");
        List<Integer> trainLabels = DatasetLoader.loadLabels("data/perceptron.data");

        List<double[]> testData = DatasetLoader.loadData("data/perceptron.test.data");
        List<Integer> testLabels = DatasetLoader.loadLabels("data/perceptron.test.data");

        // 50% acc issue, fix
        trainData = normalizeData(trainData);
        testData = normalizeData(testData);


        Perceptron p = new Perceptron(trainData.get(0).length, 0.1);
        Collections.shuffle(trainData);
        Collections.shuffle(trainLabels);


        p.train(trainData, trainLabels, 20000);

        int correctPredictions = 0;
        for (int i = 0; i < testData.size(); i++) {
            int prediction = p.predict(testData.get(i));
            if (prediction == testLabels.get(i)) {
                correctPredictions++;
            }
        }

        System.out.println("Accuracy: " + (correctPredictions / (double) testData.size()) * 100 + "%");
    }

    public static List<double[]> normalizeData(List<double[]> data) {

        int featureCount = data.get(0).length;
        double[] minValues = new double[featureCount];
        double[] maxValues = new double[featureCount];

        for (int i = 0; i < featureCount; i++) {
            minValues[i] = Double.MAX_VALUE;
            maxValues[i] = Double.MIN_VALUE;
        }

        // find min/max for each feature
        for (double[] row : data) {
            for (int i = 0; i < featureCount; i++) {
                minValues[i] = Math.min(minValues[i], row[i]);
                maxValues[i] = Math.max(maxValues[i], row[i]);
            }
        }

        // normalize each feature to the range [0, 1]
        for (int i = 0; i < data.size(); i++) {
            double[] row = data.get(i);
            for (int j = 0; j < featureCount; j++) {
                row[j] = (row[j] - minValues[j]) / (maxValues[j] - minValues[j]);
            }
        }

        return data;
    }

}
