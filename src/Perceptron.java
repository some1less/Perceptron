import java.util.List;
import java.util.logging.Level;

public class Perceptron {

    private double[] weights;
    private double bias;
    private double learningRate;

    public Perceptron(int inputSize, double learningRate) {
        this.weights = new double[inputSize];
        this.bias = Math.random();
        this.learningRate = learningRate;

        for (int i = 0; i < weights.length; i++) {
            weights[i] = Math.random();
        }
    }

    public int predict(double[] testVector){
        double res = 0;
        for (int i = 0; i < testVector.length; i++){
            res += testVector[i] * weights[i];
        }
        res -= bias;
        return res >= 0 ? 1 : 0;
    }

    public void train(List<double[]> inputs, List<Integer> labels, int epochs) {

        for (int epoch = 0; epoch < epochs; epoch++) {
            for (int i = 0; i < inputs.size(); i++) {

                double[] input = inputs.get(i);
                int label = labels.get(i);
                int prediction = predict(input);
                int error = label - prediction;

                for (int j = 0; j < input.length; j++) {
                    weights[j] += learningRate * error * input[j];
                }
                bias -= error * learningRate;

            }
        }

    }


}
