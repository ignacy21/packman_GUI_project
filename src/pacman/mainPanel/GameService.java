package pacman.mainPanel;

import pacman.mainPanel.gameData.GameData;
import pacman.mainPanel.gameData.GameDataBuilder;
import pacman.tiles.BoardService;
import pacman.tiles.Tile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GameService {

    private final BoardService boardService = new BoardService();


    public GameData runGameBasedOnBoard(String boardPath) {
        List<List<Tile>> board = createBoard(boardPath);
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = board.getFirst().size();
        int height = board.size();
        int tileSize = calculateTileSize(width, height);
        int pacmanSpeed = 3;
        int ghostSpeed = 3;

        int[] pacmanRespawn;
        int[] ghostRespawn;
        int rowThatSwitchSides;

        GameDataBuilder gameDataBuilder = new GameDataBuilder()
                .withBoard(board)
                .withWidth(screenWidth)
                .withHeight(screenHeight)
                .withWidthInTiles(width)
                .withHeightInTiles(height)
                .withTileSize(tileSize)
                .withPacmanSpeed(pacmanSpeed)
                .withGhostSpeed(ghostSpeed);

        switch (boardPath) {
            case "board1.txt" -> {
                rowThatSwitchSides = 10;
                pacmanRespawn = new int[]{tileSize * 12, tileSize * 11};
                ghostRespawn = new int[]{tileSize * 30, tileSize * 11};
            }
            case "board2.txt" -> {
                rowThatSwitchSides = 14;
                pacmanRespawn = new int[]{tileSize * 11, tileSize * 17};
                ghostRespawn = new int[]{tileSize * 14, tileSize * 16};
            }
            case "board3.txt" -> {
                rowThatSwitchSides = 12;
                pacmanRespawn = new int[]{tileSize * 9, tileSize * 9};
                ghostRespawn = new int[]{tileSize * 40, tileSize * 7};
            }
            case "board4.txt" -> {
                rowThatSwitchSides = 15;
                pacmanRespawn = new int[]{tileSize * 12, tileSize * 14};
                ghostRespawn = new int[]{tileSize * 16, tileSize * 42};
            }
            default -> throw new RuntimeException("There is no such file as: " + boardPath);
        }

        gameDataBuilder
                .withRowThatSwitchSize(rowThatSwitchSides)
                .withPacmanRespawnPoint(pacmanRespawn)
                .withGhostRespawnPoint(ghostRespawn);

        return gameDataBuilder.build();
    }

    private int calculateTileSize(int widthInTiles, int heightInTiles) {
        int height = Toolkit.getDefaultToolkit().getScreenSize().height - 80;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int tileSize;
        if ((heightInTiles + 2) > (widthInTiles - 4)) {
            tileSize = ((height) / (heightInTiles + 2));
        } else {
            tileSize = (width / (widthInTiles - 4));
        }
        return tileSize;
    }

    public List<List<Tile>> createBoard(String filePath) {
        List<List<Tile>> boardFromFile;
        try {
            boardFromFile = boardService.createBoardFromFile(String.format("src/pacman/tiles/boards/%s", filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return boardFromFile;
    }
}