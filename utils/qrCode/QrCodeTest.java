package net.messi.early.utils.qrCode;

import net.messi.early.utils.NumberUtils;

public class QrCodeTest {

    public static void main(String[] args) throws Exception {
        // 存放在二维码中的内容
        String singleProof = NumberUtils.singleProof();
        // 嵌入二维码的图片路径  F:/qrCodeImage/dog.jpg
        String imgPath = "";
        // 生成的二维码的路径及名称
        String destPath = "G:/weixinPlay/userImages/qrCode/face/" + System.currentTimeMillis() + ".jpg";
        //生成二维码
        QRCodeUtil.encode(singleProof, imgPath, destPath, true);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        //打印出解析出的内容
        System.out.println(str);
    }
}
