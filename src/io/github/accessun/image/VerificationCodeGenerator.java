package io.github.accessun.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerificationCodeGenerator {
    private int width = 90;
    private int height = 38;
    private int codeCount = 4;
    private int x = width / (codeCount + 1);
    private int fontHeight = height - 2;
    private int codeY = height - 6;
    // 0 ~ 9 在该数组中出现两次，以提高数字出现的概率
    private final char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public void genCode(String outputPath) {
        genCode(outputPath, true);
    }
    
    public void genCode(String outputPath, boolean printTextToConsole) {
        // 定义图像buffer  
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();

        // 创建一个随机数生成器类  
        Random random = new Random();

        // 将图像填充为白色  
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 创建字体，字体的大小应该根据图片的高度来定。  
        Font font = new Font("Consolas", Font.PLAIN | Font.BOLD, fontHeight);
        // 设置字体。  
        g.setFont(font);

        // 画边框。  
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width - 1, height - 1);

        // 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。  
        Color[] lineColorsCollection = new Color[] { Color.GRAY, Color.MAGENTA, Color.PINK, Color.ORANGE, Color.CYAN };
        for (int i = 0; i < 160; i++) {
            int bound = lineColorsCollection.length;
            g.setColor(lineColorsCollection[random.nextInt(bound)]);
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。  
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;

        // 随机产生codeCount数字的验证码。  
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字。  
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。  
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);

            // 用随机产生的颜色将验证码绘制到图像中。  
            g.setColor(new Color(red, green, blue));
            g.drawString(strRand, (i + 1) * x - 8, codeY);

            // 将产生的四个随机数组合在一起。  
            randomCode.append(strRand);
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(outputPath));
            ImageIO.write(buffImg, "jpeg", fos);
        } catch (Exception e) {
            throw new RuntimeException("Fail to write to image!", e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        if (printTextToConsole)
            System.out.println(randomCode.toString().toUpperCase());
    }
}
