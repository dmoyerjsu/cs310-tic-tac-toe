package edu.jsu.mcis;

public class TicTacToeController {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView();
        
    }

    public String getMarkAsString(int row, int col) {        
        return (model.getMark(row, col).toString());        
    }
    
    public TicTacToeView getView() {        
        return view;        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // INSERT YOUR CODE HERE
        JButton button = (JButton)event.getSource();
        
        string buttonName = button.getName();
        int row = Integer.parseInt(buttonName.substring(6,7));
        int col = Integer.parseInt(buttonName.substring(7,8));
        model.makeMark(row, col);

        view.updateSquares();
        if(model.isGameover()){
            view.disableSquares();
            view.showResult(model.getResult().toString());
        }

}
