public class Main {

    public static void main(String[] args) {

        GUI gui = new GUI();

        gui.makeBoard();

        while (true) {
            // X spillerens tur
            gui.getXPlayer();
            gui.makeBoard();
            gui.checkWinner();

            // Check om X har vundet
            String result = gui.checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            // O spillerens tur
            gui.getOPlayer();
            gui.makeBoard();
            gui.checkWinner();

            // Check hvis O har vundet
            result = gui.checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
    }
}
