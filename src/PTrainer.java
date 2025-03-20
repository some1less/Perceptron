import java.util.List;

public class PTrainer {

    public static void main(String[] args) {

        List<double[]> trainData = DatasetLoader.loadData("data/perceptron.data");
        List<Integer> trainLabels = DatasetLoader.loadLabels("data/perceptron.data");

        List<double[]> testData = DatasetLoader.loadData("data/perceptron.test.data");
        List<Integer> testLabels = DatasetLoader.loadLabels("data/perceptron.test.data");

        Perceptron p = new Perceptron(trainData.get(0).length, 0.01);

        p.train(trainData, trainLabels, 1000);

        int correctPredictions = 0;
        for (int i = 0; i < testData.size(); i++) {
            int prediction = p.predict(testData.get(i));
            if (prediction == testLabels.get(i)) {
                correctPredictions++;
            }
        }

        System.out.println("Accuracy: " + (correctPredictions / (double) testData.size()) * 100 + "%");
    }

}
