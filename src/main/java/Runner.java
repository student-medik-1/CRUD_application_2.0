import view.AbstractView;
import view.RunnerView;

public class Runner {

    public static void main(String[] args) {


        AbstractView abstractView = RunnerView.getView();
        abstractView.start();
    }
}
