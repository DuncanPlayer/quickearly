package net.messi.early.controller;

import net.messi.early.mapper.EarlyshopQrcodeMapper;
import net.messi.early.mapper.EarlyshopReservationGoodsMapper;
import net.messi.early.mapper.EarlyshopReservationMapper;
import net.messi.early.pojo.EarlyshopQrcode;
import net.messi.early.pojo.EarlyshopQrcodeExample;
import net.messi.early.pojo.EarlyshopReservationExample;
import net.messi.early.pojo.EarlyshopReservationGoodsExample;
import net.messi.early.utils.JSONResult;
import net.messi.early.utils.NumberUtils;
import net.messi.early.utils.qrCode.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("qrCode")
public class QrcodeController {

    @Autowired
    private EarlyshopQrcodeMapper qrcodeMapper;

    @Autowired
    private EarlyshopReservationMapper reservationMapper;

    @Autowired
    private EarlyshopReservationGoodsMapper reservationGoodsMapper;

    @ResponseBody
    @RequestMapping("/enCode")
    public JSONResult enCode(Integer userId, Integer reservationId) throws Exception {
        EarlyshopQrcode qrcode = new EarlyshopQrcode();

        EarlyshopQrcodeExample qrcodeExample = new EarlyshopQrcodeExample();
        EarlyshopQrcodeExample.Criteria criteria = qrcodeExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andOrderIdEqualTo(reservationId);
        List<EarlyshopQrcode> qrcodeList = qrcodeMapper.selectByExample(qrcodeExample);
        //返回路径
        String imageSrc = null;
        if (qrcodeList.size() <= 0 || null == qrcodeList) {
            //生成二维码，保存到本地。并返回相对路径
            // 放在二维码中的内容  ----用户取单凭证编码
            String singleProof = NumberUtils.singleProof();
            // 嵌入二维码的图片路径
            String imgPath = "";
            //以时间戳作为图片得名称
            String imageName = System.currentTimeMillis() + ".jpg";
            // 生成的二维码的路径及名称
            String destPath = "G:/weixinPlay/userImages/qrCode/face/" + imageName;
            //保存相对路径---返回给小程序端
            imageSrc = "/qrCode/face/" + imageName;
            //生成二维码
            QRCodeUtil.encode(singleProof, imgPath, destPath, true);

            qrcode.setUserId(userId);
            qrcode.setOrderId(reservationId);
            qrcode.setQrcodeSrc(imageSrc);
            qrcode.setQrcontent(singleProof);
            qrcode.setIsused("0");

            qrcodeMapper.insert(qrcode);
        } else {
            //数据库已经有该二维码
            EarlyshopQrcode qrcode1 = qrcodeList.get(0);
            imageSrc = qrcode1.getQrcodeSrc();
        }

        return JSONResult.ok(imageSrc);
    }

    @ResponseBody
    @RequestMapping("/setTakeOrder")
    public JSONResult setTakeOrder(Integer userId, Integer reservationId) {
        EarlyshopQrcodeExample qrcodeExample = new EarlyshopQrcodeExample();
        EarlyshopQrcodeExample.Criteria criteria = qrcodeExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andOrderIdEqualTo(reservationId);
        List<EarlyshopQrcode> qrcodeList = qrcodeMapper.selectByExample(qrcodeExample);
        EarlyshopQrcode qrcode = qrcodeList.get(0);
        qrcode.setModifyTime(System.currentTimeMillis() + "");
        qrcode.setIsdefault("1");
        qrcodeMapper.updateByPrimaryKey(qrcode);
        return JSONResult.ok();
    }

    @GetMapping("/validateCode")
    public void validateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String resultCode = request.getParameter("resultCode");
        String mark = "0";
        EarlyshopQrcodeExample qrcodeExample = new EarlyshopQrcodeExample();
        EarlyshopQrcodeExample.Criteria criteria = qrcodeExample.createCriteria();
        criteria.andQrcontentEqualTo(resultCode);
        List<EarlyshopQrcode> qrcodeList = qrcodeMapper.selectByExample(qrcodeExample);
        if (qrcodeList.size() > 0 && qrcodeList != null) {
            EarlyshopQrcode qrcode = qrcodeList.get(0);
            qrcode.setIsused("1");
            qrcodeMapper.updateByPrimaryKey(qrcode);
            mark = "1";
        }
        response.getWriter().write(mark);
    }

    @ResponseBody
    @RequestMapping("/selectStatus")
    public JSONResult selectStatus(Integer userId, Integer reservationId) {
        EarlyshopQrcodeExample qrcodeExample = new EarlyshopQrcodeExample();
        EarlyshopQrcodeExample.Criteria criteria = qrcodeExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andOrderIdEqualTo(reservationId);
        EarlyshopQrcode qrcode = qrcodeMapper.selectByExample(qrcodeExample).get(0);
        String mark = "false";
        if (qrcode != null && qrcode.getIsused().equals("1")) {
            EarlyshopReservationExample reservationExample = new EarlyshopReservationExample();
            EarlyshopReservationExample.Criteria criteria1 = reservationExample.createCriteria();
            criteria1.andIdEqualTo(reservationId);
            reservationMapper.deleteByExample(reservationExample);

            EarlyshopReservationGoodsExample goodsExample = new EarlyshopReservationGoodsExample();
            EarlyshopReservationGoodsExample.Criteria goodsCriteria = goodsExample.createCriteria();
            goodsCriteria.andReservationIdEqualTo(reservationId);
            reservationGoodsMapper.deleteByExample(goodsExample);
            mark = "true";
        }
        return JSONResult.ok(mark);
    }
}
