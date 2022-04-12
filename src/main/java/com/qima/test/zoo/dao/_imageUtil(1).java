package com.qima.test.zoo.dao;



import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


class _imageUtil {
	private static final String FONT_COLOR = "#000000";
	private static final String FONT_TYPE = "微软雅黑";
	private static final int FONT_SIZE = 18;
	private static final String DRAW_NAME = "请吃牛杂可否";
	private static final int DRAW_LEFT = 100;
	private static final int DRAW_TOP = 180;
	/**
	 * 将一张图片写入另一张
	 * @param bigPath 大图片
	 * @param smallPath 小图片
	 * @param x 要下入图片与原图片的左边距（px）
	 * @param y 上边距（px）
	 * @param h 二维码高宽（px）
	 * @param outfile 输出文件
	 */
	public static final void overlapImage(String bigPath, String smallPath,int x,int y,int h,File outfile) {
		try {
			BufferedImage big = ImageIO.read(new File(bigPath));
			BufferedImage small = ImageIO.read(new File(smallPath));
			Graphics2D g = big.createGraphics();
			g.drawImage(small, x, y, h, h, null);
			g.dispose();
			ImageIO.write(big, "jpg", outfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 将多张图片(正方形)写入另一张
	 */
	public static final void overlapImage(BufferedImage big,final SmallImage[] smallImages,File outfile){
		try {
			for(SmallImage smallImage : smallImages){
				Graphics2D g = big.createGraphics();
				BufferedImage small = ImageIO.read(new File(smallImage.getSmallPath()));
				g.drawImage(small, smallImage.getX(), smallImage.getY(), smallImage.getH(), smallImage.getH(), null);
				g.dispose();
			}
			ImageIO.write(big, "jpg", outfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//http://www.cnblogs.com/dreammyle/p/4843365.html
		 //读入表情包
        //TODO ERROR
        //String path = request.getSession().getServletContext().getRealPath("/")+basePath+ "/" +fileName;
        String fileWepappPath = "F:\\1.png";
        //E:/h5/jfb_web/WebRoot/image/poster/default_poster_img_4_1.jpg
        File posterFile = new File(fileWepappPath);
//        if(!posterFile.exists()){
//        	posterFile = new File( SysConfigHelper.getParam("webapp_post_path") +"/"+"image/poster/default_poster_img.jpg");
//        }
        BufferedImage posterDemo = null;
		try {
			posterDemo = ImageIO.read(posterFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        //写入用户名字

        Graphics outg = posterDemo.createGraphics();

        //画海报模板到新的面板
        outg.drawImage(posterDemo, 0, 0, posterDemo.getWidth(), posterDemo.getHeight(), null);
        //画文字到新的面板
        outg.setColor(Color.decode(FONT_COLOR));
        outg.setFont(new Font(FONT_TYPE,Font.BOLD,FONT_SIZE)); //字体、字型、字号
        outg.drawString(DRAW_NAME, DRAW_LEFT,DRAW_TOP); //画文字
        outg.dispose();
        
       /* // 生成二维码
        ZXingCode.getQRCode(url,owner_id,user_id);

        // 二维码小图片
        SmallImage ermw = new SmallImage(SysConfigHelper.getParam("scene_filepath") +"/ewm/"+ owner_id+"_"+ user_id + "_qrcode.png",
                poster.getPos_parameter1(), poster.getPos_parameter2(), poster.getPos_parameter3());

        String openid = user.getOpenid();
        String path = SysConfigHelper.getParam("scene_filepath") + "/poster/" + "default_head_img_" + owner_id + ".jpg";
        File defalutFile = new File(path);
        if(!defalutFile.exists()){
        	path = SysConfigHelper.getParam("scene_filepath") + "/poster/" + "default_head_img.jpg";
        }

        // 下载小图像
        if(user_id != 0){
            HttpHelper.downloadFile(user.getHeadimgurl() + "0", SysConfigHelper.getParam("scene_filepath") + "/head/" + openid + "_head.png");
            path = SysConfigHelper.getParam("scene_filepath") + "/head/" + openid + "_head.png";
        }

        // 头像小图片
        SmallImage head = new SmallImage(path, poster.getHead_parameter1(), poster.getHead_parameter2(), poster.getHead_parameter3());
*/
        // 最终输出的用户海报
        String saveFileName = "D://result.jpg";
        File outfile = new File(saveFileName);
        File p = new File(outfile.getParent());
        if(!p.exists()){
            p.mkdirs();
        }
        if(!outfile.exists()){
            try {
				outfile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
        
		 //多张图片合并
//        _imageUtil.overlapImage(posterDemo,new SmallImage[] { head, ermw }, outfile);
        _imageUtil.overlapImage(posterDemo,new SmallImage[] {}, outfile);
	}
}

