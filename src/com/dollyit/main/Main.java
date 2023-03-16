package com.dollyit.main;

import com.dollyit.data.Map;
import java.util.Scanner;

public class Main {
    private static final Map map = Map.randomMap(8, 10);

    public static void main(String[] args) {
        int row, col, isObstacle;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            map.display();

            System.out.print("Enter '1' for obstacle, '0' for block: ");
            isObstacle = scanner.nextInt();

            System.out.print("Enter column: ");
            col = scanner.nextInt();

            System.out.print("Enter row: ");
            row = scanner.nextInt();

            System.out.println("Setting: "+row+" - "+col);
            if (isObstacle == 1)
                map.changeCell(col, row);
            else
                map.insertAtCoords(col, row);
        }
    }
}
