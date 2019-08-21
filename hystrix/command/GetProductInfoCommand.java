package net.messi.early.hystrix.command;

import com.netflix.hystrix.*;
import net.messi.early.dto.GoodsDetailDTO;
import net.messi.early.service.GoodsService;

public class GetProductInfoCommand extends HystrixCommand<GoodsDetailDTO> {

    private Integer productId;
    private GoodsService goodsService;


    public GetProductInfoCommand(Integer productId,GoodsService goodsService){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetProductInfoCommand"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(10)  //线程池大小
                        .withMaximumSize(30) //高峰期可以扩容到30个线程
                        .withAllowMaximumSizeToDivergeFromCoreSize(true)
                        .withKeepAliveTimeMinutes(1) //高峰期过了一分钟，释放掉线程
                        .withMaxQueueSize(50)  //缓存队列大小
                        .withQueueSizeRejectionThreshold(100))  //好像是那个fallback大小
                );
        //默认线程池是10个
        this.productId = productId;
        this.goodsService = goodsService;
    }

    @Override
    protected GoodsDetailDTO run() throws Exception {
        // 需要从数据源重新拉去数据，重建缓存
        GoodsDetailDTO goodsDetailDTO;
        goodsDetailDTO = goodsService.goodsDetail(productId.intValue());
        System.out.println("=================从数据库中获取信息，商品信息=" + goodsDetailDTO);
        return goodsDetailDTO;
    }
}
