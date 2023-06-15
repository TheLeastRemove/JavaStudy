package TableTennisScoring;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;

public class Interface {
    String option_1 = "开始计分";
    String option_2 = "查看历史";
    String option_3 = "退出";
    String option_4 = "返回";

    Integer place;
    String time;
    String referee;

    Pair<String, Integer> player_1;
    Pair<String, Integer> player_2;

    Integer totalNumberOfBureaus;
    Integer numberOfBureaus;
    Pair<Integer, Integer> numberOfSets;//赛制 3局2胜
    Boolean ballPower;
    Boolean direction;

    history history;


    public Interface() {
        player_1 = new Pair<>(" ", 0);
        player_2 = new Pair<>(" ", 0);
        place = 0;
        time = "00:00";
        totalNumberOfBureaus = 0;
        numberOfSets = new Pair<>(3, 2);
        numberOfBureaus = 0;
        ballPower = true;
        direction = true;
    }

    public void start() {
        System.out.println("欢迎使用乒乓球计分系统");
        System.out.println("请选择功能：");
        System.out.println("1.开始计分");
        System.out.println("2.查看历史");
        System.out.println("3.退出");
        System.out.println("请输入数字：");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                startGame();
                break;
            case 2:
                //showHistory();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("输入错误，请重新输入");
                start();
        }
    }

    private void startGame() {
        System.out.println("请输入选手姓名：");
        Scanner scanner = new Scanner(System.in);
        player_1.setFirst(scanner.nextLine());
        player_2.setFirst(scanner.nextLine());

        history history = new history(numberOfSets, player_1, 0, player_2, 0);

        System.out.println("请输入球台号：");
        place = scanner.nextInt();
        scanner.nextLine(); //读取回车符

        System.out.println("请输入比赛时间(hh:mm)：");
        time = scanner.nextLine();

        System.out.println("请输入比赛裁判：");
        referee = scanner.nextLine();


        System.out.println("---开始猜先---");

        System.out.println("确认后出现正反结果");
        scanner.nextLine();

        System.out.println("结果是" + (new Random().nextBoolean() ? "正" : "反") + "面朝上！");

        //暂时规定，球权为true为一号选手。
        System.out.println("先发球的是选手1还是选手2?");
        ballPower = (scanner.nextInt() == 1);

        //暂时规定，方向为true为正方向。
        System.out.println("其位于正方向还是反方向? //正方向为1，反方向为2");
        direction = scanner.nextInt() == 1;

        System.out.println("比赛开始！");

        while (true) {
            System.out.print("第" + (++totalNumberOfBureaus) + "局比赛开始！");
            while (!whoWinTotal()) {
                clearScreen();
                System.out.println("第" + (++numberOfBureaus) + "球开始！");
                showScore();
                System.out.println("请输入得分的选手：");
                int player = scanner.nextInt();

                while (true) {
                    if (player == 1) {
                        increaseScore(player_1);
                        break;
                    } else if (player == 2) {
                        increaseScore(player_2);
                        break;
                    } else {
                        System.out.println("输入错误，请重新输入");
                    }
                }
                showScoreNow();
                ballPower = exchangeBallRights(ballPower);
            }


            history.setScore(player_1.getSecond() > player_2.getSecond());
            player_1.setSecond(0);
            player_2.setSecond(0);
            numberOfBureaus = 0;
        }


    }

    private void showScoreNow() {
        System.out.println("当前比分：");
        System.out.println(player_1.getFirst() + " "
                + player_1.getSecond()
                + " : "
                + player_2.getSecond() + " "
                + player_2.getFirst());
    }

    private void outputGameToFile() {

    }

    private void inputGameFromFile() {

    }

    private void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean exchangeBallRights(boolean ballPower) {
        if (player_1.getSecond() >= 10 && player_2.getSecond() >= 10)
            return !ballPower;
        else
            return ((numberOfBureaus % 2 == 0) != ballPower);
    }

    private void increaseScore(Pair<String, Integer> player) {
        player.setSecond(player.getSecond() + 1);
    }

    private void showScore() {
        System.out.print(numberOfBureaus + ">>");
        String flagT = ballPower ? " ⚪ " : "  ";
        String flagF = ballPower ? "  " : " ⚪ ";

        if (direction) {
            System.out.println(flagT + player_1.getFirst() + " "
                    + player_1.getSecond()
                    + " : "
                    + player_2.getSecond() + " "
                    + player_2.getFirst() + flagF);
        } else {
            System.out.println(flagF + player_1.getFirst() + " "
                    + player_1.getSecond()
                    + " : "
                    + player_2.getSecond() + " "
                    + player_2.getFirst() + flagT);
        }
    }

    private boolean whoWinTotal() {
        if (player_1.getSecond() == 11 && player_2.getSecond() < 10) {
            System.out.println(player_1.getFirst() + "获得胜利！");
            return true;
        } else if (player_2.getSecond() == 11 && player_1.getSecond() < 10) {
            System.out.println(player_2.getFirst() + "获得胜利！");
            return true;
        } else if (player_1.getSecond() >= 10 && player_2.getSecond() >= 10) {
            if (player_1.getSecond() - player_2.getSecond() == 2) {
                System.out.println(player_1.getFirst() + "获得胜利！");
                return true;
            } else if (player_2.getSecond() - player_1.getSecond() == 2) {
                System.out.println(player_2.getFirst() + "获得胜利！");
                return true;
            }
        }
        return false;
    }

}

