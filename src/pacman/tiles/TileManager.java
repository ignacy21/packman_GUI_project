package pacman.tiles;

import java.awt.*;
import java.util.List;

import static pacman.mainPanel.PacmanPanel.TILE_SIZE;

public class TileManager {

    public void paintTiles(Graphics2D graphics2D, List<List<Tile>> board) {

        for (int i = 0, y = 0; i < board.size(); i++, y += TILE_SIZE) {
            List<Tile> tileRow = board.get(i);
            for (int j = 0, x = 0; j < tileRow.size(); j++, x += TILE_SIZE) {
                Tile tile = tileRow.get(j);
                if (!"void".equals(tile.getName())) {
                    graphics2D.drawImage(tile.getImage(), x, y, TILE_SIZE, TILE_SIZE, null);
                }
            }
        }


    }
}
