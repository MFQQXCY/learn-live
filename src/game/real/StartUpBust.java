package game.real;

import java.util.ArrayList;

/**
 * 击沉游戏主体
 * 1. 创建三个被击沉对象，赋予名字
 * 2. 将被击沉对象放在7x7表格中
 * 3. 检查用户的每次猜测是否命中
 * 4. 游戏运行直到所有被击沉
 * 5. 退出main函数
 * 
 */
public class StartUpBust {

    GameHelper helper = new GameHelper();
    ArrayList<StartUp> startUps = new ArrayList<>();
    int numOfGuesses;

    void setUpGame() {
        startUps.add(new StartUp("cabista"));
        startUps.add(new StartUp("poniez"));
        startUps.add(new StartUp("hacqi"));
        
        System.out.println("Your goal is to sink three Startups.");
        System.out.println("poniez, hacqi, cabista");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for (StartUp startUp : startUps) {
            startUp.setLocationCells(helper.placeStartup(3));
        }
    }

    void startPlaying() {
        while(startUps.size() > 0){
            String s = helper.getUserInput("Enter a guess");
            checkUserGuess(s);
        }
        finishGame();
    }

    void checkUserGuess(String guess) {
        numOfGuesses ++;
        String result = "miss";
        for (StartUp startUp : startUps) {
            result = startUp.checkYourself(guess);
            if(result.equals("hit")){
                break;
            }
            if(result.equals("kill")){
                startUps.remove(startUp);
                break;
            }

        }
        System.out.println(result);

    }

    void finishGame() {
        System.out.println("Game Over");
        if(numOfGuesses < 20){
            System.out.println("Congratulations!");
        }else{
            System.out.println("work hard!");
        }
        System.out.println("You tried " + numOfGuesses + "times.");
    }

    public static void main(String[] args) {
        StartUpBust game = new StartUpBust();
        game.setUpGame();
        game.startPlaying();
    }

}
