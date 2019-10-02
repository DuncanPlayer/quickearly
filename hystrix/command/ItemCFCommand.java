package net.messi.early.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import net.messi.early.pojo.NideshopGoods;
import net.messi.early.service.GoodsService;
import net.messi.early.synergy.ItemCF;
import net.messi.early.utils.NumberUtils;

import java.util.List;

public class ItemCFCommand extends HystrixCommand<List<NideshopGoods>> {

    private Integer id;
    private Integer userId;
    private GoodsService goodsService;
    private static Integer DEFAULTRECOMMENDGID = 1199389;

    public ItemCFCommand(Integer id,Integer userId,GoodsService goodsService){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ItemCFCommandGroup"))
                // 配置以信号量隔离方式，最多允许10个tomcat线程进来
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(5 * 1000) //超时时间设置为5*1000
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)));
        this.id = id;
        this.userId = userId;
        this.goodsService = goodsService;
    }

    @Override
    protected List<NideshopGoods> run() throws Exception {
        List<NideshopGoods> goodsList = null;
        List<Integer> idList = null;
        NideshopGoods goods = goodsService.findByGoodsSn(id);
        //插入用户访问记录 userid goodsid  喜欢度量10-20
//        goodsService.insertItemCf(userId, Integer.parseInt(goods.getGoodsSn()), NumberUtils.randomTenToTwenty());
//        try {
//            idList = new ItemCF().itemCF(userId, Integer.parseInt(goods.getGoodsSn()), ItemCF.RECOMMEDSIZE);
//            if (idList.size() < 6) {
//                //默认推荐
//                goodsList = goodsService.findRelateGoodsById(new ItemCF().itemCF(userId, DEFAULTRECOMMENDGID, ItemCF.RECOMMEDSIZE));
//            } else {
//                goodsList = goodsService.findRelateGoodsById(idList);
//            }
//        } catch (Exception e) {
//            System.out.println("ItemCF");
//            e.printStackTrace();
//        }
        return goodsList;
    }

    @Override
    protected List<NideshopGoods> getFallback() {
        System.out.println("【ITEMCFCOMMAND降级了】");
        return null;
    }
}
