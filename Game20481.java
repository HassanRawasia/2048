/*
 * ICS4U.2019
 * 2048
 */
package edu.hdsb.gwss.hassan.ics4u.u2;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

/**
 * @author 1rawasiahas
 * @version 2019.S2
 */
public class Game20481 extends javax.swing.JFrame {

    // COLOURS
    private static final Color[] COLOUR_BG = {
        new Color(205, 193, 180), // 0
        new Color(238, 228, 218), // 2
        new Color(237, 224, 200), // 4
        new Color(242, 177, 121), // 8
        new Color(245, 149, 99), // 16
        new Color(245, 149, 99), // 32
        new Color(246, 94, 59), // 64
        new Color(246, 94, 59), // 128
        new Color(237, 204, 97) // 256
    };

    private static final Color[] COLOUR_FONT = {
        new Color(205, 193, 180), // 0
        new Color(119, 110, 101), // 2
        new Color(119, 110, 101), // 4
        new Color(249, 246, 242), // 8
        new Color(249, 246, 242), // 16
        new Color(249, 246, 242), // 32
        new Color(249, 246, 242), // 64
        new Color(249, 246, 242), // 128
        new Color(249, 246, 242) // 256
    };

    private JLabel[][] jLabels;
    private int[][] data;
    int score = 0;
    boolean moved;

    /**
     * Creates new form Game2048
     */
    public Game20481() {
        initComponents();

        // SQUARE VALUES
        this.data = new int[4][4];

        // SQUARE LABELS
        this.jLabels = new JLabel[4][4];

        // ROW 0
        jLabels[0][0] = jLabel00;
        jLabels[0][1] = jLabel01;
        jLabels[0][2] = jLabel02;
        jLabels[0][3] = jLabel03;

        // ROW 1
        jLabels[1][0] = jLabel10;
        jLabels[1][1] = jLabel11;
        jLabels[1][2] = jLabel12;
        jLabels[1][3] = jLabel13;

        // ROW 2
        jLabels[2][0] = jLabel20;
        jLabels[2][1] = jLabel21;
        jLabels[2][2] = jLabel22;
        jLabels[2][3] = jLabel23;

        // ROW 3
        jLabels[3][0] = jLabel30;
        jLabels[3][1] = jLabel31;
        jLabels[3][2] = jLabel32;
        jLabels[3][3] = jLabel33;

        // PLACE, two, 2's
        //this.placeRandomTwo();
        //this.placeRandomTwo();
        // TEST DATA
        this.data[0][0] = 2;
        this.data[1][0] = 0;
        this.data[2][0] = 2;
        this.data[3][0] = 2;

        this.data[0][1] = 0;
        this.data[1][1] = 2;
        this.data[2][1] = 2;
        this.data[3][1] = 2;

        this.data[0][2] = 2;
        this.data[1][2] = 0;
        this.data[2][2] = 0;
        this.data[3][2] = 2;

        this.data[0][3] = 0;
        this.data[1][3] = 2;
        this.data[2][3] = 2;
        this.data[3][3] = 0;

        this.updateGameboard();

    }

