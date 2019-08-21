package net.messi.early.synergy;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemCF {

    public static MysqlDataSource dataSource = new MysqlDataSource();
    public static Integer RECOMMEDSIZE = 6;

    public ItemCF() {
        dataSource.setUrl("jdbc:mysql://localhost:3306/earlydetail?useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("earlydetail");
    }

    public static void main(String[] main) throws Exception {
        //new ItemCF().itemCF(1,1199389,RECOMMEDSIZE);
    }

    public static List<Integer> itemCF(Integer uid, Integer itemId, Integer howMany) throws Exception {
        JDBCDataModel dataModel = new MySQLJDBCDataModel(dataSource, "recommend", "uid", "gid", "val", "time");
        DataModel model = dataModel;
        //计算相似度，相似度算法有很多种，欧几里得、皮尔逊等等。
        ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
        //构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于物品的协同过滤推荐
        GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dataModel, itemSimilarity);
        //给用户ID等于5的用户推荐10个与105相似的商品
        List<RecommendedItem> recommendedItemList = recommender.recommendedBecause(uid, itemId, howMany);

        List<Integer> recommendList = new ArrayList<>();
        for (RecommendedItem recommendation : recommendedItemList) {
            recommendList.add(Integer.parseInt(recommendation.getItemID() + ""));
        }
        return recommendList;
    }
}
