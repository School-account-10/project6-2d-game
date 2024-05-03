import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game2 extends JFrame implements KeyListener {
    private static int CURRENT_SPEED = 60;
    private static final int WIDTH = 40;
    private static final int HEIGHT = 20;
    private static final int PIPE_WIDTH = 3;
    private static final int PIPE_GAP = 5;
    private static final char BIRD_CHAR = '>';
    private static final char PIPE_CHAR = '|';
    private static final char EMPTY_CHAR = ' ';

    private static int birdPos = HEIGHT / 2;
    private static int pipePos = WIDTH;
    private static int gapPos = (int) (Math.random() * (HEIGHT - PIPE_GAP - 1)) + 1;
    private static int score = 0;

    private JLabel[][] grid;

    public Game2() {
        setTitle("Flappy Bird");
        setSize(WIDTH * 10, HEIGHT * 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        grid = new JLabel[HEIGHT][WIDTH];
        setLayout(null);

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                grid[y][x] = new JLabel();
                grid[y][x].setBounds(x * 10, y * 20, 10, 20);
                add(grid[y][x]);
            }
        }

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setVisible(true);

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(current_speed); // Adjust the speed of the game
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                move();
                if (pipePos == birdPos) {
                    score++;
                    current_speed--;
                }
                checkCollision();
                updateGrid();
            }
        }).start();
    }

    private void updateGrid() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (y == birdPos && x == birdPos) {
                    grid[y][x].setText(String.valueOf(BIRD_CHAR));
                } else if ((x == pipePos || x == pipePos + 1 || x == pipePos + 2)
                        && (y < gapPos || y >= gapPos + PIPE_GAP)) {
                    grid[y][x].setText(String.valueOf(PIPE_CHAR));
                } else {
                    grid[y][x].setText(String.valueOf(EMPTY_CHAR));
                }
            }
        }
        setTitle("Flappy Bird - Score: " + score);
    }

    private void move() {
        pipePos--;
        if (pipePos < 0) {
            pipePos = WIDTH;
            gapPos = (int) (Math.random() * (HEIGHT - PIPE_GAP - 1)) + 1;
        }
    }

    private void checkCollision() {
        if ((birdPos == pipePos || birdPos == pipePos + 1 || birdPos == pipePos + 2)
                && (birdPos < gapPos || birdPos >= gapPos + PIPE_GAP)) {
            System.out.println("Game Over!");
            System.out.println("Your score: " + score);
            System.out.println("your speed: "+ current_speed);
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            flap();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            birdPos += 2; // Move bird down
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    private void flap() {
        if (birdPos > 0) {
            birdPos -= 2; // Flap upwards
        }
    }
    public static void main(String[] args) {
        new Game2();

    }
}
