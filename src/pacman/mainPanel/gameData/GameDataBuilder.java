package pacman.mainPanel.gameData;

import pacman.tiles.Tile;

import java.util.List;

public class GameDataBuilder {

    private List<List<Tile>> board;
    private int width;
    private int height;
    private int widthInTiles;
    private int heightInTiles;
    private int TILE_SIZE;
    private int pacmanSpeed;
    private int ghostSpeed;
    private int rowThatSwitchSize;
    private int[] ghostRespawnPoint;
    private int[] pacmanRespawnPoint;

    public GameDataBuilder() {}

    public GameDataBuilder withBoard(List<List<Tile>> board) {
        this.board = board;
        return this;
    }

    public GameDataBuilder withWidth(int width) {
        this.width = width;
        return this;
    }

    public GameDataBuilder withHeight(int height) {
        this.height = height;
        return this;
    }

    public GameDataBuilder withWidthInTiles(int widthInTiles) {
        this.widthInTiles = widthInTiles;
        return this;
    }

    public GameDataBuilder withHeightInTiles(int heightInTiles) {
        this.heightInTiles = heightInTiles;
        return this;
    }

    public GameDataBuilder withTileSize(int tileSize) {
        this.TILE_SIZE = tileSize;
        return this;
    }

    public GameDataBuilder withPacmanSpeed(int pacmanSpeed) {
        this.pacmanSpeed = pacmanSpeed;
        return this;
    }

    public GameDataBuilder withGhostSpeed(int ghostSpeed) {
        this.ghostSpeed = ghostSpeed;
        return this;
    }

    public GameDataBuilder withRowThatSwitchSize(int rowThatSwitchSize) {
        this.rowThatSwitchSize = rowThatSwitchSize;
        return this;
    }

    public GameDataBuilder withGhostRespawnPoint(int[] ghostRespawnPoint) {
        this.ghostRespawnPoint = ghostRespawnPoint;
        return this;
    }

    public GameDataBuilder withPacmanRespawnPoint(int[] pacmanRespawnPoint) {
        this.pacmanRespawnPoint = pacmanRespawnPoint;
        return this;
    }

    public GameData build() {
        return new GameData(board, width, height, widthInTiles, heightInTiles, TILE_SIZE, pacmanSpeed, ghostSpeed, rowThatSwitchSize, ghostRespawnPoint, pacmanRespawnPoint);
    }
}