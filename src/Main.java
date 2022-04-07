import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class Main extends JFrame {

    public Main() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Domeq");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Main ex = new Main();
                ex.setVisible(true);
            }
        });
    }
}

class Surface extends JPanel {
//punkty do trójkątów
    private final int[][] pkt = {{20,260}, {470,260}, {245,80}};
    private final int[][] mtn = {{700, 20}, {500,300}, {800,300}};
    private final int[][] snowtop = {{700, 20}, {655,80}, {725,80}};

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Color okna = new Color(139, 228, 235);

        //niebo
        g2d.setPaint(okna);
        g2d.fillRect(0,0,800,600);

        //góra
        g2d.setPaint(new Color(127, 88, 20));
        GenPath(g2d,mtn);

        //ośnieżony wierzchołek góry
        g2d.setPaint(Color.white);
        GenPath(g2d, snowtop);

        //drzewa
        g2d.setPaint(new Color(0,70,0));
        int[][] drzewo1 = {{30,100}, {0,246}, {60, 246}};
        GenPath(g2d, drzewo1);

        int[][] drzewo2 = {{15,96}, {-15,246}, {30, 246}};
        GenPath(g2d, drzewo2);

        int[][] drzewo3 = {{45,110}, {15,246}, {60, 246}};
        GenPath(g2d, drzewo3);

        int[][] drzewo4 = {{60,100}, {30,246}, {90, 246}};
        GenPath(g2d, drzewo4);

        int[][] drzewo5 = {{90,80}, {60,246}, {120, 246}};
        GenPath(g2d, drzewo5);

        int[][] drzewo6 = {{120,69}, {90,246}, {150, 246}};
        GenPath(g2d, drzewo6);

        //trawa
        g2d.setPaint(new Color(48,152,41));
        g2d.fillRect(0,246,800,554);

        //słońce
        g2d.setPaint(Color.yellow);
        g2d.fillOval(480,15, 90,90);

        //dom
        g2d.setPaint(new Color(255, 154, 0));
        g2d.fillRect(90, 260, 300, 300);

        //okna
        g2d.setPaint(okna);
        g2d.fillRect(120,300,80,60);
        g2d.fillRect(280,300,80,60);
        g2d.fillRect(280,450,80,60);
        //ramki do okien
        g2d.setPaint(new Color(171, 171, 171));
        BasicStroke bs = new BasicStroke(6,BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs);
        g2d.drawRect(120,300,80,60);
        g2d.drawRect(280,300,80,60);
        g2d.drawRect(280,450,80,60);

        //komin
        g2d.fillRect(70,120,50,100);

        //drzwi
        g2d.setPaint(new Color(127, 88, 20));
        g2d.fillRect(140,400,80,160);

        //klamka
        g2d.setPaint(new Color(229,194,22));
        g2d.fillRect(200,500,8,3);

        //koła
        g2d.setPaint(new Color(0,0,0));
        g2d.fillOval(500,480,60,60);
        g2d.fillOval(780,480,60,60);

        //felgi
        g2d.setPaint(new Color(201,200,198));
        g2d.fillOval(510,490,40,40);

        //auto
        g2d.setPaint(new Color(72,119,230));
        g2d.fillRect(460,450,400,60);
        g2d.fillRoundRect(550,380,200,80,25,25);

        //okna auta
        g2d.setPaint(okna);
        g2d.fillRect(570,400,70,50);
        g2d.fillRect(660,400,70,50);

        //dach
        g2d.setPaint(new Color(218, 33, 33));
        GenPath(g2d,pkt);
        g2d.dispose();

    }

    //metoda rysująca trójkąty
    public void GenPath(Graphics2D g, int[][] coords){
        GeneralPath myPath = new GeneralPath();
        myPath.moveTo(coords[0][0], coords[0][1]);
        for (int i = 0; i < coords.length; i++) {
            myPath.lineTo(coords[i][0], coords[i][1]);
        }
        myPath.closePath();
        g.fill(myPath);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}