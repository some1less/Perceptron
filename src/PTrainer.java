import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PTrainer {

    public static void main(String[] args) {

        List<double[]> trainData = DatasetLoader.loadData("data/perceptron.data");
        List<Integer> trainLabels = DatasetLoader.loadLabels("data/perceptron.data");

        for (double[] dataRow : trainData) {
            System.out.println(Arrays.toString(dataRow));
        }

        for (int e : trainLabels){
            System.out.println(e);
        }

        List<double[]> testData = DatasetLoader.loadData("data/perceptron.test.data");
        List<Integer> testLabels = DatasetLoader.loadLabels("data/perceptron.test.data");

        for (double[] dataRow : testData) {
            System.out.println(Arrays.toString(dataRow));
        }

        for (int e : testLabels){
            System.out.println(e);
        }

        Perceptron p = new Perceptron(trainData.get(0).length, 0.01);
//        Collections.shuffle(trainData);
//        Collections.shuffle(trainLabels);


        p.train(trainData, trainLabels, 385);

        int correctPredictions = 0;
        for (int i = 0; i < testData.size(); i++) {
            int prediction = p.predict(testData.get(i));
            if (prediction == testLabels.get(i)) {
                correctPredictions++;
            }
        }

        for (double w : p.weights) {
            System.out.print(w + ", ");
        }
        System.out.println();

        System.out.println(p.bias);
        System.out.println("Accuracy: " + (correctPredictions / (double) testData.size()) * 100 + "%");
    }
}