    public boolean shiftLeft() {
        for (int i = 0; i < data.length; i++) {
            for (int pass = 0; pass < data.length - 1; pass++) {
                for (int j = 1; j < data[i].length; j++) {
                    if (data[i][j - 1] == 0 && data[i][j] != 0) {
                        data[i][j - 1] = data[i][j];
                        data[i][j] = 0;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void mergeLeft() {
        for (int i = 0; i < data.length; i++) {
            for (int pass = 0; pass < data.length - 1; pass++) {
                for (int j = 1; j < data[i].length; j++) {
                    if (data[i][j - 1] == data[i][j]) {
                        data[i][j - 1] = data[i][j - 1] * 2;
                        data[i][j] = 0;
                        score += data[i][j - 1];
                    }
                }
            }
        }
    }

    public boolean shiftUp() {
        for (int i = 1; i < data.length; i++) {
            for (int pass = 0; pass < data.length - 1; pass++) {
                for (int j = 0; j < data[i].length; j++) {
                    if (data[i - 1][j] == 0 && data[i][j] != 0) {
                        data[i - 1][j] = data[i][j];
                        data[i][j] = 0;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void mergeUp() {
        for (int i = 1; i < data.length; i++) {
            for (int pass = 0; pass < data.length - 1; pass++) {
                for (int j = 0; j < data[i].length; j++) {
                    if (data[i - 1][j] == data[i][j]) {
                        data[i - 1][j] = data[i - 1][j] * 2;
                        data[i][j] = 0;
                        score += data[i - 1][j];
                    }
                }
            }
        }
    }

    public boolean shiftRight() {
        for (int i = 0; i < data.length; i++) {
            for (int pass = 0; pass < data.length - 1; pass++) {
                for (int j = 2; j >= 0; j--) {
                    if (data[i][j + 1] == 0 && data[i][j] != 0) {
                        data[i][j + 1] = data[i][j];
                        data[i][j] = 0;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void mergeRight() {
        for (int i = 0; i < data.length; i++) {
            for (int pass = 0; pass < data.length - 1; pass++) {
                for (int j = 2; j >= 0; j--) {
                    if (data[i][j + 1] == data[i][j]) {
                        data[i][j + 1] = data[i][j + 1] * 2;
                        data[i][j] = 0;
                        score += data[i][j + 1];
                    }
                }
            }
        }
    }
    
    public boolean shiftDown() {
        for (int i = 2; i >= 0; i--) {
            for (int pass = 0; pass < data.length - 1; pass++) {
                for (int j = 0; j < data[i].length; j++) {
                    if (data[i + 1][j] == 0 && data[i][j] != 0) {
                        data[i + 1][j] = data[i][j];
                        data[i][j] = 0;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void mergeDown() {
        for (int i = 2; i >= 0; i--) {
            for (int pass = 0; pass < data.length - 1; pass++) {
                for (int j = 0; j < data[i].length; j++) {
                    if (data[i + 1][j] == data[i][j]) {
                        data[i + 1][j] = data[i + 1][j] * 2;
                        data[i][j] = 0;
                        score += data[i + 1][j];
                    }
                }
            }
        }
    }
 
    public void placeRandomTwo() {
        boolean placed = false;
        int r, c;
        while (!placed) {
            r = (int) (Math.random() * data.length);
            c = (int) (Math.random() * data[0].length);
            if (data[r][c] == 0) {
                data[r][c] = 2;
                placed = true;
            }
        }

    }

    public void updateGameboard() {

        int colourIndex;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {

                // COLOUR BASED ON VALUE
                if (data[row][col] == 0) {
                    colourIndex = 0;
                } else {
                    colourIndex = (int) (Math.log(data[row][col]) / Math.log(2));
                }
                this.jLabels[row][col].setBackground(COLOUR_BG[colourIndex]);
                this.jLabels[row][col].setForeground(COLOUR_FONT[colourIndex]);
                this.jLabels[row][col].setText("" + this.data[row][col]);

            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBottom = new javax.swing.JPanel();
        jLabel00 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel01 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel02 = new javax.swing.JLabel();
        jLabel03 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanelTop = new javax.swing.JPanel();
        jLabelScoreLabel = new javax.swing.JLabel();
        jLabelDisplayScore = new javax.swing.JLabel();
        jLabelBestLabel = new javax.swing.JLabel();
        jLabelBestScoreDisplay = new javax.swing.JLabel();
        jLabelGameName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelBottom.setBackground(new java.awt.Color(187, 173, 160));

        jLabel00.setBackground(new java.awt.Color(205, 193, 180));
        jLabel00.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel00.setText("00");
        jLabel00.setOpaque(true);

        jLabel10.setBackground(new java.awt.Color(205, 193, 180));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("00");
        jLabel10.setOpaque(true);

        jLabel20.setBackground(new java.awt.Color(205, 193, 180));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("00");
        jLabel20.setOpaque(true);

        jLabel30.setBackground(new java.awt.Color(205, 193, 180));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("00");
        jLabel30.setOpaque(true);

        jLabel01.setBackground(new java.awt.Color(205, 193, 180));
        jLabel01.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel01.setText("00");
        jLabel01.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(205, 193, 180));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("00");
        jLabel11.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(205, 193, 180));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("00");
        jLabel21.setOpaque(true);

        jLabel31.setBackground(new java.awt.Color(205, 193, 180));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("00");
        jLabel31.setOpaque(true);

        jLabel02.setBackground(new java.awt.Color(205, 193, 180));
        jLabel02.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel02.setText("00");
        jLabel02.setOpaque(true);

        jLabel03.setBackground(new java.awt.Color(205, 193, 180));
        jLabel03.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel03.setText("00");
        jLabel03.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(205, 193, 180));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("00");
        jLabel12.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(205, 193, 180));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("00");
        jLabel13.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(205, 193, 180));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("00");
        jLabel22.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(205, 193, 180));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("00");
        jLabel23.setOpaque(true);

        jLabel32.setBackground(new java.awt.Color(205, 193, 180));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("00");
        jLabel32.setOpaque(true);

        jLabel33.setBackground(new java.awt.Color(205, 193, 180));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("00");
        jLabel33.setOpaque(true);

        javax.swing.GroupLayout jPanelBottomLayout = new javax.swing.GroupLayout(jPanelBottom);
        jPanelBottom.setLayout(jPanelBottomLayout);
        jPanelBottomLayout.setHorizontalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel00, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jPanelBottomLayout.setVerticalGroup(
            jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBottomLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBottomLayout.createSequentialGroup()
                        .addComponent(jLabel03, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBottomLayout.createSequentialGroup()
                        .addComponent(jLabel02, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBottomLayout.createSequentialGroup()
                        .addComponent(jLabel01, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBottomLayout.createSequentialGroup()
                        .addComponent(jLabel00, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jPanelTop.setBackground(new java.awt.Color(210, 210, 210));

        jLabelScoreLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelScoreLabel.setForeground(new java.awt.Color(242, 235, 138));
        jLabelScoreLabel.setText("SCORE");

        jLabelDisplayScore.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDisplayScore.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDisplayScore.setText("####");

        jLabelBestLabel.setBackground(new java.awt.Color(225, 225, 225));
        jLabelBestLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelBestLabel.setForeground(new java.awt.Color(242, 235, 138));
        jLabelBestLabel.setText("BEST");

        jLabelBestScoreDisplay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelBestScoreDisplay.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBestScoreDisplay.setText("####");

        jLabelGameName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelGameName.setText("2048");

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelGameName, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDisplayScore)
                    .addComponent(jLabelScoreLabel))
                .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTopLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabelBestLabel))
                    .addGroup(jPanelTopLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelBestScoreDisplay)))
                .addContainerGap())
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelScoreLabel)
                    .addComponent(jLabelBestLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDisplayScore)
                    .addComponent(jLabelBestScoreDisplay))
                .addContainerGap(44, Short.MAX_VALUE))
            .addComponent(jLabelGameName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        System.out.print("KEY PRESSED: ");
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("UP");
                shiftUp();
                mergeUp();
                shiftUp();
                moved = shiftUp();
                if (moved == true) {
                    placeRandomTwo();
                }
                updateGameboard();
                jLabelDisplayScore.setText("" + score);
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("DOWN");
                shiftDown();
                mergeDown();
                shiftDown();
                moved = shiftDown();
                if (moved == true) {
                    placeRandomTwo();
                }
                updateGameboard();
                jLabelDisplayScore.setText("" + score);
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("LEFT");
                shiftLeft();
                mergeLeft();
                shiftLeft();
                moved = shiftLeft();
                if (moved == true) {
                    placeRandomTwo();
                }
                updateGameboard();
                jLabelDisplayScore.setText("" + score);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT");
                shiftRight();
                mergeRight();
                shiftRight();
                moved = shiftRight();
                if (moved == true) {
                    placeRandomTwo();
                }
                updateGameboard();
                jLabelDisplayScore.setText("" + score);
                break;
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game20481.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game20481.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game20481.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game20481.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game20481().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel00;
    private javax.swing.JLabel jLabel01;
    private javax.swing.JLabel jLabel02;
    private javax.swing.JLabel jLabel03;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabelBestLabel;
    private javax.swing.JLabel jLabelBestScoreDisplay;
    private javax.swing.JLabel jLabelDisplayScore;
    private javax.swing.JLabel jLabelGameName;
    private javax.swing.JLabel jLabelScoreLabel;
    private javax.swing.JPanel jPanelBottom;
    private javax.swing.JPanel jPanelTop;
    // End of variables declaration//GEN-END:variables
}
